package community.backend.domain.user.auth.service;

import community.backend.domain.user.auth.presentation.dto.request.CreateUserRequestDto;
import community.backend.domain.user.auth.presentation.dto.request.LoginRequestDto;
import community.backend.domain.user.auth.presentation.dto.response.TokenResponseDto;
import community.backend.domain.user.user.domain.User;
import community.backend.domain.user.user.domain.repository.UserRepository;
import community.backend.domain.user.user.exception.DuplicatedUserEmailException;
import community.backend.domain.user.user.exception.DuplicatedUserNameException;
import community.backend.domain.user.user.exception.PasswordMismatchException;
import community.backend.domain.user.user.exception.UserNotFoundException;
import community.backend.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(CreateUserRequestDto dto) {
        // 이메일 중복 확인
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw DuplicatedUserEmailException.EXCEPTION;
        }
        // 이름 중복 확인
        if (userRepository.findByName(dto.getName()).isPresent()) {
            throw DuplicatedUserNameException.EXCEPTION;
        }

        userRepository.save(dto.toEntity(passwordEncoder.encode(dto.getPassword())));
    }

    @Transactional
    public TokenResponseDto login(LoginRequestDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        // 비밀번호 일치 여부 확인
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.createAccessToken(user);
        String refreshToken = jwtTokenProvider.createRefreshToken(user);

        return TokenResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}

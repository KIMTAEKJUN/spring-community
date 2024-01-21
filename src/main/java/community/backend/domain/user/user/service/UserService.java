package community.backend.domain.user.user.service;

import community.backend.domain.user.user.domain.User;
import community.backend.domain.user.user.domain.repository.UserRepository;
import community.backend.domain.user.user.exception.DuplicatedUserNameException;
import community.backend.domain.user.user.exception.InternalServerException;
import community.backend.domain.user.user.exception.PasswordMismatchException;
import community.backend.domain.user.user.exception.UserNotFoundException;
import community.backend.domain.user.user.presentation.dto.request.DeleteUserRequestDto;
import community.backend.domain.user.user.presentation.dto.request.UpdateNameRequestDto;
import community.backend.domain.user.user.presentation.dto.request.UpdatePasswordRequestDto;
import community.backend.domain.user.user.presentation.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public UserResponseDto getUserInfo(Long id) {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);

            return UserResponseDto.of(user);
        } catch (Exception e) {
            throw InternalServerException.EXCEPTION;
        }
    }

    @Transactional
    public void updateUserName(UpdateNameRequestDto dto, Long id) {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);

            // 이름 중복 확인
            if (userRepository.findByName(dto.getName()).isPresent()) {
                throw DuplicatedUserNameException.EXCEPTION;
            }

            user.updateName(dto.getName());
            userRepository.save(user);
        } catch (Exception e) {
            throw InternalServerException.EXCEPTION;
        }
    }

    @Transactional
    public void updateUserPassword(UpdatePasswordRequestDto dto, Long id) {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);

            // 비밀번호 일치 여부 확인
            if (!passwordEncoder.matches(dto.getCurrentPassword(), user.getPassword())) {
                throw PasswordMismatchException.EXCEPTION;
            }

            user.updatePassword(passwordEncoder.encode(dto.getPassword()));
            userRepository.save(user);
        } catch (Exception e) {
            throw InternalServerException.EXCEPTION;
        }
    }

    @Transactional
    public void updateUserProfileImage(String profileImage, Long id) {
        try {
            // TODO: 나중에 S3로 변경
            User user = userRepository.findById(id)
                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);

            user.updateProfileImage(profileImage);
            userRepository.save(user);
        } catch (Exception e) {
            throw InternalServerException.EXCEPTION;
        }
    }

    @Transactional
    public void deleteUser(DeleteUserRequestDto dto, Long id) {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);

            // 비밀번호 일치 여부 확인
            if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
                throw PasswordMismatchException.EXCEPTION;
            }

            userRepository.delete(user);
        } catch (Exception e) {
            throw InternalServerException.EXCEPTION;
        }
    }
}

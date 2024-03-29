package community.backend.domain.user.auth.presentation;

import community.backend.domain.user.auth.presentation.dto.request.CreateUserRequestDto;
import community.backend.domain.user.auth.presentation.dto.request.LoginRequestDto;
import community.backend.domain.user.auth.presentation.dto.response.TokenResponseDto;
import community.backend.domain.user.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid CreateUserRequestDto dto) {
        authService.signUp(dto);
    }

    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody @Valid LoginRequestDto dto) {
        return authService.login(dto);
    }
}

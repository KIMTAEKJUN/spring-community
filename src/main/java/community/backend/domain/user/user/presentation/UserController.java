package community.backend.domain.user.user.presentation;

import community.backend.domain.user.user.presentation.dto.request.DeleteUserRequestDto;
import community.backend.domain.user.user.presentation.dto.request.UpdateNameRequestDto;
import community.backend.domain.user.user.presentation.dto.request.UpdatePasswordRequestDto;
import community.backend.domain.user.user.presentation.dto.response.UserResponseDto;
import community.backend.domain.user.user.service.UserService;
import community.backend.global.config.resolver.UserId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public UserResponseDto getUserInfo(@UserId Long id) {
        return userService.getUserInfo(id);
    }

    @PutMapping("/name")
    public void updateUserName(@RequestBody @Valid UpdateNameRequestDto dto, @UserId Long id) {
        userService.updateUserName(dto, id);
    }

    @PutMapping("/password")
    public void updateUserPassword(@RequestBody @Valid UpdatePasswordRequestDto dto, @UserId Long id) {
        userService.updateUserPassword(dto, id);
    }

    @PutMapping("/profile-img")
    public void updateUserProfileImg(@RequestParam String profileImage, @UserId Long id) {
        userService.updateUserProfileImage(profileImage, id);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody @Valid DeleteUserRequestDto dto, @UserId Long id) {
        userService.deleteUser(dto, id);
    }
}

package community.backend.domain.user.auth.service;

import community.backend.domain.user.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2UserService extends DefaultOAuth2UserService {
//    private final UserService userService;

//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
//        OAuth2User oAuth2User = super.loadUser(userRequest);
//
//
//    }
}

package paintstore.securiry;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        String errorMessage = null;
        if (exception instanceof UsernameNotFoundException) {
            errorMessage = "User name not found";
        } else if (exception instanceof DisabledException) {
            errorMessage = "Tài khoản bị khóa";
        } else {
            // Xử lý các trường hợp ngoại lệ khác nếu cần thiết
            errorMessage = "Tài khoản hoặc mật khẩu sai, hoặc tài khoản của bạn đã bị khóa";
        }

        String encodedErrorMessage = URLEncoder.encode(errorMessage, StandardCharsets.UTF_8.toString());
        response.sendRedirect("/login?error=" + encodedErrorMessage);
    }
}

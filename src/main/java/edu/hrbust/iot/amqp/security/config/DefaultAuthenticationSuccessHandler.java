package edu.hrbust.iot.amqp.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hrbust.iot.amqp.web.utils.common.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring Security
 * 认证成功处理类
 */
@Slf4j
@Component("successHandler")
public class DefaultAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        WebResponse<String> response = WebResponse.success("登陆成功");
        response.setCode(WebResponse.LOGIN_SUCCESS_CODE);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(response));
        log.info("[{}]登陆成功", httpServletRequest.getParameter("username"));
    }
}
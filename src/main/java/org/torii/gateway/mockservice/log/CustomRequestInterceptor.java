package org.torii.gateway.mockservice.log;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import java.time.Instant;

@Component
@Slf4j
public class CustomRequestInterceptor extends WebRequestHandlerInterceptorAdapter {


    public CustomRequestInterceptor(WebRequestInterceptor requestInterceptor) {
        super(requestInterceptor);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String ipAddress = request.getRemoteAddr();

        long startTime = Instant.now().toEpochMilli();
        log.info("Request URL::" + request.getRequestURL().toString() +
                ":: Start Time=" + Instant.now() + ":: IP=" + ipAddress);
        request.setAttribute("startTime", startTime);
        return true;
    }

}
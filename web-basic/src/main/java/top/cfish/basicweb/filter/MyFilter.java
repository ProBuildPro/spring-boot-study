package top.cfish.basicweb.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: isisiwish
 * @date: 2019/5/10
 * @time: 20:00
 */
@Slf4j
public class MyFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        log.info("this is MyFilter url : {}", request.getRequestURI());
        filterChain.doFilter(request, response);
    }
    
    @Override
    public void destroy()
    {
    }
}

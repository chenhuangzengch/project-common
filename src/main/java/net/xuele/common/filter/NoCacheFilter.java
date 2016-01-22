package net.xuele.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * zhihuan.cai 新建于 2015/6/17 0017.
 */
public class NoCacheFilter implements Filter {

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpResponse.setHeader("Pragma", "no-cache");
        httpResponse.setDateHeader("Expires", 0);

        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
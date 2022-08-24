package cybersoft.javabackend.java18.gamedoanso.filter;

import cybersoft.javabackend.java18.gamedoanso.Utils.UrlUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = UrlUtils.ALL)
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest; // ép kiểu về httpServletRequest -> vì filter có thể sử dụng cho nhiều chương trình(hiện tại đang sử dụng http)
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        // process before the request get in servlet
        // filterChain.doFilter(req, resp);
        // process response from servlet
        if (isLoginUser(req) || isAuthUrl(req)) {
            filterChain.doFilter(req, resp); // gọi lại doFilter để làm việc với filter tiếp theo
        } else {
            resp.sendRedirect(req.getContextPath() + UrlUtils.DANG_NHAP);
        }
    }

    @Override
    public void destroy() {

    }

    private boolean isAuthUrl(HttpServletRequest req) {
        var path = req.getServletPath();
        return path.startsWith(UrlUtils.DANG_KY)
                || path.startsWith(UrlUtils.DANG_NHAP)
                || path.startsWith(UrlUtils.HEALTH);
    }

    private boolean isLoginUser(HttpServletRequest req) {
        var currentUser = req.getSession().getAttribute("currentUser");
        return currentUser != null;
    }
}

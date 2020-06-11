package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "PermissionFilterAdmin", urlPatterns = "/admin_")
public class PermissionFilterAdmin implements Filter {

    public static final int ROLE_ADMIN = 1;
    public void init(FilterConfig config) throws ServletException {}
    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();
        Object object = session.getAttribute("ROLE");
        if (object != null) {
            int role = Integer.parseInt(object.toString());
            if (role == ROLE_ADMIN) {
                chain.doFilter(req, resp);
            } else {
                PrintWriter writer = resp.getWriter();
                writer.write("You are customer");
            }
        }
    }
}

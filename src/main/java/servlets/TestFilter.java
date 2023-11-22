package servlets;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Servlet Filter implementation class TestFilter
 */
public class TestFilter extends HttpFilter implements Filter {
     
	private static final long serialVersionUID = 1L;
	private static final Logger logger=Logger.getLogger(TestFilter.class.getName());
    /**
     * @see HttpFilter#HttpFilter()
     */
    public TestFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		   String accion = request.getParameter("accion");

	        if (accion != null && accion.equals("filtra")) {
	            // Modificar el request
	            request.setAttribute("status", "filtrada");
	            logger.info("TestFilter:: paso por filtro e modifico request");
	        } else {
	            // No modificar el request
	            request.setAttribute("status", "non_filtrada");
	            logger.info("TestFilter:: paso por filtro e non modifico request");
	        }
	       
	        chain.doFilter(request, response);
	    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

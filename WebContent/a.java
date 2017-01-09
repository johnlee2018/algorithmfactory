import java.io.IOException;     
  
import javax.servlet.Filter;     
import javax.servlet.FilterChain;     
import javax.servlet.FilterConfig;     
import javax.servlet.ServletException;     
import javax.servlet.ServletRequest;     
import javax.servlet.ServletResponse;     
import javax.servlet.http.HttpServletRequest;     
import javax.servlet.http.HttpServletResponse;     
import javax.servlet.http.HttpSession;     
import org.apache.commons.lang3.StringUtils;     
import com.iqbon.jcms.util.KeyConstant;     
    
/**   
* session������   
*/    
  
public class SessionFilter implements Filter {     
  
/**   
* ��Ҫ�ų���ҳ��   
*/    
  
private String excludedPages;       
private String[] excludedPageArray;     
  
/**   
* @see Filter#destroy()   
*/    
  
public void destroy() {     
	return;     
}     
    
/**   
* ��session�����жϵ�ǰ�����Ƿ��е�¼   
*/    
  
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
{     
	boolean isExcludedPage = false;     
	for (String page : excludedPageArray) 
	{//�ж��Ƿ��ڹ���url֮��     
		if(((HttpServletRequest) request).getServletPath().equals(page))
		{     
			isExcludedPage = true;     
			break;     
		}     
	}     
  
	if (isExcludedPage) 
	{//�ڹ���url֮��     
		chain.doFilter(request, response);     
	} 
	else 
	{//���ڹ���url֮�⣬�ж�session�Ƿ����     
		HttpSession session = ((HttpServletRequest) request).getSession();     
		if (session == null || session.getAttribute(KeyConstant.SESSION_KEY_USER) == null) 
		{     
			((HttpServletResponse) response).sendRedirect(��/login.htm��);     
		} 
		else 
		{     
			chain.doFilter(request, response);     
		}     
	}     
}     
  
/**   
* ��ʼ����������ȡ��Ҫ�ų������url   
*/    
  
public void init(FilterConfig fConfig) throws ServletException {     
	excludedPages = fConfig.getInitParameter(��excludedPages��);     
	if (StringUtils.isNotEmpty(excludedPages)) {     
			excludedPageArray = excludedPages.split(��,��);     
	}     
	return;     
	}     
}
package util;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 分页切面
 * @author ll
 *
 */
@Aspect
@Component
public class PagerAspect {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Pointcut("execution(* service..*(..))")
	public void selfPointcut() {};
	
	@SuppressWarnings("unchecked")
	@Around("selfPointcut()")
	public Object aroundAdvice(ProceedingJoinPoint jp) {
		Object o = null;
		
		//  --  根据jp对象获取method对象
		MethodSignature signature = (MethodSignature)jp.getSignature();
		Method m = signature.getMethod();
		
		//  --  Method对象获取是否含有@MiniPager方法
		MiniPager miniPager = (MiniPager)m.getAnnotation(MiniPager.class);
		
		//  --  做判断,若没有@MiniPager标注，则执行原始的业务方法
		if(miniPager==null) {   //--
			try {
				o = jp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			return o;
		}
		//  --  若加有@MiniPager标注，则加入分页代码
		//  i  获取某实体类对应的总的条目数
		//  ii 根据页大小，计算总的页数
		String tableName = miniPager.tableName();
		int totalTtems = jdbcTemplate.queryForObject("select count(*) from"+tableName, Integer.class);
		//  根据页大小计算总的页数
		int pageSize = (int)jp.getArgs()[1];
		int pagerNo = (int)jp.getArgs()[0];
		int totalPages = (totalTtems + pageSize -1)/pageSize;
		if(pagerNo>=totalPages)pagerNo = totalPages;
		//  iii  返回Pager对象
		Pager pager = new Pager();
		try {
			List data = (List)jp.proceed(new Object[] {pagerNo,pageSize});
			pager.setData(data);
			pager.setTotal(totalPages);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pager;
	}
}


//  应该是架构师写的代码
//  

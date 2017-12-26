package bookstore;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import bookstore.filters.BootCompliantUrlRewriteFilter;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
    public static final String REWRITE_FILTER_NAME = "rewriteFilter";
    public static final String REWRITE_FILTER_CONF_PATH = "urlrewrite.xml";
    
    @Bean
    public FilterRegistrationBean rewriteFilterConfig() {
        FilterRegistrationBean reg = new FilterRegistrationBean();
        reg.setName(REWRITE_FILTER_NAME);
        reg.setFilter(new BootCompliantUrlRewriteFilter(new ClassPathResource(REWRITE_FILTER_CONF_PATH)));

        reg.addInitParameter("confPath", REWRITE_FILTER_CONF_PATH);
        reg.addInitParameter("confReloadCheckInterval", "-1");
        reg.addInitParameter("statusPath", "/redirect");
        reg.addInitParameter("statusEnabledOnHosts", "*");
        reg.addInitParameter("logLevel", "DEBUG");
        reg.setDispatcherTypes(EnumSet.of(DispatcherType.REQUEST));
    	    reg.addUrlPatterns("/*");
    	    reg.setOrder(3);
    	
        return reg;
    }
    
    
}

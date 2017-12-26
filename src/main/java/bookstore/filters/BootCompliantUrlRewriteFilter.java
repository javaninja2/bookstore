package bookstore.filters;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.springframework.core.io.Resource;
import org.tuckey.web.filters.urlrewrite.Conf;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

public class BootCompliantUrlRewriteFilter extends UrlRewriteFilter {

    private Resource resource;

    public BootCompliantUrlRewriteFilter(Resource config){
        this.resource = config;
    }

    //Override the loadUrlRewriter method, and write your own implementation
    @Override
    protected void loadUrlRewriter(FilterConfig filterConfig) throws ServletException {
        try {
            //Create a UrlRewrite Conf object with the injected resource
            Conf conf = new Conf(filterConfig.getServletContext(), resource.getInputStream(), resource.getFilename(), "bookstore");
            checkConf(conf);
        } catch (IOException ex) {
            throw new ServletException("Unable to load URL rewrite configuration file from " + this.resource, ex);
        }
    }
}
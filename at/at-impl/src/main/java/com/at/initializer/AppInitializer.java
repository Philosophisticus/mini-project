package com.at.initializer;

import com.at.config.AppConfig;
import com.at.config.WebAppConfig;
import com.at.initializer.listener.SessionListener;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    @Override
    protected String[] getServletMappings()
    {
        return new String[] {"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class<?>[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class<?>[] { WebAppConfig.class };
    }

    @Override
    protected Filter[] getServletFilters()
    {
        return new Filter[] { new HiddenHttpMethodFilter() };
    }

    @Override
    public void onStartup(ServletContext servletContext)
        throws
            ServletException
    {
        super.onStartup(servletContext);
        servletContext.addListener(new SessionListener());
    }

}

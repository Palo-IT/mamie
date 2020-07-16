package org.paloit.mamie.test.monitored.back.spring.boot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

@Component
public class CpuUsageFilter extends GenericFilterBean {

    private final Logger logger = LoggerFactory.getLogger(CpuUsageFilter.class);
    private final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    //http://tutorials.jenkov.com/java-performance/jmh.html
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            String url = ((HttpServletRequest) request).getRequestURL().toString();
            request.getLocalAddr();
            logger.info("Start of request: " + url);

            chain.doFilter(request, response);

            final long threadUserTime = threadMXBean.getCurrentThreadUserTime();
            final long currentThreadCpuTime = threadMXBean.getCurrentThreadCpuTime();
            logger.info("End of request : " + currentThreadCpuTime + ":" + threadUserTime);
        } else {
            logger.warn("Unable to profile request, Not an HttpServletRequest : " + request.getClass().getName());
            doFilter(request, response, chain);
        }

    }
}

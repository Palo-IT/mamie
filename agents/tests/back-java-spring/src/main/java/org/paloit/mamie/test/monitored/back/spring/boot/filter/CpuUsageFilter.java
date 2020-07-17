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

    //https://stackoverflow.com/questions/504103/how-do-i-write-a-correct-micro-benchmark-in-java

    //http://tutorials.jenkov.com/java-performance/jmh.html
    //https://docs.oracle.com/en/java/javase/11/management/using-platform-mbean-server-and-platform-mxbeans.html#GUID-E954720D-0C11-491C-8784-4364738DDEE3
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {

            final String url = ((HttpServletRequest) request).getRequestURL().toString();
            request.getLocalAddr();

            if(threadMXBean.isCurrentThreadCpuTimeSupported()){

                final long start = threadMXBean.getCurrentThreadCpuTime();

                chain.doFilter(request, response);

                final long end = threadMXBean.getCurrentThreadCpuTime();
                final long elapsed = end - start;

                logger.info("Request: "+ url+  " cpuTime: "+ elapsed);
            }else {
                logger.warn("Unable to profile request, thread cpu time not supported : " + request.getClass().getName());
            }

        } else {
            logger.warn("Unable to profile request, Not an HttpServletRequest : " + request.getClass().getName());
            doFilter(request, response, chain);
        }

    }
}

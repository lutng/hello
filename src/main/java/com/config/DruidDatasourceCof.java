package com.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidDatasourceCof {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDateSource(){
        System.out.println("22222");
        return new DruidDataSource();
    }

/*    @Bean
    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(),  "/druid/*");
        registrationBean.addInitParameter("allow", "127.0.0.1");// IP白名单 (没有配置或者为空，则允许所有访问)
      //  registrationBean.addInitParameter("deny", "");// IP黑名单 (存在共同时，deny优先于allow)
        registrationBean.addInitParameter("loginUsername", "root");
        registrationBean.addInitParameter("loginPassword", "12345");
        registrationBean.addInitParameter("username", "root");
        registrationBean.addInitParameter("password", "12345");
        registrationBean.addInitParameter("resetEnable", "false");
        return registrationBean;
    }*/

    //注册Servlet
   /* @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servlet = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,Object> map = new HashMap<>();
        map.put("loginUsername","admin");
        map.put("loginPassword","123456");
        map.put("allow","");
        servlet.setInitParameters(map);
        return servlet;
    }*/

    // 过滤器的配置，看看哪些请求需要被过滤
    // 没有web.xml 的情况配置 Filter 的方法！ FilterRegistrationBean
/*    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        // 配置内容
        // 配置哪些请求可以被过滤！
        HashMap<String, String> map = new HashMap<>();
        map.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(map);

        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }*/

}

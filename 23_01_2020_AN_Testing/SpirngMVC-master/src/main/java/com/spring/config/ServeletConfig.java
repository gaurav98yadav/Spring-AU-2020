package com.spring.config;
 
import javax.sql.DataSource;     

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spring.data.DataManipulation;

import com.spring.data.EmployeeData;
 
@Configuration
@ComponentScan(basePackages="com.spring.*")
@EnableWebMvc
public class ServeletConfig extends WebMvcConfigurerAdapter{
	 
	@Bean
	public InternalResourceViewResolver resolver() {
	    InternalResourceViewResolver vr = new InternalResourceViewResolver();
	    vr.setPrefix("/WEB-INF/views/");
	    vr.setSuffix(".jsp");
	    return vr;
	}
	
    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/employeedb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
         
        return dataSource;
    }
     
    @Bean
    public EmployeeData getEmployeeDAO() {
        return new DataManipulation(getDataSource());
    }
}	
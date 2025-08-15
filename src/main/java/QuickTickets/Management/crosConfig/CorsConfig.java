package QuickTickets.Management.crosConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registery) {
				  registery.addMapping("/**") 
                 .allowedOrigins("http://localhost:3000","http://localhost:3001","https://quicktickets100.netlify.app") 
                 .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") 
                 .allowedHeaders("*") 
                 .allowCredentials(true);
			}
			
		};
	}

}

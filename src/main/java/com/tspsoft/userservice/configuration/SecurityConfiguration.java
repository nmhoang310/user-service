package com.tspsoft.userservice.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
//	private final JwtAuthenticationFilter jwtAuthFilter;
//	private final AuthenticationProvider authenticationProvider;
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		http
//		//.cors(Customizer.withDefaults())
//		.cors().and().csrf().disable()
//		.authorizeHttpRequests()
//		.requestMatchers("/secret-info").permitAll()
//		.anyRequest().authenticated();
////		.requestMatchers("/api/v0/auth/**")
////		.permitAll()
//		//.anyRequest()
//		//.authenticated()
////		.and()
////		.sessionManagement()
////		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////		.and()
//	//	.authenticationProvider(authenticationProvider);
//	//	.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//		
//		return http.build();
//	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		 http
			.cors(Customizer.withDefaults())
			.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/secret-info").permitAll()
			.anyRequest().authenticated();
			
			return http.build();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
	    configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELET"));
	    configuration.setAllowedHeaders(List.of("Authorization"));
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}
}

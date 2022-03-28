package marian.constantin.marica.travelhousebackend.security;

import marian.constantin.marica.travelhousebackend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfiguration(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/v1/user/getUserDetails").authenticated()
                .antMatchers("/api/v1/user/authenticated").authenticated()
                .antMatchers("/api/v1/user/register").permitAll()
                .antMatchers("/api/v1/user/addPhoneNumber").authenticated()
                .antMatchers("/api/v1/user/changePassword").authenticated()
                .antMatchers("/api/v1/offer/getOffers").authenticated()
                .antMatchers("/api/v1/offer/createOffer").authenticated()
                .antMatchers("/api/v1/offer/updateOfferByTitle").authenticated()
                .antMatchers("/api/v1/offer/updateOfferByPrice").authenticated()
                .antMatchers("/api/v1/offer/updateOfferByDescription").authenticated()
                .antMatchers("/api/v1/offer/updateOfferByType").authenticated()
                .antMatchers("/api/v1/offer/deleteOffer").authenticated()
                .antMatchers("/api/v1/offerReview/getOfferReviews/byOffer/**").authenticated()
                .antMatchers("/api/v1/offerReview/getOfferReviews/byTourist/**").authenticated()
                .antMatchers("/api/v1/offerReview/createOfferReview").authenticated()
                .antMatchers("/api/v1/offerReview/updateOfferReviewByRating").authenticated()
                .antMatchers("/api/v1/offerReview/updateOfferReviewByComment").authenticated()
                .antMatchers("/api/v1/offerReview/deleteOfferReview").authenticated()
                .antMatchers("/api/v1/touristReview/getStatusByTourist/**").authenticated()
                .antMatchers("/api/v1/touristReview/addTouristReview/**").authenticated()
                .antMatchers("/h2-console/**").permitAll();
        http.formLogin();
        http.httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }
}

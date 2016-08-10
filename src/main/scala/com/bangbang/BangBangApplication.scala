package com.bangbang

import org.psnively.scala.context.function.{FunctionalConfigApplicationContext, FunctionalConfiguration}
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
//@EnableOAuth2Client
//@EnableAuthorizationServer
//@Order(6)
class BangBangApplication

object BangBangApplication {
  def main(args: Array[String]) {
    val app = new SpringApplication(classOf[BangBangApplication])
    app.addInitializers((applicationContext: ConfigurableApplicationContext) ⇒
      applicationContext.setParent(FunctionalConfigApplicationContext[TestConfig]))
    app.run()
  }

//  @Configuration
//  @EnableResourceServer protected class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//    @throws[Exception]
//    override def configure(http: HttpSecurity) =
//      http.antMatcher("/me").authorizeRequests.anyRequest.authenticated
//  }

}

class TestConfig extends FunctionalConfiguration

//@Configuration
//class SecurityConfig extends WebSecurityConfigurerAdapter {
//  @Autowired val oAuth2ClientContext: OAuth2ClientContext = null
//
//  @Bean
//  def springDataUserDetailsService: UserDetailsService = {
//    new UserDetailsService {
//      override def loadUserByUsername(username: String): UserDetails = ???
//    }
//  }
//
//  @throws[Exception]
//  override protected def configure(http: HttpSecurity) {
//    // @formatter:off
//    http
//      .antMatcher("/**")
//        .authorizeRequests()
//        .antMatchers("/", "/login**", "/webjars/**", "/qq/**").permitAll()
//        .anyRequest().authenticated()
////      .and.asInstanceOf[HttpSecurity]
////        .exceptionHandling()
////        .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"))
//      .and.logout().logoutSuccessUrl("/").permitAll
//      .and.csrf().ignoringAntMatchers("/**")
//      .and.addFilterBefore(ssoFilter, classOf[BasicAuthenticationFilter])
//    // @formatter:on
//  }
//
//  @Bean def oauth2ClientFilterRegistration(filter: OAuth2ClientContextFilter): FilterRegistrationBean = {
//    val registration: FilterRegistrationBean = new FilterRegistrationBean
//    registration.setFilter(filter)
//    registration.setOrder(-100)
//    registration
//  }
//
//  @ConfigurationProperties("qq")
//  @Bean private[bangbang] def qq: ClientResources = new ClientResources
//
//  private def ssoFilter: Filter = {
//    val filter = new CompositeFilter
//    filter.setFilters(List(ssoFilter(qq, "/login/qq")).asJava)
//    filter
//  }
//
//  private def ssoFilter(client: ClientResources, path: String): Filter = {
//    val qqFilter: OAuth2ClientAuthenticationProcessingFilter = new OAuth2ClientAuthenticationProcessingFilter(path) {
//      override def attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication = {
//        val result = super.attemptAuthentication(request, response)
//        val details = result.getDetails
//        println(s"=====================${details.getClass}---$details========================")
//        result
//      }
//    }
//    val facebookTemplate: OAuth2RestTemplate = new OAuth2RestTemplate(client.getClient, oAuth2ClientContext)
//    qqFilter.setRestTemplate(facebookTemplate)
//    qqFilter.setTokenServices(new UserInfoTokenServices(client.resource.getUserInfoUri, client.getClient.getClientId))
//    qqFilter
//  }
//
//  @Autowired private val dataSource: DataSource = null
//
//  @throws[Exception]
//  override def configure(auth: AuthenticationManagerBuilder): Unit = {
//    // @formatter:off
//    auth.jdbcAuthentication().dataSource(dataSource)
//      .usersByUsernameQuery("SELECT username, password, TRUE " + "FROM user WHERE username=?")
//      .authoritiesByUsernameQuery("SELECT username, 'ROLE_USER' FROM user WHERE username=?")
//    // @formatter:on
//  }
//}
//
//class ClientResources {
//  @BeanProperty val client: OAuth2ProtectedResourceDetails = new AuthorizationCodeResourceDetails
//  @BeanProperty val resource: ResourceServerProperties = new ResourceServerProperties
//}

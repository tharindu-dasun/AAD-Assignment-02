package lk.ijse.gdse.config;

@Configuration
@ComponentScan
@EnableWebMvc
@Import({JPAConfiguration.class, TechLeadServiceImpl.class, ProjectServiceImpl.class})
public class WebAppRootConfig {
}

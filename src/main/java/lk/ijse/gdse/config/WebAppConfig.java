package lk.ijse.gdse.config;

@Configuration
@ComponentScan(basePackageClasses = {Response.class, TechLeadController.class})
@EnableWebMvc
public class WebAppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
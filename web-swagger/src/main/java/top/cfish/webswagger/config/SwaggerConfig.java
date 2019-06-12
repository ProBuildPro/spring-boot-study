package top.cfish.webswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: isisiwish
 * @date: 2019/5/23
 * @time: 16:36
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("top.cfish.webswagger.controller")).paths(PathSelectors.any()).build();
    }
    
    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder().title("客户管理").description("客户管理中心API 1.0操作文档").termsOfServiceUrl("https://cfish.top/").version("1.0").contact(new Contact("isisiwish", "https://cfish.top/", "isisiwish#qq.com")).build();
    }
}

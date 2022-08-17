package seokjiae.codingtestbackend.infra.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seokjiae.codingtestbackend.application.HttpQueryService;
import seokjiae.codingtestbackend.application.OEmbedService;
import seokjiae.codingtestbackend.application.OEmbedServiceImpl;
import seokjiae.codingtestbackend.domain.DelegateOEmbedUrlConverter;
import seokjiae.codingtestbackend.infra.RestTemplateQueryService;
import seokjiae.codingtestbackend.infra.WebClientQueryService;

@Configuration
public class ApplicationConfig {

  @Bean
  public HttpQueryService restTemplateQueryService(RestTemplateBuilder builder) {
    return new RestTemplateQueryService(builder);
  }

  @Bean
  public HttpQueryService webClientQueryService() {
    return new WebClientQueryService();
  }

  @Bean
  public OEmbedService oEmbedService(HttpQueryService webClientQueryService,
      DelegateOEmbedUrlConverter delegateOEmbedUrlConverter) {
    return new OEmbedServiceImpl(webClientQueryService, delegateOEmbedUrlConverter);
  }
}

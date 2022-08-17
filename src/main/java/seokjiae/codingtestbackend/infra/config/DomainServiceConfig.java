package seokjiae.codingtestbackend.infra.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seokjiae.codingtestbackend.domain.CodeSandboxOEmbedUrlConverter;
import seokjiae.codingtestbackend.domain.DelegateOEmbedUrlConverter;
import seokjiae.codingtestbackend.domain.OEmbedUrlConverter;
import seokjiae.codingtestbackend.domain.TwitterOEmbedUrlConverter;
import seokjiae.codingtestbackend.domain.VimeoOEmbedUrlConverter;
import seokjiae.codingtestbackend.domain.YoutubeOEmbedUrlConverter;

@Configuration
public class DomainServiceConfig {

  @Bean
  public OEmbedUrlConverter twitterOEmbedUrlConverter() {
    return new TwitterOEmbedUrlConverter();
  }

  @Bean
  public OEmbedUrlConverter youtubeOEmbedUrlConverter() {
    return new YoutubeOEmbedUrlConverter();
  }

  @Bean
  public OEmbedUrlConverter vimeoOEmbedUrlConverter() {
    return new VimeoOEmbedUrlConverter();
  }

  @Bean
  public OEmbedUrlConverter codeSandboxOEmbedUrlConverter() {
    return new CodeSandboxOEmbedUrlConverter();
  }

  @Bean
  public DelegateOEmbedUrlConverter delegateOEmbedUrlConverter(List<OEmbedUrlConverter> converters) {
    return new DelegateOEmbedUrlConverter(converters);
  }
}

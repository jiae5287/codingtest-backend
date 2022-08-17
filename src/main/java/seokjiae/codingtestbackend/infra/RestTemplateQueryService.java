package seokjiae.codingtestbackend.infra;

import java.util.Map;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import seokjiae.codingtestbackend.application.HttpQueryService;

public class RestTemplateQueryService implements HttpQueryService {

  private final RestTemplate restTemplate;

  public RestTemplateQueryService(RestTemplateBuilder builder) {
    this.restTemplate = builder.build();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Map<String, Object> query(String uri) {
    return restTemplate.getForObject(uri, Map.class);
  }
}

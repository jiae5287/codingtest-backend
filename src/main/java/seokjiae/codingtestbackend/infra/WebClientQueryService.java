package seokjiae.codingtestbackend.infra;

import java.util.Map;
import org.springframework.web.reactive.function.client.WebClient;
import seokjiae.codingtestbackend.application.HttpQueryService;

public class WebClientQueryService implements HttpQueryService {

  private final WebClient webClient;

  public WebClientQueryService() {
    this.webClient = WebClient.builder().build();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Map<String, Object> query(String uri) {
    return webClient.get().uri(uri)
        .retrieve()
        .bodyToMono(Map.class).block();
  }
}

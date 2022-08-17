package seokjiae.codingtestbackend.application;

import java.util.Map;
import seokjiae.codingtestbackend.domain.DelegateOEmbedUrlConverter;

public class OEmbedServiceImpl implements OEmbedService {

  private final HttpQueryService httpQueryService;
  private final DelegateOEmbedUrlConverter delegateOEmbedUrlConverter;

  public OEmbedServiceImpl(HttpQueryService httpQueryService, DelegateOEmbedUrlConverter delegateOEmbedUrlConverter) {
    this.httpQueryService = httpQueryService;
    this.delegateOEmbedUrlConverter = delegateOEmbedUrlConverter;
  }

  @Override
  public Map<String, Object> getOEmbedInfo(String requestUrl) {
    String oembedUrl = delegateOEmbedUrlConverter.convert(requestUrl);
    return httpQueryService.query(oembedUrl);
  }
}

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
    // delegateOEmbedUrlConverter를 통해 oembed url을 가져온다.
    String oembedUrl = delegateOEmbedUrlConverter.convert(requestUrl);
    // oembed url을 가지고 http 요청을 보내 결과값을 받아온다.
    return httpQueryService.query(oembedUrl);
  }
}

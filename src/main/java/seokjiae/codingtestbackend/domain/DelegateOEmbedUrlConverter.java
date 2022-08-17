package seokjiae.codingtestbackend.domain;

import java.util.List;
import seokjiae.codingtestbackend.domain.exception.InvalidSchemeException;
import seokjiae.codingtestbackend.domain.utils.UrlUtil;

public class DelegateOEmbedUrlConverter {

  private final List<OEmbedUrlConverter> converters;

  public DelegateOEmbedUrlConverter(List<OEmbedUrlConverter> converters) {
    this.converters = converters;
  }

  public String convert(String requestUrl) {
    UrlUtil.validateUrl(requestUrl);
    for (OEmbedUrlConverter converter : converters) {
      if (converter.convertable(requestUrl)) {
        return converter.convert(requestUrl);
      }
    }
    throw new InvalidSchemeException("사용할 수 없는 Scheme입니다.");
  }

}

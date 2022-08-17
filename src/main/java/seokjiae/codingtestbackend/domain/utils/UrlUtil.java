package seokjiae.codingtestbackend.domain.utils;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.validator.routines.UrlValidator;
import seokjiae.codingtestbackend.domain.exception.InvalidHostException;
import seokjiae.codingtestbackend.domain.exception.InvalidUrlException;

public final class UrlUtil {

  private UrlUtil() {}

  public static void validateUrl(String url) {
    if (!new UrlValidator().isValid(url)) {
      throw new InvalidUrlException("유효하지 않은 url입니다.");
    }
  }

  public static String getHostUrl(String url) {
    // 해당 주소에서 Host 주소 부분만 추출
    String hostUrl;
    try {
      hostUrl = new URL(url).getHost();
    } catch (MalformedURLException e) {
      throw new InvalidHostException("유효하지 않은 Host입니다.");
    }
    // null 처리
    if (hostUrl == null) {
      throw new InvalidHostException("Host값이 null입니다.");
    }
    return hostUrl;
  }
}

package seokjiae.codingtestbackend.domain;

import java.util.regex.Pattern;
import seokjiae.codingtestbackend.domain.utils.UrlUtil;

public class TwitterOEmbedUrlConverter implements OEmbedUrlConverter {

  @Override
  public boolean convertable(String requestUrl) {
    String hostUrl = UrlUtil.getHostUrl(requestUrl);

    switch (hostUrl) {
      case "www.twitter.com" :
      case "twitter.com" :
        break;
      default:
        return false;
    }

    if (Pattern.compile("(https://twitter.com/*)").matcher(requestUrl).find()
        || Pattern.compile("(https://twitter.com/*/status/*?)").matcher(requestUrl).find()
        || Pattern.compile("(https://*.twitter.com/*/status/*)").matcher(requestUrl).find()
    ) {
      return true;
    }
    return false;
  }

  @Override
  public String convert(String requestUrl) {
    return "https://publish.twitter.com/oembed?url=" + requestUrl;
  }
}

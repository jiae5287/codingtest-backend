package seokjiae.codingtestbackend.domain;

import java.util.regex.Pattern;
import seokjiae.codingtestbackend.domain.utils.UrlUtil;

public class VimeoOEmbedUrlConverter implements OEmbedUrlConverter {

  @Override
  public boolean convertable(String requestUrl) {
    String hostUrl = UrlUtil.getHostUrl(requestUrl);

    switch (hostUrl) {
      case "vimeo.com" :
      case "player.vimeo.com" :
        break;
      default:
        return false;
    }

    if (Pattern.compile("(https://vimeo.com/*)").matcher(requestUrl).find()
        || Pattern.compile("(https://vimeo.com/album/*/video/*)").matcher(requestUrl).find()
        || Pattern.compile("(https://vimeo.com/channels/*/*)").matcher(requestUrl).find()
        || Pattern.compile("(https://vimeo.com/groups/*/videos/*)").matcher(requestUrl).find()
        || Pattern.compile("(https://vimeo.com/ondemand/*/*)").matcher(requestUrl).find()
        || Pattern.compile("(https://player.vimeo.com/video/*)").matcher(requestUrl).find()
    ) {
      return true;
    }
    return false;
  }

  @Override
  public String convert(String requestUrl) {
    return "https://vimeo.com/api/oembed.json?url=" + requestUrl;
  }
}

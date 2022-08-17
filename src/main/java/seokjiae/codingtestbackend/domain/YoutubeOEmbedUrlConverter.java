package seokjiae.codingtestbackend.domain;

import java.util.regex.Pattern;
import seokjiae.codingtestbackend.domain.utils.UrlUtil;

public class YoutubeOEmbedUrlConverter implements OEmbedUrlConverter {

  @Override
  public boolean convertable(String requestUrl) {
    String hostUrl = UrlUtil.getHostUrl(requestUrl);

    switch (hostUrl) {
      case "www.youtube.com":
      case "youtube.com":
      case "youtu.be":
        break;
      default:
        return false;
    }

    if (Pattern.compile("(https://.*.youtube.com/watch.*)").matcher(requestUrl).find()
        || Pattern.compile("(https://.*.youtube.com/v/.*)").matcher(requestUrl).find()
        || Pattern.compile("(https://youtu.be/.*)").matcher(requestUrl).find()
        || Pattern.compile("(https://.*.youtube.com/playlist?list=.*)").matcher(requestUrl).find()
        || Pattern.compile("(https://youtube.com/playlist?list=.*)").matcher(requestUrl).find()
        || Pattern.compile("(https://.*.youtube.com/shorts.*)").matcher(requestUrl).find()
    ) {
      return true;
    }
    return false;
  }

  @Override
  public String convert(String requestUrl) {
    return "https://www.youtube.com/oembed?url=" + requestUrl;
  }
}

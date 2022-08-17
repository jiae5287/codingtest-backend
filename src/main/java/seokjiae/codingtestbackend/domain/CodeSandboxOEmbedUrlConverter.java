package seokjiae.codingtestbackend.domain;

import java.util.regex.Pattern;
import seokjiae.codingtestbackend.domain.utils.UrlUtil;

public class CodeSandboxOEmbedUrlConverter implements OEmbedUrlConverter {

  public CodeSandboxOEmbedUrlConverter() {
  }

  @Override
  public boolean convertable(String requestUrl) {
    String hostUrl = UrlUtil.getHostUrl(requestUrl);

    switch (hostUrl) {
      case "codesandbox.io" : break;
      default : return false;
    }

    if (Pattern.compile("(https://codesandbox.io/s/*)").matcher(requestUrl).find()
    || Pattern.compile("(https://codesandbox.io/embed/*)").matcher(requestUrl).find()) {
      return true;
    }
    return false;
  }

  @Override
  public String convert(String requestUrl) {
    return "https://codesandbox.io/oembed?url=" + requestUrl;
  }
}

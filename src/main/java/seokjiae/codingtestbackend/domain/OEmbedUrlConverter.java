package seokjiae.codingtestbackend.domain;

public interface OEmbedUrlConverter {

  boolean convertable(String requestUrl);

  String convert(String requestUrl);
}

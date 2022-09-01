package seokjiae.codingtestbackend.domain;

/**
 * OEmbedUrlConverter.
 * convertable : 해당 객체를 사용할 수 있는지 확인하는 메서드.
 * convert : 클라이언트가 보낸 url을 provider가 제공하는 oembed url로 변경하는 메서드.
 */
public interface OEmbedUrlConverter {

  boolean convertable(String requestUrl);

  String convert(String requestUrl);
}

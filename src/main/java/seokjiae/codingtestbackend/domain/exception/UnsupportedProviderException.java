package seokjiae.codingtestbackend.domain.exception;

/**
 * UnsupportedProviderException.
 * 지원하지 않는 provider인 경우 발생하는 예외.
 */
public class UnsupportedProviderException extends RuntimeException {

  public UnsupportedProviderException() {
  }

  public UnsupportedProviderException(String message) {
    super(message);
  }
}

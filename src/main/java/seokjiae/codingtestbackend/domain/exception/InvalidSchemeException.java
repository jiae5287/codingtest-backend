package seokjiae.codingtestbackend.domain.exception;

/**
 * InvalidSchemeException.
 * provider.json에서 제공하지 않는 scheme인 경우 예외 발생.
 */
public class InvalidSchemeException extends RuntimeException {

  public InvalidSchemeException() {
  }

  public InvalidSchemeException(String message) {
    super(message);
  }
}

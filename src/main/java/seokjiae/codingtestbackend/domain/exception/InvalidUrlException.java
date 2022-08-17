package seokjiae.codingtestbackend.domain.exception;

/**
 * InvalidUrlException.
 * URL이 유효하지 않을 때 발생하는 Exception.
 */
public class InvalidUrlException extends RuntimeException {

  public InvalidUrlException() {
  }

  public InvalidUrlException(String message) {
    super(message);
  }
}

package seokjiae.codingtestbackend.domain.exception;

/**
 * InvalidHostException.
 * URL의 Host가 유효하지 않을 때 발생하는 예외.
 */
public class InvalidHostException extends RuntimeException {

  public InvalidHostException() {
  }

  public InvalidHostException(String message) {
    super(message);
  }
}

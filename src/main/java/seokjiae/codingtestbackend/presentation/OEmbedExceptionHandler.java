package seokjiae.codingtestbackend.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import seokjiae.codingtestbackend.domain.exception.InvalidHostException;
import seokjiae.codingtestbackend.domain.exception.InvalidSchemeException;
import seokjiae.codingtestbackend.domain.exception.InvalidUrlException;
import seokjiae.codingtestbackend.domain.exception.UnsupportedProviderException;

@ControllerAdvice
public class OEmbedExceptionHandler {

  final Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * invalidUrlException.
   * 유효하지 않은 URL 예외 처리 메서드.
   */
  @ExceptionHandler(InvalidUrlException.class)
  public String invalidUrlException(InvalidUrlException ex, Model model) {
    logger.error("invalidUrlException : {}", ex.getMessage());
    model.addAttribute("error", ex.getMessage());
    return "index";
  }

  /**
   * invalidHostException.
   * 유효하지 않은 Host URL 예외 처리 메서드.
   */
  @ExceptionHandler(InvalidHostException.class)
  public String invalidHostException(InvalidHostException ex, Model model) {
    logger.error("invalidHostException : {}", ex.getMessage());
    model.addAttribute("error", ex.getMessage());
    return "index";
  }

  /**
   * unsupportedProviderException.
   * 지원하지 않는 provider인 경우 발생하는 예외.
   */
  @ExceptionHandler(UnsupportedProviderException.class)
  public String unsupportedProviderException(UnsupportedProviderException ex, Model model) {
    logger.error("unsupportedProviderException : {}", ex.getMessage());
    model.addAttribute("error", ex.getMessage());
    return "index";
  }

  /**
   * InvalidSchemeException.
   * provider.json에서 제공하지 않는 scheme인 경우 예외 발생.
   */
  @ExceptionHandler(InvalidSchemeException.class)
  public String invalidSchemeException(InvalidSchemeException ex, Model model) {
    logger.error("invalidSchemeException : {}", ex.getMessage());
    model.addAttribute("error", ex.getMessage());
    return "index";
  }
}

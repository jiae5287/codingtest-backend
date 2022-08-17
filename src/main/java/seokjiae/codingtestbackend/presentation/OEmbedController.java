package seokjiae.codingtestbackend.presentation;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import seokjiae.codingtestbackend.application.OEmbedService;

@Controller
public class OEmbedController {

  private final OEmbedService oembedService;

  public OEmbedController(OEmbedService oembedService) {
    this.oembedService = oembedService;
  }

  @ResponseStatus(code = HttpStatus.OK)
  @GetMapping("/oembed")
  public String getOEmbedInfo(Model model, @RequestParam @NonNull String paramUrl) {
    Map<String, Object> resultMap = oembedService.getOEmbedInfo(paramUrl);
    model.addAttribute("paramUrl", paramUrl);
    model.addAttribute("resultMap", resultMap);
    return "index";
  }
}

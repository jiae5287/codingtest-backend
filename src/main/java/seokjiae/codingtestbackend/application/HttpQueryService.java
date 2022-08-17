package seokjiae.codingtestbackend.application;

import java.util.Map;

public interface HttpQueryService {

  Map<String, Object> query(String uri);

}

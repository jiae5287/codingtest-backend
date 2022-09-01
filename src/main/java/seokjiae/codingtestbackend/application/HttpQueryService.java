package seokjiae.codingtestbackend.application;

import java.util.Map;

/**
 * HttpQueryService.
 * embed url을 이용해 provider 사이트에서 url의 상세정보를 가져옵니다.
 * 그때 일어나는 http 통신을 위해 사용하는 interface입니다.
 */
public interface HttpQueryService {

  Map<String, Object> query(String uri);

}

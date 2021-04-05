package br.com.bomdestino.sgm.msoauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.bomdestino.sgm.msoauth.models.User;

@Component
@FeignClient(name = "sgm-users-service", path = "/api/v1/users")
public interface UserFeignClient {

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email);
}

package lv.merrill.audion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "greeting",
        url = "localhost:8080"
)
public interface HelloWorldClient {
    @GetMapping("/api/hello-world")
    String greeting();
}
package lv.merrill.audion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @Autowired
    private HelloWorldClient helloWorldClient;

    @Autowired
    private GreetingRepository greetingRepository;

    @GetMapping("/hello-world")
    public ResponseEntity<String> test() {
        String helloWorld = greetingRepository.findGreeting();
        return ResponseEntity.of(Optional.of(helloWorld));
    }

    @GetMapping("/hello-world/feign")
    public ResponseEntity<String> helloWorldFeign() {
        return ResponseEntity.of(Optional.of(helloWorldClient.greeting()));
    }
}

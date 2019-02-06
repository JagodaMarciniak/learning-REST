package hello;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/greetings")
@RestController
public class GreetingController {
  Map<Integer, Greeting> greetings = new HashMap<>();
  //counter is a key in HashMAp
  private int counter = 0;
  @Autowired
  HelloWorld helloWorld;

  //pobiera obiekt
  @GetMapping
  public Collection<Greeting> greetings() {
    return greetings.values();
  }

  //wysyła obiekt
  @GetMapping("/hello")
  public String sayHello() {
    return helloWorld.sayHello();
  }

  @PostMapping //pobieramy przywitanie, zapisujemy w mapie pod kluczem
  public int saveGreetings(@RequestBody Greeting greeting) {
    greeting.putId(counter);
    greetings.put(counter, greeting);
    return counter++;
  }

  @PutMapping("/{id}")
  public void updateGreeting(@PathVariable("id") int greetingId, @RequestBody Greeting greeting) {
    greeting.setId(greetingId);
    greetings.put(greetingId, greeting);
  }

  @GetMapping("/{id}")
  public Greeting getSingleGreeting(@PathVariable("id") int greetingId) {
    return greetings.get(greetingId);

  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") int greatingId) {
    greetings.remove(greatingId);
  }
}

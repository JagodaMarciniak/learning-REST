package hello;

import org.springframework.lang.NonNull;

public class Greeting {

  @NonNull
  long id;
  @NonNull
  String content;

  public Greeting() {
  }

  public Greeting(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void putId(int counter) {
    this.id = counter;
  }
}

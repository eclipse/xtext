package my.company;

import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Greeter {
  public void greetBunchOfPeople(final List<String> people) {
    for (final String name : people) {
      String _sayHello = this.sayHello(name);
      InputOutput.<String>println(_sayHello);
    }
  }
  
  public String sayHello(final String personToGreet) {
    return (("Hello " + personToGreet) + "!");
  }
}

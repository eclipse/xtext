package generator;

import generator.AbstractWebsite;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class Community extends AbstractWebsite {
  public String path() {
    return "community.html";
  }
  
  public CharSequence contents() {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
}

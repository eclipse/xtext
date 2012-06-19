package generator;

import generator.AbstractWebsite;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class Download extends AbstractWebsite {
  public String path() {
    return "download.html";
  }
  
  public CharSequence contents() {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
}

package generator;

import generator.AbstractWebsite;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class Plan extends AbstractWebsite {
  public String path() {
    return "plan.html";
  }
  
  public CharSequence contents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t\t");
    _builder.newLine();
    return _builder;
  }
}

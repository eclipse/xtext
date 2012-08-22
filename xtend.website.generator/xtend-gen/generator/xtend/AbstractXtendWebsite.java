package generator.xtend;

import generator.AbstractWebsite;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public abstract class AbstractXtendWebsite extends AbstractWebsite {
  public String websiteDescription() {
    return "Xtend is a statically typed programming language sitting on top of Java.";
  }
  
  public String websiteTitle() {
    return "Xtend - Modernized Java";
  }
  
  public String twitterID() {
    return "xtendlang";
  }
  
  public String analyticsAccount() {
    return "UA-2429174-4";
  }
  
  public CharSequence headline(final String title) {
    return "";
  }
  
  public String plusoneURL() {
    return "http://www.xtend-lang.org";
  }
  
  public Iterable<Pair<String,String>> topLevelMenu() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("news.html", "News");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("download.html", "Download");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("documentation.html", "Documentation");
    Pair<String,String> _mappedTo_3 = Pair.<String, String>of("community.html", "Community");
    Pair<String,String> _mappedTo_4 = Pair.<String, String>of("http://xtext.org", "Xtext");
    Pair<String,String> _mappedTo_5 = Pair.<String, String>of("http://www.eclipse.org", "Eclipse.org");
    ArrayList<Pair<String,String>> _newArrayList = CollectionLiterals.<Pair<String,String>>newArrayList(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5);
    return _newArrayList;
  }
}

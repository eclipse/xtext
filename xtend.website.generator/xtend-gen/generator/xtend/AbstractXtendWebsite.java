package generator.xtend;

import generator.AbstractWebsite;

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
}

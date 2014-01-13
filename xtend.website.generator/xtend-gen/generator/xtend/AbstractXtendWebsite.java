package generator.xtend;

import generator.AbstractWebsite;
import org.eclipse.xtend2.lib.StringConcatenation;
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
    return CollectionLiterals.<Pair<String,String>>newArrayList(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5);
  }
  
  public CharSequence quickLinksAndTweets() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div id=\"extra\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"inner\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"container\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<div class=\"span6\">");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<h3 style=\"padding-top: 0px; margin-top: 0px;\">Quick Links</h3>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<ul class=\"footer-links clearfix\">");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://www.eclipse.org/legal/privacy.php\">Privacy Policy</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://www.eclipse.org/legal/termsofuse.php\">Terms of Use</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://www.eclipse.org/legal/copyright.php\">Copyright Agent</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://www.eclipse.org/legal/\">Legal</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</ul>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<ul class=\"footer-links clearfix\">");
    _builder.newLine();
    _builder.append("      \t\t\t");
    _builder.append("<li><a href=\"http://www.eclipse.org\">Eclipse Home</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://marketplace.eclipse.org/\">Market Place</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://live.eclipse.org/\">Eclipse Live</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://www.planeteclipse.org/\">Eclipse Planet</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</ul>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<div class=\"span6\">");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<h3 style=\"padding-top: 0px; margin-top: 0px;\"><a href=\"https://twitter.com/xtendlang\" style=\"color : white;\">@Xtendlang</a> on Twitter</h3>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<a class=\"twitter-timeline\" href=\"https://twitter.com/xtendlang\" data-widget-id=\"346624176666333185\"");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("data-chrome=\"noheader nofooter transparent\"");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("data-theme=\"dark\">Tweets by @Xtendlang</a>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<script>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("!function(d,s,id) { ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?\'http\':\'https\';");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("if(!d.getElementById(id)) { ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t  ");
    _builder.append("js=d.createElement(s);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t  ");
    _builder.append("js.id=id;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t  ");
    _builder.append("js.src=p+\"://platform.twitter.com/widgets.js\";");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t  ");
    _builder.append("fjs.parentNode.insertBefore(js,fjs);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}(document,\"script\",\"twitter-wjs\");</script>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
}

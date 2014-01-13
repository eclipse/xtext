package generator;

import generator.AbstractWebsite;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class News extends AbstractWebsite {
  public String path() {
    return "news.html";
  }
  
  protected boolean isPrettyPrint() {
    return true;
  }
  
  public CharSequence javaScriptDocumentStart() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>");
    _builder.newLine();
    _builder.append("<script type=\"text/javascript\">");
    _builder.newLine();
    _builder.append("google.load(\"feeds\", \"1\");");
    _builder.newLine();
    _builder.append("</script>");
    _builder.newLine();
    CharSequence _javaScriptDocumentStart = super.javaScriptDocumentStart();
    String _string = _javaScriptDocumentStart.toString();
    return (_builder.toString() + _string);
  }
  
  public CharSequence jsOnLoad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var feed = new google.feeds.Feed(\"http://xtextnews.blogspot.com/feeds/posts/default?orderby=published&foo=\"+new Date().getTime());");
    _builder.newLine();
    _builder.append("feed.load(function(result) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (!result.error) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var container = document.getElementById(\"feed\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var html = \'<h1>Latest News</h1><hr>\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (var i = 0; i < result.feed.entries.length; i++) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("var entry = result.feed.entries[i];");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("var div = document.createElement(\"div\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("div.appendChild(document.createTextNode(entry.title));");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("container.appendChild(div);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("var stringEntry = \'<div class=\"row\"><div class=\"span1\">&nbsp;</div><div class=\"span10\">\'");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("+ \'<h2>\'+entry.title+\' <small>published \'+new Date(entry.publishedDate).toDateString()+\' by \'+ entry.author+\'</small></h2>\'");
    _builder.newLine();
    _builder.append("\t        \t\t\t\t");
    _builder.append("+ \'<p>\' + entry.content+\'</p>\'");
    _builder.newLine();
    _builder.append("\t        \t\t\t\t");
    _builder.append("+ \'</div><div class=\"span1\">&nbsp;</div></div>\'");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("var html = html + stringEntry");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("container.innerHTML = html");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("});");
    _builder.newLine();
    CharSequence _jsOnLoad = super.jsOnLoad();
    String _string = _jsOnLoad.toString();
    return (_builder.toString() + _string);
  }
  
  public CharSequence contents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div id=\"header_wrapper\" class=\"container\" >");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("<div id=\"page\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"inner\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"container clearfix\" id=\"feed\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<h1>Loading Latest News...</h1>");
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

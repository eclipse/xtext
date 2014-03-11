package generator.xtend;

import generator.xtend.AbstractXtendWebsite;
import generator.xtend.Article;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Community extends AbstractXtendWebsite {
  public String path() {
    return "community.html";
  }
  
  public CharSequence contents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div id=\"page\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div id=\"team\" class=\"container clearfix\"> ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<h2>Resources</h2>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<hr>");
    _builder.newLine();
    _builder.append("\t\t");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("icon-discussions-blue.png");
    _builder_1.newLine();
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("Discussion Group");
    _builder_2.newLine();
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("https://groups.google.com/group/xtend-lang");
    _builder_3.newLine();
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("<p>The <strong>Xtend Google Group</strong> is the first source for getting answers in case you got stuck.");
    _builder_4.newLine();
    _builder_4.append("The community is very friendly. ");
    _builder_4.newLine();
    _builder_4.append("<br>Please ask any questions clearly and with sufficient information attached.</p>");
    _builder_4.newLine();
    CharSequence _entry = this.entry(_builder_1.toString(), _builder_2.toString(), _builder_3.toString(), _builder_4.toString());
    _builder.append(_entry, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("icon-bug-blue.png");
    _builder_5.newLine();
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("Found a Bug?");
    _builder_6.newLine();
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("https://bugs.eclipse.org/bugs/enter_bug.cgi?product=Xtend");
    _builder_7.newLine();
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("<p>Bug reports and enhancement request are tracked at <strong>bugs.eclipse.org</strong>. Please ");
    _builder_8.newLine();
    _builder_8.append("explain the problem and provide a reduced but reproducable eample.");
    _builder_8.newLine();
    _builder_8.append("Also please explain the concrete use case when requesting enhancements.</p>");
    _builder_8.newLine();
    CharSequence _entry_1 = this.entry(_builder_5.toString(), _builder_6.toString(), _builder_7.toString(), _builder_8.toString());
    _builder.append(_entry_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    StringConcatenation _builder_9 = new StringConcatenation();
    _builder_9.append("icon-twitter-blue.png");
    _builder_9.newLine();
    StringConcatenation _builder_10 = new StringConcatenation();
    _builder_10.append("Xtend on Twitter");
    _builder_10.newLine();
    StringConcatenation _builder_11 = new StringConcatenation();
    _builder_11.append("https://twitter.com/#!/xtendlang");
    _builder_11.newLine();
    StringConcatenation _builder_12 = new StringConcatenation();
    _builder_12.append("<p>If you are on twitter and want to get notified about all things Xtend, you should consider following <strong>@xtendlang</strong>.</p>");
    _builder_12.newLine();
    CharSequence _entry_2 = this.entry(_builder_9.toString(), _builder_10.toString(), _builder_11.toString(), _builder_12.toString());
    _builder.append(_entry_2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    StringConcatenation _builder_13 = new StringConcatenation();
    _builder_13.append("icon-google-blue.png");
    _builder_13.newLine();
    StringConcatenation _builder_14 = new StringConcatenation();
    _builder_14.append("Xtend on Google +");
    _builder_14.newLine();
    StringConcatenation _builder_15 = new StringConcatenation();
    _builder_15.append("https://plus.google.com/108502071045096808067/posts");
    _builder_15.newLine();
    StringConcatenation _builder_16 = new StringConcatenation();
    _builder_16.append("<p>If you don\'t like Twitter but are on Google +. You might want to add Xtend to one of your circles.</p>");
    _builder_16.newLine();
    CharSequence _entry_3 = this.entry(_builder_13.toString(), _builder_14.toString(), _builder_15.toString(), _builder_16.toString());
    _builder.append(_entry_3, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<br/><br/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<br/><br/>");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _printArticles = this.printArticles();
    _builder.append(_printArticles, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence printArticles() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div id=\"team\" class=\"container clearfix\"> ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<h2>Articles and Blog Posts</h2>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<hr>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"span1\">&nbsp;</div>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"span9\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<table class=\"table table-striped\">");
    _builder.newLine();
    _builder.append("\t\t");
    final Procedure1<Article> _function = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setArticle("Extending Java - Xtend a New Language for Java Developers");
        it.setHref("http://pragprog.com/magazines/2011-12/extending-java");
        it.setImg("http://a.pragprog.com/magazines/2011-12/images/iStock_000016728269Small__lz3rv0__.jpg");
      }
    };
    final Procedure1<Article> _function_1 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("JavaFX & Xtend - A Perfect Match");
        it.setHref("http://tomsondev.bestsolution.at/2012/04/11/javafx-xtend-a-perfect-match/");
      }
    };
    final Procedure1<Article> _function_2 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("JavaFX & Xtend - A Sensational Perfect Match");
        it.setHref("http://tomsondev.bestsolution.at/2012/04/11/javafx-xtend-a-sensational-perfect-match/");
      }
    };
    final Procedure1<Article> _function_3 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("JavaFX & Xtend - An Ongoing Love");
        it.setHref("http://tomsondev.bestsolution.at/2012/05/29/javafx-xtend-an-ongoing-love/");
      }
    };
    final Procedure1<Article> _function_4 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Xtend, JavaFX-Properties and Operator Overloading");
        it.setHref("http://tomsondev.bestsolution.at/2012/06/19/xtend-javafx-properties-and-operator-overloading/");
      }
    };
    final Procedure1<Article> _function_5 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Building SWT User Interfaces with Xtend");
        it.setHref("http://blog.moritz.eysholdt.de/2011/12/building-swt-user-interfaces-with-xtend.html");
      }
    };
    final Procedure1<Article> _function_6 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Vert.x & Xtend");
        it.setHref("http://blog.efftinge.de/2012/06/vertx-and-xtend.html");
      }
    };
    final Procedure1<Article> _function_7 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Distance / Time = Speed - A Post on Operator Overloading in Xtend");
        it.setHref("http://blog.efftinge.de/2012/05/distance-time-speed.html");
      }
    };
    final Procedure1<Article> _function_8 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Xtend Example Screencasts");
        it.setHref("http://blog.efftinge.de/2012/04/xtend-examples-used-at-eclipsecon-2012.html");
      }
    };
    final Procedure1<Article> _function_9 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Working With Distances using Xtend (Operator Overloading Applied)");
        it.setHref("http://blog.efftinge.de/2012/04/xtend-example-working-with-distances.html");
      }
    };
    final Procedure1<Article> _function_10 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("I Like Free Beer (99 Bottles in Xtend)");
        it.setHref("http://blog.efftinge.de/2012/01/i-like-free-beer.html");
      }
    };
    final Procedure1<Article> _function_11 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Groovy, Scala, Java, Xtend - A Stupid Comparism");
        it.setHref("http://blog.efftinge.de/2011/12/groovy-scala-java-xtend-stupid.html");
      }
    };
    final Procedure1<Article> _function_12 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Groovy, Scala, Java, Xtend - An UPDATED Stupid Comparism");
        it.setHref("http://blog.efftinge.de/2011/12/groovy-scala-java-xtend-updated-stupid.html");
      }
    };
    final Procedure1<Article> _function_13 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Writing Android Apps with Xtend");
        it.setHref("http://blog.efftinge.de/2011/12/writing-android-uis-with-xtend.html");
      }
    };
    final Procedure1<Article> _function_14 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("What\'s so special about Xtend\'s extension methods");
        it.setHref("http://blog.efftinge.de/2011/11/whats-so-special-about-xtends-extension.html");
      }
    };
    final Procedure1<Article> _function_15 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Xtend - Type-safe Groovy-style Builder APIs");
        it.setHref("http://blog.efftinge.de/2011/10/xtend-21-type-safe-groovy-style-builder.html");
      }
    };
    final Procedure1<Article> _function_16 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setArticle("Xtend - eine Sprache für Java Entwickler (German)");
        it.setHref("http://it-republik.de/jaxenter/artikel/Codegenerierung-mit-Eclipse-Xtend-4186.html");
      }
    };
    List<Article> _articles = this.articles(_function, _function_1, _function_2, _function_3, _function_4, _function_5, _function_6, _function_7, _function_8, _function_9, _function_10, _function_11, _function_12, _function_13, _function_14, _function_15, _function_16);
    final Function1<Article, CharSequence> _function_17 = new Function1<Article, CharSequence>() {
      public CharSequence apply(final Article it) {
        return Community.this.printArticle(it);
      }
    };
    List<CharSequence> _map = ListExtensions.<Article, CharSequence>map(_articles, _function_17);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</table>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"span1\">&nbsp;</div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence printArticle(final Article it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<tr><td>");
    {
      boolean _isArticle = it.isArticle();
      if (_isArticle) {
        _builder.append("Article: ");
      } else {
        _builder.append("Blog: ");
      }
    }
    _builder.append("</td><td><h2><a href=\"");
    String _href = it.getHref();
    _builder.append(_href, "");
    _builder.append("\">");
    String _title = it.getTitle();
    _builder.append(_title, "");
    _builder.append("</a></h2></td></tr>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence entry(final String img, final String title, final String link, final String description) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"span1\">&nbsp;</div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"span9 team\">");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<a href=\"");
    String _trim = link.trim();
    _builder.append(_trim, "    ");
    _builder.append("\" class=\"anchor-in-div\"></a>");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<div class=\"span4 \">");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<img src=\"images/");
    String _trim_1 = img.trim();
    _builder.append(_trim_1, "\t    ");
    _builder.append("\" alt=\"image\" class=\"image_left\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t    ");
    _builder.append("<h3 style=\"padding-top: 0px; margin-top: 0px;\">");
    String _trim_2 = title.trim();
    _builder.append(_trim_2, "\t    ");
    _builder.append("</h3>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t \t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"span5 \">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(description, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<div class=\"span1\">&nbsp;</div>");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
  
  public List<Article> articles(final Procedure1<? super Article>... articles) {
    final Function1<Procedure1<? super Article>, Article> _function = new Function1<Procedure1<? super Article>, Article>() {
      public Article apply(final Procedure1<? super Article> f) {
        Article _article = new Article();
        final Procedure1<Article> _function = new Procedure1<Article>() {
          public void apply(final Article it) {
            f.apply(it);
          }
        };
        return ObjectExtensions.<Article>operator_doubleArrow(_article, _function);
      }
    };
    return ListExtensions.<Procedure1<? super Article>, Article>map(((List<Procedure1<? super Article>>)Conversions.doWrapArray(articles)), _function);
  }
}

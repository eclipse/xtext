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
    _builder.append("\t");
    _builder.append("<!--Container-->");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div id=\"header_wrapper\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"container\"> ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"flexslider image-slider\">");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<div class=\"span5 team\">");
    _builder.newLine();
    _builder.append("\t\t\t  ");
    _builder.append("<a href=\"https://groups.google.com/group/xtend-lang\" class=\"anchor-in-div\" title=\"The <strong>Xtend Google Group</strong> is the first source for getting answers in case you got stuck. The community is very friendly. Please ask any questions clearly and with sufficient information attached.\"></a>");
    _builder.newLine();
    _builder.append("\t\t\t  ");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("<div class=\"span1\">");
    _builder.newLine();
    _builder.append("\t\t\t      ");
    _builder.append("<img src=\"images/icon-discussions-blue.png\" alt=\"image\" class=\"image_left\">");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("<div class=\"span4\">");
    _builder.newLine();
    _builder.append("\t\t\t      ");
    _builder.append("<h3 >Discussion Group</h3>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<p></p>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t  ");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<div class=\"span5 team\">");
    _builder.newLine();
    _builder.append("\t\t\t\t ");
    _builder.append("<a href=\"https://bugs.eclipse.org/bugs/enter_bug.cgi?product=Xtend\" class=\"anchor-in-div\" title=\"Bug reports and enhancement request are tracked at <strong>bugs.eclipse.org</strong>. Please explain the problem and provide a reduced but reproducable eample. Also please explain the concrete use case when requesting enhancements.\"></a>");
    _builder.newLine();
    _builder.append("\t\t\t\t ");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t\t\t\t    ");
    _builder.append("<div class=\"span1\">");
    _builder.newLine();
    _builder.append("\t\t\t\t      ");
    _builder.append("<img src=\"images/icon-bug-blue.png\" alt=\"image\" class=\"image_left\">");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</div>\t\t ");
    _builder.newLine();
    _builder.append("\t\t\t\t    ");
    _builder.append("<div class=\"span4\">");
    _builder.newLine();
    _builder.append("\t\t\t\t      ");
    _builder.append("<h3 >Found a Bug?</h3>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<div class=\"span5 team\">");
    _builder.newLine();
    _builder.append("\t\t\t  ");
    _builder.append("<a href=\"https://twitter.com/#!/xtendlang\" class=\"anchor-in-div\" title=\"If you are on twitter and want to get notified about all things Xtend, you should consider following @xtendlang.\"></a>");
    _builder.newLine();
    _builder.append("\t\t\t  ");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("<div class=\"span1\">");
    _builder.newLine();
    _builder.append("\t\t\t      ");
    _builder.append("<img src=\"images/icon-twitter-blue.png\" alt=\"image\" class=\"image_left\">");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("<div class=\"span4\">");
    _builder.newLine();
    _builder.append("\t\t\t      ");
    _builder.append("<h3 >Xtend on Twitter</h3>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t  ");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<div class=\"span5 team\">");
    _builder.newLine();
    _builder.append("\t\t\t\t ");
    _builder.append("<a href=\"https://plus.google.com/108502071045096808067/posts\" class=\"anchor-in-div\" title=\"If you don\'t like Twitter but are on Google+. You might want to add Xtend to one of your circles.\"></a>");
    _builder.newLine();
    _builder.append("\t\t\t\t ");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t\t\t\t    ");
    _builder.append("<div class=\"span1\">");
    _builder.newLine();
    _builder.append("\t\t\t\t      ");
    _builder.append("<img src=\"images/icon-google-blue.png\" alt=\"image\" class=\"image_left\">");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</div>\t\t ");
    _builder.newLine();
    _builder.append("\t\t\t\t    ");
    _builder.append("<div class=\"span4\">");
    _builder.newLine();
    _builder.append("\t\t\t\t      ");
    _builder.append("<h3 >Xtend on Google+</h3>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t  ");
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
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div>");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("<div class=\"inner\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _printVideos = this.printVideos();
    _builder.append(_printVideos, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t  ");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div>");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("<div class=\"inner\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _printArticles = this.printArticles();
    _builder.append(_printArticles, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t  ");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence printVideos() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div id=\"team\" class=\"container clearfix\"> ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<h2>Videos of Presentations</h2>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<hr>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"span10\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<table class=\"table table-striped\">");
    _builder.newLine();
    _builder.append("\t\t");
    final Procedure1<Article> _function = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setVideo("Eclipse Xtend: A Language Made for Java Developers (JDK.IO 2014, Kobenhavn)");
        it.setHref("http://jdk.io/index.php/program/enterprise-java/20-xtend-in-action");
      }
    };
    final Procedure1<Article> _function_1 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setVideo("Xtend in Action (Devoxx 2013)");
        it.setHref("http://parleys.com/play/5297729ae4b039ad2298c9b5/chapter0/about");
      }
    };
    final Procedure1<Article> _function_2 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setVideo("Eclipse Xtend: A Language Made for Java Developers (JavaOne 2012, SF)");
        it.setHref("https://www.youtube.com/watch?v=EzH5MPd13iI");
      }
    };
    final Procedure1<Article> _function_3 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setVideo("Eclipse Xtend: A Language Made for Java Developers (Skills Matter 2012, London)");
        it.setHref("https://skillsmatter.com/skillscasts/2917-xtend-xtest");
      }
    };
    List<Article> _articles = this.articles(_function, _function_1, _function_2, _function_3);
    final Function1<Article, CharSequence> _function_4 = new Function1<Article, CharSequence>() {
      public CharSequence apply(final Article it) {
        return Community.this.printArticle(it);
      }
    };
    List<CharSequence> _map = ListExtensions.<Article, CharSequence>map(_articles, _function_4);
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
    _builder.append("<div class=\"span10\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<table class=\"table table-striped\">");
    _builder.newLine();
    _builder.append("\t\t");
    final Procedure1<Article> _function = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Android Development has its own Swift");
        it.setHref("http://blog.futurice.com/android-development-has-its-own-swift");
      }
    };
    final Procedure1<Article> _function_1 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Xtend, the Gentle and Functional Java");
        it.setHref("http://the-dusty-deck.blogspot.de/2014/06/xtend-gentle-and-functional-java.html");
      }
    };
    final Procedure1<Article> _function_2 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Android and Xtend");
        it.setHref("http://www.infoq.com/articles/unusual-ways-to-create-a-mobile-app");
      }
    };
    final Procedure1<Article> _function_3 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("20 Facts about Xtend");
        it.setHref("http://jnario.org/org/jnario/jnario/documentation/20FactsAboutXtendSpec.html");
      }
    };
    final Procedure1<Article> _function_4 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("5 things that make Xtend a great language");
        it.setHref("http://sebastianbenz.de/5-Things-that-make-Xtend-a-great-Language-for-Java-developers");
      }
    };
    final Procedure1<Article> _function_5 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Building Vaadin UIs with Xtend");
        it.setHref("http://www.javacodegeeks.com/2013/02/building-vaadin-ui-with-xtend.html");
      }
    };
    final Procedure1<Article> _function_6 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Java 8 vs. Xtend");
        it.setHref("http://blog.efftinge.de/2012/12/java-8-vs-xtend.html");
      }
    };
    final Procedure1<Article> _function_7 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("A better Java: Scala or Xtend");
        it.setHref("http://duncan.mac-vicar.com/2012/09/30/a-better-java-scala-or-xtend/");
      }
    };
    final Procedure1<Article> _function_8 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("RxJava and Xtend");
        it.setHref("http://mnmlst-dvlpr.blogspot.de/2014/07/rxjava-and-xtend.html");
      }
    };
    final Procedure1<Article> _function_9 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("The Software Life: First Impressions of Xtend");
        it.setHref("http://mnmlst-dvlpr.blogspot.de/2014/07/rxjava-and-xtend.html");
      }
    };
    final Procedure1<Article> _function_10 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setArticle("Extending Java - Xtend a New Language for Java Developers");
        it.setHref("http://pragprog.com/magazines/2011-12/extending-java");
        it.setImg("http://a.pragprog.com/magazines/2011-12/images/iStock_000016728269Small__lz3rv0__.jpg");
      }
    };
    final Procedure1<Article> _function_11 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("JavaFX & Xtend - A Perfect Match");
        it.setHref("http://tomsondev.bestsolution.at/2012/04/11/javafx-xtend-a-perfect-match/");
      }
    };
    final Procedure1<Article> _function_12 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("JavaFX & Xtend - A Sensational Perfect Match");
        it.setHref("http://tomsondev.bestsolution.at/2012/04/11/javafx-xtend-a-sensational-perfect-match/");
      }
    };
    final Procedure1<Article> _function_13 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("JavaFX & Xtend - An Ongoing Love");
        it.setHref("http://tomsondev.bestsolution.at/2012/05/29/javafx-xtend-an-ongoing-love/");
      }
    };
    final Procedure1<Article> _function_14 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Xtend, JavaFX-Properties and Operator Overloading");
        it.setHref("http://tomsondev.bestsolution.at/2012/06/19/xtend-javafx-properties-and-operator-overloading/");
      }
    };
    final Procedure1<Article> _function_15 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Building SWT User Interfaces with Xtend");
        it.setHref("http://blog.moritz.eysholdt.de/2011/12/building-swt-user-interfaces-with-xtend.html");
      }
    };
    final Procedure1<Article> _function_16 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Vert.x & Xtend");
        it.setHref("http://blog.efftinge.de/2012/06/vertx-and-xtend.html");
      }
    };
    final Procedure1<Article> _function_17 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Distance / Time = Speed - A Post on Operator Overloading in Xtend");
        it.setHref("http://blog.efftinge.de/2012/05/distance-time-speed.html");
      }
    };
    final Procedure1<Article> _function_18 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Xtend Example Screencasts");
        it.setHref("http://blog.efftinge.de/2012/04/xtend-examples-used-at-eclipsecon-2012.html");
      }
    };
    final Procedure1<Article> _function_19 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Working With Distances using Xtend (Operator Overloading Applied)");
        it.setHref("http://blog.efftinge.de/2012/04/xtend-example-working-with-distances.html");
      }
    };
    final Procedure1<Article> _function_20 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("I Like Free Beer (99 Bottles in Xtend)");
        it.setHref("http://blog.efftinge.de/2012/01/i-like-free-beer.html");
      }
    };
    final Procedure1<Article> _function_21 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Groovy, Scala, Java, Xtend - A Stupid Comparism");
        it.setHref("http://blog.efftinge.de/2011/12/groovy-scala-java-xtend-stupid.html");
      }
    };
    final Procedure1<Article> _function_22 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Groovy, Scala, Java, Xtend - An UPDATED Stupid Comparism");
        it.setHref("http://blog.efftinge.de/2011/12/groovy-scala-java-xtend-updated-stupid.html");
      }
    };
    final Procedure1<Article> _function_23 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Writing Android Apps with Xtend");
        it.setHref("http://blog.efftinge.de/2011/12/writing-android-uis-with-xtend.html");
      }
    };
    final Procedure1<Article> _function_24 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("What\'s so special about Xtend\'s extension methods");
        it.setHref("http://blog.efftinge.de/2011/11/whats-so-special-about-xtends-extension.html");
      }
    };
    final Procedure1<Article> _function_25 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setBlog("Xtend - Type-safe Groovy-style Builder APIs");
        it.setHref("http://blog.efftinge.de/2011/10/xtend-21-type-safe-groovy-style-builder.html");
      }
    };
    final Procedure1<Article> _function_26 = new Procedure1<Article>() {
      public void apply(final Article it) {
        it.setArticle("Xtend - eine Sprache für Java Entwickler (German)");
        it.setHref("http://it-republik.de/jaxenter/artikel/Codegenerierung-mit-Eclipse-Xtend-4186.html");
      }
    };
    List<Article> _articles = this.articles(_function, _function_1, _function_2, _function_3, _function_4, _function_5, _function_6, _function_7, _function_8, _function_9, _function_10, _function_11, _function_12, _function_13, _function_14, _function_15, _function_16, _function_17, _function_18, _function_19, _function_20, _function_21, _function_22, _function_23, _function_24, _function_25, _function_26);
    final Function1<Article, CharSequence> _function_27 = new Function1<Article, CharSequence>() {
      public CharSequence apply(final Article it) {
        return Community.this.printArticle(it);
      }
    };
    List<CharSequence> _map = ListExtensions.<Article, CharSequence>map(_articles, _function_27);
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
    Article.Kind _kind = it.getKind();
    _builder.append(_kind, "");
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

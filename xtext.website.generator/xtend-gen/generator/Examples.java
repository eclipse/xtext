package generator;

import bootstrap.Body;
import bootstrap.HtmlExtensions;
import bootstrap.XdocExtensions;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import generator.Documentation;
import generator.ExampleSetup;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xdoc.XdocStandaloneSetup;
import org.eclipse.xtext.xdoc.xdoc.Chapter;
import org.eclipse.xtext.xdoc.xdoc.Document;
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup;

@SuppressWarnings("all")
public class Examples extends Documentation {
  @Inject
  private Body _body;
  
  @Inject
  private XdocExtensions _xdocExtensions;
  
  @Inject
  private HtmlExtensions _htmlExtensions;
  
  public XdocStandaloneSetup getStandaloneSetup() {
    ExampleSetup _exampleSetup = new ExampleSetup();
    return _exampleSetup;
  }
  
  public String getXdocDocumentRootFolder() {
    return "../docs/org.xtext.sevenlanguages.doc.xdoc/xdoc";
  }
  
  public String path() {
    return "examples.html";
  }
  
  public CharSequence navBar() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!-- Navbar -->");
    _builder.newLine();
    _builder.append("<div class=\"navbar navbar-fixed-top\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("style=\"border-bottom: 1px solid #000;\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"navbar-inner\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"container\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<a class=\"btn btn-navbar\" data-toggle=\"collapse\"");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("data-target=\".nav-collapse\"> <span class=\"icon-bar\"></span> <span");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("class=\"icon-bar\"></span> <span class=\"icon-bar\"></span>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</a> <a class=\"brand\" href=\"index.html\"></a>");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<div class=\"nav-collapse collapse\" style=\"height: 0px;\">");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<ul class=\"nav\">");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<li ");
    {
      String _path = this.path();
      boolean _equals = Objects.equal(_path, "download.html");
      if (_equals) {
        _builder.append("class=\"active\"");
      }
    }
    _builder.append("><a href=\"download.html\">Download</a></li>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    CharSequence _navbarDropdown = this.navbarDropdown();
    _builder.append(_navbarDropdown, "					");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("<li ");
    {
      String _path_1 = this.path();
      boolean _equals_1 = Objects.equal(_path_1, "documentation.html");
      if (_equals_1) {
        _builder.append("class=\"active\"");
      }
    }
    _builder.append("><a href=\"documentation.html\">Documentation</a></li>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("<li ");
    {
      String _path_2 = this.path();
      boolean _equals_2 = Objects.equal(_path_2, "community.html");
      if (_equals_2) {
        _builder.append("class=\"active\"");
      }
    }
    _builder.append("><a href=\"community.html\">Community</a></li>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("<li><a href=\"http://www.eclipse.org\">Eclipse.org</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</ul>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<!--/.nav-collapse -->");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("<!-- Navbar End -->");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence navbarDropdown() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<li class=\"dropdown");
    {
      String _path = this.path();
      boolean _equals = Objects.equal(_path, "examples.html");
      if (_equals) {
        _builder.append(" active");
      }
    }
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<a href=\"examples.html\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Examples<b class=\"caret\"></b></a>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<ul class=\"dropdown-menu\">");
    _builder.newLine();
    {
      Document _document = this.getDocument();
      Iterable<Chapter> _allChapters = this._xdocExtensions.getAllChapters(_document);
      for(final Chapter chapter : _allChapters) {
        _builder.append("\t\t");
        _builder.append("<li><a href=\"#");
        String _href = this._htmlExtensions.href(chapter);
        _builder.append(_href, "		");
        _builder.append("\">");
        TextOrMarkup _title = chapter.getTitle();
        CharSequence _htmlText = this._htmlExtensions.toHtmlText(_title);
        _builder.append(_htmlText, "		");
        _builder.append("</a></li>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("</ul>");
    _builder.newLine();
    _builder.append("</li>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence contents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!--Container-->");
    _builder.newLine();
    _builder.append("<div id=\"header_wrapper\" class=\"container\" >");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"inner\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"container\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<div class=\"page-heading\"><h1>Documentation</h1></div>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</div> <!-- /.container -->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</div> <!-- /inner -->");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("<div id=\"page\">  ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"inner\">");
    _builder.newLine();
    _builder.append("\t\t");
    Document _document = this.getDocument();
    CharSequence _body = this._body.body(_document);
    _builder.append(_body, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
}

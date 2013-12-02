package bootstrap;

import bootstrap.HtmlExtensions;
import bootstrap.XdocExtensions;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xdoc.xdoc.AbstractSection;
import org.eclipse.xtext.xdoc.xdoc.Document;
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup;

@SuppressWarnings("all")
public class Menu {
  @Inject
  @Extension
  private XdocExtensions _xdocExtensions;
  
  @Inject
  @Extension
  private HtmlExtensions _htmlExtensions;
  
  public CharSequence menu(final Document document) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div class=\"navbar navbar-fixed-top\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"navbar-inner\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"container\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\">");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<span class=\"icon-bar\"></span>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<span class=\"icon-bar\"></span>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<span class=\"icon-bar\"></span>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</a>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<a class=\"brand\" href=\"http://www.xtend-lang.org\">Xtend</a>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<ul class=\"nav\">");
    _builder.newLine();
    {
      Iterable<? extends AbstractSection> _sections = this._xdocExtensions.getSections(document);
      for(final AbstractSection s : _sections) {
        {
          Iterable<? extends AbstractSection> _sections_1 = this._xdocExtensions.getSections(s);
          int _size = IterableExtensions.size(_sections_1);
          boolean _lessEqualsThan = (_size <= 1);
          if (_lessEqualsThan) {
            _builder.append("\t\t\t\t");
            _builder.append("<li><a href=\"");
            String _href = this._htmlExtensions.href(s);
            _builder.append(_href, "\t\t\t\t");
            _builder.append("\">");
            TextOrMarkup _title = s.getTitle();
            CharSequence _htmlText = this._htmlExtensions.toHtmlText(_title);
            _builder.append(_htmlText, "\t\t\t\t");
            _builder.append("</a></li>");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t\t\t\t");
            _builder.append("<li class=\"dropdown\">");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append("<a class=\"dropdown-toggle\" data-toggle=\"dropdown\">");
            TextOrMarkup _title_1 = s.getTitle();
            CharSequence _htmlText_1 = this._htmlExtensions.toHtmlText(_title_1);
            _builder.append(_htmlText_1, "\t\t\t\t\t");
            _builder.append(" <b class=\"caret\"></b></a>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append("<ul class=\"dropdown-menu\">");
            _builder.newLine();
            {
              Iterable<? extends AbstractSection> _sections_2 = this._xdocExtensions.getSections(s);
              for(final AbstractSection subSection : _sections_2) {
                _builder.append("\t\t\t\t");
                _builder.append("\t\t");
                _builder.append("<li><a href=\"");
                String _href_1 = this._htmlExtensions.href(subSection);
                _builder.append(_href_1, "\t\t\t\t\t\t");
                _builder.append("\">");
                TextOrMarkup _title_2 = subSection.getTitle();
                CharSequence _htmlText_2 = this._htmlExtensions.toHtmlText(_title_2);
                _builder.append(_htmlText_2, "\t\t\t\t\t\t");
                _builder.append("</a></li>");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append("</ul>");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("</li>");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.append("</ul>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<ul class=\"nav pull-right\">");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<li><a href=\"http://www.eclipse.org\">Eclipse.org</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</ul>\t");
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

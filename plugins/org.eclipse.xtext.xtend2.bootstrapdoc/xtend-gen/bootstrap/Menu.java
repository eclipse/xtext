package bootstrap;

import bootstrap.HtmlExtensions;
import bootstrap.XdocExtensions;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xdoc.xdoc.AbstractSection;
import org.eclipse.xtext.xdoc.xdoc.Document;
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup;

@SuppressWarnings("all")
public class Menu {
  @Inject
  private XdocExtensions _xdocExtensions;
  
  @Inject
  private HtmlExtensions _htmlExtensions;
  
  public CharSequence menu(final Document document) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div class=\"topbar\" data-dropdown=\"dropdown\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"fill\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"container\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<a class=\"brand\" href=\"http://xtend-lang.org\">Xtend</a>");
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
          boolean _operator_lessEqualsThan = IntegerExtensions.operator_lessEqualsThan(_size, 1);
          if (_operator_lessEqualsThan) {
            _builder.append("\t\t\t\t");
            _builder.append("<li><a href=\"#");
            String _href = this._htmlExtensions.href(s);
            _builder.append(_href, "				");
            _builder.append("\">");
            TextOrMarkup _title = s.getTitle();
            CharSequence _html = this._htmlExtensions.toHtml(_title);
            _builder.append(_html, "				");
            _builder.append("</a></li>");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t\t\t\t");
            _builder.append("<li class=\"dropdown\">");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append("<a href=\"#");
            String _href_1 = this._htmlExtensions.href(s);
            _builder.append(_href_1, "					");
            _builder.append("\" class=\"dropdown-toggle\">");
            TextOrMarkup _title_1 = s.getTitle();
            CharSequence _html_1 = this._htmlExtensions.toHtml(_title_1);
            _builder.append(_html_1, "					");
            _builder.append("</a>");
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
                _builder.append("<li><a href=\"#");
                String _href_2 = this._htmlExtensions.href(subSection);
                _builder.append(_href_2, "						");
                _builder.append("\">");
                TextOrMarkup _title_2 = subSection.getTitle();
                CharSequence _html_2 = this._htmlExtensions.toHtml(_title_2);
                _builder.append(_html_2, "						");
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
    _builder.append("\t\t\t\t");
    _builder.append("<li><a href=\"http://www.eclipse.org\">Eclipse.org</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</ul>");
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

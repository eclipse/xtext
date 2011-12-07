package bootstrap;

import bootstrap.XdocExtensions;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xdoc.xdoc.AbstractSection;
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup;
import org.eclipse.xtext.xdoc.xdoc.XdocFile;

@SuppressWarnings("all")
public class Menu {
  @Inject
  private XdocExtensions _xdocExtensions;
  
  public CharSequence menu(final XdocFile file) {
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
      AbstractSection _mainSection = file.getMainSection();
      Iterable<? extends AbstractSection> _sections = this._xdocExtensions.getSections(_mainSection);
      for(final AbstractSection s : _sections) {
        {
          Iterable<? extends AbstractSection> _sections_1 = this._xdocExtensions.getSections(s);
          boolean _isEmpty = IterableExtensions.isEmpty(_sections_1);
          if (_isEmpty) {
            _builder.append("\t\t\t\t");
            _builder.append("<li><a href=\"#");
            String _id = this._xdocExtensions.id(s);
            _builder.append(_id, "				");
            _builder.append("\">");
            TextOrMarkup _title = s.getTitle();
            _builder.append(_title, "				");
            _builder.append("</a></li>");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t\t\t\t");
            _builder.append("<li class=\"dropdown\">");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append("<a href=\"#");
            String _id_1 = this._xdocExtensions.id(s);
            _builder.append(_id_1, "					");
            _builder.append("\">");
            TextOrMarkup _title_1 = s.getTitle();
            _builder.append(_title_1, "					");
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
                String _id_2 = this._xdocExtensions.id(subSection);
                _builder.append(_id_2, "						");
                _builder.append("\">");
                TextOrMarkup _title_2 = subSection.getTitle();
                _builder.append(_title_2, "						");
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

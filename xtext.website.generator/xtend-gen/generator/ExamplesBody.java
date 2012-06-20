package generator;

import bootstrap.Body;
import bootstrap.HtmlExtensions;
import bootstrap.XdocExtensions;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xdoc.xdoc.AbstractSection;
import org.eclipse.xtext.xdoc.xdoc.Chapter;
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup;

@SuppressWarnings("all")
public class ExamplesBody extends Body {
  @Inject
  private XdocExtensions _xdocExtensions;
  
  @Inject
  private HtmlExtensions _htmlExtensions;
  
  public CharSequence h1(final Chapter chapter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!-- chapter -->");
    _builder.newLine();
    _builder.append("<section id=\"");
    String _href = this._htmlExtensions.href(chapter);
    _builder.append(_href, "");
    _builder.append("\" style=\"padding-top: 68px; margin-top: -68px;\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"span10 offset1\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<h1>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    TextOrMarkup _title = chapter.getTitle();
    CharSequence _html = this._htmlExtensions.toHtml(_title);
    _builder.append(_html, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("</h1>");
    _builder.newLine();
    {
      EList<TextOrMarkup> _contents = chapter.getContents();
      for(final TextOrMarkup content : _contents) {
        _builder.append("\t\t\t");
        CharSequence _html_1 = this._htmlExtensions.toHtml(content);
        _builder.append(_html_1, "			");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Iterable<? extends AbstractSection> _sections = this._xdocExtensions.getSections(chapter);
      for(final AbstractSection section : _sections) {
        _builder.append("\t\t\t");
        CharSequence _h2 = this.h2(section);
        _builder.append(_h2, "			");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("</section>");
    _builder.newLine();
    return _builder;
  }
}

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
public class DocumentationBody extends Body {
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
    _builder.append("\" style=\"margin-bottom: 50px\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"span8 offset3\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<h1>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    TextOrMarkup _title = chapter.getTitle();
    CharSequence _htmlText = this._htmlExtensions.toHtmlText(_title);
    _builder.append(_htmlText, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("</h1>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<hr style=\"margin-top: 5px; margin-bottom: 5px;\">");
    _builder.newLine();
    {
      EList<TextOrMarkup> _contents = chapter.getContents();
      for(final TextOrMarkup content : _contents) {
        _builder.append("\t\t\t");
        CharSequence _htmlParagraph = this._htmlExtensions.toHtmlParagraph(content);
        _builder.append(_htmlParagraph, "			");
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
  
  public CharSequence h2(final AbstractSection section) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!--  section -->");
    _builder.newLine();
    _builder.append("<section id=\"");
    String _href = this._htmlExtensions.href(section);
    _builder.append(_href, "");
    _builder.append("\" style=\"margin-top: 20px; padding-top: 0;\">");
    _builder.newLineIfNotEmpty();
    _builder.append("<h2>");
    TextOrMarkup _title = section.getTitle();
    CharSequence _htmlText = this._htmlExtensions.toHtmlText(_title);
    _builder.append(_htmlText, "");
    _builder.append("</h2>");
    _builder.newLineIfNotEmpty();
    {
      EList<TextOrMarkup> _contents = section.getContents();
      for(final TextOrMarkup content : _contents) {
        CharSequence _htmlParagraph = this._htmlExtensions.toHtmlParagraph(content);
        _builder.append(_htmlParagraph, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Iterable<? extends AbstractSection> _sections = this._xdocExtensions.getSections(section);
      for(final AbstractSection subsection : _sections) {
        CharSequence _h3plus = this.h3plus(subsection, 3);
        _builder.append(_h3plus, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</section>");
    _builder.newLine();
    return _builder;
  }
}

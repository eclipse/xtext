package generator;

import bootstrap.HtmlExtensions;
import bootstrap.XdocExtensions;
import com.google.inject.Inject;
import generator.DocumentationBody;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xdoc.xdoc.AbstractSection;
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup;

@SuppressWarnings("all")
public class ExamplesBody extends DocumentationBody {
  @Inject
  private XdocExtensions _xdocExtensions;
  
  @Inject
  private HtmlExtensions _htmlExtensions;
  
  public CharSequence h1(final AbstractSection section) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!-- chapter -->");
    _builder.newLine();
    _builder.append("<section id=\"");
    String _hrefId = this._htmlExtensions.hrefId(section);
    _builder.append(_hrefId, "");
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
    TextOrMarkup _title = section.getTitle();
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
      EList<TextOrMarkup> _contents = section.getContents();
      for(final TextOrMarkup content : _contents) {
        _builder.append("\t\t\t");
        CharSequence _htmlParagraph = content==null?(CharSequence)null:this._htmlExtensions.toHtmlParagraph(content);
        _builder.append(_htmlParagraph, "			");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Iterable<? extends AbstractSection> _sections = this._xdocExtensions.getSections(section);
      for(final AbstractSection subSection : _sections) {
        _builder.append("\t\t\t");
        CharSequence _h2 = this.h2(subSection);
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
  
  public CharSequence body(final AbstractSection rootSection) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div id=\"maincontainer\" class=\"container\">");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _h1 = this.h1(rootSection);
    _builder.append(_h1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
}

package bootstrap;

import bootstrap.HtmlExtensions;
import bootstrap.XdocExtensions;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xdoc.xdoc.AbstractSection;
import org.eclipse.xtext.xdoc.xdoc.Chapter;
import org.eclipse.xtext.xdoc.xdoc.Document;
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup;

@SuppressWarnings("all")
public class Body {
  @Inject
  private XdocExtensions _xdocExtensions;
  
  @Inject
  private HtmlExtensions _htmlExtensions;
  
  public CharSequence body(final Document document) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div id=\"maincontainer\" class=\"container\">");
    _builder.newLine();
    {
      EList<Chapter> _chapters = document.getChapters();
      for(final Chapter chapter : _chapters) {
        _builder.append("\t");
        AbstractSection _resolve = this._xdocExtensions.resolve(chapter);
        CharSequence _h1 = this.h1(((Chapter) _resolve));
        _builder.append(_h1, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence h1(final Chapter chapter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!-- chapter -->");
    _builder.newLine();
    _builder.append("<section id=\"");
    String _href = this._htmlExtensions.href(chapter);
    _builder.append(_href, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<div class=\"page-header\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<h1>");
    _builder.newLine();
    _builder.append("\t\t\t");
    TextOrMarkup _title = chapter.getTitle();
    CharSequence _html = this._htmlExtensions.toHtml(_title);
    _builder.append(_html, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("</h1>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"span12 offset2\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    EList<TextOrMarkup> _contents = chapter.getContents();
    CharSequence _htmlParagraph = this._htmlExtensions.toHtmlParagraph(_contents);
    _builder.append(_htmlParagraph, "			");
    _builder.newLineIfNotEmpty();
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
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("<h2>");
    TextOrMarkup _title = section.getTitle();
    CharSequence _html = this._htmlExtensions.toHtml(_title);
    _builder.append(_html, "");
    _builder.append("</h2>");
    _builder.newLineIfNotEmpty();
    EList<TextOrMarkup> _contents = section.getContents();
    CharSequence _htmlParagraph = this._htmlExtensions.toHtmlParagraph(_contents);
    _builder.append(_htmlParagraph, "");
    _builder.newLineIfNotEmpty();
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
  
  public CharSequence h3plus(final AbstractSection section, final int hLevel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!-- subsection -->");
    _builder.newLine();
    _builder.append("<section id=\"");
    String _href = this._htmlExtensions.href(section);
    _builder.append(_href, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("<h");
    _builder.append(hLevel, "");
    _builder.append(">");
    TextOrMarkup _title = section.getTitle();
    CharSequence _html = this._htmlExtensions.toHtml(_title);
    _builder.append(_html, "");
    _builder.append("</h");
    _builder.append(hLevel, "");
    _builder.append(">");
    _builder.newLineIfNotEmpty();
    EList<TextOrMarkup> _contents = section.getContents();
    CharSequence _htmlParagraph = this._htmlExtensions.toHtmlParagraph(_contents);
    _builder.append(_htmlParagraph, "");
    _builder.newLineIfNotEmpty();
    {
      Iterable<? extends AbstractSection> _sections = this._xdocExtensions.getSections(section);
      for(final AbstractSection subSection : _sections) {
        int _operator_plus = IntegerExtensions.operator_plus(hLevel, 1);
        CharSequence _h3plus = this.h3plus(subSection, _operator_plus);
        _builder.append(_h3plus, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</section>");
    _builder.newLine();
    return _builder;
  }
}

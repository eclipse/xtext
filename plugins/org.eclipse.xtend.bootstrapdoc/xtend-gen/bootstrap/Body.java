package bootstrap;

import bootstrap.HtmlExtensions;
import bootstrap.TargetPaths;
import bootstrap.XdocExtensions;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xdoc.xdoc.AbstractSection;
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup;

@SuppressWarnings("all")
public class Body {
  @Inject
  @Extension
  private XdocExtensions _xdocExtensions;
  
  @Inject
  @Extension
  private HtmlExtensions _htmlExtensions;
  
  @Inject
  @Extension
  private TargetPaths _targetPaths;
  
  public CharSequence body(final AbstractSection rootSection) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div id=\"maincontainer\" class=\"container\">");
    _builder.newLine();
    {
      Iterable<? extends AbstractSection> _sections = this._xdocExtensions.getSections(rootSection);
      final Function1<AbstractSection, Boolean> _function = new Function1<AbstractSection, Boolean>() {
        public Boolean apply(final AbstractSection it) {
          boolean _isTargetRootElement = Body.this._targetPaths.isTargetRootElement(it);
          return Boolean.valueOf((!_isTargetRootElement));
        }
      };
      Iterable<? extends AbstractSection> _filter = IterableExtensions.filter(_sections, _function);
      for(final AbstractSection chapter : _filter) {
        _builder.append("\t");
        CharSequence _h1 = this.h1(chapter);
        _builder.append(_h1, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
  
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
    _builder.append("<div class=\"span8 offset3\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<h1>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    TextOrMarkup _title = section.getTitle();
    CharSequence _htmlText = this._htmlExtensions.toHtmlText(_title);
    _builder.append(_htmlText, "\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("</h1>");
    _builder.newLine();
    {
      EList<TextOrMarkup> _contents = section.getContents();
      for(final TextOrMarkup content : _contents) {
        _builder.append("\t\t\t");
        CharSequence _htmlParagraph = this._htmlExtensions.toHtmlParagraph(content);
        _builder.append(_htmlParagraph, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Iterable<? extends AbstractSection> _sections = this._xdocExtensions.getSections(section);
      for(final AbstractSection subSection : _sections) {
        _builder.append("\t\t\t");
        CharSequence _h2 = this.h2(subSection);
        _builder.append(_h2, "\t\t\t");
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
    String _hrefId = this._htmlExtensions.hrefId(section);
    _builder.append(_hrefId, "");
    _builder.append("\" style=\"padding-top: 68px; margin-top: -68px;\">");
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
  
  public CharSequence h3plus(final AbstractSection section, final int hLevel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!-- subsection -->");
    _builder.newLine();
    _builder.append("<section id=\"");
    String _hrefId = this._htmlExtensions.hrefId(section);
    _builder.append(_hrefId, "");
    _builder.append("\" style=\"padding-top: 68px; margin-top: -68px;\">");
    _builder.newLineIfNotEmpty();
    _builder.append("<h");
    _builder.append(hLevel, "");
    _builder.append(">");
    TextOrMarkup _title = section.getTitle();
    CharSequence _htmlText = this._htmlExtensions.toHtmlText(_title);
    _builder.append(_htmlText, "");
    _builder.append("</h");
    _builder.append(hLevel, "");
    _builder.append(">");
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
      for(final AbstractSection subSection : _sections) {
        CharSequence _h3plus = this.h3plus(subSection, (hLevel + 1));
        _builder.append(_h3plus, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</section>");
    _builder.newLine();
    return _builder;
  }
}

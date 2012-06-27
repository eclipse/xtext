package generator;

import bootstrap.Body;
import bootstrap.HtmlExtensions;
import bootstrap.PostProcessor;
import bootstrap.TargetPaths;
import bootstrap.XdocExtensions;
import com.google.inject.Inject;
import generator.AbstractXdocBaseWebsite;
import generator.DocumentationSetup;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xdoc.XdocStandaloneSetup;
import org.eclipse.xtext.xdoc.xdoc.AbstractSection;
import org.eclipse.xtext.xdoc.xdoc.Document;
import org.eclipse.xtext.xdoc.xdoc.Part;
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup;

@SuppressWarnings("all")
public class DocumentationPage extends AbstractXdocBaseWebsite {
  @Inject
  private Body _body;
  
  @Inject
  private HtmlExtensions _htmlExtensions;
  
  @Inject
  private PostProcessor processor;
  
  @Inject
  private TargetPaths _targetPaths;
  
  @Inject
  private XdocExtensions _xdocExtensions;
  
  private final AbstractSection section;
  
  private final Document document;
  
  public DocumentationPage(final Document document, final AbstractSection section) {
    this.document = document;
    this.section = section;
  }
  
  public Document getDocument() {
    return this.document;
  }
  
  public XdocStandaloneSetup getStandaloneSetup() {
    DocumentationSetup _documentationSetup = new DocumentationSetup();
    return _documentationSetup;
  }
  
  public String path() {
    String _targetPath = this._targetPaths.getTargetPath(this.section);
    return _targetPath;
  }
  
  public CharSequence website() {
    CharSequence _website = super.website();
    String _postProcess = this.processor.postProcess(_website);
    return _postProcess;
  }
  
  public CharSequence contents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!--Container-->");
    _builder.newLine();
    _builder.append("<div id=\"header_wrapper\" class=\"container\">");
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
    _builder.append("\t");
    CharSequence _menu = this.menu(this.document);
    _builder.append(_menu, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("<div id=\"page\">  ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"inner\">");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _body = this._body.body(this.section);
    _builder.append(_body, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence menu(final Document doc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ul id=\"nav-outline\">");
    _builder.newLine();
    {
      EList<Part> _parts = doc.getParts();
      for(final Part part : _parts) {
        _builder.append("\t");
        _builder.append("<li>&nbsp;</li>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<li style=\"color : #333;\">");
        TextOrMarkup _title = part.getTitle();
        CharSequence _htmlText = this._htmlExtensions.toHtmlText(_title);
        _builder.append(_htmlText, "	");
        _builder.append("</li>");
        _builder.newLineIfNotEmpty();
        {
          Iterable<? extends AbstractSection> _sections = this._xdocExtensions.getSections(part);
          for(final AbstractSection chapter : _sections) {
            _builder.append("\t");
            _builder.append("<li><a href=\"");
            String _href = this._htmlExtensions.href(chapter);
            _builder.append(_href, "	");
            _builder.append("\">");
            TextOrMarkup _title_1 = chapter.getTitle();
            CharSequence _htmlText_1 = this._htmlExtensions.toHtmlText(_title_1);
            _builder.append(_htmlText_1, "	");
            _builder.append("</a>");
            _builder.newLineIfNotEmpty();
            {
              Iterable<? extends AbstractSection> _sections_1 = this._xdocExtensions.getSections(chapter);
              boolean _hasElements = false;
              for(final AbstractSection section : _sections_1) {
                if (!_hasElements) {
                  _hasElements = true;
                  _builder.append("<ul>", "	");
                }
                _builder.append("\t");
                _builder.append("<li><a href=\"");
                String _href_1 = this._htmlExtensions.href(section);
                _builder.append(_href_1, "	");
                _builder.append("\">");
                TextOrMarkup _title_2 = section.getTitle();
                CharSequence _htmlText_2 = this._htmlExtensions.toHtmlText(_title_2);
                _builder.append(_htmlText_2, "	");
                _builder.append("</a></li>");
                _builder.newLineIfNotEmpty();
              }
              if (_hasElements) {
                _builder.append("</ul>", "	");
              }
            }
            _builder.append("\t");
            _builder.append("</li>");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    CharSequence _additionalLinks = this.additionalLinks();
    _builder.append(_additionalLinks, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</ul>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence additionalLinks() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<li>&nbsp;</li>");
    _builder.newLine();
    _builder.append("<li style=\"color : #333;\">Additional Resources");
    _builder.newLine();
    _builder.append("<li><a href=\"documentation/2.3.0/Documentation.pdf\">Documentation <img src=\"images/pdf_icon.gif\"></a>");
    _builder.newLine();
    _builder.append("<li><a href=\"http://download.eclipse.org/modeling/tmf/xtext/javadoc/2.3/\">API Documentation (JavaDoc)</a>");
    _builder.newLine();
    return _builder;
  }
}

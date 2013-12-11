package generator.xtend;

import bootstrap.Body;
import bootstrap.HtmlExtensions;
import bootstrap.PostProcessor;
import com.google.common.collect.Iterators;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.google.inject.Inject;
import generator.xtend.AbstractXtendWebsite;
import generator.xtend.DocumentationSetup;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xdoc.XdocStandaloneSetup;
import org.eclipse.xtext.xdoc.xdoc.Chapter;
import org.eclipse.xtext.xdoc.xdoc.Document;
import org.eclipse.xtext.xdoc.xdoc.ImageRef;
import org.eclipse.xtext.xdoc.xdoc.Part;
import org.eclipse.xtext.xdoc.xdoc.Section;
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup;
import xdocgen.DocumentLoad;

@SuppressWarnings("all")
public class Documentation extends AbstractXtendWebsite {
  public Documentation() {
    String _xdocDocumentRootFolder = this.getXdocDocumentRootFolder();
    Document _loadDocument = this.docLoader.loadDocument(_xdocDocumentRootFolder);
    this.doc = _loadDocument;
  }
  
  public XdocStandaloneSetup getStandaloneSetup() {
    DocumentationSetup _documentationSetup = new DocumentationSetup();
    return _documentationSetup;
  }
  
  public String getXdocDocumentRootFolder() {
    return "../plugins/org.eclipse.xtend.doc.xdoc/xdoc";
  }
  
  public String path() {
    return "documentation.html";
  }
  
  protected boolean isPrettyPrint() {
    return true;
  }
  
  protected boolean isOutline() {
    return true;
  }
  
  protected boolean isPopover() {
    return false;
  }
  
  private final Document doc;
  
  @Inject
  private DocumentLoad docLoader;
  
  @Inject
  @Extension
  private Body _body;
  
  @Inject
  @Extension
  private HtmlExtensions _htmlExtensions;
  
  @Inject
  private PostProcessor processor;
  
  private final String currentVersion = "2.5.0";
  
  public CharSequence website() {
    CharSequence _website = super.website();
    String _postProcess = this.processor.postProcess(_website);
    return _postProcess;
  }
  
  public void generateTo(final File targetDir) {
    super.generateTo(targetDir);
    this.copyImages(this.doc, targetDir);
  }
  
  public void copyImages(final Document doc, final File targetDir) {
    Resource _eResource = doc.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    final TreeIterator<Object> iter = EcoreUtil.<Object>getAllContents(_resourceSet, true);
    Iterator<ImageRef> _filter = Iterators.<ImageRef>filter(iter, ImageRef.class);
    final Procedure1<ImageRef> _function = new Procedure1<ImageRef>() {
      public void apply(final ImageRef it) {
        try {
          Resource _eResource = it.eResource();
          URI _uRI = _eResource.getURI();
          URI _trimSegments = _uRI.trimSegments(1);
          String _fileString = _trimSegments.toFileString();
          String _path = it.getPath();
          File _file = new File(_fileString, _path);
          final File source = _file;
          boolean _exists = source.exists();
          boolean _not = (!_exists);
          if (_not) {
            String _canonicalPath = source.getCanonicalPath();
            String _plus = ("Referenced Image " + _canonicalPath);
            String _plus_1 = (_plus + " does not exist in ");
            Resource _eResource_1 = it.eResource();
            URI _uRI_1 = _eResource_1.getURI();
            String _lastSegment = _uRI_1.lastSegment();
            String _plus_2 = (_plus_1 + _lastSegment);
            String _plus_3 = (_plus_2 + " line ");
            ICompositeNode _node = NodeModelUtils.getNode(it);
            int _startLine = _node.getStartLine();
            String _plus_4 = (_plus_3 + Integer.valueOf(_startLine));
            IllegalStateException _illegalStateException = new IllegalStateException(_plus_4);
            throw _illegalStateException;
          }
          String _path_1 = it.getPath();
          File _file_1 = new File(targetDir, _path_1);
          final File target = _file_1;
          String _canonicalPath_1 = target.getCanonicalPath();
          InputOutput.<String>println(_canonicalPath_1);
          InputSupplier<FileInputStream> _newInputStreamSupplier = Files.newInputStreamSupplier(source);
          Files.copy(_newInputStreamSupplier, target);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    IteratorExtensions.<ImageRef>forEach(_filter, _function);
  }
  
  public CharSequence contents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!--Container-->");
    _builder.newLine();
    CharSequence _menu = this.menu(this.doc);
    _builder.append(_menu, "");
    _builder.newLineIfNotEmpty();
    _builder.append("<div id=\"page\">  ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"inner\">");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _body = this._body.body(this.doc);
    _builder.append(_body, "\t\t");
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
      EList<Chapter> _chapters = doc.getChapters();
      for(final Chapter chapter : _chapters) {
        _builder.append("\t");
        _builder.append("<li><a href=\"");
        String _href = this._htmlExtensions.href(chapter);
        _builder.append(_href, "\t");
        _builder.append("\">");
        TextOrMarkup _title = chapter.getTitle();
        CharSequence _htmlText = this._htmlExtensions.toHtmlText(_title);
        _builder.append(_htmlText, "\t");
        _builder.append("</a>");
        _builder.newLineIfNotEmpty();
        {
          EList<Section> _subSections = chapter.getSubSections();
          boolean _hasElements = false;
          for(final Section section : _subSections) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append("<ul>", "\t");
            }
            _builder.append("\t");
            _builder.append("<li><a href=\"");
            String _href_1 = this._htmlExtensions.href(section);
            _builder.append(_href_1, "\t");
            _builder.append("\">");
            TextOrMarkup _title_1 = section.getTitle();
            CharSequence _htmlText_1 = this._htmlExtensions.toHtmlText(_title_1);
            _builder.append(_htmlText_1, "\t");
            _builder.append("</a></li>");
            _builder.newLineIfNotEmpty();
          }
          if (_hasElements) {
            _builder.append("</ul>", "\t");
          }
        }
        _builder.append("\t");
        _builder.append("</li>");
        _builder.newLine();
      }
    }
    {
      EList<Part> _parts = doc.getParts();
      for(final Part part : _parts) {
        _builder.append("\t");
        _builder.append("<li>&nbsp;</li>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<li style=\"color : #333;\">");
        TextOrMarkup _title_2 = part.getTitle();
        CharSequence _htmlText_2 = this._htmlExtensions.toHtmlText(_title_2);
        _builder.append(_htmlText_2, "\t");
        _builder.append("</li>");
        _builder.newLineIfNotEmpty();
        {
          EList<Chapter> _chapters_1 = part.getChapters();
          for(final Chapter chapter_1 : _chapters_1) {
            _builder.append("\t");
            _builder.append("<li><a href=\"");
            String _href_2 = this._htmlExtensions.href(chapter_1);
            _builder.append(_href_2, "\t");
            _builder.append("\">");
            TextOrMarkup _title_3 = chapter_1.getTitle();
            CharSequence _htmlText_3 = this._htmlExtensions.toHtmlText(_title_3);
            _builder.append(_htmlText_3, "\t");
            _builder.append("</a>");
            _builder.newLineIfNotEmpty();
            {
              EList<Section> _subSections_1 = chapter_1.getSubSections();
              boolean _hasElements_1 = false;
              for(final Section section_1 : _subSections_1) {
                if (!_hasElements_1) {
                  _hasElements_1 = true;
                  _builder.append("<ul>", "\t");
                }
                _builder.append("\t");
                _builder.append("<li><a href=\"");
                String _href_3 = this._htmlExtensions.href(section_1);
                _builder.append(_href_3, "\t");
                _builder.append("\">");
                TextOrMarkup _title_4 = section_1.getTitle();
                CharSequence _htmlText_4 = this._htmlExtensions.toHtmlText(_title_4);
                _builder.append(_htmlText_4, "\t");
                _builder.append("</a></li>");
                _builder.newLineIfNotEmpty();
              }
              if (_hasElements_1) {
                _builder.append("</ul>", "\t");
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
    _builder.append("<li>&nbsp;</li>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<li style=\"color : #333;\">Additional Resources</li>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<li><a href=\"documentation/");
    _builder.append(this.currentVersion, "\t");
    _builder.append("/Xtend%20User%20Guide.pdf\">Documentation <img src=\"images/pdf_icon.gif\"></a>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<li><a href=\"api/");
    _builder.append(this.currentVersion, "\t");
    _builder.append("/index.html\">Runtime Library API</a>");
    _builder.newLineIfNotEmpty();
    _builder.append("</ul>");
    _builder.newLine();
    return _builder;
  }
}

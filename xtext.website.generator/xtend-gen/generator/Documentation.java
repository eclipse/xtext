package generator;

import bootstrap.Body;
import bootstrap.HtmlExtensions;
import bootstrap.PostProcessor;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.google.inject.Inject;
import com.google.inject.Injector;
import generator.AbstractWebsite;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
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
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
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
public class Documentation extends AbstractWebsite {
  public Documentation() {
    XdocStandaloneSetup _xdocStandaloneSetup = new XdocStandaloneSetup();
    final Injector injector = _xdocStandaloneSetup.createInjectorAndDoEMFRegistration();
    injector.injectMembers(this);
    Document _loadDocument = this.docLoader.loadDocument("/Users/efftinge/Workspaces/ws-xtext/org.eclipse.xtext/plugins/org.eclipse.xtext.doc.xdoc/xdoc");
    this.doc = _loadDocument;
  }
  
  public String path() {
    return "documentation.html";
  }
  
  private final Document doc;
  
  @Inject
  private DocumentLoad docLoader;
  
  @Inject
  private Body _body;
  
  @Inject
  private HtmlExtensions _htmlExtensions;
  
  @Inject
  private PostProcessor processor;
  
  public CharSequence website() {
    CharSequence _website = super.website();
    String _postProcess = this.processor.postProcess(_website);
    return _postProcess;
  }
  
  public void generateTo(final File targetDir) {
    super.generateTo(targetDir);
  }
  
  public void copyImages(final Document doc, final File targetDir) {
    Resource _eResource = doc.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    final TreeIterator<?> iter = EcoreUtil.getAllContents(_resourceSet, true);
    Iterator<ImageRef> _filter = Iterators.<ImageRef>filter(iter, ImageRef.class);
    final Procedure1<ImageRef> _function = new Procedure1<ImageRef>() {
        public void apply(final ImageRef it) {
          try {
            Resource _eResource = it.eResource();
            URI _uRI = _eResource.getURI();
            String _fileString = _uRI.toFileString();
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
          } catch (Exception _e) {
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
    _builder.append("<div id=\"header_wrapper\" class=\"container\" >");
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
    _builder.append("</div>");
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
    _builder.append("<div id=\"outline-container\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<ul id=\"outline\">");
    _builder.newLine();
    {
      EList<Chapter> _chapters = doc.getChapters();
      EList<Part> _parts = doc.getParts();
      final Function1<Part,EList<Chapter>> _function = new Function1<Part,EList<Chapter>>() {
          public EList<Chapter> apply(final Part it) {
            EList<Chapter> _chapters = it.getChapters();
            return _chapters;
          }
        };
      List<EList<Chapter>> _map = ListExtensions.<Part, EList<Chapter>>map(_parts, _function);
      Iterable<Chapter> _flatten = Iterables.<Chapter>concat(_map);
      Iterable<Chapter> _plus = Iterables.<Chapter>concat(_chapters, _flatten);
      for(final Chapter chapter : _plus) {
        _builder.append("\t\t");
        _builder.append("<li><a href=\"#");
        String _href = this._htmlExtensions.href(chapter);
        _builder.append(_href, "		");
        _builder.append("\">");
        TextOrMarkup _title = chapter.getTitle();
        CharSequence _html = this._htmlExtensions.toHtml(_title);
        _builder.append(_html, "		");
        _builder.append("</a>");
        _builder.newLineIfNotEmpty();
        {
          EList<Section> _subSections = chapter.getSubSections();
          boolean _hasElements = false;
          for(final Section section : _subSections) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append("<ul>", "		");
            }
            _builder.append("\t\t");
            _builder.append("<li><a href=\"#");
            String _href_1 = this._htmlExtensions.href(section);
            _builder.append(_href_1, "		");
            _builder.append("\">");
            TextOrMarkup _title_1 = section.getTitle();
            CharSequence _html_1 = this._htmlExtensions.toHtml(_title_1);
            _builder.append(_html_1, "		");
            _builder.append("</a></li>");
            _builder.newLineIfNotEmpty();
          }
          if (_hasElements) {
            _builder.append("</ul>", "		");
          }
        }
        _builder.append("\t\t");
        _builder.append("</li>");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("</ul>");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
}

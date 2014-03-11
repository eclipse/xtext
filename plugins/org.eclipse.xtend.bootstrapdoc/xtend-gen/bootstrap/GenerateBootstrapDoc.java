package bootstrap;

import bootstrap.Body;
import bootstrap.Config;
import bootstrap.MainSite;
import bootstrap.Menu;
import bootstrap.PostProcessor;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multimap;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xdoc.xdoc.Document;
import org.eclipse.xtext.xdoc.xdoc.ImageRef;

@SuppressWarnings("all")
public class GenerateBootstrapDoc {
  /**
   * Use the main methods in xtext.website.generator and xtend.website.generator, instead.
   */
  public static void main(final String[] args) {
    Config _config = new Config();
    final Injector injector = _config.createInjectorAndDoEMFRegistration();
    GenerateBootstrapDoc _instance = injector.<GenerateBootstrapDoc>getInstance(GenerateBootstrapDoc.class);
    _instance.generate();
  }
  
  @Inject
  private Provider<ResourceSet> provider;
  
  @Inject
  private MainSite mainSite;
  
  @Inject
  @Extension
  private Menu _menu;
  
  @Inject
  @Extension
  private Body _body;
  
  @Inject
  @Extension
  private PostProcessor _postProcessor;
  
  @Inject
  private IResourceValidator validator;
  
  @Inject(optional = true)
  @Named("documentRoot")
  private String documentRoot = "../org.eclipse.xtend.doc.xdoc/xdoc";
  
  @Inject(optional = true)
  @Named("targetDirectory")
  private String targetDirectory = "../../website/documentation";
  
  public void generate() {
    try {
      final Document document = this.loadDocument();
      final File targetDir = new File(this.targetDirectory);
      final File sourceDir = new File(this.documentRoot);
      final File file = new File(targetDir, "index.html");
      this.copyImages(document, sourceDir, targetDir);
      File _absoluteFile = file.getAbsoluteFile();
      InputOutput.<File>println(_absoluteFile);
      File _parentFile = file.getParentFile();
      _parentFile.mkdirs();
      final FileWriter writer = new FileWriter(file);
      String _main = this.main(document);
      writer.append(_main);
      writer.close();
      InputOutput.<String>println("Done.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void copyImages(final Document doc, final File sourceDir, final File targetDir) {
    Resource _eResource = doc.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    final TreeIterator<Object> iter = EcoreUtil.<Object>getAllContents(_resourceSet, true);
    Iterator<ImageRef> _filter = Iterators.<ImageRef>filter(iter, ImageRef.class);
    final Procedure1<ImageRef> _function = new Procedure1<ImageRef>() {
      public void apply(final ImageRef it) {
        try {
          String _path = it.getPath();
          final File source = new File(sourceDir, _path);
          boolean _exists = source.exists();
          boolean _not = (!_exists);
          if (_not) {
            String _canonicalPath = source.getCanonicalPath();
            String _plus = ("Referenced Image " + _canonicalPath);
            String _plus_1 = (_plus + " does not exist in ");
            Resource _eResource = it.eResource();
            URI _uRI = _eResource.getURI();
            String _lastSegment = _uRI.lastSegment();
            String _plus_2 = (_plus_1 + _lastSegment);
            String _plus_3 = (_plus_2 + " line ");
            ICompositeNode _node = NodeModelUtils.getNode(it);
            int _startLine = _node.getStartLine();
            String _plus_4 = (_plus_3 + Integer.valueOf(_startLine));
            throw new IllegalStateException(_plus_4);
          }
          String _path_1 = it.getPath();
          final File target = new File(targetDir, _path_1);
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
  
  public Document loadDocument() {
    final ResourceSet rs = this.provider.get();
    PathTraverser _pathTraverser = new PathTraverser();
    List<String> _singletonList = Collections.<String>singletonList("../org.eclipse.xtend.doc.xdoc/xdoc");
    final Predicate<URI> _function = new Predicate<URI>() {
      public boolean apply(final URI it) {
        String _fileExtension = it.fileExtension();
        return Objects.equal(_fileExtension, "xdoc");
      }
    };
    Multimap<String, URI> _resolvePathes = _pathTraverser.resolvePathes(_singletonList, _function);
    final Collection<URI> uris = _resolvePathes.values();
    for (final URI uri : uris) {
      {
        InputOutput.<String>println(("Loading " + uri));
        rs.getResource(uri, true);
      }
    }
    EcoreUtil2.resolveAll(rs);
    EList<Resource> _resources = rs.getResources();
    final Function1<Resource, List<Issue>> _function_1 = new Function1<Resource, List<Issue>>() {
      public List<Issue> apply(final Resource it) {
        return GenerateBootstrapDoc.this.validator.validate(it, CheckMode.ALL, null);
      }
    };
    List<List<Issue>> _map = ListExtensions.<Resource, List<Issue>>map(_resources, _function_1);
    final Iterable<Issue> issues = Iterables.<Issue>concat(_map);
    final Function1<Issue, Boolean> _function_2 = new Function1<Issue, Boolean>() {
      public Boolean apply(final Issue i) {
        Severity _severity = i.getSeverity();
        return Boolean.valueOf(Objects.equal(_severity, Severity.ERROR));
      }
    };
    boolean _exists = IterableExtensions.<Issue>exists(issues, _function_2);
    if (_exists) {
      final Function1<Issue, String> _function_3 = new Function1<Issue, String>() {
        public String apply(final Issue it) {
          String _string = it.toString();
          return ("\n\t" + _string);
        }
      };
      Iterable<String> _map_1 = IterableExtensions.<Issue, String>map(issues, _function_3);
      String _join = IterableExtensions.join(_map_1);
      throw new IllegalStateException(_join);
    } else {
      boolean _isEmpty = IterableExtensions.isEmpty(issues);
      boolean _not = (!_isEmpty);
      if (_not) {
        final Function1<Issue, String> _function_4 = new Function1<Issue, String>() {
          public String apply(final Issue it) {
            return it.toString();
          }
        };
        Iterable<String> _map_2 = IterableExtensions.<Issue, String>map(issues, _function_4);
        String _join_1 = IterableExtensions.join(_map_2, "\n");
        InputOutput.<String>println(_join_1);
      }
    }
    TreeIterator<Notifier> _allContents = rs.getAllContents();
    Iterator<Document> _filter = Iterators.<Document>filter(_allContents, Document.class);
    return IteratorExtensions.<Document>head(_filter);
  }
  
  public String main(final Document document) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _header = this.mainSite.header("../bootstrap");
    _builder.append(_header, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _menu = this._menu.menu(document);
    _builder.append(_menu, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _body = this._body.body(document);
    _builder.append(_body, "\t");
    _builder.newLineIfNotEmpty();
    CharSequence _footer = this.mainSite.footer("../bootstrap");
    _builder.append(_footer, "");
    _builder.newLineIfNotEmpty();
    return this._postProcessor.postProcess(_builder);
  }
}

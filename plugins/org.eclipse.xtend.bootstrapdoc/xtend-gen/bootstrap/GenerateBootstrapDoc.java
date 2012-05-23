package bootstrap;

import bootstrap.Body;
import bootstrap.MainSite;
import bootstrap.Menu;
import bootstrap.PostProcessor;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import java.io.File;
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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xdoc.XdocStandaloneSetup;
import org.eclipse.xtext.xdoc.xdoc.Document;

@SuppressWarnings("all")
public class GenerateBootstrapDoc {
  public static void main(final String[] args) {
    XdocStandaloneSetup _xdocStandaloneSetup = new XdocStandaloneSetup();
    final Injector injector = _xdocStandaloneSetup.createInjectorAndDoEMFRegistration();
    GenerateBootstrapDoc _instance = injector.<GenerateBootstrapDoc>getInstance(GenerateBootstrapDoc.class);
    _instance.generate();
  }
  
  @Inject
  private Provider<ResourceSet> provider;
  
  @Inject
  private MainSite mainSite;
  
  @Inject
  private Menu _menu;
  
  @Inject
  private Body _body;
  
  @Inject
  private PostProcessor _postProcessor;
  
  @Inject
  private IResourceValidator validator;
  
  public void generate() {
    try {
      final Document document = this.loadDocument();
      File _file = new File("../../website/documentation/index.html");
      final File file = _file;
      File _parentFile = file.getParentFile();
      _parentFile.mkdirs();
      FileWriter _fileWriter = new FileWriter(file);
      final FileWriter writer = _fileWriter;
      String _main = this.main(document);
      writer.append(_main);
      writer.close();
      InputOutput.<String>println("Done.");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Document loadDocument() {
    final ResourceSet rs = this.provider.get();
    PathTraverser _pathTraverser = new PathTraverser();
    List<String> _singletonList = Collections.<String>singletonList("../org.eclipse.xtend.doc.xdoc/xdoc");
    final Function1<URI,Boolean> _function = new Function1<URI,Boolean>() {
        public Boolean apply(final URI it) {
          String _fileExtension = it.fileExtension();
          boolean _equals = Objects.equal(_fileExtension, "xdoc");
          return _equals;
        }
      };
    Multimap<String,URI> _resolvePathes = _pathTraverser.resolvePathes(_singletonList, new Predicate<URI>() {
        public boolean apply(URI input) {
          return _function.apply(input);
        }
    });
    final Collection<URI> uris = _resolvePathes.values();
    for (final URI uri : uris) {
      {
        String _plus = ("Loading " + uri);
        InputOutput.<String>println(_plus);
        rs.getResource(uri, true);
      }
    }
    EcoreUtil2.resolveAll(rs);
    EList<Resource> _resources = rs.getResources();
    for (final Resource resource : _resources) {
      {
        final List<Issue> issues = this.validator.validate(resource, CheckMode.ALL, null);
        final Function1<Issue,Boolean> _function_1 = new Function1<Issue,Boolean>() {
            public Boolean apply(final Issue i) {
              Severity _severity = i.getSeverity();
              boolean _equals = Objects.equal(_severity, Severity.ERROR);
              return Boolean.valueOf(_equals);
            }
          };
        boolean _exists = IterableExtensions.<Issue>exists(issues, _function_1);
        if (_exists) {
          String _string = issues.toString();
          IllegalStateException _illegalStateException = new IllegalStateException(_string);
          throw _illegalStateException;
        }
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
    _builder.append(_menu, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _body = this._body.body(document);
    _builder.append(_body, "	");
    _builder.newLineIfNotEmpty();
    CharSequence _footer = this.mainSite.footer("../bootstrap");
    _builder.append(_footer, "");
    _builder.newLineIfNotEmpty();
    String _postProcess = this._postProcessor.postProcess(_builder);
    return _postProcess;
  }
}

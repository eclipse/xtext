package bootstrap;

import bootstrap.Body;
import bootstrap.MainSite;
import bootstrap.Menu;
import bootstrap.PostProcessor;
import com.google.common.base.Predicate;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
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
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xdoc.XdocStandaloneSetup;
import org.eclipse.xtext.xdoc.xdoc.Document;

@SuppressWarnings("all")
public class GenerateBootstrapDoc {
  public static void main(final String[] args) {
      XdocStandaloneSetup _xdocStandaloneSetup = new XdocStandaloneSetup();
      Injector _createInjectorAndDoEMFRegistration = _xdocStandaloneSetup.createInjectorAndDoEMFRegistration();
      final Injector injector = _createInjectorAndDoEMFRegistration;
      GenerateBootstrapDoc _instance = injector.<GenerateBootstrapDoc>getInstance(bootstrap.GenerateBootstrapDoc.class);
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
      {
        Document _loadDocument = this.loadDocument();
        final Document document = _loadDocument;
        File _file = new File("bootstrap/index.html");
        FileWriter _fileWriter = new FileWriter(_file);
        final FileWriter writer = _fileWriter;
        String _main = this.main(document);
        writer.append(_main);
        writer.close();
        InputOutput.<String>println("Done.");
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Document loadDocument() {
      Provider<ResourceSet> _provider = this.provider;
      ResourceSet _get = _provider.get();
      final ResourceSet rs = _get;
      PathTraverser _pathTraverser = new PathTraverser();
      List<String> _singletonList = Collections.<String>singletonList("../org.eclipse.xtext.xtend2.doc/xdoc");
      final Function1<URI,Boolean> _function = new Function1<URI,Boolean>() {
          public Boolean apply(final URI it) {
            String _fileExtension = it.fileExtension();
            boolean _operator_equals = ObjectExtensions.operator_equals(_fileExtension, "xdoc");
            return _operator_equals;
          }
        };
      Multimap<String,URI> _resolvePathes = _pathTraverser.resolvePathes(_singletonList, new Predicate<URI>() {
          public boolean apply(URI input) {
            return _function.apply(input);
          }
      });
      Collection<URI> _values = _resolvePathes.values();
      final Collection<URI> uris = _values;
      for (final URI uri : uris) {
        {
          String _operator_plus = StringExtensions.operator_plus("Loading ", uri);
          InputOutput.<String>println(_operator_plus);
          rs.getResource(uri, true);
        }
      }
      EcoreUtil.resolveAll(rs);
      EList<Resource> _resources = rs.getResources();
      for (final Resource resource : _resources) {
        {
          IResourceValidator _validator = this.validator;
          CheckMode _ALL = CheckMode.ALL;
          List<Issue> _validate = _validator.validate(resource, _ALL, null);
          final List<Issue> issues = _validate;
          final Function1<Issue,Boolean> _function_1 = new Function1<Issue,Boolean>() {
              public Boolean apply(final Issue i) {
                Severity _severity = i.getSeverity();
                Severity _ERROR = Severity.ERROR;
                boolean _operator_equals = ObjectExtensions.operator_equals(_severity, _ERROR);
                return Boolean.valueOf(_operator_equals);
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
      Iterator<Document> _filter = IteratorExtensions.<Document>filter(_allContents, org.eclipse.xtext.xdoc.xdoc.Document.class);
      Document _head = IteratorExtensions.<Document>head(_filter);
      return _head;
  }
  
  public String main(final Document document) {
    StringConcatenation _builder = new StringConcatenation();
    MainSite _mainSite = this.mainSite;
    CharSequence _header = _mainSite.header();
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
    MainSite _mainSite_1 = this.mainSite;
    CharSequence _footer = _mainSite_1.footer();
    _builder.append(_footer, "");
    _builder.newLineIfNotEmpty();
    String _postProcess = this._postProcessor.postProcess(_builder);
    return _postProcess;
  }
}

package workflow;

import bootstrap.MainSite;
import bootstrap.Menu;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xdoc.XdocStandaloneSetup;
import org.eclipse.xtext.xdoc.xdoc.XdocFile;

@SuppressWarnings("all")
public class GenerateBootstrapDoc {
  public static void main(final String[] args) {
      XdocStandaloneSetup _xdocStandaloneSetup = new XdocStandaloneSetup();
      Injector _createInjectorAndDoEMFRegistration = _xdocStandaloneSetup.createInjectorAndDoEMFRegistration();
      final Injector injector = _createInjectorAndDoEMFRegistration;
      GenerateBootstrapDoc _instance = injector.<GenerateBootstrapDoc>getInstance(workflow.GenerateBootstrapDoc.class);
      _instance.generate();
  }
  
  @Inject
  private Provider<ResourceSet> provider;
  
  @Inject
  private MainSite mainSite;
  
  @Inject
  private Menu _menu;
  
  @Inject
  private IResourceValidator validator;
  
  public void generate() {
    try {
      {
        XdocFile _loadFile = this.loadFile();
        final XdocFile file = _loadFile;
        File _file = new File("index.html");
        FileWriter _fileWriter = new FileWriter(_file);
        final FileWriter writer = _fileWriter;
        CharSequence _main = this.main(file);
        writer.append(_main);
        writer.close();
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public XdocFile loadFile() {
      ResourceSet _get = this.provider.get();
      final ResourceSet rs = _get;
      URI _createURI = URI.createURI("xdoc/Xtend.xdoc");
      Resource _resource = rs.getResource(_createURI, true);
      final Resource resource = _resource;
      List<Issue> _validate = this.validator.validate(resource, CheckMode.ALL, null);
      final List<Issue> issues = _validate;
      final Function1<Issue,Boolean> _function = new Function1<Issue,Boolean>() {
          public Boolean apply(final Issue i) {
            Severity _severity = i.getSeverity();
            boolean _operator_equals = ObjectExtensions.operator_equals(_severity, Severity.ERROR);
            return Boolean.valueOf(_operator_equals);
          }
        };
      boolean _exists = IterableExtensions.<Issue>exists(issues, _function);
      if (_exists) {
        String _string = issues.toString();
        IllegalStateException _illegalStateException = new IllegalStateException(_string);
        throw _illegalStateException;
      }
      EList<EObject> _contents = resource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      return ((XdocFile) _head);
  }
  
  public CharSequence main(final XdocFile file) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _header = this.mainSite.header();
    _builder.append(_header, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _menu = this._menu.menu(file);
    _builder.append(_menu, "	");
    _builder.newLineIfNotEmpty();
    CharSequence _footer = this.mainSite.footer();
    _builder.append(_footer, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}

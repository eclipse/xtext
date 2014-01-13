package bootstrap;

import bootstrap.GenerateBootstrapDoc;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.eclipse.xtext.xdoc.XdocRuntimeModule;
import org.eclipse.xtext.xdoc.XdocStandaloneSetup;

@SuppressWarnings("all")
public class Config extends XdocStandaloneSetup implements Module {
  public static void main(final String[] args) {
    XdocStandaloneSetup _xdocStandaloneSetup = new XdocStandaloneSetup();
    final Injector injector = _xdocStandaloneSetup.createInjectorAndDoEMFRegistration();
    GenerateBootstrapDoc _instance = injector.<GenerateBootstrapDoc>getInstance(GenerateBootstrapDoc.class);
    _instance.generate();
  }
  
  public Injector createInjector() {
    XdocRuntimeModule _xdocRuntimeModule = new XdocRuntimeModule();
    return Guice.createInjector(_xdocRuntimeModule, this);
  }
  
  public void configure(final Binder binder) {
  }
}

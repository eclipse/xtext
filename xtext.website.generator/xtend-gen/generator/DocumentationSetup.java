package generator;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.eclipse.xtext.xdoc.XdocRuntimeModule;
import org.eclipse.xtext.xdoc.XdocStandaloneSetup;

@SuppressWarnings("all")
public class DocumentationSetup extends XdocStandaloneSetup implements Module {
  public Injector createInjector() {
    Injector _xblockexpression = null;
    {
      XdocRuntimeModule _xdocRuntimeModule = new XdocRuntimeModule();
      final XdocRuntimeModule module = _xdocRuntimeModule;
      Injector _createInjector = Guice.createInjector(module, this);
      _xblockexpression = (_createInjector);
    }
    return _xblockexpression;
  }
  
  public void configure(final Binder binder) {
  }
}

package generator.xtend;

import bootstrap.Body;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.binder.AnnotatedBindingBuilder;
import generator.xtend.DocumentationBody;
import org.eclipse.xtext.xdoc.XdocRuntimeModule;
import org.eclipse.xtext.xdoc.XdocStandaloneSetup;

@SuppressWarnings("all")
public class DocumentationSetup extends XdocStandaloneSetup implements Module {
  public Injector createInjector() {
    Injector _xblockexpression = null;
    {
      final XdocRuntimeModule module = new XdocRuntimeModule();
      _xblockexpression = Guice.createInjector(module, this);
    }
    return _xblockexpression;
  }
  
  public void configure(final Binder binder) {
    AnnotatedBindingBuilder<Body> _bind = binder.<Body>bind(Body.class);
    _bind.to(DocumentationBody.class);
  }
}

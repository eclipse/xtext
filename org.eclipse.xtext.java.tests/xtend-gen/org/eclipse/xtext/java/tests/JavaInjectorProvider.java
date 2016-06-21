package org.eclipse.xtext.java.tests;

import com.google.common.base.Objects;
import com.google.inject.Injector;
import org.eclipse.xtext.java.JavaSourceLanguageSetup;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.IRegistryConfigurator;

@SuppressWarnings("all")
public class JavaInjectorProvider implements IInjectorProvider, IRegistryConfigurator {
  private final JavaSourceLanguageSetup setup = new JavaSourceLanguageSetup();
  
  private Injector injector;
  
  @Override
  public Injector getInjector() {
    boolean _equals = Objects.equal(this.injector, null);
    if (_equals) {
      Injector _createInjector = this.setup.createInjector();
      this.injector = _createInjector;
    }
    return this.injector;
  }
  
  @Override
  public void restoreRegistry() {
  }
  
  @Override
  public void setupRegistry() {
    Injector _injector = this.getInjector();
    this.setup.register(_injector, "txt");
    Injector _injector_1 = this.getInjector();
    this.setup.register(_injector_1, "java");
  }
}

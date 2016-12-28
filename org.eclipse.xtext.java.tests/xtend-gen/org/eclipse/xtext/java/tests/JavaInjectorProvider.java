package org.eclipse.xtext.java.tests;

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
    if ((this.injector == null)) {
      this.injector = this.setup.createInjector();
    }
    return this.injector;
  }
  
  @Override
  public void restoreRegistry() {
  }
  
  @Override
  public void setupRegistry() {
    this.setup.register(this.getInjector(), "txt");
    this.setup.register(this.getInjector(), "java");
  }
}

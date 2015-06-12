package org.eclipse.xtext.java.tests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.Map;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.java.resource.JavaRuntimeModule;
import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.junit4.IRegistryConfigurator;

@SuppressWarnings("all")
public class JavaInjectorProvider implements IInjectorProvider, IRegistryConfigurator {
  private final Injector injector = Guice.createInjector(new JavaRuntimeModule());
  
  @Override
  public Injector getInjector() {
    return this.injector;
  }
  
  @Override
  public void restoreRegistry() {
  }
  
  @Override
  public void setupRegistry() {
    final Resource.Factory factory = this.injector.<Resource.Factory>getInstance(Resource.Factory.class);
    Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    _extensionToFactoryMap.put("txt", factory);
    Map<String, Object> _extensionToFactoryMap_1 = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    _extensionToFactoryMap_1.put("java", factory);
  }
}

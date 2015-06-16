package org.eclipse.xtext.java;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ISetupExtension;
import org.eclipse.xtext.java.JavaRuntimeModule;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class JavaSourceLanguageSetup implements ISetup, ISetupExtension {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    final Injector injector = this.createInjector();
    this.register(injector, "java");
    return injector;
  }
  
  @Override
  public List<String> getFileExtensions() {
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("java"));
  }
  
  public Injector createInjector() {
    JavaRuntimeModule _javaRuntimeModule = new JavaRuntimeModule();
    return Guice.createInjector(_javaRuntimeModule);
  }
  
  public void register(final Injector injector, final String fileExtension) {
    final Resource.Factory resourceFactory = injector.<Resource.Factory>getInstance(Resource.Factory.class);
    final IResourceServiceProvider serviceProvider = injector.<IResourceServiceProvider>getInstance(IResourceServiceProvider.class);
    Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    _extensionToFactoryMap.put(fileExtension, resourceFactory);
    Map<String, Object> _extensionToFactoryMap_1 = IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap();
    _extensionToFactoryMap_1.put(fileExtension, serviceProvider);
  }
}

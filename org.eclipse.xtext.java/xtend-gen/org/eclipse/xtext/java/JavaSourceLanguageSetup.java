package org.eclipse.xtext.java;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.java.JavaSourceLanguageRuntimeModule;
import org.eclipse.xtext.resource.IResourceServiceProvider;

@SuppressWarnings("all")
public class JavaSourceLanguageSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    final Injector injector = this.createInjector();
    this.register(injector, "java");
    return injector;
  }
  
  public Injector createInjector() {
    JavaSourceLanguageRuntimeModule _javaSourceLanguageRuntimeModule = new JavaSourceLanguageRuntimeModule();
    return Guice.createInjector(_javaSourceLanguageRuntimeModule);
  }
  
  public void register(final Injector injector, final String fileExtension) {
    final Resource.Factory resourceFactory = injector.<Resource.Factory>getInstance(Resource.Factory.class);
    final IResourceServiceProvider serviceProvider = injector.<IResourceServiceProvider>getInstance(IResourceServiceProvider.class);
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(fileExtension, resourceFactory);
    IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put(fileExtension, serviceProvider);
  }
}

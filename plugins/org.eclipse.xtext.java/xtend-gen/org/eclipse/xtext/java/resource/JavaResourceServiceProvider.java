package org.eclipse.xtext.java.resource;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.validation.IResourceValidator;

@SuppressWarnings("all")
public class JavaResourceServiceProvider implements IResourceServiceProvider {
  @Inject
  private Injector injector;
  
  @Override
  public boolean canHandle(final URI uri) {
    String _fileExtension = uri.fileExtension();
    return Objects.equal(_fileExtension, "java");
  }
  
  @Override
  public <T extends Object> T get(final Class<T> t) {
    return this.injector.<T>getInstance(t);
  }
  
  @Override
  public IContainer.Manager getContainerManager() {
    return this.<IContainer.Manager>get(IContainer.Manager.class);
  }
  
  @Override
  public IEncodingProvider getEncodingProvider() {
    return this.<IEncodingProvider>get(IEncodingProvider.class);
  }
  
  @Override
  public IResourceDescription.Manager getResourceDescriptionManager() {
    return this.<IResourceDescription.Manager>get(IResourceDescription.Manager.class);
  }
  
  @Override
  public IResourceValidator getResourceValidator() {
    return this.<IResourceValidator>get(IResourceValidator.class);
  }
}

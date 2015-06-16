package org.eclipse.xtext.java.resource;

import com.google.inject.ConfigurationException;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class JavaResourceServiceProvider implements IResourceServiceProvider {
  @Inject
  private Injector injector;
  
  @Inject
  private FileExtensionProvider extensionProvider;
  
  @Override
  public boolean canHandle(final URI uri) {
    Set<String> _fileExtensions = this.extensionProvider.getFileExtensions();
    String _fileExtension = uri.fileExtension();
    return _fileExtensions.contains(_fileExtension);
  }
  
  @Override
  public <T extends Object> T get(final Class<T> t) {
    try {
      return this.injector.<T>getInstance(t);
    } catch (final Throwable _t) {
      if (_t instanceof ConfigurationException) {
        final ConfigurationException e = (ConfigurationException)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
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
    return null;
  }
}

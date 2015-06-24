/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtext.idea.resource.IResourceIdeaServiceProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.service.LanguageSpecific;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultResourceIdeaServiceProvider implements IResourceIdeaServiceProvider {
  @Inject
  @Delegate
  private IResourceServiceProvider delegate;
  
  @Inject
  @LanguageSpecific
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IPsiModelAssociations psiModelAssociations;
  
  public boolean canHandle(final URI uri) {
    return this.delegate.canHandle(uri);
  }
  
  public <T extends Object> T get(final Class<T> t) {
    return this.delegate.get(t);
  }
  
  public IContainer.Manager getContainerManager() {
    return this.delegate.getContainerManager();
  }
  
  public IEncodingProvider getEncodingProvider() {
    return this.delegate.getEncodingProvider();
  }
  
  public IResourceDescription.Manager getResourceDescriptionManager() {
    return this.delegate.getResourceDescriptionManager();
  }
  
  public IResourceValidator getResourceValidator() {
    return this.delegate.getResourceValidator();
  }
  
  @Pure
  public IPsiModelAssociations getPsiModelAssociations() {
    return this.psiModelAssociations;
  }
}

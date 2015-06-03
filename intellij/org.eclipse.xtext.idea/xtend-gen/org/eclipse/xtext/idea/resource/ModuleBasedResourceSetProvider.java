/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.intellij.openapi.module.Module;
import org.eclipse.xtext.resource.XtextResourceSet;

@Singleton
@SuppressWarnings("all")
public class ModuleBasedResourceSetProvider {
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  public XtextResourceSet get(final Module context) {
    final XtextResourceSet resourceSet = this.resourceSetProvider.get();
    resourceSet.setClasspathURIContext(context);
    return resourceSet;
  }
}

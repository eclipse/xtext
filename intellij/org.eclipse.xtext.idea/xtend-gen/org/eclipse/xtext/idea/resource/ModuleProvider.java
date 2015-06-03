/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.intellij.openapi.module.Module;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;

@SuppressWarnings("all")
public class ModuleProvider {
  public static Module findModule(final ResourceSet resourceSet) {
    Object _classpathURIContext = ((XtextResourceSet) resourceSet).getClasspathURIContext();
    return ((Module) _classpathURIContext);
  }
}

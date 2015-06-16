/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.filesystem;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.idea.filesystem.IdeaWorkspaceConfig;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider;

@SuppressWarnings("all")
public class IdeaWorkspaceConfigProvider implements IWorkspaceConfigProvider {
  @Override
  public IWorkspaceConfig getWorkspaceConfig(final Resource context) {
    final ResourceSet resourceSet = context.getResourceSet();
    if ((resourceSet instanceof XtextResourceSet)) {
      final Object uriContext = ((XtextResourceSet)resourceSet).getClasspathURIContext();
      if ((uriContext instanceof Module)) {
        final Project project = ((Module)uriContext).getProject();
        return new IdeaWorkspaceConfig(project);
      }
    }
    URI _uRI = context.getURI();
    String _plus = ("Could not determine the project for " + _uRI);
    throw new IllegalArgumentException(_plus);
  }
}

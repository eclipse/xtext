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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.idea.filesystem.IdeaWorkspaceConfig;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider;

@SuppressWarnings("all")
public class IdeaWorkspaceConfigProvider implements IWorkspaceConfigProvider {
  @Override
  public IdeaWorkspaceConfig getWorkspaceConfig(final ResourceSet context) {
    if ((context instanceof XtextResourceSet)) {
      final Object uriContext = ((XtextResourceSet)context).getClasspathURIContext();
      if ((uriContext instanceof Module)) {
        return this.getWorkspaceConfig(((Module)uriContext));
      }
    }
    throw new IllegalArgumentException("Could not determine the project");
  }
  
  public IdeaWorkspaceConfig getWorkspaceConfig(final Module module) {
    Project _project = module.getProject();
    return this.getWorkspaceConfig(_project);
  }
  
  public IdeaWorkspaceConfig getWorkspaceConfig(final Project project) {
    return new IdeaWorkspaceConfig(project);
  }
}

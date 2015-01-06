/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.filesystem;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.idea.filesystem.IdeaModuleConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class IdeaWorkspaceConfigProvider implements Provider<WorkspaceConfig> {
  @Inject
  private IOutputConfigurationProvider outputConfigurations;
  
  public WorkspaceConfig get() {
    WorkspaceConfig _xblockexpression = null;
    {
      ProjectManager _instance = ProjectManager.getInstance();
      Project[] _openProjects = _instance.getOpenProjects();
      final Project project = IterableExtensions.<Project>head(((Iterable<Project>)Conversions.doWrapArray(_openProjects)));
      String _basePath = project.getBasePath();
      final WorkspaceConfig result = new WorkspaceConfig(_basePath);
      ModuleManager _instance_1 = ModuleManager.getInstance(project);
      Module[] _modules = _instance_1.getModules();
      final Procedure1<Module> _function = new Procedure1<Module>() {
        public void apply(final Module m) {
          IdeaModuleConfig _ideaModuleConfig = new IdeaModuleConfig(m, IdeaWorkspaceConfigProvider.this.outputConfigurations);
          result.addProjectConfig(_ideaModuleConfig);
        }
      };
      IterableExtensions.<Module>forEach(((Iterable<Module>)Conversions.doWrapArray(_modules)), _function);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}

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
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.xbase.file.SimpleWorkspaceConfig;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.idea.filesystem.IdeaModuleConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class IdeaWorkspaceConfigProvider implements Provider<WorkspaceConfig> {
  @Inject
  private IOutputConfigurationProvider outputConfigurations;
  
  @Override
  public WorkspaceConfig get() {
    SimpleWorkspaceConfig _xblockexpression = null;
    {
      ProjectManager _instance = ProjectManager.getInstance();
      Project[] _openProjects = _instance.getOpenProjects();
      final Project project = IterableExtensions.<Project>head(((Iterable<Project>)Conversions.doWrapArray(_openProjects)));
      String _basePath = project.getBasePath();
      final SimpleWorkspaceConfig result = new SimpleWorkspaceConfig(_basePath);
      ModuleManager _instance_1 = ModuleManager.getInstance(project);
      Module[] _modules = _instance_1.getModules();
      final Consumer<Module> _function = new Consumer<Module>() {
        @Override
        public void accept(final Module m) {
          IdeaModuleConfig _ideaModuleConfig = new IdeaModuleConfig(m, IdeaWorkspaceConfigProvider.this.outputConfigurations);
          result.addProjectConfig(_ideaModuleConfig);
        }
      };
      ((List<Module>)Conversions.doWrapArray(_modules)).forEach(_function);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}

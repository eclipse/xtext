/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.filesystem;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class IdeaModuleConfig extends ProjectConfig {
  private final Module module;
  
  private final IOutputConfigurationProvider outputConfigurations;
  
  public IdeaModuleConfig(final Module module, final IOutputConfigurationProvider outputConfigurations) {
    super(module.getName());
    this.module = module;
    this.outputConfigurations = outputConfigurations;
  }
  
  public Map<Path, Path> getSourceFolderMappings() {
    Map<Path, Path> _xblockexpression = null;
    {
      final Map<Path, Path> mappings = super.getSourceFolderMappings();
      boolean _isEmpty = mappings.isEmpty();
      if (_isEmpty) {
        ModuleRootManager _instance = ModuleRootManager.getInstance(this.module);
        VirtualFile[] _sourceRoots = _instance.getSourceRoots();
        final Procedure1<VirtualFile> _function = new Procedure1<VirtualFile>() {
          public void apply(final VirtualFile root) {
            final Project project = IdeaModuleConfig.this.module.getProject();
            VirtualFile _baseDir = project.getBaseDir();
            String _name = IdeaModuleConfig.this.module.getName();
            final VirtualFile moduleBaseDir = _baseDir.findChild(_name);
            final String relativeSourceFolder = VfsUtil.getRelativePath(root, moduleBaseDir, Path.SEGMENT_SEPARATOR);
            String _name_1 = IdeaModuleConfig.this.module.getName();
            String _plus = (_name_1 + Character.valueOf(Path.SEGMENT_SEPARATOR));
            final String sourcePath = (_plus + relativeSourceFolder);
            String _name_2 = IdeaModuleConfig.this.module.getName();
            String _plus_1 = (_name_2 + Character.valueOf(Path.SEGMENT_SEPARATOR));
            Set<OutputConfiguration> _outputConfigurations = IdeaModuleConfig.this.outputConfigurations.getOutputConfigurations();
            OutputConfiguration _head = IterableExtensions.<OutputConfiguration>head(_outputConfigurations);
            String _outputDirectory = _head.getOutputDirectory(sourcePath);
            final String outputPath = (_plus_1 + _outputDirectory);
            Path _path = new Path(sourcePath);
            Path _path_1 = new Path(outputPath);
            mappings.put(_path, _path_1);
          }
        };
        IterableExtensions.<VirtualFile>forEach(((Iterable<VirtualFile>)Conversions.doWrapArray(_sourceRoots)), _function);
      }
      _xblockexpression = mappings;
    }
    return _xblockexpression;
  }
  
  public Path getRootPath() {
    String _name = this.module.getName();
    return new Path(_name);
  }
}

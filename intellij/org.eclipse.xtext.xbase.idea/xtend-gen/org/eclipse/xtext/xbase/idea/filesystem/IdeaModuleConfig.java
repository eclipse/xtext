/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.filesystem;

import com.google.common.base.Objects;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.SourceFolder;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.idea.extensions.RootModelExtensions;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.idea.filesystem.IdeaFileSystemSupport;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
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
  
  @Override
  public Map<Path, Path> getSourceFolderMappings() {
    Map<Path, Path> _xblockexpression = null;
    {
      final Map<Path, Path> mappings = super.getSourceFolderMappings();
      boolean _isEmpty = mappings.isEmpty();
      if (_isEmpty) {
        Iterable<SourceFolder> _sourceFolders = RootModelExtensions.getSourceFolders(this.module);
        final Procedure1<SourceFolder> _function = new Procedure1<SourceFolder>() {
          @Override
          public void apply(final SourceFolder sourceFolder) {
            Set<OutputConfiguration> _outputConfigurations = IdeaModuleConfig.this.outputConfigurations.getOutputConfigurations();
            OutputConfiguration _head = IterableExtensions.<OutputConfiguration>head(_outputConfigurations);
            String _relativePath = RootModelExtensions.getRelativePath(sourceFolder);
            final String relativeOutputPath = _head.getOutputDirectory(_relativePath);
            Iterable<SourceFolder> _sourceFolders = RootModelExtensions.getSourceFolders(IdeaModuleConfig.this.module);
            final Function1<SourceFolder, Boolean> _function = new Function1<SourceFolder, Boolean>() {
              @Override
              public Boolean apply(final SourceFolder it) {
                String _relativePath = RootModelExtensions.getRelativePath(it);
                return Boolean.valueOf(Objects.equal(_relativePath, relativeOutputPath));
              }
            };
            final SourceFolder outputFolder = IterableExtensions.<SourceFolder>findFirst(_sourceFolders, _function);
            final Path sourcePath = IdeaFileSystemSupport.createAbsolutePath(IdeaModuleConfig.this.module, sourceFolder);
            final Path outputPath = IdeaFileSystemSupport.createAbsolutePath(IdeaModuleConfig.this.module, outputFolder);
            mappings.put(sourcePath, outputPath);
          }
        };
        IterableExtensions.<SourceFolder>forEach(_sourceFolders, _function);
      }
      _xblockexpression = mappings;
    }
    return _xblockexpression;
  }
  
  @Override
  public Path getRootPath() {
    String _name = this.module.getName();
    return new Path(_name);
  }
}

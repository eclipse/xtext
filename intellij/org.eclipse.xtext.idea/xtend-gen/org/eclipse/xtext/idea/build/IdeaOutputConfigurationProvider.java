/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.intellij.facet.Facet;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.SourceFolder;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.VirtualFile;
import java.io.File;
import java.util.Set;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider2;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.idea.extensions.RootModelExtensions;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.FacetProvider;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaOutputConfigurationProvider implements IContextualOutputConfigurationProvider, IContextualOutputConfigurationProvider2 {
  @Inject
  private FacetProvider facetProvider;
  
  @Inject
  private IOutputConfigurationProvider defaultOutput;
  
  @Override
  public Set<OutputConfiguration> getOutputConfigurations(final Resource context) {
    ResourceSet _resourceSet = context.getResourceSet();
    return this.getOutputConfigurations(_resourceSet);
  }
  
  @Override
  public Set<OutputConfiguration> getOutputConfigurations(final ResourceSet context) {
    final Object module = ((XtextResourceSet) context).getClasspathURIContext();
    if ((module instanceof Module)) {
      return this.getOutputConfigurations(((Module)module));
    }
    return this.defaultOutput.getOutputConfigurations();
  }
  
  public Set<OutputConfiguration> getOutputConfigurations(final Module module) {
    final Facet<? extends AbstractFacetConfiguration> facet = this.facetProvider.getFacet(module);
    boolean _notEquals = (!Objects.equal(facet, null));
    if (_notEquals) {
      AbstractFacetConfiguration _configuration = facet.getConfiguration();
      final GeneratorConfigurationState generatorConf = _configuration.getState();
      final OutputConfiguration defOut = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
      String _outputDirectory = generatorConf.getOutputDirectory();
      String _moduleRelativePath = this.toModuleRelativePath(_outputDirectory, module);
      defOut.setOutputDirectory(_moduleRelativePath);
      boolean _isCreateDirectory = generatorConf.isCreateDirectory();
      defOut.setCreateOutputDirectory(_isCreateDirectory);
      boolean _isDeleteGenerated = generatorConf.isDeleteGenerated();
      defOut.setCanClearOutputDirectory(_isDeleteGenerated);
      boolean _isOverwriteExisting = generatorConf.isOverwriteExisting();
      defOut.setOverrideExistingResources(_isOverwriteExisting);
      defOut.setUseOutputPerSourceFolder(true);
      final Iterable<SourceFolder> allSrcFolders = RootModelExtensions.getExistingSourceFolders(module);
      for (final SourceFolder srcFolder : allSrcFolders) {
        {
          String _relativePath = RootModelExtensions.getRelativePath(srcFolder);
          final OutputConfiguration.SourceMapping mapping = new OutputConfiguration.SourceMapping(_relativePath);
          boolean _isTestSource = srcFolder.isTestSource();
          if (_isTestSource) {
            String _testOutputDirectory = generatorConf.getTestOutputDirectory();
            String _moduleRelativePath_1 = this.toModuleRelativePath(_testOutputDirectory, module);
            mapping.setOutputDirectory(_moduleRelativePath_1);
          } else {
            String _outputDirectory_1 = generatorConf.getOutputDirectory();
            String _moduleRelativePath_2 = this.toModuleRelativePath(_outputDirectory_1, module);
            mapping.setOutputDirectory(_moduleRelativePath_2);
          }
          Set<OutputConfiguration.SourceMapping> _sourceMappings = defOut.getSourceMappings();
          _sourceMappings.add(mapping);
        }
      }
      return Sets.<OutputConfiguration>newHashSet(defOut);
    }
    return this.defaultOutput.getOutputConfigurations();
  }
  
  public String toModuleRelativePath(final String path, final Module module) {
    boolean _isAbsolute = FileUtil.isAbsolute(path);
    if (_isAbsolute) {
      Application _application = ApplicationManager.getApplication();
      final Computable<String> _function = new Computable<String>() {
        @Override
        public String compute() {
          ModuleRootManager _instance = ModuleRootManager.getInstance(module);
          VirtualFile[] _contentRoots = _instance.getContentRoots();
          final VirtualFile root = IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(_contentRoots)));
          String _path = root.getPath();
          final String relativePath = FileUtil.getRelativePath(_path, path, File.separatorChar);
          return relativePath;
        }
      };
      return _application.<String>runReadAction(_function);
    }
    return path;
  }
}

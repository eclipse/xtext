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
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.SourceFolder;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import java.util.Set;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.idea.extensions.RootModelExtensions;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.FacetProvider;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaOutputConfigurationProvider implements IContextualOutputConfigurationProvider {
  @Inject
  private FacetProvider facetProvider;
  
  @Inject
  private IOutputConfigurationProvider defaultOutput;
  
  @Override
  public Set<OutputConfiguration> getOutputConfigurations(final Resource context) {
    ResourceSet _resourceSet = context.getResourceSet();
    final Object module = ((XtextResourceSet) _resourceSet).getClasspathURIContext();
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
      defOut.setOutputDirectory(_outputDirectory);
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
          ContentEntry _contentEntry = srcFolder.getContentEntry();
          VirtualFile _file = _contentEntry.getFile();
          VirtualFile _file_1 = srcFolder.getFile();
          String _path = VfsUtil.getPath(_file, _file_1, '/');
          final OutputConfiguration.SourceMapping mapping = new OutputConfiguration.SourceMapping(_path);
          boolean _isTestSource = srcFolder.isTestSource();
          if (_isTestSource) {
            String _testOutputDirectory = generatorConf.getTestOutputDirectory();
            mapping.setOutputDirectory(_testOutputDirectory);
          } else {
            String _outputDirectory_1 = generatorConf.getOutputDirectory();
            mapping.setOutputDirectory(_outputDirectory_1);
          }
          Set<OutputConfiguration.SourceMapping> _sourceMappings = defOut.getSourceMappings();
          _sourceMappings.add(mapping);
        }
      }
      return Sets.<OutputConfiguration>newHashSet(defOut);
    }
    return this.defaultOutput.getOutputConfigurations();
  }
}

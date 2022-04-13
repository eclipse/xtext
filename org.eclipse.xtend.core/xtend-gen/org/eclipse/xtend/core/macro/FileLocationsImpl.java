/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class FileLocationsImpl implements FileLocations {
  @Inject
  @Accessors
  private IProjectConfigProvider projectInformationProvider;

  @Inject
  @Accessors
  private IContextualOutputConfigurationProvider outputConfigurationProvider;

  @Accessors
  private Resource context;

  protected IProjectConfig getProjectConfig(final Path path) {
    final String firstSegment = path.getSegments().get(0);
    final IProjectConfig projectConfig = this.projectInformationProvider.getProjectConfig(this.context.getResourceSet());
    if (((projectConfig == null) || (!Objects.equal(projectConfig.getName(), firstSegment)))) {
      throw new IllegalArgumentException((("The project \'" + firstSegment) + "\' has not been configured."));
    }
    return projectConfig;
  }

  @Override
  public Path getSourceFolder(final Path path) {
    final Function1<Path, Boolean> _function = (Path sourceFolder) -> {
      return Boolean.valueOf(path.startsWith(sourceFolder));
    };
    return IterableExtensions.<Path>findFirst(this.getProjectSourceFolders(path), _function);
  }

  @Override
  public Path getTargetFolder(final Path path) {
    Path _xblockexpression = null;
    {
      final Path projectFolder = this.getProjectFolder(path);
      if ((projectFolder == null)) {
        return null;
      }
      final OutputConfiguration outputConfiguration = IterableExtensions.<OutputConfiguration>head(this.outputConfigurationProvider.getOutputConfigurations(this.context));
      final Path sourceFolder = this.getSourceFolder(path);
      String _xifexpression = null;
      if ((sourceFolder == null)) {
        _xifexpression = outputConfiguration.getOutputDirectory();
      } else {
        String _xblockexpression_1 = null;
        {
          final String projectRelativeSourceFolder = IterableExtensions.join(IterableExtensions.<String>tail(sourceFolder.getSegments()), "/");
          _xblockexpression_1 = outputConfiguration.getOutputDirectory(projectRelativeSourceFolder);
        }
        _xifexpression = _xblockexpression_1;
      }
      final String outputFolder = _xifexpression;
      _xblockexpression = projectFolder.append(outputFolder);
    }
    return _xblockexpression;
  }

  @Override
  public Path getProjectFolder(final Path path) {
    final IProjectConfig config = this.getProjectConfig(path);
    return Path.ROOT.append(config.getName());
  }

  @Override
  public Set<Path> getProjectSourceFolders(final Path path) {
    final Function1<ISourceFolder, Path> _function = (ISourceFolder it) -> {
      return this.getProjectFolder(path).append(it.getName());
    };
    return IterableExtensions.<Path>toSet(IterableExtensions.map(this.getProjectConfig(path).getSourceFolders(), _function));
  }

  @Pure
  public IProjectConfigProvider getProjectInformationProvider() {
    return this.projectInformationProvider;
  }

  public void setProjectInformationProvider(final IProjectConfigProvider projectInformationProvider) {
    this.projectInformationProvider = projectInformationProvider;
  }

  @Pure
  public IContextualOutputConfigurationProvider getOutputConfigurationProvider() {
    return this.outputConfigurationProvider;
  }

  public void setOutputConfigurationProvider(final IContextualOutputConfigurationProvider outputConfigurationProvider) {
    this.outputConfigurationProvider = outputConfigurationProvider;
  }

  @Pure
  public Resource getContext() {
    return this.context;
  }

  public void setContext(final Resource context) {
    this.context = context;
  }
}

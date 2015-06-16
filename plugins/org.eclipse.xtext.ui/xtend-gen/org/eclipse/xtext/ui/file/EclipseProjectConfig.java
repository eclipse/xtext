/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.file;

import com.google.common.collect.Iterables;
import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.ui.file.EclipseSourceFolder;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class EclipseProjectConfig implements IProjectConfig {
  private final IProject project;
  
  private final Resource context;
  
  private final IContextualOutputConfigurationProvider configurationProvider;
  
  @Override
  public String getName() {
    return this.project.getName();
  }
  
  @Override
  public URI getPath() {
    String _name = this.getName();
    String _plus = ("/" + _name);
    return URI.createPlatformResourceURI(_plus, true);
  }
  
  @Override
  public Set<? extends ISourceFolder> getSourceFolders() {
    Set<EclipseSourceFolder> _xblockexpression = null;
    {
      final Set<OutputConfiguration> outputConfigurations = this.configurationProvider.getOutputConfigurations(this.context);
      final Function1<OutputConfiguration, Set<String>> _function = new Function1<OutputConfiguration, Set<String>>() {
        @Override
        public Set<String> apply(final OutputConfiguration it) {
          return it.getSourceFolders();
        }
      };
      Iterable<Set<String>> _map = IterableExtensions.<OutputConfiguration, Set<String>>map(outputConfigurations, _function);
      final Iterable<String> sourceFolders = Iterables.<String>concat(_map);
      final Function1<String, EclipseSourceFolder> _function_1 = new Function1<String, EclipseSourceFolder>() {
        @Override
        public EclipseSourceFolder apply(final String it) {
          return new EclipseSourceFolder(EclipseProjectConfig.this.project, it);
        }
      };
      Iterable<EclipseSourceFolder> _map_1 = IterableExtensions.<String, EclipseSourceFolder>map(sourceFolders, _function_1);
      _xblockexpression = IterableExtensions.<EclipseSourceFolder>toSet(_map_1);
    }
    return _xblockexpression;
  }
  
  @Override
  public ISourceFolder findSourceFolderContaing(final URI member) {
    Set<? extends ISourceFolder> _sourceFolders = this.getSourceFolders();
    final Function1<ISourceFolder, Boolean> _function = new Function1<ISourceFolder, Boolean>() {
      @Override
      public Boolean apply(final ISourceFolder folder) {
        URI _path = folder.getPath();
        URI _deresolve = member.deresolve(_path);
        return Boolean.valueOf(_deresolve.isRelative());
      }
    };
    return IterableExtensions.findFirst(_sourceFolders, _function);
  }
  
  public EclipseProjectConfig(final IProject project, final Resource context, final IContextualOutputConfigurationProvider configurationProvider) {
    super();
    this.project = project;
    this.context = context;
    this.configurationProvider = configurationProvider;
  }
}

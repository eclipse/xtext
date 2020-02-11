/**
 * Copyright (c) 2015, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.wizard.AbstractFile;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.SourceFolderDescriptor;
import org.eclipse.xtext.xtext.wizard.TestProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@FinalFieldsConstructor
@SuppressWarnings("all")
public abstract class TestedProjectDescriptor extends ProjectDescriptor {
  public abstract TestProjectDescriptor getTestProject();
  
  @Override
  public Set<ExternalDependency> getExternalDependencies() {
    LinkedHashSet<ExternalDependency> _xblockexpression = null;
    {
      final LinkedHashSet<ExternalDependency> deps = CollectionLiterals.<ExternalDependency>newLinkedHashSet();
      Set<ExternalDependency> _externalDependencies = super.getExternalDependencies();
      Iterables.<ExternalDependency>addAll(deps, _externalDependencies);
      boolean _isInlined = this.getTestProject().isInlined();
      if (_isInlined) {
        Set<ExternalDependency> _externalDependencies_1 = this.getTestProject().getExternalDependencies();
        Iterables.<ExternalDependency>addAll(deps, _externalDependencies_1);
      }
      _xblockexpression = deps;
    }
    return _xblockexpression;
  }
  
  @Override
  public Set<SourceFolderDescriptor> getSourceFolders() {
    LinkedHashSet<SourceFolderDescriptor> _xblockexpression = null;
    {
      final LinkedHashSet<SourceFolderDescriptor> sourceFolders = CollectionLiterals.<SourceFolderDescriptor>newLinkedHashSet();
      Set<SourceFolderDescriptor> _sourceFolders = super.getSourceFolders();
      Iterables.<SourceFolderDescriptor>addAll(sourceFolders, _sourceFolders);
      boolean _isInlined = this.getTestProject().isInlined();
      if (_isInlined) {
        Set<SourceFolderDescriptor> _sourceFolders_1 = this.getTestProject().getSourceFolders();
        Iterables.<SourceFolderDescriptor>addAll(sourceFolders, _sourceFolders_1);
      }
      _xblockexpression = sourceFolders;
    }
    return _xblockexpression;
  }
  
  @Override
  public Iterable<? extends AbstractFile> getFiles() {
    ArrayList<AbstractFile> _xblockexpression = null;
    {
      final ArrayList<AbstractFile> files = CollectionLiterals.<AbstractFile>newArrayList();
      Iterable<? extends AbstractFile> _files = super.getFiles();
      Iterables.<AbstractFile>addAll(files, _files);
      boolean _isInlined = this.getTestProject().isInlined();
      if (_isInlined) {
        final Function1<AbstractFile, Boolean> _function = (AbstractFile fileFromTestProject) -> {
          final Function1<AbstractFile, Boolean> _function_1 = (AbstractFile it) -> {
            String _relativePath = it.getRelativePath();
            String _relativePath_1 = fileFromTestProject.getRelativePath();
            return Boolean.valueOf(Objects.equal(_relativePath, _relativePath_1));
          };
          boolean _exists = IterableExtensions.<AbstractFile>exists(files, _function_1);
          return Boolean.valueOf((!_exists));
        };
        Iterable<? extends AbstractFile> _filter = IterableExtensions.filter(this.getTestProject().getFiles(), _function);
        Iterables.<AbstractFile>addAll(files, _filter);
      }
      _xblockexpression = files;
    }
    return _xblockexpression;
  }
  
  public TestedProjectDescriptor(final WizardConfiguration config) {
    super(config);
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
      TestProjectDescriptor _testProject = this.getTestProject();
      boolean _isInlined = _testProject.isInlined();
      if (_isInlined) {
        TestProjectDescriptor _testProject_1 = this.getTestProject();
        Set<ExternalDependency> _externalDependencies_1 = _testProject_1.getExternalDependencies();
        Iterables.<ExternalDependency>addAll(deps, _externalDependencies_1);
      }
      _xblockexpression = deps;
    }
    return _xblockexpression;
  }
  
  @Override
  public Set<String> getSourceFolders() {
    LinkedHashSet<String> _xblockexpression = null;
    {
      final LinkedHashSet<String> sourceFolders = CollectionLiterals.<String>newLinkedHashSet();
      Set<String> _sourceFolders = super.getSourceFolders();
      Iterables.<String>addAll(sourceFolders, _sourceFolders);
      TestProjectDescriptor _testProject = this.getTestProject();
      boolean _isInlined = _testProject.isInlined();
      if (_isInlined) {
        TestProjectDescriptor _testProject_1 = this.getTestProject();
        Set<String> _sourceFolders_1 = _testProject_1.getSourceFolders();
        Iterables.<String>addAll(sourceFolders, _sourceFolders_1);
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
      TestProjectDescriptor _testProject = this.getTestProject();
      boolean _isInlined = _testProject.isInlined();
      if (_isInlined) {
        TestProjectDescriptor _testProject_1 = this.getTestProject();
        Iterable<? extends AbstractFile> _files_1 = _testProject_1.getFiles();
        final Function1<AbstractFile, Boolean> _function = new Function1<AbstractFile, Boolean>() {
          @Override
          public Boolean apply(final AbstractFile fileFromTestProject) {
            final Function1<AbstractFile, Boolean> _function = new Function1<AbstractFile, Boolean>() {
              @Override
              public Boolean apply(final AbstractFile it) {
                String _relativePath = it.getRelativePath();
                String _relativePath_1 = fileFromTestProject.getRelativePath();
                return Boolean.valueOf(Objects.equal(_relativePath, _relativePath_1));
              }
            };
            boolean _exists = IterableExtensions.<AbstractFile>exists(files, _function);
            return Boolean.valueOf((!_exists));
          }
        };
        Iterable<? extends AbstractFile> _filter = IterableExtensions.filter(_files_1, _function);
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

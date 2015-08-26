package org.eclipse.xtext.xtext.wizard;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.GeneratedFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TestProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@FinalFieldsConstructor
@SuppressWarnings("all")
public abstract class TestedProjectDescriptor extends ProjectDescriptor {
  public abstract TestProjectDescriptor getTestProject();
  
  @Override
  public Set<ExternalDependency> getExternalDependencies() {
    HashSet<ExternalDependency> _xblockexpression = null;
    {
      final HashSet<ExternalDependency> deps = CollectionLiterals.<ExternalDependency>newHashSet();
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
    HashSet<String> _xblockexpression = null;
    {
      final HashSet<String> sourceFolders = CollectionLiterals.<String>newHashSet();
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
  public Iterable<? extends GeneratedFile> getFiles() {
    ArrayList<GeneratedFile> _xblockexpression = null;
    {
      final ArrayList<GeneratedFile> files = CollectionLiterals.<GeneratedFile>newArrayList();
      Iterable<? extends GeneratedFile> _files = super.getFiles();
      Iterables.<GeneratedFile>addAll(files, _files);
      TestProjectDescriptor _testProject = this.getTestProject();
      boolean _isInlined = _testProject.isInlined();
      if (_isInlined) {
        TestProjectDescriptor _testProject_1 = this.getTestProject();
        Iterable<? extends GeneratedFile> _files_1 = _testProject_1.getFiles();
        Iterables.<GeneratedFile>addAll(files, _files_1);
      }
      _xblockexpression = files;
    }
    return _xblockexpression;
  }
  
  public TestedProjectDescriptor(final WizardConfiguration config) {
    super(config);
  }
}

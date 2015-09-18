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
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TestProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TextFile;
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
  public Iterable<? extends TextFile> getFiles() {
    ArrayList<TextFile> _xblockexpression = null;
    {
      final ArrayList<TextFile> files = CollectionLiterals.<TextFile>newArrayList();
      Iterable<? extends TextFile> _files = super.getFiles();
      Iterables.<TextFile>addAll(files, _files);
      TestProjectDescriptor _testProject = this.getTestProject();
      boolean _isInlined = _testProject.isInlined();
      if (_isInlined) {
        TestProjectDescriptor _testProject_1 = this.getTestProject();
        Iterable<? extends TextFile> _files_1 = _testProject_1.getFiles();
        final Function1<TextFile, Boolean> _function = new Function1<TextFile, Boolean>() {
          @Override
          public Boolean apply(final TextFile fileFromTestProject) {
            final Function1<TextFile, Boolean> _function = new Function1<TextFile, Boolean>() {
              @Override
              public Boolean apply(final TextFile it) {
                String _relativePath = it.getRelativePath();
                String _relativePath_1 = fileFromTestProject.getRelativePath();
                return Boolean.valueOf(Objects.equal(_relativePath, _relativePath_1));
              }
            };
            boolean _exists = IterableExtensions.<TextFile>exists(files, _function);
            return Boolean.valueOf((!_exists));
          }
        };
        Iterable<? extends TextFile> _filter = IterableExtensions.filter(_files_1, _function);
        Iterables.<TextFile>addAll(files, _filter);
      }
      _xblockexpression = files;
    }
    return _xblockexpression;
  }
  
  public TestedProjectDescriptor(final WizardConfiguration config) {
    super(config);
  }
}

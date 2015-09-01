package org.eclipse.xtext.xtext.wizard;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.UiProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class IdeProjectDescriptor extends ProjectDescriptor {
  @Override
  public String getNameQualifier() {
    return ".ide";
  }
  
  @Override
  public Set<? extends ProjectDescriptor> getUpstreamProjects() {
    WizardConfiguration _config = this.getConfig();
    RuntimeProjectDescriptor _runtimeProject = _config.getRuntimeProject();
    return Collections.<ProjectDescriptor>unmodifiableSet(CollectionLiterals.<ProjectDescriptor>newHashSet(_runtimeProject));
  }
  
  @Override
  public boolean isEclipsePluginProject() {
    boolean _or = false;
    WizardConfiguration _config = this.getConfig();
    BuildSystem _buildSystem = _config.getBuildSystem();
    boolean _isPluginBuild = _buildSystem.isPluginBuild();
    if (_isPluginBuild) {
      _or = true;
    } else {
      WizardConfiguration _config_1 = this.getConfig();
      UiProjectDescriptor _uiProject = _config_1.getUiProject();
      boolean _isEnabled = _uiProject.isEnabled();
      _or = _isEnabled;
    }
    return _or;
  }
  
  @Override
  public Set<ExternalDependency> getExternalDependencies() {
    HashSet<ExternalDependency> _xblockexpression = null;
    {
      final HashSet<ExternalDependency> deps = CollectionLiterals.<ExternalDependency>newHashSet();
      Set<ExternalDependency> _externalDependencies = super.getExternalDependencies();
      Iterables.<ExternalDependency>addAll(deps, _externalDependencies);
      ExternalDependency _createXtextDependency = ExternalDependency.createXtextDependency("org.eclipse.xtext.ide");
      deps.add(_createXtextDependency);
      ExternalDependency _createXtextDependency_1 = ExternalDependency.createXtextDependency("org.eclipse.xtext.xbase.ide");
      deps.add(_createXtextDependency_1);
      _xblockexpression = deps;
    }
    return _xblockexpression;
  }
  
  @Override
  public PomFile pom() {
    PomFile _pom = super.pom();
    final Procedure1<PomFile> _function = new Procedure1<PomFile>() {
      @Override
      public void apply(final PomFile it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<build>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<plugins>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<plugin>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<groupId>org.eclipse.xtend</groupId>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<artifactId>xtend-maven-plugin</artifactId>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</plugin>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("</plugins>");
        _builder.newLine();
        _builder.append("</build>");
        _builder.newLine();
        it.setBuildSection(_builder.toString());
        String _xifexpression = null;
        boolean _isEclipsePluginProject = IdeProjectDescriptor.this.isEclipsePluginProject();
        if (_isEclipsePluginProject) {
          _xifexpression = "eclipse-plugin";
        } else {
          _xifexpression = "jar";
        }
        it.setPackaging(_xifexpression);
      }
    };
    return ObjectExtensions.<PomFile>operator_doubleArrow(_pom, _function);
  }
  
  public IdeProjectDescriptor(final WizardConfiguration config) {
    super(config);
  }
}

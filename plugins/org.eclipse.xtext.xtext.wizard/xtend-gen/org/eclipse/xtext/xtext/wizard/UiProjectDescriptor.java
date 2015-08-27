package org.eclipse.xtext.xtext.wizard;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.GradleBuildFile;
import org.eclipse.xtext.xtext.wizard.IdeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class UiProjectDescriptor extends ProjectDescriptor {
  @Override
  public Set<? extends ProjectDescriptor> getUpstreamProjects() {
    WizardConfiguration _config = this.getConfig();
    RuntimeProjectDescriptor _runtimeProject = _config.getRuntimeProject();
    WizardConfiguration _config_1 = this.getConfig();
    IdeProjectDescriptor _ideProject = _config_1.getIdeProject();
    final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ProjectDescriptor it) {
        return Boolean.valueOf(it.isEnabled());
      }
    };
    Iterable<? extends ProjectDescriptor> _filter = IterableExtensions.filter(Collections.<ProjectDescriptor>unmodifiableSet(CollectionLiterals.<ProjectDescriptor>newHashSet(_runtimeProject, _ideProject)), _function);
    return IterableExtensions.toSet(_filter);
  }
  
  @Override
  public String getNameQualifier() {
    return ".ui";
  }
  
  @Override
  public boolean isEclipsePluginProject() {
    return true;
  }
  
  @Override
  public Set<ExternalDependency> getExternalDependencies() {
    HashSet<ExternalDependency> _xblockexpression = null;
    {
      final HashSet<ExternalDependency> deps = CollectionLiterals.<ExternalDependency>newHashSet();
      Set<ExternalDependency> _externalDependencies = super.getExternalDependencies();
      Iterables.<ExternalDependency>addAll(deps, _externalDependencies);
      ExternalDependency _createXtextDependency = ExternalDependency.createXtextDependency("org.eclipse.xtext.ui");
      deps.add(_createXtextDependency);
      ExternalDependency _externalDependency = new ExternalDependency();
      final Procedure1<ExternalDependency> _function = new Procedure1<ExternalDependency>() {
        @Override
        public void apply(final ExternalDependency it) {
          final Procedure1<ExternalDependency.P2Coordinates> _function = new Procedure1<ExternalDependency.P2Coordinates>() {
            @Override
            public void apply(final ExternalDependency.P2Coordinates it) {
              it.setBundleId("org.eclipse.ui.editors");
              it.setVersion("3.5.0");
            }
          };
          it.p2(_function);
        }
      };
      ExternalDependency _doubleArrow = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_externalDependency, _function);
      deps.add(_doubleArrow);
      ExternalDependency _externalDependency_1 = new ExternalDependency();
      final Procedure1<ExternalDependency> _function_1 = new Procedure1<ExternalDependency>() {
        @Override
        public void apply(final ExternalDependency it) {
          final Procedure1<ExternalDependency.P2Coordinates> _function = new Procedure1<ExternalDependency.P2Coordinates>() {
            @Override
            public void apply(final ExternalDependency.P2Coordinates it) {
              it.setBundleId("org.eclipse.ui.ide");
              it.setVersion("3.5.0");
            }
          };
          it.p2(_function);
        }
      };
      ExternalDependency _doubleArrow_1 = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_externalDependency_1, _function_1);
      deps.add(_doubleArrow_1);
      WizardConfiguration _config = this.getConfig();
      IdeProjectDescriptor _ideProject = _config.getIdeProject();
      boolean _isEnabled = _ideProject.isEnabled();
      boolean _not = (!_isEnabled);
      if (_not) {
        WizardConfiguration _config_1 = this.getConfig();
        IdeProjectDescriptor _ideProject_1 = _config_1.getIdeProject();
        Set<ExternalDependency> _externalDependencies_1 = _ideProject_1.getExternalDependencies();
        Iterables.<ExternalDependency>addAll(deps, _externalDependencies_1);
      }
      _xblockexpression = deps;
    }
    return _xblockexpression;
  }
  
  @Override
  public Set<String> getBinIncludes() {
    HashSet<String> _xblockexpression = null;
    {
      final HashSet<String> includes = CollectionLiterals.<String>newHashSet();
      Set<String> _binIncludes = super.getBinIncludes();
      Iterables.<String>addAll(includes, _binIncludes);
      includes.add("plugin.xml");
      _xblockexpression = includes;
    }
    return _xblockexpression;
  }
  
  @Override
  public GradleBuildFile buildGradle() {
    throw new UnsupportedOperationException("UI projects cannot be built with Gradle yet");
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
        it.setPackaging("eclipse-plugin");
      }
    };
    return ObjectExtensions.<PomFile>operator_doubleArrow(_pom, _function);
  }
  
  public UiProjectDescriptor(final WizardConfiguration config) {
    super(config);
  }
}

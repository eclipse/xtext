package org.eclipse.xtext.xtext.wizard;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.Scope;
import org.eclipse.xtext.xtext.wizard.TextFile;

@SuppressWarnings("all")
public class GradleBuildFile extends TextFile {
  @Accessors
  private String pluginsSection = "";
  
  @Accessors
  private String additionalContent = "";
  
  public GradleBuildFile(final ProjectDescriptor project) {
    super(Outlet.ROOT, "build.gradle", project);
  }
  
  @Override
  public String getContent() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.pluginsSection, "");
    _builder.newLineIfNotEmpty();
    {
      Iterable<Object> _allDependencies = this.getAllDependencies();
      boolean _isEmpty = IterableExtensions.isEmpty(_allDependencies);
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("dependencies {");
        _builder.newLine();
        {
          ProjectDescriptor _project = this.getProject();
          Set<? extends ProjectDescriptor> _upstreamProjects = _project.getUpstreamProjects();
          for(final ProjectDescriptor p : _upstreamProjects) {
            _builder.append("\t");
            _builder.append("compile project(\':");
            String _name = p.getName();
            _builder.append(_name, "\t");
            _builder.append("\')");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          Iterable<ExternalDependency.MavenCoordinates> _mavenDependencies = this.getMavenDependencies();
          for(final ExternalDependency.MavenCoordinates dep : _mavenDependencies) {
            _builder.append("\t");
            Scope _scope = dep.getScope();
            String _gradleNotation = _scope.getGradleNotation();
            _builder.append(_gradleNotation, "\t");
            _builder.append(" \"");
            String _groupId = dep.getGroupId();
            _builder.append(_groupId, "\t");
            _builder.append(":");
            String _artifactId = dep.getArtifactId();
            _builder.append(_artifactId, "\t");
            _builder.append(":");
            String _version = dep.getVersion();
            _builder.append(_version, "\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append(this.additionalContent, "");
    _builder.newLineIfNotEmpty();
    {
      ProjectDescriptor _project_1 = this.getProject();
      boolean _isEclipsePluginProject = _project_1.isEclipsePluginProject();
      if (_isEclipsePluginProject) {
        _builder.append("//this is an eclipse plugin project");
        _builder.newLine();
        _builder.append("eclipseClasspath.enabled=false");
        _builder.newLine();
      }
    }
    return _builder.toString();
  }
  
  private Iterable<ExternalDependency.MavenCoordinates> getMavenDependencies() {
    ProjectDescriptor _project = this.getProject();
    Set<ExternalDependency> _externalDependencies = _project.getExternalDependencies();
    final Function1<ExternalDependency, ExternalDependency.MavenCoordinates> _function = new Function1<ExternalDependency, ExternalDependency.MavenCoordinates>() {
      @Override
      public ExternalDependency.MavenCoordinates apply(final ExternalDependency it) {
        return it.getMaven();
      }
    };
    Iterable<ExternalDependency.MavenCoordinates> _map = IterableExtensions.<ExternalDependency, ExternalDependency.MavenCoordinates>map(_externalDependencies, _function);
    final Function1<ExternalDependency.MavenCoordinates, Boolean> _function_1 = new Function1<ExternalDependency.MavenCoordinates, Boolean>() {
      @Override
      public Boolean apply(final ExternalDependency.MavenCoordinates it) {
        String _artifactId = it.getArtifactId();
        return Boolean.valueOf((!Objects.equal(_artifactId, null)));
      }
    };
    return IterableExtensions.<ExternalDependency.MavenCoordinates>filter(_map, _function_1);
  }
  
  private Iterable<Object> getAllDependencies() {
    ProjectDescriptor _project = this.getProject();
    Set<? extends ProjectDescriptor> _upstreamProjects = _project.getUpstreamProjects();
    Iterable<ExternalDependency.MavenCoordinates> _mavenDependencies = this.getMavenDependencies();
    return Iterables.<Object>concat(_upstreamProjects, _mavenDependencies);
  }
  
  @Pure
  public String getPluginsSection() {
    return this.pluginsSection;
  }
  
  public void setPluginsSection(final String pluginsSection) {
    this.pluginsSection = pluginsSection;
  }
  
  @Pure
  public String getAdditionalContent() {
    return this.additionalContent;
  }
  
  public void setAdditionalContent(final String additionalContent) {
    this.additionalContent = additionalContent;
  }
}

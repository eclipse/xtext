/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

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
    _builder.append(this.pluginsSection);
    _builder.newLineIfNotEmpty();
    {
      boolean _isEmpty = IterableExtensions.isEmpty(this.getAllDependencies());
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("dependencies {");
        _builder.newLine();
        {
          Set<? extends ProjectDescriptor> _upstreamProjects = this.getProject().getUpstreamProjects();
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
            {
              String _version = dep.getVersion();
              boolean _tripleNotEquals = (_version != null);
              if (_tripleNotEquals) {
                _builder.append("\t");
                String _gradleNotation = dep.getScope().getGradleNotation();
                _builder.append(_gradleNotation, "\t");
                _builder.append(" \"");
                String _groupId = dep.getGroupId();
                _builder.append(_groupId, "\t");
                _builder.append(":");
                String _artifactId = dep.getArtifactId();
                _builder.append(_artifactId, "\t");
                _builder.append(":");
                String _version_1 = dep.getVersion();
                _builder.append(_version_1, "\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                String _gradleNotation_1 = dep.getScope().getGradleNotation();
                _builder.append(_gradleNotation_1, "\t");
                _builder.append(" \'");
                String _groupId_1 = dep.getGroupId();
                _builder.append(_groupId_1, "\t");
                _builder.append(":");
                String _artifactId_1 = dep.getArtifactId();
                _builder.append(_artifactId_1, "\t");
                _builder.append("\'");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append(this.additionalContent);
    _builder.newLineIfNotEmpty();
    {
      boolean _isEclipsePluginProject = this.getProject().isEclipsePluginProject();
      if (_isEclipsePluginProject) {
        _builder.append("//this is an eclipse plugin project");
        _builder.newLine();
        _builder.append("eclipseClasspath.enabled=false");
        _builder.newLine();
        _builder.append("cleanEclipseClasspath.enabled=false");
        _builder.newLine();
      }
    }
    return _builder.toString();
  }
  
  private Iterable<ExternalDependency.MavenCoordinates> getMavenDependencies() {
    final Function1<ExternalDependency, ExternalDependency.MavenCoordinates> _function = (ExternalDependency it) -> {
      return it.getMaven();
    };
    final Function1<ExternalDependency.MavenCoordinates, Boolean> _function_1 = (ExternalDependency.MavenCoordinates it) -> {
      String _artifactId = it.getArtifactId();
      return Boolean.valueOf((_artifactId != null));
    };
    return IterableExtensions.<ExternalDependency.MavenCoordinates>filter(IterableExtensions.<ExternalDependency, ExternalDependency.MavenCoordinates>map(this.getProject().getExternalDependencies(), _function), _function_1);
  }
  
  private Iterable<Object> getAllDependencies() {
    Set<? extends ProjectDescriptor> _upstreamProjects = this.getProject().getUpstreamProjects();
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

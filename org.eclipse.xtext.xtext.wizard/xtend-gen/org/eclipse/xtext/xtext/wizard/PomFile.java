/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard;

import com.google.common.base.Objects;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.ParentProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.Scope;
import org.eclipse.xtext.xtext.wizard.TextFile;

@SuppressWarnings("all")
public class PomFile extends TextFile {
  @Accessors
  private String packaging = "jar";
  
  @Accessors
  private String buildSection = "";
  
  @Accessors
  private String profileSection = "";
  
  public PomFile(final ProjectDescriptor project) {
    super(Outlet.ROOT, "pom.xml", project);
  }
  
  @Override
  public String getContent() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<modelVersion>4.0.0</modelVersion>");
    _builder.newLine();
    {
      ProjectDescriptor _project = this.getProject();
      ParentProjectDescriptor _parentProject = this.getProject().getConfig().getParentProject();
      boolean _notEquals = (!Objects.equal(_project, _parentProject));
      if (_notEquals) {
        _builder.append("\t");
        _builder.append("<parent>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<groupId>");
        String _baseName = this.getProject().getConfig().getBaseName();
        _builder.append(_baseName, "\t\t");
        _builder.append("</groupId>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<artifactId>");
        String _name = this.getProject().getConfig().getParentProject().getName();
        _builder.append(_name, "\t\t");
        _builder.append("</artifactId>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<version>1.0.0-SNAPSHOT</version>");
        _builder.newLine();
        {
          ProjectLayout _projectLayout = this.getProject().getConfig().getProjectLayout();
          boolean _equals = Objects.equal(_projectLayout, ProjectLayout.FLAT);
          if (_equals) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<relativePath>../");
            String _name_1 = this.getProject().getConfig().getParentProject().getName();
            _builder.append(_name_1, "\t\t");
            _builder.append("/pom.xml</relativePath>");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("</parent>");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("<groupId>");
        String _baseName_1 = this.getProject().getConfig().getBaseName();
        _builder.append(_baseName_1, "\t");
        _builder.append("</groupId>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("<version>1.0.0-SNAPSHOT</version>");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("<artifactId>");
    String _name_2 = this.getProject().getName();
    _builder.append(_name_2, "\t");
    _builder.append("</artifactId>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<packaging>");
    _builder.append(this.packaging, "\t");
    _builder.append("</packaging>");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append(this.buildSection, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _isEclipsePluginProject = this.getProject().isEclipsePluginProject();
      boolean _not = (!_isEclipsePluginProject);
      if (_not) {
        _builder.append("\t");
        _builder.append("<dependencies>");
        _builder.newLine();
        {
          Set<? extends ProjectDescriptor> _upstreamProjects = this.getProject().getUpstreamProjects();
          for(final ProjectDescriptor p : _upstreamProjects) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<dependency>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<groupId>${project.groupId}</groupId>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<artifactId>");
            String _name_3 = p.getName();
            _builder.append(_name_3, "\t\t\t");
            _builder.append("</artifactId>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<version>${project.version}</version>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("</dependency>");
            _builder.newLine();
          }
        }
        {
          final Function1<ExternalDependency, ExternalDependency.MavenCoordinates> _function = (ExternalDependency it) -> {
            return it.getMaven();
          };
          final Function1<ExternalDependency.MavenCoordinates, Boolean> _function_1 = (ExternalDependency.MavenCoordinates it) -> {
            String _artifactId = it.getArtifactId();
            return Boolean.valueOf((_artifactId != null));
          };
          Iterable<ExternalDependency.MavenCoordinates> _filter = IterableExtensions.<ExternalDependency.MavenCoordinates>filter(IterableExtensions.<ExternalDependency, ExternalDependency.MavenCoordinates>map(this.getProject().getExternalDependencies(), _function), _function_1);
          for(final ExternalDependency.MavenCoordinates dep : _filter) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<dependency>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<groupId>");
            String _groupId = dep.getGroupId();
            _builder.append(_groupId, "\t\t\t");
            _builder.append("</groupId>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<artifactId>");
            String _artifactId = dep.getArtifactId();
            _builder.append(_artifactId, "\t\t\t");
            _builder.append("</artifactId>");
            _builder.newLineIfNotEmpty();
            {
              String _version = dep.getVersion();
              boolean _tripleNotEquals = (_version != null);
              if (_tripleNotEquals) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("<version>");
                String _version_1 = dep.getVersion();
                _builder.append(_version_1, "\t\t\t");
                _builder.append("</version>");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              Scope _scope = dep.getScope();
              boolean _notEquals_1 = (!Objects.equal(_scope, Scope.COMPILE));
              if (_notEquals_1) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("<scope>");
                String _mavenNotation = dep.getScope().getMavenNotation();
                _builder.append(_mavenNotation, "\t\t\t");
                _builder.append("</scope>");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isOptional = dep.isOptional();
              if (_isOptional) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("<optional>true</optional>");
                _builder.newLine();
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("</dependency>");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("</dependencies>");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append(this.profileSection, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</project>");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Pure
  public String getPackaging() {
    return this.packaging;
  }
  
  public void setPackaging(final String packaging) {
    this.packaging = packaging;
  }
  
  @Pure
  public String getBuildSection() {
    return this.buildSection;
  }
  
  public void setBuildSection(final String buildSection) {
    this.buildSection = buildSection;
  }
  
  @Pure
  public String getProfileSection() {
    return this.profileSection;
  }
  
  public void setProfileSection(final String profileSection) {
    this.profileSection = profileSection;
  }
}

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
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.Scope;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TestedProjectDescriptor;

@SuppressWarnings("all")
public abstract class TestProjectDescriptor extends ProjectDescriptor {
  @Accessors
  private final ProjectDescriptor testedProject;
  
  public TestProjectDescriptor(final TestedProjectDescriptor testedProject) {
    super(testedProject.getConfig());
    this.testedProject = testedProject;
  }
  
  @Override
  public Set<String> getSourceFolders() {
    final Function1<Outlet, String> _function = (Outlet it) -> {
      return this.sourceFolder(it);
    };
    List<String> _map = ListExtensions.<Outlet, String>map(Collections.<Outlet>unmodifiableList(CollectionLiterals.<Outlet>newArrayList(Outlet.TEST_JAVA, Outlet.TEST_RESOURCES, Outlet.TEST_SRC_GEN, Outlet.TEST_XTEND_GEN)), _function);
    return IterableExtensions.<String>toSet(_map);
  }
  
  public boolean isInlined() {
    return (this.isEnabled() && (!Objects.equal(this.getConfig().getSourceLayout(), SourceLayout.PLAIN)));
  }
  
  public boolean isSeparate() {
    return (this.isEnabled() && Objects.equal(this.getConfig().getSourceLayout(), SourceLayout.PLAIN));
  }
  
  @Override
  public String getNameQualifier() {
    String _nameQualifier = this.testedProject.getNameQualifier();
    return (_nameQualifier + ".tests");
  }
  
  @Override
  public Set<? extends ProjectDescriptor> getUpstreamProjects() {
    return Collections.<ProjectDescriptor>unmodifiableSet(CollectionLiterals.<ProjectDescriptor>newHashSet(this.testedProject));
  }
  
  @Override
  public boolean isEclipsePluginProject() {
    return this.testedProject.isEclipsePluginProject();
  }
  
  @Override
  public Set<ExternalDependency> getExternalDependencies() {
    final LinkedHashSet<ExternalDependency> deps = CollectionLiterals.<ExternalDependency>newLinkedHashSet();
    Set<ExternalDependency> _externalDependencies = super.getExternalDependencies();
    Iterables.<ExternalDependency>addAll(deps, _externalDependencies);
    ExternalDependency _externalDependency = new ExternalDependency();
    final Procedure1<ExternalDependency> _function = (ExternalDependency it) -> {
      ExternalDependency.P2Coordinates _p2 = it.getP2();
      _p2.setBundleId("org.junit");
      ExternalDependency.P2Coordinates _p2_1 = it.getP2();
      _p2_1.setVersion("4.12.0");
      ExternalDependency.MavenCoordinates _maven = it.getMaven();
      _maven.setGroupId("junit");
      ExternalDependency.MavenCoordinates _maven_1 = it.getMaven();
      _maven_1.setArtifactId("junit");
      ExternalDependency.MavenCoordinates _maven_2 = it.getMaven();
      _maven_2.setVersion("4.12");
      ExternalDependency.MavenCoordinates _maven_3 = it.getMaven();
      _maven_3.setScope(Scope.TESTCOMPILE);
    };
    ExternalDependency _doubleArrow = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_externalDependency, _function);
    deps.add(_doubleArrow);
    return deps;
  }
  
  @Override
  public PomFile pom() {
    PomFile _pom = super.pom();
    final Procedure1<PomFile> _function = (PomFile it) -> {
      String _xifexpression = null;
      boolean _isEclipsePluginProject = this.isEclipsePluginProject();
      if (_isEclipsePluginProject) {
        _xifexpression = "eclipse-test-plugin";
      } else {
        _xifexpression = "jar";
      }
      it.setPackaging(_xifexpression);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<build>");
      _builder.newLine();
      {
        if (((!this.isEclipsePluginProject()) && Objects.equal(this.getConfig().getSourceLayout(), SourceLayout.PLAIN))) {
          _builder.append("\t");
          _builder.append("<testSourceDirectory>");
          String _sourceFolder = this.sourceFolder(Outlet.TEST_JAVA);
          _builder.append(_sourceFolder, "\t");
          _builder.append("</testSourceDirectory>");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("<testResources>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("<testResource>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("<directory>");
          String _sourceFolder_1 = this.sourceFolder(Outlet.TEST_RESOURCES);
          _builder.append(_sourceFolder_1, "\t\t\t");
          _builder.append("</directory>");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("<excludes>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t\t");
          _builder.append("<exclude>**/*.java</exclude>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t\t");
          _builder.append("<exclude>**/*.xtend</exclude>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("</excludes>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("</testResource>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("</testResources>");
          _builder.newLine();
        }
      }
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
      {
        boolean _isEclipsePluginProject_1 = this.isEclipsePluginProject();
        if (_isEclipsePluginProject_1) {
          _builder.append("\t\t");
          _builder.append("<plugin>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("<groupId>org.eclipse.tycho</groupId>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("<artifactId>tycho-surefire-plugin</artifactId>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("<version>${tycho-version}</version>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("<configuration>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t");
          _builder.append("<failIfNoTests>false</failIfNoTests>");
          _builder.newLine();
          {
            boolean _needsUiHarness = this.needsUiHarness();
            if (_needsUiHarness) {
              _builder.append("\t\t");
              _builder.append("\t\t");
              _builder.append("<useUIHarness>true</useUIHarness>");
              _builder.newLine();
            }
          }
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("</configuration>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("</plugin>");
          _builder.newLine();
          {
            boolean _needsUiHarness_1 = this.needsUiHarness();
            if (_needsUiHarness_1) {
              _builder.append("\t\t");
              _builder.append("<plugin>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("<groupId>org.eclipse.tycho</groupId>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("<artifactId>target-platform-configuration</artifactId>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("<configuration>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t");
              _builder.append("<dependency-resolution>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t\t");
              _builder.append("<extraRequirements>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t\t\t");
              _builder.append("<!-- to get the org.eclipse.osgi.compatibility.state plugin");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t\t\t");
              _builder.append("if the target platform is Luna or later.");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t\t\t");
              _builder.append("(backward compatible with kepler and previous versions)");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t\t\t");
              _builder.append("see https://bugs.eclipse.org/bugs/show_bug.cgi?id=492149 -->");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t\t\t");
              _builder.append("<requirement>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t\t\t\t");
              _builder.append("<type>eclipse-feature</type>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t\t\t\t");
              _builder.append("<id>org.eclipse.rcp</id>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t\t\t\t");
              _builder.append("<versionRange>0.0.0</versionRange>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t\t\t");
              _builder.append("</requirement>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t\t");
              _builder.append("</extraRequirements>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t");
              _builder.append("</dependency-resolution>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("</configuration>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("</plugin>");
              _builder.newLine();
            }
          }
        }
      }
      {
        boolean _isEclipsePluginProject_2 = this.isEclipsePluginProject();
        boolean _not = (!_isEclipsePluginProject_2);
        if (_not) {
          _builder.append("\t\t");
          _builder.append("<plugin>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("<groupId>org.codehaus.mojo</groupId>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("<artifactId>build-helper-maven-plugin</artifactId>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("<version>1.9.1</version>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("<executions>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t");
          _builder.append("<execution>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t");
          _builder.append("<id>add-test-source</id>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t");
          _builder.append("<phase>initialize</phase>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t");
          _builder.append("<goals>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t\t");
          _builder.append("<goal>add-test-source</goal>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t\t");
          _builder.append("<goal>add-test-resource</goal>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t");
          _builder.append("</goals>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t");
          _builder.append("<configuration>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t\t");
          _builder.append("<sources>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t\t\t");
          _builder.append("<source>");
          String _sourceFolder_2 = this.sourceFolder(Outlet.TEST_SRC_GEN);
          _builder.append(_sourceFolder_2, "\t\t\t\t\t\t\t");
          _builder.append("</source>");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t\t\t\t");
          _builder.append("</sources>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t\t");
          _builder.append("<resources>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t\t\t");
          _builder.append("<resource>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t\t\t\t");
          _builder.append("<directory>");
          String _sourceFolder_3 = this.sourceFolder(Outlet.TEST_SRC_GEN);
          _builder.append(_sourceFolder_3, "\t\t\t\t\t\t\t\t");
          _builder.append("</directory>");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t\t\t\t\t\t");
          _builder.append("<excludes>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t\t\t\t\t");
          _builder.append("<exclude>**/*.java</exclude>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t\t\t\t");
          _builder.append("</excludes>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t\t\t");
          _builder.append("</resource>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t\t");
          _builder.append("</resources>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t\t");
          _builder.append("</configuration>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t");
          _builder.append("</execution>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("</executions>");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("</plugin>");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("</plugins>");
      _builder.newLine();
      _builder.append("</build>");
      _builder.newLine();
      it.setBuildSection(_builder.toString());
      if ((this.isEclipsePluginProject() && this.needsUiHarness())) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("<profiles>");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("<profile>");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("<id>testing-on-mac</id>");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("<activation>");
        _builder_1.newLine();
        _builder_1.append("\t\t\t");
        _builder_1.append("<os>");
        _builder_1.newLine();
        _builder_1.append("\t\t\t\t");
        _builder_1.append("<family>mac</family>");
        _builder_1.newLine();
        _builder_1.append("\t\t\t");
        _builder_1.append("</os>");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("</activation>");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("<properties>");
        _builder_1.newLine();
        _builder_1.append("\t\t\t");
        _builder_1.append("<tycho.testArgLine>-XstartOnFirstThread</tycho.testArgLine>");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("</properties>");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("</profile>");
        _builder_1.newLine();
        _builder_1.append("</profiles>");
        _builder_1.newLine();
        it.setProfileSection(_builder_1.toString());
      }
    };
    return ObjectExtensions.<PomFile>operator_doubleArrow(_pom, _function);
  }
  
  public boolean needsUiHarness() {
    return false;
  }
  
  @Pure
  public ProjectDescriptor getTestedProject() {
    return this.testedProject;
  }
}

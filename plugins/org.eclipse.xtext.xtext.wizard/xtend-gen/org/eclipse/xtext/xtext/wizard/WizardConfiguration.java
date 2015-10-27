/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.XtextVersion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.Ecore2XtextConfiguration;
import org.eclipse.xtext.xtext.wizard.IdeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.IntellijProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.ParentProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TargetPlatformProject;
import org.eclipse.xtext.xtext.wizard.TestProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TestedProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.UiProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WebProjectDescriptor;

@Accessors
@SuppressWarnings("all")
public class WizardConfiguration {
  private String rootLocation;
  
  private String baseName;
  
  private XtextVersion xtextVersion = XtextVersion.getCurrent();
  
  private final Ecore2XtextConfiguration ecore2Xtext = new Ecore2XtextConfiguration();
  
  private Charset encoding = Charset.defaultCharset();
  
  private BuildSystem preferredBuildSystem = BuildSystem.ECLIPSE;
  
  private SourceLayout sourceLayout = SourceLayout.PLAIN;
  
  private ProjectLayout projectLayout = ProjectLayout.FLAT;
  
  private final LanguageDescriptor language = new LanguageDescriptor();
  
  private final RuntimeProjectDescriptor runtimeProject = new RuntimeProjectDescriptor(this);
  
  private final IdeProjectDescriptor ideProject = new IdeProjectDescriptor(this);
  
  private final UiProjectDescriptor uiProject = new UiProjectDescriptor(this);
  
  private final IntellijProjectDescriptor intellijProject = new IntellijProjectDescriptor(this);
  
  private final WebProjectDescriptor webProject = new WebProjectDescriptor(this);
  
  private final ParentProjectDescriptor parentProject = new ParentProjectDescriptor(this);
  
  private final TargetPlatformProject targetPlatformProject = new TargetPlatformProject(this);
  
  private boolean needsGradleWrapper = true;
  
  public Set<ProjectDescriptor> getEnabledProjects() {
    ImmutableSet<ProjectDescriptor> _xblockexpression = null;
    {
      final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
        @Override
        public Boolean apply(final ProjectDescriptor it) {
          return Boolean.valueOf(it.isEnabled());
        }
      };
      final Iterable<? extends ProjectDescriptor> productionProjects = IterableExtensions.filter(Collections.<ProjectDescriptor>unmodifiableList(CollectionLiterals.<ProjectDescriptor>newArrayList(this.parentProject, this.runtimeProject, this.ideProject, this.uiProject, this.intellijProject, this.webProject, this.targetPlatformProject)), _function);
      Iterable<TestedProjectDescriptor> _filter = Iterables.<TestedProjectDescriptor>filter(productionProjects, TestedProjectDescriptor.class);
      final Function1<TestedProjectDescriptor, TestProjectDescriptor> _function_1 = new Function1<TestedProjectDescriptor, TestProjectDescriptor>() {
        @Override
        public TestProjectDescriptor apply(final TestedProjectDescriptor it) {
          return it.getTestProject();
        }
      };
      Iterable<TestProjectDescriptor> _map = IterableExtensions.<TestedProjectDescriptor, TestProjectDescriptor>map(_filter, _function_1);
      final Function1<TestProjectDescriptor, Boolean> _function_2 = new Function1<TestProjectDescriptor, Boolean>() {
        @Override
        public Boolean apply(final TestProjectDescriptor it) {
          boolean _and = false;
          boolean _isEnabled = it.isEnabled();
          if (!_isEnabled) {
            _and = false;
          } else {
            boolean _isSeparate = it.isSeparate();
            _and = _isSeparate;
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<TestProjectDescriptor> testProjects = IterableExtensions.<TestProjectDescriptor>filter(_map, _function_2);
      Iterable<ProjectDescriptor> _plus = Iterables.<ProjectDescriptor>concat(productionProjects, testProjects);
      _xblockexpression = ImmutableSet.<ProjectDescriptor>copyOf(_plus);
    }
    return _xblockexpression;
  }
  
  public boolean needsMavenBuild() {
    boolean _or = false;
    boolean _equals = Objects.equal(this.preferredBuildSystem, BuildSystem.MAVEN);
    if (_equals) {
      _or = true;
    } else {
      boolean _and = false;
      boolean _equals_1 = Objects.equal(this.preferredBuildSystem, BuildSystem.GRADLE);
      if (!_equals_1) {
        _and = false;
      } else {
        boolean _isEnabled = this.uiProject.isEnabled();
        _and = _isEnabled;
      }
      _or = _and;
    }
    return _or;
  }
  
  public boolean needsTychoBuild() {
    boolean _and = false;
    boolean _needsMavenBuild = this.needsMavenBuild();
    if (!_needsMavenBuild) {
      _and = false;
    } else {
      boolean _isEclipsePluginProject = this.runtimeProject.isEclipsePluginProject();
      _and = _isEclipsePluginProject;
    }
    return _and;
  }
  
  public boolean needsGradleBuild() {
    boolean _or = false;
    boolean _equals = Objects.equal(this.preferredBuildSystem, BuildSystem.GRADLE);
    if (_equals) {
      _or = true;
    } else {
      boolean _isEnabled = this.intellijProject.isEnabled();
      _or = _isEnabled;
    }
    return _or;
  }
  
  public boolean isNeedsGradleWrapper() {
    boolean _and = false;
    boolean _needsGradleBuild = this.needsGradleBuild();
    if (!_needsGradleBuild) {
      _and = false;
    } else {
      _and = this.needsGradleWrapper;
    }
    return _and;
  }
  
  @Pure
  public String getRootLocation() {
    return this.rootLocation;
  }
  
  public void setRootLocation(final String rootLocation) {
    this.rootLocation = rootLocation;
  }
  
  @Pure
  public String getBaseName() {
    return this.baseName;
  }
  
  public void setBaseName(final String baseName) {
    this.baseName = baseName;
  }
  
  @Pure
  public XtextVersion getXtextVersion() {
    return this.xtextVersion;
  }
  
  public void setXtextVersion(final XtextVersion xtextVersion) {
    this.xtextVersion = xtextVersion;
  }
  
  @Pure
  public Ecore2XtextConfiguration getEcore2Xtext() {
    return this.ecore2Xtext;
  }
  
  @Pure
  public Charset getEncoding() {
    return this.encoding;
  }
  
  public void setEncoding(final Charset encoding) {
    this.encoding = encoding;
  }
  
  @Pure
  public BuildSystem getPreferredBuildSystem() {
    return this.preferredBuildSystem;
  }
  
  public void setPreferredBuildSystem(final BuildSystem preferredBuildSystem) {
    this.preferredBuildSystem = preferredBuildSystem;
  }
  
  @Pure
  public SourceLayout getSourceLayout() {
    return this.sourceLayout;
  }
  
  public void setSourceLayout(final SourceLayout sourceLayout) {
    this.sourceLayout = sourceLayout;
  }
  
  @Pure
  public ProjectLayout getProjectLayout() {
    return this.projectLayout;
  }
  
  public void setProjectLayout(final ProjectLayout projectLayout) {
    this.projectLayout = projectLayout;
  }
  
  @Pure
  public LanguageDescriptor getLanguage() {
    return this.language;
  }
  
  @Pure
  public RuntimeProjectDescriptor getRuntimeProject() {
    return this.runtimeProject;
  }
  
  @Pure
  public IdeProjectDescriptor getIdeProject() {
    return this.ideProject;
  }
  
  @Pure
  public UiProjectDescriptor getUiProject() {
    return this.uiProject;
  }
  
  @Pure
  public IntellijProjectDescriptor getIntellijProject() {
    return this.intellijProject;
  }
  
  @Pure
  public WebProjectDescriptor getWebProject() {
    return this.webProject;
  }
  
  @Pure
  public ParentProjectDescriptor getParentProject() {
    return this.parentProject;
  }
  
  @Pure
  public TargetPlatformProject getTargetPlatformProject() {
    return this.targetPlatformProject;
  }
  
  public void setNeedsGradleWrapper(final boolean needsGradleWrapper) {
    this.needsGradleWrapper = needsGradleWrapper;
  }
}

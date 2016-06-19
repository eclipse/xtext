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
import org.eclipse.xtext.util.JavaVersion;
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
import org.eclipse.xtext.xtext.wizard.P2RepositoryProject;
import org.eclipse.xtext.xtext.wizard.ParentProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.SdkFeatureProject;
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
  
  private BuildSystem preferredBuildSystem = BuildSystem.NONE;
  
  private SourceLayout sourceLayout = SourceLayout.PLAIN;
  
  private ProjectLayout projectLayout = ProjectLayout.FLAT;
  
  private boolean needsGradleWrapper = true;
  
  private JavaVersion javaVersion = JavaVersion.JAVA8;
  
  private final LanguageDescriptor language = new LanguageDescriptor();
  
  private final RuntimeProjectDescriptor runtimeProject = new RuntimeProjectDescriptor(this);
  
  private final IdeProjectDescriptor ideProject = new IdeProjectDescriptor(this);
  
  private final UiProjectDescriptor uiProject = new UiProjectDescriptor(this);
  
  private final IntellijProjectDescriptor intellijProject = new IntellijProjectDescriptor(this);
  
  private final WebProjectDescriptor webProject = new WebProjectDescriptor(this);
  
  private final ParentProjectDescriptor parentProject = new ParentProjectDescriptor(this);
  
  private final TargetPlatformProject targetPlatformProject = new TargetPlatformProject(this);
  
  private final SdkFeatureProject sdkProject = new SdkFeatureProject(this);
  
  private final P2RepositoryProject p2Project = new P2RepositoryProject(this);
  
  public Set<ProjectDescriptor> getEnabledProjects() {
    ImmutableSet<ProjectDescriptor> _xblockexpression = null;
    {
      final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
        return Boolean.valueOf(it.isEnabled());
      };
      final Iterable<? extends ProjectDescriptor> productionProjects = IterableExtensions.filter(Collections.<ProjectDescriptor>unmodifiableList(CollectionLiterals.<ProjectDescriptor>newArrayList(this.parentProject, this.runtimeProject, this.ideProject, this.uiProject, this.intellijProject, this.webProject, this.targetPlatformProject, this.sdkProject, this.p2Project)), _function);
      Iterable<TestedProjectDescriptor> _filter = Iterables.<TestedProjectDescriptor>filter(productionProjects, TestedProjectDescriptor.class);
      final Function1<TestedProjectDescriptor, TestProjectDescriptor> _function_1 = (TestedProjectDescriptor it) -> {
        return it.getTestProject();
      };
      Iterable<TestProjectDescriptor> _map = IterableExtensions.<TestedProjectDescriptor, TestProjectDescriptor>map(_filter, _function_1);
      final Function1<TestProjectDescriptor, Boolean> _function_2 = (TestProjectDescriptor it) -> {
        return Boolean.valueOf((it.isEnabled() && it.isSeparate()));
      };
      final Iterable<TestProjectDescriptor> testProjects = IterableExtensions.<TestProjectDescriptor>filter(_map, _function_2);
      Iterable<ProjectDescriptor> _plus = Iterables.<ProjectDescriptor>concat(productionProjects, testProjects);
      _xblockexpression = ImmutableSet.<ProjectDescriptor>copyOf(_plus);
    }
    return _xblockexpression;
  }
  
  public boolean needsMavenBuild() {
    return (Objects.equal(this.preferredBuildSystem, BuildSystem.MAVEN) || (Objects.equal(this.preferredBuildSystem, BuildSystem.GRADLE) && this.uiProject.isEnabled()));
  }
  
  public boolean needsTychoBuild() {
    return (this.needsMavenBuild() && this.runtimeProject.isEclipsePluginProject());
  }
  
  public boolean needsGradleBuild() {
    return (Objects.equal(this.preferredBuildSystem, BuildSystem.GRADLE) || this.intellijProject.isEnabled());
  }
  
  public boolean isNeedsGradleWrapper() {
    return (this.needsGradleWrapper && this.needsGradleBuild());
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
  
  public void setNeedsGradleWrapper(final boolean needsGradleWrapper) {
    this.needsGradleWrapper = needsGradleWrapper;
  }
  
  @Pure
  public JavaVersion getJavaVersion() {
    return this.javaVersion;
  }
  
  public void setJavaVersion(final JavaVersion javaVersion) {
    this.javaVersion = javaVersion;
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
  
  @Pure
  public SdkFeatureProject getSdkProject() {
    return this.sdkProject;
  }
  
  @Pure
  public P2RepositoryProject getP2Project() {
    return this.p2Project;
  }
}

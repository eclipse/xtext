/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.util.XtextVersion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.wizard.AbstractFile;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.IdeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.P2RepositoryProject;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.SdkFeatureProject;
import org.eclipse.xtext.xtext.wizard.SourceFolderDescriptor;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TestProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TestedProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.UiProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WebProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class WizardConfigurationTest {
  private WizardConfiguration config;
  
  @Before
  public void setupConfig() {
    WizardConfiguration _wizardConfiguration = new WizardConfiguration();
    final Procedure1<WizardConfiguration> _function = (WizardConfiguration it) -> {
      it.setBaseName("org.example.mydsl");
      it.setRootLocation("");
      LanguageDescriptor _language = it.getLanguage();
      final Procedure1<LanguageDescriptor> _function_1 = (LanguageDescriptor it_1) -> {
        it_1.setName("org.example.mydsl.MyDsl");
        it_1.setFileExtensions(LanguageDescriptor.FileExtensions.fromString("mydsl"));
      };
      ObjectExtensions.<LanguageDescriptor>operator_doubleArrow(_language, _function_1);
    };
    WizardConfiguration _doubleArrow = ObjectExtensions.<WizardConfiguration>operator_doubleArrow(_wizardConfiguration, _function);
    this.config = _doubleArrow;
  }
  
  @Test
  public void runtimeProjectCanBeBuiltAsPlainMavenProject() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    Assert.assertFalse(this.config.getRuntimeProject().isEclipsePluginProject());
    Assert.assertFalse(this.config.getRuntimeProject().pom().getContent().contains("eclipse-plugin"));
    Assert.assertFalse(this.config.getParentProject().pom().getContent().contains("tycho"));
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      boolean _isEclipsePluginProject = it.isEclipsePluginProject();
      return Boolean.valueOf((!_isEclipsePluginProject));
    };
    final Function1<ProjectDescriptor, Boolean> _function_1 = (ProjectDescriptor it) -> {
      return Boolean.valueOf(it.pom().getContent().contains("tycho"));
    };
    Assert.assertFalse(IterableExtensions.exists(IterableExtensions.filter(this.allJavaProjects(), _function), _function_1));
  }
  
  @Test
  public void runtimeProjectIsPluginProjectWhenUiProjectIsEnabled() {
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    Assert.assertTrue(this.config.getRuntimeProject().isEclipsePluginProject());
  }
  
  @Test
  public void eclipsePluginsAreBuiltWithTychoWhenMavenBuiltIsEnabled() {
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    IdeProjectDescriptor _ideProject = this.config.getIdeProject();
    _ideProject.setEnabled(true);
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    Assert.assertTrue(this.config.needsTychoBuild());
    RuntimeProjectDescriptor _runtimeProject = this.config.getRuntimeProject();
    IdeProjectDescriptor _ideProject_1 = this.config.getIdeProject();
    UiProjectDescriptor _uiProject_1 = this.config.getUiProject();
    final Consumer<ProjectDescriptor> _function = (ProjectDescriptor it) -> {
      Assert.assertTrue(it.pom().getContent().contains("eclipse-plugin"));
    };
    Collections.<ProjectDescriptor>unmodifiableList(CollectionLiterals.<ProjectDescriptor>newArrayList(_runtimeProject, _ideProject_1, _uiProject_1)).forEach(_function);
    Assert.assertTrue(this.config.getParentProject().pom().getContent().contains("tycho"));
  }
  
  @Test
  public void p2AndSdkProjectsAreBuiltWithTychoWhenMavenBuiltIsEnabled() {
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    P2RepositoryProject _p2Project = this.config.getP2Project();
    _p2Project.setEnabled(true);
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    Assert.assertTrue(this.config.needsTychoBuild());
    Assert.assertTrue(this.config.getSdkProject().pom().getContent().contains("eclipse-feature"));
    Assert.assertTrue(this.config.getP2Project().pom().getContent().contains("eclipse-repository"));
    Assert.assertTrue(this.config.getParentProject().pom().getContent().contains("tycho"));
  }
  
  @Test
  public void p2ProjectsEnablesSourceGenerationWithTychoWhenMavenBuiltIsEnabled() {
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    P2RepositoryProject _p2Project = this.config.getP2Project();
    _p2Project.setEnabled(true);
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    Assert.assertTrue(this.config.needsTychoBuild());
    String _content = this.config.getParentProject().pom().getContent();
    final Procedure1<String> _function = (String it) -> {
      Assert.assertTrue(it.contains("tycho-source-plugin"));
      Assert.assertTrue(it.contains("tycho-source-feature-plugin"));
    };
    ObjectExtensions.<String>operator_doubleArrow(_content, _function);
  }
  
  @Test
  public void aTychoBuildIncludesATargetPlatform() {
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    Assert.assertTrue(this.config.getTargetPlatformProject().isEnabled());
  }
  
  @Test
  public void testProjectIsPluginProjectWhenRuntimeProjectIsPluginProject() {
    TestProjectDescriptor _testProject = this.config.getRuntimeProject().getTestProject();
    _testProject.setEnabled(true);
    Assert.assertTrue(this.config.getRuntimeProject().getTestProject().isEclipsePluginProject());
  }
  
  @Test
  public void p2ProjectEnablesSdkProject() {
    P2RepositoryProject _p2Project = this.config.getP2Project();
    _p2Project.setEnabled(true);
    SdkFeatureProject _sdkProject = this.config.getSdkProject();
    _sdkProject.setEnabled(false);
    Assert.assertTrue(this.config.getSdkProject().isEnabled());
  }
  
  @Test
  public void eclipseUiCanBeBuiltWithPDE() {
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    Assert.assertFalse(this.config.needsGradleBuild());
    Assert.assertFalse(this.config.needsMavenBuild());
  }
  
  @Test
  public void eclipseUiIsBuiltWithTychoWhenNotUsingPDE() {
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    this.config.setPreferredBuildSystem(BuildSystem.GRADLE);
    Assert.assertTrue(this.config.needsTychoBuild());
  }
  
  @Test
  public void mavenNeedsAParentProject() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    Assert.assertTrue(this.config.getParentProject().isEnabled());
  }
  
  @Test
  public void gradleNeedsAParentProject() {
    this.config.setPreferredBuildSystem(BuildSystem.GRADLE);
    Assert.assertTrue(this.config.getParentProject().isEnabled());
  }
  
  @Test
  public void inlinedTestProjectsDontOverrideMainSources() {
    TestProjectDescriptor _testProject = this.config.getRuntimeProject().getTestProject();
    _testProject.setEnabled(true);
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    this.config.setSourceLayout(SourceLayout.MAVEN);
    final Function1<AbstractFile, Boolean> _function = (AbstractFile it) -> {
      String _relativePath = it.getRelativePath();
      return Boolean.valueOf(Objects.equal(_relativePath, "pom.xml"));
    };
    final AbstractFile pom = IterableExtensions.findFirst(this.config.getRuntimeProject().getFiles(), _function);
    Assert.assertTrue((pom instanceof PomFile));
    Assert.assertTrue(((PomFile) pom).getContent().toString().contains("<artifactId>org.example.mydsl</artifactId>"));
  }
  
  @Test
  public void inlinedTestProjectsAddTheirDependenciesToTheMainProject() {
    TestProjectDescriptor _testProject = this.config.getRuntimeProject().getTestProject();
    _testProject.setEnabled(true);
    this.config.setSourceLayout(SourceLayout.MAVEN);
    final Consumer<ExternalDependency> _function = (ExternalDependency testDependency) -> {
      final Function1<ExternalDependency, Boolean> _function_1 = (ExternalDependency it) -> {
        return Boolean.valueOf(((Objects.equal(it.getMaven().getArtifactId(), testDependency.getMaven().getArtifactId()) && Objects.equal(it.getP2().getBundleId(), testDependency.getP2().getBundleId())) && Objects.equal(it.getP2().getPackages(), testDependency.getP2().getPackages())));
      };
      Assert.assertTrue(
        IterableExtensions.<ExternalDependency>exists(this.config.getRuntimeProject().getExternalDependencies(), _function_1));
    };
    this.config.getRuntimeProject().getTestProject().getExternalDependencies().forEach(_function);
  }
  
  @Test
  public void inlinedTestProjectsAddTheirSourceFoldersToTheMainProject() {
    TestProjectDescriptor _testProject = this.config.getRuntimeProject().getTestProject();
    _testProject.setEnabled(true);
    this.config.setSourceLayout(SourceLayout.MAVEN);
    final Consumer<SourceFolderDescriptor> _function = (SourceFolderDescriptor folder) -> {
      Assert.assertTrue(this.config.getRuntimeProject().getSourceFolders().contains(folder));
    };
    this.config.getRuntimeProject().getTestProject().getSourceFolders().forEach(_function);
  }
  
  @Test
  public void mavenProjectsHaveAPom() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(it.isPartOfMavenBuild());
    };
    final Consumer<ProjectDescriptor> _function_1 = (ProjectDescriptor it) -> {
      it.setEnabled(true);
      final Function1<AbstractFile, Boolean> _function_2 = (AbstractFile it_1) -> {
        String _relativePath = it_1.getRelativePath();
        return Boolean.valueOf(Objects.equal(_relativePath, "pom.xml"));
      };
      Assert.assertTrue(IterableExtensions.exists(it.getFiles(), _function_2));
    };
    IterableExtensions.filter(this.allJavaProjects(), _function).forEach(_function_1);
  }
  
  @Test
  public void gradleProjectsHaveABuildFile() {
    this.config.setPreferredBuildSystem(BuildSystem.GRADLE);
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(it.isPartOfGradleBuild());
    };
    final Consumer<ProjectDescriptor> _function_1 = (ProjectDescriptor it) -> {
      it.setEnabled(true);
      final Function1<AbstractFile, Boolean> _function_2 = (AbstractFile it_1) -> {
        String _relativePath = it_1.getRelativePath();
        return Boolean.valueOf(Objects.equal(_relativePath, "build.gradle"));
      };
      Assert.assertTrue(IterableExtensions.exists(it.getFiles(), _function_2));
    };
    IterableExtensions.filter(this.allJavaProjects(), _function).forEach(_function_1);
  }
  
  @Test
  public void pluginProjectsHaveEclipseMetaData() {
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(it.isEclipsePluginProject());
    };
    final Consumer<ProjectDescriptor> _function_1 = (ProjectDescriptor it) -> {
      it.setEnabled(true);
      final Function1<AbstractFile, Boolean> _function_2 = (AbstractFile it_1) -> {
        String _relativePath = it_1.getRelativePath();
        return Boolean.valueOf(Objects.equal(_relativePath, "MANIFEST.MF"));
      };
      Assert.assertTrue(IterableExtensions.exists(it.getFiles(), _function_2));
      final Function1<AbstractFile, Boolean> _function_3 = (AbstractFile it_1) -> {
        String _relativePath = it_1.getRelativePath();
        return Boolean.valueOf(Objects.equal(_relativePath, "build.properties"));
      };
      Assert.assertTrue(IterableExtensions.exists(it.getFiles(), _function_3));
    };
    IterableExtensions.filter(this.allJavaProjects(), _function).forEach(_function_1);
  }
  
  @Test
  public void featureProjectsHaveEclipseBuildProperties() {
    final Function1<AbstractFile, Boolean> _function = (AbstractFile it) -> {
      String _relativePath = it.getRelativePath();
      return Boolean.valueOf(Objects.equal(_relativePath, "build.properties"));
    };
    Assert.assertTrue(IterableExtensions.exists(this.config.getSdkProject().getFiles(), _function));
  }
  
  @Test
  public void projectsCanBeBuiltAgainstXtextNightlies() {
    this.config.setPreferredBuildSystem(BuildSystem.GRADLE);
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    XtextVersion _xtextVersion = new XtextVersion("2.9.0-SNAPSHOT");
    this.config.setXtextVersion(_xtextVersion);
    final String snapshotsRepo = "repositories/snapshots";
    Assert.assertTrue(this.config.getParentProject().pom().getContent().contains(snapshotsRepo));
    Assert.assertTrue(this.config.getParentProject().buildGradle().getContent().contains(snapshotsRepo));
    final String nightlyUpdateSite = "xtext/updates/nightly";
    Assert.assertTrue(this.config.getTargetPlatformProject().target().toString().contains(nightlyUpdateSite));
  }
  
  @Test
  public void projectsCanBeBuiltAgainstXtextReleases() {
    this.config.setPreferredBuildSystem(BuildSystem.GRADLE);
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    XtextVersion _xtextVersion = new XtextVersion("2.9.0");
    this.config.setXtextVersion(_xtextVersion);
    final String snapshotsRepo = "repositories/snapshots";
    Assert.assertFalse(this.config.getParentProject().pom().getContent().contains(snapshotsRepo));
    Assert.assertFalse(this.config.getParentProject().buildGradle().getContent().contains(snapshotsRepo));
    final String releaseUpdateSite = "xtext/updates/releases/2.9.0";
    Assert.assertTrue(this.config.getTargetPlatformProject().target().toString().contains(releaseUpdateSite));
  }
  
  @Test
  public void gradleEclipseClasspathIsIgnoredForPluginProjects() {
    this.config.setPreferredBuildSystem(BuildSystem.GRADLE);
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    IdeProjectDescriptor _ideProject = this.config.getIdeProject();
    _ideProject.setEnabled(true);
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(it.isEclipsePluginProject());
    };
    final Consumer<ProjectDescriptor> _function_1 = (ProjectDescriptor it) -> {
      Assert.assertTrue(it.buildGradle().getContent().contains("eclipseClasspath.enabled=false"));
    };
    IterableExtensions.<ProjectDescriptor>filter(this.config.getEnabledProjects(), _function).forEach(_function_1);
  }
  
  @Test
  public void parentContainsOtherProjectsInHierarchicallayout() {
    this.config.setProjectLayout(ProjectLayout.HIERARCHICAL);
    final Consumer<ProjectDescriptor> _function = (ProjectDescriptor it) -> {
      String _location = it.getLocation();
      String _location_1 = this.config.getParentProject().getLocation();
      String _plus = (_location_1 + "/");
      Assert.assertTrue(_location.startsWith(_plus));
    };
    this.allJavaProjects().forEach(_function);
  }
  
  @Test
  public void plainMavenProjectsCanBeBuiltWithEclipseLayout() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    this.config.setSourceLayout(SourceLayout.PLAIN);
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(((!it.isEclipsePluginProject()) && it.isPartOfMavenBuild()));
    };
    final Iterable<? extends ProjectDescriptor> plainMavenProjects = IterableExtensions.filter(this.allJavaProjects(), _function);
    final Consumer<ProjectDescriptor> _function_1 = (ProjectDescriptor it) -> {
      Assert.assertTrue(it.pom().getContent().contains("<directory>src</directory>"));
      Assert.assertTrue(it.pom().getContent().contains("<source>src-gen</source>"));
      Assert.assertTrue(it.pom().getContent().contains("<directory>src-gen</directory>"));
    };
    plainMavenProjects.forEach(_function_1);
    final Function1<ProjectDescriptor, Boolean> _function_2 = (ProjectDescriptor it) -> {
      return Boolean.valueOf((!(it instanceof TestProjectDescriptor)));
    };
    final Consumer<ProjectDescriptor> _function_3 = (ProjectDescriptor it) -> {
      Assert.assertTrue(it.pom().getContent().contains("<sourceDirectory>src</sourceDirectory>"));
      Assert.assertTrue(it.pom().getContent().contains("add-source"));
      Assert.assertTrue(it.pom().getContent().contains("add-resource"));
      Assert.assertFalse(it.pom().getContent().contains("add-test-source"));
      Assert.assertFalse(it.pom().getContent().contains("add-test-resource"));
    };
    IterableExtensions.filter(plainMavenProjects, _function_2).forEach(_function_3);
    final Consumer<TestProjectDescriptor> _function_4 = (TestProjectDescriptor it) -> {
      Assert.assertTrue(it.pom().getContent().contains("<testSourceDirectory>src</testSourceDirectory>"));
      Assert.assertTrue(it.pom().getContent().contains("add-test-source"));
      Assert.assertTrue(it.pom().getContent().contains("add-test-resource"));
      Assert.assertFalse(it.pom().getContent().contains("add-source"));
      Assert.assertFalse(it.pom().getContent().contains("add-resource"));
    };
    Iterables.<TestProjectDescriptor>filter(plainMavenProjects, TestProjectDescriptor.class).forEach(_function_4);
  }
  
  @Test
  public void plainMavenProjectsCanBeBuiltWithMavenLayout() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    this.config.setSourceLayout(SourceLayout.MAVEN);
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(((!it.isEclipsePluginProject()) && it.isPartOfMavenBuild()));
    };
    final Iterable<? extends ProjectDescriptor> plainMavenProjects = IterableExtensions.filter(this.allJavaProjects(), _function);
    final Function1<ProjectDescriptor, Boolean> _function_1 = (ProjectDescriptor it) -> {
      return Boolean.valueOf((!(it instanceof TestProjectDescriptor)));
    };
    final Iterable<? extends ProjectDescriptor> mainProjects = IterableExtensions.filter(plainMavenProjects, _function_1);
    final Consumer<ProjectDescriptor> _function_2 = (ProjectDescriptor it) -> {
      it.setEnabled(true);
    };
    plainMavenProjects.forEach(_function_2);
    final Function1<TestProjectDescriptor, Boolean> _function_3 = (TestProjectDescriptor it) -> {
      return Boolean.valueOf(it.isInlined());
    };
    Assert.assertTrue(IterableExtensions.<TestProjectDescriptor>forall(Iterables.<TestProjectDescriptor>filter(plainMavenProjects, TestProjectDescriptor.class), _function_3));
    final Consumer<ProjectDescriptor> _function_4 = (ProjectDescriptor it) -> {
      Assert.assertTrue(it.pom().getContent().contains("add-source"));
      Assert.assertTrue(it.pom().getContent().contains("add-resource"));
      Assert.assertTrue(it.pom().getContent().contains("<source>src/main/xtext-gen</source>"));
      Assert.assertTrue(it.pom().getContent().contains("<directory>src/main/xtext-gen</directory>"));
    };
    mainProjects.forEach(_function_4);
    final Consumer<TestedProjectDescriptor> _function_5 = (TestedProjectDescriptor it) -> {
      Assert.assertTrue(it.pom().getContent().contains("add-test-source"));
      Assert.assertTrue(it.pom().getContent().contains("add-test-resource"));
      Assert.assertTrue(it.pom().getContent().contains("<source>src/test/xtext-gen</source>"));
      Assert.assertTrue(it.pom().getContent().contains("<directory>src/test/xtext-gen</directory>"));
    };
    Iterables.<TestedProjectDescriptor>filter(mainProjects, TestedProjectDescriptor.class).forEach(_function_5);
  }
  
  @Test
  public void pomFileDontDuplicateMavenDefaults() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    this.config.setSourceLayout(SourceLayout.MAVEN);
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(((!it.isEclipsePluginProject()) && it.isPartOfMavenBuild()));
    };
    final Iterable<? extends ProjectDescriptor> plainMavenProjects = IterableExtensions.filter(this.allJavaProjects(), _function);
    final Function1<ProjectDescriptor, Boolean> _function_1 = (ProjectDescriptor it) -> {
      return Boolean.valueOf((!(it instanceof TestProjectDescriptor)));
    };
    final Iterable<? extends ProjectDescriptor> mainProjects = IterableExtensions.filter(plainMavenProjects, _function_1);
    final Consumer<ProjectDescriptor> _function_2 = (ProjectDescriptor it) -> {
      it.setEnabled(true);
    };
    plainMavenProjects.forEach(_function_2);
    final Consumer<ProjectDescriptor> _function_3 = (ProjectDescriptor it) -> {
      Assert.assertFalse(it.pom().getContent().contains("<sourceDirectory>"));
      Assert.assertFalse(it.pom().getContent().contains("<directory>src/main/resources</directory>"));
      Assert.assertFalse(it.pom().getContent().contains("<testSourceDirectory>"));
      Assert.assertFalse(it.pom().getContent().contains("<directory>src/test/resources</directory>"));
    };
    mainProjects.forEach(_function_3);
  }
  
  @Test
  public void uiTestsNeedTychoUiHarness() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    final String pom = this.config.getUiProject().getTestProject().pom().getContent();
    Assert.assertTrue(pom.contains("useUIHarness"));
  }
  
  @Test
  public void runtimeTestsDontNeedTychoUiHarness() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    final String pom = this.config.getRuntimeProject().getTestProject().pom().getContent();
    Assert.assertFalse(pom.contains("useUIHarness"));
  }
  
  @Test
  public void tychoDoesNotFailOnMissingTests() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    Assert.assertTrue(this.config.getParentProject().pom().getContent().contains("failIfNoTests"));
  }
  
  @Test
  public void allBuildSystemsUseJava8() {
    final String parentPom = this.config.getParentProject().pom().getContent();
    Assert.assertTrue(parentPom.contains("<maven.compiler.source>1.8</maven.compiler.source>"));
    Assert.assertTrue(parentPom.contains("<maven.compiler.target>1.8</maven.compiler.target>"));
    final String parentGradle = this.config.getParentProject().buildGradle().getContent();
    Assert.assertTrue(parentGradle.contains("sourceCompatibility = \'1.8\'"));
    Assert.assertTrue(parentGradle.contains("targetCompatibility = \'1.8\'"));
    final Function1<ProjectDescriptor, String> _function = (ProjectDescriptor it) -> {
      return it.manifest();
    };
    final Consumer<String> _function_1 = (String it) -> {
      Assert.assertTrue(it.contains("Bundle-RequiredExecutionEnvironment: JavaSE-1.8"));
    };
    ListExtensions.map(this.allJavaProjects(), _function).forEach(_function_1);
  }
  
  @Test
  public void allBuildSystemsUseOtherJava() {
    this.config.setJavaVersion(JavaVersion.JAVA7);
    final String parentPom = this.config.getParentProject().pom().getContent();
    Assert.assertTrue(parentPom.contains("<maven.compiler.source>1.7</maven.compiler.source>"));
    Assert.assertTrue(parentPom.contains("<maven.compiler.target>1.7</maven.compiler.target>"));
    final String parentGradle = this.config.getParentProject().buildGradle().getContent();
    Assert.assertTrue(parentGradle.contains("sourceCompatibility = \'1.7\'"));
    Assert.assertTrue(parentGradle.contains("targetCompatibility = \'1.7\'"));
    final Function1<ProjectDescriptor, String> _function = (ProjectDescriptor it) -> {
      return it.manifest();
    };
    final Consumer<String> _function_1 = (String it) -> {
      Assert.assertTrue(it.contains("Bundle-RequiredExecutionEnvironment: JavaSE-1.7"));
    };
    ListExtensions.map(this.allJavaProjects(), _function).forEach(_function_1);
  }
  
  public List<? extends ProjectDescriptor> allJavaProjects() {
    RuntimeProjectDescriptor _runtimeProject = this.config.getRuntimeProject();
    TestProjectDescriptor _testProject = this.config.getRuntimeProject().getTestProject();
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    TestProjectDescriptor _testProject_1 = this.config.getUiProject().getTestProject();
    IdeProjectDescriptor _ideProject = this.config.getIdeProject();
    WebProjectDescriptor _webProject = this.config.getWebProject();
    return Collections.<ProjectDescriptor>unmodifiableList(CollectionLiterals.<ProjectDescriptor>newArrayList(_runtimeProject, _testProject, _uiProject, _testProject_1, _ideProject, _webProject));
  }
  
  @Test
  public void binExcludes() {
    Assert.assertEquals(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("**/*.mwe2", "**/*.xtend")), this.config.getRuntimeProject().getBinExcludes());
    Assert.assertEquals(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("**/*.xtend")), this.config.getRuntimeProject().getTestProject().getBinExcludes());
    Assert.assertEquals(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("**/*.xtend")), this.config.getUiProject().getBinExcludes());
    Assert.assertEquals(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("**/*.xtend")), this.config.getUiProject().getTestProject().getBinExcludes());
    Assert.assertEquals(Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet()), this.config.getSdkProject().getBinExcludes());
  }
}

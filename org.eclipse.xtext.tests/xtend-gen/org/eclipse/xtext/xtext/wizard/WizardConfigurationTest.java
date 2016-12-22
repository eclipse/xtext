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
import java.util.List;
import java.util.Set;
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
import org.eclipse.xtext.xtext.wizard.GradleBuildFile;
import org.eclipse.xtext.xtext.wizard.IdeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.IntellijProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.P2RepositoryProject;
import org.eclipse.xtext.xtext.wizard.ParentProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.SdkFeatureProject;
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
    Assert.assertFalse(IterableExtensions.exists(IterableExtensions.filter(this.allJavaProjects(), ((Function1<ProjectDescriptor, Boolean>) (ProjectDescriptor it) -> {
      boolean _isEclipsePluginProject = it.isEclipsePluginProject();
      return Boolean.valueOf((!_isEclipsePluginProject));
    })), ((Function1<ProjectDescriptor, Boolean>) (ProjectDescriptor it) -> {
      PomFile _pom = it.pom();
      String _content = _pom.getContent();
      return Boolean.valueOf(_content.contains("tycho"));
    })));
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
    ParentProjectDescriptor _parentProject = this.config.getParentProject();
    PomFile _pom = _parentProject.pom();
    String _content = _pom.getContent();
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
    RuntimeProjectDescriptor _runtimeProject = this.config.getRuntimeProject();
    TestProjectDescriptor _testProject = _runtimeProject.getTestProject();
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
  public void intellijNeedsAGradleBuild() {
    IntellijProjectDescriptor _intellijProject = this.config.getIntellijProject();
    _intellijProject.setEnabled(true);
    Assert.assertTrue(this.config.needsGradleBuild());
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
    RuntimeProjectDescriptor _runtimeProject = this.config.getRuntimeProject();
    TestProjectDescriptor _testProject = _runtimeProject.getTestProject();
    _testProject.setEnabled(true);
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    this.config.setSourceLayout(SourceLayout.MAVEN);
    RuntimeProjectDescriptor _runtimeProject_1 = this.config.getRuntimeProject();
    Iterable<? extends AbstractFile> _files = _runtimeProject_1.getFiles();
    final Function1<AbstractFile, Boolean> _function = (AbstractFile it) -> {
      String _relativePath = it.getRelativePath();
      return Boolean.valueOf(Objects.equal(_relativePath, "pom.xml"));
    };
    final AbstractFile pom = IterableExtensions.findFirst(_files, _function);
    Assert.assertTrue((pom instanceof PomFile));
    Assert.assertTrue(((PomFile) pom).getContent().toString().contains("<artifactId>org.example.mydsl</artifactId>"));
  }
  
  @Test
  public void inlinedTestProjectsAddTheirDependenciesToTheMainProject() {
    RuntimeProjectDescriptor _runtimeProject = this.config.getRuntimeProject();
    TestProjectDescriptor _testProject = _runtimeProject.getTestProject();
    _testProject.setEnabled(true);
    this.config.setSourceLayout(SourceLayout.MAVEN);
    RuntimeProjectDescriptor _runtimeProject_1 = this.config.getRuntimeProject();
    TestProjectDescriptor _testProject_1 = _runtimeProject_1.getTestProject();
    Set<ExternalDependency> _externalDependencies = _testProject_1.getExternalDependencies();
    final Consumer<ExternalDependency> _function = (ExternalDependency testDependency) -> {
      Assert.assertTrue(
        IterableExtensions.<ExternalDependency>exists(this.config.getRuntimeProject().getExternalDependencies(), 
          ((Function1<ExternalDependency, Boolean>) (ExternalDependency it) -> {
            return Boolean.valueOf(((Objects.equal(it.getMaven().getArtifactId(), testDependency.getMaven().getArtifactId()) && Objects.equal(it.getP2().getBundleId(), testDependency.getP2().getBundleId())) && Objects.equal(it.getP2().getPackages(), testDependency.getP2().getPackages())));
          })));
    };
    _externalDependencies.forEach(_function);
  }
  
  @Test
  public void inlinedTestProjectsAddTheirSourceFoldersToTheMainProject() {
    RuntimeProjectDescriptor _runtimeProject = this.config.getRuntimeProject();
    TestProjectDescriptor _testProject = _runtimeProject.getTestProject();
    _testProject.setEnabled(true);
    this.config.setSourceLayout(SourceLayout.MAVEN);
    RuntimeProjectDescriptor _runtimeProject_1 = this.config.getRuntimeProject();
    TestProjectDescriptor _testProject_1 = _runtimeProject_1.getTestProject();
    Set<String> _sourceFolders = _testProject_1.getSourceFolders();
    final Consumer<String> _function = (String testFolder) -> {
      Assert.assertTrue(this.config.getRuntimeProject().getSourceFolders().contains(testFolder));
    };
    _sourceFolders.forEach(_function);
  }
  
  @Test
  public void mavenProjectsHaveAPom() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(it.isPartOfMavenBuild());
    };
    Iterable<? extends ProjectDescriptor> _filter = IterableExtensions.filter(_allJavaProjects, _function);
    final Consumer<ProjectDescriptor> _function_1 = (ProjectDescriptor it) -> {
      it.setEnabled(true);
      Assert.assertTrue(IterableExtensions.exists(it.getFiles(), ((Function1<AbstractFile, Boolean>) (AbstractFile it_1) -> {
        String _relativePath = it_1.getRelativePath();
        return Boolean.valueOf(Objects.equal(_relativePath, "pom.xml"));
      })));
    };
    _filter.forEach(_function_1);
  }
  
  @Test
  public void gradleProjectsHaveABuildFile() {
    this.config.setPreferredBuildSystem(BuildSystem.GRADLE);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(it.isPartOfGradleBuild());
    };
    Iterable<? extends ProjectDescriptor> _filter = IterableExtensions.filter(_allJavaProjects, _function);
    final Consumer<ProjectDescriptor> _function_1 = (ProjectDescriptor it) -> {
      it.setEnabled(true);
      Assert.assertTrue(IterableExtensions.exists(it.getFiles(), ((Function1<AbstractFile, Boolean>) (AbstractFile it_1) -> {
        String _relativePath = it_1.getRelativePath();
        return Boolean.valueOf(Objects.equal(_relativePath, "build.gradle"));
      })));
    };
    _filter.forEach(_function_1);
  }
  
  @Test
  public void pluginProjectsHaveEclipseMetaData() {
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(it.isEclipsePluginProject());
    };
    Iterable<? extends ProjectDescriptor> _filter = IterableExtensions.filter(_allJavaProjects, _function);
    final Consumer<ProjectDescriptor> _function_1 = (ProjectDescriptor it) -> {
      it.setEnabled(true);
      Assert.assertTrue(IterableExtensions.exists(it.getFiles(), ((Function1<AbstractFile, Boolean>) (AbstractFile it_1) -> {
        String _relativePath = it_1.getRelativePath();
        return Boolean.valueOf(Objects.equal(_relativePath, "MANIFEST.MF"));
      })));
      Assert.assertTrue(IterableExtensions.exists(it.getFiles(), ((Function1<AbstractFile, Boolean>) (AbstractFile it_1) -> {
        String _relativePath = it_1.getRelativePath();
        return Boolean.valueOf(Objects.equal(_relativePath, "build.properties"));
      })));
    };
    _filter.forEach(_function_1);
  }
  
  @Test
  public void featureProjectsHaveEclipseBuildProperties() {
    Assert.assertTrue(IterableExtensions.exists(this.config.getSdkProject().getFiles(), ((Function1<AbstractFile, Boolean>) (AbstractFile it) -> {
      String _relativePath = it.getRelativePath();
      return Boolean.valueOf(Objects.equal(_relativePath, "build.properties"));
    })));
  }
  
  @Test
  public void projectsCanBeBuiltAgainstXtextNightlies() {
    this.config.setPreferredBuildSystem(BuildSystem.GRADLE);
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    IntellijProjectDescriptor _intellijProject = this.config.getIntellijProject();
    _intellijProject.setEnabled(true);
    XtextVersion _xtextVersion = new XtextVersion("2.9.0-SNAPSHOT");
    this.config.setXtextVersion(_xtextVersion);
    final String snapshotsRepo = "repositories/snapshots";
    Assert.assertTrue(this.config.getParentProject().pom().getContent().contains(snapshotsRepo));
    Assert.assertTrue(this.config.getParentProject().buildGradle().getContent().contains(snapshotsRepo));
    final String xtextIntellijSnapshots = "/xtext-intellij/lastSuccessfulBuild/";
    Assert.assertTrue(this.config.getIntellijProject().buildGradle().getContent().contains(xtextIntellijSnapshots));
    final String nightlyUpdateSite = "xtext/updates/nightly";
    Assert.assertTrue(this.config.getTargetPlatformProject().target().toString().contains(nightlyUpdateSite));
  }
  
  @Test
  public void projectsCanBeBuiltAgainstXtextReleases() {
    this.config.setPreferredBuildSystem(BuildSystem.GRADLE);
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    IntellijProjectDescriptor _intellijProject = this.config.getIntellijProject();
    _intellijProject.setEnabled(true);
    XtextVersion _xtextVersion = new XtextVersion("2.9.0");
    this.config.setXtextVersion(_xtextVersion);
    final String snapshotsRepo = "repositories/snapshots";
    Assert.assertFalse(this.config.getParentProject().pom().getContent().contains(snapshotsRepo));
    Assert.assertFalse(this.config.getParentProject().buildGradle().getContent().contains(snapshotsRepo));
    final String xtextIntellijRelease = "xtext/idea/${xtextVersion}";
    Assert.assertTrue(this.config.getIntellijProject().buildGradle().getContent().contains(xtextIntellijRelease));
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
    Set<ProjectDescriptor> _enabledProjects = this.config.getEnabledProjects();
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(it.isEclipsePluginProject());
    };
    Iterable<ProjectDescriptor> _filter = IterableExtensions.<ProjectDescriptor>filter(_enabledProjects, _function);
    final Consumer<ProjectDescriptor> _function_1 = (ProjectDescriptor it) -> {
      Assert.assertTrue(it.buildGradle().getContent().contains("eclipseClasspath.enabled=false"));
    };
    _filter.forEach(_function_1);
  }
  
  @Test
  public void parentContainsOtherProjectsInHierarchicallayout() {
    this.config.setProjectLayout(ProjectLayout.HIERARCHICAL);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Consumer<ProjectDescriptor> _function = (ProjectDescriptor it) -> {
      Assert.assertTrue(it.getLocation().startsWith((this.config.getParentProject().getLocation() + "/")));
    };
    _allJavaProjects.forEach(_function);
  }
  
  @Test
  public void plainMavenProjectsCanBeBuiltWithEclipseLayout() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    this.config.setSourceLayout(SourceLayout.PLAIN);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(((!it.isEclipsePluginProject()) && it.isPartOfMavenBuild()));
    };
    final Iterable<? extends ProjectDescriptor> plainMavenProjects = IterableExtensions.filter(_allJavaProjects, _function);
    final Consumer<ProjectDescriptor> _function_1 = (ProjectDescriptor it) -> {
      Assert.assertTrue(it.pom().getContent().contains("<directory>src</directory>"));
      Assert.assertTrue(it.pom().getContent().contains("<source>src-gen</source>"));
      Assert.assertTrue(it.pom().getContent().contains("<directory>src-gen</directory>"));
    };
    plainMavenProjects.forEach(_function_1);
    final Function1<ProjectDescriptor, Boolean> _function_2 = (ProjectDescriptor it) -> {
      return Boolean.valueOf((!(it instanceof TestProjectDescriptor)));
    };
    Iterable<? extends ProjectDescriptor> _filter = IterableExtensions.filter(plainMavenProjects, _function_2);
    final Consumer<ProjectDescriptor> _function_3 = (ProjectDescriptor it) -> {
      Assert.assertTrue(it.pom().getContent().contains("<sourceDirectory>src</sourceDirectory>"));
      Assert.assertTrue(it.pom().getContent().contains("add-source"));
      Assert.assertTrue(it.pom().getContent().contains("add-resource"));
      Assert.assertFalse(it.pom().getContent().contains("add-test-source"));
      Assert.assertFalse(it.pom().getContent().contains("add-test-resource"));
    };
    _filter.forEach(_function_3);
    Iterable<TestProjectDescriptor> _filter_1 = Iterables.<TestProjectDescriptor>filter(plainMavenProjects, TestProjectDescriptor.class);
    final Consumer<TestProjectDescriptor> _function_4 = (TestProjectDescriptor it) -> {
      Assert.assertTrue(it.pom().getContent().contains("<testSourceDirectory>src</testSourceDirectory>"));
      Assert.assertTrue(it.pom().getContent().contains("add-test-source"));
      Assert.assertTrue(it.pom().getContent().contains("add-test-resource"));
      Assert.assertFalse(it.pom().getContent().contains("add-source"));
      Assert.assertFalse(it.pom().getContent().contains("add-resource"));
    };
    _filter_1.forEach(_function_4);
  }
  
  @Test
  public void plainMavenProjectsCanBeBuiltWithMavenLayout() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    this.config.setSourceLayout(SourceLayout.MAVEN);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(((!it.isEclipsePluginProject()) && it.isPartOfMavenBuild()));
    };
    final Iterable<? extends ProjectDescriptor> plainMavenProjects = IterableExtensions.filter(_allJavaProjects, _function);
    final Function1<ProjectDescriptor, Boolean> _function_1 = (ProjectDescriptor it) -> {
      return Boolean.valueOf((!(it instanceof TestProjectDescriptor)));
    };
    final Iterable<? extends ProjectDescriptor> mainProjects = IterableExtensions.filter(plainMavenProjects, _function_1);
    final Consumer<ProjectDescriptor> _function_2 = (ProjectDescriptor it) -> {
      it.setEnabled(true);
    };
    plainMavenProjects.forEach(_function_2);
    Assert.assertTrue(IterableExtensions.<TestProjectDescriptor>forall(Iterables.<TestProjectDescriptor>filter(plainMavenProjects, TestProjectDescriptor.class), ((Function1<TestProjectDescriptor, Boolean>) (TestProjectDescriptor it) -> {
      return Boolean.valueOf(it.isInlined());
    })));
    final Consumer<ProjectDescriptor> _function_3 = (ProjectDescriptor it) -> {
      Assert.assertTrue(it.pom().getContent().contains("add-source"));
      Assert.assertTrue(it.pom().getContent().contains("add-resource"));
      Assert.assertTrue(it.pom().getContent().contains("<source>src/main/xtext-gen</source>"));
      Assert.assertTrue(it.pom().getContent().contains("<directory>src/main/xtext-gen</directory>"));
    };
    mainProjects.forEach(_function_3);
    Iterable<TestedProjectDescriptor> _filter = Iterables.<TestedProjectDescriptor>filter(mainProjects, TestedProjectDescriptor.class);
    final Consumer<TestedProjectDescriptor> _function_4 = (TestedProjectDescriptor it) -> {
      Assert.assertTrue(it.pom().getContent().contains("add-test-source"));
      Assert.assertTrue(it.pom().getContent().contains("add-test-resource"));
      Assert.assertTrue(it.pom().getContent().contains("<source>src/test/xtext-gen</source>"));
      Assert.assertTrue(it.pom().getContent().contains("<directory>src/test/xtext-gen</directory>"));
    };
    _filter.forEach(_function_4);
  }
  
  @Test
  public void pomFileDontDuplicateMavenDefaults() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    this.config.setSourceLayout(SourceLayout.MAVEN);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, Boolean> _function = (ProjectDescriptor it) -> {
      return Boolean.valueOf(((!it.isEclipsePluginProject()) && it.isPartOfMavenBuild()));
    };
    final Iterable<? extends ProjectDescriptor> plainMavenProjects = IterableExtensions.filter(_allJavaProjects, _function);
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
    UiProjectDescriptor _uiProject_1 = this.config.getUiProject();
    TestProjectDescriptor _testProject = _uiProject_1.getTestProject();
    PomFile _pom = _testProject.pom();
    final String pom = _pom.getContent();
    Assert.assertTrue(pom.contains("useUIHarness"));
  }
  
  @Test
  public void runtimeTestsDontNeedTychoUiHarness() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    RuntimeProjectDescriptor _runtimeProject = this.config.getRuntimeProject();
    TestProjectDescriptor _testProject = _runtimeProject.getTestProject();
    PomFile _pom = _testProject.pom();
    final String pom = _pom.getContent();
    Assert.assertFalse(pom.contains("useUIHarness"));
  }
  
  @Test
  public void tychoDoesNotFailOnMissingTests() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    Iterable<TestProjectDescriptor> _filter = Iterables.<TestProjectDescriptor>filter(_allJavaProjects, TestProjectDescriptor.class);
    final Function1<TestProjectDescriptor, Boolean> _function = (TestProjectDescriptor it) -> {
      return Boolean.valueOf(it.isEclipsePluginProject());
    };
    Iterable<TestProjectDescriptor> _filter_1 = IterableExtensions.<TestProjectDescriptor>filter(_filter, _function);
    final Function1<TestProjectDescriptor, PomFile> _function_1 = (TestProjectDescriptor it) -> {
      return it.pom();
    };
    final Iterable<PomFile> poms = IterableExtensions.<TestProjectDescriptor, PomFile>map(_filter_1, _function_1);
    final Consumer<PomFile> _function_2 = (PomFile it) -> {
      Assert.assertTrue(it.getContent().contains("failIfNoTests"));
    };
    poms.forEach(_function_2);
  }
  
  @Test
  public void allBuildSystemsUseJava8() {
    ParentProjectDescriptor _parentProject = this.config.getParentProject();
    PomFile _pom = _parentProject.pom();
    final String parentPom = _pom.getContent();
    Assert.assertTrue(parentPom.contains("<maven.compiler.source>1.8</maven.compiler.source>"));
    Assert.assertTrue(parentPom.contains("<maven.compiler.target>1.8</maven.compiler.target>"));
    ParentProjectDescriptor _parentProject_1 = this.config.getParentProject();
    GradleBuildFile _buildGradle = _parentProject_1.buildGradle();
    final String parentGradle = _buildGradle.getContent();
    Assert.assertTrue(parentGradle.contains("sourceCompatibility = \'1.8\'"));
    Assert.assertTrue(parentGradle.contains("targetCompatibility = \'1.8\'"));
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, String> _function = (ProjectDescriptor it) -> {
      return it.manifest();
    };
    List<String> _map = ListExtensions.map(_allJavaProjects, _function);
    final Consumer<String> _function_1 = (String it) -> {
      Assert.assertTrue(it.contains("Bundle-RequiredExecutionEnvironment: JavaSE-1.8"));
    };
    _map.forEach(_function_1);
  }
  
  @Test
  public void allBuildSystemsUseOtherJava() {
    this.config.setJavaVersion(JavaVersion.JAVA7);
    ParentProjectDescriptor _parentProject = this.config.getParentProject();
    PomFile _pom = _parentProject.pom();
    final String parentPom = _pom.getContent();
    Assert.assertTrue(parentPom.contains("<maven.compiler.source>1.7</maven.compiler.source>"));
    Assert.assertTrue(parentPom.contains("<maven.compiler.target>1.7</maven.compiler.target>"));
    ParentProjectDescriptor _parentProject_1 = this.config.getParentProject();
    GradleBuildFile _buildGradle = _parentProject_1.buildGradle();
    final String parentGradle = _buildGradle.getContent();
    Assert.assertTrue(parentGradle.contains("sourceCompatibility = \'1.7\'"));
    Assert.assertTrue(parentGradle.contains("targetCompatibility = \'1.7\'"));
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, String> _function = (ProjectDescriptor it) -> {
      return it.manifest();
    };
    List<String> _map = ListExtensions.map(_allJavaProjects, _function);
    final Consumer<String> _function_1 = (String it) -> {
      Assert.assertTrue(it.contains("Bundle-RequiredExecutionEnvironment: JavaSE-1.7"));
    };
    _map.forEach(_function_1);
  }
  
  public List<? extends ProjectDescriptor> allJavaProjects() {
    RuntimeProjectDescriptor _runtimeProject = this.config.getRuntimeProject();
    RuntimeProjectDescriptor _runtimeProject_1 = this.config.getRuntimeProject();
    TestProjectDescriptor _testProject = _runtimeProject_1.getTestProject();
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    UiProjectDescriptor _uiProject_1 = this.config.getUiProject();
    TestProjectDescriptor _testProject_1 = _uiProject_1.getTestProject();
    IdeProjectDescriptor _ideProject = this.config.getIdeProject();
    IntellijProjectDescriptor _intellijProject = this.config.getIntellijProject();
    WebProjectDescriptor _webProject = this.config.getWebProject();
    return Collections.<ProjectDescriptor>unmodifiableList(CollectionLiterals.<ProjectDescriptor>newArrayList(_runtimeProject, _testProject, _uiProject, _testProject_1, _ideProject, _intellijProject, _webProject));
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

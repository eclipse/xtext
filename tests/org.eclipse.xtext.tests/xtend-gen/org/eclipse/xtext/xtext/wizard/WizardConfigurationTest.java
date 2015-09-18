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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.generator.XtextVersion;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.GradleBuildFile;
import org.eclipse.xtext.xtext.wizard.IdeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.IntellijProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.ParentProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TargetPlatformProject;
import org.eclipse.xtext.xtext.wizard.TestProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TestedProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TextFile;
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
    final Procedure1<WizardConfiguration> _function = new Procedure1<WizardConfiguration>() {
      @Override
      public void apply(final WizardConfiguration it) {
        it.setBaseName("org.example.mydsl");
        it.setRootLocation("");
        LanguageDescriptor _language = it.getLanguage();
        final Procedure1<LanguageDescriptor> _function = new Procedure1<LanguageDescriptor>() {
          @Override
          public void apply(final LanguageDescriptor it) {
            it.setName("org.example.mydsl.MyDsl");
            LanguageDescriptor.FileExtensions _fromString = LanguageDescriptor.FileExtensions.fromString("mydsl");
            it.setFileExtensions(_fromString);
          }
        };
        ObjectExtensions.<LanguageDescriptor>operator_doubleArrow(_language, _function);
      }
    };
    WizardConfiguration _doubleArrow = ObjectExtensions.<WizardConfiguration>operator_doubleArrow(_wizardConfiguration, _function);
    this.config = _doubleArrow;
  }
  
  @Test
  public void runtimeProjectCanBeBuiltAsPlainMavenProject() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    RuntimeProjectDescriptor _runtimeProject = this.config.getRuntimeProject();
    boolean _isEclipsePluginProject = _runtimeProject.isEclipsePluginProject();
    Assert.assertFalse(_isEclipsePluginProject);
    RuntimeProjectDescriptor _runtimeProject_1 = this.config.getRuntimeProject();
    PomFile _pom = _runtimeProject_1.pom();
    String _content = _pom.getContent();
    boolean _contains = _content.contains("eclipse-plugin");
    Assert.assertFalse(_contains);
    ParentProjectDescriptor _parentProject = this.config.getParentProject();
    PomFile _pom_1 = _parentProject.pom();
    String _content_1 = _pom_1.getContent();
    boolean _contains_1 = _content_1.contains("tycho");
    Assert.assertFalse(_contains_1);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ProjectDescriptor it) {
        boolean _isEclipsePluginProject = it.isEclipsePluginProject();
        return Boolean.valueOf((!_isEclipsePluginProject));
      }
    };
    Iterable<? extends ProjectDescriptor> _filter = IterableExtensions.filter(_allJavaProjects, _function);
    final Function1<ProjectDescriptor, Boolean> _function_1 = new Function1<ProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ProjectDescriptor it) {
        PomFile _pom = it.pom();
        String _content = _pom.getContent();
        return Boolean.valueOf(_content.contains("tycho"));
      }
    };
    boolean _exists = IterableExtensions.exists(_filter, _function_1);
    Assert.assertFalse(_exists);
  }
  
  @Test
  public void runtimeProjectIsPluginProjectWhenUiProjectIsEnabled() {
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    RuntimeProjectDescriptor _runtimeProject = this.config.getRuntimeProject();
    boolean _isEclipsePluginProject = _runtimeProject.isEclipsePluginProject();
    Assert.assertTrue(_isEclipsePluginProject);
  }
  
  @Test
  public void eclipsePluginsAreBuiltWithTychoWhenMavenBuiltIsEnabled() {
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    IdeProjectDescriptor _ideProject = this.config.getIdeProject();
    _ideProject.setEnabled(true);
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    boolean _needsTychoBuild = this.config.needsTychoBuild();
    Assert.assertTrue(_needsTychoBuild);
    RuntimeProjectDescriptor _runtimeProject = this.config.getRuntimeProject();
    IdeProjectDescriptor _ideProject_1 = this.config.getIdeProject();
    UiProjectDescriptor _uiProject_1 = this.config.getUiProject();
    final Procedure1<ProjectDescriptor> _function = new Procedure1<ProjectDescriptor>() {
      @Override
      public void apply(final ProjectDescriptor it) {
        PomFile _pom = it.pom();
        String _content = _pom.getContent();
        boolean _contains = _content.contains("eclipse-plugin");
        Assert.assertTrue(_contains);
      }
    };
    IterableExtensions.forEach(Collections.<ProjectDescriptor>unmodifiableList(CollectionLiterals.<ProjectDescriptor>newArrayList(_runtimeProject, _ideProject_1, _uiProject_1)), _function);
    ParentProjectDescriptor _parentProject = this.config.getParentProject();
    PomFile _pom = _parentProject.pom();
    String _content = _pom.getContent();
    boolean _contains = _content.contains("tycho");
    Assert.assertTrue(_contains);
  }
  
  @Test
  public void aTychoBuildIncludesATargetPlatform() {
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    TargetPlatformProject _targetPlatformProject = this.config.getTargetPlatformProject();
    boolean _isEnabled = _targetPlatformProject.isEnabled();
    Assert.assertTrue(_isEnabled);
  }
  
  @Test
  public void testProjectIsPluginProjectWhenRuntimeProjectIsPluginProject() {
    RuntimeProjectDescriptor _runtimeProject = this.config.getRuntimeProject();
    TestProjectDescriptor _testProject = _runtimeProject.getTestProject();
    _testProject.setEnabled(true);
    RuntimeProjectDescriptor _runtimeProject_1 = this.config.getRuntimeProject();
    TestProjectDescriptor _testProject_1 = _runtimeProject_1.getTestProject();
    boolean _isEclipsePluginProject = _testProject_1.isEclipsePluginProject();
    Assert.assertTrue(_isEclipsePluginProject);
  }
  
  @Test
  public void eclipseUiCanBeBuiltWithPDE() {
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    boolean _needsGradleBuild = this.config.needsGradleBuild();
    Assert.assertFalse(_needsGradleBuild);
    boolean _needsMavenBuild = this.config.needsMavenBuild();
    Assert.assertFalse(_needsMavenBuild);
  }
  
  @Test
  public void eclipseUiIsBuiltWithTychoWhenNotUsingPDE() {
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    this.config.setPreferredBuildSystem(BuildSystem.GRADLE);
    boolean _needsTychoBuild = this.config.needsTychoBuild();
    Assert.assertTrue(_needsTychoBuild);
  }
  
  @Test
  public void intellijNeedsAGradleBuild() {
    IntellijProjectDescriptor _intellijProject = this.config.getIntellijProject();
    _intellijProject.setEnabled(true);
    boolean _needsGradleBuild = this.config.needsGradleBuild();
    Assert.assertTrue(_needsGradleBuild);
  }
  
  @Test
  public void mavenNeedsAParentProject() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    ParentProjectDescriptor _parentProject = this.config.getParentProject();
    boolean _isEnabled = _parentProject.isEnabled();
    Assert.assertTrue(_isEnabled);
  }
  
  @Test
  public void gradleNeedsAParentProject() {
    this.config.setPreferredBuildSystem(BuildSystem.GRADLE);
    ParentProjectDescriptor _parentProject = this.config.getParentProject();
    boolean _isEnabled = _parentProject.isEnabled();
    Assert.assertTrue(_isEnabled);
  }
  
  @Test
  public void inlinedTestProjectsDontOverrideMainSources() {
    RuntimeProjectDescriptor _runtimeProject = this.config.getRuntimeProject();
    TestProjectDescriptor _testProject = _runtimeProject.getTestProject();
    _testProject.setEnabled(true);
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    this.config.setSourceLayout(SourceLayout.MAVEN);
    RuntimeProjectDescriptor _runtimeProject_1 = this.config.getRuntimeProject();
    Iterable<? extends TextFile> _files = _runtimeProject_1.getFiles();
    final Function1<TextFile, Boolean> _function = new Function1<TextFile, Boolean>() {
      @Override
      public Boolean apply(final TextFile it) {
        String _relativePath = it.getRelativePath();
        return Boolean.valueOf(Objects.equal(_relativePath, "pom.xml"));
      }
    };
    final TextFile pom = IterableExtensions.findFirst(_files, _function);
    String _content = pom.getContent();
    String _string = _content.toString();
    boolean _contains = _string.contains("<artifactId>org.example.mydsl</artifactId>");
    Assert.assertTrue(_contains);
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
    final Procedure1<ExternalDependency> _function = new Procedure1<ExternalDependency>() {
      @Override
      public void apply(final ExternalDependency testDependency) {
        RuntimeProjectDescriptor _runtimeProject = WizardConfigurationTest.this.config.getRuntimeProject();
        Set<ExternalDependency> _externalDependencies = _runtimeProject.getExternalDependencies();
        final Function1<ExternalDependency, Boolean> _function = new Function1<ExternalDependency, Boolean>() {
          @Override
          public Boolean apply(final ExternalDependency it) {
            boolean _and = false;
            boolean _and_1 = false;
            ExternalDependency.MavenCoordinates _maven = it.getMaven();
            String _artifactId = _maven.getArtifactId();
            ExternalDependency.MavenCoordinates _maven_1 = testDependency.getMaven();
            String _artifactId_1 = _maven_1.getArtifactId();
            boolean _equals = Objects.equal(_artifactId, _artifactId_1);
            if (!_equals) {
              _and_1 = false;
            } else {
              ExternalDependency.P2Coordinates _p2 = it.getP2();
              String _bundleId = _p2.getBundleId();
              ExternalDependency.P2Coordinates _p2_1 = testDependency.getP2();
              String _bundleId_1 = _p2_1.getBundleId();
              boolean _equals_1 = Objects.equal(_bundleId, _bundleId_1);
              _and_1 = _equals_1;
            }
            if (!_and_1) {
              _and = false;
            } else {
              ExternalDependency.P2Coordinates _p2_2 = it.getP2();
              Set<String> _packages = _p2_2.getPackages();
              ExternalDependency.P2Coordinates _p2_3 = testDependency.getP2();
              Set<String> _packages_1 = _p2_3.getPackages();
              boolean _equals_2 = Objects.equal(_packages, _packages_1);
              _and = _equals_2;
            }
            return Boolean.valueOf(_and);
          }
        };
        boolean _exists = IterableExtensions.<ExternalDependency>exists(_externalDependencies, _function);
        Assert.assertTrue(_exists);
      }
    };
    IterableExtensions.<ExternalDependency>forEach(_externalDependencies, _function);
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
    final Procedure1<String> _function = new Procedure1<String>() {
      @Override
      public void apply(final String testFolder) {
        RuntimeProjectDescriptor _runtimeProject = WizardConfigurationTest.this.config.getRuntimeProject();
        Set<String> _sourceFolders = _runtimeProject.getSourceFolders();
        boolean _contains = _sourceFolders.contains(testFolder);
        Assert.assertTrue(_contains);
      }
    };
    IterableExtensions.<String>forEach(_sourceFolders, _function);
  }
  
  @Test
  public void mavenProjectsHaveAPom() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ProjectDescriptor it) {
        return Boolean.valueOf(it.isPartOfMavenBuild());
      }
    };
    Iterable<? extends ProjectDescriptor> _filter = IterableExtensions.filter(_allJavaProjects, _function);
    final Procedure1<ProjectDescriptor> _function_1 = new Procedure1<ProjectDescriptor>() {
      @Override
      public void apply(final ProjectDescriptor it) {
        it.setEnabled(true);
        Iterable<? extends TextFile> _files = it.getFiles();
        final Function1<TextFile, Boolean> _function = new Function1<TextFile, Boolean>() {
          @Override
          public Boolean apply(final TextFile it) {
            String _relativePath = it.getRelativePath();
            return Boolean.valueOf(Objects.equal(_relativePath, "pom.xml"));
          }
        };
        boolean _exists = IterableExtensions.exists(_files, _function);
        Assert.assertTrue(_exists);
      }
    };
    IterableExtensions.forEach(_filter, _function_1);
  }
  
  @Test
  public void gradleProjectsHaveABuildFile() {
    this.config.setPreferredBuildSystem(BuildSystem.GRADLE);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ProjectDescriptor it) {
        return Boolean.valueOf(it.isPartOfGradleBuild());
      }
    };
    Iterable<? extends ProjectDescriptor> _filter = IterableExtensions.filter(_allJavaProjects, _function);
    final Procedure1<ProjectDescriptor> _function_1 = new Procedure1<ProjectDescriptor>() {
      @Override
      public void apply(final ProjectDescriptor it) {
        it.setEnabled(true);
        Iterable<? extends TextFile> _files = it.getFiles();
        final Function1<TextFile, Boolean> _function = new Function1<TextFile, Boolean>() {
          @Override
          public Boolean apply(final TextFile it) {
            String _relativePath = it.getRelativePath();
            return Boolean.valueOf(Objects.equal(_relativePath, "build.gradle"));
          }
        };
        boolean _exists = IterableExtensions.exists(_files, _function);
        Assert.assertTrue(_exists);
      }
    };
    IterableExtensions.forEach(_filter, _function_1);
  }
  
  @Test
  public void pluginProjectsHaveEclipseMetaData() {
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ProjectDescriptor it) {
        return Boolean.valueOf(it.isEclipsePluginProject());
      }
    };
    Iterable<? extends ProjectDescriptor> _filter = IterableExtensions.filter(_allJavaProjects, _function);
    final Procedure1<ProjectDescriptor> _function_1 = new Procedure1<ProjectDescriptor>() {
      @Override
      public void apply(final ProjectDescriptor it) {
        it.setEnabled(true);
        Iterable<? extends TextFile> _files = it.getFiles();
        final Function1<TextFile, Boolean> _function = new Function1<TextFile, Boolean>() {
          @Override
          public Boolean apply(final TextFile it) {
            String _relativePath = it.getRelativePath();
            return Boolean.valueOf(Objects.equal(_relativePath, "MANIFEST.MF"));
          }
        };
        boolean _exists = IterableExtensions.exists(_files, _function);
        Assert.assertTrue(_exists);
        Iterable<? extends TextFile> _files_1 = it.getFiles();
        final Function1<TextFile, Boolean> _function_1 = new Function1<TextFile, Boolean>() {
          @Override
          public Boolean apply(final TextFile it) {
            String _relativePath = it.getRelativePath();
            return Boolean.valueOf(Objects.equal(_relativePath, "build.properties"));
          }
        };
        boolean _exists_1 = IterableExtensions.exists(_files_1, _function_1);
        Assert.assertTrue(_exists_1);
      }
    };
    IterableExtensions.forEach(_filter, _function_1);
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
    ParentProjectDescriptor _parentProject = this.config.getParentProject();
    PomFile _pom = _parentProject.pom();
    String _content = _pom.getContent();
    boolean _contains = _content.contains(snapshotsRepo);
    Assert.assertTrue(_contains);
    ParentProjectDescriptor _parentProject_1 = this.config.getParentProject();
    GradleBuildFile _buildGradle = _parentProject_1.buildGradle();
    String _content_1 = _buildGradle.getContent();
    boolean _contains_1 = _content_1.contains(snapshotsRepo);
    Assert.assertTrue(_contains_1);
    final String xtextIntellijSnapshots = "/xtext-intellij/lastSuccessfulBuild/";
    IntellijProjectDescriptor _intellijProject_1 = this.config.getIntellijProject();
    GradleBuildFile _buildGradle_1 = _intellijProject_1.buildGradle();
    String _content_2 = _buildGradle_1.getContent();
    boolean _contains_2 = _content_2.contains(xtextIntellijSnapshots);
    Assert.assertTrue(_contains_2);
    final String nightlyUpdateSite = "xtext/updates/nightly";
    TargetPlatformProject _targetPlatformProject = this.config.getTargetPlatformProject();
    CharSequence _target = _targetPlatformProject.target();
    String _string = _target.toString();
    boolean _contains_3 = _string.contains(nightlyUpdateSite);
    Assert.assertTrue(_contains_3);
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
    ParentProjectDescriptor _parentProject = this.config.getParentProject();
    PomFile _pom = _parentProject.pom();
    String _content = _pom.getContent();
    boolean _contains = _content.contains(snapshotsRepo);
    Assert.assertFalse(_contains);
    ParentProjectDescriptor _parentProject_1 = this.config.getParentProject();
    GradleBuildFile _buildGradle = _parentProject_1.buildGradle();
    String _content_1 = _buildGradle.getContent();
    boolean _contains_1 = _content_1.contains(snapshotsRepo);
    Assert.assertFalse(_contains_1);
    final String xtextIntellijRelease = "xtext/idea/${xtextVersion}";
    IntellijProjectDescriptor _intellijProject_1 = this.config.getIntellijProject();
    GradleBuildFile _buildGradle_1 = _intellijProject_1.buildGradle();
    String _content_2 = _buildGradle_1.getContent();
    boolean _contains_2 = _content_2.contains(xtextIntellijRelease);
    Assert.assertTrue(_contains_2);
    final String releaseUpdateSite = "xtext/updates/releases/2.9.0";
    TargetPlatformProject _targetPlatformProject = this.config.getTargetPlatformProject();
    CharSequence _target = _targetPlatformProject.target();
    String _string = _target.toString();
    boolean _contains_3 = _string.contains(releaseUpdateSite);
    Assert.assertTrue(_contains_3);
  }
  
  @Test
  public void gradleEclipseClasspathIsIgnoredForPluginProjects() {
    this.config.setPreferredBuildSystem(BuildSystem.GRADLE);
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    IdeProjectDescriptor _ideProject = this.config.getIdeProject();
    _ideProject.setEnabled(true);
    Set<ProjectDescriptor> _enabledProjects = this.config.getEnabledProjects();
    final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ProjectDescriptor it) {
        return Boolean.valueOf(it.isEclipsePluginProject());
      }
    };
    Iterable<ProjectDescriptor> _filter = IterableExtensions.<ProjectDescriptor>filter(_enabledProjects, _function);
    final Procedure1<ProjectDescriptor> _function_1 = new Procedure1<ProjectDescriptor>() {
      @Override
      public void apply(final ProjectDescriptor it) {
        GradleBuildFile _buildGradle = it.buildGradle();
        String _content = _buildGradle.getContent();
        boolean _contains = _content.contains("eclipseClasspath.enabled=false");
        Assert.assertTrue(_contains);
      }
    };
    IterableExtensions.<ProjectDescriptor>forEach(_filter, _function_1);
  }
  
  @Test
  public void parentContainsOtherProjectsInHierarchicallayout() {
    this.config.setProjectLayout(ProjectLayout.HIERARCHICAL);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Procedure1<ProjectDescriptor> _function = new Procedure1<ProjectDescriptor>() {
      @Override
      public void apply(final ProjectDescriptor it) {
        String _location = it.getLocation();
        ParentProjectDescriptor _parentProject = WizardConfigurationTest.this.config.getParentProject();
        String _location_1 = _parentProject.getLocation();
        String _plus = (_location_1 + "/");
        boolean _startsWith = _location.startsWith(_plus);
        Assert.assertTrue(_startsWith);
      }
    };
    IterableExtensions.forEach(_allJavaProjects, _function);
  }
  
  @Test
  public void plainMavenProjectsCanBeBuiltWithEclipseLayout() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    this.config.setSourceLayout(SourceLayout.PLAIN);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ProjectDescriptor it) {
        boolean _and = false;
        boolean _isEclipsePluginProject = it.isEclipsePluginProject();
        boolean _not = (!_isEclipsePluginProject);
        if (!_not) {
          _and = false;
        } else {
          boolean _isPartOfMavenBuild = it.isPartOfMavenBuild();
          _and = _isPartOfMavenBuild;
        }
        return Boolean.valueOf(_and);
      }
    };
    final Iterable<? extends ProjectDescriptor> plainMavenProjects = IterableExtensions.filter(_allJavaProjects, _function);
    final Procedure1<ProjectDescriptor> _function_1 = new Procedure1<ProjectDescriptor>() {
      @Override
      public void apply(final ProjectDescriptor it) {
        PomFile _pom = it.pom();
        String _content = _pom.getContent();
        boolean _contains = _content.contains("<sourceDirectory>src</sourceDirectory>");
        Assert.assertTrue(_contains);
        PomFile _pom_1 = it.pom();
        String _content_1 = _pom_1.getContent();
        boolean _contains_1 = _content_1.contains("<directory>src</directory>");
        Assert.assertTrue(_contains_1);
        PomFile _pom_2 = it.pom();
        String _content_2 = _pom_2.getContent();
        boolean _contains_2 = _content_2.contains("<source>src-gen</source>");
        Assert.assertTrue(_contains_2);
        PomFile _pom_3 = it.pom();
        String _content_3 = _pom_3.getContent();
        boolean _contains_3 = _content_3.contains("<directory>src-gen</directory>");
        Assert.assertTrue(_contains_3);
      }
    };
    IterableExtensions.forEach(plainMavenProjects, _function_1);
    final Function1<ProjectDescriptor, Boolean> _function_2 = new Function1<ProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ProjectDescriptor it) {
        return Boolean.valueOf((!(it instanceof TestProjectDescriptor)));
      }
    };
    Iterable<? extends ProjectDescriptor> _filter = IterableExtensions.filter(plainMavenProjects, _function_2);
    final Procedure1<ProjectDescriptor> _function_3 = new Procedure1<ProjectDescriptor>() {
      @Override
      public void apply(final ProjectDescriptor it) {
        PomFile _pom = it.pom();
        String _content = _pom.getContent();
        boolean _contains = _content.contains("add-source");
        Assert.assertTrue(_contains);
        PomFile _pom_1 = it.pom();
        String _content_1 = _pom_1.getContent();
        boolean _contains_1 = _content_1.contains("add-resource");
        Assert.assertTrue(_contains_1);
        PomFile _pom_2 = it.pom();
        String _content_2 = _pom_2.getContent();
        boolean _contains_2 = _content_2.contains("add-test-source");
        Assert.assertFalse(_contains_2);
        PomFile _pom_3 = it.pom();
        String _content_3 = _pom_3.getContent();
        boolean _contains_3 = _content_3.contains("add-test-resource");
        Assert.assertFalse(_contains_3);
      }
    };
    IterableExtensions.forEach(_filter, _function_3);
    Iterable<TestProjectDescriptor> _filter_1 = Iterables.<TestProjectDescriptor>filter(plainMavenProjects, TestProjectDescriptor.class);
    final Procedure1<TestProjectDescriptor> _function_4 = new Procedure1<TestProjectDescriptor>() {
      @Override
      public void apply(final TestProjectDescriptor it) {
        PomFile _pom = it.pom();
        String _content = _pom.getContent();
        boolean _contains = _content.contains("add-test-source");
        Assert.assertTrue(_contains);
        PomFile _pom_1 = it.pom();
        String _content_1 = _pom_1.getContent();
        boolean _contains_1 = _content_1.contains("add-test-resource");
        Assert.assertTrue(_contains_1);
        PomFile _pom_2 = it.pom();
        String _content_2 = _pom_2.getContent();
        boolean _contains_2 = _content_2.contains("add-source");
        Assert.assertFalse(_contains_2);
        PomFile _pom_3 = it.pom();
        String _content_3 = _pom_3.getContent();
        boolean _contains_3 = _content_3.contains("add-resource");
        Assert.assertFalse(_contains_3);
      }
    };
    IterableExtensions.<TestProjectDescriptor>forEach(_filter_1, _function_4);
  }
  
  @Test
  public void plainMavenProjectsCanBeBuiltWithMavenLayout() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    this.config.setSourceLayout(SourceLayout.MAVEN);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ProjectDescriptor it) {
        boolean _and = false;
        boolean _isEclipsePluginProject = it.isEclipsePluginProject();
        boolean _not = (!_isEclipsePluginProject);
        if (!_not) {
          _and = false;
        } else {
          boolean _isPartOfMavenBuild = it.isPartOfMavenBuild();
          _and = _isPartOfMavenBuild;
        }
        return Boolean.valueOf(_and);
      }
    };
    final Iterable<? extends ProjectDescriptor> plainMavenProjects = IterableExtensions.filter(_allJavaProjects, _function);
    final Function1<ProjectDescriptor, Boolean> _function_1 = new Function1<ProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ProjectDescriptor it) {
        return Boolean.valueOf((!(it instanceof TestProjectDescriptor)));
      }
    };
    final Iterable<? extends ProjectDescriptor> mainProjects = IterableExtensions.filter(plainMavenProjects, _function_1);
    final Procedure1<ProjectDescriptor> _function_2 = new Procedure1<ProjectDescriptor>() {
      @Override
      public void apply(final ProjectDescriptor it) {
        it.setEnabled(true);
      }
    };
    IterableExtensions.forEach(plainMavenProjects, _function_2);
    Iterable<TestProjectDescriptor> _filter = Iterables.<TestProjectDescriptor>filter(plainMavenProjects, TestProjectDescriptor.class);
    final Function1<TestProjectDescriptor, Boolean> _function_3 = new Function1<TestProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final TestProjectDescriptor it) {
        return Boolean.valueOf(it.isInlined());
      }
    };
    boolean _forall = IterableExtensions.<TestProjectDescriptor>forall(_filter, _function_3);
    Assert.assertTrue(_forall);
    final Procedure1<ProjectDescriptor> _function_4 = new Procedure1<ProjectDescriptor>() {
      @Override
      public void apply(final ProjectDescriptor it) {
        PomFile _pom = it.pom();
        String _content = _pom.getContent();
        boolean _contains = _content.contains("add-source");
        Assert.assertTrue(_contains);
        PomFile _pom_1 = it.pom();
        String _content_1 = _pom_1.getContent();
        boolean _contains_1 = _content_1.contains("add-resource");
        Assert.assertTrue(_contains_1);
        PomFile _pom_2 = it.pom();
        String _content_2 = _pom_2.getContent();
        boolean _contains_2 = _content_2.contains("<source>src/main/xtext-gen</source>");
        Assert.assertTrue(_contains_2);
        PomFile _pom_3 = it.pom();
        String _content_3 = _pom_3.getContent();
        boolean _contains_3 = _content_3.contains("<directory>src/main/xtext-gen</directory>");
        Assert.assertTrue(_contains_3);
      }
    };
    IterableExtensions.forEach(mainProjects, _function_4);
    Iterable<TestedProjectDescriptor> _filter_1 = Iterables.<TestedProjectDescriptor>filter(mainProjects, TestedProjectDescriptor.class);
    final Procedure1<TestedProjectDescriptor> _function_5 = new Procedure1<TestedProjectDescriptor>() {
      @Override
      public void apply(final TestedProjectDescriptor it) {
        PomFile _pom = it.pom();
        String _content = _pom.getContent();
        boolean _contains = _content.contains("add-test-source");
        Assert.assertTrue(_contains);
        PomFile _pom_1 = it.pom();
        String _content_1 = _pom_1.getContent();
        boolean _contains_1 = _content_1.contains("add-test-resource");
        Assert.assertTrue(_contains_1);
        PomFile _pom_2 = it.pom();
        String _content_2 = _pom_2.getContent();
        boolean _contains_2 = _content_2.contains("<source>src/test/xtext-gen</source>");
        Assert.assertTrue(_contains_2);
        PomFile _pom_3 = it.pom();
        String _content_3 = _pom_3.getContent();
        boolean _contains_3 = _content_3.contains("<directory>src/test/xtext-gen</directory>");
        Assert.assertTrue(_contains_3);
      }
    };
    IterableExtensions.<TestedProjectDescriptor>forEach(_filter_1, _function_5);
  }
  
  @Test
  public void pomFileDontDuplicateMavenDefaults() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    this.config.setSourceLayout(SourceLayout.MAVEN);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ProjectDescriptor it) {
        boolean _and = false;
        boolean _isEclipsePluginProject = it.isEclipsePluginProject();
        boolean _not = (!_isEclipsePluginProject);
        if (!_not) {
          _and = false;
        } else {
          boolean _isPartOfMavenBuild = it.isPartOfMavenBuild();
          _and = _isPartOfMavenBuild;
        }
        return Boolean.valueOf(_and);
      }
    };
    final Iterable<? extends ProjectDescriptor> plainMavenProjects = IterableExtensions.filter(_allJavaProjects, _function);
    final Function1<ProjectDescriptor, Boolean> _function_1 = new Function1<ProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ProjectDescriptor it) {
        return Boolean.valueOf((!(it instanceof TestProjectDescriptor)));
      }
    };
    final Iterable<? extends ProjectDescriptor> mainProjects = IterableExtensions.filter(plainMavenProjects, _function_1);
    final Procedure1<ProjectDescriptor> _function_2 = new Procedure1<ProjectDescriptor>() {
      @Override
      public void apply(final ProjectDescriptor it) {
        it.setEnabled(true);
      }
    };
    IterableExtensions.forEach(plainMavenProjects, _function_2);
    final Procedure1<ProjectDescriptor> _function_3 = new Procedure1<ProjectDescriptor>() {
      @Override
      public void apply(final ProjectDescriptor it) {
        PomFile _pom = it.pom();
        String _content = _pom.getContent();
        boolean _contains = _content.contains("<sourceDirectory>");
        Assert.assertFalse(_contains);
        PomFile _pom_1 = it.pom();
        String _content_1 = _pom_1.getContent();
        boolean _contains_1 = _content_1.contains("<directory>src/main/resources</directory>");
        Assert.assertFalse(_contains_1);
        PomFile _pom_2 = it.pom();
        String _content_2 = _pom_2.getContent();
        boolean _contains_2 = _content_2.contains("<testSourceDirectory>");
        Assert.assertFalse(_contains_2);
        PomFile _pom_3 = it.pom();
        String _content_3 = _pom_3.getContent();
        boolean _contains_3 = _content_3.contains("<directory>src/test/resources</directory>");
        Assert.assertFalse(_contains_3);
      }
    };
    IterableExtensions.forEach(mainProjects, _function_3);
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
    boolean _contains = pom.contains("useUIHarness");
    Assert.assertTrue(_contains);
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
    boolean _contains = pom.contains("useUIHarness");
    Assert.assertFalse(_contains);
  }
  
  @Test
  public void tychoDoesNotFailOnMissingTests() {
    this.config.setPreferredBuildSystem(BuildSystem.MAVEN);
    UiProjectDescriptor _uiProject = this.config.getUiProject();
    _uiProject.setEnabled(true);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    Iterable<TestProjectDescriptor> _filter = Iterables.<TestProjectDescriptor>filter(_allJavaProjects, TestProjectDescriptor.class);
    final Function1<TestProjectDescriptor, Boolean> _function = new Function1<TestProjectDescriptor, Boolean>() {
      @Override
      public Boolean apply(final TestProjectDescriptor it) {
        return Boolean.valueOf(it.isEclipsePluginProject());
      }
    };
    Iterable<TestProjectDescriptor> _filter_1 = IterableExtensions.<TestProjectDescriptor>filter(_filter, _function);
    final Function1<TestProjectDescriptor, PomFile> _function_1 = new Function1<TestProjectDescriptor, PomFile>() {
      @Override
      public PomFile apply(final TestProjectDescriptor it) {
        return it.pom();
      }
    };
    final Iterable<PomFile> poms = IterableExtensions.<TestProjectDescriptor, PomFile>map(_filter_1, _function_1);
    final Procedure1<PomFile> _function_2 = new Procedure1<PomFile>() {
      @Override
      public void apply(final PomFile it) {
        String _content = it.getContent();
        boolean _contains = _content.contains("failIfNoTests");
        Assert.assertTrue(_contains);
      }
    };
    IterableExtensions.<PomFile>forEach(poms, _function_2);
  }
  
  @Test
  public void allBuildSystemsUseJava6() {
    ParentProjectDescriptor _parentProject = this.config.getParentProject();
    PomFile _pom = _parentProject.pom();
    final String parentPom = _pom.getContent();
    boolean _contains = parentPom.contains("<maven.compiler.source>1.6</maven.compiler.source>");
    Assert.assertTrue(_contains);
    boolean _contains_1 = parentPom.contains("<maven.compiler.target>1.6</maven.compiler.target>");
    Assert.assertTrue(_contains_1);
    ParentProjectDescriptor _parentProject_1 = this.config.getParentProject();
    GradleBuildFile _buildGradle = _parentProject_1.buildGradle();
    final String parentGradle = _buildGradle.getContent();
    boolean _contains_2 = parentGradle.contains("sourceCompatibility = \'1.6\'");
    Assert.assertTrue(_contains_2);
    boolean _contains_3 = parentGradle.contains("targetCompatibility = \'1.6\'");
    Assert.assertTrue(_contains_3);
    List<? extends ProjectDescriptor> _allJavaProjects = this.allJavaProjects();
    final Function1<ProjectDescriptor, String> _function = new Function1<ProjectDescriptor, String>() {
      @Override
      public String apply(final ProjectDescriptor it) {
        return it.manifest();
      }
    };
    List<String> _map = ListExtensions.map(_allJavaProjects, _function);
    final Procedure1<String> _function_1 = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        boolean _contains = it.contains("Bundle-RequiredExecutionEnvironment: JavaSE-1.6");
        Assert.assertTrue(_contains);
      }
    };
    IterableExtensions.<String>forEach(_map, _function_1);
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
}

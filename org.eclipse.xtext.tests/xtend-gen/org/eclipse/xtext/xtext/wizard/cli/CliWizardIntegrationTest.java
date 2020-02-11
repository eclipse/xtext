/**
 * Copyright (c) 2015, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard.cli;

import com.google.common.base.Charsets;
import com.google.common.collect.Sets;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.tests.LineDelimiters;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.util.XtextVersion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.IdeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageServer;
import org.eclipse.xtext.xtext.wizard.LineDelimiter;
import org.eclipse.xtext.xtext.wizard.P2RepositoryProject;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TestProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.UiProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WebProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;
import org.eclipse.xtext.xtext.wizard.cli.CliProjectsCreator;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
@SuppressWarnings("all")
public class CliWizardIntegrationTest {
  @Data
  private static class GeneratedFile {
    private final String relativePath;
    
    private final String content;
    
    public GeneratedFile(final String relativePath, final String content) {
      super();
      this.relativePath = relativePath;
      this.content = content;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.relativePath== null) ? 0 : this.relativePath.hashCode());
      return prime * result + ((this.content== null) ? 0 : this.content.hashCode());
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      CliWizardIntegrationTest.GeneratedFile other = (CliWizardIntegrationTest.GeneratedFile) obj;
      if (this.relativePath == null) {
        if (other.relativePath != null)
          return false;
      } else if (!this.relativePath.equals(other.relativePath))
        return false;
      if (this.content == null) {
        if (other.content != null)
          return false;
      } else if (!this.content.equals(other.content))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("relativePath", this.relativePath);
      b.add("content", this.content);
      return b.toString();
    }
    
    @Pure
    public String getRelativePath() {
      return this.relativePath;
    }
    
    @Pure
    public String getContent() {
      return this.content;
    }
  }
  
  /**
   * Use this main method to update the expectations to whatever the wizard currently generates
   */
  public static void main(final String[] args) {
    final CliProjectsCreator creator = CliWizardIntegrationTest.newProjectCreator();
    final Consumer<WizardConfiguration> _function = (WizardConfiguration config) -> {
      try {
        String _baseName = config.getBaseName();
        final File targetLocation = new File("testdata/wizard-expectations", _baseName);
        targetLocation.mkdirs();
        Files.sweepFolder(targetLocation);
        config.setRootLocation(targetLocation.getPath());
        creator.createProjects(config);
        String _baseName_1 = config.getBaseName();
        String _plus = ("Updating expectations for " + _baseName_1);
        InputOutput.<String>println(_plus);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    CliWizardIntegrationTest.projectConfigs.forEach(_function);
  }
  
  private static final List<WizardConfiguration> projectConfigs = Collections.<WizardConfiguration>unmodifiableList(CollectionLiterals.<WizardConfiguration>newArrayList(ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.plainMaven");
    it.setPreferredBuildSystem(BuildSystem.MAVEN);
    it.setSourceLayout(SourceLayout.MAVEN);
    it.setProjectLayout(ProjectLayout.HIERARCHICAL);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(true);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    WebProjectDescriptor _webProject = it.getWebProject();
    _webProject.setEnabled(true);
  })), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.mavenTycho");
    it.setPreferredBuildSystem(BuildSystem.MAVEN);
    it.setSourceLayout(SourceLayout.PLAIN);
    it.setProjectLayout(ProjectLayout.HIERARCHICAL);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(true);
    UiProjectDescriptor _uiProject = it.getUiProject();
    _uiProject.setEnabled(true);
    TestProjectDescriptor _testProject_1 = it.getUiProject().getTestProject();
    _testProject_1.setEnabled(true);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    WebProjectDescriptor _webProject = it.getWebProject();
    _webProject.setEnabled(true);
  })), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.mavenTychoJ9");
    it.setPreferredBuildSystem(BuildSystem.MAVEN);
    it.setSourceLayout(SourceLayout.PLAIN);
    it.setProjectLayout(ProjectLayout.HIERARCHICAL);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(true);
    UiProjectDescriptor _uiProject = it.getUiProject();
    _uiProject.setEnabled(true);
    TestProjectDescriptor _testProject_1 = it.getUiProject().getTestProject();
    _testProject_1.setEnabled(true);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    WebProjectDescriptor _webProject = it.getWebProject();
    _webProject.setEnabled(true);
    it.setJavaVersion(JavaVersion.JAVA9);
  })), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.gradle");
    it.setPreferredBuildSystem(BuildSystem.GRADLE);
    it.setSourceLayout(SourceLayout.MAVEN);
    it.setProjectLayout(ProjectLayout.HIERARCHICAL);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(true);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    WebProjectDescriptor _webProject = it.getWebProject();
    _webProject.setEnabled(true);
  })), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.eclipsePlugin");
    it.setPreferredBuildSystem(BuildSystem.NONE);
    it.setSourceLayout(SourceLayout.PLAIN);
    it.setProjectLayout(ProjectLayout.FLAT);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(true);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    UiProjectDescriptor _uiProject = it.getUiProject();
    _uiProject.setEnabled(true);
    TestProjectDescriptor _testProject_1 = it.getUiProject().getTestProject();
    _testProject_1.setEnabled(true);
  })), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.eclipsePluginP2");
    it.setPreferredBuildSystem(BuildSystem.NONE);
    it.setSourceLayout(SourceLayout.PLAIN);
    it.setProjectLayout(ProjectLayout.FLAT);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(true);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    UiProjectDescriptor _uiProject = it.getUiProject();
    _uiProject.setEnabled(true);
    TestProjectDescriptor _testProject_1 = it.getUiProject().getTestProject();
    _testProject_1.setEnabled(true);
    P2RepositoryProject _p2Project = it.getP2Project();
    _p2Project.setEnabled(true);
  })), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.mavenTychoP2");
    it.setPreferredBuildSystem(BuildSystem.MAVEN);
    it.setSourceLayout(SourceLayout.PLAIN);
    it.setProjectLayout(ProjectLayout.HIERARCHICAL);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(true);
    UiProjectDescriptor _uiProject = it.getUiProject();
    _uiProject.setEnabled(true);
    TestProjectDescriptor _testProject_1 = it.getUiProject().getTestProject();
    _testProject_1.setEnabled(true);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    WebProjectDescriptor _webProject = it.getWebProject();
    _webProject.setEnabled(true);
    P2RepositoryProject _p2Project = it.getP2Project();
    _p2Project.setEnabled(true);
  })), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.full");
    it.setPreferredBuildSystem(BuildSystem.GRADLE);
    it.setSourceLayout(SourceLayout.PLAIN);
    it.setProjectLayout(ProjectLayout.HIERARCHICAL);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(true);
    UiProjectDescriptor _uiProject = it.getUiProject();
    _uiProject.setEnabled(true);
    TestProjectDescriptor _testProject_1 = it.getUiProject().getTestProject();
    _testProject_1.setEnabled(true);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    WebProjectDescriptor _webProject = it.getWebProject();
    _webProject.setEnabled(true);
    P2RepositoryProject _p2Project = it.getP2Project();
    _p2Project.setEnabled(true);
  })), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.lsMavenFatjar");
    it.setPreferredBuildSystem(BuildSystem.MAVEN);
    it.setSourceLayout(SourceLayout.PLAIN);
    it.setProjectLayout(ProjectLayout.HIERARCHICAL);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(false);
    UiProjectDescriptor _uiProject = it.getUiProject();
    _uiProject.setEnabled(false);
    TestProjectDescriptor _testProject_1 = it.getUiProject().getTestProject();
    _testProject_1.setEnabled(false);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    WebProjectDescriptor _webProject = it.getWebProject();
    _webProject.setEnabled(false);
    it.setLanguageServer(LanguageServer.FATJAR);
  })), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.lsMavenTychoFatjar");
    it.setPreferredBuildSystem(BuildSystem.MAVEN);
    it.setSourceLayout(SourceLayout.PLAIN);
    it.setProjectLayout(ProjectLayout.HIERARCHICAL);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(false);
    UiProjectDescriptor _uiProject = it.getUiProject();
    _uiProject.setEnabled(true);
    TestProjectDescriptor _testProject_1 = it.getUiProject().getTestProject();
    _testProject_1.setEnabled(false);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    WebProjectDescriptor _webProject = it.getWebProject();
    _webProject.setEnabled(false);
    it.setLanguageServer(LanguageServer.FATJAR);
  })), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.lsGradleFatjar");
    it.setPreferredBuildSystem(BuildSystem.GRADLE);
    it.setSourceLayout(SourceLayout.PLAIN);
    it.setProjectLayout(ProjectLayout.HIERARCHICAL);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(false);
    UiProjectDescriptor _uiProject = it.getUiProject();
    _uiProject.setEnabled(false);
    TestProjectDescriptor _testProject_1 = it.getUiProject().getTestProject();
    _testProject_1.setEnabled(false);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    WebProjectDescriptor _webProject = it.getWebProject();
    _webProject.setEnabled(false);
    it.setLanguageServer(LanguageServer.FATJAR);
  })), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.lsMavenApp");
    it.setPreferredBuildSystem(BuildSystem.MAVEN);
    it.setSourceLayout(SourceLayout.PLAIN);
    it.setProjectLayout(ProjectLayout.HIERARCHICAL);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(false);
    UiProjectDescriptor _uiProject = it.getUiProject();
    _uiProject.setEnabled(false);
    TestProjectDescriptor _testProject_1 = it.getUiProject().getTestProject();
    _testProject_1.setEnabled(false);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    WebProjectDescriptor _webProject = it.getWebProject();
    _webProject.setEnabled(false);
    it.setLanguageServer(LanguageServer.APP);
  })), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.lsMavenTychoApp");
    it.setPreferredBuildSystem(BuildSystem.MAVEN);
    it.setSourceLayout(SourceLayout.PLAIN);
    it.setProjectLayout(ProjectLayout.HIERARCHICAL);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(false);
    UiProjectDescriptor _uiProject = it.getUiProject();
    _uiProject.setEnabled(true);
    TestProjectDescriptor _testProject_1 = it.getUiProject().getTestProject();
    _testProject_1.setEnabled(false);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    WebProjectDescriptor _webProject = it.getWebProject();
    _webProject.setEnabled(false);
    it.setLanguageServer(LanguageServer.APP);
  })), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), ((Procedure1<WizardConfiguration>) (WizardConfiguration it) -> {
    it.setBaseName("org.xtext.example.lsGradleApp");
    it.setPreferredBuildSystem(BuildSystem.GRADLE);
    it.setSourceLayout(SourceLayout.PLAIN);
    it.setProjectLayout(ProjectLayout.HIERARCHICAL);
    TestProjectDescriptor _testProject = it.getRuntimeProject().getTestProject();
    _testProject.setEnabled(false);
    UiProjectDescriptor _uiProject = it.getUiProject();
    _uiProject.setEnabled(false);
    TestProjectDescriptor _testProject_1 = it.getUiProject().getTestProject();
    _testProject_1.setEnabled(false);
    IdeProjectDescriptor _ideProject = it.getIdeProject();
    _ideProject.setEnabled(true);
    WebProjectDescriptor _webProject = it.getWebProject();
    _webProject.setEnabled(false);
    it.setLanguageServer(LanguageServer.APP);
  }))));
  
  private static WizardConfiguration newProjectConfig() {
    final Procedure1<WizardConfiguration> _function = (WizardConfiguration it) -> {
      XtextVersion _xtextVersion = new XtextVersion("unspecified");
      it.setXtextVersion(_xtextVersion);
      it.setEncoding(Charsets.UTF_8);
      it.setLineDelimiter(LineDelimiter.UNIX.getValue());
      LanguageDescriptor _language = it.getLanguage();
      final Procedure1<LanguageDescriptor> _function_1 = (LanguageDescriptor it_1) -> {
        it_1.setName("org.xtext.example.mydsl.MyDsl");
        it_1.setFileExtensions(LanguageDescriptor.FileExtensions.fromString("mydsl"));
      };
      ObjectExtensions.<LanguageDescriptor>operator_doubleArrow(_language, _function_1);
    };
    return ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
      new WizardConfiguration() {
        @Override
        public String toString() {
          StringConcatenation _builder = new StringConcatenation();
          BuildSystem _preferredBuildSystem = this.getPreferredBuildSystem();
          _builder.append(_preferredBuildSystem);
          _builder.append("|");
          SourceLayout _sourceLayout = this.getSourceLayout();
          _builder.append(_sourceLayout);
          _builder.append("|");
          ProjectLayout _projectLayout = this.getProjectLayout();
          _builder.append(_projectLayout);
          _builder.append("|");
          LanguageServer _languageServer = this.getLanguageServer();
          _builder.append(_languageServer);
          return _builder.toString();
        }
      }, _function);
  }
  
  private static CliProjectsCreator newProjectCreator() {
    CliProjectsCreator _cliProjectsCreator = new CliProjectsCreator();
    final Procedure1<CliProjectsCreator> _function = (CliProjectsCreator it) -> {
      it.setLineDelimiter("\n");
    };
    return ObjectExtensions.<CliProjectsCreator>operator_doubleArrow(_cliProjectsCreator, _function);
  }
  
  @Parameterized.Parameters(name = "{index}: {0}")
  public static List<WizardConfiguration> data() {
    return CliWizardIntegrationTest.projectConfigs;
  }
  
  @Rule
  public TemporaryFolder temp = new TemporaryFolder();
  
  private WizardConfiguration config;
  
  private CliProjectsCreator creator;
  
  public CliWizardIntegrationTest(final WizardConfiguration config) {
    this.config = config;
    this.creator = CliWizardIntegrationTest.newProjectCreator();
  }
  
  @Test
  public void testProjectCreation() {
    this.validateCreatedProjects();
  }
  
  private void validateCreatedProjects() {
    File _root = this.temp.getRoot();
    String _baseName = this.config.getBaseName();
    final File targetLocation = new File(_root, _baseName);
    this.config.setRootLocation(targetLocation.getPath());
    this.creator.createProjects(this.config);
    String _baseName_1 = this.config.getBaseName();
    final File expectationLocation = new File("testdata/wizard-expectations", _baseName_1);
    final TreeSet<CliWizardIntegrationTest.GeneratedFile> expectedFiles = this.toFileSet(expectationLocation);
    final TreeSet<CliWizardIntegrationTest.GeneratedFile> actualFiles = this.toFileSet(targetLocation);
    this.compareFileTrees(expectedFiles, actualFiles);
  }
  
  private TreeSet<CliWizardIntegrationTest.GeneratedFile> toFileSet(final File root) {
    TreeSet<CliWizardIntegrationTest.GeneratedFile> _xblockexpression = null;
    {
      final ArrayList<File> allFiles = CollectionLiterals.<File>newArrayList();
      this.collectAllFiles(root, allFiles);
      final Function1<File, CliWizardIntegrationTest.GeneratedFile> _function = (File it) -> {
        CliWizardIntegrationTest.GeneratedFile _xblockexpression_1 = null;
        {
          final String relativePath = it.getPath().replace(root.getPath(), "");
          _xblockexpression_1 = this.toGeneratedFile(it, relativePath);
        }
        return _xblockexpression_1;
      };
      final List<CliWizardIntegrationTest.GeneratedFile> generatedFiles = ListExtensions.<File, CliWizardIntegrationTest.GeneratedFile>map(allFiles, _function);
      final Comparator<CliWizardIntegrationTest.GeneratedFile> _function_1 = (CliWizardIntegrationTest.GeneratedFile $0, CliWizardIntegrationTest.GeneratedFile $1) -> {
        return ($0.relativePath.compareTo($1.relativePath));
      };
      final Comparator<CliWizardIntegrationTest.GeneratedFile> sortByPath = _function_1;
      _xblockexpression = CollectionLiterals.<CliWizardIntegrationTest.GeneratedFile>newTreeSet(sortByPath, ((CliWizardIntegrationTest.GeneratedFile[])Conversions.unwrapArray(generatedFiles, CliWizardIntegrationTest.GeneratedFile.class)));
    }
    return _xblockexpression;
  }
  
  private void collectAllFiles(final File root, final List<File> children) {
    boolean _isDirectory = root.isDirectory();
    if (_isDirectory) {
      final Consumer<File> _function = (File it) -> {
        this.collectAllFiles(it, children);
      };
      ((List<File>)Conversions.doWrapArray(root.listFiles())).forEach(_function);
    } else {
      children.add(root);
    }
  }
  
  private CliWizardIntegrationTest.GeneratedFile toGeneratedFile(final File file, final String relativePath) {
    try {
      String _xifexpression = null;
      boolean _isDirectory = file.isDirectory();
      if (_isDirectory) {
        _xifexpression = "";
      } else {
        _xifexpression = com.google.common.io.Files.asCharSource(file, this.config.getEncoding()).read();
      }
      return new CliWizardIntegrationTest.GeneratedFile(relativePath, _xifexpression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void compareFileTrees(final Set<CliWizardIntegrationTest.GeneratedFile> expectedFiles, final Set<CliWizardIntegrationTest.GeneratedFile> actualFiles) {
    final Function1<CliWizardIntegrationTest.GeneratedFile, String> _function = (CliWizardIntegrationTest.GeneratedFile it) -> {
      return it.relativePath;
    };
    final Map<String, CliWizardIntegrationTest.GeneratedFile> expectedFilesByPath = IterableExtensions.<String, CliWizardIntegrationTest.GeneratedFile>toMap(expectedFiles, _function);
    final Function1<CliWizardIntegrationTest.GeneratedFile, String> _function_1 = (CliWizardIntegrationTest.GeneratedFile it) -> {
      return it.relativePath;
    };
    final Map<String, CliWizardIntegrationTest.GeneratedFile> actualFilesByPath = IterableExtensions.<String, CliWizardIntegrationTest.GeneratedFile>toMap(actualFiles, _function_1);
    final Sets.SetView<CliWizardIntegrationTest.GeneratedFile> missingFiles = Sets.<CliWizardIntegrationTest.GeneratedFile>difference(expectedFiles, actualFiles);
    final Sets.SetView<CliWizardIntegrationTest.GeneratedFile> unexpectedFiles = Sets.<CliWizardIntegrationTest.GeneratedFile>difference(actualFiles, expectedFiles);
    final Sets.SetView<CliWizardIntegrationTest.GeneratedFile> comparableFiles = Sets.<CliWizardIntegrationTest.GeneratedFile>intersection(expectedFiles, actualFiles);
    final Consumer<CliWizardIntegrationTest.GeneratedFile> _function_2 = (CliWizardIntegrationTest.GeneratedFile it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Missing file: ");
      _builder.append(it.relativePath);
      throw new ComparisonFailure(_builder.toString(), it.content, "");
    };
    missingFiles.forEach(_function_2);
    final Consumer<CliWizardIntegrationTest.GeneratedFile> _function_3 = (CliWizardIntegrationTest.GeneratedFile it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Unexpected file: ");
      _builder.append(it.relativePath);
      throw new ComparisonFailure(_builder.toString(), "", it.content);
    };
    unexpectedFiles.forEach(_function_3);
    final Consumer<CliWizardIntegrationTest.GeneratedFile> _function_4 = (CliWizardIntegrationTest.GeneratedFile it) -> {
      final String expectedContent = LineDelimiters.toUnix(expectedFilesByPath.get(it.relativePath).content);
      final String actualContent = LineDelimiters.toUnix(actualFilesByPath.get(it.relativePath).content);
      Assert.assertEquals(it.relativePath, expectedContent, actualContent);
    };
    comparableFiles.forEach(_function_4);
  }
}

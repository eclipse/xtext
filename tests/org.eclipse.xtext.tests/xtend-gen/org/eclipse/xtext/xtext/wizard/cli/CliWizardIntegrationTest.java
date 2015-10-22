/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard.cli;

import com.google.common.base.Charsets;
import com.google.common.collect.Sets;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.internal.LineDelimiters;
import org.eclipse.xtext.util.Files;
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
import org.eclipse.xtext.xtext.wizard.IntellijProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
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
      result = prime * result + ((this.content== null) ? 0 : this.content.hashCode());
      return result;
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
    final Procedure1<WizardConfiguration> _function = new Procedure1<WizardConfiguration>() {
      @Override
      public void apply(final WizardConfiguration config) {
        try {
          String _baseName = config.getBaseName();
          final File targetLocation = new File("testdata/wizard-expectations", _baseName);
          targetLocation.mkdirs();
          Files.sweepFolder(targetLocation);
          String _path = targetLocation.getPath();
          config.setRootLocation(_path);
          creator.createProjects(config);
          String _baseName_1 = config.getBaseName();
          String _plus = ("Updating expectations for " + _baseName_1);
          InputOutput.<String>println(_plus);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    IterableExtensions.<WizardConfiguration>forEach(CliWizardIntegrationTest.projectConfigs, _function);
  }
  
  private final static List<WizardConfiguration> projectConfigs = Collections.<WizardConfiguration>unmodifiableList(CollectionLiterals.<WizardConfiguration>newArrayList(ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), new Procedure1<WizardConfiguration>() {
    @Override
    public void apply(final WizardConfiguration it) {
      it.setBaseName("org.xtext.example.plainMaven");
      it.setPreferredBuildSystem(BuildSystem.MAVEN);
      it.setSourceLayout(SourceLayout.MAVEN);
      it.setProjectLayout(ProjectLayout.HIERARCHICAL);
      RuntimeProjectDescriptor _runtimeProject = it.getRuntimeProject();
      TestProjectDescriptor _testProject = _runtimeProject.getTestProject();
      _testProject.setEnabled(true);
      IdeProjectDescriptor _ideProject = it.getIdeProject();
      _ideProject.setEnabled(true);
      WebProjectDescriptor _webProject = it.getWebProject();
      _webProject.setEnabled(true);
    }
  }), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), new Procedure1<WizardConfiguration>() {
    @Override
    public void apply(final WizardConfiguration it) {
      it.setBaseName("org.xtext.example.mavenTycho");
      it.setPreferredBuildSystem(BuildSystem.MAVEN);
      it.setSourceLayout(SourceLayout.PLAIN);
      it.setProjectLayout(ProjectLayout.HIERARCHICAL);
      RuntimeProjectDescriptor _runtimeProject = it.getRuntimeProject();
      TestProjectDescriptor _testProject = _runtimeProject.getTestProject();
      _testProject.setEnabled(true);
      UiProjectDescriptor _uiProject = it.getUiProject();
      _uiProject.setEnabled(true);
      UiProjectDescriptor _uiProject_1 = it.getUiProject();
      TestProjectDescriptor _testProject_1 = _uiProject_1.getTestProject();
      _testProject_1.setEnabled(true);
      IdeProjectDescriptor _ideProject = it.getIdeProject();
      _ideProject.setEnabled(true);
      WebProjectDescriptor _webProject = it.getWebProject();
      _webProject.setEnabled(true);
    }
  }), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), new Procedure1<WizardConfiguration>() {
    @Override
    public void apply(final WizardConfiguration it) {
      it.setBaseName("org.xtext.example.gradle");
      it.setPreferredBuildSystem(BuildSystem.GRADLE);
      it.setSourceLayout(SourceLayout.MAVEN);
      it.setProjectLayout(ProjectLayout.HIERARCHICAL);
      RuntimeProjectDescriptor _runtimeProject = it.getRuntimeProject();
      TestProjectDescriptor _testProject = _runtimeProject.getTestProject();
      _testProject.setEnabled(true);
      IdeProjectDescriptor _ideProject = it.getIdeProject();
      _ideProject.setEnabled(true);
      WebProjectDescriptor _webProject = it.getWebProject();
      _webProject.setEnabled(true);
      IntellijProjectDescriptor _intellijProject = it.getIntellijProject();
      _intellijProject.setEnabled(true);
    }
  }), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), new Procedure1<WizardConfiguration>() {
    @Override
    public void apply(final WizardConfiguration it) {
      it.setBaseName("org.xtext.example.eclipsePlugin");
      it.setPreferredBuildSystem(BuildSystem.ECLIPSE);
      it.setSourceLayout(SourceLayout.PLAIN);
      it.setProjectLayout(ProjectLayout.FLAT);
      RuntimeProjectDescriptor _runtimeProject = it.getRuntimeProject();
      TestProjectDescriptor _testProject = _runtimeProject.getTestProject();
      _testProject.setEnabled(true);
      IdeProjectDescriptor _ideProject = it.getIdeProject();
      _ideProject.setEnabled(true);
      UiProjectDescriptor _uiProject = it.getUiProject();
      _uiProject.setEnabled(true);
      UiProjectDescriptor _uiProject_1 = it.getUiProject();
      TestProjectDescriptor _testProject_1 = _uiProject_1.getTestProject();
      _testProject_1.setEnabled(true);
    }
  }), ObjectExtensions.<WizardConfiguration>operator_doubleArrow(
    CliWizardIntegrationTest.newProjectConfig(), new Procedure1<WizardConfiguration>() {
    @Override
    public void apply(final WizardConfiguration it) {
      it.setBaseName("org.xtext.example.full");
      it.setPreferredBuildSystem(BuildSystem.GRADLE);
      it.setSourceLayout(SourceLayout.PLAIN);
      it.setProjectLayout(ProjectLayout.HIERARCHICAL);
      RuntimeProjectDescriptor _runtimeProject = it.getRuntimeProject();
      TestProjectDescriptor _testProject = _runtimeProject.getTestProject();
      _testProject.setEnabled(true);
      UiProjectDescriptor _uiProject = it.getUiProject();
      _uiProject.setEnabled(true);
      UiProjectDescriptor _uiProject_1 = it.getUiProject();
      TestProjectDescriptor _testProject_1 = _uiProject_1.getTestProject();
      _testProject_1.setEnabled(true);
      IdeProjectDescriptor _ideProject = it.getIdeProject();
      _ideProject.setEnabled(true);
      WebProjectDescriptor _webProject = it.getWebProject();
      _webProject.setEnabled(true);
      IntellijProjectDescriptor _intellijProject = it.getIntellijProject();
      _intellijProject.setEnabled(true);
    }
  })));
  
  private static WizardConfiguration newProjectConfig() {
    WizardConfiguration _wizardConfiguration = new WizardConfiguration();
    final Procedure1<WizardConfiguration> _function = new Procedure1<WizardConfiguration>() {
      @Override
      public void apply(final WizardConfiguration it) {
        XtextVersion _xtextVersion = new XtextVersion("2.9.0-SNAPSHOT");
        it.setXtextVersion(_xtextVersion);
        it.setEncoding(Charsets.UTF_8);
        LanguageDescriptor _language = it.getLanguage();
        final Procedure1<LanguageDescriptor> _function = new Procedure1<LanguageDescriptor>() {
          @Override
          public void apply(final LanguageDescriptor it) {
            it.setName("org.xtext.example.mydsl.MyDsl");
            LanguageDescriptor.FileExtensions _fromString = LanguageDescriptor.FileExtensions.fromString("mydsl");
            it.setFileExtensions(_fromString);
          }
        };
        ObjectExtensions.<LanguageDescriptor>operator_doubleArrow(_language, _function);
      }
    };
    return ObjectExtensions.<WizardConfiguration>operator_doubleArrow(_wizardConfiguration, _function);
  }
  
  private static CliProjectsCreator newProjectCreator() {
    CliProjectsCreator _cliProjectsCreator = new CliProjectsCreator();
    final Procedure1<CliProjectsCreator> _function = new Procedure1<CliProjectsCreator>() {
      @Override
      public void apply(final CliProjectsCreator it) {
        it.setLineDelimiter("\n");
      }
    };
    return ObjectExtensions.<CliProjectsCreator>operator_doubleArrow(_cliProjectsCreator, _function);
  }
  
  @Rule
  public TemporaryFolder temp = new TemporaryFolder();
  
  private WizardConfiguration config;
  
  private CliProjectsCreator creator;
  
  @Test
  public void testProjectCreation() {
    CliProjectsCreator _newProjectCreator = CliWizardIntegrationTest.newProjectCreator();
    this.creator = _newProjectCreator;
    final Procedure1<WizardConfiguration> _function = new Procedure1<WizardConfiguration>() {
      @Override
      public void apply(final WizardConfiguration config) {
        CliWizardIntegrationTest.this.config = config;
        CliWizardIntegrationTest.this.validateCreatedProjects();
      }
    };
    IterableExtensions.<WizardConfiguration>forEach(CliWizardIntegrationTest.projectConfigs, _function);
  }
  
  private void validateCreatedProjects() {
    File _root = this.temp.getRoot();
    String _baseName = this.config.getBaseName();
    final File targetLocation = new File(_root, _baseName);
    String _path = targetLocation.getPath();
    this.config.setRootLocation(_path);
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
      final Function1<File, CliWizardIntegrationTest.GeneratedFile> _function = new Function1<File, CliWizardIntegrationTest.GeneratedFile>() {
        @Override
        public CliWizardIntegrationTest.GeneratedFile apply(final File it) {
          CliWizardIntegrationTest.GeneratedFile _xblockexpression = null;
          {
            String _path = it.getPath();
            String _path_1 = root.getPath();
            final String relativePath = _path.replace(_path_1, "");
            _xblockexpression = CliWizardIntegrationTest.this.toGeneratedFile(it, relativePath);
          }
          return _xblockexpression;
        }
      };
      final List<CliWizardIntegrationTest.GeneratedFile> generatedFiles = ListExtensions.<File, CliWizardIntegrationTest.GeneratedFile>map(allFiles, _function);
      final Comparator<CliWizardIntegrationTest.GeneratedFile> _function_1 = new Comparator<CliWizardIntegrationTest.GeneratedFile>() {
        @Override
        public int compare(final CliWizardIntegrationTest.GeneratedFile $0, final CliWizardIntegrationTest.GeneratedFile $1) {
          return ($0.relativePath.compareTo($1.relativePath));
        }
      };
      final Comparator<CliWizardIntegrationTest.GeneratedFile> sortByPath = _function_1;
      _xblockexpression = CollectionLiterals.<CliWizardIntegrationTest.GeneratedFile>newTreeSet(sortByPath, ((CliWizardIntegrationTest.GeneratedFile[])Conversions.unwrapArray(generatedFiles, CliWizardIntegrationTest.GeneratedFile.class)));
    }
    return _xblockexpression;
  }
  
  private void collectAllFiles(final File root, final List<File> children) {
    children.add(root);
    boolean _isDirectory = root.isDirectory();
    if (_isDirectory) {
      File[] _listFiles = root.listFiles();
      final Procedure1<File> _function = new Procedure1<File>() {
        @Override
        public void apply(final File it) {
          CliWizardIntegrationTest.this.collectAllFiles(it, children);
        }
      };
      IterableExtensions.<File>forEach(((Iterable<File>)Conversions.doWrapArray(_listFiles)), _function);
    }
  }
  
  private CliWizardIntegrationTest.GeneratedFile toGeneratedFile(final File file, final String relativePath) {
    try {
      String _xifexpression = null;
      boolean _isDirectory = file.isDirectory();
      if (_isDirectory) {
        _xifexpression = "";
      } else {
        Charset _encoding = this.config.getEncoding();
        _xifexpression = com.google.common.io.Files.toString(file, _encoding);
      }
      return new CliWizardIntegrationTest.GeneratedFile(relativePath, _xifexpression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void compareFileTrees(final Set<CliWizardIntegrationTest.GeneratedFile> expectedFiles, final Set<CliWizardIntegrationTest.GeneratedFile> actualFiles) {
    final Function1<CliWizardIntegrationTest.GeneratedFile, String> _function = new Function1<CliWizardIntegrationTest.GeneratedFile, String>() {
      @Override
      public String apply(final CliWizardIntegrationTest.GeneratedFile it) {
        return it.relativePath;
      }
    };
    final Map<String, CliWizardIntegrationTest.GeneratedFile> expectedFilesByPath = IterableExtensions.<String, CliWizardIntegrationTest.GeneratedFile>toMap(expectedFiles, _function);
    final Function1<CliWizardIntegrationTest.GeneratedFile, String> _function_1 = new Function1<CliWizardIntegrationTest.GeneratedFile, String>() {
      @Override
      public String apply(final CliWizardIntegrationTest.GeneratedFile it) {
        return it.relativePath;
      }
    };
    final Map<String, CliWizardIntegrationTest.GeneratedFile> actualFilesByPath = IterableExtensions.<String, CliWizardIntegrationTest.GeneratedFile>toMap(actualFiles, _function_1);
    final Sets.SetView<CliWizardIntegrationTest.GeneratedFile> missingFiles = Sets.<CliWizardIntegrationTest.GeneratedFile>difference(actualFiles, expectedFiles);
    final Sets.SetView<CliWizardIntegrationTest.GeneratedFile> unexpectedFiles = Sets.<CliWizardIntegrationTest.GeneratedFile>difference(expectedFiles, actualFiles);
    final Sets.SetView<CliWizardIntegrationTest.GeneratedFile> comparableFiles = Sets.<CliWizardIntegrationTest.GeneratedFile>intersection(expectedFiles, actualFiles);
    final Procedure1<CliWizardIntegrationTest.GeneratedFile> _function_2 = new Procedure1<CliWizardIntegrationTest.GeneratedFile>() {
      @Override
      public void apply(final CliWizardIntegrationTest.GeneratedFile it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Missing file: ");
        _builder.append(it.relativePath, "");
        throw new ComparisonFailure(_builder.toString(), it.content, "");
      }
    };
    IterableExtensions.<CliWizardIntegrationTest.GeneratedFile>forEach(missingFiles, _function_2);
    final Procedure1<CliWizardIntegrationTest.GeneratedFile> _function_3 = new Procedure1<CliWizardIntegrationTest.GeneratedFile>() {
      @Override
      public void apply(final CliWizardIntegrationTest.GeneratedFile it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Unexpected file: ");
        _builder.append(it.relativePath, "");
        throw new ComparisonFailure(_builder.toString(), "", it.content);
      }
    };
    IterableExtensions.<CliWizardIntegrationTest.GeneratedFile>forEach(unexpectedFiles, _function_3);
    final Procedure1<CliWizardIntegrationTest.GeneratedFile> _function_4 = new Procedure1<CliWizardIntegrationTest.GeneratedFile>() {
      @Override
      public void apply(final CliWizardIntegrationTest.GeneratedFile it) {
        CliWizardIntegrationTest.GeneratedFile _get = expectedFilesByPath.get(it.relativePath);
        final String expectedContent = LineDelimiters.toUnix(_get.content);
        CliWizardIntegrationTest.GeneratedFile _get_1 = actualFilesByPath.get(it.relativePath);
        final String actualContent = LineDelimiters.toUnix(_get_1.content);
        Assert.assertEquals(it.relativePath, expectedContent, actualContent);
      }
    };
    IterableExtensions.<CliWizardIntegrationTest.GeneratedFile>forEach(comparableFiles, _function_4);
  }
}

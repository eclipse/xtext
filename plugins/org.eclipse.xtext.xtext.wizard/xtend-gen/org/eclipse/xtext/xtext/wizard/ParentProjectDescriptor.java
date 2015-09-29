package org.eclipse.xtext.xtext.wizard;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.XtextVersion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.wizard.GradleBuildFile;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.PlainTextFile;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TargetPlatformProject;
import org.eclipse.xtext.xtext.wizard.TextFile;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class ParentProjectDescriptor extends ProjectDescriptor {
  private String nameQualifier = ".parent";
  
  @Override
  public String getNameQualifier() {
    return this.nameQualifier;
  }
  
  public void setNameQualifier(final String nameQualifier) {
    this.nameQualifier = nameQualifier;
  }
  
  @Override
  public boolean isEnabled() {
    boolean _or = false;
    boolean _or_1 = false;
    WizardConfiguration _config = this.getConfig();
    boolean _needsGradleBuild = _config.needsGradleBuild();
    if (_needsGradleBuild) {
      _or_1 = true;
    } else {
      WizardConfiguration _config_1 = this.getConfig();
      boolean _needsMavenBuild = _config_1.needsMavenBuild();
      _or_1 = _needsMavenBuild;
    }
    if (_or_1) {
      _or = true;
    } else {
      WizardConfiguration _config_2 = this.getConfig();
      ProjectLayout _projectLayout = _config_2.getProjectLayout();
      boolean _equals = Objects.equal(_projectLayout, ProjectLayout.HIERARCHICAL);
      _or = _equals;
    }
    return _or;
  }
  
  @Override
  public void setEnabled(final boolean enabled) {
    throw new UnsupportedOperationException("The parent project is automatically enabled depending on the build system");
  }
  
  @Override
  public String getLocation() {
    WizardConfiguration _config = this.getConfig();
    String _rootLocation = _config.getRootLocation();
    String _plus = (_rootLocation + "/");
    String _name = this.getName();
    return (_plus + _name);
  }
  
  @Override
  public boolean isEclipsePluginProject() {
    return false;
  }
  
  @Override
  public boolean isPartOfGradleBuild() {
    return true;
  }
  
  @Override
  public boolean isPartOfMavenBuild() {
    return true;
  }
  
  @Override
  public Iterable<? extends TextFile> getFiles() {
    final ArrayList<TextFile> files = CollectionLiterals.<TextFile>newArrayList();
    Iterable<? extends TextFile> _files = super.getFiles();
    Iterables.<TextFile>addAll(files, _files);
    WizardConfiguration _config = this.getConfig();
    boolean _needsGradleBuild = _config.needsGradleBuild();
    if (_needsGradleBuild) {
      CharSequence _settingsGradle = this.settingsGradle();
      PlainTextFile _file = this.file(Outlet.ROOT, "settings.gradle", _settingsGradle);
      files.add(_file);
      CharSequence _sourceLayoutGradle = this.sourceLayoutGradle();
      PlainTextFile _file_1 = this.file(Outlet.ROOT, "gradle/source-layout.gradle", _sourceLayoutGradle);
      files.add(_file_1);
    }
    return files;
  }
  
  @Override
  public GradleBuildFile buildGradle() {
    GradleBuildFile _buildGradle = super.buildGradle();
    final Procedure1<GradleBuildFile> _function = new Procedure1<GradleBuildFile>() {
      @Override
      public void apply(final GradleBuildFile it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("buildscript {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("repositories {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("jcenter()");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("dependencies {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("classpath \'org.xtend:xtend-gradle-plugin:");
        WizardConfiguration _config = ParentProjectDescriptor.this.getConfig();
        XtextVersion _xtextVersion = _config.getXtextVersion();
        String _xtendGradlePluginVersion = _xtextVersion.getXtendGradlePluginVersion();
        _builder.append(_xtendGradlePluginVersion, "\t\t");
        _builder.append("\'");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("subprojects {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("ext.xtextVersion = \"");
        WizardConfiguration _config_1 = ParentProjectDescriptor.this.getConfig();
        XtextVersion _xtextVersion_1 = _config_1.getXtextVersion();
        _builder.append(_xtextVersion_1, "\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("repositories {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("jcenter()");
        _builder.newLine();
        {
          WizardConfiguration _config_2 = ParentProjectDescriptor.this.getConfig();
          XtextVersion _xtextVersion_2 = _config_2.getXtextVersion();
          boolean _isSnapshot = _xtextVersion_2.isSnapshot();
          if (_isSnapshot) {
            _builder.append("\t\t");
            _builder.append("maven {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("url \"https://oss.sonatype.org/content/repositories/snapshots\"");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("apply plugin: \'java\'");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("apply plugin: \'org.xtend.xtend\'");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("apply from: \"${rootDir}/gradle/source-layout.gradle\"");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("sourceCompatibility = \'1.6\'");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("targetCompatibility = \'1.6\'");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it.setAdditionalContent(_builder.toString());
      }
    };
    return ObjectExtensions.<GradleBuildFile>operator_doubleArrow(_buildGradle, _function);
  }
  
  public CharSequence settingsGradle() {
    StringConcatenation _builder = new StringConcatenation();
    {
      WizardConfiguration _config = this.getConfig();
      Set<ProjectDescriptor> _enabledProjects = _config.getEnabledProjects();
      final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
        @Override
        public Boolean apply(final ProjectDescriptor it) {
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(it, ParentProjectDescriptor.this));
          if (!_notEquals) {
            _and = false;
          } else {
            boolean _isPartOfGradleBuild = it.isPartOfGradleBuild();
            _and = _isPartOfGradleBuild;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterable<ProjectDescriptor> _filter = IterableExtensions.<ProjectDescriptor>filter(_enabledProjects, _function);
      for(final ProjectDescriptor p : _filter) {
        {
          WizardConfiguration _config_1 = this.getConfig();
          ProjectLayout _projectLayout = _config_1.getProjectLayout();
          boolean _equals = Objects.equal(_projectLayout, ProjectLayout.FLAT);
          if (_equals) {
            _builder.append("includeFlat");
          } else {
            _builder.append("include");
          }
        }
        _builder.append(" \'");
        String _name = p.getName();
        _builder.append(_name, "");
        _builder.append("\'");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence sourceLayoutGradle() {
    StringConcatenation _builder = new StringConcatenation();
    {
      WizardConfiguration _config = this.getConfig();
      SourceLayout _sourceLayout = _config.getSourceLayout();
      boolean _equals = Objects.equal(_sourceLayout, SourceLayout.PLAIN);
      if (_equals) {
        _builder.append("if (name.endsWith(\".tests\")) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("sourceSets {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("main {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("java.srcDirs = []");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("resources.srcDirs = []");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("test {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("java.srcDirs = [\'");
        String _sourceFolder = this.sourceFolder(Outlet.TEST_JAVA);
        _builder.append(_sourceFolder, "\t\t\t");
        _builder.append("\', \'");
        String _sourceFolder_1 = this.sourceFolder(Outlet.TEST_SRC_GEN);
        _builder.append(_sourceFolder_1, "\t\t\t");
        _builder.append("\']");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("resources.srcDirs = [\'");
        String _sourceFolder_2 = this.sourceFolder(Outlet.TEST_RESOURCES);
        _builder.append(_sourceFolder_2, "\t\t\t");
        _builder.append("\', \'");
        String _sourceFolder_3 = this.sourceFolder(Outlet.TEST_SRC_GEN);
        _builder.append(_sourceFolder_3, "\t\t\t");
        _builder.append("\']");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("xtendOutputDir = \'");
        String _sourceFolder_4 = this.sourceFolder(Outlet.TEST_XTEND_GEN);
        _builder.append(_sourceFolder_4, "\t\t\t");
        _builder.append("\'");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("sourceSets {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("main {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("java.srcDirs = [\'");
        String _sourceFolder_5 = this.sourceFolder(Outlet.MAIN_JAVA);
        _builder.append(_sourceFolder_5, "\t\t\t");
        _builder.append("\', \'");
        String _sourceFolder_6 = this.sourceFolder(Outlet.MAIN_SRC_GEN);
        _builder.append(_sourceFolder_6, "\t\t\t");
        _builder.append("\']");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("resources.srcDirs = [\'");
        String _sourceFolder_7 = this.sourceFolder(Outlet.MAIN_RESOURCES);
        _builder.append(_sourceFolder_7, "\t\t\t");
        _builder.append("\', \'");
        String _sourceFolder_8 = this.sourceFolder(Outlet.MAIN_SRC_GEN);
        _builder.append(_sourceFolder_8, "\t\t\t");
        _builder.append("\']");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("xtendOutputDir = \'");
        String _sourceFolder_9 = this.sourceFolder(Outlet.MAIN_XTEND_GEN);
        _builder.append(_sourceFolder_9, "\t\t\t");
        _builder.append("\'");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("test {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("java.srcDirs = []");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("resources.srcDirs = []");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("sourceSets {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("main {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("java.srcDirs = [\'");
        String _sourceFolder_10 = this.sourceFolder(Outlet.MAIN_JAVA);
        _builder.append(_sourceFolder_10, "\t\t");
        _builder.append("\', \'");
        String _sourceFolder_11 = this.sourceFolder(Outlet.MAIN_SRC_GEN);
        _builder.append(_sourceFolder_11, "\t\t");
        _builder.append("\']");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("resources.srcDirs = [\'");
        String _sourceFolder_12 = this.sourceFolder(Outlet.MAIN_RESOURCES);
        _builder.append(_sourceFolder_12, "\t\t");
        _builder.append("\', \'");
        String _sourceFolder_13 = this.sourceFolder(Outlet.MAIN_SRC_GEN);
        _builder.append(_sourceFolder_13, "\t\t");
        _builder.append("\']");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("xtendOutputDir = \'");
        String _sourceFolder_14 = this.sourceFolder(Outlet.MAIN_XTEND_GEN);
        _builder.append(_sourceFolder_14, "\t\t");
        _builder.append("\'");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("test {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("java.srcDirs = [\'");
        String _sourceFolder_15 = this.sourceFolder(Outlet.TEST_JAVA);
        _builder.append(_sourceFolder_15, "\t\t");
        _builder.append("\', \'");
        String _sourceFolder_16 = this.sourceFolder(Outlet.TEST_SRC_GEN);
        _builder.append(_sourceFolder_16, "\t\t");
        _builder.append("\']");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("resources.srcDirs = [\'");
        String _sourceFolder_17 = this.sourceFolder(Outlet.TEST_RESOURCES);
        _builder.append(_sourceFolder_17, "\t\t");
        _builder.append("\', \'");
        String _sourceFolder_18 = this.sourceFolder(Outlet.TEST_SRC_GEN);
        _builder.append(_sourceFolder_18, "\t\t");
        _builder.append("\']");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("xtendOutputDir = \'");
        String _sourceFolder_19 = this.sourceFolder(Outlet.TEST_XTEND_GEN);
        _builder.append(_sourceFolder_19, "\t\t");
        _builder.append("\'");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("plugins.withId(\'war\') {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("webAppDirName = \"");
    String _sourceFolder_20 = this.sourceFolder(Outlet.WEBAPP);
    _builder.append(_sourceFolder_20, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("plugins.withId(\'org.xtext.idea-plugin\') {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("assembleSandbox.metaInf.from(\'");
    String _sourceFolder_21 = this.sourceFolder(Outlet.META_INF);
    _builder.append(_sourceFolder_21, "\t");
    _builder.append("\')");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public PomFile pom() {
    PomFile _pom = super.pom();
    final Procedure1<PomFile> _function = new Procedure1<PomFile>() {
      @Override
      public void apply(final PomFile it) {
        it.setPackaging("pom");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<properties>");
        _builder.newLine();
        {
          WizardConfiguration _config = ParentProjectDescriptor.this.getConfig();
          boolean _needsTychoBuild = _config.needsTychoBuild();
          if (_needsTychoBuild) {
            _builder.append("\t");
            _builder.append("<tycho-version>0.23.1</tycho-version>");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("<xtextVersion>");
        WizardConfiguration _config_1 = ParentProjectDescriptor.this.getConfig();
        XtextVersion _xtextVersion = _config_1.getXtextVersion();
        _builder.append(_xtextVersion, "\t");
        _builder.append("</xtextVersion>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("<project.build.sourceEncoding>");
        WizardConfiguration _config_2 = ParentProjectDescriptor.this.getConfig();
        Charset _encoding = _config_2.getEncoding();
        _builder.append(_encoding, "\t");
        _builder.append("</project.build.sourceEncoding>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("<maven.compiler.source>1.6</maven.compiler.source>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<maven.compiler.target>1.6</maven.compiler.target>");
        _builder.newLine();
        _builder.append("</properties>");
        _builder.newLine();
        _builder.append("<modules>");
        _builder.newLine();
        {
          WizardConfiguration _config_3 = ParentProjectDescriptor.this.getConfig();
          Set<ProjectDescriptor> _enabledProjects = _config_3.getEnabledProjects();
          final Function1<ProjectDescriptor, Boolean> _function = new Function1<ProjectDescriptor, Boolean>() {
            @Override
            public Boolean apply(final ProjectDescriptor it) {
              boolean _and = false;
              boolean _notEquals = (!Objects.equal(it, ParentProjectDescriptor.this));
              if (!_notEquals) {
                _and = false;
              } else {
                boolean _isPartOfMavenBuild = it.isPartOfMavenBuild();
                _and = _isPartOfMavenBuild;
              }
              return Boolean.valueOf(_and);
            }
          };
          Iterable<ProjectDescriptor> _filter = IterableExtensions.<ProjectDescriptor>filter(_enabledProjects, _function);
          for(final ProjectDescriptor p : _filter) {
            _builder.append("\t");
            _builder.append("<module>");
            {
              WizardConfiguration _config_4 = ParentProjectDescriptor.this.getConfig();
              ProjectLayout _projectLayout = _config_4.getProjectLayout();
              boolean _equals = Objects.equal(_projectLayout, ProjectLayout.FLAT);
              if (_equals) {
                _builder.append("../");
              }
            }
            String _name = p.getName();
            _builder.append(_name, "\t");
            _builder.append("</module>");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("</modules>");
        _builder.newLine();
        _builder.append("<build>");
        _builder.newLine();
        {
          WizardConfiguration _config_5 = ParentProjectDescriptor.this.getConfig();
          boolean _needsTychoBuild_1 = _config_5.needsTychoBuild();
          if (_needsTychoBuild_1) {
            _builder.append("\t");
            _builder.append("<plugins>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<plugin>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("<groupId>org.eclipse.tycho</groupId>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("<artifactId>tycho-maven-plugin</artifactId>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("<version>${tycho-version}</version>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("<extensions>true</extensions>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("</plugin>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("<plugin>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("<groupId>org.eclipse.tycho</groupId>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("<artifactId>target-platform-configuration</artifactId>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("<version>${tycho-version}</version>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("<configuration>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("<target>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("<artifact>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<groupId>");
            WizardConfiguration _config_6 = ParentProjectDescriptor.this.getConfig();
            String _baseName = _config_6.getBaseName();
            _builder.append(_baseName, "\t\t\t\t\t\t");
            _builder.append("</groupId>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<artifactId>");
            WizardConfiguration _config_7 = ParentProjectDescriptor.this.getConfig();
            TargetPlatformProject _targetPlatformProject = _config_7.getTargetPlatformProject();
            String _name_1 = _targetPlatformProject.getName();
            _builder.append(_name_1, "\t\t\t\t\t\t");
            _builder.append("</artifactId>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<version>${project.version}</version>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("</artifact>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("</target>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("<environments>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("<environment>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<os>macosx</os>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<ws>cocoa</ws>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<arch>x86_64</arch>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("</environment>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("<environment>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<os>win32</os>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<ws>win32</ws>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<arch>x86_64</arch>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("</environment>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("<environment>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<os>linux</os>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<ws>gtk</ws>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t\t");
            _builder.append("<arch>x86_64</arch>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("</environment>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("</environments>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("</configuration>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("</plugin>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("</plugins>");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("<pluginManagement>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<plugins>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<plugin>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<groupId>org.eclipse.xtend</groupId>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<artifactId>xtend-maven-plugin</artifactId>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<version>${xtextVersion}</version>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<executions>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("<execution>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("<goals>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t");
        _builder.append("<goal>compile</goal>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t");
        _builder.append("<goal>testCompile</goal>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("</goals>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("</execution>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("</executions>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<configuration>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("<outputDirectory>${basedir}/");
        String _sourceFolder = ParentProjectDescriptor.this.sourceFolder(Outlet.MAIN_XTEND_GEN);
        _builder.append(_sourceFolder, "\t\t\t\t\t");
        _builder.append("</outputDirectory>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t\t");
        _builder.append("<testOutputDirectory>${basedir}/");
        String _sourceFolder_1 = ParentProjectDescriptor.this.sourceFolder(Outlet.TEST_XTEND_GEN);
        _builder.append(_sourceFolder_1, "\t\t\t\t\t");
        _builder.append("</testOutputDirectory>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("</configuration>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("</plugin>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<plugin>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<groupId>org.apache.maven.plugins</groupId>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<artifactId>maven-clean-plugin</artifactId>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<version>2.5</version>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<configuration>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("<filesets>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("<fileset>");
        _builder.newLine();
        {
          Set<Outlet> _set = IterableExtensions.<Outlet>toSet(Collections.<Outlet>unmodifiableList(CollectionLiterals.<Outlet>newArrayList(Outlet.MAIN_XTEND_GEN, Outlet.TEST_XTEND_GEN)));
          final Function1<Outlet, String> _function_1 = new Function1<Outlet, String>() {
            @Override
            public String apply(final Outlet it) {
              return ParentProjectDescriptor.this.sourceFolder(it);
            }
          };
          Iterable<String> _map = IterableExtensions.<Outlet, String>map(_set, _function_1);
          for(final String dir : _map) {
            _builder.append("\t\t\t\t\t\t\t");
            _builder.append("<directory>${basedir}/");
            _builder.append(dir, "\t\t\t\t\t\t\t");
            _builder.append("</directory>");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t\t\t\t\t");
        _builder.append("</fileset>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("</filesets>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("</configuration>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("</plugin>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</plugins>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("</pluginManagement>");
        _builder.newLine();
        _builder.append("</build>");
        _builder.newLine();
        {
          WizardConfiguration _config_8 = ParentProjectDescriptor.this.getConfig();
          XtextVersion _xtextVersion_1 = _config_8.getXtextVersion();
          boolean _isSnapshot = _xtextVersion_1.isSnapshot();
          if (_isSnapshot) {
            _builder.append("<repositories>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("<repository>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("<id>sonatype-snapshots</id>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("<url>https://oss.sonatype.org/content/repositories/snapshots</url>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("<releases><enabled>false</enabled></releases>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("<snapshots><enabled>true</enabled></snapshots>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("</repository>");
            _builder.newLine();
            _builder.append("</repositories>");
            _builder.newLine();
            _builder.append("<pluginRepositories>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("<pluginRepository>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("<id>sonatype-snapshots</id>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("<url>https://oss.sonatype.org/content/repositories/snapshots</url>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("<releases><enabled>false</enabled></releases>");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("<snapshots><enabled>true</enabled></snapshots>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("</pluginRepository>");
            _builder.newLine();
            _builder.append("</pluginRepositories>");
            _builder.newLine();
          }
        }
        it.setBuildSection(_builder.toString());
      }
    };
    return ObjectExtensions.<PomFile>operator_doubleArrow(_pom, _function);
  }
  
  @Override
  public Set<String> getSourceFolders() {
    return Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet());
  }
  
  public ParentProjectDescriptor(final WizardConfiguration config) {
    super(config);
  }
}

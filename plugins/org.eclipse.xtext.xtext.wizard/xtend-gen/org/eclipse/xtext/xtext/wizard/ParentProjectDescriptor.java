package org.eclipse.xtext.xtext.wizard;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.generator.XtextVersion;
import org.eclipse.xtext.xtext.wizard.GeneratedFile;
import org.eclipse.xtext.xtext.wizard.GradleBuildFile;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.PlainTextFile;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.SourceLayout;
import org.eclipse.xtext.xtext.wizard.TargetPlatformProject;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class ParentProjectDescriptor extends ProjectDescriptor {
  @Override
  public String getNameQualifier() {
    return ".parent";
  }
  
  @Override
  public boolean isEnabled() {
    boolean _or = false;
    WizardConfiguration _config = this.getConfig();
    boolean _needsGradleBuild = _config.needsGradleBuild();
    if (_needsGradleBuild) {
      _or = true;
    } else {
      WizardConfiguration _config_1 = this.getConfig();
      boolean _needsMavenBuild = _config_1.needsMavenBuild();
      _or = _needsMavenBuild;
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
  public Iterable<? extends GeneratedFile> getFiles() {
    final ArrayList<GeneratedFile> files = CollectionLiterals.<GeneratedFile>newArrayList();
    Iterable<? extends GeneratedFile> _files = super.getFiles();
    Iterables.<GeneratedFile>addAll(files, _files);
    WizardConfiguration _config = this.getConfig();
    boolean _needsGradleBuild = _config.needsGradleBuild();
    if (_needsGradleBuild) {
      CharSequence _settingsGradle = this.settingsGradle();
      PlainTextFile _file = this.file(Outlet.ROOT, "settings.gradle", _settingsGradle);
      files.add(_file);
      WizardConfiguration _config_1 = this.getConfig();
      SourceLayout _sourceLayout = _config_1.getSourceLayout();
      boolean _equals = Objects.equal(_sourceLayout, SourceLayout.PLAIN);
      if (_equals) {
        CharSequence _plainLayout = this.plainLayout();
        PlainTextFile _file_1 = this.file(Outlet.ROOT, "gradle/plain-layout.gradle", _plainLayout);
        files.add(_file_1);
      }
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
        _builder.append("classpath \'org.xtend:xtend-gradle-plugin:0.4.8\'");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("subprojects {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("ext.xtextVersion = \"");
        WizardConfiguration _config = ParentProjectDescriptor.this.getConfig();
        XtextVersion _xtextVersion = _config.getXtextVersion();
        _builder.append(_xtextVersion, "\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("repositories {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("jcenter()");
        _builder.newLine();
        {
          WizardConfiguration _config_1 = ParentProjectDescriptor.this.getConfig();
          XtextVersion _xtextVersion_1 = _config_1.getXtextVersion();
          boolean _isSnapshot = _xtextVersion_1.isSnapshot();
          if (_isSnapshot) {
            _builder.append("\t\t");
            _builder.append("maven {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("url \"https://oss.sonatype.org/content/repositories/snapshots/\"");
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
        {
          WizardConfiguration _config_2 = ParentProjectDescriptor.this.getConfig();
          SourceLayout _sourceLayout = _config_2.getSourceLayout();
          boolean _equals = Objects.equal(_sourceLayout, SourceLayout.PLAIN);
          if (_equals) {
            _builder.append("\t");
            _builder.append("apply from: \"${rootDir}/gradle/plain-layout.gradle\"");
            _builder.newLine();
          }
        }
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
  
  public CharSequence plainLayout() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (name.endsWith(\".tests\")) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sourceSets.test.java.srcDirs = [\'src\', \'src-gen\']");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sourceSets.test.resources.srcDirs = [\'src\', \'src-gen\']");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sourceSets.test.xtendOutputDir = \'xtend-gen\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sourceSets.main.java.srcDirs = []");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sourceSets.main.resources.srcDirs = []");
    _builder.newLine();
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sourceSets.main.java.srcDirs = [\'src\', \'src-gen\']");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sourceSets.main.resources.srcDirs = [\'src\', \'src-gen\']");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sourceSets.main.xtendOutputDir = \'xtend-gen\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sourceSets.test.java.srcDirs = []");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sourceSets.test.resources.srcDirs = []");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("plugins.withId(\'war\') {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("webAppDirName = \"WebRoot\"");
    _builder.newLine();
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
        _builder.append("<phase>generate-sources</phase>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("<goals>");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t\t");
        _builder.append("<goal>compile</goal>");
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
        _builder.append("\t\t\t\t\t\t\t");
        _builder.append("<directory>${basedir}/");
        String _sourceFolder_1 = ParentProjectDescriptor.this.sourceFolder(Outlet.MAIN_XTEND_GEN);
        _builder.append(_sourceFolder_1, "\t\t\t\t\t\t\t");
        _builder.append("</directory>");
        _builder.newLineIfNotEmpty();
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

package org.eclipse.xtext.xtext.wizard;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.ExternalDependency;
import org.eclipse.xtext.xtext.wizard.GradleBuildFile;
import org.eclipse.xtext.xtext.wizard.IdeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.PomFile;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.Scope;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class WebProjectDescriptor extends ProjectDescriptor {
  private final static String REQUIREJS_VERSION = "2.1.17";
  
  private final static String JQUERY_VERSION = "2.1.4";
  
  private final static String JETTY_VERSION = "9.2.11.v20150529";
  
  private final static String SLF4J_VERSION = "1.7.12";
  
  private final static String ACE_VERSION = "1.1.9";
  
  @Override
  public Set<? extends ProjectDescriptor> getUpstreamProjects() {
    WizardConfiguration _config = this.getConfig();
    RuntimeProjectDescriptor _runtimeProject = _config.getRuntimeProject();
    WizardConfiguration _config_1 = this.getConfig();
    IdeProjectDescriptor _ideProject = _config_1.getIdeProject();
    return Collections.<ProjectDescriptor>unmodifiableSet(CollectionLiterals.<ProjectDescriptor>newHashSet(_runtimeProject, _ideProject));
  }
  
  @Override
  public String getNameQualifier() {
    return ".web";
  }
  
  @Override
  public boolean isEclipsePluginProject() {
    return false;
  }
  
  @Override
  public boolean isPartOfGradleBuild() {
    WizardConfiguration _config = this.getConfig();
    BuildSystem _preferredBuildSystem = _config.getPreferredBuildSystem();
    return Objects.equal(_preferredBuildSystem, BuildSystem.GRADLE);
  }
  
  @Override
  public boolean isPartOfMavenBuild() {
    WizardConfiguration _config = this.getConfig();
    BuildSystem _preferredBuildSystem = _config.getPreferredBuildSystem();
    return Objects.equal(_preferredBuildSystem, BuildSystem.MAVEN);
  }
  
  @Override
  public Set<ExternalDependency> getExternalDependencies() {
    final HashSet<ExternalDependency> deps = CollectionLiterals.<ExternalDependency>newHashSet();
    Set<ExternalDependency> _externalDependencies = super.getExternalDependencies();
    Iterables.<ExternalDependency>addAll(deps, _externalDependencies);
    ExternalDependency _createXtextDependency = ExternalDependency.createXtextDependency("org.eclipse.xtext.web.servlet");
    deps.add(_createXtextDependency);
    ExternalDependency _createMavenDependency = ExternalDependency.createMavenDependency("org.eclipse.xtend:org.eclipse.xtend.lib:${xtextVersion}");
    deps.add(_createMavenDependency);
    ExternalDependency _createMavenDependency_1 = ExternalDependency.createMavenDependency(("org.webjars:requirejs:" + WebProjectDescriptor.REQUIREJS_VERSION));
    deps.add(_createMavenDependency_1);
    ExternalDependency _createMavenDependency_2 = ExternalDependency.createMavenDependency(("org.webjars:jquery:" + WebProjectDescriptor.JQUERY_VERSION));
    deps.add(_createMavenDependency_2);
    ExternalDependency _createMavenDependency_3 = ExternalDependency.createMavenDependency(("org.webjars:ace:" + WebProjectDescriptor.ACE_VERSION));
    deps.add(_createMavenDependency_3);
    ExternalDependency _createMavenDependency_4 = ExternalDependency.createMavenDependency(("org.eclipse.jetty:jetty-annotations:" + WebProjectDescriptor.JETTY_VERSION));
    final Procedure1<ExternalDependency> _function = new Procedure1<ExternalDependency>() {
      @Override
      public void apply(final ExternalDependency it) {
        ExternalDependency.MavenCoordinates _maven = it.getMaven();
        _maven.setScope(Scope.PROVIDED);
      }
    };
    ExternalDependency _doubleArrow = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_createMavenDependency_4, _function);
    deps.add(_doubleArrow);
    ExternalDependency _createMavenDependency_5 = ExternalDependency.createMavenDependency(("org.slf4j:slf4j-api:" + WebProjectDescriptor.SLF4J_VERSION));
    final Procedure1<ExternalDependency> _function_1 = new Procedure1<ExternalDependency>() {
      @Override
      public void apply(final ExternalDependency it) {
        ExternalDependency.MavenCoordinates _maven = it.getMaven();
        _maven.setScope(Scope.PROVIDED);
      }
    };
    ExternalDependency _doubleArrow_1 = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_createMavenDependency_5, _function_1);
    deps.add(_doubleArrow_1);
    ExternalDependency _createMavenDependency_6 = ExternalDependency.createMavenDependency(("org.slf4j:slf4j-log4j12:" + WebProjectDescriptor.SLF4J_VERSION));
    final Procedure1<ExternalDependency> _function_2 = new Procedure1<ExternalDependency>() {
      @Override
      public void apply(final ExternalDependency it) {
        ExternalDependency.MavenCoordinates _maven = it.getMaven();
        _maven.setScope(Scope.PROVIDED);
      }
    };
    ExternalDependency _doubleArrow_2 = ObjectExtensions.<ExternalDependency>operator_doubleArrow(_createMavenDependency_6, _function_2);
    deps.add(_doubleArrow_2);
    return deps;
  }
  
  @Override
  public GradleBuildFile buildGradle() {
    GradleBuildFile _buildGradle = super.buildGradle();
    final Procedure1<GradleBuildFile> _function = new Procedure1<GradleBuildFile>() {
      @Override
      public void apply(final GradleBuildFile it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("plugins {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("id \'war\'");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it.setPluginsSection(_builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("task jettyRun(type:JavaExec) {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("dependsOn(sourceSets.main.runtimeClasspath)");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("classpath = sourceSets.main.runtimeClasspath.filter{it.exists()}");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("main = \"");
        WizardConfiguration _config = WebProjectDescriptor.this.getConfig();
        LanguageDescriptor _language = _config.getLanguage();
        String _basePackage = _language.getBasePackage();
        _builder_1.append(_basePackage, "\t");
        _builder_1.append(".web.ServerLauncher\"");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t");
        _builder_1.append("standardInput = System.in");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        it.setAdditionalContent(_builder_1.toString());
      }
    };
    return ObjectExtensions.<GradleBuildFile>operator_doubleArrow(_buildGradle, _function);
  }
  
  @Override
  public PomFile pom() {
    PomFile _pom = super.pom();
    final Procedure1<PomFile> _function = new Procedure1<PomFile>() {
      @Override
      public void apply(final PomFile it) {
        it.setPackaging("war");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<build>");
        _builder.newLine();
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
        _builder.append("\t\t");
        _builder.append("<plugin>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<artifactId>maven-war-plugin</artifactId>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<version>2.6</version>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<configuration>");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("<warSourceDirectory>");
        String _sourceFolder = WebProjectDescriptor.this.sourceFolder(Outlet.WEBAPP);
        _builder.append(_sourceFolder, "\t\t\t\t");
        _builder.append("</warSourceDirectory>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("</configuration>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("</plugin>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("</plugins>");
        _builder.newLine();
        _builder.append("</build>");
        _builder.newLine();
        it.setBuildSection(_builder.toString());
      }
    };
    return ObjectExtensions.<PomFile>operator_doubleArrow(_pom, _function);
  }
  
  public WebProjectDescriptor(final WizardConfiguration config) {
    super(config);
  }
}

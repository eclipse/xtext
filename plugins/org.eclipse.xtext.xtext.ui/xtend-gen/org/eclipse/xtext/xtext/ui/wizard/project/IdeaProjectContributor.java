package org.eclipse.xtext.xtext.ui.wizard.project;

import org.eclipse.core.resources.IProject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.util.IProjectFactoryContributor;
import org.eclipse.xtext.xtext.ui.wizard.project.DefaultProjectFactoryContributor;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectInfo;

/**
 * Contributes Idea parts to a new dsl test project
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.9
 */
@SuppressWarnings("all")
public class IdeaProjectContributor extends DefaultProjectFactoryContributor {
  private XtextProjectInfo projectInfo;
  
  public IdeaProjectContributor(final XtextProjectInfo projectInfo) {
    this.projectInfo = projectInfo;
  }
  
  @Override
  public void contributeFiles(final IProject project, final IProjectFactoryContributor.IFileCreator fc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("buildscript {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("repositories { jcenter() }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("dependencies { classpath \'org.xtext:xtext-idea-gradle-plugin:+\'}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("apply plugin: \'org.xtext.idea-plugin\'");
    _builder.newLine();
    _builder.append("apply plugin: \'eclipse\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("dependencies {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("compile project(\':");
    String _projectName = this.projectInfo.getProjectName();
    _builder.append(_projectName, "\t");
    _builder.append("\')");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("compile project(\':");
    String _ideProjectName = this.projectInfo.getIdeProjectName();
    _builder.append(_ideProjectName, "\t");
    _builder.append("\')");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("ideaDevelopment {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ideaVersion = \'141.178.9\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("pluginRepositories {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("url \'https://hudson.eclipse.org/xtext/job/xtext-intellij/lastSuccessfulBuild/artifact/git-repo/intellij/build/ideaRepository/updatePlugins.xml\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("pluginDependencies {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("id \'org.eclipse.xtext.idea\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("allprojects {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("repositories { ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("jcenter()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("maven {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("url \"https://oss.sonatype.org/content/repositories/snapshots/\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("apply plugin: \'java\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sourceSets.main.java.srcDirs = [\'src\', \'src-gen\', \'xtend-gen\']");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sourceSets.main.resources.srcDirs = [\'src\', \'src-gen\']");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("configure(project(\':");
    String _projectName_1 = this.projectInfo.getProjectName();
    _builder.append(_projectName_1, "");
    _builder.append("\')) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("dependencies {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("compile \'org.eclipse.xtext:org.eclipse.xtext.common.types:+\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("configure(project(\'");
    String _ideProjectName_1 = this.projectInfo.getIdeProjectName();
    _builder.append(_ideProjectName_1, "");
    _builder.append("\')) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("dependencies { ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("compile project(\':");
    String _projectName_2 = this.projectInfo.getProjectName();
    _builder.append(_projectName_2, "\t\t");
    _builder.append("\')");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("compile \'org.eclipse.xtext:org.eclipse.xtext.ide:+\' ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.writeToFile(_builder, fc, "build.gradle");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("includeFlat \'");
    String _projectName_3 = this.projectInfo.getProjectName();
    _builder_1.append(_projectName_3, "");
    _builder_1.append("\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("includeFlat \'");
    String _ideProjectName_2 = this.projectInfo.getIdeProjectName();
    _builder_1.append(_ideProjectName_2, "");
    _builder_1.append("\'");
    _builder_1.newLineIfNotEmpty();
    this.writeToFile(_builder_1, fc, "settings.gradle");
  }
}

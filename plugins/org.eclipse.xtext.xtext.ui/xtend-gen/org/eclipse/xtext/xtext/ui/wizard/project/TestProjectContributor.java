package org.eclipse.xtext.xtext.ui.wizard.project;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.util.IProjectFactoryContributor;
import org.eclipse.xtext.xtext.ui.wizard.project.DefaultProjectFactoryContributor;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectInfo;

/**
 * Contributes build.properties file and the launch configuration file to a new dsl test project
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
@SuppressWarnings("all")
public class TestProjectContributor extends DefaultProjectFactoryContributor {
  private XtextProjectInfo projectInfo;
  
  public TestProjectContributor(final XtextProjectInfo projectInfo) {
    this.projectInfo = projectInfo;
  }
  
  public void contributeFiles(final IProject project, final IProjectFactoryContributor.IFileCreator fileWriter) {
    this.contributeBuildProperties(fileWriter);
    this.contributeLaunchConfig(fileWriter);
  }
  
  private IFile contributeBuildProperties(final IProjectFactoryContributor.IFileCreator fileWriter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("source.. = src/,\\");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("src-gen/,\\");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("xtend-gen/");
    _builder.newLine();
    _builder.append("bin.includes = META-INF/,\\");
    _builder.newLine();
    _builder.append("       ");
    _builder.append(".");
    _builder.newLine();
    return this.writeToFile(_builder, fileWriter, "build.properties");
  }
  
  private IFile contributeLaunchConfig(final IProjectFactoryContributor.IFileCreator fileWriter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<launchConfiguration type=\"org.eclipse.jdt.junit.launchconfig\">");
    _builder.newLine();
    _builder.append("<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_PATHS\">");
    _builder.newLine();
    _builder.append("<listEntry value=\"/");
    String _testProjectName = this.projectInfo.getTestProjectName();
    _builder.append(_testProjectName, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</listAttribute>");
    _builder.newLine();
    _builder.append("<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_TYPES\">");
    _builder.newLine();
    _builder.append("<listEntry value=\"4\"/>");
    _builder.newLine();
    _builder.append("</listAttribute>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.junit.CONTAINER\" value=\"=");
    String _testProjectName_1 = this.projectInfo.getTestProjectName();
    _builder.append(_testProjectName_1, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("<booleanAttribute key=\"org.eclipse.jdt.junit.KEEPRUNNING_ATTR\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.junit.TEST_KIND\" value=\"org.eclipse.jdt.junit.loader.junit4\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.PROJECT_ATTR\" value=\"");
    String _testProjectName_2 = this.projectInfo.getTestProjectName();
    _builder.append(_testProjectName_2, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</launchConfiguration>");
    _builder.newLine();
    String _testProjectName_3 = this.projectInfo.getTestProjectName();
    String _plus = (_testProjectName_3 + ".launch");
    return this.writeToFile(_builder, fileWriter, _plus);
  }
}

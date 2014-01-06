package org.eclipse.xtext.xtext.ui.wizard.releng.templates;

import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.util.IProjectFactoryContributor;
import org.eclipse.xtext.xtext.ui.wizard.releng.P2DirectorLaunch;
import org.eclipse.xtext.xtext.ui.wizard.releng.RelengProjectInfo;

/**
 * Creates some buckminster files. cquery, spec, rmap etc.
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
@SuppressWarnings("all")
public class BuckminsterFilesCreator {
  private static String CSPEC_FILE_NAME = "buckminster.cspec";
  
  private static String PROJECT = "project";
  
  private static String PROJECT_CQUERY_NAME = (BuckminsterFilesCreator.PROJECT + ".cquery");
  
  private static String PLATFORM_CQUERY_NAME = (BuckminsterFilesCreator.PROJECT + "s-platform.cquery");
  
  private static String PROJECT_RMAP_NAME = (BuckminsterFilesCreator.PROJECT + ".rmap");
  
  private static String PLATFORM_RMAP_NAME = (BuckminsterFilesCreator.PROJECT + "s-platform.rmap");
  
  private static String COMMANDS_FILE_NAME = "commands.txt";
  
  private static String INSTALL_BUCKY_LAUNCH = ".InstallHeadlessBuckminster.launch";
  
  private IProjectFactoryContributor.IFileCreator fileCreator;
  
  public BuckminsterFilesCreator(final IProjectFactoryContributor.IFileCreator fileCreator) {
    this.fileCreator = fileCreator;
  }
  
  public IFile createBuckminsterFiles(final RelengProjectInfo projectInfo) {
    IFile _xblockexpression = null;
    {
      this.createCspec(projectInfo);
      this.createCommands(projectInfo);
      this.createProjectCquery(projectInfo);
      this.createPlatformCquery(projectInfo);
      this.createPlatformRmap(projectInfo);
      _xblockexpression = (this.createProjectRmap(projectInfo));
    }
    return _xblockexpression;
  }
  
  private IFile writeToFile(final CharSequence chrSeq, final String fileName) {
    return this.fileCreator.writeToFile(chrSeq, fileName);
  }
  
  /**
   * Creates commands text file that it used to instruct headless buckminster, what to do.<br>
   */
  private IFile createCommands(final RelengProjectInfo projectInfo) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("setpref targetPlatformPath=\"${target.platform}\"");
    _builder.newLine();
    _builder.append("resolve \"${projects.location}/");
    String _projectName = projectInfo.getProjectName();
    _builder.append(_projectName, "");
    _builder.append("/");
    _builder.append(BuckminsterFilesCreator.PLATFORM_CQUERY_NAME, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("resolve \"${projects.location}/");
    String _projectName_1 = projectInfo.getProjectName();
    _builder.append(_projectName_1, "");
    _builder.append("/");
    _builder.append(BuckminsterFilesCreator.PROJECT_CQUERY_NAME, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    {
      List<String> _preCompileLaunchers = projectInfo.getPreCompileLaunchers();
      for(final String preCompileLauncher : _preCompileLaunchers) {
        _builder.append("launch -l \"");
        _builder.append(preCompileLauncher, "");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("build");
    _builder.newLine();
    {
      List<IFile> _testLaunchers = projectInfo.getTestLaunchers();
      for(final IFile testLauncher : _testLaunchers) {
        _builder.append("junit -l \"");
        IProject _project = testLauncher.getProject();
        String _name = _project.getName();
        Path _path = new Path(_name);
        IPath _projectRelativePath = testLauncher.getProjectRelativePath();
        IPath _append = _path.append(_projectRelativePath);
        _builder.append(_append, "");
        _builder.append("\"  --flatXML --output \"${buckminster.output.root}/test.results/");
        String _name_1 = testLauncher.getName();
        _builder.append(_name_1, "");
        _builder.append(".xml\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("perform \"");
    String _siteFeatureProjectName = projectInfo.getSiteFeatureProjectName();
    _builder.append(_siteFeatureProjectName, "");
    _builder.append("#site.p2\"");
    _builder.newLineIfNotEmpty();
    return this.writeToFile(_builder, BuckminsterFilesCreator.COMMANDS_FILE_NAME);
  }
  
  /**
   * Creates buckminster scpec.<br>
   * @param projectInfo Project configuration to use
   */
  private IFile createCspec(final RelengProjectInfo projectInfo) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<cs:cspec xmlns:cs=\"http://www.eclipse.org/buckminster/CSpec-1.0\" name=\"");
    String _projectName = projectInfo.getProjectName();
    _builder.append(_projectName, "");
    _builder.append("\" componentType=\"buckminster\" version=\"1.0.0\">");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("<cs:dependencies>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<cs:dependency name=\"org.eclipse.platform\" componentType=\"eclipse.feature\"/>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<cs:dependency name=\"org.eclipse.xtext.sdk\" componentType=\"eclipse.feature\"/>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</cs:dependencies>");
    _builder.newLine();
    _builder.append("</cs:cspec>");
    _builder.newLine();
    return this.writeToFile(_builder, BuckminsterFilesCreator.CSPEC_FILE_NAME);
  }
  
  /**
   * Creates project cquery.<br>
   * @param projectInfo Project configuration to use
   */
  private IFile createProjectCquery(final RelengProjectInfo projectInfo) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<cq:componentQuery xmlns:cq=\"http://www.eclipse.org/buckminster/CQuery-1.0\" resourceMap=\"");
    _builder.append(BuckminsterFilesCreator.PROJECT_RMAP_NAME, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("<cq:rootRequest name=\"");
    String _siteFeatureProjectName = projectInfo.getSiteFeatureProjectName();
    _builder.append(_siteFeatureProjectName, "    ");
    _builder.append("\" componentType=\"eclipse.feature\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</cq:componentQuery>");
    _builder.newLine();
    return this.writeToFile(_builder, BuckminsterFilesCreator.PROJECT_CQUERY_NAME);
  }
  
  /**
   * Creates platform cquery.<br>
   * @param projectInfo Project configuration to use
   */
  private IFile createPlatformCquery(final RelengProjectInfo projectInfo) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<cq:componentQuery xmlns:cq=\"http://www.eclipse.org/buckminster/CQuery-1.0\" resourceMap=\"");
    _builder.append(BuckminsterFilesCreator.PLATFORM_RMAP_NAME, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("<cq:rootRequest name=\"");
    String _projectName = projectInfo.getProjectName();
    _builder.append(_projectName, "    ");
    _builder.append("\" componentType=\"buckminster\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("<cq:property key=\"target.arch\" value=\"*\"/>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<cq:property key=\"target.os\" value=\"*\"/>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<cq:property key=\"target.ws\" value=\"*\"/>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<cq:advisorNode namePattern=\"^.*\\.source$\" skipComponent=\"true\"/>");
    _builder.newLine();
    _builder.append("</cq:componentQuery>");
    _builder.newLine();
    _builder.newLine();
    return this.writeToFile(_builder, BuckminsterFilesCreator.PLATFORM_CQUERY_NAME);
  }
  
  /**
   * Creates platform rmap.<br>
   * @param projectInfo Project configuration to use
   */
  private IFile createPlatformRmap(final RelengProjectInfo projectInfo) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<rm:rmap xmlns:bc=\"http://www.eclipse.org/buckminster/Common-1.0\" xmlns:rm=\"http://www.eclipse.org/buckminster/RMap-1.0\">");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<rm:property key=\"eclipse.download\" value=\"http://download.eclipse.org\"/>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<rm:property key=\"xtext.p2.repository\" value=\"${eclipse.download}/modeling/tmf/xtext/updates/composite/releases/\"/>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<rm:property key=\"eclipse.target.platform\" value=\"${eclipse.download}/releases/kepler\"/>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<rm:redirect pattern=\"");
    String _projectName = projectInfo.getProjectName();
    _builder.append(_projectName, "  ");
    _builder.append("\" href=\"");
    _builder.append(BuckminsterFilesCreator.PROJECT_RMAP_NAME, "  ");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("<rm:locator pattern=\"^org\\.eclipse\\.(?:xtext|xpand|xtend|xtend2|emf\\.mwe|emf\\.mwe2)(?:\\..+)?$\" searchPathRef=\"xtext\"/>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<rm:locator pattern=\"^com\\.google.*\" searchPathRef=\"xtext\"/>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<rm:locator pattern=\"^org\\.antlr.*\" searchPathRef=\"xtext\"/>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<rm:locator pattern=\"javax.inject\" searchPathRef=\"xtext\"/>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<rm:locator searchPathRef=\"eclipse\"/>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<rm:searchPath name=\"xtext\">");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<rm:provider componentTypes=\"osgi.bundle,eclipse.feature\" readerType=\"p2\" source=\"false\">");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("<rm:property key=\"buckminster.source\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("<rm:uri format=\"{0}\">");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<bc:propertyRef key=\"xtext.p2.repository\"/>");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("</rm:uri>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</rm:provider>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("</rm:searchPath>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<rm:searchPath name=\"eclipse\">");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<rm:provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"p2\" source=\"false\" mutable=\"false\">");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("<rm:property key=\"buckminster.source\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("<rm:property key=\"buckminster.mutable\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("<rm:uri format=\"{0}\">");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<bc:propertyRef key=\"eclipse.target.platform\"/>");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("</rm:uri>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</rm:provider>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("</rm:searchPath>");
    _builder.newLine();
    _builder.append("</rm:rmap>");
    _builder.newLine();
    return this.writeToFile(_builder, BuckminsterFilesCreator.PLATFORM_RMAP_NAME);
  }
  
  /**
   * Creates projects rmap.<br>
   * @param projectInfo Project configuration to use
   */
  private IFile createProjectRmap(final RelengProjectInfo projectInfo) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<rm:rmap xmlns:bc=\"http://www.eclipse.org/buckminster/Common-1.0\" xmlns:rm=\"http://www.eclipse.org/buckminster/RMap-1.0\">");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<rm:property key=\"projects.location\" value=\"${workspace.root}\"/>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<rm:locator pattern=\"^");
    String _projectNameSpace = projectInfo.getProjectNameSpace();
    String _replaceAll = _projectNameSpace.replaceAll("\\.", "\\.");
    _builder.append(_replaceAll, "  ");
    _builder.append("(?:\\..+)?$\" searchPathRef=\"project\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("<rm:searchPath name=\"project\">");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<rm:provider componentTypes=\"eclipse.feature,osgi.bundle,buckminster\" readerType=\"local\" mutable=\"false\">");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("<rm:property key=\"buckminster.mutable\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("<rm:uri format=\"{0}/{1}\">");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<bc:propertyRef key=\"projects.location\"/>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<bc:propertyRef key=\"buckminster.component\"/>");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("</rm:uri>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</rm:provider>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("</rm:searchPath>");
    _builder.newLine();
    _builder.append("</rm:rmap>");
    _builder.newLine();
    return this.writeToFile(_builder, BuckminsterFilesCreator.PROJECT_RMAP_NAME);
  }
  
  /**
   * Creates launch configuration file that installs headless buckminster<br>
   * @param projectInfo Project configuration to use
   */
  public IFile createInstallBuckminsterLaunch(final RelengProjectInfo projectInfo) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<launchConfiguration type=\"org.eclipse.pde.ui.RuntimeWorkbench\">");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"append.args\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"askclear\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"automaticAdd\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"automaticValidate\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"bootstrap\" value=\"\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"checked\" value=\"[NONE]\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"clearConfig\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"clearws\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"clearwslog\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"configLocation\" value=\"${workspace_loc}/.metadata/.plugins/org.eclipse.pde.core/Install headless buckminster\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"default\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"includeOptional\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"location\" value=\"");
    _builder.append(P2DirectorLaunch.LOCATION, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.PROGRAM_ARGUMENTS\" value=\"-os ${target.os} -ws ${target.ws} -arch ${target.arch} -nl ${target.nl} -consoleLog ");
    String _args = P2DirectorLaunch.args();
    _builder.append(_args, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER\" value=\"org.eclipse.pde.ui.workbenchClasspathProvider\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.VM_ARGUMENTS\" value=\"-Xms40m -Xmx512m\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"pde.version\" value=\"3.3\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"product\" value=\"");
    _builder.append(P2DirectorLaunch.PRODUCT, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("<booleanAttribute key=\"show_selected_only\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"templateConfig\" value=\"${target_home}/configuration/config.ini\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"tracing\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"useCustomFeatures\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"useDefaultConfig\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"useDefaultConfigArea\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"useProduct\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("</launchConfiguration>");
    _builder.newLine();
    return this.writeToFile(_builder, BuckminsterFilesCreator.INSTALL_BUCKY_LAUNCH);
  }
}

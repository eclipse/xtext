package org.eclipse.xtext.xtext.ui.wizard.releng.templates;

import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.util.IProjectFactoryContributor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xtext.ui.wizard.releng.RelengProjectInfo;

/**
 * Creates spex for the site feature to define build time dependencies.<br>
 * 
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
@SuppressWarnings("all")
public class SiteSpexCreator implements IProjectFactoryContributor {
  private RelengProjectInfo projectInfo;
  
  public SiteSpexCreator(final RelengProjectInfo projectInfo) {
    this.projectInfo = projectInfo;
  }
  
  public void contributeFiles(final IProject project, final IProjectFactoryContributor.IFileCreator fileCreator) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<cs:cspecExtension xmlns:com=\"http://www.eclipse.org/buckminster/Common-1.0\" xmlns:cs=\"http://www.eclipse.org/buckminster/CSpec-1.0\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<cs:dependencies>");
    _builder.newLine();
    {
      List<IFile> _testLaunchers = this.projectInfo.getTestLaunchers();
      final Function1<IFile,IProject> _function = new Function1<IFile,IProject>() {
        public IProject apply(final IFile it) {
          IProject _project = it.getProject();
          return _project;
        }
      };
      List<IProject> _map = ListExtensions.<IFile, IProject>map(_testLaunchers, _function);
      for(final IProject testProject : _map) {
        _builder.append("\t\t");
        _builder.append("<cs:dependency name=\"");
        String _name = testProject.getName();
        _builder.append(_name, "\t\t");
        _builder.append("\" componentType=\"osgi.bundle\" />");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("</cs:dependencies>");
    _builder.newLine();
    _builder.append("</cs:cspecExtension>");
    _builder.newLine();
    this.writeToFile(_builder, fileCreator, "buckminster.cspex");
  }
  
  private IFile writeToFile(final CharSequence chrSeq, final IProjectFactoryContributor.IFileCreator fCreator, final String fileName) {
    return fCreator.writeToFile(chrSeq, fileName);
  }
}

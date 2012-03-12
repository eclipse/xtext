package org.eclipse.xtext.ui.util;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.util.ProjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Creates a simple feature project.<br>
 * Created project contains .project, build.properties and feature.xml files<br>
 * Plugin entries can be added using {@link FeatureProjectFactory#addBundle(String)} method.<br>
 * 
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
@SuppressWarnings("all")
public class FeatureProjectFactory extends ProjectFactory {
  private static String MANIFEST_FILENAME = "feature.xml";
  
  private List<String> containedBundles = new Function0<List<String>>() {
    public List<String> apply() {
      ArrayList<String> _arrayList = new ArrayList<String>();
      return _arrayList;
    }
  }.apply();
  
  private String featureLabel;
  
  public void setFeatureLabel(final String label) {
    this.featureLabel = label;
  }
  
  /**
   * Adds a new plugin entry
   */
  public FeatureProjectFactory addBundle(final String bundleId) {
    this.containedBundles.add(bundleId);
    return this;
  }
  
  @Override
  protected void enhanceProject(final IProject project, final SubMonitor subMonitor, final Shell shell) throws CoreException {
    super.enhanceProject(project, subMonitor, shell);
    SubMonitor _newChild = subMonitor.newChild(1);
    this.createManifest(project, _newChild);
    SubMonitor _newChild_1 = subMonitor.newChild(1);
    this.createBuildProperties(project, _newChild_1);
  }
  
  private void createBuildProperties(final IProject project, final IProgressMonitor monitor) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("bin.includes =");
    _builder.append(FeatureProjectFactory.MANIFEST_FILENAME, "");
    _builder.newLineIfNotEmpty();
    this.writeToFile(_builder, "build.properties", project, monitor);
  }
  
  private void createManifest(final IProject project, final IProgressMonitor monitor) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<feature id=\"");
    _builder.append(this.projectName, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("label=\"");
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.featureLabel);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      _xifexpression = this.featureLabel;
    } else {
      String _plus = (this.projectName + " Feature");
      _xifexpression = _plus;
    }
    _builder.append(_xifexpression, "	");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("version=\"1.0.0.qualifier\">");
    _builder.newLine();
    {
      for(final String containedBundle : this.containedBundles) {
        _builder.append("\t");
        _builder.append("<plugin");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("id=\"");
        _builder.append(containedBundle, "			");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("download-size=\"0\"");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("install-size=\"0\"");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("version=\"0.0.0\"");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("unpack=\"false\"/>");
        _builder.newLine();
      }
    }
    _builder.append("</feature>");
    _builder.newLine();
    this.writeToFile(_builder, FeatureProjectFactory.MANIFEST_FILENAME, project, monitor);
  }
  
  private IFile writeToFile(final CharSequence chrSeq, final String fileName, final IProject project, final IProgressMonitor progrMonitor) {
    String _string = chrSeq.toString();
    return this.createFile(fileName, project, _string, progrMonitor);
  }
}

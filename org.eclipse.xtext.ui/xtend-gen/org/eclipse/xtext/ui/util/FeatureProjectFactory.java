package org.eclipse.xtext.ui.util;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.util.ProjectFactory;
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
  
  private static String CATEGORY_FILE_NAME = "category.xml";
  
  private static String BUILD_PROPS_FILE_NAME = "build.properties";
  
  private static String SOURCE_FEAT_ENDING = ".source";
  
  private static String FEAT_ENDING = ".feature";
  
  private List<String> containedBundles = new ArrayList<String>();
  
  private List<String> includedFeatures = new ArrayList<String>();
  
  private String mainCategoryName;
  
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
  
  /**
   * Adds a new included feature entry
   */
  public FeatureProjectFactory addFeature(final String featureId) {
    this.includedFeatures.add(featureId);
    return this;
  }
  
  /**
   * @param mainCategoryName If not null or empty a category.xml will be created
   */
  public FeatureProjectFactory withCategoryFile(final String mainCategoryName) {
    this.mainCategoryName = mainCategoryName;
    return this;
  }
  
  @Override
  protected void enhanceProject(final IProject project, final SubMonitor subMonitor, final Shell shell) throws CoreException {
    super.enhanceProject(project, subMonitor, shell);
    SubMonitor _newChild = subMonitor.newChild(1);
    this.createManifest(project, _newChild);
    SubMonitor _newChild_1 = subMonitor.newChild(1);
    this.createBuildProperties(project, _newChild_1);
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.mainCategoryName);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      SubMonitor _newChild_2 = subMonitor.newChild(1);
      this.createCategoryFile(project, this.mainCategoryName, _newChild_2);
    }
  }
  
  private void createBuildProperties(final IProject project, final IProgressMonitor monitor) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("bin.includes =");
    _builder.append(FeatureProjectFactory.MANIFEST_FILENAME, "");
    _builder.newLineIfNotEmpty();
    this.writeToFile(_builder, FeatureProjectFactory.BUILD_PROPS_FILE_NAME, project, monitor);
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
      _xifexpression = (this.projectName + " Feature");
    }
    _builder.append(_xifexpression, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("version=\"1.0.0.qualifier\">");
    _builder.newLine();
    {
      for(final String includedFeature : this.includedFeatures) {
        _builder.append("\t");
        _builder.append("<includes");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("id=\"");
        _builder.append(includedFeature, "\t\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("version=\"0.0.0\"/>");
        _builder.newLine();
      }
    }
    {
      for(final String containedBundle : this.containedBundles) {
        _builder.append("\t");
        _builder.append("<plugin");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("id=\"");
        _builder.append(containedBundle, "\t\t\t");
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
  
  private void createCategoryFile(final IProject project, final String categoryName, final IProgressMonitor monitor) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<site>");
    _builder.newLine();
    {
      for(final String includedFeature : this.includedFeatures) {
        _builder.append("\t");
        _builder.append("<feature id=\"");
        _builder.append(includedFeature, "\t");
        _builder.append("\" version=\"0.0.0\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<category name=\"main\"/>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("</feature>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<feature id=\"");
        String _sourceFeatureName = null;
        if (includedFeature!=null) {
          _sourceFeatureName=this.sourceFeatureName(includedFeature);
        }
        _builder.append(_sourceFeatureName, "\t");
        _builder.append("\" version=\"0.0.0\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<category name=\"main.source\"/>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("</feature>");
        _builder.newLine();
      }
    }
    _builder.append("   ");
    _builder.append("<category-def name=\"main\" label=\"");
    _builder.append(categoryName, "   ");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("   ");
    _builder.append("<category-def name=\"main.source\" label=\"Source for ");
    _builder.append(categoryName, "   ");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</site>");
    _builder.newLine();
    this.writeToFile(_builder, FeatureProjectFactory.CATEGORY_FILE_NAME, project, monitor);
  }
  
  private String sourceFeatureName(final String featureId) {
    String _xblockexpression = null;
    {
      boolean _endsWith = featureId.endsWith(FeatureProjectFactory.FEAT_ENDING);
      if (_endsWith) {
        return featureId.replaceAll((("\\" + FeatureProjectFactory.FEAT_ENDING) + "$"), (FeatureProjectFactory.SOURCE_FEAT_ENDING + FeatureProjectFactory.FEAT_ENDING));
      }
      _xblockexpression = (featureId + FeatureProjectFactory.SOURCE_FEAT_ENDING);
    }
    return _xblockexpression;
  }
}

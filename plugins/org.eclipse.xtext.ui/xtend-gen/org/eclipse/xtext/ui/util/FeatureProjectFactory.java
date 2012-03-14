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
import org.eclipse.xtext.ui.util.IProjectFactoryContributor;
import org.eclipse.xtext.ui.util.IProjectFactoryContributor.IFileCreator;
import org.eclipse.xtext.ui.util.ProjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
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
  
  private List containedBundles = new Function0<List>() {
    public List apply() {
      ArrayList<?> _arrayList = new ArrayList<Object>();
      return _arrayList;
    }
  }.apply();
  
  private List<IProjectFactoryContributor> contributors = new Function0<List<IProjectFactoryContributor>>() {
    public List<IProjectFactoryContributor> apply() {
      ArrayList<IProjectFactoryContributor> _arrayList = new ArrayList<IProjectFactoryContributor>();
      return _arrayList;
    }
  }.apply();
  
  private List includedFeatures = new Function0<List>() {
    public List apply() {
      ArrayList<?> _arrayList = new ArrayList<Object>();
      return _arrayList;
    }
  }.apply();
  
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
   * Adds a new included feature entry
   */
  public FeatureProjectFactory addContributor(final IProjectFactoryContributor Contributor) {
    this.contributors.add(Contributor);
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
    for (final IProjectFactoryContributor contributor : this.contributors) {
      {
        final Function2<CharSequence,String,IFile> _function = new Function2<CharSequence,String,IFile>() {
            public IFile apply(final CharSequence content, final String name) {
              SubMonitor _newChild = subMonitor.newChild(1);
              IFile _writeToFile = FeatureProjectFactory.this.writeToFile(content, name, project, _newChild);
              return _writeToFile;
            }
          };
        final IFileCreator fileWriter = new IFileCreator() {
            public IFile writeToFile(CharSequence chars,String fileName) {
              return _function.apply(chars,fileName);
            }
        };
        contributor.contributeFiles(project, fileWriter);
      }
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
      for(final Object includedFeature : this.includedFeatures) {
        _builder.append("\t");
        _builder.append("<includes");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("id=\"");
        _builder.append(includedFeature, "		");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("version=\"0.0.0\"/>");
        _builder.newLine();
      }
    }
    {
      for(final Object containedBundle : this.containedBundles) {
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
  
  private void createCategoryFile(final IProject project, final String categoryName, final IProgressMonitor monitor) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<site>");
    _builder.newLine();
    {
      for(final Object includedFeature : this.includedFeatures) {
        _builder.append("\t");
        _builder.append("<feature id=\"");
        _builder.append(includedFeature, "	");
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
        _builder.append(includedFeature, "	");
        _builder.append(".source\" version=\"0.0.0\">");
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
  
  private IFile writeToFile(final CharSequence chrSeq, final String fileName, final IProject project, final IProgressMonitor progrMonitor) {
    String _string = chrSeq.toString();
    return this.createFile(fileName, project, _string, progrMonitor);
  }
}

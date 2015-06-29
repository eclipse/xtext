package org.eclipse.xtext.idea.facet;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.idea.util.IdeaWidgetFactory;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * Created by dhuebner on 19.06.15.
 */
@SuppressWarnings("all")
public class GeneratorFacetForm<T extends GeneratorConfigurationState> {
  @Extension
  private IdeaWidgetFactory _ideaWidgetFactory = new IdeaWidgetFactory();
  
  private JCheckBox activated;
  
  private TextFieldWithBrowseButton directory;
  
  private TextFieldWithBrowseButton testDirectory;
  
  private JCheckBox createDirectory;
  
  private JCheckBox overwriteFiles;
  
  private JCheckBox deleteGenerated;
  
  private Module module;
  
  private JComponent rootPanel;
  
  public GeneratorFacetForm(final Module module) {
    this.module = module;
    JComponent _createComponent = this.createComponent();
    this.rootPanel = _createComponent;
  }
  
  protected JComponent createComponent() {
    final Function1<IdeaWidgetFactory.TwoColumnPanel, IdeaWidgetFactory.TwoColumnPanel> _function = new Function1<IdeaWidgetFactory.TwoColumnPanel, IdeaWidgetFactory.TwoColumnPanel>() {
      @Override
      public IdeaWidgetFactory.TwoColumnPanel apply(@Extension final IdeaWidgetFactory.TwoColumnPanel it) {
        IdeaWidgetFactory.TwoColumnPanel _xblockexpression = null;
        {
          final Function1<GridBagConstraints, JComponent> _function = new Function1<GridBagConstraints, JComponent>() {
            @Override
            public JComponent apply(final GridBagConstraints it) {
              return GeneratorFacetForm.this._ideaWidgetFactory.separator("General");
            }
          };
          it.row(it, _function);
          final Function1<GridBagConstraints, JComponent> _function_1 = new Function1<GridBagConstraints, JComponent>() {
            @Override
            public JComponent apply(final GridBagConstraints it) {
              JCheckBox _checkBox = GeneratorFacetForm.this._ideaWidgetFactory.checkBox("Compiler is activated");
              return GeneratorFacetForm.this.activated = _checkBox;
            }
          };
          it.row(it, _function_1);
          final Function1<GridBagConstraints, JComponent> _function_2 = new Function1<GridBagConstraints, JComponent>() {
            @Override
            public JComponent apply(final GridBagConstraints it) {
              return GeneratorFacetForm.this._ideaWidgetFactory.label(" ");
            }
          };
          it.row(it, _function_2);
          final Function1<GridBagConstraints, JComponent> _function_3 = new Function1<GridBagConstraints, JComponent>() {
            @Override
            public JComponent apply(final GridBagConstraints it) {
              return GeneratorFacetForm.this._ideaWidgetFactory.separator("Output Folder");
            }
          };
          it.row(it, _function_3);
          final Function1<GridBagConstraints, JComponent> _function_4 = new Function1<GridBagConstraints, JComponent>() {
            @Override
            public JComponent apply(final GridBagConstraints it) {
              return GeneratorFacetForm.this._ideaWidgetFactory.label("Directory:");
            }
          };
          final Function1<GridBagConstraints, JComponent> _function_5 = new Function1<GridBagConstraints, JComponent>() {
            @Override
            public JComponent apply(final GridBagConstraints it) {
              TextFieldWithBrowseButton _xblockexpression = null;
              {
                it.weightx = 1.0;
                Project _project = GeneratorFacetForm.this.module.getProject();
                TextFieldWithBrowseButton _browseField = GeneratorFacetForm.this._ideaWidgetFactory.browseField(_project);
                _xblockexpression = GeneratorFacetForm.this.directory = _browseField;
              }
              return _xblockexpression;
            }
          };
          it.row(it, _function_4, _function_5);
          final Function1<GridBagConstraints, JComponent> _function_6 = new Function1<GridBagConstraints, JComponent>() {
            @Override
            public JComponent apply(final GridBagConstraints it) {
              return GeneratorFacetForm.this._ideaWidgetFactory.label("Test Directory:");
            }
          };
          final Function1<GridBagConstraints, JComponent> _function_7 = new Function1<GridBagConstraints, JComponent>() {
            @Override
            public JComponent apply(final GridBagConstraints it) {
              Project _project = GeneratorFacetForm.this.module.getProject();
              TextFieldWithBrowseButton _browseField = GeneratorFacetForm.this._ideaWidgetFactory.browseField(_project);
              return GeneratorFacetForm.this.testDirectory = _browseField;
            }
          };
          it.row(it, _function_6, _function_7);
          final Function1<GridBagConstraints, JComponent> _function_8 = new Function1<GridBagConstraints, JComponent>() {
            @Override
            public JComponent apply(final GridBagConstraints it) {
              JCheckBox _checkBox = GeneratorFacetForm.this._ideaWidgetFactory.checkBox("Create directory if it doesn\'t exist");
              return GeneratorFacetForm.this.createDirectory = _checkBox;
            }
          };
          it.row(it, _function_8);
          final Function1<GridBagConstraints, JComponent> _function_9 = new Function1<GridBagConstraints, JComponent>() {
            @Override
            public JComponent apply(final GridBagConstraints it) {
              JCheckBox _checkBox = GeneratorFacetForm.this._ideaWidgetFactory.checkBox("Overwrite existing files");
              return GeneratorFacetForm.this.overwriteFiles = _checkBox;
            }
          };
          it.row(it, _function_9);
          final Function1<GridBagConstraints, JComponent> _function_10 = new Function1<GridBagConstraints, JComponent>() {
            @Override
            public JComponent apply(final GridBagConstraints it) {
              JCheckBox _checkBox = GeneratorFacetForm.this._ideaWidgetFactory.checkBox("Delete generated files");
              return GeneratorFacetForm.this.deleteGenerated = _checkBox;
            }
          };
          it.row(it, _function_10);
          _xblockexpression = it.expand(it, GridBagConstraints.VERTICAL);
        }
        return _xblockexpression;
      }
    };
    return this._ideaWidgetFactory.twoColumnPanel(_function);
  }
  
  public void setData(final GeneratorConfigurationState data) {
    boolean _isCreateDirectory = data.isCreateDirectory();
    this.createDirectory.setSelected(_isCreateDirectory);
    boolean _isOverwriteExisting = data.isOverwriteExisting();
    this.overwriteFiles.setSelected(_isOverwriteExisting);
    boolean _isDeleteGenerated = data.isDeleteGenerated();
    this.deleteGenerated.setSelected(_isDeleteGenerated);
    boolean _isActivated = data.isActivated();
    this.activated.setSelected(_isActivated);
    String _outputDirectory = data.getOutputDirectory();
    this.directory.setText(_outputDirectory);
    String _testOutputDirectory = data.getTestOutputDirectory();
    this.testDirectory.setText(_testOutputDirectory);
  }
  
  public void getData(final T data) {
    boolean _isSelected = this.createDirectory.isSelected();
    data.setCreateDirectory(_isSelected);
    boolean _isSelected_1 = this.overwriteFiles.isSelected();
    data.setOverwriteExisting(_isSelected_1);
    boolean _isSelected_2 = this.deleteGenerated.isSelected();
    data.setDeleteGenerated(_isSelected_2);
    boolean _isSelected_3 = this.activated.isSelected();
    data.setActivated(_isSelected_3);
    String _text = this.directory.getText();
    data.setOutputDirectory(_text);
    String _text_1 = this.testDirectory.getText();
    data.setTestOutputDirectory(_text_1);
  }
  
  public boolean isModified(final T data) {
    boolean _isSelected = this.createDirectory.isSelected();
    boolean _isCreateDirectory = data.isCreateDirectory();
    boolean _tripleNotEquals = (Boolean.valueOf(_isSelected) != Boolean.valueOf(_isCreateDirectory));
    if (_tripleNotEquals) {
      return true;
    }
    boolean _isSelected_1 = this.overwriteFiles.isSelected();
    boolean _isOverwriteExisting = data.isOverwriteExisting();
    boolean _tripleNotEquals_1 = (Boolean.valueOf(_isSelected_1) != Boolean.valueOf(_isOverwriteExisting));
    if (_tripleNotEquals_1) {
      return true;
    }
    boolean _isSelected_2 = this.deleteGenerated.isSelected();
    boolean _isDeleteGenerated = data.isDeleteGenerated();
    boolean _tripleNotEquals_2 = (Boolean.valueOf(_isSelected_2) != Boolean.valueOf(_isDeleteGenerated));
    if (_tripleNotEquals_2) {
      return true;
    }
    boolean _isSelected_3 = this.activated.isSelected();
    boolean _isActivated = data.isActivated();
    boolean _tripleNotEquals_3 = (Boolean.valueOf(_isSelected_3) != Boolean.valueOf(_isActivated));
    if (_tripleNotEquals_3) {
      return true;
    }
    boolean _xifexpression = false;
    String _text = this.directory.getText();
    boolean _tripleNotEquals_4 = (_text != null);
    if (_tripleNotEquals_4) {
      String _text_1 = this.directory.getText();
      String _outputDirectory = data.getOutputDirectory();
      boolean _equals = _text_1.equals(_outputDirectory);
      _xifexpression = (!_equals);
    } else {
      String _outputDirectory_1 = data.getOutputDirectory();
      _xifexpression = (_outputDirectory_1 != null);
    }
    if (_xifexpression) {
      return true;
    }
    boolean _xifexpression_1 = false;
    String _text_2 = this.testDirectory.getText();
    boolean _tripleNotEquals_5 = (_text_2 != null);
    if (_tripleNotEquals_5) {
      String _text_3 = this.testDirectory.getText();
      String _testOutputDirectory = data.getTestOutputDirectory();
      boolean _equals_1 = _text_3.equals(_testOutputDirectory);
      _xifexpression_1 = (!_equals_1);
    } else {
      String _testOutputDirectory_1 = data.getTestOutputDirectory();
      _xifexpression_1 = (_testOutputDirectory_1 != null);
    }
    if (_xifexpression_1) {
      return true;
    }
    return false;
  }
  
  public JComponent getRootComponent() {
    return this.rootPanel;
  }
}

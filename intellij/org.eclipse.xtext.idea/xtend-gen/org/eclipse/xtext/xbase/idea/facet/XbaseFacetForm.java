/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.facet;

import com.google.common.base.Objects;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.LanguageLevelModuleExtension;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.impl.LanguageLevelProjectExtensionImpl;
import com.intellij.openapi.roots.ui.configuration.LanguageLevelCombo;
import com.intellij.pom.java.LanguageLevel;
import com.intellij.ui.components.JBTextField;
import java.awt.GridBagConstraints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.idea.facet.GeneratorFacetForm;
import org.eclipse.xtext.idea.util.IdeaWidgetFactory;
import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class XbaseFacetForm extends GeneratorFacetForm {
  @Extension
  private IdeaWidgetFactory _ideaWidgetFactory = new IdeaWidgetFactory();
  
  private LanguageLevelCombo targetJavaVersion;
  
  private JCheckBox generateSuppressWarnings;
  
  private JCheckBox generateGeneratedAnnotation;
  
  private JCheckBox includeDateInGenerated;
  
  private JBTextField generatedAnnotationComment;
  
  private JCheckBox installDslAsPrimarySource;
  
  private JCheckBox hideLocalSyntheticVariables;
  
  public XbaseFacetForm(final Module module) {
    super(module);
  }
  
  @Override
  protected JComponent createComponent() {
    final JComponent comp = super.createComponent();
    this.includeDateInGenerated.setEnabled(false);
    this.generatedAnnotationComment.setEnabled(false);
    this.hideLocalSyntheticVariables.setEnabled(false);
    final ItemListener _function = new ItemListener() {
      @Override
      public void itemStateChanged(final ItemEvent it) {
        boolean _isSelected = XbaseFacetForm.this.generateGeneratedAnnotation.isSelected();
        XbaseFacetForm.this.includeDateInGenerated.setEnabled(_isSelected);
        boolean _isSelected_1 = XbaseFacetForm.this.generateGeneratedAnnotation.isSelected();
        XbaseFacetForm.this.generatedAnnotationComment.setEnabled(_isSelected_1);
      }
    };
    this.generateGeneratedAnnotation.addItemListener(_function);
    final ItemListener _function_1 = new ItemListener() {
      @Override
      public void itemStateChanged(final ItemEvent it) {
        boolean _isSelected = XbaseFacetForm.this.installDslAsPrimarySource.isSelected();
        XbaseFacetForm.this.hideLocalSyntheticVariables.setEnabled(_isSelected);
      }
    };
    this.installDslAsPrimarySource.addItemListener(_function_1);
    return comp;
  }
  
  @Override
  public IdeaWidgetFactory.TwoColumnPanel createGeneralSection(@Extension final IdeaWidgetFactory.TwoColumnPanel it) {
    IdeaWidgetFactory.TwoColumnPanel _xblockexpression = null;
    {
      super.createGeneralSection(it);
      final Function1<GridBagConstraints, JComponent> _function = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          final Function1<GridBagConstraints, JComponent> _function = new Function1<GridBagConstraints, JComponent>() {
            @Override
            public JComponent apply(final GridBagConstraints it) {
              return XbaseFacetForm.this._ideaWidgetFactory.label("Language level:");
            }
          };
          final Function1<GridBagConstraints, JComponent> _function_1 = new Function1<GridBagConstraints, JComponent>() {
            @Override
            public JComponent apply(final GridBagConstraints it) {
              LanguageLevelCombo _xblockexpression = null;
              {
                XbaseFacetForm.this._ideaWidgetFactory.expand(it, GridBagConstraints.HORIZONTAL);
                LanguageLevelCombo _createLanguageLevelCombo = XbaseFacetForm.this.createLanguageLevelCombo();
                _xblockexpression = XbaseFacetForm.this.targetJavaVersion = _createLanguageLevelCombo;
              }
              return _xblockexpression;
            }
          };
          return XbaseFacetForm.this._ideaWidgetFactory.container(_function, _function_1);
        }
      };
      it.row(it, _function);
      final Function1<GridBagConstraints, JComponent> _function_1 = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JCheckBox _checkBox = XbaseFacetForm.this._ideaWidgetFactory.checkBox("Generate @SuppressWarnings annotations");
          return XbaseFacetForm.this.generateSuppressWarnings = _checkBox;
        }
      };
      it.row(it, _function_1);
      final Function1<GridBagConstraints, JComponent> _function_2 = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JCheckBox _checkBox = XbaseFacetForm.this._ideaWidgetFactory.checkBox("Generate @Generated annotations");
          return XbaseFacetForm.this.generateGeneratedAnnotation = _checkBox;
        }
      };
      it.row(it, _function_2);
      final Function1<GridBagConstraints, JComponent> _function_3 = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JCheckBox _xblockexpression = null;
          {
            XbaseFacetForm.this._ideaWidgetFactory.indent(it);
            JCheckBox _checkBox = XbaseFacetForm.this._ideaWidgetFactory.checkBox("Include current time information");
            _xblockexpression = XbaseFacetForm.this.includeDateInGenerated = _checkBox;
          }
          return _xblockexpression;
        }
      };
      it.row(it, _function_3);
      final Function1<GridBagConstraints, JComponent> _function_4 = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JPanel _xblockexpression = null;
          {
            XbaseFacetForm.this._ideaWidgetFactory.indent(it);
            final Function1<GridBagConstraints, JComponent> _function = new Function1<GridBagConstraints, JComponent>() {
              @Override
              public JComponent apply(final GridBagConstraints it) {
                return XbaseFacetForm.this._ideaWidgetFactory.label("Comment:");
              }
            };
            final Function1<GridBagConstraints, JComponent> _function_1 = new Function1<GridBagConstraints, JComponent>() {
              @Override
              public JComponent apply(final GridBagConstraints it) {
                JBTextField _xblockexpression = null;
                {
                  XbaseFacetForm.this._ideaWidgetFactory.expand(it, GridBagConstraints.HORIZONTAL);
                  it.anchor = GridBagConstraints.WEST;
                  JBTextField _textField = XbaseFacetForm.this._ideaWidgetFactory.textField();
                  _xblockexpression = XbaseFacetForm.this.generatedAnnotationComment = _textField;
                }
                return _xblockexpression;
              }
            };
            _xblockexpression = XbaseFacetForm.this._ideaWidgetFactory.container(_function, _function_1);
          }
          return _xblockexpression;
        }
      };
      _xblockexpression = it.row(it, _function_4);
    }
    return _xblockexpression;
  }
  
  @Override
  public IdeaWidgetFactory.TwoColumnPanel createOutputSection(@Extension final IdeaWidgetFactory.TwoColumnPanel it) {
    IdeaWidgetFactory.TwoColumnPanel _xblockexpression = null;
    {
      super.createOutputSection(it);
      final Function1<GridBagConstraints, JComponent> _function = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JCheckBox _checkBox = XbaseFacetForm.this._ideaWidgetFactory.checkBox("Ignore generated Java source when debugging (Use for Android)");
          return XbaseFacetForm.this.installDslAsPrimarySource = _checkBox;
        }
      };
      it.row(it, _function);
      final Function1<GridBagConstraints, JComponent> _function_1 = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JCheckBox _xblockexpression = null;
          {
            XbaseFacetForm.this._ideaWidgetFactory.indent(it);
            JCheckBox _checkBox = XbaseFacetForm.this._ideaWidgetFactory.checkBox("Hide synthetic local variables in the debugger");
            _xblockexpression = XbaseFacetForm.this.hideLocalSyntheticVariables = _checkBox;
          }
          return _xblockexpression;
        }
      };
      _xblockexpression = it.row(it, _function_1);
    }
    return _xblockexpression;
  }
  
  @Override
  public void postCreateComponent() {
    super.postCreateComponent();
    this.installDslAsPrimarySource.setVisible(false);
    this.hideLocalSyntheticVariables.setVisible(false);
  }
  
  @Override
  public void setData(final GeneratorConfigurationState data) {
    super.setData(data);
    if ((data instanceof XbaseGeneratorConfigurationState)) {
      LanguageLevel[] _values = LanguageLevel.values();
      final Function1<LanguageLevel, Boolean> _function = new Function1<LanguageLevel, Boolean>() {
        @Override
        public Boolean apply(final LanguageLevel it) {
          String _name = it.name();
          String _targetJavaVersion = ((XbaseGeneratorConfigurationState)data).getTargetJavaVersion();
          return Boolean.valueOf((_name == _targetJavaVersion));
        }
      };
      LanguageLevel _findFirst = IterableExtensions.<LanguageLevel>findFirst(((Iterable<LanguageLevel>)Conversions.doWrapArray(_values)), _function);
      boolean _notEquals = (!Objects.equal(_findFirst, null));
      if (_notEquals) {
        String _targetJavaVersion = ((XbaseGeneratorConfigurationState)data).getTargetJavaVersion();
        LanguageLevel _valueOf = LanguageLevel.valueOf(_targetJavaVersion);
        this.targetJavaVersion.setSelectedItem(_valueOf);
      } else {
        this.targetJavaVersion.setSelectedItem(null);
      }
      boolean _isGenerateSuppressWarnings = ((XbaseGeneratorConfigurationState)data).isGenerateSuppressWarnings();
      this.generateSuppressWarnings.setSelected(_isGenerateSuppressWarnings);
      boolean _isGenerateGeneratedAnnotation = ((XbaseGeneratorConfigurationState)data).isGenerateGeneratedAnnotation();
      this.generateGeneratedAnnotation.setSelected(_isGenerateGeneratedAnnotation);
      boolean _isIncludeDateInGenerated = ((XbaseGeneratorConfigurationState)data).isIncludeDateInGenerated();
      this.includeDateInGenerated.setSelected(_isIncludeDateInGenerated);
      String _generatedAnnotationComment = ((XbaseGeneratorConfigurationState)data).getGeneratedAnnotationComment();
      this.generatedAnnotationComment.setText(_generatedAnnotationComment);
      boolean _isInstallDslAsPrimarySource = ((XbaseGeneratorConfigurationState)data).isInstallDslAsPrimarySource();
      this.installDslAsPrimarySource.setSelected(_isInstallDslAsPrimarySource);
      boolean _isHideLocalSyntheticVariables = ((XbaseGeneratorConfigurationState)data).isHideLocalSyntheticVariables();
      this.hideLocalSyntheticVariables.setSelected(_isHideLocalSyntheticVariables);
    }
  }
  
  @Override
  public void getData(final GeneratorConfigurationState data) {
    super.getData(data);
    if ((data instanceof XbaseGeneratorConfigurationState)) {
      Object _selectedItem = this.targetJavaVersion.getSelectedItem();
      String _string = null;
      if (_selectedItem!=null) {
        _string=_selectedItem.toString();
      }
      ((XbaseGeneratorConfigurationState)data).setTargetJavaVersion(_string);
      boolean _isSelected = this.generateSuppressWarnings.isSelected();
      ((XbaseGeneratorConfigurationState)data).setGenerateSuppressWarnings(_isSelected);
      boolean _isSelected_1 = this.generateGeneratedAnnotation.isSelected();
      ((XbaseGeneratorConfigurationState)data).setGenerateGeneratedAnnotation(_isSelected_1);
      boolean _isSelected_2 = this.includeDateInGenerated.isSelected();
      ((XbaseGeneratorConfigurationState)data).setIncludeDateInGenerated(_isSelected_2);
      String _text = this.generatedAnnotationComment.getText();
      ((XbaseGeneratorConfigurationState)data).setGeneratedAnnotationComment(_text);
      boolean _isSelected_3 = this.installDslAsPrimarySource.isSelected();
      ((XbaseGeneratorConfigurationState)data).setInstallDslAsPrimarySource(_isSelected_3);
      boolean _isSelected_4 = this.hideLocalSyntheticVariables.isSelected();
      ((XbaseGeneratorConfigurationState)data).setHideLocalSyntheticVariables(_isSelected_4);
    }
  }
  
  @Override
  public boolean isModified(final GeneratorConfigurationState data) {
    boolean _isModified = super.isModified(data);
    boolean _not = (!_isModified);
    if (_not) {
      if ((data instanceof XbaseGeneratorConfigurationState)) {
        boolean _xifexpression = false;
        Object _selectedItem = this.targetJavaVersion.getSelectedItem();
        boolean _tripleNotEquals = (_selectedItem != null);
        if (_tripleNotEquals) {
          Object _selectedItem_1 = this.targetJavaVersion.getSelectedItem();
          String _string = _selectedItem_1.toString();
          String _targetJavaVersion = ((XbaseGeneratorConfigurationState)data).getTargetJavaVersion();
          boolean _equals = _string.equals(_targetJavaVersion);
          _xifexpression = (!_equals);
        } else {
          String _targetJavaVersion_1 = ((XbaseGeneratorConfigurationState)data).getTargetJavaVersion();
          _xifexpression = (_targetJavaVersion_1 != null);
        }
        if (_xifexpression) {
          return true;
        }
        boolean _isSelected = this.generateSuppressWarnings.isSelected();
        boolean _isGenerateSuppressWarnings = ((XbaseGeneratorConfigurationState)data).isGenerateSuppressWarnings();
        boolean _tripleNotEquals_1 = (Boolean.valueOf(_isSelected) != Boolean.valueOf(_isGenerateSuppressWarnings));
        if (_tripleNotEquals_1) {
          return true;
        }
        boolean _isSelected_1 = this.generateGeneratedAnnotation.isSelected();
        boolean _isGenerateGeneratedAnnotation = ((XbaseGeneratorConfigurationState)data).isGenerateGeneratedAnnotation();
        boolean _tripleNotEquals_2 = (Boolean.valueOf(_isSelected_1) != Boolean.valueOf(_isGenerateGeneratedAnnotation));
        if (_tripleNotEquals_2) {
          return true;
        }
        boolean _isSelected_2 = this.includeDateInGenerated.isSelected();
        boolean _isIncludeDateInGenerated = ((XbaseGeneratorConfigurationState)data).isIncludeDateInGenerated();
        boolean _tripleNotEquals_3 = (Boolean.valueOf(_isSelected_2) != Boolean.valueOf(_isIncludeDateInGenerated));
        if (_tripleNotEquals_3) {
          return true;
        }
        boolean _xifexpression_1 = false;
        String _text = this.generatedAnnotationComment.getText();
        boolean _tripleNotEquals_4 = (_text != null);
        if (_tripleNotEquals_4) {
          String _text_1 = this.generatedAnnotationComment.getText();
          String _generatedAnnotationComment = ((XbaseGeneratorConfigurationState)data).getGeneratedAnnotationComment();
          boolean _equals_1 = _text_1.equals(_generatedAnnotationComment);
          _xifexpression_1 = (!_equals_1);
        } else {
          String _generatedAnnotationComment_1 = ((XbaseGeneratorConfigurationState)data).getGeneratedAnnotationComment();
          _xifexpression_1 = (_generatedAnnotationComment_1 != null);
        }
        if (_xifexpression_1) {
          return true;
        }
        boolean _isSelected_3 = this.installDslAsPrimarySource.isSelected();
        boolean _isInstallDslAsPrimarySource = ((XbaseGeneratorConfigurationState)data).isInstallDslAsPrimarySource();
        boolean _tripleNotEquals_5 = (Boolean.valueOf(_isSelected_3) != Boolean.valueOf(_isInstallDslAsPrimarySource));
        if (_tripleNotEquals_5) {
          return true;
        }
        boolean _isSelected_4 = this.hideLocalSyntheticVariables.isSelected();
        boolean _isHideLocalSyntheticVariables = ((XbaseGeneratorConfigurationState)data).isHideLocalSyntheticVariables();
        boolean _tripleNotEquals_6 = (Boolean.valueOf(_isSelected_4) != Boolean.valueOf(_isHideLocalSyntheticVariables));
        if (_tripleNotEquals_6) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public LanguageLevelCombo createLanguageLevelCombo() {
    abstract class __XbaseFacetForm_1 extends LanguageLevelCombo {
      __XbaseFacetForm_1(final String defaultItem) {
        super(defaultItem);
      }
      
      LanguageLevelModuleExtension llExt;
    }
    
    final String defItem = "Module default";
    final __XbaseFacetForm_1 langLavelCombo = new __XbaseFacetForm_1(defItem) {
      {
        llExt = ModuleRootManager.getInstance(XbaseFacetForm.this.getModule()).<LanguageLevelModuleExtension>getModuleExtension(LanguageLevelModuleExtension.class);
      }
      @Override
      protected LanguageLevel getDefaultLevel() {
        LanguageLevel langLevel = this.llExt.getLanguageLevel();
        boolean _equals = Objects.equal(langLevel, null);
        if (_equals) {
          Module _module = XbaseFacetForm.this.getModule();
          Project _project = _module.getProject();
          LanguageLevelProjectExtensionImpl _instanceImpl = LanguageLevelProjectExtensionImpl.getInstanceImpl(_project);
          LanguageLevel _currentLevel = _instanceImpl.getCurrentLevel();
          langLevel = _currentLevel;
        }
        return langLevel;
      }
    };
    langLavelCombo.insertItemAt(defItem, 0);
    return langLavelCombo;
  }
}

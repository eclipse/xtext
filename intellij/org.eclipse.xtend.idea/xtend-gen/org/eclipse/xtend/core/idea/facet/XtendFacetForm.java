/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.facet;

import com.intellij.openapi.module.Module;
import com.intellij.ui.components.JBTextField;
import java.awt.GridBagConstraints;
import java.util.Collections;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.eclipse.xtend.core.idea.facet.XtendGeneratorConfigurationState;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.idea.facet.GeneratorFacetForm;
import org.eclipse.xtext.idea.util.IdeaWidgetFactory;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFacetForm extends GeneratorFacetForm {
  @Extension
  private IdeaWidgetFactory _ideaWidgetFactory = new IdeaWidgetFactory();
  
  private JCheckBox useJavaCompilerCompliance;
  
  private JComboBox targetJavaVersion;
  
  private JCheckBox generateSuppressWarnings;
  
  private JCheckBox generateGeneratedAnnotation;
  
  private JCheckBox includeDateInGenerated;
  
  private JBTextField generatedAnnotationComment;
  
  private JCheckBox installDslAsPrimarySource;
  
  private JCheckBox hideLocalSyntheticVariables;
  
  public XtendFacetForm(final Module module) {
    super(module);
  }
  
  @Override
  public IdeaWidgetFactory.TwoColumnPanel createGeneralSection(@Extension final IdeaWidgetFactory.TwoColumnPanel it) {
    IdeaWidgetFactory.TwoColumnPanel _xblockexpression = null;
    {
      super.createGeneralSection(it);
      final Function1<GridBagConstraints, JComponent> _function = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JCheckBox _checkBox = XtendFacetForm.this._ideaWidgetFactory.checkBox("Use source compatibility level from Java settings");
          return XtendFacetForm.this.useJavaCompilerCompliance = _checkBox;
        }
      };
      it.row(it, _function);
      final Function1<GridBagConstraints, JComponent> _function_1 = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JPanel _xblockexpression = null;
          {
            XtendFacetForm.this._ideaWidgetFactory.indent(it);
            final Function1<GridBagConstraints, JComponent> _function = new Function1<GridBagConstraints, JComponent>() {
              @Override
              public JComponent apply(final GridBagConstraints it) {
                return XtendFacetForm.this._ideaWidgetFactory.label("Source compatibility level of generated code:");
              }
            };
            final Function1<GridBagConstraints, JComponent> _function_1 = new Function1<GridBagConstraints, JComponent>() {
              @Override
              public JComponent apply(final GridBagConstraints it) {
                JComboBox _xblockexpression = null;
                {
                  XtendFacetForm.this._ideaWidgetFactory.expand(it, GridBagConstraints.HORIZONTAL);
                  JComboBox _jComboBox = new JComboBox(((String[]) ((String[])Conversions.unwrapArray(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Java 6", "Java 7")), String.class))));
                  _xblockexpression = XtendFacetForm.this.targetJavaVersion = _jComboBox;
                }
                return _xblockexpression;
              }
            };
            _xblockexpression = XtendFacetForm.this._ideaWidgetFactory.container(_function, _function_1);
          }
          return _xblockexpression;
        }
      };
      it.row(it, _function_1);
      final Function1<GridBagConstraints, JComponent> _function_2 = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JCheckBox _checkBox = XtendFacetForm.this._ideaWidgetFactory.checkBox("Generate @SuppressWarnings annotations");
          return XtendFacetForm.this.generateSuppressWarnings = _checkBox;
        }
      };
      it.row(it, _function_2);
      final Function1<GridBagConstraints, JComponent> _function_3 = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JCheckBox _checkBox = XtendFacetForm.this._ideaWidgetFactory.checkBox("Generate @Generated annotations");
          return XtendFacetForm.this.generateGeneratedAnnotation = _checkBox;
        }
      };
      it.row(it, _function_3);
      final Function1<GridBagConstraints, JComponent> _function_4 = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JCheckBox _xblockexpression = null;
          {
            XtendFacetForm.this._ideaWidgetFactory.indent(it);
            JCheckBox _checkBox = XtendFacetForm.this._ideaWidgetFactory.checkBox("Include current time information");
            _xblockexpression = XtendFacetForm.this.includeDateInGenerated = _checkBox;
          }
          return _xblockexpression;
        }
      };
      it.row(it, _function_4);
      final Function1<GridBagConstraints, JComponent> _function_5 = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JPanel _xblockexpression = null;
          {
            XtendFacetForm.this._ideaWidgetFactory.indent(it);
            final Function1<GridBagConstraints, JComponent> _function = new Function1<GridBagConstraints, JComponent>() {
              @Override
              public JComponent apply(final GridBagConstraints it) {
                return XtendFacetForm.this._ideaWidgetFactory.label("Comment:");
              }
            };
            final Function1<GridBagConstraints, JComponent> _function_1 = new Function1<GridBagConstraints, JComponent>() {
              @Override
              public JComponent apply(final GridBagConstraints it) {
                JBTextField _xblockexpression = null;
                {
                  XtendFacetForm.this._ideaWidgetFactory.expand(it, GridBagConstraints.HORIZONTAL);
                  it.anchor = GridBagConstraints.WEST;
                  JBTextField _jBTextField = new JBTextField(20);
                  _xblockexpression = XtendFacetForm.this.generatedAnnotationComment = _jBTextField;
                }
                return _xblockexpression;
              }
            };
            _xblockexpression = XtendFacetForm.this._ideaWidgetFactory.container(_function, _function_1);
          }
          return _xblockexpression;
        }
      };
      _xblockexpression = it.row(it, _function_5);
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
          JCheckBox _checkBox = XtendFacetForm.this._ideaWidgetFactory.checkBox("Ignore generated Java source when debugging (Use for Android)");
          return XtendFacetForm.this.installDslAsPrimarySource = _checkBox;
        }
      };
      it.row(it, _function);
      final Function1<GridBagConstraints, JComponent> _function_1 = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JCheckBox _xblockexpression = null;
          {
            XtendFacetForm.this._ideaWidgetFactory.indent(it);
            JCheckBox _checkBox = XtendFacetForm.this._ideaWidgetFactory.checkBox("Hide synthetic local variables in the debugger");
            _xblockexpression = XtendFacetForm.this.hideLocalSyntheticVariables = _checkBox;
          }
          return _xblockexpression;
        }
      };
      _xblockexpression = it.row(it, _function_1);
    }
    return _xblockexpression;
  }
  
  @Override
  public void setData(final GeneratorConfigurationState data) {
    super.setData(data);
    if ((data instanceof XtendGeneratorConfigurationState)) {
      boolean _isUseJavaCompilerCompliance = ((XtendGeneratorConfigurationState)data).isUseJavaCompilerCompliance();
      this.useJavaCompilerCompliance.setSelected(_isUseJavaCompilerCompliance);
      String _targetJavaVersion = ((XtendGeneratorConfigurationState)data).getTargetJavaVersion();
      this.targetJavaVersion.setSelectedItem(_targetJavaVersion);
      boolean _isGenerateSuppressWarnings = ((XtendGeneratorConfigurationState)data).isGenerateSuppressWarnings();
      this.generateSuppressWarnings.setSelected(_isGenerateSuppressWarnings);
      boolean _isGenerateGeneratedAnnotation = ((XtendGeneratorConfigurationState)data).isGenerateGeneratedAnnotation();
      this.generateGeneratedAnnotation.setSelected(_isGenerateGeneratedAnnotation);
      boolean _isIncludeDateInGenerated = ((XtendGeneratorConfigurationState)data).isIncludeDateInGenerated();
      this.includeDateInGenerated.setSelected(_isIncludeDateInGenerated);
      String _generatedAnnotationComment = ((XtendGeneratorConfigurationState)data).getGeneratedAnnotationComment();
      this.generatedAnnotationComment.setText(_generatedAnnotationComment);
      boolean _isInstallDslAsPrimarySource = ((XtendGeneratorConfigurationState)data).isInstallDslAsPrimarySource();
      this.installDslAsPrimarySource.setSelected(_isInstallDslAsPrimarySource);
    }
  }
  
  @Override
  public void getData(final GeneratorConfigurationState data) {
    super.getData(data);
    if ((data instanceof XtendGeneratorConfigurationState)) {
      boolean _isSelected = this.useJavaCompilerCompliance.isSelected();
      ((XtendGeneratorConfigurationState)data).setUseJavaCompilerCompliance(_isSelected);
      Object _selectedItem = this.targetJavaVersion.getSelectedItem();
      String _string = _selectedItem.toString();
      ((XtendGeneratorConfigurationState)data).setTargetJavaVersion(_string);
      boolean _isSelected_1 = this.generateSuppressWarnings.isSelected();
      ((XtendGeneratorConfigurationState)data).setGenerateSuppressWarnings(_isSelected_1);
      boolean _isSelected_2 = this.generateGeneratedAnnotation.isSelected();
      ((XtendGeneratorConfigurationState)data).setGenerateGeneratedAnnotation(_isSelected_2);
      boolean _isSelected_3 = this.includeDateInGenerated.isSelected();
      ((XtendGeneratorConfigurationState)data).setIncludeDateInGenerated(_isSelected_3);
      String _text = this.generatedAnnotationComment.getText();
      ((XtendGeneratorConfigurationState)data).setGeneratedAnnotationComment(_text);
      boolean _isSelected_4 = this.installDslAsPrimarySource.isSelected();
      ((XtendGeneratorConfigurationState)data).setInstallDslAsPrimarySource(_isSelected_4);
    }
  }
  
  @Override
  public boolean isModified(final GeneratorConfigurationState data) {
    boolean _isModified = super.isModified(data);
    boolean _not = (!_isModified);
    if (_not) {
      if ((data instanceof XtendGeneratorConfigurationState)) {
        boolean _isSelected = this.useJavaCompilerCompliance.isSelected();
        boolean _isUseJavaCompilerCompliance = ((XtendGeneratorConfigurationState)data).isUseJavaCompilerCompliance();
        boolean _tripleNotEquals = (Boolean.valueOf(_isSelected) != Boolean.valueOf(_isUseJavaCompilerCompliance));
        if (_tripleNotEquals) {
          return true;
        }
        boolean _isSelected_1 = this.generateGeneratedAnnotation.isSelected();
        boolean _isGenerateGeneratedAnnotation = ((XtendGeneratorConfigurationState)data).isGenerateGeneratedAnnotation();
        boolean _tripleNotEquals_1 = (Boolean.valueOf(_isSelected_1) != Boolean.valueOf(_isGenerateGeneratedAnnotation));
        if (_tripleNotEquals_1) {
          return true;
        }
        boolean _isSelected_2 = this.generateSuppressWarnings.isSelected();
        boolean _isGenerateSuppressWarnings = ((XtendGeneratorConfigurationState)data).isGenerateSuppressWarnings();
        boolean _tripleNotEquals_2 = (Boolean.valueOf(_isSelected_2) != Boolean.valueOf(_isGenerateSuppressWarnings));
        if (_tripleNotEquals_2) {
          return true;
        }
        boolean _isSelected_3 = this.installDslAsPrimarySource.isSelected();
        boolean _isInstallDslAsPrimarySource = ((XtendGeneratorConfigurationState)data).isInstallDslAsPrimarySource();
        boolean _tripleNotEquals_3 = (Boolean.valueOf(_isSelected_3) != Boolean.valueOf(_isInstallDslAsPrimarySource));
        if (_tripleNotEquals_3) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.facet;

import com.intellij.openapi.module.Module;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import org.eclipse.xtend.core.idea.facet.XtendGeneratorConfigurationState;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.idea.facet.GeneratorFacetForm;
import org.eclipse.xtext.idea.util.IdeaWidgetFactory;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFacetForm extends GeneratorFacetForm {
  @Extension
  private IdeaWidgetFactory _ideaWidgetFactory = new IdeaWidgetFactory();
  
  private JCheckBox useJavasSourcelevel;
  
  private JCheckBox generateGeneratedAnno;
  
  private JCheckBox generateSuppressWarnAnno;
  
  private JCheckBox ignoreGeneratedJava;
  
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
          return XtendFacetForm.this.useJavasSourcelevel = _checkBox;
        }
      };
      it.row(it, _function);
      final Function1<GridBagConstraints, JComponent> _function_1 = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JCheckBox _checkBox = XtendFacetForm.this._ideaWidgetFactory.checkBox("Generate @SuppressWarnings annotations");
          return XtendFacetForm.this.generateSuppressWarnAnno = _checkBox;
        }
      };
      it.row(it, _function_1);
      final Function1<GridBagConstraints, JComponent> _function_2 = new Function1<GridBagConstraints, JComponent>() {
        @Override
        public JComponent apply(final GridBagConstraints it) {
          JCheckBox _checkBox = XtendFacetForm.this._ideaWidgetFactory.checkBox("Generate @Generated annotations");
          return XtendFacetForm.this.generateGeneratedAnno = _checkBox;
        }
      };
      _xblockexpression = it.row(it, _function_2);
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
          return XtendFacetForm.this.ignoreGeneratedJava = _checkBox;
        }
      };
      _xblockexpression = it.row(it, _function);
    }
    return _xblockexpression;
  }
  
  @Override
  public void setData(final GeneratorConfigurationState data) {
    super.setData(data);
    if ((data instanceof XtendGeneratorConfigurationState)) {
      boolean _isUseJavasSourcelevel = ((XtendGeneratorConfigurationState)data).isUseJavasSourcelevel();
      this.useJavasSourcelevel.setSelected(_isUseJavasSourcelevel);
      boolean _isGenerateGeneratedAnno = ((XtendGeneratorConfigurationState)data).isGenerateGeneratedAnno();
      this.generateGeneratedAnno.setSelected(_isGenerateGeneratedAnno);
      boolean _isGenerateSuppressWarnAnno = ((XtendGeneratorConfigurationState)data).isGenerateSuppressWarnAnno();
      this.generateSuppressWarnAnno.setSelected(_isGenerateSuppressWarnAnno);
      boolean _isIgnoreGeneratedJava = ((XtendGeneratorConfigurationState)data).isIgnoreGeneratedJava();
      this.ignoreGeneratedJava.setSelected(_isIgnoreGeneratedJava);
    }
  }
  
  @Override
  public void getData(final GeneratorConfigurationState data) {
    super.getData(data);
    if ((data instanceof XtendGeneratorConfigurationState)) {
      boolean _isSelected = this.useJavasSourcelevel.isSelected();
      ((XtendGeneratorConfigurationState)data).setUseJavasSourcelevel(_isSelected);
      boolean _isSelected_1 = this.generateGeneratedAnno.isSelected();
      ((XtendGeneratorConfigurationState)data).setGenerateGeneratedAnno(_isSelected_1);
      boolean _isSelected_2 = this.generateSuppressWarnAnno.isSelected();
      ((XtendGeneratorConfigurationState)data).setGenerateSuppressWarnAnno(_isSelected_2);
      boolean _isSelected_3 = this.ignoreGeneratedJava.isSelected();
      ((XtendGeneratorConfigurationState)data).setIgnoreGeneratedJava(_isSelected_3);
    }
  }
  
  @Override
  public boolean isModified(final GeneratorConfigurationState data) {
    boolean _isModified = super.isModified(data);
    boolean _not = (!_isModified);
    if (_not) {
      if ((data instanceof XtendGeneratorConfigurationState)) {
        boolean _isSelected = this.useJavasSourcelevel.isSelected();
        boolean _isUseJavasSourcelevel = ((XtendGeneratorConfigurationState)data).isUseJavasSourcelevel();
        boolean _tripleNotEquals = (Boolean.valueOf(_isSelected) != Boolean.valueOf(_isUseJavasSourcelevel));
        if (_tripleNotEquals) {
          return true;
        }
        boolean _isSelected_1 = this.generateGeneratedAnno.isSelected();
        boolean _isGenerateGeneratedAnno = ((XtendGeneratorConfigurationState)data).isGenerateGeneratedAnno();
        boolean _tripleNotEquals_1 = (Boolean.valueOf(_isSelected_1) != Boolean.valueOf(_isGenerateGeneratedAnno));
        if (_tripleNotEquals_1) {
          return true;
        }
        boolean _isSelected_2 = this.generateSuppressWarnAnno.isSelected();
        boolean _isGenerateSuppressWarnAnno = ((XtendGeneratorConfigurationState)data).isGenerateSuppressWarnAnno();
        boolean _tripleNotEquals_2 = (Boolean.valueOf(_isSelected_2) != Boolean.valueOf(_isGenerateSuppressWarnAnno));
        if (_tripleNotEquals_2) {
          return true;
        }
        boolean _isSelected_3 = this.ignoreGeneratedJava.isSelected();
        boolean _isIgnoreGeneratedJava = ((XtendGeneratorConfigurationState)data).isIgnoreGeneratedJava();
        boolean _tripleNotEquals_3 = (Boolean.valueOf(_isSelected_3) != Boolean.valueOf(_isIgnoreGeneratedJava));
        if (_tripleNotEquals_3) {
          return true;
        }
      }
    }
    return true;
  }
}

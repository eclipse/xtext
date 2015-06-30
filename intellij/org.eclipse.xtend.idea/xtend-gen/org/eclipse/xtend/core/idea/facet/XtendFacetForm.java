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
import org.eclipse.xtext.idea.facet.GeneratorFacetForm;
import org.eclipse.xtext.idea.util.IdeaWidgetFactory;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFacetForm extends GeneratorFacetForm<XtendGeneratorConfigurationState> {
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
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.ui.FacetEditorContext;
import com.intellij.facet.ui.FacetEditorTab;
import com.intellij.facet.ui.FacetValidatorsManager;
import com.intellij.openapi.module.Module;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.idea.facet.GeneratorFacetEditorTab;
import org.eclipse.xtext.xbase.idea.facet.XbaseFacetForm;
import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XbaseFacetConfiguration extends AbstractFacetConfiguration {
  @Override
  public FacetEditorTab[] createEditorTabs(final FacetEditorContext editorContext, final FacetValidatorsManager validatorsManager) {
    Facet _facet = editorContext.getFacet();
    Module _module = _facet.getModule();
    final XbaseFacetForm uiForm = new XbaseFacetForm(_module, validatorsManager);
    Facet _facet_1 = editorContext.getFacet();
    final GeneratorFacetEditorTab<XbaseFacetConfiguration> facetEditorTab = new GeneratorFacetEditorTab<XbaseFacetConfiguration>(_facet_1, uiForm);
    return new FacetEditorTab[] { facetEditorTab };
  }
  
  @Override
  public XbaseGeneratorConfigurationState getState() {
    GeneratorConfigurationState _state = super.getState();
    return ((XbaseGeneratorConfigurationState) _state);
  }
  
  @Override
  protected XbaseGeneratorConfigurationState createNewDefaultState() {
    OutputConfiguration defOutput = this.findDefaultOutputConfiguration();
    return new XbaseGeneratorConfigurationState(defOutput);
  }
  
  public void loadState(final XbaseGeneratorConfigurationState state) {
    super.loadState(state);
  }
}

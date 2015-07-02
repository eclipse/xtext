/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.facet;

import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class AbstractXbaseFacetConfiguration extends AbstractFacetConfiguration {
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

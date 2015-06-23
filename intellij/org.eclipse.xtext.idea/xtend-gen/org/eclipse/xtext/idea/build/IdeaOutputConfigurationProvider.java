/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.intellij.facet.Facet;
import com.intellij.facet.FacetManager;
import com.intellij.facet.FacetTypeId;
import com.intellij.openapi.module.Module;
import java.util.Set;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaOutputConfigurationProvider implements IContextualOutputConfigurationProvider {
  @Inject(optional = true)
  private AbstractFacetType<AbstractFacetConfiguration> languageFacet;
  
  public final static String TEST_OUTPUT = "TEST_OUTPUT";
  
  /**
   * TODO need a delegate to default output configs
   */
  @Override
  public Set<OutputConfiguration> getOutputConfigurations(final Resource context) {
    boolean _equals = Objects.equal(this.languageFacet, null);
    if (_equals) {
      return Sets.<OutputConfiguration>newHashSet();
    }
    ResourceSet _resourceSet = context.getResourceSet();
    final Object module = ((XtextResourceSet) _resourceSet).getClasspathURIContext();
    if ((module instanceof Module)) {
      FacetManager _instance = FacetManager.getInstance(((Module)module));
      FacetTypeId<Facet<AbstractFacetConfiguration>> _id = this.languageFacet.getId();
      final Facet<AbstractFacetConfiguration> facet = _instance.<Facet<AbstractFacetConfiguration>>getFacetByType(_id);
      AbstractFacetConfiguration _configuration = facet.getConfiguration();
      final GeneratorConfigurationState generatorConf = _configuration.getState();
      final OutputConfiguration defOut = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
      String _outputDirectory = generatorConf.getOutputDirectory();
      defOut.setOutputDirectory(_outputDirectory);
      final OutputConfiguration testOut = new OutputConfiguration(IdeaOutputConfigurationProvider.TEST_OUTPUT);
      String _testOutputDirectory = generatorConf.getTestOutputDirectory();
      testOut.setOutputDirectory(_testOutputDirectory);
      return Sets.<OutputConfiguration>newHashSet(defOut, testOut);
    }
    return Sets.<OutputConfiguration>newHashSet();
  }
}

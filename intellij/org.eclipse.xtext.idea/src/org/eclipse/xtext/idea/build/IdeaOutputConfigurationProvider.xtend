/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build

import com.google.common.collect.Sets
import com.google.inject.Inject
import com.intellij.facet.FacetManager
import com.intellij.openapi.module.Module
import java.util.Set
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider
import org.eclipse.xtext.generator.OutputConfiguration
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration
import org.eclipse.xtext.idea.facet.AbstractFacetType
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.generator.IFileSystemAccess

/**
 * @author dhuebner - Initial contribution and API
 */
class IdeaOutputConfigurationProvider implements IContextualOutputConfigurationProvider {

	@Inject(optional=true) AbstractFacetType<AbstractFacetConfiguration> languageFacet

	public final static String TEST_OUTPUT = "TEST_OUTPUT"
	
	/*TODO need a delegate to default output configs*/
	override Set<OutputConfiguration> getOutputConfigurations(Resource context) {
		if (languageFacet == null) {
			return Sets.newHashSet
		}
		val module = (context.resourceSet as XtextResourceSet).classpathURIContext
		if (module instanceof Module) {
			val facet = FacetManager.getInstance(module).getFacetByType(languageFacet.id)
			val generatorConf = facet.configuration.state
			val defOut = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT)
			defOut.outputDirectory = generatorConf.outputDirectory
			val testOut = new OutputConfiguration(TEST_OUTPUT)
			testOut.outputDirectory = generatorConf.testOutputDirectory
			return Sets.newHashSet(defOut, testOut)
		}
		return Sets.newHashSet
	}

}
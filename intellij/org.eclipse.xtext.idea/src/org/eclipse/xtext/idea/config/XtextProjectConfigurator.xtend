/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.config

import com.intellij.facet.FacetManager
import com.intellij.facet.FacetTypeRegistry
import com.intellij.openapi.module.Module
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration
import org.eclipse.xtext.idea.facet.AbstractFacetType

/**
 * @author dhuebner - Initial contribution and API
 */
class XtextProjectConfigurator {

	def AbstractFacetConfiguration createOrGetFacetConf(Module module, String id) {
		val facetType = FacetTypeRegistry.getInstance().findFacetType(id)
		if (!(facetType instanceof AbstractFacetType<?>)) {
			return null
		}
		val mnr = FacetManager.getInstance(module)
		var facet = mnr.findFacet(facetType.id, facetType.defaultFacetName) ?:
			FacetManager.getInstance(module).addFacet(facetType, facetType.defaultFacetName, null)
		return facet.configuration as AbstractFacetConfiguration
	}
}
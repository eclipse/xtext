/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.sdomain.idea.facet

import com.intellij.facet.Facet
import com.intellij.facet.FacetType
import com.intellij.openapi.module.Module

/**
 * @author dhuebner - Initial contribution and API
 */
class SDomainFacet extends Facet<SDomainFacetConfiguration> {

	new(FacetType<SDomainFacet, SDomainFacetConfiguration> facetType, Module module, String name,
		SDomainFacetConfiguration configuration, Facet<SDomainFacetConfiguration> underlyingFacet) {
		super(facetType, module, name, configuration, underlyingFacet)
	}

}

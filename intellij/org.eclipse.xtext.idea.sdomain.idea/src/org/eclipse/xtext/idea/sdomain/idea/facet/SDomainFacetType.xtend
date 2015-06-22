/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.sdomain.idea.facet

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.facet.Facet
import com.intellij.facet.FacetTypeId
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration
import org.eclipse.xtext.idea.facet.AbstractFacetType
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage

/**
 * @author dhuebner - Initial contribution and API
 */
class SDomainFacetType extends AbstractFacetType<AbstractFacetConfiguration> {
	static val TYPE_ID_STRING = "sdomain"
	public static val TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);
	@Inject Provider<AbstractFacetConfiguration> facetConfiguration

	new() {
		super(SDomainFacetType.TYPEID, TYPE_ID_STRING, "SDomain");
		SDomainLanguage.INSTANCE.injectMembers(this)
	}

	override createDefaultConfiguration() {
		// TODO load defaults
		return facetConfiguration.get();
	}

}

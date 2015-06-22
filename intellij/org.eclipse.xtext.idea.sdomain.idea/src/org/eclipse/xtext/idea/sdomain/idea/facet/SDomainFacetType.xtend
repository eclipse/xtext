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
import com.intellij.facet.FacetTypeId
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import org.eclipse.xtext.idea.Icons

/**
 * @author dhuebner - Initial contribution and API
 */
class SDomainFacetType extends FacetType<SDomainFacet, SDomainFacetConfiguration> {
	static val TYPE_ID_STRING = "sdomain"
	public static val TYPEID = new FacetTypeId<SDomainFacet>(TYPE_ID_STRING);

	new() {
		super(SDomainFacetType.TYPEID, TYPE_ID_STRING, "SDomain", null);
	}

	override createDefaultConfiguration() {
		return new SDomainFacetConfiguration();
	}

	override createFacet(Module module, String name, SDomainFacetConfiguration configuration, Facet underlyingFacet) {
		return new SDomainFacet(this, module, name, configuration, underlyingFacet)
	}

	override isSuitableModuleType(ModuleType moduleType) {
		true
	}

	override getIcon() {
		return Icons.DSL_FILE_TYPE
	}

}

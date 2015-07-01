/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.facet;

import com.google.inject.Inject;
import com.intellij.facet.Facet;
import com.intellij.facet.FacetManager;
import com.intellij.facet.FacetTypeId;
import com.intellij.openapi.module.Module;

/**
 * @author dhuebner - Initial contribution and API
 */
public class FacetProvider {
	@SuppressWarnings("rawtypes")
	@Inject FacetTypeId typeId;
	
	@SuppressWarnings("unchecked")
	public Facet<? extends AbstractFacetConfiguration> getFacet(Module module) {
		return FacetManager.getInstance(module).getFacetByType(typeId);
	}
}

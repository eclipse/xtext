/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.facet;

import javax.swing.Icon;

import org.eclipse.xtext.idea.Icons;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.facet.Facet;
import com.intellij.facet.FacetConfiguration;
import com.intellij.facet.FacetType;
import com.intellij.facet.FacetTypeId;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;

/**
 * @author dhuebner - Initial contribution and API
 */
public abstract class AbstractFacetType<C extends FacetConfiguration> extends FacetType<Facet<C>, C> {
	private @Inject Provider<C> facetConfiguration;

	public AbstractFacetType(FacetTypeId<Facet<C>> id, String stringId, String presentableName) {
		super(id, stringId, presentableName);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Facet<C> createFacet(Module module, String name, C configuration, Facet underlyingFacet) {
		return new Facet<C>(this, module, name, configuration, underlyingFacet);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean isSuitableModuleType(ModuleType moduleType) {
		return true;
	}

	@Override
	public C createDefaultConfiguration() {
		return facetConfiguration.get();
	}

	@Override
	public Icon getIcon() {
		return Icons.DSL_FILE_TYPE;
	}
}

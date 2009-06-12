/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class FragmentFakingEcoreResourceFactoryImpl extends EcoreResourceFactoryImpl {
	
	private final ResourceSaveIndicator isSaving;
	
	public static final String ECORE_SUFFIX = "ecore";
	
	public FragmentFakingEcoreResourceFactoryImpl(ResourceSaveIndicator isSaving) {
		this.isSaving = isSaving;
	}

	@Override
	public Resource createResource(URI uri) {
		FragmentFakingEcoreResource result = new FragmentFakingEcoreResource(uri, isSaving);
	    return result;
	}

}
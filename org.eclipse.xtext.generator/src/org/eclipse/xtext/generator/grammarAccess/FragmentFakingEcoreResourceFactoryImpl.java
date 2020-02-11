/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
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
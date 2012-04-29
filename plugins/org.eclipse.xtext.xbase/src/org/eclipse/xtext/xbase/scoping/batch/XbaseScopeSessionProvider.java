/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmType;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @TODO Javadoc
 */
public class XbaseScopeSessionProvider {

	@Inject
	private IFeatureScopeSession rootSession;
	
	@Inject
	private ImplicitlyImportedTypes implicitlyImportedTypes;
	
	public IFeatureScopeSession withContext(Resource context) {
		List<JvmType> literalClasses = implicitlyImportedTypes.getLiteralClasses(context);
		List<JvmType> extensionClasses = implicitlyImportedTypes.getExtensionClasses(context);
		return rootSession.addTypesToStaticScope(literalClasses, extensionClasses);
	}
	
}

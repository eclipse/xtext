/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.ecore;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NsURIQualifiedNameProvider extends EcoreQualifiedNameProvider {

	@Override
	protected String name(EPackage ePackage) {
		return ePackage.getNsURI();
	}

	@Override
	protected String getCacheKey() {
		return "nsURIfqn";
	}
	
	@Override
	protected boolean isRecurseParent(EObject obj) {
		return !(obj instanceof EPackage) && super.isRecurseParent(obj);
	}
}

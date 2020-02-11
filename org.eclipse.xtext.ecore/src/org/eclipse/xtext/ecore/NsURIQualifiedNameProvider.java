/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ecore;

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

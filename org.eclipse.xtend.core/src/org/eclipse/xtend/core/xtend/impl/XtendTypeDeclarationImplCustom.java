/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.xtend.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtendTypeDeclarationImplCustom extends XtendTypeDeclarationImpl {

	@Override 
	public boolean isAnonymous() {
		return false;
	}
	
	@Override
	public boolean isLocal() {
		EObject container = eContainer();
		if (container instanceof XtendMember && !(container instanceof XtendTypeDeclaration)) {
			return !isAnonymous();
		}
		return false;
	}
	
}

/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
		return name == null;
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

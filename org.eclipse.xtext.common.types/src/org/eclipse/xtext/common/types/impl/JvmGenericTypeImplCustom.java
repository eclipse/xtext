/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmTypeParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmGenericTypeImplCustom extends JvmGenericTypeImpl {
	
	@Override
	public boolean isInstantiateable() {
		return !isAbstract() && !isInterface();
	}

	// late initialization
	
	@Override
	public EList<JvmTypeParameter> getTypeParameters() {
		checkPendingInitialization();
		return super.getTypeParameters();
	}
	
	@Override
	public boolean isStrictFloatingPoint() {
		checkPendingInitialization();
		return super.isStrictFloatingPoint();
	}
	
	@Override
	public boolean isAnonymous() {
		checkPendingInitialization();
		return super.isAnonymous();
	}
}

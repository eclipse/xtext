/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

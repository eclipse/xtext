/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtype.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmReferenceTypeArgument;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XFunctionTypeRefImplCustom extends XFunctionTypeRefImpl {
	
	private final static BasicEList.UnmodifiableEList<JvmTypeReference> empty = new BasicEList.UnmodifiableEList<JvmTypeReference>(0,null);
	
	@Override
	public EList<JvmTypeReference> getParamTypes() {
		int numberOfArguments = getArguments().size()-1;
		if (numberOfArguments==0) {
			return empty;
		}
		JvmTypeReference[] args = new JvmTypeReference[numberOfArguments];
		for (int i = 0; i < args.length; i++) {
			args[i] = ((JvmReferenceTypeArgument)getArguments().get(i)).getTypeReference();
		}
		return new BasicEList.UnmodifiableEList<JvmTypeReference>(numberOfArguments, args);
	}
	
	@Override
	public JvmTypeReference getReturnType() {
		return ((JvmReferenceTypeArgument)getArguments().get(getArguments().size()-1)).getTypeReference();
	}
}

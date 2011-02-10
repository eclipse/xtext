/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtype.impl;

import static com.google.common.collect.Lists.*;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.Functions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XFunctionTypeRefImplCustom extends XFunctionTypeRefImpl {
	
	@Override
	public JvmType getType() {
		if (this.type == null) {
			// make sure scoping has taken place and installed an IJvmTypeProvider
			getReturnType().getType();
			type = TypesFactory.eINSTANCE.createJvmVoid();
			((InternalEObject)type).eSetProxyURI(computeTypeUri());
		}
		return super.getType();
	}
	
	@Override
	public EList<JvmTypeReference> getArguments() {
		ArrayList<JvmTypeReference> list = newArrayList(getParamTypes());
		list.add(getReturnType());
		BasicInternalEList<JvmTypeReference> ref = new BasicInternalEList<JvmTypeReference>(JvmTypeReference.class, list);
		return ref;
	}

	protected URI computeTypeUri() {
		return URI.createURI("java:/Objects/"+Functions.class.getCanonicalName()+"#"+Functions.class.getCanonicalName()+"$Function"+getParamTypes().size());
	}
	
	@Override
	public String getCanonicalName() {
		StringBuilder result = new StringBuilder("(");
		for (int i = 0;i< getParamTypes().size();i++) {
			JvmTypeReference reference = getParamTypes().get(i);
			result.append(reference.getCanonicalName());
			if (i<getParamTypes().size()-1)
				result.append(", ");
		}
		result.append(") => ");
		if (getReturnType()!=null)
			result.append(getReturnType().getCanonicalName());
		return result.toString();
	}
}

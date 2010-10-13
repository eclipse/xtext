/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CallableFeaturePredicate {
	
	private PolymorphicDispatcher<Boolean> dispatcher = new PolymorphicDispatcher<Boolean>("_case",3,3,Collections.singletonList(this));
	
	public boolean accept(EObject input, EObject context, JvmTypeReference thisVarType) {
		return internalDispatch(input,context,thisVarType);
	}
	
	protected boolean internalDispatch(EObject input, EObject context, JvmTypeReference thisVarType) {
		return dispatcher.invoke(input,context,thisVarType);
	}
	
	protected boolean _case(Object input, Object call, Object v) {
		return false;
	}
	
	protected boolean _case(XVariableDeclaration input, XFeatureCall call, Void v) {
		return true;
	}
	
	protected boolean _case(JvmFormalParameter param, XFeatureCall call, Void v) {
		return true;
	}
	
	protected boolean _case(JvmField input, XAbstractFeatureCall call, Void v) {
		return call.getArguments().size()==1;
	}
	
	protected boolean _case(JvmField input, XAbstractFeatureCall call, JvmTypeReference thisVarType) {
		return call.getArguments().size()==0;
	}
	
	protected boolean _case(JvmOperation input, XAbstractFeatureCall call, Void v) {
		return call.getArguments().size()-1 == input.getParameters().size();
	}
	
	protected boolean _case(JvmOperation input, XAbstractFeatureCall call, JvmTypeReference thisVarType) {
		return call.getArguments().size() == input.getParameters().size();
	}
	
}

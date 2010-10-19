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
 * <p>
 * Checks whether a given {@link org.eclipse.xtext.common.types.JvmIdentifyableElement}
 * can possibly be called by a given {@link XAbstractFeatureCall}.
 * </p>
 * <p>
 *  Note that the {@link XAbstractFeatureCall} not neccessarily needs to be complete.
 *  Any guards for any missing information should be skipped. This ensures, that this predicate
 *  can also be used in the context of content assist.
 * </p>
 * <p>
 *  Taken from section <a href="http://java.sun.com/docs/books/jls/third_edition/html/expressions.html#316811">15.12.2.1 Identify Potentially Applicable Methods</a>
 *  of the Java Language Specification, the following rules are applied:</p>
 *  <ol>
 *  <li>The arity of the member is lesser or equal to the arity of the method invocation.</li>
 *  <li>If the member is a variable arity method with arity n, the arity of the method invocation is greater or equal to n-1.</li>
 *  <li>If the member is a fixed arity method with arity n, the arity of the method invocation is equal to n.</li>
 *  <li>If the method invocation includes explicit type parameters, and the member is a generic method, then the number of actual type parameters is equal to the number of formal type parameters.</li>
 *  </ol>
 *  
 * @author Sven Efftinge
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

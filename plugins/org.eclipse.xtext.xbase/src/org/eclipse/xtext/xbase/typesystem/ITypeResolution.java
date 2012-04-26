/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;

/**
 * A type resolution allows to query the types of given expressions. Furthermore 
 * it encapsulates the issues that occurred during type resolution.
 * 
 * TODO JavaDoc, toString
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITypeResolution {

	List<Diagnostic> getQueuedDiagnostics();
	
	JvmTypeReference getActualType(XExpression expression);
	
	JvmTypeReference getExpectedType(XExpression expression);
	
	/**
	 * @param expression may either be an {@link XAbstractFeatureCall} or {@link XConstructorCall}. May not be <code>null</code>. 
	 */
	List<JvmTypeReference> getActualTypeArguments(XExpression expression);

	// TODO return types? are they necessary for clients if diagnostics were already produced?
	
	ITypeResolution NULL = new ITypeResolution() {
		
		public List<Diagnostic> getQueuedDiagnostics() {
			return Collections.emptyList();
		}
		
		public JvmTypeReference getExpectedType(XExpression expression) {
			return null;
		}
		
		public List<JvmTypeReference> getActualTypeArguments(XExpression expression) {
			return Collections.emptyList();
		}
		
		public JvmTypeReference getActualType(XExpression expression) {
			return null;
		}
	};
	
}

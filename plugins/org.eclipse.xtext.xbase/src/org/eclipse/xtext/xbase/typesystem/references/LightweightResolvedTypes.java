/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO toString, null annotations, JAvadoc
 */
public interface LightweightResolvedTypes extends IResolvedTypes {

	List<Diagnostic> getQueuedDiagnostics();
	
	LightweightTypeReference internalGetActualType(XExpression expression);
	
	LightweightTypeReference internalGetActualType(JvmIdentifiableElement identifiable);
	
	LightweightTypeReference internalGetExpectedType(XExpression expression);
	
	/**
	 * @param expression may either be an {@link XAbstractFeatureCall} or {@link XConstructorCall}. May not be <code>null</code>. 
	 */
	List<LightweightTypeReference> internalGetActualTypeArguments(XExpression expression);
	
	LightweightResolvedTypes NULL = new LightweightResolvedTypes() {
		
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

		public JvmTypeReference getActualType(JvmIdentifiableElement identifiable) {
			return null;
		}

		public LightweightTypeReference internalGetActualType(XExpression expression) {
			return null;
		}

		public LightweightTypeReference internalGetActualType(JvmIdentifiableElement identifiable) {
			return null;
		}

		public LightweightTypeReference internalGetExpectedType(XExpression expression) {
			return null;
		}

		public List<LightweightTypeReference> internalGetActualTypeArguments(XExpression expression) {
			return null;
		}
	};
}

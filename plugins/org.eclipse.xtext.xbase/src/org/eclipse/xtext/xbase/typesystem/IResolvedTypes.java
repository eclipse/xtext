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
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * Resolved types represent the result of the type resolution.
 * They offer a means to query for actual types, expectations, 
 * the type arguments for a feature call or the diagnostics that
 * were produced during the type resolution.
 * 
 * TODO JavaDoc, describe contract for toString
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public interface IResolvedTypes {

	/* 
	 * TODO find a suitable abstraction to represent diagnostics
	 * It's cumbersome to use Issues since they only know about URIs 
	 * so we probably want to use Diagnostics?
	 */
	List<Diagnostic> getQueuedDiagnostics();
	
	/**
	 * Returns the actually inferred type for the given expression or <code>null</code> if none.
	 * @param expression expression whose type is queried.
	 */
	@Nullable
	LightweightTypeReference getActualType(XExpression expression);
	
	/**
	 * Returns the actually inferred return type for the given expression or <code>null</code> if none.
	 * @param expression expression whose return type is queried.
	 */
	@Nullable
	LightweightTypeReference getReturnType(XExpression expression);
	
	/**
	 * Returns the actually inferred or declared type for the given identifiable or <code>null</code> if none.
	 * @param identifiable identifiable whose type is queried.
	 */
	@Nullable
	LightweightTypeReference getActualType(JvmIdentifiableElement identifiable);
	
	/**
	 * Returns the actually expected type for the given expression or <code>null</code> if none.
	 * @param expression expression whose expected type is queried.
	 */
	@Nullable
	LightweightTypeReference getExpectedType(XExpression expression);
	
	/**
	 * @param expression may either be an {@link XAbstractFeatureCall} or {@link XConstructorCall}. May not be <code>null</code>. 
	 */
	List<LightweightTypeReference> getActualTypeArguments(XExpression expression);

	// TODO return types? are they necessary for clients if diagnostics were already produced?
	
	IResolvedTypes NULL = new NullResolvedTypes();

	/**
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 */
	class NullResolvedTypes implements IResolvedTypes {
		
		protected NullResolvedTypes() {
		}
		
		public List<Diagnostic> getQueuedDiagnostics() {
			return Collections.emptyList();
		}
		
		@Nullable
		public LightweightTypeReference getExpectedType(XExpression expression) {
			return null;
		}
		
		public List<LightweightTypeReference> getActualTypeArguments(XExpression expression) {
			return Collections.emptyList();
		}
		
		@Nullable
		public LightweightTypeReference getActualType(XExpression expression) {
			return null;
		}
		
		@Nullable
		public LightweightTypeReference getReturnType(XExpression expression) {
			return null;
		}

		@Nullable
		public LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
			return null;
		}
	}
	
}

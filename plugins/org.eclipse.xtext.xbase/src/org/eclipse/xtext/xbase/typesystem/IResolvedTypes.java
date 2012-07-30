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
@NonNullByDefault
public interface IResolvedTypes {

	List<Diagnostic> getQueuedDiagnostics();
	
	@Nullable
	JvmTypeReference getActualType(XExpression expression);
	
	@Nullable
	JvmTypeReference getActualType(JvmIdentifiableElement identifiable);
	
	@Nullable
	JvmTypeReference getExpectedType(XExpression expression);
	
	/**
	 * @param expression may either be an {@link XAbstractFeatureCall} or {@link XConstructorCall}. May not be <code>null</code>. 
	 */
	List<JvmTypeReference> getActualTypeArguments(XExpression expression);

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
		public JvmTypeReference getExpectedType(XExpression expression) {
			return null;
		}
		
		public List<JvmTypeReference> getActualTypeArguments(XExpression expression) {
			return Collections.emptyList();
		}
		
		@Nullable
		public JvmTypeReference getActualType(XExpression expression) {
			return null;
		}

		@Nullable
		public JvmTypeReference getActualType(JvmIdentifiableElement identifiable) {
			return null;
		}
	}
	
}

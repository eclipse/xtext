/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * Represents the function ASTNode -> Type, which is the main concept of a type system. 
 */
public interface ITypeProvider<T> {

	/**
	 * computes the type of the given astNode.
	 * @param astNode - the node for which to compute the type T
	 * @param context - the context information may be null
	 * 
	 * @return the type T or null. <code>null</code> indicates a problem with type resolution. 
	 * 		   Clients shouldn't register follow up errors in that case.
	 */
	public T getType(EObject astNode, Context<T> context);
	
	public static class Context<T> implements ValidationMessageAcceptor{
		
		public static <T> Context<T> newCtx() {
			return newCtx(null,ValidationMessageAcceptor.NULL);
		}
		public static <T> Context<T> newCtx(ValidationMessageAcceptor acceptor) {
			return newCtx(null,acceptor);
		}
		public static <T> Context<T> newCtx(T expectedType, ValidationMessageAcceptor acceptor) {
			return new Context<T>(null,acceptor);
		}
		
		private T expectedType;
		private ValidationMessageAcceptor acceptor;
		
		public Context(T expectedType, ValidationMessageAcceptor messageAcceptor) {
			this.expectedType = expectedType;
			this.acceptor = messageAcceptor;
		}
		
		public void acceptError(String message, EObject object, Integer feature, String code, String... issueData) {
			this.acceptor.acceptError(message, object, feature, code, issueData);
		}
		public void acceptWarning(String message, EObject object, Integer feature, String code, String... issueData) {
			this.acceptor.acceptWarning(message, object, feature, code, issueData);
		}
		
		public T getExpectedType() {
			return expectedType;
		}
	}
}

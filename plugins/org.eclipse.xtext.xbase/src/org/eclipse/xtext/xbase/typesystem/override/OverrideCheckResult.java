/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.EnumSet;

import org.eclipse.xtext.common.types.JvmOperation;

/**
 * The result of a check for a method override relationship.
 * 
 * @see IResolvedOperation#isOverridingOrImplementing(JvmOperation)
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface OverrideCheckResult {
	/**
	 * Returns <code>true</code> if the current operation successfully
	 * overrides or implements the given operation.
	 */
	boolean isValid();
	/**
	 * Returns <code>true</code> if there are problems in the checked method
	 * hierarchy, e.g. the return type needs unchecked conversion.
	 */
	boolean hasProblems();
	/**
	 * Obtain details on the override check.
	 */
	EnumSet<OverrideCheckResult.OverrideCheckDetails> getDetails();
	
	/**
	 * The overriding candidate.
	 */
	IResolvedOperation getThisOperation();
	
	/**
	 * The checked operation.
	 */
	JvmOperation getGivenOperation();
	
	enum OverrideCheckDetails {
		/**
		 * The resolved operation represents the given operation.
		 */
		CURRENT,
		/**
		 * The given operation is strictly overridden, e.g. parameter types,
		 * type parameters and return type are identical and the given operation
		 * is concrete and overridden by this operation.
		 */
		OVERRIDE,
		/**
		 * The given operation is strictly implemented, e.g. parameter types,
		 * type parameters and return type are identical and the given operation
		 * is abstract and implemented by this operation.
		 */
		IMPLEMENTATION,
		/**
		 * The given operation is redeclared, e.g. parameter types,
		 * type parameters and return type are identical but this operation
		 * is abstract and the given operation is concrete.
		 */
		REDECLARATION,
		/**
		 * The given operation is repeated, e.g. parameter types,
		 * type parameters and return type are identical. This operation and the given
		 * operation are abstract.
		 */
		REPEATED,
		/**
		 * The given operation declares different type parameters than this operation. 
		 */
		TYPE_PARAMETER_MISMATCH,
		/**
		 * This operation overrides the given operation but the return type requires
		 * an unchecked conversion. 
		 */
		UNCHECKED_CONVERSION_REQUIRED,
		/**
		 * This operation declares exceptions that are not declared by the given methods.
		 */
		EXCEPTION_MISMATCH,
		/**
		 * The name or the arity of the given operation does not match this operation.
		 */
		NAME_OR_ARITY_MISMATCH,
		/**
		 * The parameter types of the given method do not match this method.
		 */
		PARAMETER_TYPE_MISMATCH,
		/**
		 * The given operation has the same erasure on the parameter types but
		 * is not overridden by this operation.
		 */
		SAME_ERASURE,
		/**
		 * The return types do not match.
		 */
		RETURN_MISMATCH,
		/**
		 * The given operation is overridden by this operation and the return type is specialized
		 * by this operation.
		 */
		COVARIANT_RETURN,
		/**
		 * The current method seems to override the given method, but that one is not visible (e.g.
		 * it is private or package private and in another package).
		 */
		NOT_VISIBLE,
		/**
		 * The current method seems to override the given method but that one is final and cannot be overridden.
		 */
		IS_FINAL,
		/**
		 * The current method seems to override the given method but attempts to reduce its visibility.
		 */
		REDUCED_VISIBILITY,
		/**
		 * Attempt to override a static operation.
		 */
		OPERATION_IS_STATIC
	}
}
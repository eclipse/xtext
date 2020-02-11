/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

import org.eclipse.xtext.common.types.JvmOperation;

/**
 * The result of a check for a method override relationship.
 * 
 * @see IResolvedOperation#isOverridingOrImplementing(JvmOperation)
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IOverrideCheckResult {
	/**
	 * Returns <code>true</code> if the current operation successfully overrides or implements the given operation.
	 * Override state that is considered to be valid is:
	 * <ul>
	 *   <li>{@link org.eclipse.xtext.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails#IMPLEMENTATION implementation}</li>
	 *   <li>{@link org.eclipse.xtext.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails#OVERRIDE override}</li>
	 *   <li>{@link org.eclipse.xtext.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails#REDECLARATION re-declaration}</li>
	 *   <li>{@link org.eclipse.xtext.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails#REPEATED repeating}</li>
	 *   <li>{@link org.eclipse.xtext.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails#SHADOWED shadowing}</li>
	 * </ul>
	 */
	boolean isOverridingOrImplementing();
	
	/**
	 * Returns <code>true</code> if there are problems in the checked method hierarchy, e.g. the return type needs
	 * unchecked conversion.
	 */
	boolean hasProblems();

	/**
	 * Obtain details on the override check.
	 */
	EnumSet<IOverrideCheckResult.OverrideCheckDetails> getDetails();

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
		 * The given operation is strictly overridden, e.g. parameter types, type parameters and return type are
		 * identical and the given operation is concrete and overridden by this operation.
		 */
		OVERRIDE,
		/**
		 * The given operation is strictly implemented, e.g. parameter types, type parameters and return type are
		 * identical and the given operation is abstract and implemented by this operation.
		 */
		IMPLEMENTATION,
		/**
		 * The given operation is redeclared, e.g. parameter types, type parameters and return type are identical but
		 * this operation is abstract and the given operation is concrete.
		 * 
		 * Example: {@link Collection#equals(Object)} redeclares {@link Object#equals(Object)} or <code>B#m</code>
		 * redeclares <code>A#m</code> in the following example.
		 * 
		 * <pre>
		 * class A {
		 * 	void m() {
		 * 	}
		 * }
		 * 
		 * abstract class B extends A {
		 * 	abstract void m();
		 * }
		 * </pre>
		 * 
		 */
		REDECLARATION,
		/**
		 * The given operation is repeated, e.g. parameter types, type parameters and return type are identical. This
		 * operation and the given operation are abstract or this operation is defined in an interface and the given
		 * operation is concrete.
		 * 
		 * Example: {@link List#equals(Object)} repeats {@link Collection#equals(Object)}.
		 */
		REPEATED,
		/**
		 * This method is static and shadows another static method from the super class
		 */
		SHADOWED,
		/**
		 * The given operation declares different type parameters than this operation.
		 */
		TYPE_PARAMETER_MISMATCH,
		/**
		 * This operation overrides the given operation but the return type requires an unchecked conversion.
		 */
		UNCHECKED_CONVERSION_REQUIRED,
		/**
		 * This operation declares exceptions that are not declared by the given methods.
		 */
		EXCEPTION_MISMATCH,
		/**
		 * The name of the given operation does not match this operation.
		 */
		NAME_MISMATCH,
		/**
		 * The arity of the given operation does not match this operation.
		 */
		ARITY_MISMATCH,
		/**
		 * The parameter types of the given method do not match this method.
		 */
		PARAMETER_TYPE_MISMATCH,
		/**
		 * The given operation has the same erasure on the parameter types but is not overridden by this operation.
		 */
		SAME_ERASURE,
		/**
		 * The return types do not match.
		 */
		RETURN_MISMATCH,
		/**
		 * The given operation is overridden by this operation and the return type is specialized by this operation.
		 */
		COVARIANT_RETURN,
		/**
		 * The current method seems to override the given method, but that one is not visible (e.g. it is private or
		 * package private and in another package).
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
		 * Attempt to override a static operation with an instance method or vice versa
		 */
		STATIC_MISMATCH,
		/**
		 * No inheritance relation between this operation and the given operation.
		 */
		NO_INHERITANCE,
		/**
		 * Both operations are declared in the very same type thus it can't be an override relationship.
		 */
		SAME_DECLARATOR,
		/**
		 * Attempt to override a var arg method with a non var arg method or vice versa.
		 * 
		 * <pre>
		 * class A {
		 * 	void m(String... s) {}
		 * }
		 * 
		 * class B extends A {
		 * 	&#064;Override
		 * 	void m(String[] s) {}
		 * }
		 * </pre>
		 * 
		 * Should yield the message <code>Varargs methods should only override or be overridden by other varargs methods unlike
		 * B.m(String[]) and A.m(String...)</code>
		 */
		VAR_ARG_MISMATCH,
		/**
		 * The operations are declared in different interfaces that do not extend each other, their type erasure is equal,
		 * and at least one of them is not abstract, i.e. it has a default implementation (Java 8).
		 */
		DEFAULT_IMPL_CONFLICT,
		/**
		 * The overriding operation is not <code>synchronized</code> although the overridden is.
		 */
		SYNCHRONIZED_MISMATCH
		;
	}

}

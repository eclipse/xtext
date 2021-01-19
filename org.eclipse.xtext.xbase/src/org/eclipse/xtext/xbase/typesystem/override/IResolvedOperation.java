/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * Resolved representation of a {@link JvmOperation}.
 * 
 * Parameter types, return type, declared exceptions and type arguments are put into the context of a specific declaring
 * reference, e.g. {@link List#add(Object) List#add(Object)} becomes <code>List#add(String)</code> in the context of an
 * {@link ArrayList ArrayList&lt;String&gt;}
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IResolvedOperation extends IResolvedExecutable {

	/**
	 * Returns overridden and implemented methods for this method.
	 * 
	 * Example:
	 * 
	 * <pre>
	 * interface I {
	 *   void method()
	 * }
	 * abstract class C {
	 *   abstract void method()
	 * }
	 * class D extends C implements I {
	 *   void method() {}
	 * }
	 * </pre>
	 * 
	 * The resolved representation of <code>D#method</code> will return a list with two elements:
	 * <code>C#method, I#method</code>. The first element in the list is always the overridden implementation or the
	 * inherited abstract method from the superclass, if any. Thus the list is sorted. The elements in the list are not
	 * transitively collected.
	 * 
	 * <pre>
	 * interface I1 {
	 *   void method()
	 * }
	 * interface I2 {
	 *   void method()
	 * }
	 * interface I3 extends I1, I2 {
	 * }
	 * interface I4 {
	 *   void method()
	 * }
	 * interface I5 extends I4 {
	 *   void method()
	 * }
	 * class C implements I5, I3 {
	 *   void method()
	 * }
	 * </pre>
	 * 
	 * The list of resolved inherited methods for <code>C#method</code> will be
	 * <code>I1#method, I2#method, I5#method</code> thus it will not contain and of <code>I4#method</code>.
	 * 
	 * Only methods that would be successfully checked for {@link #isOverridingOrImplementing(JvmOperation)} will be
	 * returned.
	 * 
	 * @see #getOverriddenAndImplementedMethodCandidates()
	 * @return a list of overridden and implemented methods.
	 */
	List<IResolvedOperation> getOverriddenAndImplementedMethods();

	/*
	 * Note: the behavior for ambiguous super methods was observed from JDT UI.
	 * super invocation in B#m like
	 * void m(String s) {
	 *   super.m(s);
	 * }
	 * needs to be validated as ambiguous.
	 */
	/**
	 * Returns the overridden method, if any.
	 * 
	 * A candidate is considered to be the overridden method if this method itself is not abstract, the candidate is
	 * contained in the list of {@link #getOverriddenAndImplementedMethods() overridden and implemented methods}, and
	 * the candidate is not abstract.
	 * 
	 * It may happen that two methods are overridden, e.g.
	 * 
	 * <pre>
	 * class A&lt;T&gt; {
	 * 	void m(T t) {
	 * 	}
	 * 
	 * 	void m(String s) {
	 * 	}
	 * }
	 * 
	 * class B extends A&lt;String&gt; {
	 * 	&#064;Override
	 * 	void m(String s) {
	 * 	}
	 * }
	 * </pre>
	 * 
	 * In that case, the first match is returned thus it depends on the order in the super type.
	 * 
	 * @see #getOverriddenAndImplementedMethods()
	 * @return a super implementation or <code>null</code> if none.
	 */
	/* @Nullable */
	IResolvedOperation getOverriddenMethod();

	/**
	 * Returns the inherited methods with the same simple name as this method.
	 * 
	 * @see #getOverriddenAndImplementedMethods()
	 * @see #isOverridingOrImplementing(JvmOperation)
	 * @return a list of methods with the same simple name.
	 */
	List<JvmOperation> getOverriddenAndImplementedMethodCandidates();

	/**
	 * Transitively check whether this operation if implementing or overriding the given operation.
	 * 
	 * @return the check result.
	 */
	IOverrideCheckResult isOverridingOrImplementing(JvmOperation operation);

	/**
	 * The override check result that is associated with this operation. If this is a {@link #isBottomInContext()
	 * bottom}, the {@link IOverrideCheckResult#getDetails() details} will only include the
	 * {@link org.eclipse.xtext.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails#CURRENT current}
	 * detail. In other cases, the actual information about the relationship of the hierarchy function to its
	 * specialization in the {@link IResolvedExecutable#getContextType() context} is returned.
	 * 
	 * @return the computed check result
	 */
	IOverrideCheckResult getOverrideCheckResult();
	
	/**
	 * Returns the list of exceptions that are declared in this operation
	 * but do not match the super implementation.
	 * @return the list of illegally declared exceptions.
	 */
	List<LightweightTypeReference> getIllegallyDeclaredExceptions();

	/**
	 * Returns the resolved type parameters for a given operation. If this operation represents an overridden operation,
	 * the type parameters are the ones that are declared on the initially requested resolved operation.
	 * 
	 * Consider the following interface and implementation class:
	 * 
	 * <pre>
	 * interface I {
	 *   &lt;T extends CharSequence&gt; T method()
	 * }
	 * class C implements I {
	 *   public &lt;V extends CharSequence&gt; V method() {
	 *     return null;
	 *   }
	 * }
	 * </pre>
	 * 
	 * If the initially requested method was <code>C#method</code> and the current handle points to
	 * <code>I#method</code>, the type parameters will contain <code>V</code> instead of <code>T</code>.
	 * 
	 * The list may contain a different number of type parameters than the actual operation.
	 * 
	 * <pre>
	 * interface I {
	 *   &lt;T&gt; T method()
	 * }
	 * class C implements I {
	 *   public String method() {
	 *     return null;
	 *   }
	 * }
	 * </pre>
	 * 
	 * The method <code>I#method</code> in the context of class <code>C</code> will yield an empty list of resolved type
	 * parameters even though it {@link #getTypeParameters() declares} <code>T</code>.
	 * 
	 * @return the list of resolved type parameters.
	 */
	List<JvmTypeParameter> getResolvedTypeParameters();
	
	/**
	 * Returns the list of resolved constraints for the given type parameter index.
	 * 
	 * Consider the following example:
	 * 
	 * <pre>
	 * interface I&lt;T&gt; {
	 *   &lt;V extends T&gt; V method(Class&lt;? extends V&gt; c);
	 * }
	 * 
	 * abstract class C implements I&lt;CharSequence&gt; {
	 * }
	 * </pre>
	 * 
	 * The resolved constraint of <code>I#method&lt;V&gt;</code> in the context of class <code>C</code> is
	 * <code>CharSequence</code>.
	 * 
	 * @param idx
	 *            the index of the considered type parameter.
	 * 
	 * @return a list of resolved upper bound constraints for the type parameter at index <code>idx</code>.
	 * @see #getResolvedTypeParameterConstraints(int)
	 * @throws IndexOutOfBoundsException
	 *             if the idx does not match the resolved type parameter list.
	 */
	List<LightweightTypeReference> getResolvedTypeParameterConstraints(int idx) throws IndexOutOfBoundsException;
	
	/**
	 * Returns the resolved return types in the current context. That is, all free type variables are bound according
	 * to the bottom of this method hierarchy.
	 * 
	 * @see #getContextType()
	 * @see #getResolvedTypeParameters()
	 * @return the return type.
	 */
	LightweightTypeReference getResolvedReturnType();

	/**
	 * Returns <code>true</code> if the bottom of this resolved method hierachy, which that there is no specialization
	 * of this method in the current context.
	 * 
	 * <pre>
	 * interface I1 {
	 *   void m()
	 * }
	 * interface I2 {
	 *   void m()
	 * }
	 * abstract class C implements I1, I2 {
	 * }
	 * </pre>
	 * 
	 * If you get hold on the abstract method <code>I1#m</code> or <code>I2#m</code> both will return <code>true</code>.
	 * 
	 * @see #getAsBottom()
	 */
	boolean isBottomInContext();

	/**
	 * Returns the current method as a {@link #isBottomInContext() bottom method}. That implies, that the
	 * {@link #getContextType() context type} of the result is the resolved declarator of the current
	 * {@link #getDeclaration() declaration}.
	 * 
	 * <pre>
	 * interface I&lt;T&gt; {
	 *   &lt;K&gt; T m(K k);
	 * }
	 * class C implements I&lt;V&lt; {
	 *   &lt;U&gt; V m(U u);
	 * }
	 * </pre>
	 * 
	 * If this resolved method represents <code>I#m</code> in the context of class <code>C</code> (thus the return type
	 * will be <code>V</code> and the {@link #getResolvedTypeParameters() resolved type parameters} include
	 * <code>U</code>, {@link #getAsBottom()} will yield <code>I#m</code> in the context of <code>I&lt;V&lt;</code>.
	 * That is, the return type is still resolved to <code>V</code>. Nevertheless, the local type parameter of
	 * <code>I#m</code> is now resolved to its declaration <code>K</code>. This implies that the parameter type is no
	 * longer resolved to <code>U</code> but <code>K</code> instead. The bottom representation can be used to create
	 * descriptive error messages. If the current resolved method is already a bottom type, it is returned itself.
	 * 
	 * @return the current operation as bottom type.
	 * @see #isBottomInContext()
	 */
	IResolvedOperation getAsBottom();

	/**
	 * Returns the declared operation that is resolved.
	 * 
	 * @return the declaration.
	 */
	@Override
	JvmOperation getDeclaration();
}

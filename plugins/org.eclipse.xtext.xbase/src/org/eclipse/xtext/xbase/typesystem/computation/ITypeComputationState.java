/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.validation.FeatureNameValidator;

/**
 * The current state of the type computation.
 * It is passed around as a context instance that allows to query types that
 * were already computed, assign types to local variables or trigger type
 * computation for expression in the context of a certain expectation.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public interface ITypeComputationState {

	/**
	 * The given expectation will be resolved if it contains unresolved type
	 * arguments, e.g. an operation that declares two parameters of the very
	 * same type argument will yield a more detailed expectation if possible.
	 * <code>&lt;T&gt; T foo(T, T)</code> with
	 * <code>foo&lt;String&gt;(null, 'string')</code> will allow to pass the unresolved <code>T</code> as expectation
	 * where clients would be invoked with the better candidate 'string'.
	 */
	ITypeComputationState withExpectation(LightweightTypeReference expectation);
	
	/**
	 * After the fact refinement of the expected type. The expected type of a given
	 * expression may be changed after the real type of that expression is known.
	 * 
	 * Example:
	 * 
	 * <pre>
	 * for(double d: produceIntArray) {
	 * }
	 * </pre>
	 * 
	 * Expressions are resolved in the context of an expected type, which may or may not exist (e.g. it may be <code>null</code>).
	 * 
	 * The expectation for the call to <code>produceIntArray</code> is <code>double[]</code>. 
	 * However, the method returns an array of int. The tricky part is, that an <code>int[]</code>
	 * is not assignable to a <code>double[]</code> which would lead to incompatible types. Nevertheless,
	 * the expression is valid, since the component type is relevant for the compatibility
	 * in the context of a for-loop. Therefore, the expectation is refined after the fact to 
	 * <code>int[]</code> because the conformance could be validated.   
	 */
	void refineExpectedType(XExpression expression, LightweightTypeReference expectation);
	
	/**
	 * The given expectation becomes the expected return type and the expected type for
	 * the current context. Outer context is ignored for child expressions.
	 */
	ITypeComputationState withRootExpectation(LightweightTypeReference expectation);
	
	/**
	 * Keep the current return expectation and assume an actual expectation that is not void.
	 * 
	 * Example:
	 * <pre>
	 * val x = someExpression
	 * </pre>
	 * 
	 * The expectation for the call to <code>someExpression</code> is anything but <code>void</code>.
	 * 
	 */
	ITypeComputationState withNonVoidExpectation();
	
	/**
	 * Transfers the available return type expectation to the actual expectation of this
	 * computation step.
	 * 
	 * <pre>
	 * op someMethod: String {
	 *   return someExpression
	 * }
	 * </pre>
	 * 
	 * The actual expectation of the child <code>someExpression</code> is the return expectation
	 * in that context, e.g. <code>java.lang.String</code> in the given example. 
	 */
	ITypeComputationState withReturnExpectation();
	
	/**
	 * Keeps the return type expectation. Otherwise the new state does not have any expectations.
	 * 
	 * Example:
	 * <pre>
	 * {
	 *   someExpression
	 *   subsequent 
	 * }
	 * </pre>
	 * 
	 * The expectation for the call to <code>someExpression</code> does not have any actual expectations.
	 */
	ITypeComputationState withoutExpectation();

	/**
	 * A type checkpoint allows to re-specify the type of an identifiable that was already
	 * type-computed. The refined type is discarded as soon as the state is left.
	 */
	ITypeComputationState withTypeCheckpoint();

	ITypeComputationResult computeTypes(@Nullable XExpression expression);
	
	/**
	 * @param type the type of the element. <code>null</code> or other invalid types will be treated as error types.
	 */
	ITypeComputationState assignType(JvmIdentifiableElement element, @Nullable LightweightTypeReference type);
	
	/**
	 * @param type the type of the element. <code>null</code> or other invalid types will be treated as error types.
	 */
	ITypeComputationState assignType(JvmIdentifiableElement element, @Nullable LightweightTypeReference type, boolean addToChildScope);
	
	ITypeAssigner assignTypes();
	
	/**
	 * Adds the given element as a local variable. An issue is recorded if the new element will
	 * shadow an existing element. If the new element has a disallowed name, it will not be added to the scope.
	 * 
	 * @see FeatureNameValidator
	 * @param element the newly added element (e.g. a {@link XVariableDeclaration variable} or {@link JvmFormalParameter parameter}.
	 */
	void addLocalToCurrentScope(JvmIdentifiableElement element);
	
	/**
	 * Assigns the given actual type to the raw type which shall be reachable with the given name.
	 * This is useful to refine the context of certain expression children, e.g. the body of a lambda
	 * expression shall use the visibility constraints of the implemented SAM type.
	 * 
	 * <pre>
	 * 	assignType(IFeatureNames.SELF, 'java.util.Comparator', 'java.util.Comparator&lt;String&gt;');
	 * </pre>
	 * 
	 * @param name the name of the feature that should point to the given type, e.g. {@link IFeatureNames#THIS}
	 * @param rawType the type that declares the context of the expression.
	 * @param actualType the context type with bound type arguments (possibly unresolved). 
	 */
	void assignType(QualifiedName name, JvmType rawType, LightweightTypeReference actualType);
	
	void addDiagnostic(AbstractDiagnostic diagnostic);
	
	/**
	 * The result is never empty.
	 */
	List<? extends ITypeExpectation> getExpectations();
	
	/**
	 * The result is never empty.
	 */
	List<? extends IConstructorLinkingCandidate> getLinkingCandidates(XConstructorCall constructorCall);
	
	/**
	 * The result is never empty.
	 */
	List<? extends IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall);
	
	void acceptActualType(LightweightTypeReference type);
	
	void acceptActualType(LightweightTypeReference type, ConformanceHint... hints);
	
	// TODO implement this better, especially for instanceof in conditions
	
	void reassignType(JvmIdentifiableElement refinable, LightweightTypeReference type);
	
	void discardReassignedTypes(JvmIdentifiableElement refinable);

	ITypeReferenceOwner getReferenceOwner();
	
	OwnedConverter getConverter();
	
}

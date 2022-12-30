/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.EnumSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.scoping.batch.ITypeImporter;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.validation.FeatureNameValidator;

/**
 * The current state of the type computation.
 * It is passed around as a context instance that allows to query types that
 * were already computed, assign types to local variables or trigger type
 * computation for expression in the context of a certain expectation.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
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
	 * The outer context is ignored for child expressions and the newly produced context
	 * does not impose any restrictions on the expectation.
	 */
	ITypeComputationState withoutRootExpectation();
	
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
	 * type-computed. The refined type is discarded as soon as the state is left. In that sense,
	 * the type checkpoint describes the scope of certain type specializations.
	 * 
	 * @param context an indicator that describes the context of this type checkpoint, e.g. an {@link XCasePart}.
	 */
	ITypeComputationState withTypeCheckpoint(/* @Nullable */ EObject context);
	
	ITypeComputationState withExpectedExceptions(List<LightweightTypeReference> declaredExceptionTypes);
	
	List<LightweightTypeReference> getExpectedExceptions();

	/**
	 * Triggers type computation for a child expression of the currently considered expression.
	 * 
	 * @throws IllegalArgumentException if the given expression is the currently computed expression.
	 */
	ITypeComputationResult computeTypes(/* @Nullable */ XExpression expression);
	
	/**
	 * Assigns the type to the given element and makes the element available in the scope.
	 * This is fully equivalent to {@code assignType(element, type, true)}.
	 * Each element may only be typed once.
	 * 
	 * @param element the identifiable that will be annotated with the given type.
	 * @param type the type of the element. <code>null</code> or other invalid types will be treated as error types.
	 * @see #assignType(JvmIdentifiableElement, LightweightTypeReference, boolean)
	 * @see #addLocalToCurrentScope(JvmIdentifiableElement)
	 * @see #assignTypes()
	 * @see ITypeAssigner
	 */
	ITypeComputationState assignType(JvmIdentifiableElement element, /* @Nullable */ LightweightTypeReference type);
	
	/**
	 * Assigns the given type to the given element and optionally adds the element to the scope.
	 * Each element may only be typed once.
	 * 
	 * @param element the identifiable that will be annotated with the given type.
	 * @param type the type of the element. <code>null</code> or other invalid types will be treated as error types.
	 * @param addToChildScope <code>true</code> if the element should be added to the child scope, <code>false</code> if only the type
	 * 	information should be recorded.
	 * @see ITypeAssigner
	 * @see #assignTypes()
	 * @see #addLocalToCurrentScope(JvmIdentifiableElement)
	 */
	ITypeComputationState assignType(JvmIdentifiableElement element, /* @Nullable */ LightweightTypeReference type, boolean addToChildScope);
	
	/**
	 * Obtain a new {@link ITypeAssigner} that allows to add a bulk of {@link JvmIdentifiableElement elements} to this computation state.
	 */
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
	 * Adds the given element as an extension provider to the current scope.
	 * 
	 * @param extensionProvider the identifiable that points to the extension provider
	 */
	void addExtensionToCurrentScope(JvmIdentifiableElement extensionProvider);
	
	/**
	 * Adds the given type to the static scope.
	 * 
	 * @param type the type that is added to the static scope.
	 */
	void addTypeToStaticImportScope(JvmDeclaredType type);
	
	/**
	 * Adds the given type to the static extension scope.
	 * 
	 * @param type the type that is added to the static extension scope.
	 * @since 2.6
	 */
	void addTypeToStaticExtensionImportScope(JvmDeclaredType type);
	
	/**
	 * Allows to add several imports in a bulk operation on a fine grained basis,
	 * e.g. it supports to import only a subset of the members of a type.
	 * 
	 * @since 2.6
	 */
	void addImports(ITypeImporter.Client importer);
	
	/**
	 * Adds the given elements as extension providers to the current scope.
	 * The elements are all treated with equal priority, e.g. their contributed
	 * extensions may be ambiguous.
	 * 
	 * @param extensionProviders the identifiables that contribute to the extension scope
	 */
	void addExtensionsToCurrentScope(List<? extends JvmIdentifiableElement> extensionProviders);
	
	/**
	 * If the expression tree contains expressions that define a new scope, e.g. add local variables
	 * to the scope as a {@link XForLoopExpression} would do, the scope for contained expressions may
	 * be explicitly recorded by announcing that the inference is now done within that newly created scope.
	 */
	void withinScope(EObject context);
	
	/**
	 * If the expression tree contains intermediate objects, e.g. {@link XCasePart}
	 * or {@link XCatchClause}, one can explicitly record the scope of these
	 * objects as these won't be processed by the inference infrastructure.
	 */
	void afterScope(EObject context);
	
	/**
	 * If the container of an expression decides to alter the scope after the 
	 * expression was typed, its AFTER scope may be rewritten.
	 */
	void rewriteScope(EObject context);
	
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
	
	/**
	 * Annotates the currently considered expression(s) with the given type.
	 * It is assumed that the type does not depend on the expectation.
	 */
	void acceptActualType(LightweightTypeReference type);
	
	/**
	 * Allows to register a candidate that gets the chance to validate or change the state
	 * of the AST in a subsequent processing step.
	 * 
	 * @param expression the expression that the given candidate is associated with.
	 * @param candidate the candidate to validate if it is still present at the root of the decision tree.
	 * @see IClosureCandidate
	 */
	void acceptCandidate(XExpression expression, IApplicableCandidate candidate);
	
	/**
	 * Annotates the currently considered expression(s) with the given type.
	 * It is assumed that the type does not depend on the expectation.
	 * 
	 * The conformance hints are used to decide which variant will be finally chosen, if more than
	 * one type was given.
	 */
	void acceptActualType(LightweightTypeReference type, ConformanceHint... hints);
	
	/**
	 * Annotates the currently considered expression(s) with the given type.
	 * It is assumed that the type does not depend on the expectation.
	 * 
	 * The conformance hints are used to decide which variant will be finally chosen, if more than
	 * one type was given.
	 */
	void acceptActualType(LightweightTypeReference type, EnumSet<ConformanceHint> hints);
	
	/**
	 * Annotates the currently considered expression(s) with the given type.
	 * It is assumed that the type does not depend on the expectation.
	 * 
	 * The flags are used to decide which variant will be finally chosen, if more than
	 * one type was given.
	 * 
	 * @see ConformanceFlags
	 */
	void acceptActualType(LightweightTypeReference type, int flags);
	
	// TODO implement this better, especially for instanceof in conditions
	/**
	 * Allows to specialize the known type of an identifiable, that was already annotated
	 * with a type. Type refinements may be used to save casts. Usually only
	 * simple identifiables should be refined, e.g. {@link XVariableDeclaration local variables}.
	 * It's the clients responsibility to decide about that.
	 * 
	 * Example:
	 * <pre>
	 * val Object x = obtainInstance
	 * if (x instanceof String &amp;&amp; x.length &gt; 0) {
	 *   x.substring(1)
	 * }
	 * </pre>
	 * 
	 * The instanceof expression may refine the type for subsequent expressions, e.g. in boolean
	 * conditions or blocks.  
	 */
	void reassignType(JvmIdentifiableElement refinable, LightweightTypeReference type);
	
	/**
	 * A reassigned type may become obsolete due to assignments. Those should discard the reassign information.
	 * Example:
	 * <pre>
	 * var node = someNode;
	 * while(node instanceof ContainerNode) {
	 * 		node = node.container
	 * 		node.container // type error
	 * }
	 * </pre>
	 * After the assignment in the while loop, the node is no longer considered to be a ContainerNode. 
	 */
	void discardReassignedTypes(JvmIdentifiableElement refinable);

	/**
	 * The current type reference owner for newly converted type references.
	 */
	ITypeReferenceOwner getReferenceOwner();
	
	/**
	 * Create a new, managed {@link UnboundTypeReference} for the given type parameter which was
	 * first encountered for the given expression.
	 * @param expression the expression that used / referenced the type parameter
	 * @param typeParameter the type parameter
	 */
	UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter typeParameter);

	/**
	 * Adds the given diagnostic to the current state. If this state is later discarded in favor
	 * of a better solution, the diagnostic is discarded, too.
	 */
	void addDiagnostic(AbstractDiagnostic diagnostic);
	
	/**
	 * Returns the severity for the given {@code issueCode}.
	 */
	Severity getSeverity(String issueCode);
	
	/**
	 * Returns {@code false} if no issues have to be produced for the given issueCode.
	 */
	boolean isIgnored(String issueCode);
	
}

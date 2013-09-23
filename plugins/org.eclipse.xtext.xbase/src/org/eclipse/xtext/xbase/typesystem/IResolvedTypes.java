/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * Resolved types represent the result of the type resolution.
 * They offer a means to query for actual types, expectations, 
 * the type arguments for a feature call or the diagnostics that
 * were produced during the type resolution.
 * 
 * TODO JavaDoc - better describe actual type, return type and expected types.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public interface IResolvedTypes {

	/* 
	 * TODO find a suitable abstraction to represent diagnostics
	 * It's cumbersome to use Issues since they only know about URIs 
	 * so we probably want to use Diagnostics?
	 * 
	 * TODO do we really need this on the resolved types API? probably not
	 */
	Collection<AbstractDiagnostic> getQueuedDiagnostics();
	
	/**
	 * Returns the linking candidates that could not be resolved but are not 
	 * exposed to the users because they are follow up errors.
	 */
	Collection<ILinkingCandidate> getFollowUpErrors();
	
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
	 * Returns <code>true</code> if the given expression may have the type <code>void</code>.
	 * @param expression expression whose expected type is queried.
	 */
	boolean isVoidTypeAllowed(XExpression expression);
	
	/**
	 * Returns the expected return type for the given expression or <code>null</code> if none.
	 * @param expression expression whose expected return type is queried.
	 */
	@Nullable
	LightweightTypeReference getExpectedReturnType(XExpression expression);
	
	/**
	 * @param expression may either be an {@link XAbstractFeatureCall} or {@link XConstructorCall}. May not be <code>null</code>. 
	 */
	List<LightweightTypeReference> getActualTypeArguments(XExpression expression);
	
	/**
	 * Returns the intermediate linking result for the given feature call, if any.
	 * If the feature call is <code>null</code>, the result is <code>null</code>.
	 * @param featureCall the feature call that is queried for the current linking state.
	 * @return the potentially intermediate linking state or <code>null</code> if none.
	 */
	@Nullable
	JvmIdentifiableElement getLinkedFeature(@Nullable XAbstractFeatureCall featureCall);
	
	/**
	 * Returns the intermediate linking result for the given constructor call, if any.
	 * If the constructor call is <code>null</code>, the result is <code>null</code>.
	 * If the constructor call is broken, it may return a {@link JvmType} instead of 
	 * a {@link JvmConstructor}.
	 * @param constructorCall the constructor call that is queried for the current linking state.
	 * @return the potentially intermediate linking state or <code>null</code> if none.
	 */
	@Nullable
	JvmIdentifiableElement getLinkedFeature(@Nullable XConstructorCall constructorCall);
	
	/**
	 * Returns the intermediate linking candidate for the given feature call, if any.
	 * If the feature call is <code>null</code>, the result is <code>null</code>.
	 * @param featureCall the feature call that is queried for the current linking state.
	 * @return the potentially intermediate linking state or <code>null</code> if none.
	 */
	@Nullable
	IFeatureLinkingCandidate getLinkingCandidate(@Nullable XAbstractFeatureCall featureCall);
	
	/**
	 * Returns the intermediate linking candidate for the given constructor call, if any.
	 * If the constructor call is <code>null</code>, the result is <code>null</code>.
	 * If the constructor call is broken, it may return a {@link JvmType} instead of 
	 * a {@link JvmConstructor}.
	 * @param constructorCall the constructor call that is queried for the current linking state.
	 * @return the potentially intermediate linking state or <code>null</code> if none.
	 */
	@Nullable
	IConstructorLinkingCandidate getLinkingCandidate(@Nullable XConstructorCall constructorCall);
	
	/**
	 * Returns <code>true</code> if the expression's type is based on a type
	 * refinement, e.g. an instanceof guard my specialize the type of the checked
	 * reference. Any feature call to that reference is considered to be based on
	 * a refined type.
	 * @param expression the expression that may have been typed based on a refinement.
	 * @return <code>true</code> if the type was refined, <code>false</code> otherwise.
	 */
	boolean isRefinedType(XExpression expression);

	IResolvedTypes NULL = new NullResolvedTypes();

	/**
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 */
	class NullResolvedTypes implements IResolvedTypes {
		
		protected NullResolvedTypes() {
		}
		
		public Collection<AbstractDiagnostic> getQueuedDiagnostics() {
			return Collections.emptyList();
		}
		
		public Collection<ILinkingCandidate> getFollowUpErrors() {
			return Collections.emptyList();
		}
		
		@Nullable
		public LightweightTypeReference getExpectedType(XExpression expression) {
			return null;
		}
		
		@Nullable
		public LightweightTypeReference getExpectedReturnType(XExpression expression) {
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
		
		public boolean isVoidTypeAllowed(XExpression expression) {
			return false;
		}
		
		@Nullable
		public JvmIdentifiableElement getLinkedFeature(@Nullable XAbstractFeatureCall featureCall) {
			return null;
		}
		
		@Nullable
		public IFeatureLinkingCandidate getLinkingCandidate(@Nullable XAbstractFeatureCall featureCall) {
			return null;
		}
		
		@Nullable
		public JvmIdentifiableElement getLinkedFeature(@Nullable XConstructorCall constructorCall) {
			return null;
		}
		
		@Nullable
		public IConstructorLinkingCandidate getLinkingCandidate(@Nullable XConstructorCall constructorCall) {
			return null;
		}
	}
	
}

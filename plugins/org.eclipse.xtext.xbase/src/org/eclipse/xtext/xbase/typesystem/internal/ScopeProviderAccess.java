/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API 
 * TODO JavaDoc, toString
 */
public class ScopeProviderAccess {

	@Inject
	private LinkingHelper linkingHelper;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private LazyURIEncoder encoder;

	@NonNullByDefault
	@Nullable
	protected IFeatureLinkingCandidate getKnownFeature(XAbstractFeatureCall featureCall, AbstractTypeComputationState state, ResolvedTypes resolvedTypes) {
		IFeatureLinkingCandidate result = resolvedTypes.getFeature(featureCall);
		if (result != null) {
			return new AppliedFeatureLinkingCandidate(result);
		}
		EObject proxyOrResolved = (EObject) featureCall.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
		if (proxyOrResolved == null) {
			return new NullFeatureLinkingCandidate(featureCall, state);
		}
		if (!proxyOrResolved.eIsProxy()) {
			return state.createResolvedLink(featureCall, (JvmIdentifiableElement) proxyOrResolved);
		}
		if (!encoder.isCrossLinkFragment(featureCall.eResource(), EcoreUtil.getURI(proxyOrResolved).fragment())) {
			JvmIdentifiableElement feature = featureCall.getFeature();
			if (!feature.eIsProxy()) {
				return state.createResolvedLink(featureCall, feature);
			}
		}
		return null;
	}
	
	@NonNullByDefault
	@Nullable
	protected IConstructorLinkingCandidate getKnownConstructor(XConstructorCall constructorCall, AbstractTypeComputationState state,
			ResolvedTypes resolvedTypes) {
		IConstructorLinkingCandidate result = resolvedTypes.getConstructor(constructorCall);
		if (result != null) {
			return result;
		}
		EObject proxyOrResolved = (EObject) constructorCall.eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
		if (proxyOrResolved == null) {
			result = new NullConstructorLinkingCandidate(constructorCall, state);
			return result;
		}
		if (!proxyOrResolved.eIsProxy()) {
			result = state.createResolvedLink(constructorCall, (JvmConstructor) proxyOrResolved);
			return result;
		}
		if (!encoder.isCrossLinkFragment(constructorCall.eResource(), EcoreUtil.getURI(proxyOrResolved).fragment())) {
			JvmConstructor constructor = constructorCall.getConstructor();
			if (!constructor.eIsProxy()) {
				return state.createResolvedLink(constructorCall, constructor);
			}
		}
		return null;
	}

	/**
	 * Returns a bunch of descriptions most of which are actually {@link IIdentifiableElementDescription describing identifiables}. 
	 * The provided iterable is never empty but it may contain a single {@link ErrorDescription error description}.
	 * 
	 * @return the available descriptions.
	 */
	@NonNullByDefault
	public Iterable<IEObjectDescription> getCandidateDescriptions(XExpression expression, EReference reference, @Nullable EObject toBeLinked,
			IFeatureScopeSession session, IResolvedTypes types) throws IllegalNodeException {
		if (toBeLinked == null) {
			return Collections.emptyList();
		}
		if (!toBeLinked.eIsProxy()) {
			throw new IllegalStateException(expression + " was already linked to " + toBeLinked);
		}
		URI uri = EcoreUtil.getURI(toBeLinked);
		String fragment = uri.fragment();
		if (encoder.isCrossLinkFragment(expression.eResource(), fragment)) {
			INode node = encoder.getNode(expression, fragment);
			final EClass requiredType = reference.getEReferenceType();
			if (requiredType == null)
				return Collections.emptyList();

			final String crossRefString = linkingHelper.getCrossRefNodeAsString(node, true);
			if (crossRefString != null && !crossRefString.equals("")) {
				final IScope scope = session.getScope(expression, reference, types);
				QualifiedName qualifiedLinkName = qualifiedNameConverter.toQualifiedName(crossRefString);
				Iterable<IEObjectDescription> descriptions = scope.getElements(qualifiedLinkName);
				if (Iterables.isEmpty(descriptions)) {
					return Collections.<IEObjectDescription>singletonList(new ErrorDescription(node, qualifiedLinkName));
				}
				return descriptions;
			}
			return Collections.emptyList();
		} else {
			throw new IllegalStateException(expression + " uses unsupported uri fragment " + uri);
		}
	}
	
	public static class ErrorDescription implements IIdentifiableElementDescription {

		private QualifiedName name;
		private INode node;
		private boolean followUp;

		public ErrorDescription(INode node, QualifiedName name) {
			this.node = node;
			this.name = name;
			this.followUp = false;
		}
		
		public ErrorDescription() {
			this.node = null;
			this.name = null;
			this.followUp = true;
		}
		
		public boolean isFollowUpError() {
			return followUp;
		}
		
		public QualifiedName getName() {
			return name;
		}
		
		public INode getNode() {
			return node;
		}

		public QualifiedName getQualifiedName() {
			return name;
		}

		public EObject getEObjectOrProxy() {
			return null;
		}

		public URI getEObjectURI() {
			return null;
		}

		public EClass getEClass() {
			return null;
		}

		public String getUserData(String key) {
			return null;
		}

		public String[] getUserDataKeys() {
			return Strings.EMPTY_ARRAY;
		}

		@NonNull 
		public JvmIdentifiableElement getElementOrProxy() {
			throw new UnsupportedOperationException();
		}

		@NonNull 
		public String getShadowingKey() {
			return "ErrorDescription";
		}

		public int getBucketId() {
			return 0;
		}

		@Nullable
		public LightweightTypeReference getImplicitReceiverType() {
			return null;
		}

		@Nullable
		public XExpression getImplicitReceiver() {
			return null;
		}

		@NonNull
		public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping() {
			return Collections.emptyMap();
		}
		
		@NonNull
		public EnumSet<ConformanceHint> getImplicitReceiverConformanceHints() {
			return EnumSet.noneOf(ConformanceHint.class);
		}

		@Nullable
		public LightweightTypeReference getSyntacticReceiverType() {
			return null;
		}

		@Nullable
		public XExpression getSyntacticReceiver() {
			return null;
		}

		@NonNull
		public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping() {
			return Collections.emptyMap();
		}
		
		@NonNull
		public EnumSet<ConformanceHint> getSyntacticReceiverConformanceHints() {
			return EnumSet.noneOf(ConformanceHint.class);
		}

		@Nullable
		public XExpression getImplicitFirstArgument() {
			return null;
		}

		@Nullable
		public LightweightTypeReference getImplicitFirstArgumentType() {
			return null;
		}

		@NonNull 
		public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitFirstArgumentTypeParameterMapping() {
			return Collections.emptyMap();
		}
		
		@NonNull
		public EnumSet<ConformanceHint> getImplicitFirstArgumentConformanceHints() {
			return EnumSet.noneOf(ConformanceHint.class);
		}

		public boolean isVisible() {
			return true;
		}

		public boolean isStatic() {
			return false;
		}

		public boolean isExtension() {
			return false;
		}

	}

}

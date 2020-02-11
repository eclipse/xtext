/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
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

	/* @Nullable */
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
	
	/* @Nullable */
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
	public Iterable<IEObjectDescription> getCandidateDescriptions(XExpression expression, EReference reference, /* @Nullable */ EObject toBeLinked,
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
				QualifiedName qualifiedLinkName = qualifiedNameConverter.toQualifiedName(crossRefString);
				if (!qualifiedLinkName.isEmpty()) {
					final IScope scope = session.getScope(expression, reference, types);
					Iterable<IEObjectDescription> descriptions = scope.getElements(qualifiedLinkName);
					if (Iterables.isEmpty(descriptions)) {
						INode errorNode = getErrorNode(expression, node);
						if (errorNode != node) {
							qualifiedLinkName = getErrorName(errorNode);
						}
						return Collections.<IEObjectDescription>singletonList(new ErrorDescription(getErrorNode(expression, node), qualifiedLinkName));
					}
					return descriptions;
				} else {
					return Collections.<IEObjectDescription>singletonList(new ErrorDescription(null /* followUp problem */));
				}
			}
			return Collections.emptyList();
		} else {
			throw new IllegalStateException(expression + " uses unsupported uri fragment " + uri);
		}
	}

	private QualifiedName getErrorName(INode errorNode) {
		List<String> segments = Lists.newArrayListWithCapacity(4);
		for(ILeafNode leaf: errorNode.getLeafNodes()) {
			if (!leaf.isHidden()) {
				String text = leaf.getText();
				// XParenthesizedExpression
				if (text.equals("(") || text.equals(")")) {
					continue;
				}
				if (!text.equals(".") && !text.equals("::")) {
					if (text.charAt(0) == '^')
						segments.add(text.substring(1));
					else
						segments.add(text);
				}
			}
		}
		return QualifiedName.create(segments);
	}
	
	/**
	 * Returns the node that best describes the error, e.g. if there is an expression
	 * <code>com::foo::DoesNotExist::method()</code> the error will be rooted at <code>com</code>, but
	 * the real problem is <code>com::foo::DoesNotExist</code>.
	 */
	private INode getErrorNode(XExpression expression, INode node) {
		if (expression instanceof XFeatureCall) {
			XFeatureCall featureCall = (XFeatureCall) expression;
			if (!canBeTypeLiteral(featureCall)) {
				return node;
			}
			if (featureCall.eContainingFeature() == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
				XMemberFeatureCall container = (XMemberFeatureCall) featureCall.eContainer();
				if (canBeTypeLiteral(container)) {
					boolean explicitStatic = container.isExplicitStatic();
					XMemberFeatureCall outerMost = getLongestTypeLiteralCandidate(container, explicitStatic);
					if (outerMost != null)
						return NodeModelUtils.getNode(outerMost);
				}
			}
		}
		return node;
	}

	/* @Nullable */
	private XMemberFeatureCall getLongestTypeLiteralCandidate(XMemberFeatureCall current, boolean mustBeStatic) {
		if (current.eContainingFeature() == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
			XMemberFeatureCall container = (XMemberFeatureCall) current.eContainer();
			if (canBeTypeLiteral(container)) {
				if (!mustBeStatic && !container.isExplicitStatic()) {
					return null;
				}
				if (mustBeStatic != container.isExplicitStatic()) {
					return current;
				}
				if (mustBeStatic && container.eContainingFeature() != XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
					return current;
				}
				return getLongestTypeLiteralCandidate(container, mustBeStatic);
			}
		}
		if (mustBeStatic) {
			return null;
		}
		if (!mustBeStatic && !current.isExplicitStatic()) {
			return null;
		}
		return current;
	}

	private boolean canBeTypeLiteral(XAbstractFeatureCall featureCall) {
		return !featureCall.isExplicitOperationCallOrBuilderSyntax() && featureCall.getTypeArguments().isEmpty();
	}

	public static class ErrorDescription implements IIdentifiableElementDescription {

		private final QualifiedName name;
		private final INode node;
		private final boolean followUp;
		private final LightweightTypeReference syntacticReceiverType;

		public ErrorDescription(INode node, QualifiedName name) {
			this.node = node;
			this.name = name;
			this.followUp = false;
			this.syntacticReceiverType = null;
		}
		
		public ErrorDescription(/* @Nullable */ LightweightTypeReference syntacticReceiverType) {
			this.node = null;
			this.name = null;
			this.followUp = true;
			this.syntacticReceiverType = syntacticReceiverType;
		}
		
		public boolean isFollowUpError() {
			return followUp;
		}
		
		@Override
		public QualifiedName getName() {
			return name;
		}
		
		public INode getNode() {
			return node;
		}

		@Override
		public QualifiedName getQualifiedName() {
			return name;
		}

		@Override
		public EObject getEObjectOrProxy() {
			return null;
		}

		@Override
		public URI getEObjectURI() {
			return null;
		}

		@Override
		public EClass getEClass() {
			return null;
		}

		@Override
		public String getUserData(String key) {
			return null;
		}

		@Override
		public String[] getUserDataKeys() {
			return Strings.EMPTY_ARRAY;
		}

		/* @NonNull */ 
		@Override
		public JvmIdentifiableElement getElementOrProxy() {
			throw new UnsupportedOperationException();
		}

		/* @NonNull */ 
		@Override
		public String getShadowingKey() {
			return "ErrorDescription";
		}

		@Override
		public int getBucketId() {
			return 0;
		}

		/* @Nullable */
		@Override
		public LightweightTypeReference getImplicitReceiverType() {
			return null;
		}

		/* @Nullable */
		@Override
		public XExpression getImplicitReceiver() {
			return null;
		}

		/* @NonNull */
		@Override
		public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping() {
			return Collections.emptyMap();
		}
		
		/* @NonNull */
		@Override
		public EnumSet<ConformanceHint> getImplicitReceiverConformanceHints() {
			return EnumSet.noneOf(ConformanceHint.class);
		}
		
		@Override
		public int getImplicitReceiverConformanceFlags() {
			return ConformanceFlags.NONE;
		}

		/* @Nullable */
		@Override
		public LightweightTypeReference getSyntacticReceiverType() {
			return syntacticReceiverType;
		}

		/* @Nullable */
		@Override
		public XExpression getSyntacticReceiver() {
			return null;
		}
		
		@Override
		public boolean isSyntacticReceiverPossibleArgument() {
			return false;
		}

		/* @NonNull */
		@Override
		public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping() {
			return Collections.emptyMap();
		}
		
		/* @NonNull */
		@Override
		public int getSyntacticReceiverConformanceFlags() {
			return ConformanceFlags.NONE;
		}

		/* @Nullable */
		@Override
		public XExpression getImplicitFirstArgument() {
			return null;
		}

		/* @Nullable */
		@Override
		public LightweightTypeReference getImplicitFirstArgumentType() {
			return null;
		}

		/* @NonNull */ 
		public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitFirstArgumentTypeParameterMapping() {
			return Collections.emptyMap();
		}
		
		/* @NonNull */
		@Override
		public EnumSet<ConformanceHint> getSyntacticReceiverConformanceHints() {
			return EnumSet.noneOf(ConformanceHint.class);
		}
		
		public int getImplicitFirstArgumentConformanceFlags() {
			return ConformanceFlags.NONE;
		}

		@Override
		public boolean isVisible() {
			return true;
		}

		@Override
		public boolean isStatic() {
			return false;
		}

		@Override
		public boolean isExtension() {
			return false;
		}
		
		@Override
		public boolean isTypeLiteral() {
			return false;
		}
		
		@Override
		public boolean isAnonymousClassConstructorCall() {
			return false;
		}
		
		@Override
		public int getNumberOfIrrelevantParameters() {
			return 0;
		}
		
		@Override
		public int getNumberOfParameters() {
			return 0;
		}
		
		@Override
		public boolean isValidStaticState() {
			return false;
		}

	}

}

/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.util;

import java.util.List;

import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
@Singleton
public class FeatureCallAsTypeLiteralHelper {

	/**
	 * Returns <code>true</code> if the given feature call can be a type literal (structurally). 
	 * Otherwise <code>false</code>.
	 */
	public boolean isPotentialTypeLiteral(XExpression featureCall, /* @Nullable */ IResolvedTypes resolvedTypes) {
		if (featureCall instanceof XMemberFeatureCall) {
			return isPotentialTypeLiteralImpl(featureCall, resolvedTypes, ((XMemberFeatureCall) featureCall).isExplicitStatic());	
		}
		return isPotentialTypeLiteralImpl(featureCall, resolvedTypes, false);
	}

	protected boolean isPotentialTypeLiteralImpl(XExpression featureCall, /* @Nullable */ IResolvedTypes resolvedTypes, boolean staticNotation) {
		if (featureCall instanceof XMemberFeatureCall) {
			XMemberFeatureCall casted = (XMemberFeatureCall) featureCall;
			if (casted.isExplicitOperationCallOrBuilderSyntax() || casted.isNullSafe()) {
				return false;
			}
			XExpression target = casted.getMemberCallTarget();
			if (casted.isExplicitStatic() != staticNotation) {
				return false;
			}
			return isPotentialTypeLiteralImpl(target, resolvedTypes, staticNotation);
		}
		if (featureCall instanceof XFeatureCall) {
			XFeatureCall casted = (XFeatureCall) featureCall;
			if (casted.isExplicitOperationCallOrBuilderSyntax()) {
				return false;
			}
			if (resolvedTypes == null)
				return true;
			LightweightTypeReference knownType = resolvedTypes.getActualType(casted);
			if (knownType == null || knownType.isUnknown()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the segments that are preceding the feature call, e.g. it returns 
	 * <code>'java', 'lang'</code> for a feature call <code>java.lang.String</code>.
	 * <code>java::lang::String</code>.
	 * Returns <code>null</code> if no such segments exist, e.g. because the member call target
	 * does not indicate a type reference syntactically, e.g. <code>(java.lang).String</code>.
	 */
	/* @Nullable */
	public List<String> getTypeNameSegmentsFromConcreteSyntax(XMemberFeatureCall featureCall) {
		List<INode> nodes = NodeModelUtils.findNodesForFeature(featureCall, XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET);
		List<String> prefix = getTypeNameSegmentsFromConcreteSyntax(nodes, featureCall.isExplicitStatic());
		return prefix;
	}
	
	protected List<String> getTypeNameSegmentsFromConcreteSyntax(List<INode> nodes, boolean staticNotation) {
		List<String> result = null;
		for(INode node: nodes) {
			for(ILeafNode leaf: node.getLeafNodes()) {
				if (!leaf.isHidden()) {
					String text = leaf.getText();
					// XParenthesizedExpression
					if (text.equals("(") || text.equals(")")) {
						return null;
					}
					if (text.equals(".")) {
						if (staticNotation) {
							return null;
						}
					}
					if (text.equals("::")) {
						if (!staticNotation) {
							return null;
						}
					}
					if (!text.equals(".") && !text.equals("::")) {
						if (result == null) {
							result = Lists.newArrayListWithCapacity(4);
						}
						if (text.charAt(0) == '^') {
							result.add(text.substring(1));
						} else {
							result.add(text);
						}
					}
				}
			}
		}
		return result;
	}
	
	public XAbstractFeatureCall getRootTypeLiteral(XAbstractFeatureCall featureCall) {
		if (featureCall.isTypeLiteral()) {
			return featureCall;
		}
		if (featureCall.isPackageFragment()) {
			return getRootTypeLiteral((XAbstractFeatureCall) featureCall.eContainer());
		}
		if (featureCall.getFeature() == null || featureCall.getFeature().eIsProxy()) {
			// syntactic check
			if (featureCall instanceof XFeatureCall || featureCall instanceof XMemberFeatureCall) {
				if (!isPotentialTypeLiteral(featureCall, null)) {
					return null;
				}
				if (featureCall instanceof XMemberFeatureCall) {
					return doGetRootTypeLiteral((XMemberFeatureCall) featureCall);
				}
				if (featureCall instanceof XFeatureCall) {
					if (featureCall.eContainingFeature() == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
						return doGetRootTypeLiteral((XMemberFeatureCall) featureCall.eContainer());
					}
				}
			}
		}
		return null;
	}

	protected XAbstractFeatureCall doGetRootTypeLiteral(XMemberFeatureCall featureCall) {
		boolean staticNotation = featureCall.isExplicitStatic();
		XMemberFeatureCall current = featureCall;
		while(current.eContainingFeature() == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
			XMemberFeatureCall container = (XMemberFeatureCall) current.eContainer();
			if (container.isExplicitStatic()) {
				if (staticNotation == false) {
					return current;
				}
				current = container;
			} else if (staticNotation) {
				return (XAbstractFeatureCall) current.getMemberCallTarget();
			} else {
				current = container;
			}
		}
		if (current != featureCall && staticNotation) {
			return (XAbstractFeatureCall) current.getMemberCallTarget();
		}
		return null;
	}

	public boolean isDefiniteTypeLiteral(XAbstractFeatureCall featureCall) {
		if (featureCall.isExplicitOperationCallOrBuilderSyntax())
			return false;
		if (!featureCall.getTypeArguments().isEmpty())
			return false;
		if (featureCall.eContainingFeature() == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
			XMemberFeatureCall container = (XMemberFeatureCall) featureCall.eContainer();
			if (container.isExplicitStatic()) {
				return true;
			}
			return isDefiniteTypeLiteral(container);
		}
		return false;
	}
	
}

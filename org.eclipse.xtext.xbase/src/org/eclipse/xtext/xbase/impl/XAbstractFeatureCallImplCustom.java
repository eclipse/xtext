/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class XAbstractFeatureCallImplCustom extends XAbstractFeatureCallImpl {
	
	private boolean isLinked = false;
	
	@Override
	public void setFeature(JvmIdentifiableElement newFeature) {
		isLinked = newFeature != null && !newFeature.eIsProxy();
		super.setFeature(newFeature);
	}
	
	@Override
	public JvmIdentifiableElement getFeature() {
		if (feature != null && feature.eIsProxy()) {
			// body copied from super impl
			InternalEObject oldFeature = (InternalEObject) feature;
			feature = (JvmIdentifiableElement) eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE, oldFeature, feature));
			}
			
			// and additionally maintain #isLinked flag
			isLinked = true;
		}
		return feature;
	}
	
	@Override
	public boolean isExplicitOperationCallOrBuilderSyntax() {
		return true;
	}
	
	@Override
	public String getConcreteSyntaxFeatureName() {
		List<INode> list = NodeModelUtils.findNodesForFeature(this, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		if (list.size()!=1) {
			if (feature == null || feature.eIsProxy())
				return "<unkown>";
			return String.format("<implicit: %s>", feature.getIdentifier());
		}
		INode node = list.get(0);
		if (node instanceof ILeafNode) {
			return node.getText();
		}
		StringBuilder result = new StringBuilder();
		for(ILeafNode leafNode: node.getLeafNodes()) {
			if (!leafNode.isHidden())
				result.append(leafNode.getText());
		}
		return result.toString();
	}
	
	protected String getExpressionsAsString(List<XExpression> expressions, boolean explicitOperationCall) {
		if (!explicitOperationCall && expressions.isEmpty())
			return "";
		String s = "(";
		for (Iterator<XExpression> iterator = expressions.iterator(); iterator.hasNext();) {
			XExpression type = iterator.next();
			s+=getExpressionAsString(type);
			if (iterator.hasNext())
				s+=",";
		}
		return s+")";
	}
	
	protected String getExpressionAsString(XExpression x) {
		if (x == null)
			return "<null>";
		return "<"+x.getClass().getSimpleName()+">";
	}

	@Override
	public XExpression getImplicitReceiver() {
		ensureFeatureLinked();
		return super.getImplicitReceiver();
	}
	
	@Override
	public XExpression getImplicitFirstArgument() {
		ensureFeatureLinked();
		return super.getImplicitFirstArgument();
	}
	
	@Override
	public boolean isPackageFragment() {
		return false;
	}
	
	@Override
	public boolean isTypeLiteral() {
		return false;
	}
	
	/**
	 * checks whether the feature was successfully linked
	 * Any features which rely on side effects done during linking of feature should call this method.
	 */
	protected void ensureFeatureLinked() {
		if (isLinked)
			return;
		
		// simply trigger linking if not yet linked
		getFeature();
	}
	
	@Override
	public boolean isValidFeature() {
		return Strings.isEmpty(getInvalidFeatureIssueCode());
	}
	
	@Override
	public String getInvalidFeatureIssueCode() {
		ensureFeatureLinked();
		return super.getInvalidFeatureIssueCode();
	}
	
	@Override
	public boolean isStatic() {
		JvmIdentifiableElement element = getFeature();
		if (element != null && !element.eIsProxy()) {
			if (element instanceof JvmFeature && !(element instanceof JvmConstructor))
				return ((JvmFeature) element).isStatic();
		}
		return false;
	}
	
	protected boolean isExtension(XExpression syntacticReceiver) {
		return (isStatic() || getImplicitReceiver() != null) && (syntacticReceiver != null || getImplicitFirstArgument() != null);
	}
	
	protected XExpression getActualReceiver(XExpression syntacticReceiver) {
		XExpression implicitReceiver = getImplicitReceiver();
		if (implicitReceiver != null)
			return implicitReceiver;
		if (isStatic())
			return null;
		return syntacticReceiver;
	}
	
	protected EList<XExpression> getActualArguments(XExpression syntacticReceiver, XExpression syntacticArgument) {
		if (syntacticArgument != null) {
			return getActualArguments(syntacticReceiver, new BasicEList<XExpression>(Collections.singletonList(syntacticArgument)));
		}
		return getActualArguments(syntacticReceiver, ECollections.<XExpression>emptyEList());
	}
	
	protected EList<XExpression> getActualArguments(XExpression syntacticReceiver, EList<XExpression> syntacticArguments) {
		if (isStatic()) {
			if (syntacticReceiver != null) {
				return createArgumentList(syntacticReceiver, syntacticArguments);
			}
			XExpression implicitFirstArgument = getImplicitFirstArgument();
			if (implicitFirstArgument != null) {
				return createArgumentList(implicitFirstArgument, syntacticArguments);
			}
		} else {
			XExpression implicitReceiver = getImplicitReceiver();
			if (implicitReceiver != null && syntacticReceiver != null) {
				return createArgumentList(syntacticReceiver, syntacticArguments);
			}
			XExpression implicitFirstArgument = getImplicitFirstArgument();
			if (implicitFirstArgument != null) {
				return createArgumentList(implicitFirstArgument, syntacticArguments);
			}
		}
		return syntacticArguments;
	}
	
	protected EList<XExpression> createArgumentList(XExpression head, List<XExpression> tail) {
		// TODO investigate in optimized List impls like head -> tail
		EList<XExpression> result = new BasicEList<XExpression>(tail.size() + 1);
		result.add(head);
		result.addAll(tail);
		return result;
	}
	
	@Override
	public boolean isOperation() {
		return false;
	}
	
}

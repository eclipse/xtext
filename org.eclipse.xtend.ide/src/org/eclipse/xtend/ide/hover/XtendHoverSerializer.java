/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.hover;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.util.XbaseSwitch;

import com.google.inject.Singleton;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
@Singleton
public class XtendHoverSerializer implements IFeatureNames {

	private static final String SEPARATOR = ", ";
	private static final String DELIMITER = ".";

	public String computeUnsugaredExpression(EObject object) {
		if (object instanceof XAbstractFeatureCall) {
			StringBuilder stringBuilder = new StringBuilder();
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) object;
			JvmIdentifiableElement feature = featureCall.getFeature();
			if (feature != null && !feature.eIsProxy()) {
				// Static extensions which are no expliciteOperationCalls
				if (featureCall instanceof XMemberFeatureCall && feature instanceof JvmOperation && !((XMemberFeatureCall) featureCall).isExplicitOperationCall()) {
					JvmOperation jvmOperation = (JvmOperation) feature;
					if (jvmOperation.isStatic()) {
						return stringBuilder.append(getStaticCallDesugaredVersion(featureCall, jvmOperation)).toString();
					}
				}
				// Static calls with implicit receiver or implicit first argument
				if (featureCall.getImplicitReceiver() != null || featureCall.getImplicitFirstArgument() != null) {
					if (featureCall.isStatic()) {
						return stringBuilder.append(getStaticCallDesugaredVersion(featureCall, (JvmMember) feature)).toString();
					}
					XExpression receiver = featureCall.getActualReceiver();
					if (receiver instanceof XMemberFeatureCall) {
						stringBuilder.append(THIS).append(DELIMITER);
						stringBuilder.append(((XMemberFeatureCall) receiver).getFeature().getSimpleName()).append(DELIMITER);
					} else if (receiver instanceof XAbstractFeatureCall) {
						JvmIdentifiableElement receiverFeature = ((XAbstractFeatureCall) receiver).getFeature();
						if (receiverFeature == feature.eContainer()) {
							stringBuilder.append(THIS).append(DELIMITER);
						} else {
							stringBuilder.append(receiverFeature.getSimpleName()).append(DELIMITER);
						}
					}
					stringBuilder.append(feature.getSimpleName());
					if (feature instanceof JvmExecutable)
						stringBuilder.append(computeArguments(featureCall));
					return stringBuilder.toString();
				}
			}
		}
		return "";
	}

	protected String getStaticCallDesugaredVersion(XAbstractFeatureCall featureCall,
			JvmMember jvmMember) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(jvmMember.getDeclaringType().getSimpleName());
		stringBuilder.append(DELIMITER);
		stringBuilder.append(jvmMember.getSimpleName());
		stringBuilder.append(computeArguments(featureCall));
		return stringBuilder.toString();
	}

	public String computeArguments(XAbstractFeatureCall featureCall) {
		StringBuilder stringBuilder = new StringBuilder("(");
		if (featureCall != null) {
			XExpression implicitFirstArgument = featureCall.getImplicitFirstArgument();
			List<XExpression> arguments = featureCall.getActualArguments();
			if (implicitFirstArgument != null) {
				XbaseSwitch<String> xbaseSwitch = new XtendHoverXbaseSwitch();
				String doSwitch = xbaseSwitch.doSwitch(implicitFirstArgument).trim();
				if (doSwitch != null)
					stringBuilder.append(doSwitch);
			}
			int start = implicitFirstArgument != null ? 1 : 0;
			for(int i = start; i < arguments.size(); i++) {
				if (i != 0) {
					stringBuilder.append(SEPARATOR);
				}
				XExpression expression = arguments.get(i);
				ICompositeNode node = NodeModelUtils.findActualNodeFor(expression);
				if (node != null)
					stringBuilder.append(node.getText().trim());
			}
		}
		stringBuilder.append(")");
		return stringBuilder.toString();
	}

	private static final class XtendHoverXbaseSwitch extends XbaseSwitch<String> {
		@Override
		public String caseXAbstractFeatureCall(XAbstractFeatureCall object) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(object);
			if (node != null)
				return node.getText();
			else
				return object.getFeature().getSimpleName();
		}

		@Override
		public String caseXExpression(XExpression object) {
			if (object != null) {
				ICompositeNode node = NodeModelUtils.findActualNodeFor(object);
				if (node != null)
					return node.getText();
			}
			return "";
		}
	}

	public Pair<String, String> computePreAndSuffix(EObject element) {
		ICompositeNode node = NodeModelUtils.getNode(element);
		if (node != null) {
			XtextResource resource = (XtextResource) element.eResource();
			if (resource != null) {
				IParseResult parseResult = resource.getParseResult();
				if (parseResult != null) {
					String model = parseResult.getRootNode().getText();
					return Tuples.create(model.substring(0, node.getTotalOffset()) + "\n",
							"\n" + model.substring(node.getTotalEndOffset()));
				}
			}
		}
		return Tuples.create("", "");

	}
}
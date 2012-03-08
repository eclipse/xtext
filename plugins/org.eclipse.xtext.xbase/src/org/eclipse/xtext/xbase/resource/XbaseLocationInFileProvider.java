/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.conversion.StaticQualifierValueConverter;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class XbaseLocationInFileProvider extends DefaultLocationInFileProvider {
	
	@Inject
	private StaticQualifierValueConverter staticQualifierValueConverter; 
	
	@Override
	public ITextRegion getSignificantTextRegion(EObject element) {
		if(element instanceof XSwitchExpression && ((XSwitchExpression)element).getLocalVarName() != null) {
			 return getLocationOfAttribute(element, XbasePackage.Literals.XSWITCH_EXPRESSION__LOCAL_VAR_NAME, -1, true);
		}
		return super.getSignificantTextRegion(element);
	}
	
	@Override
	protected ITextRegion getLocationOfCrossReference(EObject owner, EReference reference, int indexInList,
			boolean isSignificant) {
		if (owner instanceof XFeatureCall && reference == XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE && isSignificant) {
			List<INode> nodes = NodeModelUtils.findNodesForFeature(owner, reference);
			if (!nodes.isEmpty()) {
				INode qualifierNode = nodes.get(0);
				ITextRegion result = ITextRegion.EMPTY_REGION;
				INode pending = null;
				String delimiter = staticQualifierValueConverter.getStringNamespaceDelimiter();
				for (INode node : qualifierNode.getLeafNodes()) {
					if (!isHidden(node)) {
						int length = node.getLength();
						if (length != 0) {
							if (pending != null) {
								result.merge(new TextRegionWithLineInformation(pending.getOffset(), length, pending.getStartLine() - 1, pending.getEndLine() - 1));
								pending = null;
							}
							if (delimiter.equals(node.getText())) {
								pending = node;
							} else {
								result = result.merge(new TextRegionWithLineInformation(node.getOffset(), length, node.getStartLine() - 1, node.getEndLine() - 1));
							}
						}
					}
				}
				return result;
			}
		}
		return super.getLocationOfCrossReference(owner, reference, indexInList, isSignificant);
	}
	
	@Override
	protected List<INode> getLocationNodes(EObject obj) {
		if (obj instanceof XMemberFeatureCall || obj instanceof XAssignment || obj instanceof XFeatureCall) {
			List<INode> resultNodes = Lists.newArrayList();
			final ICompositeNode startNode = findNodeFor(obj);
			boolean crossRefConsumed = false;
			for (INode child : startNode.getChildren()) {
				if (crossRefConsumed) {
					resultNodes.add(child);
				} else {
					EObject grammarElement = child.getGrammarElement();
					if (grammarElement instanceof CrossReference) {
						// We don't use the grammar access to be more robust against
						// overwriting grammars
						Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
						if (XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE.getName().equals(assignment.getFeature())) {
							crossRefConsumed = true;
							resultNodes.add(child);
						}
					}
				} 
			}
			if (!resultNodes.isEmpty())
				return resultNodes;
		}
		return super.getLocationNodes(obj);
	}
	
	@Override
	protected boolean useKeyword(Keyword keyword, EObject context) {
//		String value = keyword.getValue();
//		for(int i = 0; i < value.length(); i++) {
//			char c = value.charAt(i);
//			if (Character.isJavaIdentifierPart(c)) {
//				return true;
//			}
//		}
		return false;
	}

}

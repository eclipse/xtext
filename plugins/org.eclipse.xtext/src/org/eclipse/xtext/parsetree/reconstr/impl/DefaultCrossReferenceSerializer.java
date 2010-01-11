/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultCrossReferenceSerializer extends AbstractCrossReferenceSerializer {

	@Inject
	protected LinkingHelper linkingHelper;

	@Inject
	protected ILinkingService linkingService;

	@Inject
	protected IScopeProvider scopeProvider;

	@Inject
	protected IValueConverterService valueConverter;

	protected String getConvertedValue(String unconverted, CrossReference grammarElement) {
		String ruleName = linkingHelper.getRuleNameFrom(grammarElement);
		if (ruleName == null)
			throw new IllegalStateException("Cound not determine targeted rule name for "
					+ EmfFormatter.objPath(grammarElement));
		return valueConverter.toString(unconverted, ruleName);
	}

	protected AbstractNode getCrossReferenceNode(EObject object, EReference reference, EObject context) {
		List<AbstractNode> nodes = NodeUtil.findNodesForFeature(context, reference);
		if (!nodes.isEmpty()) {
			if (reference.isMany()) {
				int index = ((List<?>) context.eGet(reference, false)).indexOf(object);
				if (index >= 0 && index < nodes.size())
					return nodes.get(index);
			} else {
				return nodes.get(0);
			}
		}
		return null;
	}

	protected String getUnconvertedLinkText(EObject object, EReference reference, EObject context) {
		IScope scope = scopeProvider.getScope(context, reference);
		if (scope == null)
			return null;
		IEObjectDescription eObjectDescription = scope.getContentByEObject(object);
		if (eObjectDescription != null)
			return eObjectDescription.getName();
		return null;
	}

	@Override
	public String serializeCrossRef(EObject context, CrossReference grammarElement, EObject target) {
		final EReference ref = GrammarUtil.getReference(grammarElement, context.eClass());
		String text = null;
		AbstractNode node = getCrossReferenceNode(target, ref, context);
		if (node != null)
			text = getLinkTextFromNodeModel(context, ref, target, node);
		if (text != null)
			return text;
		text = getUnconvertedLinkText(target, ref, context);
		if (text != null)
			return getConvertedValue(text, grammarElement);
		if (node != null) {
			return linkingHelper.getCrossRefNodeAsString(node, false);
		}
		return null;
	}

	protected String getLinkTextFromNodeModel(EObject context, final EReference ref, EObject target, AbstractNode node) {
		List<EObject> objects = linkingService.getLinkedObjects(context, ref, node);
		if (objects.contains(target)) {
			return linkingHelper.getCrossRefNodeAsString(node, false);
		}
		return null;
	}

}

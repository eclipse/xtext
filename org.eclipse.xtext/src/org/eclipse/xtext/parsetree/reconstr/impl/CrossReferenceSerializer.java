/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.ICrossReferenceSerializer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class CrossReferenceSerializer implements ICrossReferenceSerializer {

	@Inject
	private LinkingHelper linkingHelper;

	@Inject
	private ILinkingService linkingService;

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private IValueConverterService valueConverter;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public boolean equalsOrReplacesNode(EObject context, CrossReference crossref, EObject target, INode node) {
		if (crossref != node.getGrammarElement())
			return false;
		EReference ref = GrammarUtil.getReference(crossref);
		if (!ref.isMany())
			return true;
		List<EObject> objects = linkingService.getLinkedObjects(context, ref, node);
		return objects.contains(target);
	}

	protected String getConvertedValue(String unconverted, CrossReference grammarElement) {
		String ruleName = linkingHelper.getRuleNameFrom(grammarElement);
		if (ruleName == null)
			throw new IllegalStateException("Could not determine targeted rule name for "
					+ EmfFormatter.objPath(grammarElement));
		return valueConverter.toString(unconverted, ruleName);
	}

	protected String getUnconvertedLinkText(EObject object, EReference reference, EObject context) {
		IScope scope = scopeProvider.getScope(context, reference);
		if (scope == null)
			return null;
		IEObjectDescription eObjectDescription = scope.getSingleElement(object);
		if (eObjectDescription != null) {
			return qualifiedNameConverter.toString(eObjectDescription.getName());
		}
		return null;
	}

	@Override
	public boolean isValid(EObject context, CrossReference crossref, EObject target, IErrorAcceptor errorAcceptor) {
		try {
			final EReference ref = GrammarUtil.getReference(crossref, context.eClass());
			String text = getUnconvertedLinkText(target, ref, context);
			if (text == null)
				return true; // maybe we'll find something useful in the node model later on?
			getConvertedValue(text, crossref);
			return true;
		} catch (ValueConverterException e) {
			if (errorAcceptor != null)
				errorAcceptor.error(e.getMessage());
			return false;
		}
	}

	@Override
	public String serializeCrossRef(EObject context, CrossReference grammarElement, final EObject target, INode node) {
		final EReference ref = GrammarUtil.getReference(grammarElement, context.eClass());
		String text = null;
		if (node != null) {
			List<EObject> objects = linkingService.getLinkedObjects(context, ref, node);
			if (Iterables.any(objects, new Predicate<EObject>() {
				private final URI targetURI = EcoreUtil.getURI(target);
				@Override
				public boolean apply(EObject input) {
					return input == target || EcoreUtil.getURI(input).equals(targetURI);
				}
			}))
				return ITokenSerializer.KEEP_VALUE_FROM_NODE_MODEL;
		}
		text = getUnconvertedLinkText(target, ref, context);
		if (text != null)
			return getConvertedValue(text, grammarElement);
		if (node != null) {
			return linkingHelper.getCrossRefNodeAsString(node, false);
		}
		return null;
	}

}

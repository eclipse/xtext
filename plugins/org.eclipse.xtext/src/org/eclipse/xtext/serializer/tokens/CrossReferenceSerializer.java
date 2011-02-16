/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.tokens;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.diagnostic.ITokenDiagnosticProvider;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class CrossReferenceSerializer implements ICrossReferenceSerializer {

	@Inject
	protected ITokenDiagnosticProvider diagnostics;

	@Inject
	private LinkingHelper linkingHelper;

	@Inject
	private ILinkingService linkingService;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	protected TokenUtil tokenUtil;

	//	public boolean equalsOrReplacesNode(EObject context, CrossReference crossref, EObject target, INode node) {
	//		if (crossref != node.getGrammarElement())
	//			return false;
	//		EReference ref = GrammarUtil.getReference(crossref);
	//		if (!ref.isMany())
	//			return true;
	//		List<EObject> objects = linkingService.getLinkedObjects(context, ref, node);
	//		return objects.contains(target);
	//	}

	@Inject
	private IValueConverterService valueConverter;

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

	public boolean isValid(EObject context, CrossReference crossref, EObject target, Acceptor errors) {
		String text = null;
		try {
			final EReference ref = GrammarUtil.getReference(crossref, context.eClass());
			text = getUnconvertedLinkText(target, ref, context);
			if (text == null)
				return true; // maybe we'll find something useful in the node model later on?
			getConvertedValue(text, crossref);
			return true;
		} catch (ValueConverterException e) {
			if (errors != null)
				errors.accept(diagnostics.getValueConversionExceptionDiagnostic(context, crossref, text, e));
			return false;
		}
	}

	public String serializeCrossRef(EObject context, CrossReference crossref, EObject target, INode node,
			Acceptor errorAcceptor) {
		final EReference ref = GrammarUtil.getReference(crossref, context.eClass());
		String text = null;
		if (node != null) {
			List<EObject> objects = linkingService.getLinkedObjects(context, ref, node);
			if (objects.contains(target))
				return tokenUtil.serializeNode(node);
		}
		text = getUnconvertedLinkText(target, ref, context);
		if (text != null)
			return getConvertedValue(text, crossref);
		if (node != null) {
			return linkingHelper.getCrossRefNodeAsString(node, false);
		}
		return null;
	}

}

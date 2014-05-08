/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.tokens;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.diagnostic.ITokenDiagnosticProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class CrossReferenceSerializer implements ICrossReferenceSerializer {

	@Inject
	protected ITokenDiagnosticProvider diagnostics;

	@Inject
	private LinkingHelper linkingHelper;

	//	@Inject
	//	private ILinkingService linkingService;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	@SerializerScopeProviderBinding
	private IScopeProvider scopeProvider;

	@Inject
	protected TokenUtil tokenUtil;

	@Inject
	private IValueConverterService valueConverter;

	public boolean isValid(EObject semanticObject, CrossReference crossref, EObject target, INode node, Acceptor errors) {
		if (target.eIsProxy() && node != null) {
			CrossReference crossrefFromNode = GrammarUtil.containingCrossReference(node.getGrammarElement());
			return crossref == crossrefFromNode;
		}
		final EReference ref = GrammarUtil.getReference(crossref, semanticObject.eClass());
		final IScope scope = scopeProvider.getScope(semanticObject, ref);
		if (scope == null) {
			if (errors != null)
				errors.accept(diagnostics.getNoScopeFoundDiagnostic(semanticObject, crossref, target));
			return false;
		}
		return getCrossReferenceNameFromScope(semanticObject, crossref, target, scope, errors) != null;
	}

	public String serializeCrossRef(EObject semanticObject, CrossReference crossref, EObject target, INode node,
			Acceptor errors) {

		if ((target == null || target.eIsProxy()) && node != null)
			return tokenUtil.serializeNode(node);

		final EReference ref = GrammarUtil.getReference(crossref, semanticObject.eClass());
		final IScope scope = scopeProvider.getScope(semanticObject, ref);
		if (scope == null) {
			if (errors != null)
				errors.accept(diagnostics.getNoScopeFoundDiagnostic(semanticObject, crossref, target));
			return null;
		}

		if (target != null && node != null) {
			String text = linkingHelper.getCrossRefNodeAsString(node, true);
			QualifiedName qn = qualifiedNameConverter.toQualifiedName(text);
			URI targetURI = EcoreUtil.getURI(target);
			if (target.eResource() != null && target.eResource().getResourceSet() != null)
				targetURI = target.eResource().getResourceSet().getURIConverter().normalize(targetURI);
			for (IEObjectDescription desc : scope.getElements(qn))
				if (desc.getEObjectURI().equals(targetURI))
					return tokenUtil.serializeNode(node);
		}

		return getCrossReferenceNameFromScope(semanticObject, crossref, target, scope, errors);
	}

	protected String getCrossReferenceNameFromScope(EObject semanticObject, CrossReference crossref, EObject target,
			final IScope scope, Acceptor errors) {
		String ruleName = linkingHelper.getRuleNameFrom(crossref);
		boolean foundOne = false;
		List<ISerializationDiagnostic> recordedErrros = null;
		for (IEObjectDescription desc : scope.getElements(target)) {
			foundOne = true;
			String unconverted = qualifiedNameConverter.toString(desc.getName());
			try {
				return valueConverter.toString(unconverted, ruleName);
			} catch (ValueConverterException e) {
				if (errors != null) {
					if (recordedErrros == null)
						recordedErrros = Lists.newArrayList();
					recordedErrros.add(diagnostics.getValueConversionExceptionDiagnostic(semanticObject, crossref,
							unconverted, e));
				}
			}
		}
		if (errors != null) {
			if (recordedErrros != null)
				for (ISerializationDiagnostic diag : recordedErrros)
					errors.accept(diag);
			if (!foundOne)
				errors.accept(diagnostics.getNoEObjectDescriptionFoundDiagnostic(semanticObject, crossref, target,
						scope));
		}
		return null;
	}

}

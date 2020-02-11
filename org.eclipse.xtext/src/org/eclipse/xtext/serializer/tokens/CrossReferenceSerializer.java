/*******************************************************************************
 * Copyright (c) 2008, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.tokens;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
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

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	@SerializerScopeProviderBinding
	private IScopeProvider scopeProvider;

	@Inject
	protected TokenUtil tokenUtil;

	@Inject
	private IValueConverterService valueConverter;

	@Override
	public boolean isValid(EObject semanticObject, CrossReference crossref, EObject target, INode node, Acceptor errors) {
		if ((target == null || target.eIsProxy()) && node != null) {
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
		
		if (target != null && target.eIsProxy()) {
			target = handleProxy(target, semanticObject, ref);
		}
		
		return getCrossReferenceNameFromScope(semanticObject, crossref, target, scope, errors) != null;
	}

	@Override
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
		
		if (target != null && target.eIsProxy()) {
			target = handleProxy(target, semanticObject, ref);
		}

		if (target != null && node != null) {
			String text = linkingHelper.getCrossRefNodeAsString(node, true);
			QualifiedName qn = qualifiedNameConverter.toQualifiedName(text);
			URI targetURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(target);
			for (IEObjectDescription desc : scope.getElements(qn)) {
				if (targetURI.equals(desc.getEObjectURI()))
					return tokenUtil.serializeNode(node);
			}
		}

		return getCrossReferenceNameFromScope(semanticObject, crossref, target, scope, errors);
	}

	protected String getCrossReferenceNameFromScope(EObject semanticObject, CrossReference crossref, EObject target,
			final IScope scope, Acceptor errors) {
		String ruleName = linkingHelper.getRuleNameFrom(crossref);
		boolean foundOne = false;
		List<ISerializationDiagnostic> recordedErrors = null;
		for (IEObjectDescription desc : scope.getElements(target)) {
			foundOne = true;
			String unconverted = qualifiedNameConverter.toString(desc.getName());
			try {
				return valueConverter.toString(unconverted, ruleName);
			} catch (ValueConverterException e) {
				if (errors != null) {
					if (recordedErrors == null)
						recordedErrors = Lists.newArrayList();
					recordedErrors.add(diagnostics.getValueConversionExceptionDiagnostic(semanticObject, crossref,
							unconverted, e));
				}
			}
		}
		if (errors != null) {
			if (recordedErrors != null)
				for (ISerializationDiagnostic diag : recordedErrors)
					errors.accept(diag);
			if (!foundOne)
				errors.accept(diagnostics.getNoEObjectDescriptionFoundDiagnostic(semanticObject, crossref, target,
						scope));
		}
		return null;
	}
	
	/**
	 * @since 2.11
	 */
	protected EObject handleProxy(EObject proxy, EObject semanticObject, EReference reference) {
		if (reference != null && reference.isResolveProxies()) {
			if (reference.isMany()) {
				@SuppressWarnings("unchecked")
				EList<? extends EObject> list = (EList<? extends EObject>) semanticObject.eGet(reference);
				int index = list.indexOf(proxy);
				if (index >= 0)
					return list.get(index);
			} else {
				return (EObject) semanticObject.eGet(reference, true);
			}
		}
		return EcoreUtil.resolve(proxy, semanticObject);
	}

}

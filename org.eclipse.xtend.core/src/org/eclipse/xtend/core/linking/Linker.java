/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.linking;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ResourceSetContext;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.linking.XbaseLazyLinker;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Optimized lazy linker implementation for Xtend. It's based on the {@link org.eclipse.xtext.xbase.resource.BatchLinkableResource BatchLinkableResource}.
 * 
 * It also validates the concrete syntax of the cross link text.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class Linker extends XbaseLazyLinker {
	
	@Inject
	private IValueConverterService valueConverterService;
	
	/**
	 * Xtend does not use the grammar pattern where the cross reference is defined 
	 * in a rule that did not instantiate the object.
	 */
	@Override
	protected boolean shouldCheckParentNode(INode node) {
		return false;
	}
	
	@Override
	protected boolean isClearAllReferencesRequired(Resource resource) {
		return ResourceSetContext.get(resource).isEditor();
	}
	
	@Override
	protected boolean hasLeafNodes(INode node) {
		if (node.getTotalLength() > 0)
			return true;
		if (node instanceof ICompositeNode) {
			return ((ICompositeNode) node).getLastChild() instanceof ILeafNode;
		}
		return false;
	}
	
	@Override
	protected void afterCreateAndSetProxy(EObject obj, INode node, EReference eRef, CrossReference xref, IDiagnosticProducer diagnosticProducer) {
		AbstractElement terminal = xref.getTerminal();
		if (!(terminal instanceof RuleCall)) { 
			throw new IllegalArgumentException(String.valueOf(xref));
		}
		AbstractRule rule = ((RuleCall) terminal).getRule();
		try {
			String tokenText = NodeModelUtils.getTokenText(node);
			valueConverterService.toValue(tokenText, rule.getName(), node);
		} catch(ValueConverterException e) {
			diagnosticProducer.addDiagnostic(new DiagnosticMessage(e.getMessage(), Severity.ERROR, Diagnostic.SYNTAX_DIAGNOSTIC, Strings.EMPTY_ARRAY));
		}
	}
	
	@Override
	protected EClass getProxyType(EObject obj, EReference eRef) {
		EClass referenceType = eRef.getEReferenceType();
		if (referenceType == TypesPackage.Literals.JVM_TYPE 
				|| referenceType == TypesPackage.Literals.JVM_IDENTIFIABLE_ELEMENT)
			return TypesPackage.Literals.JVM_VOID;
		if (referenceType == TypesPackage.Literals.JVM_DECLARED_TYPE)
			return TypesPackage.Literals.JVM_GENERIC_TYPE;
		return referenceType;
	}
}

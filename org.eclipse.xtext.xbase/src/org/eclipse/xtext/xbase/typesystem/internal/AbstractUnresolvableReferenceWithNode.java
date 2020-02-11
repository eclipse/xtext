/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractUnresolvableReferenceWithNode extends AbstractUnresolvableReference implements ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext {
	private final String text;
	private final INode node;

	public AbstractUnresolvableReferenceWithNode(XExpression expression, INode node, String text, ExpressionTypeComputationState state) {
		super(expression, state);
		this.node = node;
		this.text = text;
	}

	@Override
	public void applyToModel(IResolvedTypes resolvedTypes) {
		Resource resource = getExpression().eResource();
		if (resource instanceof LazyLinkingResource) {
			LazyLinkingResource lazyLinkingResource = (LazyLinkingResource) resource;
			
			TypeAwareLinkingDiagnosticContext context = new TypeAwareLinkingDiagnosticContext(this, resolvedTypes);
			DiagnosticMessage message = lazyLinkingResource.getDiagnosticMessageProvider()
					.getUnresolvedProxyMessage(context);
			if (message != null) {
				List<Resource.Diagnostic> diagnostics = getDiagnosticList(lazyLinkingResource, message);
				Diagnostic diagnostic = createDiagnostic(message);
				diagnostics.add(diagnostic);
			}
			EObject referenced = (InternalEObject) getExpression().eGet(getReference(), false);
			lazyLinkingResource.markUnresolvable(referenced);
		}
	}
	
	protected Resource.Diagnostic createDiagnostic(DiagnosticMessage message) {
		Diagnostic diagnostic = new XtextLinkingDiagnostic(
				node, 
				message.getMessage(),
				message.getIssueCode(), message.getIssueData());
		return diagnostic;
	}
	
	protected List<Diagnostic> getDiagnosticList(LazyLinkingResource resource, /* @Nullable */ DiagnosticMessage message) throws AssertionError {
		if (message != null) {
			switch (message.getSeverity()) {
				case ERROR:
					return resource.getErrors();
				case WARNING:
					return resource.getWarnings();
				default:
					throw new AssertionError("Unexpected severity: " + message.getSeverity());
			}
		}
		return Collections.emptyList();
	}
	
	protected INode getNode() {
		return node;
	}

	@Override
	public String getLinkText() {
		return text;
	}
	
}

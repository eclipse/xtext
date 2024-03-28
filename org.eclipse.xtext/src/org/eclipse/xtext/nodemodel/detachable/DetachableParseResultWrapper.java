/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.detachable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.diagnostics.AbstractDiagnosticProducerDecorator;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.ParseResultWrapper;
import org.eclipse.xtext.util.Triple;

/**
 * @since 2.35
 */
public class DetachableParseResultWrapper extends ParseResultWrapper {

	@Override
	public Triple<EObject, EReference, INode> toProxyInformation(IParseResult parseResult, EObject obj, EReference ref,
			INode node) {
		AbstractDetachableParseResult<?, ?> casted = (AbstractDetachableParseResult<?, ?>) parseResult;
		return super.toProxyInformation(parseResult, obj, ref, casted.toExternalReference(node));
	}
	
	@Override
	public IDiagnosticProducer wrap(IParseResult parseResult, IDiagnosticProducer producer) {
		return new AbstractDiagnosticProducerDecorator(producer) {
			@Override
			public void setNode(INode node) {
				super.setNode(externalReference(parseResult, node));
			}
		};
	}
	
	public INode externalReference(IParseResult parseResult, INode node) {
		AbstractDetachableParseResult<?, ?> casted = (AbstractDetachableParseResult<?, ?>) parseResult;
		return casted.toExternalReference(node);
	}
	
	@Override
	public IParseResult release(IParseResult parseResult) {
		if (parseResult != null) {
			((AbstractDetachableParseResult<?, ?>)parseResult).discard();
		}
		return super.release(parseResult);
	}
	
}

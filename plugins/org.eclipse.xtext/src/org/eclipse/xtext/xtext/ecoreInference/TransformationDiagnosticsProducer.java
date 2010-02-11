/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.diagnostics.AbstractDiagnosticProducer;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.DiagnosticSeverity;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TransformationDiagnosticsProducer extends AbstractDiagnosticProducer implements ErrorAcceptor {

	private TransformationErrorCode lastError;
	
	public TransformationDiagnosticsProducer(IDiagnosticConsumer consumer) {
		super(consumer);
	}

	@Override
	protected Diagnostic createDiagnostic(DiagnosticMessage message) {
		return new TransformationDiagnostic(getNode(), message.getMessage(), lastError);
	}

	public void acceptError(TransformationErrorCode errorCode, String message, EObject element) {
		setTarget(element, null);
		lastError = errorCode;
		addDiagnostic(new DiagnosticMessage(message, DiagnosticSeverity.ERROR, null));	
		lastError = null;
	}
	
	@Override
	public void setTarget(EObject object, EStructuralFeature feature) {
		EObject myObject = object;
		NodeAdapter adapter = NodeUtil.getNodeAdapter(myObject);
		while (adapter == null) {
			myObject = myObject.eContainer();
			if (myObject == null)
				break;
			adapter = NodeUtil.getNodeAdapter(myObject);
		}
		if (adapter == null)
			throw new IllegalStateException("Cannot find NodeAdapter for object: " + myObject);
		setNode(adapter.getParserNode());
	}

}

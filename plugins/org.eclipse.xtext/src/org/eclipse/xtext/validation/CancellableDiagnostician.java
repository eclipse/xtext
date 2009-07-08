/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.Diagnostician;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CancellableDiagnostician extends Diagnostician {
	
	public static final String CANCEL_INDICATOR = "org.eclipse.xtext.validation.CancellableDiagnostician.CANCEL_INDICATOR";
	
	@Inject
	public CancellableDiagnostician(EValidator.Registry registry) {
		super(registry);
	}
	
	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		CancelIndicator indicator = context != null ? (CancelIndicator) context.get(CANCEL_INDICATOR) : null;
		if (indicator != null && indicator.isCancelled())
			return true;
		return super.validate(eObject, diagnostics, context);
	}
	
	@Override
	protected boolean doValidateContents(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		CancelIndicator indicator = context != null ? (CancelIndicator) context.get(CANCEL_INDICATOR) : null;
		if (indicator != null && indicator.isCancelled())
			return true;
		return super.doValidateContents(eObject, diagnostics, context);
	}

}

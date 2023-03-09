/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CancelableDiagnostician extends Diagnostician {
	
	public static final String CANCEL_INDICATOR = CancelableDiagnostician.class + ".CANCEL_INDICATOR";
	
	@Inject
	private OperationCanceledManager operationCanceledManager;
	
	@Inject
	public CancelableDiagnostician(EValidator.Registry registry) {
		super(registry);
	}
	
	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		checkCanceled(context);
		return super.validate(eClass, eObject, diagnostics, context);
	}
	
	/**
	 * @since 2.9
	 */
	protected void checkCanceled(Map<Object, Object> context) {
		operationCanceledManager.checkCanceled(getCancelIndicator(context));
	}
	
	/**
	 * <p>
	 * Use {@link #checkCanceled} instead to throw a platform specific cancellation exception.
	 * </p> 
	 */
	@Deprecated
	protected boolean isCanceled(Map<Object, Object> context) {
		CancelIndicator indicator = getCancelIndicator(context);
		return indicator != null && indicator.isCanceled();
	}
	
	/**
	 * @since 2.9
	 */
	protected CancelIndicator getCancelIndicator(Map<Object, Object> context) {
		return context != null ? (CancelIndicator) context.get(CANCEL_INDICATOR) : null;
	}

}

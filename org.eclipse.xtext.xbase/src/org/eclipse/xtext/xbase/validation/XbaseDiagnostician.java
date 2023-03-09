/*******************************************************************************
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.validation.CancelableDiagnostician;
import org.eclipse.xtext.xbase.XClosure;

import com.google.inject.Inject;

/**
 * This class was created for EMF 2.5 compatibility. 
 * 
 * @since 2.4
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class XbaseDiagnostician extends CancelableDiagnostician {

	@Inject
	public XbaseDiagnostician(EValidator.Registry registry) {
		super(registry);
	}
	
	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		checkCanceled(context);
		if (eObject instanceof XClosure) {
			return super.validate(eClass, eObject, diagnostics, context)
					&& doValidateLambdaContents((XClosure) eObject, diagnostics, context);
		}
		return super.validate(eClass, eObject, diagnostics, context);

	}

	/**
	 * This was here for EMF 2.5 compatibility and was refactored to a no-op.
	 */
	@Deprecated
	protected boolean doValidateLambdaContents(XClosure closure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

}

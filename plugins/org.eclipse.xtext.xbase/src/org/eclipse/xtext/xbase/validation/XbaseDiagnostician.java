/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.validation.CancelableDiagnostician;
import org.eclipse.xtext.xbase.XClosure;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;

/**
 * A customized diagnostician that explicitly traverses derived contained elements
 * if they are not contained in the contents of an EObject. This is for EMF 2.5 compatibility. 
 * 
 * @since 2.4
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
public class XbaseDiagnostician extends CancelableDiagnostician {

	@Inject
	public XbaseDiagnostician(EValidator.Registry registry) {
		super(registry);
	}

	@Override
	protected boolean doValidateContents(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		checkCanceled(context);
		if (eObject instanceof XClosure) {
			return doValidateLambdaContents((XClosure) eObject, diagnostics, context);
		}
		return super.doValidateContents(eObject, diagnostics, context);
	}

	/**
	 * Validates the implicit first parameter explicitly if it was not contained in {@link EObject#eContents()}.
	 */
	protected boolean doValidateLambdaContents(XClosure closure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		List<JvmFormalParameter> implicitParameters = closure.getImplicitFormalParameters();
		boolean parameterVisited = implicitParameters.isEmpty();
		List<EObject> eContents = closure.eContents();
		if (!eContents.isEmpty()) {
			Iterator<EObject> i = eContents.iterator();
			EObject child = i.next();
			if (child != null && child.eClass() == TypesPackage.Literals.JVM_FORMAL_PARAMETER && implicitParameters.contains(child)) {
				parameterVisited = true;
			}
			boolean result = validate(child, diagnostics, context);
			while (i.hasNext() && (result || diagnostics != null)) {
				child = i.next();
				if (child != null && child.eClass() == TypesPackage.Literals.JVM_FORMAL_PARAMETER && implicitParameters.contains(child)) {
					parameterVisited = true;
				}
				result &= validate(child, diagnostics, context);
			}
			if (!parameterVisited) {
				for(int idx = 0; idx < implicitParameters.size(); idx++) {
					result &= validate(implicitParameters.get(idx), diagnostics, context);
				}
			}
			return result;
		} else {
			if (!parameterVisited) {
				boolean result = true;
				for(int idx = 0; idx < implicitParameters.size(); idx++) {
					result &= validate(implicitParameters.get(idx), diagnostics, context);
				}
				return result;
			}
			return true;
		}
	}

}

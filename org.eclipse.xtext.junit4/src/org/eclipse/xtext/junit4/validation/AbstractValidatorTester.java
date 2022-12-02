/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.validation;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated(forRemoval = true, since = "2.30")
public abstract class AbstractValidatorTester {

	protected Diagnostician diagnostician;

	public AssertableDiagnostics validate(EDataType type, Object obj) {
		Diagnostic d = diagnostician.validate(type, obj);
		return new AssertableDiagnostics(d);
	}
	
	public AssertableDiagnostics validate(EObject obj) {
		Diagnostic d = diagnostician.validate(obj);
		return new AssertableDiagnostics(d);
	}

	public AssertableDiagnostics validate(EObject obj, Map<?,?> contextEntries) {
		Diagnostic d = diagnostician.validate(obj, contextEntries);
		return new AssertableDiagnostics(d);
	}

}

/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.ImplementedBy;

/**
 * Implement a diagnostic converter if you want to customize the region that is computed for 
 * resource diagnostics or validation diagnostics.
 * The acceptor allows more than one issue per diagnostic to be created.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(DiagnosticConverterImpl.class)
public interface IDiagnosticConverter {

	/**
	 * Convert a resource diagnostic to zero, one or more markers.
	 */
	void convertResourceDiagnostic(
			org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic, Severity severity, IAcceptor<Issue> acceptor);
	
	/**
	 * Convert a validation diagnostic to zero, one or more markers.
	 */
	void convertValidatorDiagnostic(org.eclipse.emf.common.util.Diagnostic diagnostic, IAcceptor<Issue> acceptor);
}

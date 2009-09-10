/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import java.util.Map;

import com.google.inject.ImplementedBy;

/**
 * Implement a diagnostic converter if you want to customize the region that is computed for 
 * resource diagnostics or validation diagnostics.
 * The acceptor allows more than one marker per diagnostic to be created.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(DefaultDiagnosticConverter.class)
public interface IDiagnosticConverter {

	/**
	 * Accepts the created markers.
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	public interface Acceptor {
		
		/**
		 * Accepts the create markers. Implementors should ignore any null values that are passed to this method.
		 * @param marker the marker to be accepted. May be null.
		 */
		void accept(Map<String, Object> marker);
	}
	
	/**
	 * Convert a resource diagnostic to zero, one or more markers.
	 */
	void convertResourceDiagnostic(
			org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic, Object severity, Acceptor acceptor);
	
	/**
	 * Convert a validation diagnostic to zero, one or more markers.
	 */
	void convertValidatorDiagnostic(org.eclipse.emf.common.util.Diagnostic diagnostic, Acceptor acceptor);
}

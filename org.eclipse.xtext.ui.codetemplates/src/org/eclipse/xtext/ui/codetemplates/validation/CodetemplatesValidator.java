/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.validation;

import org.eclipse.xtext.ui.codetemplates.templates.Dollar;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;
import org.eclipse.xtext.validation.Check;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class CodetemplatesValidator extends AbstractCodetemplatesValidator {
	
	@Check
	public void checkDollarEscaped(Dollar dollar) {
		if (!dollar.isEscaped())
			error("Invalid escape sequence '$'", null);
	}
	
	@Override
	public boolean isLanguageSpecific() {
		return false;
	}

	/**
	 * @since 2.3
	 */
	@Check
	public void checkParameterListIsNotEmpty(Variable variable) {
		if (variable.isExpectingParameters()) {
			if (variable.getParameters().isEmpty()) {
				error("Parameter list may not be empty", null);
			}
		}
	}
	
}

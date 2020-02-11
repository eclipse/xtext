/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.resolvers;

import org.eclipse.xtext.ui.codetemplates.templates.Variable;
import org.eclipse.xtext.ui.editor.templates.CrossReferenceTemplateVariableResolver;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InspectableCrossReferenceVariableResolver extends InspectableTemplateVariableResolverDecorator {

	public InspectableCrossReferenceVariableResolver(CrossReferenceTemplateVariableResolver resolver) {
		super(resolver);
	}
	
	@Override
	public boolean hasMandatoryParameters() {
		return true;
	}

	@Override
	public boolean canHaveParameters() {
		return true;
	}

	@Override
	public void validateParameters(Variable variable, ValidationMessageAcceptor validationMessageAcceptor) {
		super.validateParameters(variable, validationMessageAcceptor);
	}

}
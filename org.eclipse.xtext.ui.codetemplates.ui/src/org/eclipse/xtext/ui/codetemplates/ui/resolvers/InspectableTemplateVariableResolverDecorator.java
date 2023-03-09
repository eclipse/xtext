/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.resolvers;

import org.eclipse.jface.text.templates.TemplateVariableResolver;
import org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class InspectableTemplateVariableResolverDecorator implements IInspectableTemplateVariableResolver {

	protected final TemplateVariableResolver decorated;
	
	public InspectableTemplateVariableResolverDecorator(TemplateVariableResolver decorated) {
		this.decorated = decorated;
	}
	
	@Override
	public String getDescription() {
		return decorated.getDescription();
	}
	
	@Override
	public String getType() {
		return decorated.getType();
	}
	
	@Override
	public boolean canHaveParameters() {
		return false;
	}
	
	@Override
	public boolean hasMandatoryParameters() {
		return false;
	}
	
	@Override
	public void validateParameters(Variable variable, ValidationMessageAcceptor validationMessageAcceptor) {
		if (!canHaveParameters()) {
			if (variable.getParameters().size() > 0)
				validationMessageAcceptor.acceptError(getUnexpectedParametersMessage(), 
						variable, TemplatesPackage.Literals.VARIABLE__PARAMETERS, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
		}
		if (hasMandatoryParameters()) {
			if (variable.getParameters().isEmpty()) {
				validationMessageAcceptor.acceptError(getMandatorParametersMessage(), 
						variable, TemplatesPackage.Literals.VARIABLE__TYPE, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
			}
		}
	}

	protected String getUnexpectedParametersMessage() {
		return getType() + "-variables do not accept parameters.";
	}
	
	protected String getMandatorParametersMessage() {
		return getType() + "-variables have mandatory parameters.";
	}
}

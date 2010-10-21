/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	
	public String getDescription() {
		return decorated.getDescription();
	}
	
	public String getType() {
		return decorated.getType();
	}
	
	public boolean canHaveParameters() {
		return false;
	}
	
	public boolean hasMandatoryParameters() {
		return false;
	}
	
	public void validateParameters(Variable variable, ValidationMessageAcceptor validationMessageAcceptor) {
		if (!canHaveParameters()) {
			if (variable.getParameters().size() > 0)
				validationMessageAcceptor.acceptError(getUnexpectedParametersMessage(), 
						variable, variable.eClass().getFeatureID(TemplatesPackage.Literals.VARIABLE__PARAMETERS), null);
		}
		if (hasMandatoryParameters()) {
			if (variable.getParameters().isEmpty()) {
				validationMessageAcceptor.acceptError(getMandatorParametersMessage(), 
						variable, variable.eClass().getFeatureID(TemplatesPackage.Literals.VARIABLE__TYPE), null);
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

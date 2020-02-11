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
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IInspectableTemplateVariableResolver {

	String getType();
	
	String getDescription();
	
	boolean hasMandatoryParameters();
	
	boolean canHaveParameters();
	
	void validateParameters(Variable variable, ValidationMessageAcceptor validationMessageAcceptor);
	
}

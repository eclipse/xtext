/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.validator.preferences;

import static org.eclipse.xtend.core.validation.IssueCodes.*;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.xbase.ui.validation.XbaseValidationConfigurationBlock;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendValidatorConfigurationBlock extends XbaseValidationConfigurationBlock {

	@Override
	protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {
		super.fillSettingsPage(composite, nColumns, defaultIndent);
		fillDispatchSection(new ComboBoxBuilder(this, createSection("Dispatch methods", composite, nColumns),
				defaultIndent));
		fillJavaDocSection(new ComboBoxBuilder(this,createSection("Javadoc", composite, nColumns),
				defaultIndent));
	}

	protected void fillDispatchSection(ComboBoxBuilder builder) {
		builder.addComboBox(DISPATCH_PLAIN_FUNCTION_NAME_CLASH, "Dispatch and non-dispatch method name clash:").addComboBox(
				SINGLE_DISPATCH_FUNCTION, "Single dispatch method:");
	}
	/**
	 * @see org.eclipse.xtend.core.validation.XtendConfigurableIssueCodes
	 */
	protected void fillJavaDocSection(ComboBoxBuilder builder) {
		builder.addJavaDelegatingComboBox(JAVA_DOC_LINKING_DIAGNOSTIC, "Unresolved references");
	}

	@Override
	protected void fillUnusedCodeSection(ComboBoxBuilder builder) {
		super.fillUnusedCodeSection(builder);
		builder.addJavaDelegatingComboBox(UNUSED_PRIVATE_MEMBER, "Unused private member:");
	}
	
	@Override
	protected void fillPotentialProgrammingProblemsSection(ComboBoxBuilder builder) {
		super.fillPotentialProgrammingProblemsSection(builder);
		builder.addComboBox(INVALID_OPERATOR_SIGNATURE, "Unexpected operator declaration:");
	}
	
	@Override
	protected void fillCodingStyleSection(ComboBoxBuilder builder) {
		super.fillCodingStyleSection(builder);
		builder.addComboBox(API_TYPE_INFERENCE, "Type inference for API methods/fields:");
		builder.addComboBox(IMPLICIT_RETURN, "Implicit return:");
	}

}

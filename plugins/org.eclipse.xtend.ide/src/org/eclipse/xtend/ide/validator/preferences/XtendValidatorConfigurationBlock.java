/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.validator.preferences;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtend.core.validation.XtendConfigurableIssueCodes;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.xbase.ui.validation.XbaseValidationConfigurationBlock;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendValidatorConfigurationBlock extends XbaseValidationConfigurationBlock {

	@Override
	protected void fillUnusedCodeSection(int defaultIndent, Composite unusedCodeSection) {
		super.fillUnusedCodeSection(defaultIndent, unusedCodeSection);
		new ComboBoxBuilder(unusedCodeSection, defaultIndent)
		
			.addComboBox(XtendConfigurableIssueCodes.SINGLE_DISPATCH_FUNCTION, "Single dispatch function:")
			.addComboBox(XtendConfigurableIssueCodes.DISPATCH_PLAIN_FUNCTION_NAME_CLASH, "Dispatch plain function name clash:")
			.addComboBox(XtendConfigurableIssueCodes.FIELD_LOCALLY_NEVER_READ, "Field never read locally:")
			.addComboBox(XtendConfigurableIssueCodes.FUNCTION_LOCALLY_NEVER_USED, "Function never used locally:")
		;
	}

	class ComboBoxBuilder {
		private int defaultIndent;
		private Composite unusedCodeSection;

		public ComboBoxBuilder(Composite unusedCodeSection,int defaultIndent) {
			this.unusedCodeSection = unusedCodeSection;
			this.defaultIndent = defaultIndent;
		}
		
		ComboBoxBuilder addComboBox(PreferenceKey prefKey, String label) {
			 XtendValidatorConfigurationBlock.this.addComboBox(prefKey, label, unusedCodeSection, defaultIndent);
			 return this;
		}
		
	}
}

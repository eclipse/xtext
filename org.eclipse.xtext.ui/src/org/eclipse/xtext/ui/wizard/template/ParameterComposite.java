/*******************************************************************************
 * Copyright (c) 2018, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Composite to be used inside a wizard to select the parameters for a template. These might be parameters for a project or a file template.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public class ParameterComposite extends Composite {

	private final AbstractTemplate template;
	private final IParameterPage parameterPage;

	private boolean inUserAction = true;

	public ParameterComposite(Composite parent, int style, AbstractTemplate template, IParameterPage parameterPage) {
		super(parent, style);
		this.template = template;
		this.parameterPage = parameterPage;
		setLayout(new GridLayout(2, false));
		for (TemplateVariable variable : template.getVariables()) {
			Composite varParent = variable.getContainer() == null ? this : variable.getContainer().getWidget();
			if (variable.isLabeled()) {
				Label label = new Label(varParent, SWT.NONE);
				label.setText(variable.getLabel());
				label.setToolTipText(variable.getDescription());
				label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
				variable.createWidget(this, varParent);
				variable.getWidget().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			} else {
				variable.createWidget(this, varParent);
				variable.getWidget().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			}
			if (variable.getDescription() != null) {
				ControlDecoration decorator = new ControlDecoration(variable.getWidget(), SWT.RIGHT | SWT.TOP, varParent);
				decorator.setDescriptionText(variable.getDescription());
				decorator.setImage(
						FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage());
			}
		}
		update();
	}

	@Override
	public void update() {
		if (inUserAction) {
			inUserAction = false;
			refreshVariables();
			validate();
			inUserAction = true;
		}
	}

	protected void validate() {
		parameterPage.setStatus(template.validate());
	}

	private void refreshVariables() {
		template.updateVariables();
		for (TemplateVariable variable : template.getVariables()) {
			variable.refresh();
		}
	}

}

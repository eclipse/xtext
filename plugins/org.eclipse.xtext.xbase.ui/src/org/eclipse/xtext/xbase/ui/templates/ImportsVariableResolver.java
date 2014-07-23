/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.templates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;
import org.eclipse.xtext.ui.codetemplates.ui.resolvers.IInspectableTemplateVariableResolver;
import org.eclipse.xtext.ui.editor.templates.AbstractTemplateVariableResolver;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateContext;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author Dennis Huebner (dhuebner) - Initial contribution and API
 * @since 2.7
 */
public class ImportsVariableResolver extends AbstractTemplateVariableResolver implements
		IInspectableTemplateVariableResolver {

	public ImportsVariableResolver() {
		super(Messages.ImportsVariableResolver_0, Messages.ImportsVariableResolver_1);
	}

	@Override
	public List<String> resolveValues(TemplateVariable variable, XtextTemplateContext xtextTemplateContext) {
		variable.setUnambiguous(true);
		variable.setValue(""); //$NON-NLS-1$
		if (xtextTemplateContext instanceof XbaseTemplateContext) {
			XbaseTemplateContext xbaseCtx = (XbaseTemplateContext) xtextTemplateContext;
			List<?> params = variable.getVariableType().getParams();
			if (params.size() > 0 && !xtextTemplateContext.isReadOnly()) {
				for (Iterator<?> iterator = params.iterator(); iterator.hasNext();) {
					String typeName = (String) iterator.next();
					xbaseCtx.addImport(typeName);
				}
			}
		}
		return new ArrayList<String>();
	}

	@Override
	protected boolean isUnambiguous(TemplateContext context) {
		return true;
	}

	@Override
	protected String[] resolveAll(TemplateContext context) {
		return new String[0];
	}

	public boolean hasMandatoryParameters() {
		return true;
	}

	public boolean canHaveParameters() {
		return true;
	}

	public void validateParameters(Variable variable, ValidationMessageAcceptor validationMessageAcceptor) {
		if (variable.getParameters().isEmpty()) {
			validationMessageAcceptor.acceptError(getType() + "-variables have mandatory parameters.", variable,
					TemplatesPackage.Literals.VARIABLE__TYPE, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
		}
	}
}

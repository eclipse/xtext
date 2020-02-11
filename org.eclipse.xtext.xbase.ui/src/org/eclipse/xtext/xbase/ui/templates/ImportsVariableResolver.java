/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.templates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;
import org.eclipse.xtext.ui.codetemplates.ui.resolvers.IInspectableTemplateVariableResolver;
import org.eclipse.xtext.ui.editor.templates.AbstractTemplateVariableResolver;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateContext;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.conversion.XbaseValueConverterService;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner (dhuebner) - Initial contribution and API
 * @since 2.7
 */
public class ImportsVariableResolver extends AbstractTemplateVariableResolver implements
		IInspectableTemplateVariableResolver {
	@Inject
	private IValueConverterService valueConverterService;

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
			if (params.size() > 0) {
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
		if (variable.getParameters().isEmpty()) {
			validationMessageAcceptor.acceptError(getType() + "-variables have mandatory parameters.", variable,
					TemplatesPackage.Literals.VARIABLE__TYPE, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
		} else {
			EList<String> parameters = variable.getParameters();
			for (int i = 0; i < parameters.size(); i++) {
				String param = parameters.get(i);
				try {
					IValueConverter<String> converter = ((XbaseValueConverterService) valueConverterService)
							.getQualifiedNameWithWildCardValueConverter();
					converter.toString(param);
				} catch (ValueConverterException e) {
					validationMessageAcceptor.acceptError(getType() + " - parameter " + param
							+ " is not a valid qualifier.", variable, TemplatesPackage.Literals.VARIABLE__PARAMETERS,
							i, null);
				}
			}
		}
	}
}

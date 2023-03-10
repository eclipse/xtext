/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.validation;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.jface.text.templates.TemplateTranslator;
import org.eclipse.jface.text.templates.TemplateVariableResolver;
import org.eclipse.text.templates.ContextTypeRegistry;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplate;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplates;
import org.eclipse.xtext.ui.codetemplates.templates.TemplateBody;
import org.eclipse.xtext.ui.codetemplates.templates.TemplatePart;
import org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;
import org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry;
import org.eclipse.xtext.ui.codetemplates.ui.resolvers.IInspectableTemplateVariableResolver;
import org.eclipse.xtext.ui.codetemplates.ui.resolvers.InspectableTemplateVariableResolverRegistry;
import org.eclipse.xtext.ui.codetemplates.validation.CodetemplatesValidator;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Check;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TemplateValidator extends CodetemplatesValidator {

	@Inject
	private InspectableTemplateVariableResolverRegistry registry;

	@Inject
	private LanguageRegistry languageRegistry;

	@Check
	public void checkTemplate(TemplateBody template) {
		EList<TemplatePart> parts = template.getParts();
		boolean cursorDefined = false;
		for (TemplatePart templatePart : parts) {
			if (templatePart instanceof Variable) {
				if ("cursor".equals(((Variable) templatePart).getName())) {
					if (cursorDefined) {
						warning("More than one cursor was defined", templatePart, TemplatesPackage.Literals.VARIABLE__NAME);
					} else {
						cursorDefined = true;
					}
				}
			}
		}
	}

	@Check
	public void checkParameterSyntax(Variable variable) {
		//worst case check
		TemplateTranslator templateTranslator = new TemplateTranslator();
		String text = NodeModelUtils.getNode(variable).getText();
		try {
			templateTranslator.translate(text);
		} catch (TemplateException e) {
			error(templateTranslator.getErrorMessage(), variable, TemplatesPackage.Literals.VARIABLE__NAME);
		}
	}

	@Check
	public void checkParameters(Variable variable) {
		Codetemplate template = EcoreUtil2.getContainerOfType(variable, Codetemplate.class);
		Codetemplates templates = EcoreUtil2.getContainerOfType(template, Codetemplates.class);
		if (templates != null && template != null) {
			Grammar language = templates.getLanguage();
			AbstractRule rule = template.getContext();
			ContextTypeIdHelper helper = languageRegistry.getContextTypeIdHelper(language);
			if (helper != null && rule != null && !rule.eIsProxy() && rule instanceof ParserRule) {
				String contextTypeId = helper.getId(rule);
				ContextTypeRegistry contextTypeRegistry = languageRegistry.getContextTypeRegistry(language);
				TemplateContextType contextType = contextTypeRegistry.getContextType(contextTypeId);
				if (contextType != null) {
					Iterator<TemplateVariableResolver> resolvers = Iterators.filter(contextType.resolvers(),
							TemplateVariableResolver.class);
					String type = variable.getType();
					if (type == null)
						type = variable.getName();
					while (resolvers.hasNext()) {
						final TemplateVariableResolver resolver = resolvers.next();
						if (resolver.getType().equals(type)) {
							IInspectableTemplateVariableResolver inspectableResolver = registry
									.toInspectableResolver(resolver);
							if (inspectableResolver != null) {
								inspectableResolver.validateParameters(variable, this);
							}
						}
					}
				}
			}
		}
	}

	@Check
	public void checkNameIsNotEmpty(Codetemplate template) {
		if (Strings.isEmpty(template.getName())) {
			error("Template name cannot be empty.", TemplatesPackage.Literals.CODETEMPLATE__NAME);
		}
	}

}

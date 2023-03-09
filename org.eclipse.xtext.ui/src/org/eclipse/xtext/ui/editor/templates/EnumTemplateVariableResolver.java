/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.xtext.Grammar;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Singleton;

/**
 * Resolves a template variable to <code>EEnumLiteral literals</code> which are
 * assignment-compatible with the <code>TemplateVariable variable</code>
 * enumeration parameter (e.g. in ${modifier:Enum('[PackageName.]Visibility')}).
 * 
 * @author Michael Clay - Initial contribution and API
 */
@Singleton
public class EnumTemplateVariableResolver extends
		AbstractTemplateVariableResolver {

	public EnumTemplateVariableResolver() {
		super(Messages.EnumTemplateVariableResolver_0, Messages.EnumTemplateVariableResolver_1 +
				Messages.EnumTemplateVariableResolver_2);
	}
	
	@Override
	public List<String> resolveValues(TemplateVariable variable,
			XtextTemplateContext castedContext) {
		String enumerationName = variable.getVariableType()
				.getParams().iterator().next();
		Grammar grammar = getGrammar(castedContext);
		if (grammar == null)
			return Collections.emptyList();
		EEnum enumeration = (EEnum) getEClassifierForGrammar(enumerationName, grammar);
		if (enumeration == null) {
			return Collections.emptyList();
		}
		return Lists.transform(enumeration.getELiterals(), new Function<EEnumLiteral, String>() {
			@Override
			public String apply(EEnumLiteral enumLiteral) {
				return enumLiteral.getLiteral();
			}
		});
	}

}

/*******************************************************************************
 * Copyright (c) 2008, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import java.util.Collections;
import java.util.List;

import org.eclipse.text.templates.ContextTypeRegistry;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
@Singleton
public class XtextTemplateContextTypeRegistry extends org.eclipse.jface.text.templates.ContextTypeRegistry {
	
	private final ContextTypeIdHelper helper;

	@Inject
	public XtextTemplateContextTypeRegistry(IGrammarAccess grammarAccess, Provider<XtextTemplateContextType> ctxTypeProvider, ContextTypeIdHelper helper) {
		this.helper = helper;
		registerContextTypes(grammarAccess, ctxTypeProvider);
	}

	protected void registerContextTypes(IGrammarAccess grammarAccess, Provider<XtextTemplateContextType> ctxTypeProvider) {
		List<XtextTemplateContextType> allContextTypes = Lists.newArrayList();
		List<ParserRule> parserRules = GrammarUtil.allParserRules(grammarAccess.getGrammar());
		for (ParserRule parserRule : parserRules) {
			XtextTemplateContextType type = ctxTypeProvider.get();
			type.setName(parserRule.getName());
			type.setId(getId(parserRule));
			allContextTypes.add(type);
			List<Keyword> keywords = EcoreUtil2.getAllContentsOfType(parserRule, Keyword.class);
			for (Keyword keyword : keywords) {
				String value = getId(keyword);
				if (value!=null) {
					type = ctxTypeProvider.get();
					type.setName("Keyword '"+keyword.getValue()+"'");
					type.setId(value);
					allContextTypes.add(type);
				}
			}
		}
		List<EnumRule> enumRules = GrammarUtil.allEnumRules(grammarAccess.getGrammar());
		for (EnumRule enumRule : enumRules) {
			List<Keyword> keywords = EcoreUtil2.getAllContentsOfType(enumRule, Keyword.class);
			for (Keyword keyword : keywords) {
				String value = getId(keyword);
				if (value!=null) {
					XtextTemplateContextType type = ctxTypeProvider.get();
					type.setName("Keyword '"+keyword.getValue()+"'");
					type.setId(value);
					allContextTypes.add(type);
				}
			}
		}
		Collections.sort(allContextTypes);
		for (XtextTemplateContextType templateContextType: allContextTypes) {
			((ContextTypeRegistry) this).addContextType(templateContextType);
		}
	}
	
	public String getId(Keyword k) {
		return helper.getId(k);
	}

	public String getId(ParserRule parserRule) {
		return helper.getId(parserRule);
	}
	
	public ContextTypeIdHelper getHelper() {
		return helper;
	}
}

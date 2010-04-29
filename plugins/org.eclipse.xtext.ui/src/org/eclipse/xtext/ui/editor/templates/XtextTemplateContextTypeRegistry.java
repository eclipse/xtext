/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.xtext.EcoreUtil2;
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
public class XtextTemplateContextTypeRegistry extends ContextTypeRegistry {
	
	private final ContextTypeIdHelper helper;

	@Inject
	public XtextTemplateContextTypeRegistry(IGrammarAccess grammarAccess, Provider<XtextTemplateContextType> ctxTypeProvider, ContextTypeIdHelper helper) {
		this.helper = helper;
		registerContextTypes(grammarAccess, ctxTypeProvider);
	}

	protected void registerContextTypes(IGrammarAccess grammarAccess, Provider<XtextTemplateContextType> ctxTypeProvider) {
		List<ParserRule> parserRules = GrammarUtil.allParserRules(grammarAccess.getGrammar());
		List<XtextTemplateContextType> allContextTypes = Lists.newArrayList();
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
		Collections.sort(allContextTypes);
		for (XtextTemplateContextType templateContextType: allContextTypes) {
			addContextType(templateContextType);
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

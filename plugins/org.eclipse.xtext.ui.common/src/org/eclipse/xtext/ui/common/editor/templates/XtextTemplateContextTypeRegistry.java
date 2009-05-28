/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.templates;

import java.util.List;

import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
@Singleton
public class XtextTemplateContextTypeRegistry extends ContextTypeRegistry {
	
	@Inject
	public XtextTemplateContextTypeRegistry(IGrammarAccess grammarAccess, Provider<XtextTemplateContextType> ctxTypeProvider) {
		registerContextTypes(grammarAccess, ctxTypeProvider);
	}

	protected void registerContextTypes(IGrammarAccess grammarAccess, Provider<XtextTemplateContextType> ctxTypeProvider) {
		List<ParserRule> parserRules = GrammarUtil.allParserRules(grammarAccess.getGrammar());
		for (ParserRule parserRule : parserRules) {
			XtextTemplateContextType type = ctxTypeProvider.get();
			type.setName(parserRule.getName());
			type.setId(getId(parserRule));
			addContextType(type);
			
			List<Keyword> keywords = EcoreUtil2.getAllContentsOfType(parserRule, Keyword.class);
			for (Keyword keyword : keywords) {
				String value = getId(keyword);
				if (value!=null) {
					type = ctxTypeProvider.get();
					type.setName("Keyword '"+keyword.getValue()+"'");
					type.setId(value);
					addContextType(type);
				}
			}
		}
	}
	
	public String getId(Keyword k) {
		return GrammarUtil.getGrammar(k).getName()+".kw_"+k.getValue();
	}

	public String getId(ParserRule parserRule) {
		return GrammarUtil.getGrammar(parserRule).getName()+"."+parserRule.getName();
	}
}

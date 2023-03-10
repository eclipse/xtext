/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.registry;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.codetemplates.ui.highlighting.TemplateBodyHighlighter;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialEditingContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;

import com.google.common.collect.Maps;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LanguageRegistry {

	protected static class Language {
		private Provider<TemplateBodyHighlighter> templateBodyHighlighter;
		private ContextTypeRegistry contextTypeRegistry;
		private ContextTypeIdHelper helper;
		private Provider<IPartialEditingContentAssistContextFactory> partialContentAssistContextFactory;
		private String primaryFileExtension;
	}
	
	private Map<String, Language> registeredLanguages = Maps.newHashMap();
	
	void register(Grammar grammar, 
			Provider<TemplateBodyHighlighter> highlighter, 
			ContextTypeRegistry registry, 
			ContextTypeIdHelper helper,
			Provider<IPartialEditingContentAssistContextFactory> partialContentAssistContextFactory,
			String primaryFileExtension) {
		Language language = new Language();
		language.contextTypeRegistry = registry;
		language.templateBodyHighlighter = highlighter;
		language.helper = helper;
		language.partialContentAssistContextFactory = partialContentAssistContextFactory;
		language.primaryFileExtension = primaryFileExtension;
		registeredLanguages.put(grammar.getName(), language);
	}
	
	public TemplateBodyHighlighter getTemplateBodyHighlighter(Grammar grammar) {
		Language language = registeredLanguages.get(grammar.getName());
		if (language == null)
			return null;
		return language.templateBodyHighlighter.get();
	}
	
	public IPartialEditingContentAssistContextFactory getPartialContentAssistContextFactory(Grammar grammar) {
		Language language = registeredLanguages.get(grammar.getName());
		if (language == null)
			return null;
		return language.partialContentAssistContextFactory.get();
	}
	
	public ContextTypeRegistry getContextTypeRegistry(Grammar grammar) {
		Language language = registeredLanguages.get(grammar.getName());
		if (language == null)
			return null;
		return language.contextTypeRegistry;
	}

	public ContextTypeIdHelper getContextTypeIdHelper(Grammar grammar) {
		Language language = registeredLanguages.get(grammar.getName());
		if (language == null)
			return null;
		return language.helper;
	}
	
	public XtextResource createTemporaryResourceIn(Grammar grammar, ResourceSet resourceSet) {
		Language language = registeredLanguages.get(grammar.getName());
		if (language == null)
			return null;
		XtextResource syntheticResource = (XtextResource) resourceSet.createResource(
				URI.createURI("syntethic:/unnamed." + language.primaryFileExtension));
		return syntheticResource;
	}
	
}

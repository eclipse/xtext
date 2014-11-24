/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.registry;

import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.codetemplates.ui.highlighting.TemplateBodyHighlighter;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialEditingContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LanguageAcceptor {

	@Inject
	private LanguageRegistry registry;
	
	public void accept(Grammar grammar, 
			Provider<TemplateBodyHighlighter> highlighter, 
			ContextTypeRegistry registry, 
			ContextTypeIdHelper helper,
			Provider<IPartialEditingContentAssistContextFactory> contentAssistContextFactory,
			String primaryFileExtension) {
		this.registry.register(grammar, highlighter, registry, helper, contentAssistContextFactory, primaryFileExtension);
	}
	
}

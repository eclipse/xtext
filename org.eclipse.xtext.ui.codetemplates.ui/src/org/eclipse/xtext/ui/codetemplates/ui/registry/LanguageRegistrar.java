/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.registry;

import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.codetemplates.ui.highlighting.TemplateBodyHighlighter;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialEditingContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LanguageRegistrar {

	@Inject
	private IGrammarAccess grammarAccess;

	@Inject
	private Provider<TemplateBodyHighlighter> highlighter;

	@Inject
	private ContextTypeRegistry contextTypeRegistry;

	@Inject
	private ContextTypeIdHelper helper;

	@Inject
	private Provider<IPartialEditingContentAssistContextFactory> contentAssistContextFactory;

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	@Inject
	public void register(LanguageAcceptor acceptor) {
		acceptor.accept(grammarAccess.getGrammar(), highlighter, contextTypeRegistry, helper,
				contentAssistContextFactory, fileExtensionProvider.getFileExtensions().iterator().next());
	}

}

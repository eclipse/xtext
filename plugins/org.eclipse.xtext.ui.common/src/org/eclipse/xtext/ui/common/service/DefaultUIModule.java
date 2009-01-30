/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.service;

import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.ITemplateContentAssistProcessor;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistProcessor;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultTemplateContentAssistProcessor;
import org.eclipse.xtext.ui.common.editor.outline.ILazyTreeProvider;
import org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.AntlrTokenScanner;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.BuiltinAntlrTokenColorer;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.ITokenColorer;

import com.google.inject.Binder;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public abstract class DefaultUIModule extends AbstractUIModule {

	abstract protected Class<? extends IProposalProvider> getIProposalProvider();
	
	protected Class<? extends org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer> getISemanticModelTransformer() {
		return org.eclipse.xtext.ui.common.editor.outline.impl.DefaultSemanticModelTransformer.class;
	}
	
	protected Class<? extends org.eclipse.xtext.ui.common.editor.outline.ILazyTreeProvider> getILazyTreeProvider() {
		return org.eclipse.xtext.ui.common.editor.outline.impl.LazyTransformingTreeProvider.class;
	}
	
	protected Class<? extends IContentAssistProcessor> getIContentAssistProcessor() {
		return DefaultContentAssistProcessor.class;
	}
	
	protected Class<? extends ITemplateContentAssistProcessor> getITemplateContentAssistProcessor() {
		return DefaultTemplateContentAssistProcessor.class;
	}

	public void configure(Binder binder) {
		binder.bind(IProposalProvider.class).to(getIProposalProvider());
		binder.bind(ITokenColorer.class).to(BuiltinAntlrTokenColorer.class);
		binder.bind(ITokenScanner.class).to(AntlrTokenScanner.class);
		binder.bind(IContentOutlinePage.class).to(XtextContentOutlinePage.class);
		binder.bind(IContentAssistProcessor.class).to(getIContentAssistProcessor());
		binder.bind(ITemplateContentAssistProcessor.class).to(getITemplateContentAssistProcessor());
		binder.bind(ISemanticModelTransformer.class).to(getISemanticModelTransformer());
		binder.bind(ILazyTreeProvider.class).to(getILazyTreeProvider());
	}

	
}

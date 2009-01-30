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
import org.eclipse.xtext.service.AbstractXtextModule;
import org.eclipse.xtext.ui.common.editor.contentassist.ITemplateContentAssistProcessor;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistProcessor;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultTemplateContentAssistProcessor;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.AntlrTokenScanner;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.BuiltinAntlrTokenColorer;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.ITokenColorer;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public abstract class DefaultUIModule extends AbstractXtextModule {

	public Class<? extends org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer> bindISemanticModelTransformer() {
		return org.eclipse.xtext.ui.common.editor.outline.impl.DefaultSemanticModelTransformer.class;
	}
	
	public Class<? extends org.eclipse.xtext.ui.common.editor.outline.ILazyTreeProvider> bindILazyTreeProvider() {
		return org.eclipse.xtext.ui.common.editor.outline.impl.LazyTransformingTreeProvider.class;
	}
	
	public Class<? extends IContentAssistProcessor> bindIContentAssistProcessor() {
		return DefaultContentAssistProcessor.class;
	}
	
	public Class<? extends ITemplateContentAssistProcessor> bindITemplateContentAssistProcessor() {
		return DefaultTemplateContentAssistProcessor.class;
	}
	
	public Class<? extends ITokenColorer> bindITokenColorer() {
		return BuiltinAntlrTokenColorer.class;
	}
	
	public Class<? extends ITokenScanner> bindITokenScanner() {
		return AntlrTokenScanner.class;
	}
	
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return XtextContentOutlinePage.class;
	}
	
}

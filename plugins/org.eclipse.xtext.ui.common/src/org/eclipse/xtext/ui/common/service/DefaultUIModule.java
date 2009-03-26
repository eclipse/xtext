/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.service;

import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.common.editor.contentassist.ITemplateContentAssistProcessor;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistProcessor;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultTemplateContentAssistProcessor;
import org.eclipse.xtext.ui.common.editor.hyperlinking.DefaultHyperlinkDetector;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.DefaultTokenScanner;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.ITokenColorer;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.NullTokenColorer;
import org.eclipse.xtext.ui.core.DefaultLabelProvider;
import org.eclipse.xtext.ui.core.DefaultLocationInFileProvider;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;
import org.eclipse.xtext.ui.core.editor.IDamagerRepairer;
import org.eclipse.xtext.ui.core.editor.XtextDamagerRepairer;
import org.eclipse.xtext.ui.core.editor.reconciler.XtextReconciler;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public abstract class DefaultUIModule extends AbstractGenericModule {

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
		return NullTokenColorer.class;
	}
	
	public Class<? extends ITokenScanner> bindITokenScanner() {
		return DefaultTokenScanner.class;
	}
	
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return XtextContentOutlinePage.class;
	}
	
	public Class<? extends ILabelProvider> bindILabelProvider() {
		return DefaultLabelProvider.class;
	}
	
	public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return DefaultLocationInFileProvider.class;
	}
	
	public Class<? extends IHyperlinkDetector> bindIHyperlinkDetector() {
		return DefaultHyperlinkDetector.class;
	}
	
	public Class<? extends IReconciler> bindIReconciler() {
		return XtextReconciler.class;
	}
	
	public Class<? extends IDamagerRepairer> bindIDamagerRepairer() {
		return XtextDamagerRepairer.class;
	}
	
}

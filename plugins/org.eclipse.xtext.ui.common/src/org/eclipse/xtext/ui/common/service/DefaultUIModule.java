/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.service;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.common.editor.contentassist.DefaultCompletionProposalPostProcessor;
import org.eclipse.xtext.ui.common.editor.contentassist.DefaultContentAssistContextFactory;
import org.eclipse.xtext.ui.common.editor.contentassist.DefaultContentAssistantFactory;
import org.eclipse.xtext.ui.common.editor.contentassist.DefaultFollowElementCalculator;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalConflictHelper;
import org.eclipse.xtext.ui.common.editor.contentassist.ProposalConflictHelper;
import org.eclipse.xtext.ui.common.editor.hyperlinking.DefaultHyperlinkDetector;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.DefaultTokenScanner;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.ITokenColorer;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.NullTokenColorer;
import org.eclipse.xtext.ui.common.editor.templates.DefaultTemplateProposalProvider;
import org.eclipse.xtext.ui.common.editor.templates.XtextTemplateContextTypeRegistry;
import org.eclipse.xtext.ui.common.editor.templates.XtextTemplateStore;
import org.eclipse.xtext.ui.common.editor.toggleComments.DefaultSingleLineCommentHelper;
import org.eclipse.xtext.ui.core.DefaultLabelProvider;
import org.eclipse.xtext.ui.core.DefaultLocationInFileProvider;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;
import org.eclipse.xtext.ui.core.InjectableAdapterFactory;
import org.eclipse.xtext.ui.core.InjectableAdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.core.editor.FastLineBasedDamagerRepairer;
import org.eclipse.xtext.ui.core.editor.IDamagerRepairer;
import org.eclipse.xtext.ui.core.editor.XtextDamagerRepairer;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalPostProcessor;
import org.eclipse.xtext.ui.core.editor.contentassist.IContentAssistantFactory;
import org.eclipse.xtext.ui.core.editor.contentassist.IFollowElementCalculator;
import org.eclipse.xtext.ui.core.editor.contentassist.ITemplateProposalProvider;
import org.eclipse.xtext.ui.core.editor.contentassist.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.core.editor.reconciler.XtextReconciler;
import org.eclipse.xtext.ui.core.editor.toggleComments.ISingleLineCommentHelper;

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
//		return FastLineBasedDamagerRepairer.class;
		return XtextDamagerRepairer.class;
	}
	
	public Class<? extends AdapterFactory> bindAdapterFactory() {
		return InjectableAdapterFactory.class;
	}
	
	public Class<? extends IContentAssistantFactory> bindIContentAssistantFactory() {
		return DefaultContentAssistantFactory.class;
	}
	
	public Class<? extends IContentAssistProcessor> bindIContentAssistProcessor() {
		return XtextContentAssistProcessor.class;
	}
	
	public Class<? extends ITemplateProposalProvider> bindITemplateProposalProvider() {
		return DefaultTemplateProposalProvider.class;
	}
	
	public Class<? extends TemplateStore> bindTemplateStore() {
		return XtextTemplateStore.class;
	}
	
	public Class<? extends ContextTypeRegistry> bindContextTypeRegistry() {
		return XtextTemplateContextTypeRegistry.class;
	}
	
	public Class<? extends ContentAssistContext.Factory> bindContentAssistContextFactory() {
		return DefaultContentAssistContextFactory.class;
	}
	
	public Class<? extends ICompletionProposalPostProcessor> bindICompletionProposalPostProcessor() {
		return DefaultCompletionProposalPostProcessor.class;
	}
	
	public Class<? extends IFollowElementCalculator> bindIFollowElementCalculator() {
		return DefaultFollowElementCalculator.class;
	}
	
	public Class<? extends IProposalConflictHelper> bindIProposalConflictHelper() {
		return ProposalConflictHelper.NullHelper.class;
	}
	
	public Class<? extends AdapterFactoryLabelProvider> bindAdapterFactoryLabelProvider() {
		return InjectableAdapterFactoryLabelProvider.class;
	}
	
	public ComposedAdapterFactory.Descriptor.Registry bindComposedAdapterFactoryDescriptorRegistry() {
		return ComposedAdapterFactory.Descriptor.Registry.INSTANCE;
	}
	
	public Class<? extends ISingleLineCommentHelper> bindISingleLineCommentHelper() {
		return DefaultSingleLineCommentHelper.class;
	}
}

/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import static org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration.*;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateProposalProvider;

import com.google.inject.Inject;

/**
 * Provides an abstract implementation of interface {@link ITemplateProposalProvider}.
 *
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTemplateProposalProvider implements ITemplateProposalProvider {
	
	private static final Logger log = Logger.getLogger(AbstractTemplateProposalProvider.class);
	
	private IScopeProvider scopeProvider;
	
	@Inject
	private IProposalConflictHelper proposalConflictHelper;
	
	@Inject
	public void setScopeProvider(IScopeProvider scopeProvider) {
		this.scopeProvider = scopeProvider;
	}

	/**
	 * @since 2.7
	 */
	protected IScopeProvider getScopeProvider() {
		return scopeProvider;
	}
	
	public static class NullSafeTemplateAcceptor extends ITemplateAcceptor.Delegate {
		
		public NullSafeTemplateAcceptor(ITemplateAcceptor delegate) {
			super();
			setDelegate(delegate);
		}
		
		@Override
		public void accept(TemplateProposal template) {
			if (template != null)
				super.accept(template);
		}
	}
	
	@Override
	public void createTemplates(ContentAssistContext context, ITemplateAcceptor acceptor) {
		if (!acceptor.canAcceptMoreTemplates())
			return;
		TemplateContext[] templateContexts = createTemplateContexts(context);
		if (templateContexts == null || templateContexts.length == 0)
			return;

		ITemplateAcceptor nullSafe = new NullSafeTemplateAcceptor(acceptor);
		for(TemplateContext templateContext: templateContexts) {
			if (!nullSafe.canAcceptMoreTemplates())
				return;
			templateContext.setVariable("selection", context.getSelectedText()); // name of the selection variables {line, word}_selection //$NON-NLS-1$
			createTemplates(templateContext, context, nullSafe);
		}
	}
	
	protected abstract void createTemplates(TemplateContext templateContext, ContentAssistContext context, ITemplateAcceptor acceptor);
	
	protected TemplateProposal createProposal(Template template, TemplateContext templateContext,
			ContentAssistContext context, Image image, int relevance) {
		if (!validate(template, context))
			return null;
		return doCreateProposal(template, templateContext, context, image, relevance);
	}

	protected TemplateProposal doCreateProposal(Template template, TemplateContext templateContext,
			ContentAssistContext context, Image image, int relevance) {
		return new XtextTemplateProposal(template, templateContext, context.getReplaceRegion(), image, relevance);
	}
	
	protected boolean validate(Template template, ContentAssistContext context) {
		boolean result = context.getMatcher().isCandidateMatchingPrefix(template.getName(), context.getPrefix());
		if (result) {
			try {
				String pattern = template.getPattern();
				if (proposalConflictHelper.existsConflict(pattern, context)) {
					result = false;
				}
			} catch(Exception e) {
				result = false;
			}
		}
		return result;
	}
	
	protected boolean validate(Template template, TemplateContext context) {
		try {
			context.getContextType().validate(template.getPattern());
		} catch (TemplateException e) {
			return false;
		}
		if (context instanceof XtextTemplateContext) {
			try {
				//pre-fill context state and check. 
				((XtextTemplateContext) context).evaluateForDisplay(template);
				return context.canEvaluate(template);
			} catch (BadLocationException e) {
				return false;
			} catch (TemplateException e) {
				return false;
			}
		}
		return true;
	}
	
	protected TemplateContext[] createTemplateContexts(ContentAssistContext context) {
		TemplateContextType[] contextTypes = getContextTypes(context);
		if (contextTypes != null && contextTypes.length != 0) {
			TemplateContext[] result = new TemplateContext[contextTypes.length];
			for(int i = 0; i < contextTypes.length; i++) {
				result[i] = doCreateTemplateContext(contextTypes[i], context);
			}
			return result;
		}
		return null;
	}
	
	protected TemplateContext doCreateTemplateContext(TemplateContextType contextType, ContentAssistContext context) {
		return new XtextTemplateContext(contextType, context.getDocument(),
				createPosition(context),
				context, getScopeProvider());
	}
	
	/**
	 * Positions created for template contexts have to be added to the document so they are updated when the document
	 * is modified.
	 * 
	 * @since 2.8
	 */
	protected Position createPosition(ContentAssistContext context) {
		Position position = new Position(context.getReplaceRegion().getOffset(), context.getReplaceRegion().getLength());
		IDocument document = context.getDocument();
		if (document.containsPositionCategory(XTEXT_TEMPLATE_POS_CATEGORY)) {
			try {
				document.addPosition(XTEXT_TEMPLATE_POS_CATEGORY, position);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		return position;
	}

	protected abstract TemplateContextType[] getContextTypes(ContentAssistContext context);


}

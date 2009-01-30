/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.ITemplateContentAssistProcessor;

import com.google.inject.Inject;

/**
 * Provides a default implementation of interface {@link ITemplateContentAssistProcessor}.
 *
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultTemplateContentAssistProcessor extends TemplateCompletionProcessor implements ITemplateContentAssistProcessor {

	@Inject
	private IProposalProvider proposalProvider;

	@Inject 
	private IScopeProvider scopeProvider;
	
	@Inject 
	private IMetamodelAccess metamodelAccess;
	
	private TemplateContextType contextType;

	private IContentAssistContext contentAssistContext;
	
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		return super.computeCompletionProposals(viewer, offset);
	}

	@Override
	protected TemplateContextType getContextType(ITextViewer viewer, IRegion region) {
		return this.contextType;
	}

	@Override
	protected Image getImage(Template template) {
		return null;
	}

	@Override
	protected Template[] getTemplates(String contextTypeId) {
		return this.proposalProvider.getTemplates(contextTypeId);
	}

	@Override
	protected TemplateContext createContext(ITextViewer viewer, IRegion region) {
		
		TemplateContextType contextType = getContextType(viewer, region);
		
		if (contextType != null) {

			return new XtextTemplateContext(contextType, viewer.getDocument(), 
					new Position(region.getOffset(), region.getLength()), 
					this.contentAssistContext,
					this.scopeProvider,
					this.metamodelAccess);
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.ITemplateContentAssistProcessor#setContextType(org.eclipse.jface.text.templates.TemplateContextType)
	 */
	public void setContextType(TemplateContextType contextType) {
		this.contextType = contextType;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.ITemplateContentAssistProcessor#setContentAssistContext(org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext)
	 */
	public void setContentAssistContext(IContentAssistContext contentAssistContext) {
		this.contentAssistContext = contentAssistContext;
	}


}

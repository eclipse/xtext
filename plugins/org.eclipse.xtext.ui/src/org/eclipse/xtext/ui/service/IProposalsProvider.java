/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service;

import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.DocumentTemplateContext;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.ui.editor.model.IEditorModel;

/**
 * @author Dennis Hübner - Initial contribution and API
 * @author Peter Friese - Initial contribution and API
 */
public interface IProposalsProvider extends IProposalsProvider0, ILanguageService {

	/**
	 * Purpose of this method: find out where we are. What's left / right to the
	 * caret? Perform a semantic analysis of our location. Important: has to run
	 * FAST!
	 */
	ICompletionContext computeContext(IEditorModel model, ITextViewer viewer, int offset);

	/**
	 * Gets called second. Must return list of "normal" i.e. non-template
	 * proposals.
	 */
	List<ICompletionProposal> getProposals(ICompletionContext context);

	/**
	 * Gets called third. Must return list of template proposals. We provide an
	 * abstract base class which can take complete care of template proposal
	 * handling
	 */
	List<ICompletionProposal> getTemplateProposals(ICompletionContext context);
	
	// TODO refactor these two methods, they should be hosted in some kind of "Access"-Class
	ContextTypeRegistry getTemplateContextRegistry();
	TemplateStore getTemplateStore();

	/**
	 * Provides a semantic analysis of the current location. 
	 */
	public interface ICompletionContext {
		IEditorModel getEditorModel();
		ITextViewer getTextViewer();
		Region getRegion();
		int getOffset();
		int getLength();
		TemplateContextType getTemplateContextType();
		TemplateContext getTemplateContext();
	}
	
	public class CompletionContext implements ICompletionContext {
		
		private final IEditorModel editorModel;
		private final ITextViewer textViewer;
		private final Region region;
		private final TemplateContextType templateContextType;
		private /* non-final */ TemplateContext templateContext;
		
		public CompletionContext(IEditorModel editorModel, Region region, ITextViewer textViewer, TemplateContextType templateContextType) {
			super();
			this.editorModel = editorModel;
			this.region = region;
			this.templateContextType = templateContextType;
			this.textViewer = textViewer;
		}

		public CompletionContext(IEditorModel editorModel, Region region, ITextViewer textViewer) {
			super();
			this.editorModel = editorModel;
			this.region = region;
			this.templateContextType = null;
			this.textViewer = textViewer;
		}

		protected TemplateContext createContext(TemplateContextType contextType, ICompletionContext completionContext) {
			if (contextType != null) {
				IDocument document = completionContext.getTextViewer().getDocument();
				return new DocumentTemplateContext(contextType, document, completionContext.getOffset(), completionContext.getLength());
			}
			return null;
		}

		public IEditorModel getEditorModel() {
			return editorModel;
		}

		public int getLength() {
			return region.getLength();
		}

		public int getOffset() {
			return region.getOffset();
		}

		public Region getRegion() {
			return region;
		}

		public TemplateContext getTemplateContext() {
			if (templateContext == null) {
				templateContext = createContext(templateContextType, this);
			}
			return templateContext;
		}

		public TemplateContextType getTemplateContextType() {
			return templateContextType;
		}

		public ITextViewer getTextViewer() {
			return textViewer;
		}
		
	}
}

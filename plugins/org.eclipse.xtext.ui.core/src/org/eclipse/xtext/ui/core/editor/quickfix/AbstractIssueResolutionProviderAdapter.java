/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.quickfix;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.IImageHelper;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.edit.IDocumentEditor;
import org.eclipse.xtext.ui.core.editor.model.edit.IssueUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.IssueContext;
import org.eclipse.xtext.validation.IssueResolution;
import org.eclipse.xtext.validation.IssueResolutionProvider;

import com.google.inject.Inject;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public abstract class AbstractIssueResolutionProviderAdapter {

	private IssueResolutionProvider resolutionProvider;
	private IDocumentEditor documentEditor;
	private IImageHelper imageHelper;

	public IssueResolutionProvider getResolutionProvider() {
		return resolutionProvider;
	}

	@Inject
	public void setResolutionProvider(IssueResolutionProvider resolutionProvider) {
		this.resolutionProvider = resolutionProvider;
	}

	public IDocumentEditor getDocumentEditor() {
		return documentEditor;
	}

	@Inject
	public void setDocumentEditor(IDocumentEditor documentEditor) {
		this.documentEditor = documentEditor;
	}

	public IImageHelper getImageHelper() {
		return imageHelper;
	}

	@Inject
	public void setImageHelper(IImageHelper imageHelper) {
		this.imageHelper = imageHelper;
	}
	
	public Iterable<IssueResolution> getResolutions(final Issue issue, final IXtextDocument document) {
		IUnitOfWork<List<IssueResolution>, XtextResource> uow = new IUnitOfWork<List<IssueResolution>, XtextResource>() {

			public List<IssueResolution> exec(XtextResource state) throws Exception {
				EObject model = state.getContents().isEmpty() ? null : state.getContents().get(0);
				EObject contextObject = (model == null) ? null : model.eResource().getEObject(issue.getUriToProblem().fragment());
				IssueContext context = new IssueContext.IssueContextImpl(contextObject, issue, document.get());
				
				return resolutionProvider.getResolutions(context);
			}
		};
		
		Iterable<IssueResolution> result = document.readOnly(uow);
		return IssueUtil.getDocumentAwareResolutions(document, documentEditor, result);			
	}

}

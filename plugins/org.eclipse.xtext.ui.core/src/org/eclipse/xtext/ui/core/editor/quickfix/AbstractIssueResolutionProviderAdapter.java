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
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.IImageHelper;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.edit.IDocumentEditor;
import org.eclipse.xtext.ui.core.internal.XtextPluginImages;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.IssueContext;
import org.eclipse.xtext.validation.IssueResolution;
import org.eclipse.xtext.validation.IssueResolutionProvider;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public abstract class AbstractIssueResolutionProviderAdapter {

	public static final String DEFAULT_IMAGE = "org.eclipse.xtext.ui.core.editor.quickfix.AbstractIssueResolutionProviderAdapter.DEFAULT_IMAGE"; 
	
	@Named(DEFAULT_IMAGE)
	@Inject(optional=true)
	private String defaultImage = XtextPluginImages.OBJ_CORRECTION_CHANGE;  
	@Inject
	private IssueResolutionProvider resolutionProvider;
	@Inject
	private IDocumentEditor documentEditor;
	@Inject
	private IImageHelper imageHelper;

	public IssueResolutionProvider getResolutionProvider() {
		return resolutionProvider;
	}

	public void setResolutionProvider(IssueResolutionProvider resolutionProvider) {
		this.resolutionProvider = resolutionProvider;
	}

	public IDocumentEditor getDocumentEditor() {
		return documentEditor;
	}

	public void setDocumentEditor(IDocumentEditor documentEditor) {
		this.documentEditor = documentEditor;
	}

	public IImageHelper getImageHelper() {
		return imageHelper;
	}

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
		return getDocumentAwareResolutions(document, result);
	}

	public Iterable<IssueResolution> getDocumentAwareResolutions(final IXtextDocument document, Iterable<IssueResolution> resolutions) {
		return Iterables.transform(resolutions, new Function<IssueResolution, IssueResolution>() {

			public IssueResolution apply(final IssueResolution delegate) {
				return new IssueResolution() {
					
					public void run() {
						IUnitOfWork<Object, XtextResource> uow = new IUnitOfWork.Void<XtextResource>() {
							@Override
							public void process(XtextResource state) throws Exception {
								delegate.run();
							}
						};
						
						documentEditor.process(uow, document);
					}
					
					public String getLabel() {
						return delegate.getLabel();
					}
					
					public String getDescription() {
						return delegate.getDescription();
					}
					
					public String getImage() {
						return delegate.getImage();
					}
				};
			}
		});
	}
	
	public Image getImage(IssueResolution resolution) {
		if(Strings.isEmpty(resolution.getImage()))
			return XtextPluginImages.get(defaultImage);
		else
			return imageHelper.getImage(resolution.getImage());
	}


}

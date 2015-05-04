/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.annotation;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.intellij.lang.Language;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;

public class IssueAnnotator implements Annotator {

	@Override
	public void annotate(PsiElement element, AnnotationHolder holder) {
		if (!(element instanceof PsiEObject)) {
			return;
		}
		Language language = element.getLanguage();
		if (!(language instanceof IXtextLanguage)) {
			return;
		}
		PsiEObject psiEObject = (PsiEObject) element;
		if (!psiEObject.isRoot()) {
			return;
		}
		Resource resource = psiEObject.getResource();
		if (resource == null) {
			return;
		}
		IXtextLanguage xtextLanguage = (IXtextLanguage) language;
		IResourceValidator resourceValidator = xtextLanguage.getInstance(IResourceValidator.class);
		try {
			for (Issue issue : getIssues(resource, resourceValidator)) {
				if (issue.isSyntaxError()) {
					continue;
				}
				HighlightSeverity highlightSeverity = getHighlightSeverity(issue.getSeverity());
				if (highlightSeverity == null) {
					continue;
				}
				int startOffset = 0;
				int endOffset = 0;
				if (issue.getOffset() != null) {
					startOffset = issue.getOffset();
					endOffset = startOffset + issue.getLength();
				}
				holder.createAnnotation(highlightSeverity, new TextRange(startOffset, endOffset), issue.getMessage());
			}
		} catch (OperationCanceledError e) {
			throw e.getWrapped();
		}
	}

	protected List<Issue> getIssues(Resource resource, final IResourceValidator resourceValidator) {
		ProgressIndicatorProvider.checkCanceled();
		if (resource instanceof ISynchronizable<?>) {
			@SuppressWarnings("unchecked")
			ISynchronizable<Resource> synchronizable = (ISynchronizable<Resource>) resource;
			try {
				return synchronizable.execute(new IUnitOfWork<List<Issue>, Resource>() {

					@Override
					public List<Issue> exec(Resource state) throws Exception {
						return doGetIssues(state, resourceValidator); 
					}

				});
			} catch (Throwable e) {
				Exceptions.sneakyThrow(e);
			}
		}
		return doGetIssues(resource, resourceValidator);
	}

	protected List<Issue> doGetIssues(Resource resource, IResourceValidator resourceValidator) {
		ProgressIndicatorProvider.checkCanceled();
		try {
			return resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, new CancelIndicator() {
				
				@Override
				public boolean isCanceled() {
					ProgressIndicatorProvider.checkCanceled();
					return false;
				}
				
			});
		} catch (OperationCanceledError e) {
    		throw e.getWrapped();
    	}
	}

	protected HighlightSeverity getHighlightSeverity(Severity severity) {
		if (severity == Severity.ERROR) {
			return HighlightSeverity.ERROR;
		}
		if (severity == Severity.WARNING) {
			return HighlightSeverity.WARNING;
		}
		if (severity == Severity.INFO) {
			return HighlightSeverity.INFORMATION;
		}
		return null;
	}

}

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension2;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.xtext.ui.MarkerUtil;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IssueUtil;
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Sets;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class XtextQuickAssistProcessor extends AbstractIssueResolutionProviderAdapter implements
		IQuickAssistProcessor {

	@Inject
	private IssueUtil issueUtil;

	@Inject
	private MarkerUtil markerUtil;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public boolean canFix(Annotation annotation) {
		if (annotation.isMarkedDeleted())
			return false;

		// non-persisted annotation
		if (annotation instanceof XtextAnnotation) {
			XtextAnnotation a = (XtextAnnotation) annotation;
			return getResolutionProvider().hasResolutionFor(a.getIssueCode());
		}

		// persisted markerAnnotation
		if (annotation instanceof MarkerAnnotation) {
			MarkerAnnotation markerAnnotation = (MarkerAnnotation) annotation;
			if (!markerAnnotation.isQuickFixableStateSet())
				markerAnnotation.setQuickFixable(getResolutionProvider().hasResolutionFor(
						markerUtil.getCode(markerAnnotation)));
			return markerAnnotation.isQuickFixable();
		}
		return false;
	}

	public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
		return false;
	}

	public ICompletionProposal[] computeQuickAssistProposals(IQuickAssistInvocationContext invocationContext) {
		ISourceViewer sourceViewer = invocationContext.getSourceViewer();
		if (sourceViewer == null)
			return new ICompletionProposal[0];
		final IDocument document = sourceViewer.getDocument();
		if (!(document instanceof IXtextDocument))
			return new ICompletionProposal[0];
		final IXtextDocument xtextDocument = (IXtextDocument) document;
		final IAnnotationModel annotationModel = sourceViewer.getAnnotationModel();
		List<ICompletionProposal> result = Lists.newArrayList();
		try {
			final int offset = invocationContext.getOffset();
			Set<Annotation> applicableAnnotations = getApplicableAnnotations(xtextDocument, annotationModel, offset);
			for(Annotation annotation : applicableAnnotations) {
				final Issue issue = issueUtil.getIssueFromAnnotation(annotation);
				if (issue != null) {
					Iterable<IssueResolution> resolutions = getResolutions(issue, xtextDocument);
					if (resolutions.iterator().hasNext()) {
						Position pos = annotationModel.getPosition(annotation);
						for (IssueResolution resolution : resolutions)
							result.add(create(pos, resolution));
					}
				}
			}
			Iterator<Annotation> iterator = applicableAnnotations.iterator();
			if(iterator.hasNext() && !result.isEmpty()){
				Position pos = annotationModel.getPosition(iterator.next());
				sourceViewer.setSelectedRange(pos.getOffset(), pos.getLength());
				sourceViewer.revealRange(pos.getOffset(), pos.getLength());
			}
		} catch (BadLocationException e) {
			errorMessage = e.getMessage();
		}
		sortQuickfixes(result);
		return result.toArray(new ICompletionProposal[result.size()]);
	}
	
	protected ICompletionProposal create(Position posisition, IssueResolution resolution) {
		return new QuickAssistCompletionProposal(posisition, resolution, getImage(resolution));
	}
	
	protected void sortQuickfixes(List<ICompletionProposal> quickFixes) {
		Collections.sort(quickFixes, new Comparator<ICompletionProposal>() {
			public int compare(ICompletionProposal o1, ICompletionProposal o2) {
				return o1.getDisplayString().compareTo(o2.getDisplayString());
			}
		});
	}

	protected Set<Annotation> getApplicableAnnotations(final IXtextDocument document, final IAnnotationModel annotationModel,
			final int offset) throws BadLocationException {
		final int line = document.getLineOfOffset(offset);
		final String delim = document.getLineDelimiter(line);
		final int delimLength = delim != null ? delim.length() : 0;
		final int lineLength = document.getLineLength(line) - delimLength;
		final int lineOffset = document.getLineOffset(line);

		Iterator<?> iterator;
		if (annotationModel instanceof IAnnotationModelExtension2)
			iterator = ((IAnnotationModelExtension2) annotationModel).getAnnotationIterator(lineOffset, lineLength, true,
					true);
		else
			iterator = annotationModel.getAnnotationIterator();

		Set<Annotation> possibleAnnotations = Sets.newHashSet();
		Annotation actualAnnotation = null;
		int nearestAnnotationOffset = Integer.MAX_VALUE;
		Annotation firstAnnotation = null;
		int offsetOfFirstAnnotation = Integer.MAX_VALUE;

		while (iterator.hasNext()) {
			Object key = iterator.next();
			if (!(key instanceof Annotation))
				continue;

			Annotation annotationTemp = (Annotation) key;
			if (!canFix(annotationTemp))
				continue;

			Position pos = annotationModel.getPosition(annotationTemp);
			if (pos == null)
				continue;

			if (pos.overlapsWith(lineOffset, lineLength)) {
				possibleAnnotations.add(annotationTemp);
				if (pos.getOffset() < offsetOfFirstAnnotation) {
					offsetOfFirstAnnotation = pos.getOffset();
					firstAnnotation = annotationTemp;
				}
				int distanceToOffset = offset - pos.getOffset();
				if (distanceToOffset >= 0 && distanceToOffset < nearestAnnotationOffset) {
					actualAnnotation = annotationTemp;
					nearestAnnotationOffset = distanceToOffset;
				} 
			}
		}
		// choose the first annotation if there is no better selection available
		if (actualAnnotation == null) {
			actualAnnotation = firstAnnotation;
		}
		// Find Annotations with same offset an length
		Set<Annotation> actualAnnotations = Sets.newHashSet();
		for(Annotation possibleAnnotation : possibleAnnotations){
			Position possibleAnnotationPosition = annotationModel.getPosition(possibleAnnotation);
			Position actualAnnotationPosition = annotationModel.getPosition(actualAnnotation);
			if(possibleAnnotationPosition.equals(actualAnnotationPosition)){
				actualAnnotations.add(possibleAnnotation);
			}
		}
		return actualAnnotations;
	}
	
	public IssueUtil getIssueUtil() {
		return issueUtil;
	}
	
	public MarkerUtil getMarkerUtil() {
		return markerUtil;
	}
}
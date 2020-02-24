/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import static java.util.Arrays.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.OperationCanceledException;
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
import org.eclipse.ui.texteditor.spelling.SpellingAnnotation;
import org.eclipse.ui.texteditor.spelling.SpellingProblem;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalComparator;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation;
import org.eclipse.xtext.ui.util.IssueUtil;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

public class XtextQuickAssistProcessor extends AbstractIssueResolutionProviderAdapter implements
		IQuickAssistProcessor {

	@Inject
	private IssueUtil issueUtil;
	
	@Inject
	private ICompletionProposalComparator comparator;
	
	/**
	 * @since 2.19
	 */
	@Inject
	private XtextDocumentUtil xtextDocumentUtil;
	
	private String errorMessage;

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
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
						issueUtil.getCode(markerAnnotation)));
			return markerAnnotation.isQuickFixable();
		}

		if (annotation instanceof SpellingAnnotation) {
			return true;
		}

		return false;
	}
	
	/**
	 * Check whether the given annotation type is supported, i.e. {@link #canFix(Annotation)} might return {@code true}.
	 * This could be made protected in a future release.
	 */
	private boolean isSupported(Annotation annotation) {
		return !annotation.isMarkedDeleted()
				&& (annotation instanceof XtextAnnotation || annotation instanceof MarkerAnnotation
					|| annotation instanceof SpellingAnnotation);
	}

	@Override
	public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
		return false;
	}

	@Override
	public ICompletionProposal[] computeQuickAssistProposals(IQuickAssistInvocationContext invocationContext) {
		ISourceViewer sourceViewer = invocationContext.getSourceViewer();
		if (sourceViewer == null)
			return new ICompletionProposal[0];
		if (invocationContext instanceof QuickAssistInvocationContext) {
			if (((QuickAssistInvocationContext) invocationContext).isCancelled()) {
				return new ICompletionProposal[0];
			}
		}
		final IDocument document = sourceViewer.getDocument();
		if (document == null)
			return new ICompletionProposal[0];
		final IAnnotationModel annotationModel = sourceViewer.getAnnotationModel();
		List<ICompletionProposal> result = Lists.newArrayList();
		try {
			Set<Annotation> applicableAnnotations = getApplicableAnnotations(document, annotationModel, invocationContext.getOffset());
			result = createQuickfixes(invocationContext, applicableAnnotations);
            selectAndRevealQuickfix(invocationContext, applicableAnnotations, result);
		} catch (BadLocationException e) {
			errorMessage = e.getMessage();
		} catch (OperationCanceledException e) {
			return new ICompletionProposal[0];
		}
		sortQuickfixes(result);
		return result.toArray(new ICompletionProposal[result.size()]);
	}

	/**
	 * @since 2.3
	 */
	protected List<ICompletionProposal> createQuickfixes(IQuickAssistInvocationContext invocationContext, Set<Annotation> applicableAnnotations) {
    	List<ICompletionProposal> result = Lists.newArrayList();
    	ISourceViewer sourceViewer = invocationContext.getSourceViewer();
		IAnnotationModel annotationModel = sourceViewer.getAnnotationModel();
		IXtextDocument xtextDocument = xtextDocumentUtil.getXtextDocument(sourceViewer);
    	for(Annotation annotation : applicableAnnotations) {
			if (annotation instanceof SpellingAnnotation) {
				SpellingProblem spellingProblem = ((SpellingAnnotation) annotation).getSpellingProblem();
				ICompletionProposal[] proposals = spellingProblem.getProposals();
				if (proposals != null) {
					result.addAll(asList(proposals));
				}
			} else {
				final Issue issue = issueUtil.getIssueFromAnnotation(annotation);
				Position pos = annotationModel.getPosition(annotation);
				if (issue != null && pos != null) {
					@SuppressWarnings("deprecation")
					Iterable<IssueResolution> resolutions = getResolutions(issue, xtextDocument);
					if (resolutions.iterator().hasNext()) {
						for (IssueResolution resolution : resolutions) {
							result.add(create(pos, resolution));
						}
					}
				}
			}
		}
    	return result;
    }

	/**
	 * @since 2.3
	 */
	protected void selectAndRevealQuickfix(IQuickAssistInvocationContext invocationContext, Set<Annotation> applicableAnnotations, List<ICompletionProposal> completionProposals) {
        if (completionProposals.isEmpty()) {
        	return;
        }
		if (!(invocationContext instanceof QuickAssistInvocationContext && ((QuickAssistInvocationContext) invocationContext).isSuppressSelection())) {
			ISourceViewer sourceViewer = invocationContext.getSourceViewer();
			IAnnotationModel annotationModel = sourceViewer.getAnnotationModel();
			Iterator<Annotation> iterator = applicableAnnotations.iterator();
			while (iterator.hasNext()) {
				Position pos = annotationModel.getPosition(iterator.next());
				if (pos != null) {
					sourceViewer.setSelectedRange(pos.getOffset(), pos.getLength());
					sourceViewer.revealRange(pos.getOffset(), pos.getLength());
					break;
				}
			}
		}
	}

	protected ICompletionProposal create(Position posisition, IssueResolution resolution) {
		return new QuickAssistCompletionProposal(posisition, resolution, getImage(resolution));
	}
	
	protected void sortQuickfixes(List<ICompletionProposal> quickFixes) {
		Collections.sort(quickFixes, comparator);
	}
	
	/**
	 * @since 2.19
	 */
	protected Set<Annotation> getApplicableAnnotations(final IDocument document, final IAnnotationModel annotationModel,
			final int offset) throws BadLocationException {
		if (document instanceof IXtextDocument) {
			return getApplicableAnnotations((IXtextDocument)document, annotationModel, offset);
		}
		return doGetApplicableAnnotations(document, annotationModel, offset);
	}

	private Set<Annotation> doGetApplicableAnnotations(final IDocument document, final IAnnotationModel annotationModel, final int offset)
			throws BadLocationException {
		final int line = document.getLineOfOffset(offset);
		final String delim = document.getLineDelimiter(line);
		final int delimLength = delim != null ? delim.length() : 0;
		final int lineLength = document.getLineLength(line) - delimLength;
		final int lineOffset = document.getLineOffset(line);

		Iterator<?> iterator;
		if (annotationModel instanceof IAnnotationModelExtension2)
			iterator = ((IAnnotationModelExtension2) annotationModel).getAnnotationIterator(lineOffset, lineLength, true, true);
		else
			iterator = annotationModel.getAnnotationIterator();

		Map<Annotation, Position> possibleAnnotations = Maps.newLinkedHashMap();
		boolean hasIncludingAnnotation = false;
		int smallestAnnotationDistance = Integer.MAX_VALUE;
		int offsetOfFirstAnnotation = Integer.MAX_VALUE;
		while (iterator.hasNext()) {
			Object key = iterator.next();
			if (key instanceof Annotation) {
				Annotation annotation = (Annotation) key;
				if (isSupported(annotation)) {
					Position pos = annotationModel.getPosition(annotation);
					// Consider all annotations that are on the same line as the cursor
					if (pos != null && pos.overlapsWith(lineOffset, lineLength)) {
						possibleAnnotations.put(annotation, pos);
						if (pos.includes(offset)) {
							hasIncludingAnnotation = true;
						} else if (offset >= pos.getOffset()) {
							int annotationDistance = offset - (pos.getOffset() + pos.getLength());
							if (annotationDistance < smallestAnnotationDistance)
								smallestAnnotationDistance = annotationDistance;
						} else if (pos.getOffset() < offsetOfFirstAnnotation) {
							offsetOfFirstAnnotation = pos.getOffset();
						}
					}
				}
			}
		}
		if (possibleAnnotations.isEmpty()) {
			return Collections.emptySet();
		}
		
		// There is an annotation that includes the cursor, so accept all including annotations
		if (hasIncludingAnnotation) {
			Set<Annotation> includingAnnotations = Sets.newLinkedHashSetWithExpectedSize(possibleAnnotations.size());
			for (Map.Entry<Annotation, Position> entry : possibleAnnotations.entrySet()) {
				if (entry.getValue().includes(offset) && canFix(entry.getKey()))
					includingAnnotations.add(entry.getKey());
			}
			return includingAnnotations;
		}
		
		// There is an annotation that is left of the cursor, so accept the nearest annotations on the left
		if (smallestAnnotationDistance != Integer.MAX_VALUE) {
			Set<Annotation> nearestAnnotations = Sets.newLinkedHashSetWithExpectedSize(possibleAnnotations.size());
			for (Map.Entry<Annotation, Position> entry : possibleAnnotations.entrySet()) {
				Position pos = entry.getValue();
				if (offset >= pos.getOffset() && offset - (pos.getOffset() + pos.getLength()) == smallestAnnotationDistance
						&& canFix(entry.getKey()))
					nearestAnnotations.add(entry.getKey());
			}
			return nearestAnnotations;
		}
		
		// Accept the nearest annotations on the right
		Set<Annotation> nearestAnnotations = Sets.newLinkedHashSetWithExpectedSize(possibleAnnotations.size());
		for (Map.Entry<Annotation, Position> entry : possibleAnnotations.entrySet()) {
			if (entry.getValue().getOffset() == offsetOfFirstAnnotation && canFix(entry.getKey()))
				nearestAnnotations.add(entry.getKey());
		}
		return nearestAnnotations;
	}

	/**
	 * Use {@link #getApplicableAnnotations(IDocument, IAnnotationModel, int)} instead.
	 */
	@Deprecated
	protected Set<Annotation> getApplicableAnnotations(final IXtextDocument document, final IAnnotationModel annotationModel,
			final int offset) throws BadLocationException {
		return doGetApplicableAnnotations(document, annotationModel, offset);
	}
	
	public IssueUtil getIssueUtil() {
		return issueUtil;
	}
	
}
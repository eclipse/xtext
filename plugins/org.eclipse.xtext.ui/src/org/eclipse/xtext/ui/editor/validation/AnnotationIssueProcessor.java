/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.validation;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.IAnnotationModelListener;
import org.eclipse.ui.texteditor.AnnotationTypeLookup;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.quickfix.XtextResourceMarkerAnnotationModel;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.Issue.Severity;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 * @author Heiko Behrens
 */
public class AnnotationIssueProcessor implements IValidationIssueProcessor, IAnnotationModelListener {
	private final IAnnotationModel annotationModel;
	private AnnotationTypeLookup lookup = new AnnotationTypeLookup();
	private final IXtextDocument xtextDocument;
	private boolean updateMarkersOnModelChange;
	private final IssueResolutionProvider issueResolutionProvider;

	public AnnotationIssueProcessor(IXtextDocument xtextDocument, IAnnotationModel annotationModel, IssueResolutionProvider issueResolutionProvider) {
		super();
		this.annotationModel = annotationModel;
		if (annotationModel != null)
			annotationModel.addAnnotationModelListener(this);
		this.xtextDocument = xtextDocument;
		this.issueResolutionProvider = issueResolutionProvider;
	}

	public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
		updateMarkersOnModelChange = false;
		List<Annotation> toBeRemoved = getAnnotationsToRemove(monitor);
		Multimap<Position, Annotation> positionToAnnotations = Multimaps.newArrayListMultimap();
		Map<Annotation, Position> annotationToPosition = getAnnotationsToAdd(positionToAnnotations, issues, monitor);
		updateMarkerAnnotations(monitor);
		updateAnnotations(monitor, toBeRemoved, annotationToPosition);
		updateMarkersOnModelChange = true;
	}

	private void updateAnnotations(IProgressMonitor monitor, List<Annotation> toBeRemoved,
			Map<Annotation, Position> annotationToPosition) {
		if (monitor.isCanceled()) {
			return;
		}
		if (annotationModel instanceof IAnnotationModelExtension) {
			Annotation[] removedAnnotations = toBeRemoved.toArray(new Annotation[toBeRemoved.size()]);
			((IAnnotationModelExtension) annotationModel).replaceAnnotations(removedAnnotations, annotationToPosition);
		} else {
			for (Annotation annotation : toBeRemoved) {
				if (monitor.isCanceled()) {
					return;
				}
				annotationModel.removeAnnotation(annotation);
			}
			for (Map.Entry<Annotation, Position> entry : annotationToPosition.entrySet()) {
				if (monitor.isCanceled()) {
					return;
				}
				annotationModel.addAnnotation(entry.getKey(), entry.getValue());
			}
		}
	}

	private List<Annotation> getAnnotationsToRemove(IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			return Lists.newArrayList();
		}
		@SuppressWarnings("unchecked")
		Iterator<Annotation> annotationIterator = annotationModel.getAnnotationIterator();
		List<Annotation> toBeRemoved = Lists.newArrayList();
		while (annotationIterator.hasNext()) {
			if (monitor.isCanceled()) {
				return toBeRemoved;
			}
			Annotation annotation = annotationIterator.next();
			String type = annotation.getType();
			if (isRelevantAnnotationType(type)) {
				if (!(annotation instanceof MarkerAnnotation)) {
					toBeRemoved.add(annotation);
				}
			}
		}
		return toBeRemoved;
	}

	private Map<Annotation, Position> getAnnotationsToAdd(Multimap<Position, Annotation> positionToAnnotations,
			List<Issue> issues, IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			return Maps.newHashBiMap();
		}
		Map<Annotation, Position> annotationToPosition = Maps.newHashMapWithExpectedSize(issues.size());
		for (Issue issue : issues) {
			if (monitor.isCanceled()) {
				return annotationToPosition;
			}
			if (isSet(issue.getOffset()) && isSet(issue.getLength()) && issue.getMessage() != null) {
				String type = lookup.getAnnotationType(EValidator.MARKER, getMarkerSeverity(issue.getSeverity()));
				boolean isQuickfixable = issueResolutionProvider.hasResolutionFor(issue.getCode());
				Annotation annotation = new XtextAnnotation(type, false, xtextDocument, issue, isQuickfixable);
				Position position = new Position(issue.getOffset(), issue.getLength());
				annotationToPosition.put(annotation, position);
				positionToAnnotations.put(position, annotation);
			}
		}
		return annotationToPosition;
	}

	private boolean isSet(Integer length) {
		return length!=null && length!=-1;
	}

	private int getMarkerSeverity(Severity severity) {
		switch (severity) {
			case ERROR:
				return IMarker.SEVERITY_ERROR;
			case WARNING:
				return IMarker.SEVERITY_WARNING;
			case INFO:
				return IMarker.SEVERITY_INFO;
		}
		throw new IllegalArgumentException();
	}

	private void updateMarkerAnnotations(IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			return;
		}
		
		Iterator<MarkerAnnotation> annotationIterator = Iterators.filter(annotationModel.getAnnotationIterator(),
				MarkerAnnotation.class);

		// every markerAnnotation produced by fast validation can be marked as deleted.
		// If its predicate still holds, the validation annotation will be covered anyway.
		while (annotationIterator.hasNext() && !monitor.isCanceled()) {
			final MarkerAnnotation annotation = annotationIterator.next();
			if(!annotation.isMarkedDeleted())
				try {
					if (isRelevantAnnotationType(annotation.getType())) {
						boolean markAsDeleted = annotation.getMarker().isSubtypeOf(MarkerTypes.FAST_VALIDATION);
						if(markAsDeleted) {
							annotation.markDeleted(true);
							announceAnnotationChanged(annotation);
						}
					}
				} catch (CoreException e) {
					// marker type cannot be resolved - keep state of annotation
				}
		}
	}

	private void announceAnnotationChanged(Annotation annotation) {
		if (annotationModel instanceof XtextResourceMarkerAnnotationModel)
			((XtextResourceMarkerAnnotationModel) annotationModel).fireAnnotationChangedEvent(annotation);
		else {
			Position position = annotationModel.getPosition(annotation);
			if (annotationModel instanceof IAnnotationModelExtension)
				((IAnnotationModelExtension) annotationModel).modifyAnnotationPosition(annotation, position);
			else {
				annotationModel.removeAnnotation(annotation);
				annotationModel.addAnnotation(annotation, position);
			}
		}
	}

	private boolean isRelevantAnnotationType(String type) {
		return type.equals(XtextEditor.ERROR_ANNOTATION_TYPE) || type.equals(XtextEditor.WARNING_ANNOTATION_TYPE);
	}

	public void modelChanged(IAnnotationModel model) {
		if (updateMarkersOnModelChange) {
			updateMarkerAnnotations(new NullProgressMonitor());
		}
	}
}

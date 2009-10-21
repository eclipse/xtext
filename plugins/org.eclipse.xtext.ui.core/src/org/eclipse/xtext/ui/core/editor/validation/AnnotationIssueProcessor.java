/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.ui.texteditor.AnnotationTypeLookup;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.xtext.ui.core.editor.XtextEditor;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
public class AnnotationIssueProcessor implements IValidationIssueProcessor {
	private final IAnnotationModel annotationModel;
	private AnnotationTypeLookup lookup = new AnnotationTypeLookup();

	public AnnotationIssueProcessor(IAnnotationModel annotationModel) {
		super();
		this.annotationModel = annotationModel;
	}

	public void processIssues(List<Map<String, Object>> issues, IProgressMonitor monitor) {
		List<Annotation> toBeRemoved = getAnnotationsToRemove(monitor);
		HashBiMap<Annotation, Position> annotationToPosition = getAnnotationsToAdd(issues, monitor);
		updateMarkerAnnotations(annotationToPosition.inverse(),monitor);
		updateAnnotations(monitor, toBeRemoved, annotationToPosition);
	}

	private void updateAnnotations(IProgressMonitor monitor, List<Annotation> toBeRemoved,
			HashBiMap<Annotation, Position> annotationToPosition) {
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

	private HashBiMap<Annotation, Position> getAnnotationsToAdd(List<Map<String, Object>> issues,
			IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			return Maps.newHashBiMap();
		}
		HashBiMap<Annotation, Position> annotationToPosition = new HashBiMap<Annotation, Position>(issues.size());
		for (Map<String, Object> map : issues) {
			if (monitor.isCanceled()) {
				return annotationToPosition;
			}
			Integer object = (Integer) map.get(IMarker.SEVERITY);
			String message = (String) map.get(IMarker.MESSAGE);
			Integer start = (Integer) map.get(IMarker.CHAR_START);
			Integer end = (Integer) map.get(IMarker.CHAR_END);
			if (start != null && end != null && message != null) {
				String type = lookup.getAnnotationType(EValidator.MARKER, object);
				Annotation annotation = new Annotation(type, false, message);
				Position position = new Position(start, end - start);
				annotationToPosition.put(annotation, position);
			}
		}
		return annotationToPosition;
	}

	private void updateMarkerAnnotations(Map<Position, Annotation> annotationsToAdd, IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			return;
		}
		@SuppressWarnings("unchecked")
		Iterator<Annotation> annotationIterator = annotationModel.getAnnotationIterator();
		while (annotationIterator.hasNext()) {
			if (monitor.isCanceled()) {
				return;
			}
			Annotation annotation = annotationIterator.next();
			if (isRelevantAnnotationType(annotation.getType()) && (annotation instanceof MarkerAnnotation)) {
				Position markerAnnotationPosition = annotationModel.getPosition(annotation);
				MarkerAnnotation markerAnnotation = (MarkerAnnotation) annotation;
				Annotation sourceAnnotation = annotationsToAdd.get(markerAnnotationPosition);
				boolean deleted = sourceAnnotation == null
						|| !sourceAnnotation.getText().equals(markerAnnotation.getText());
				markerAnnotation.markDeleted(deleted);
			}
		}
	}

	private boolean isRelevantAnnotationType(String type) {
		return type.equals(XtextEditor.ERROR_ANNOTATION_TYPE) || type.equals(XtextEditor.WARNING_ANNOTATION_TYPE);
	}
}

/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.texteditor.AnnotationTypeLookup;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.xtext.concurrent.IStateAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.editor.validation.IXtextResourceChecker;
import org.eclipse.xtext.ui.core.editor.validation.ValidationJob;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AnnotationBasedValidationJob extends ValidationJob {

	private final IAnnotationModel annotationModel;

	private AnnotationTypeLookup lookup = new AnnotationTypeLookup();

	public AnnotationBasedValidationJob(IXtextResourceChecker xtextResourceChecker,
			IStateAccess<XtextResource> xtextDocument, IAnnotationModel annotationModel) {
		super(xtextResourceChecker, xtextDocument);
		this.annotationModel = annotationModel;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void processIssues(List<Map<String, Object>> issues) {
		Iterator<Annotation> iter = annotationModel.getAnnotationIterator();
		Set<Annotation> toBeRemoved = new HashSet<Annotation>();
		while (iter.hasNext()) {
			Annotation annotation = iter.next();
			String type = annotation.getType();
			if (type.equals(XtextEditor.ERROR_ANNOTATION_TYPE) || type.equals(XtextEditor.WARNING_ANNOTATION_TYPE)) {
				if (annotation instanceof MarkerAnnotation) {
					annotation.markDeleted(true);
				}
				else {
					toBeRemoved.add(annotation);
				}
			}
		}
		for (Annotation annotation : toBeRemoved) {
			annotationModel.removeAnnotation(annotation);
		}
		for (Map<String, Object> map : issues) {
			Integer object = (Integer) map.get(IMarker.SEVERITY);
			String message = (String) map.get(IMarker.MESSAGE);
			Integer start = (Integer) map.get(IMarker.CHAR_START);
			Integer end = (Integer) map.get(IMarker.CHAR_END);
			if (start != null && end != null && message != null) {
				String type = lookup.getAnnotationType(EValidator.MARKER, object);
				Annotation annotation = new Annotation(type, false, message);
				annotationModel.addAnnotation(annotation, new Position(start, end - start));
			}
		}
	}
}

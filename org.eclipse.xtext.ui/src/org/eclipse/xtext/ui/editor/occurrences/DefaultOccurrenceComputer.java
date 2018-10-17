/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.occurrences;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static java.util.Collections.*;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultOccurrenceComputer implements IOccurrenceComputer {

	private static Logger LOG = Logger.getLogger(DefaultOccurrenceComputer.class);

	public static final String OCCURRENCE_ANNOTATION_TYPE = "org.eclipse.xtext.ui.editor.defaultOccurrenceAnnotation";
	public static final String DECLARATION_ANNOTATION_TYPE = "org.eclipse.xtext.ui.editor.declarationAnnotation";

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private IReferenceFinder referenceFinder;
	
	@Inject
	private Provider<TargetURIs> targetURIsProvider; 
	
	@Inject
	private TargetURICollector uriCollector;
	
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;
	
	@Inject
	private OperationCanceledManager operationCanceledManager;
	
	protected void addOccurrenceAnnotation(String type, IDocument document, ITextRegion textRegion,
			Map<Annotation, Position> annotationMap) {
		try {
			if (textRegion != null && textRegion.getLength() > 0) {
				Annotation annotation = new Annotation(type, false, document.get(textRegion.getOffset(),
						textRegion.getLength()));
				annotationMap.put(annotation, new Position(textRegion.getOffset(), textRegion.getLength()));
			}
		} catch (BadLocationException e) {
			LOG.error("Error creating occurrence annotation", e);
		}
	}
	
	private static class EObjectReferenceAndIndex {
		EObject source;
		EReference reference;
		int idx;
	}

	@Override
	public Map<Annotation, Position> createAnnotationMap(XtextEditor editor, final ITextSelection selection,
			final SubMonitor monitor) {
		final IXtextDocument document = editor.getDocument();
		if(document != null) {
			return document.tryReadOnly(new CancelableUnitOfWork<Map<Annotation, Position>, XtextResource>() {
				
				@Override
				public Map<Annotation, Position> exec(XtextResource resource, final CancelIndicator cancelIndicator)
						throws Exception {
					EObject target = eObjectAtOffsetHelper.resolveElementAt(resource, selection.getOffset());
					if (target != null && ! target.eIsProxy()) {
						final List<EObjectReferenceAndIndex> references = newArrayList();
						IReferenceFinder.Acceptor acceptor = new IReferenceFinder.Acceptor() {
							@Override
							public void accept(IReferenceDescription reference) {
								throw new UnsupportedOperationException("Local references are announced per object");
							}

							@Override
							public void accept(EObject source, URI sourceURI, EReference eReference, int index,
									EObject targetOrProxy, URI targetURI) {
								EObjectReferenceAndIndex acceptMe = new EObjectReferenceAndIndex();
								acceptMe.source = source;
								acceptMe.reference = eReference;
								acceptMe.idx = index;
								references.add(acceptMe);
							}
						};
						Iterable<URI> targetURIs = getTargetURIs(target);
						if (!(targetURIs instanceof TargetURIs)) {
							TargetURIs result = targetURIsProvider.get();
							result.addAllURIs(targetURIs);
							targetURIs = result;
						}
						IProgressMonitor localMonitor = new NullProgressMonitor() {
							@Override
							public boolean isCanceled() {
								return monitor.isCanceled() || cancelIndicator.isCanceled();
							}
						};
						referenceFinder.findReferences((TargetURIs) targetURIs, resource, acceptor, localMonitor);
						operationCanceledManager.checkCanceled(cancelIndicator);
						Map<Annotation, Position> result = newHashMapWithExpectedSize(references.size() + 1);
						if (target.eResource() == resource) {
							if (!references.isEmpty() || canBeReferencedLocally(target)) {
								ITextRegion declarationRegion = locationInFileProvider.getSignificantTextRegion(target);
								addOccurrenceAnnotation(DECLARATION_ANNOTATION_TYPE, document, declarationRegion, result);
							}
						}
						for (EObjectReferenceAndIndex highlightMe : references) {
							try {
								if (localMonitor.isCanceled()) {
									return emptyMap();
								}
								ITextRegion textRegion = locationInFileProvider.getSignificantTextRegion(highlightMe.source,
										highlightMe.reference, highlightMe.idx);
								addOccurrenceAnnotation(OCCURRENCE_ANNOTATION_TYPE, document, textRegion, result);
							} catch(Exception exc) {
								// outdated index information. Ignore
							}
						}
						return result;
					}
					return emptyMap();
				}
			}, () -> emptyMap());
		} else {
			return emptyMap();
		}
	}

	/**
	 * @since 2.3
	 */
	protected Iterable<URI> getTargetURIs(EObject primaryTarget) {
		TargetURIs result = targetURIsProvider.get();
		uriCollector.add(primaryTarget, result);
		return result;
	}

	/**
	 * @since 2.1
	 */
	protected boolean canBeReferencedLocally(EObject object) {
		boolean result = qualifiedNameProvider.getFullyQualifiedName(object) != null;
		return result;
	}

	@Override
	public boolean hasAnnotationType(String annotationType) {
		return DECLARATION_ANNOTATION_TYPE.equals(annotationType) || OCCURRENCE_ANNOTATION_TYPE.equals(annotationType);
	}
}

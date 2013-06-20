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
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.SimpleLocalResourceAccess;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

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
	private IQualifiedNameProvider qualifiedNameProvider;
	
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

	public Map<Annotation, Position> createAnnotationMap(XtextEditor editor, final ITextSelection selection,
			final SubMonitor monitor) {
		final IXtextDocument document = editor.getDocument();
		if(document != null) {
			return document.readOnly(new IUnitOfWork<Map<Annotation, Position>, XtextResource>() {
				public Map<Annotation, Position> exec(final XtextResource resource) throws Exception {
					if(resource != null) {
						EObject target = eObjectAtOffsetHelper.resolveElementAt(resource, (selection).getOffset());
						if (target != null && ! target.eIsProxy()) {
							monitor.setWorkRemaining(100);
							final List<IReferenceDescription> references = newArrayList();
							IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
								public void accept(IReferenceDescription reference) {
									references.add(reference);
								}
							};
							SimpleLocalResourceAccess localResourceAccess = new SimpleLocalResourceAccess(resource.getResourceSet());
							referenceFinder.findReferences(getTargetURIs(target), 
									singleton(resource.getURI()), localResourceAccess, acceptor, monitor.newChild(40));
							if (monitor.isCanceled())
								return emptyMap();
							Map<Annotation, Position> result = newHashMapWithExpectedSize(references.size() + 1);
							if (target.eResource() == resource) {
								if (!references.isEmpty() || canBeReferencedLocally(target)) {
									ITextRegion declarationRegion = locationInFileProvider.getSignificantTextRegion(target);
									addOccurrenceAnnotation(DECLARATION_ANNOTATION_TYPE, document, declarationRegion, result);
								}
							}
							monitor.worked(5);
							for (IReferenceDescription reference : references) {
								try {
									EObject source = resource.getEObject(reference.getSourceEObjectUri().fragment());
									if (source != null && reference.getEReference() != null) { // prevent exception for outdated data
										ITextRegion textRegion = locationInFileProvider.getSignificantTextRegion(source,
												reference.getEReference(), reference.getIndexInList());
										addOccurrenceAnnotation(OCCURRENCE_ANNOTATION_TYPE, document, textRegion, result);
									}
								} catch(Exception exc) {
									// outdated index information. Ignore
								}
							}
							monitor.worked(15);
							return result;
						}
					}
					return emptyMap();
				}
			});
		} else {
			return emptyMap();
		}
	}

	/**
	 * @since 2.3
	 */
	protected Iterable<URI> getTargetURIs(EObject target) {
		return singleton(EcoreUtil2.getPlatformResourceOrNormalizedURI(target));
	}
	
	/**
	 * @since 2.1
	 */
	protected boolean canBeReferencedLocally(EObject object) {
		boolean result = qualifiedNameProvider.getFullyQualifiedName(object) != null;
		return result;
	}

	public boolean hasAnnotationType(String annotationType) {
		return DECLARATION_ANNOTATION_TYPE.equals(annotationType) || OCCURRENCE_ANNOTATION_TYPE.equals(annotationType);
	}
}

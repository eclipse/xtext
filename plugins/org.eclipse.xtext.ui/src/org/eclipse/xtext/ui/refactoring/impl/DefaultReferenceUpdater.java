/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringCrossReferenceSerializer.RefTextEvaluator;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * Creates updates for all references from Xtext based resources to a renamed element using Xtext's serialization API.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultReferenceUpdater extends AbstractReferenceUpdater {

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private ITransientValueService transientValueService;

	/**
	 * @since 2.4 Replaces the obsolete CrossReferenceSerializerFacade
	 */
	@Inject
	private RefactoringCrossReferenceSerializer crossReferenceSerializer;

	@Override
	protected void createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			Multimap<URI, IReferenceDescription> resource2references, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Creating reference updates", resource2references.keySet()
				.size());
		for (URI referringResourceURI : resource2references.keySet()) {
			if (progress.isCanceled())
				return;
			Resource referringResource = resourceSet.getResource(referringResourceURI, false);
			if (!(referringResource instanceof XtextResource)) {
				updateAcceptor.getRefactoringStatus().add(ERROR, "Resource {0} is not an XtextResource.",
						referringResource.getURI(), resourceSet);
			} else {
				Iterable<IReferenceDescription> referenceDescriptions = resource2references.get(referringResourceURI);
				processReferringResource(referringResource, referenceDescriptions, elementRenameArguments,
						updateAcceptor);
			}
			progress.worked(1);
		}
	}

	/**
	 * Override this method for pre- or post-processing hooks.
	 */
	protected void processReferringResource(Resource referringResource,
			Iterable<IReferenceDescription> referenceDescriptions, ElementRenameArguments elementRenameArguments,
			IRefactoringUpdateAcceptor updateAcceptor) {
		((XtextResource) referringResource).getCache().clear(referringResource);
		for (IReferenceDescription referenceDescription : referenceDescriptions) {
			createReferenceUpdate(referenceDescription, referringResource.getURI(), elementRenameArguments,
					referringResource.getResourceSet(), updateAcceptor);
		}
	}

	protected void createReferenceUpdate(IReferenceDescription referenceDescription, URI referringResourceURI,
			ElementRenameArguments elementRenameArguments, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor) {
		URI referringElementNewURI = elementRenameArguments
				.getNewElementURI(referenceDescription.getSourceEObjectUri());
		EObject referringElement = resourceSet.getEObject(referringElementNewURI, false);
		URI targetElementNewURI = elementRenameArguments.getNewElementURI(referenceDescription.getTargetEObjectUri());
		EObject newTargetElement = resourceSet.getEObject(targetElementNewURI, false);
		createReferenceUpdate(referringElement, referringResourceURI, referenceDescription.getEReference(),
				referenceDescription.getIndexInList(), newTargetElement, updateAcceptor);
	}

	protected void createReferenceUpdate(EObject referringElement, URI referringResourceURI, EReference reference,
			int indexInList, EObject newTargetElement, IRefactoringUpdateAcceptor updateAcceptor) {
		if (!transientValueService.isTransient(referringElement, reference, indexInList)) {
			ITextRegion referenceTextRegion = locationInFileProvider.getFullTextRegion(referringElement, reference,
					indexInList);
			CrossReference crossReference = getCrossReference(referringElement, referenceTextRegion.getOffset());
			if (crossReference != null) {
				RefTextEvaluator refTextComparator = getRefTextEvaluator(referringElement, referringResourceURI, reference,
						indexInList, newTargetElement);
				String newReferenceText = crossReferenceSerializer.getCrossRefText(referringElement,
						crossReference, newTargetElement, refTextComparator, referenceTextRegion, updateAcceptor.getRefactoringStatus());
				if (newReferenceText == null) {
					newReferenceText = resolveNameConflict(referringElement, reference, newTargetElement, updateAcceptor);
				}
				if (newReferenceText == null) {
					updateAcceptor.getRefactoringStatus().add(RefactoringStatus.ERROR, "Refactoring introduces a name conflict.", referringElement, referenceTextRegion);
				}
				createTextChange(referenceTextRegion, newReferenceText, referringElement, newTargetElement, reference, 
						referringResourceURI, updateAcceptor);
			}
		}
	}
	
	/**
	 * Return null if it is not possible to resolve a name conflict; otherwise a name which should be used.
	 * @param updateAcceptor 
	 * @since 2.6
	 */
	protected String resolveNameConflict(EObject referringElement, EReference reference, EObject newTargetElement, IRefactoringUpdateAcceptor updateAcceptor) {
		return null;
	}

	/**
	 * The result is used to determine the best new link text in case of multiple possibilities.
	 * By default, the shortest text is chosen.
	 * 
	 * @since 2.4
	 */
	protected RefTextEvaluator getRefTextEvaluator(EObject referringElement, URI referringResourceURI, EReference reference,
			int indexInList, EObject newTargetElement) {
		// by default choose the shortest text
		return new RefTextEvaluator() {
			public boolean isValid(IEObjectDescription target) {
				return true;
			}
			
			public boolean isBetterThan(String newText, String currentText) {
				return newText.length() < currentText.length();
			}
		};
	}

	protected void createTextChange(ITextRegion referenceTextRegion, String newReferenceText,
			EObject referringElement, EObject newTargetElement, EReference reference, 
			URI referringResourceURI, IRefactoringUpdateAcceptor updateAcceptor) {
		if (newReferenceText != null) {
			TextEdit referenceEdit = new ReplaceEdit(referenceTextRegion.getOffset(),
					referenceTextRegion.getLength(), newReferenceText);
			updateAcceptor.accept(referringResourceURI, referenceEdit);
		}
	}

	protected CrossReference getCrossReference(EObject referringElement, int offset) {
		ICompositeNode node = NodeModelUtils.getNode(referringElement);
		if (node != null) {
			Iterator<INode> iter = node.getAsTreeIterable().iterator();
			while (iter.hasNext()) {
				INode childNode = iter.next();
				if (childNode.getOffset() >= offset && childNode.getGrammarElement() instanceof CrossReference)
					return (CrossReference) childNode.getGrammarElement();
			}
		}
		return null;
	}

	protected ILocationInFileProvider getLocationInFileProvider() {
		return locationInFileProvider;
	}

	protected ITransientValueService getTransientValueService() {
		return transientValueService;
	}

}

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static org.eclipse.xtext.util.Strings.*;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.UpdateAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DefaultReferenceUpdater extends AbstractReferenceUpdater {

	@Inject
	private IRefactoringDocument.Provider refactoringDocumentProvider;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private RenamedElementResolver renamedElementResolver;
	
	@Inject
	private ITokenSerializer.ICrossReferenceSerializer crossReferenceSerializer;


	@Override
	protected void internalCreateReferenceUpdates(ElementRenameArguments elementRenameArguments,
			Multimap<URI, IReferenceDescription> resource2references, ResourceSet resourceSet,
			ReplaceRegion declarationEdit, UpdateAcceptor updateAcceptor, RefactoringStatus status) {
		OffsetCorrector offsetCorrector = new OffsetCorrector(elementRenameArguments.getBaseElementRenameInfo()
				.getDocument(), declarationEdit);
		Map<URI, EObject> uri2renamedElement = renamedElementResolver.resolveRenamedElements(
				elementRenameArguments.getAllElementRenameInfos(), resourceSet, offsetCorrector);
		for (URI referringResourceURI : resource2references.keySet()) {
			Resource referringResource = resourceSet.getResource(referringResourceURI,
					false);
			IRefactoringDocument referringDocument = refactoringDocumentProvider.get(referringResourceURI,
					status);
			if(!(referringResource instanceof XtextResource)) {
				throw new RefactoringStatusException("Resource " + notNull(referringResourceURI)
						+ " is not an XtextResource", true);
			}
			((XtextResource)referringResource).getCache().clear(referringResource);

			for (IReferenceDescription referenceDescription : resource2references.get(referringResourceURI)) {
				EObject referringElement = renamedElementResolver.resolveReferringElement(referringResource, referenceDescription,
						uri2renamedElement);
				EObject newTargetElement = uri2renamedElement.get(referenceDescription.getTargetEObjectUri());
				createReferenceUpdate(referringElement, referringDocument,
						referenceDescription.getEReference(), referenceDescription.getIndexInList(),
						newTargetElement, updateAcceptor, offsetCorrector, status);
			}
		}
	}

	protected void createReferenceUpdate(EObject referringElement, IRefactoringDocument referringDocument,
			EReference reference, int indexInList, EObject newTargetElement, UpdateAcceptor updateAcceptor,
			OffsetCorrector offsetCorrector, final RefactoringStatus status) {
		try {
			ITextRegion referenceTextRegion = locationInFileProvider.getFullTextRegion(referringElement, reference,
					indexInList);
			CrossReference crossReference = getCrossReference(referringElement, referenceTextRegion.getOffset());
			String newReferenceText = crossReferenceSerializer.serializeCrossRef(referringElement, crossReference,
					newTargetElement, null);
			// TODO: add import hook
			int correctedOffset = offsetCorrector.newToOld(referringDocument, referenceTextRegion.getOffset());
			ReplaceRegion referenceEdit = new ReplaceRegion(correctedOffset, referenceTextRegion.getLength(),
					newReferenceText);
			updateAcceptor.accept(referringDocument, referenceEdit);
		} catch (Exception e) {
			status.addFatalError(e.getMessage());
		}
	}

	protected CrossReference getCrossReference(EObject referringElement, int offset) {
		ICompositeNode node = NodeModelUtils.getNode(referringElement);
		Iterator<INode> iter = node.getAsTreeIterable().iterator();
		while (iter.hasNext()) {
			INode childNode = iter.next();
			if (childNode.getOffset() >= offset && childNode.getGrammarElement() instanceof CrossReference)
				return (CrossReference) childNode.getGrammarElement();
		}
		return null;
	}

}

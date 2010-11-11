/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ReferenceUpdater {

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private ITokenSerializer.ICrossReferenceSerializer crossReferenceSerializer;

	public void createReferenceUpdates(final RefactoringDocument referringDocument,
			final Iterable<IReferenceDescription> oldReferenceDescriptions, final EObject newTargetEObject,
			final TextEditAcceptor acceptor, final ReplaceEdit appliedDeclarationEdit, final RefactoringStatus status) {
		try {
			final int declarationEnd = (appliedDeclarationEdit != null) ? appliedDeclarationEdit.getOffset()
					+ appliedDeclarationEdit.getText().length() : 0;
			final int declarationDelta = (appliedDeclarationEdit != null) ? appliedDeclarationEdit.getText().length()
					- appliedDeclarationEdit.getLength() : 0;
			referringDocument.getXtextDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource referringResource) throws Exception {
					for (IReferenceDescription referenceDescription : oldReferenceDescriptions) {
						checkReferenceDescription(referenceDescription);
						EObject referringElement = referringResource.getEObject(referenceDescription
								.getSourceEObjectUri().fragment());
						if (referringElement == null)
							status.addError("Refering element connot be resolved");
						System.err.println(referenceDescription.getSourceEObjectUri());
						ITextRegion referenceTextRegion = locationInFileProvider.getFullTextRegion(referringElement,
								referenceDescription.getEReference(), referenceDescription.getIndexInList());
						CrossReference crossReference = getCrossReference(referringElement,
								referenceTextRegion.getOffset());
						String newReferenceText = crossReferenceSerializer.serializeCrossRef(referringElement,
								crossReference, newTargetEObject, null);
						// TODO: add import hook
						int delta = (declarationDelta != 0 && declarationEnd <= referenceTextRegion.getOffset()) ? declarationDelta
								: 0;
						TextEdit referenceEdit = new ReplaceEdit(referenceTextRegion.getOffset() - delta,
								referenceTextRegion.getLength(), newReferenceText);
						acceptor.accept(referringDocument, referenceEdit);
					}
				}

			});
		} catch (Exception e) {
			status.addFatalError(e.getMessage());
			
		}	
	}

	protected void checkReferenceDescription(IReferenceDescription referenceDescription) {
		if (referenceDescription.getSourceEObjectUri() == null
				|| referenceDescription.getTargetEObjectUri() == null
				|| referenceDescription.getEReference() == null)
			throw new IllegalStateException("Indexed reference data is corrupt. Consider a clean build.");
	}

	protected CrossReference getCrossReference(EObject referringElement, int offset) {
		CompositeNode node = NodeUtil.getNode(referringElement);
		for (AbstractNode childNode : NodeUtil.getAllContents(node)) {
			if (childNode.getOffset() >= offset && childNode.getGrammarElement() instanceof CrossReference)
				return (CrossReference) childNode.getGrammarElement();
		}
		return null;
	}
}

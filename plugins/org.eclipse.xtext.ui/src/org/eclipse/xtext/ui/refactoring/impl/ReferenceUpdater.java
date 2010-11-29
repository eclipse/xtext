/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReferenceUpdater {

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private ITokenSerializer.ICrossReferenceSerializer crossReferenceSerializer;
	
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	public void createReferenceUpdates(final CrossRefRenameInfo.Table crossRefInfos,
			final IRefactoringDocument targetDocument, final ReplaceEdit declarationEdit,
			final TextEditAcceptor acceptor, final RefactoringStatus status) {
		for (final IRefactoringDocument referringDocument : crossRefInfos.getDocuments()) {
			referringDocument.readOnly(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource referringResource) throws Exception {
					createReferenceUpdates(referringDocument, referringResource, crossRefInfos, targetDocument,
							declarationEdit, acceptor, status);
				}
			});
		}
	}

	protected void createReferenceUpdates(final IRefactoringDocument referringDocument,
			XtextResource referringResource, final CrossRefRenameInfo.Table crossRefInfos,
			final IRefactoringDocument targetDocument, final ReplaceEdit declarationEdit,
			final TextEditAcceptor acceptor, final RefactoringStatus status) {
		// clear cache such that names of elements in scopes are recalculated
		referringResource.getCache().clear(referringResource);
		for (final CrossRefRenameInfo crossRefInfo : crossRefInfos.getByDocument(referringDocument)) {
			final EObject referringElement = referringResource.getEObject(crossRefInfo.getReferrerElementURI()
					.fragment());
			if (referringElement == null)
				throw new RefactoringStatusException("Refering element connot be resolved", true);
			crossRefInfo.getRenamedTarget().getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource targetResource) throws Exception {
					// eObjectURI might have changed with the declaration so we use the offset 
					EObject newTargetEObject = eObjectAtOffsetHelper.resolveElementAt(targetResource,
							crossRefInfo.getRenamedTarget().getOffset());
					if (referringDocument == targetDocument) {
						createReferenceUpdate(referringElement, crossRefInfo, newTargetEObject, acceptor,
								declarationEdit, status);
					} else {
						createReferenceUpdate(referringElement, crossRefInfo, newTargetEObject, acceptor, null, status);
					}
				}
			});
		}
	}

	protected void createReferenceUpdate(final EObject referringElement, final CrossRefRenameInfo crossRefInfo,
			final EObject newTargetEObject, final TextEditAcceptor acceptor, final ReplaceEdit appliedDeclarationEdit,
			final RefactoringStatus status) {
		try {
			final int declarationEnd = (appliedDeclarationEdit != null) ? appliedDeclarationEdit.getOffset()
					+ appliedDeclarationEdit.getText().length() : 0;
			final int declarationDelta = (appliedDeclarationEdit != null) ? appliedDeclarationEdit.getText().length()
					- appliedDeclarationEdit.getLength() : 0;
			ITextRegion referenceTextRegion = locationInFileProvider.getFullTextRegion(referringElement,
					crossRefInfo.getEReference(), crossRefInfo.getIndex());
			CrossReference crossReference = getCrossReference(referringElement, referenceTextRegion.getOffset());
			String newReferenceText = crossReferenceSerializer.serializeCrossRef(referringElement, crossReference,
					newTargetEObject, null);
			// TODO: add import hook
			int delta = (declarationDelta != 0 && declarationEnd <= referenceTextRegion.getOffset()) ? declarationDelta
					: 0;
			TextEdit referenceEdit = new ReplaceEdit(referenceTextRegion.getOffset() - delta,
					referenceTextRegion.getLength(), newReferenceText);
			acceptor.accept(crossRefInfo.getReferringDocument(), referenceEdit);
		} catch (Exception e) {
			status.addFatalError(e.getMessage());

		}
	}

	protected CrossReference getCrossReference(EObject referringElement, int offset) {
		ICompositeNode node = NodeModelUtils.getNode(referringElement);
		Iterator<INode> iter = node.getAsTreeIterable().iterator();
		while(iter.hasNext()) {
			INode childNode = iter.next();
			if (childNode.getOffset() >= offset && childNode.getGrammarElement() instanceof CrossReference)
				return (CrossReference) childNode.getGrammarElement();
		}
		return null;
	}
}

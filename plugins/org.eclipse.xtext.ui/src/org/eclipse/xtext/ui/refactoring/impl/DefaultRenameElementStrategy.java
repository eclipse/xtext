/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.IRenameElementStrategy;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DefaultRenameElementStrategy implements IRenameElementStrategy {

	public static class Provider implements IRenameElementStrategy.Provider {

		private static final Logger LOG = Logger.getLogger(Provider.class);

		@Inject
		private ILocationInFileProvider locationInFileProvider;

		public IRenameElementStrategy get(final URI targetElementURI, IRefactoringDocument targetDocument) {
			if(targetDocument == null) {
				return null;
			}
			return new DefaultRenameElementStrategy(targetElementURI, targetDocument, locationInFileProvider);
		}

		protected void logStatus(RefactoringStatus status) {
			for(RefactoringStatusEntry entry : status.getEntries()) {
				switch(entry.getSeverity()) {
				case RefactoringStatus.ERROR:
				case RefactoringStatus.FATAL:
					LOG.error(entry.getMessage());
					break;
				case RefactoringStatus.WARNING:
					LOG.warn(entry.getMessage());
					break;
				case RefactoringStatus.INFO:
					LOG.info(entry.getMessage());
				}
			}
		}
	}

	protected ITextRegion currentNameTextRegion;
	protected String currentName;
	protected ElementRenameInfo.Table renamedElementsTable;

	protected DefaultRenameElementStrategy(final URI targetElementURI, final IRefactoringDocument targetDocument,
			final ILocationInFileProvider locationInFileProvider) {
		renamedElementsTable = new ElementRenameInfo.Table();
		targetDocument.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource resource) {
				EObject eObject = resource.getEObject(targetElementURI.fragment());
				if (eObject == null)
					throw new RefactoringStatusException("Element could not be resolved", true);
				EAttribute nameAttribute = getNameAttribute(eObject);
				currentNameTextRegion = locationInFileProvider.getFullTextRegion(eObject, nameAttribute, 0);
				currentName = eObject.eGet(nameAttribute).toString();
				if (Strings.isEmpty(currentName))
					throw new RefactoringStatusException("Target element does not have a name", false);
				renamedElementsTable.add(new ElementRenameInfo(targetDocument, targetElementURI, currentNameTextRegion.getOffset()));
				addContentsToBeRenamed(targetDocument, eObject, locationInFileProvider);
			}
		});
	}

	public String getCurrentName() {
		return currentName;
	}

	public ReplaceEdit getRenameEdit(String newName) {
		if (Strings.isEmpty(newName))
			throw new RefactoringStatusException("New name is not set", false);
		return new ReplaceEdit(currentNameTextRegion.getOffset(), currentNameTextRegion.getLength(), newName);
	}

	public RefactoringStatus validateNewName(String newName) {
		RefactoringStatus newRefactoringStatus = new RefactoringStatus();
		if (Strings.equal(newName, currentName))
			newRefactoringStatus.addWarning("Name should be different");
		return newRefactoringStatus;
	}

	protected EAttribute getNameAttribute(EObject eObject) {
		return SimpleAttributeResolver.NAME_RESOLVER.getAttribute(eObject);
	}

	protected void addContentsToBeRenamed(final IRefactoringDocument targetDocument, EObject eObject,
			final ILocationInFileProvider locationInFileProvider) {
		for(Iterator<EObject> i = EcoreUtil.getAllProperContents(eObject, false); i.hasNext();) {
			EObject childElement = i.next();
			URI childURI = EcoreUtil.getURI(childElement);
			ITextRegion childTextRegion = locationInFileProvider.getSignificantTextRegion(childElement);
			if(childURI != null && childTextRegion != null) {
				renamedElementsTable.add(new ElementRenameInfo(targetDocument, childURI, childTextRegion.getOffset()));
			}
		}
	}

	public ElementRenameInfo.Table getRenamedElementInfos() {
		return renamedElementsTable;
	}

}

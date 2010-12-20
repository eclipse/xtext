/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static org.eclipse.xtext.util.Strings.*;

import java.io.ByteArrayOutputStream;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.UpdateAcceptor;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class XMLReferenceUpdater extends AbstractReferenceUpdater {

	@Inject
	private IRefactoringDocument.Provider refactoringDocumentProvider;

	private static final Logger LOG = Logger.getLogger(XMLReferenceUpdater.class);

	@Override
	protected void internalCreateReferenceUpdates(ElementRenameArguments elementRenameArguments,
			Multimap<URI, IReferenceDescription> resource2references, ResourceSet resourceSet,
			ReplaceRegion declarationEdit, UpdateAcceptor updateAcceptor, RefactoringStatus status, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Updating XMI References", resource2references.keySet().size());
		for (URI referringResourceURI : resource2references.keySet()) {
			try {
				if(progress.isCanceled())
					break;
				Resource referringResource = resourceSet.getResource(referringResourceURI, false);
				if(!(referringResource instanceof XMLResource)) {
					throw new RefactoringStatusException("Referring resource in XMLReferenceUpdater is not an XMLResource.", false);
				}
				IRefactoringDocument referringDocument = refactoringDocumentProvider.get(referringResourceURI, status);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				referringResource.save(outputStream, null);
				String newContent = new String(((XMLResource) referringResource).getEncoding());
				updateAcceptor.accept(referringDocument, new ReplaceRegion(0, referringDocument.getContents().length(), newContent));
				progress.worked(1);
			} catch (Exception exc) {
				status.addFatalError("Could not save referring resource " + notNull(referringResourceURI)
						+ ". See log for details.");
				LOG.error(exc);
			}
		}
	}
	
}

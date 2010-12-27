/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.io.ByteArrayOutputStream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * A generic reference updater for EMF resources referring to Xtext elements.
 * 
 * Uses the resources default serialization mechanism to update resources. This only works if the resource does not have
 * errors. For Xtext-based languages it is far more error tolerant to use a {@link DefaultReferenceUpdater} that only
 * serializes the sections of the document that contain the cross-references.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class EmfResourceReferenceUpdater extends AbstractReferenceUpdater {

	@Inject
	private IEncodingProvider encodingProvider;

	@Override
	protected void createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			Multimap<URI, IReferenceDescription> resource2references, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Updating EMF References", resource2references.keySet()
				.size());
		for (URI referringResourceURI : resource2references.keySet()) {
			try {
				if (progress.isCanceled())
					break;
				Resource referringResource = resourceSet.getResource(referringResourceURI, false);
				IRefactoringDocument referringDocument = updateAcceptor.getDocument(referringResourceURI);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				referringResource.save(outputStream, null);
				String newContent = new String(outputStream.toByteArray(),
						encodingProvider.getEncoding(referringResourceURI));
				updateAcceptor.accept(referringResourceURI, new ReplaceEdit(0, referringDocument.getOriginalContents()
						.length(), newContent));
				progress.worked(1);
			} catch (Exception exc) {
				throw new WrappedException(exc);
			}
		}
	}

}

/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;

import com.google.inject.Inject;

/**
 * Serialize an EMF resource and delivers the resulting text as an {@link TextEdit} that replaces the old content.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EmfResourceChangeUtil {

	@Inject
	private IEncodingProvider encodingProvider;

	public void addSaveAsUpdate(Resource resource, IRefactoringUpdateAcceptor updateAcceptor) throws IOException {
		IRefactoringDocument document = updateAcceptor.getDocument(resource.getURI());
		if (document == null) return;

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		resource.save(outputStream, null);
		String newContent = new String(outputStream.toByteArray(), encodingProvider.getEncoding(resource.getURI()));
		updateAcceptor.accept(resource.getURI(),
				new ReplaceEdit(0, document.getOriginalContents().length(), newContent));
	}

}

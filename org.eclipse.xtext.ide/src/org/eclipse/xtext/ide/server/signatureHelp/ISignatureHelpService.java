/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.signatureHelp;

import static java.util.Collections.*;

import org.eclipse.lsp4j.SignatureHelp;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

/**
 * Representation of a service for getting the {@link SignatureHelp signature
 * help}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@ImplementedBy(ISignatureHelpService.Noop.class)
public interface ISignatureHelpService {

	/**
	 * Shared, immutable empty instance. 
	 */
	SignatureHelp EMPTY = new SignatureHelp(emptyList(), null, null);
	
	SignatureHelp getSignatureHelp(Document document, XtextResource resource, TextDocumentPositionParams params, CancelIndicator cancelIndicator);
	
	/**
	 * Returns with a {@link SignatureHelp signature help} instance for a
	 * resource at a given offset. This method never returns with {@code null}.
	 * 
	 * @param resource
	 *            the resource to extract the help for a method/operation
	 *            signature.
	 * @param offset
	 *            the offset of the cursor in the resource.
	 * 
	 * @return a signature help instance.
	 */
	@Deprecated
	SignatureHelp getSignatureHelp(final XtextResource resource, final int offset);

	/**
	 * NOOP {@link ISignatureHelpService signature help service} implementation.
	 * 
	 * @author akos.kitta - Initial contribution and API
	 */
	@Singleton
	public static class Noop implements ISignatureHelpService {
		
		@Override
		public SignatureHelp getSignatureHelp(final XtextResource resource, final int offset) {
			return EMPTY;
		}

		@Override
		public SignatureHelp getSignatureHelp(Document document, XtextResource resource, TextDocumentPositionParams params, CancelIndicator cancelIndicator) {
			return EMPTY;
		}

	}

}

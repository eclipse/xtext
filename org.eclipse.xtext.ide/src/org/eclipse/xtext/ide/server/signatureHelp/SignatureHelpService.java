/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.signatureHelp;

import org.eclipse.lsp4j.SignatureHelp;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

/**
 * Representation of a service for getting the {@link SignatureHelp signature
 * help}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@ImplementedBy(SignatureHelpService.Noop.class)
public interface SignatureHelpService {

	/**
	 * Shared, immutable empty instance. 
	 */
	SignatureHelp EMPTY = new SignatureHelp();
	
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
	SignatureHelp getSignatureHelp(final XtextResource resource, final int offset);

	/**
	 * NOOP {@link SignatureHelpService signature help service} implementation.
	 * 
	 * @author akos.kitta - Initial contribution and API
	 */
	@Singleton
	public static class Noop implements SignatureHelpService {
		
		@Override
		public SignatureHelp getSignatureHelp(final XtextResource resource, final int offset) {
			return EMPTY;
		}

	}

}

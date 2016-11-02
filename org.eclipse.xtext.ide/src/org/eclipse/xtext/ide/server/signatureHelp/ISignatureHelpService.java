/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.signatureHelp;

import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

import io.typefox.lsapi.SignatureHelp;
import io.typefox.lsapi.builders.SignatureHelpBuilder;

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
	SignatureHelp EMPTY = new SignatureHelpBuilder().build();
	
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

	}

}

/*******************************************************************************
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.signatureHelp;

import static java.util.Collections.*;

import org.eclipse.lsp4j.SignatureHelp;
import org.eclipse.lsp4j.SignatureHelpParams;
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
	
	SignatureHelp getSignatureHelp(Document document, XtextResource resource, SignatureHelpParams params, CancelIndicator cancelIndicator);

	/**
	 * NOOP {@link ISignatureHelpService signature help service} implementation.
	 * 
	 * @author akos.kitta - Initial contribution and API
	 */
	@Singleton
	public static class Noop implements ISignatureHelpService {

		@Override
		public SignatureHelp getSignatureHelp(Document document, XtextResource resource, SignatureHelpParams params, CancelIndicator cancelIndicator) {
			return EMPTY;
		}

	}

}

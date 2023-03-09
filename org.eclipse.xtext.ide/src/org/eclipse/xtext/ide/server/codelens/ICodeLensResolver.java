/*******************************************************************************
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.codelens;

import org.eclipse.lsp4j.CodeLens;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface ICodeLensResolver {
	
	/**
	 * Resolve the given code lens.
	 */
	CodeLens resolveCodeLens(Document document, XtextResource resource, CodeLens codeLens, CancelIndicator indicator);
}

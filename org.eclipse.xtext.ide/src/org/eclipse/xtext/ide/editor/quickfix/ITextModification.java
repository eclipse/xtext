/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.quickfix;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtext.ide.server.Document;

/**
 * @author Rubén Porras Campo - Initial contribution and API
 *
 * @since 2.27
 */
@FunctionalInterface
public interface ITextModification {
	/**
	 *
	 * Returns a list of {@link TextEdit}s given a diagnostic, object and document.
	 *
	 * @param diagnostic
	 *            the {@link Diagnostic}
	 * @param object
	 *            the {@link EObject} after {@code diagnostic.getRange().getStart()}
	 * @param document
	 *            the {@link Document} with the URI given in the diagnostic
	 *
	 * @return 0..n {@link TextEdit}
	 */
	List<TextEdit> apply(Diagnostic diagnostic, EObject object, Document document);
}
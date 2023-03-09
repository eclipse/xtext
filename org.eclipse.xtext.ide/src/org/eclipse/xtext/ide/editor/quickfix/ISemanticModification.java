/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.quickfix;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.xtext.ide.serializer.IChangeSerializer.IModification;

/**
 * @author Rubén Porras Campo - Initial contribution and API
 *
 * @since 2.27
 */
@FunctionalInterface
public interface ISemanticModification {
	/**
	 *
	 * Returns an {@link IModification} given a diagnostic and an object.
	 *
	 * @param diagnostic
	 *            the {@link Diagnostic}
	 * @param object
	 *            the {@link EObject} after {@code diagnostic.getRange().getStart()}
	 *
	 * @return the {@link IModification}
	 */
	IModification<EObject> apply(Diagnostic diagnostic, EObject object);
}
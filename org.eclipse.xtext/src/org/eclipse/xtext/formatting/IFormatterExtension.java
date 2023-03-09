/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
public interface IFormatterExtension {

	ITokenStream createFormatterStream(EObject context, String initalIndentation, ITokenStream outputStream, boolean preserveWhitespaces);
	
}

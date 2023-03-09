/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface ISourceAppender {
	
	ISourceAppender append(CharSequence string);

	ISourceAppender append(JvmType type);

	ISourceAppender append(LightweightTypeReference typeRef);

	ISourceAppender newLine();

	ISourceAppender increaseIndentation();

	ISourceAppender decreaseIndentation();
	
	boolean isJava();
	
}

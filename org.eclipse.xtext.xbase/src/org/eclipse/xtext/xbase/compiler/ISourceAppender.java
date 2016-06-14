/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

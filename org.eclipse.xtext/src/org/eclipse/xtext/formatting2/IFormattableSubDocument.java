/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

/**
 * A sub document describes the formatting for a part of the entire document.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @see AbstractFormatter2#createFormattableSubDocument(ITextSegment, IFormattableDocument)
 */
public interface IFormattableSubDocument extends IFormattableDocument {
	IFormattableSubDocument requireFitsInLine(); // TODO: fits in line completely vs. first line fits in line.

	IFormattableSubDocument requireFitsInLine(int offset, int length, int maxLineWidth);
}

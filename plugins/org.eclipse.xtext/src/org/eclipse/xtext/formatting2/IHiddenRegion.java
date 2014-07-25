/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.List;

public interface IHiddenRegion extends ITextRegion { // IHiddenRegion

	boolean containsComment();

	ISemanticRegion getNextToken();

	ISemanticRegion getPreviousToken();

	List<IHiddenRegionPart> getWhitespaceAndComments(); // getParts();

	boolean isUndefined();
}
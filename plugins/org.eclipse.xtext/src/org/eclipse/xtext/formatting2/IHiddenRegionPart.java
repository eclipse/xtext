/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import org.eclipse.xtext.AbstractRule;

public interface IHiddenRegionPart extends ITextRegion { // IHiddenRegionPart
	IHiddenRegion getGap();

	AbstractRule getGrammarElement(); // EObject

	// IHidden getNextHidden(); // stays within the same gap!
	// IHidden getPreviousHidden(); // stays within the same gap!
}
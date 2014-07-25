/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.ITextSegment;

public interface IHiddenRegionPart extends ITextSegment {
	IHiddenRegion getHiddenRegion();

	EObject getGrammarElement();

	IHiddenRegionPart getNextHiddenPart(); // stays within the same HiddenRegion!

	IHiddenRegionPart getPreviousHiddenPart(); // stays within the same HiddenRegion!
}
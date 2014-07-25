/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;

public interface ISemanticRegion extends ITextRegion { // ISemanticRegion
	AbstractElement getGrammarElement();

	IHiddenRegion getLeadingGap(); // getPreviousHiddenRegion()

	ISemanticRegion getNextToken(); // getNextSemanticRegion()

	ISemanticRegion getPreviousToken(); // getPreviousSemanticRegion()

	EObject getSemanticElement();

	IHiddenRegion getTrailingGap(); // getNextHiddenRegion()
}
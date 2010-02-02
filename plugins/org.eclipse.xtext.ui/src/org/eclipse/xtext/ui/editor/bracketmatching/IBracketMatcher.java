/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.bracketmatching;

import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * Primary hook, for matching the corresponding region for a given offset.
 * 
 * Usually one should use {@link AbstractBracketMatcher}.
 */
@ImplementedBy(DefaultBracketMatcher.class)
public interface IBracketMatcher {
	
	/**
	 * @return the matching region, <code>null</code> if there's no match
	 */
	IRegion computeMatchingRegion(XtextResource state, int offset);
}

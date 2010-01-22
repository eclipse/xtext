/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.bracketmatching;


import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;

import com.google.inject.Inject;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CharacterPairMatcher implements ICharacterPairMatcher {

	public void dispose() {
	}

	public void clear() {
	}
	
	@Inject
	private IBracketMatcher bracketMatcher; 
	
	public IRegion match(IDocument iDocument, final int offset) {
		if (iDocument instanceof IXtextDocument) {
			return BracketMatchingUnitOfWork.match((IXtextDocument) iDocument, bracketMatcher, offset);
		}
		return null;
	}


	public int getAnchor() {
		return ICharacterPairMatcher.LEFT;
	}

}

/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.parser;

import org.jetbrains.annotations.NotNull;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

public interface TokenTypeProvider {

    int getAntlrType(IElementType iElementType);
    
    IElementType getIElementType(int antlrTokenType);
    
    @NotNull TokenSet getWhitespaceTokens();

	@NotNull TokenSet getCommentTokens();

	@NotNull TokenSet getStringLiteralTokens();

    public class IndexedElementType extends IElementType {
    	
    	private int localIndex;

		public IndexedElementType(String debugName, int localIndex, Language language) {
			super(debugName, language);
			this.localIndex = localIndex;
		}
		
		public int getLocalIndex() {
			return localIndex;
		}
    	
    }
}

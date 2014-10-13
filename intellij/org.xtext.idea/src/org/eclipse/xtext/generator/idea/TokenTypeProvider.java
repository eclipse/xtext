package org.eclipse.xtext.generator.idea;

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

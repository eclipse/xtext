package org.eclipse.xtext.idea.lang.parser

import com.intellij.lexer.LexerBase
import org.antlr.runtime.Lexer
import org.antlr.runtime.CommonToken
import com.google.inject.Inject
import org.eclipse.xtext.generator.idea.TokenTypeProvider
import com.intellij.psi.tree.IElementType
import org.antlr.runtime.Token

abstract class AbstractAntlrDelegatingIdeaLexer extends LexerBase {
	
	Lexer internalLexer;
    CommonToken token;

    CharSequence buffer;
    int startOffset;
    int endOffset;
    
    @Inject TokenTypeProvider tokenTypeProvider;

    override void start(CharSequence buffer, int startOffset, int endOffset, int initialState) {
        this.buffer = buffer;
        this.startOffset = startOffset;
        this.endOffset = endOffset;

        val text = buffer.subSequence(startOffset, endOffset).toString();
        internalLexer = createAntlrLexer(text);
    }
	
	def Lexer createAntlrLexer(String string)

    override int getState() {
        return if (token != null) token.getType() else 0;
    }

    override IElementType getTokenType() {
        locateToken();
        if (token == null) {
            return null;
        }
        val int type = token.getType();
        return tokenTypeProvider.getIElementType(type);
    }

    override int getTokenStart() {
        locateToken();
        return startOffset + token.getStartIndex();
    }

    override int getTokenEnd() {
        locateToken();
        return startOffset + token.getStopIndex() + 1;
    }

    override void advance() {
        locateToken();
        token = null;
    }

    override CharSequence getBufferSequence() {
        return buffer;
    }

    override int getBufferEnd() {
        return endOffset;
    }

    def void locateToken() {
        if (token == null) {
            try {
                token = internalLexer.nextToken() as CommonToken;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (token == Token.EOF_TOKEN) {
                token = null;
            }
        }
    }
}
/*
Generated with Xtext
 */
package org.eclipse.xtext.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.impl.ParseError;
import org.eclipse.xtext.parser.internal.InternalXtextLexer;
import org.eclipse.xtext.parser.internal.InternalXtextParser;

public class XtextParser extends org.eclipse.xtext.parser.AbstractParser {

    @Override
    protected IParseResult parse(String ruleName, ANTLRInputStream in, IElementFactory factory, final IParseErrorHandler handler) {
        InternalXtextLexer lexer = new InternalXtextLexer(in);
        XtextTokenStream stream = new XtextTokenStream(lexer);
        InternalXtextParser parser = new InternalXtextParser(stream, factory, grammarAccess.getGrammar()) {
            @Override
            protected void reportError(IParseError error, RecognitionException re) {
                handler.handleParserError(error);
            }
        };
        try {
            return parser.parse(ruleName);
        } catch (Exception re) {
            CommonToken lt = (CommonToken) parser.getInput().LT(parser.getInput().index());
            ParseError error = new ParseError(lt.getLine(), lt.getStartIndex(), lt.getText() != null ? lt.getText().length() : 0, lt
                    .getText(), re.getMessage(), re);
            handler.handleParserError(error);
        }
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.xtext.parser.AbstractParser#getDefaultRuleName()
     */
    @Override
    protected String getDefaultRuleName() {
        return "Grammar";
    }

}

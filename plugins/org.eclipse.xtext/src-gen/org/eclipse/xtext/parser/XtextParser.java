/*
Generated with Xtext
 */
package org.eclipse.xtext.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.internal.InternalXtextLexer;
import org.eclipse.xtext.parser.internal.InternalXtextParser;

public class XtextParser extends org.eclipse.xtext.parser.AbstractParser {

    @Override
    protected IParseResult parse(String ruleName, ANTLRInputStream in, IElementFactory factory) {
        InternalXtextLexer lexer = new InternalXtextLexer(in);
        XtextTokenStream stream = new XtextTokenStream(lexer);
        InternalXtextParser parser = new InternalXtextParser(stream, factory, grammarAccess.getGrammar());
        try {
            return parser.parse(ruleName);
        } catch (Exception re) {
            throw new ParseException(re.getMessage(), re);
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.xtext.parser.AbstractParser#getDefaultRuleName()
     */
    @Override
    protected String getDefaultRuleName() {
        return "Grammar";
    }

}

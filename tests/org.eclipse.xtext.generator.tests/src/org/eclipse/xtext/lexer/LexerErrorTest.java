package org.eclipse.xtext.lexer;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.apache.log4j.Logger;
import org.eclipse.xtext.testlanguages.parser.internal.InternalSimpleExpressionsTestLanguageLexer;

public class LexerErrorTest extends TestCase {

    private static final Logger logger = Logger.getLogger(LexerErrorTest.class);
	
	public void testLexerError() throws Exception {
        String model = "a /* uncomplete comment *";
        InternalSimpleExpressionsTestLanguageLexer lexer = new InternalSimpleExpressionsTestLanguageLexer();
        lexer.setCharStream(new ANTLRStringStream(model));
        CommonTokenStream stream = new CommonTokenStream(lexer);
        for(Object token : stream.getTokens()) {
            logger.debug(token);
        }
    }
}

package org.eclipse.xtext.lexer;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.xtext.testlanguages.parser.internal.InternalSimpleExpressionsLexer;

public class LexerErrorTest extends TestCase {

    public void testLexerError() throws Exception {
        String model = "a /* uncomplete comment *";
        InternalSimpleExpressionsLexer lexer = new InternalSimpleExpressionsLexer();
        lexer.setCharStream(new ANTLRStringStream(model));
        CommonTokenStream stream = new CommonTokenStream(lexer);
        for(Object token : stream.getTokens()) {
            System.out.println(token);
        }
    }
}

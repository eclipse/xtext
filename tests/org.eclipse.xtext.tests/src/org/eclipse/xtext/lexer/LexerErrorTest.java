/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.lexer;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.apache.log4j.Logger;
import org.eclipse.xtext.testlanguages.parser.antlr.internal.InternalSimpleExpressionsTestLanguageLexer;
import org.junit.Assert;
import org.junit.Test;

public class LexerErrorTest extends Assert {

    private static final Logger logger = Logger.getLogger(LexerErrorTest.class);
	
	@Test public void testLexerError() throws Exception {
        String model = "a /* uncomplete comment *";
        InternalSimpleExpressionsTestLanguageLexer lexer = new InternalSimpleExpressionsTestLanguageLexer();
        lexer.setCharStream(new ANTLRStringStream(model));
        CommonTokenStream stream = new CommonTokenStream(lexer);
        for(Object token : stream.getTokens()) {
            logger.debug(token);
        }
    }
}

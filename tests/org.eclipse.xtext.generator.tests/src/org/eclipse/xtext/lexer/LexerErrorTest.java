/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.lexer;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.xtext.testlanguages.parser.internal.InternalSimpleExpressionsLexer;

/**
 * 
 * @author Sven Efftinge - Initial contribution and API
 *
 */
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

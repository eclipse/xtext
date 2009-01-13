/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.parser.AbstractParser;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractAntlrParser extends AbstractParser {

	public IParseResult parse(String ruleName, InputStream in, IAstFactory factory) {
        try {
            IParseResult parseResult = (IParseResult) parse(ruleName, new ANTLRInputStream(in), factory);
            return parseResult;
        } catch (IOException e) {
            throw new WrappedException(e);
        }
    }
	
	protected abstract IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory);
}

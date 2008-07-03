/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.parser.impl.PartialParsingUtil;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.service.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public abstract class AbstractParser implements IParser {

    @Inject
    private IAstFactory astElementFactory;

    @Inject
    protected IGrammarAccess grammarAccess;

    public IParseResult parse(String ruleName, InputStream in, IAstFactory factory) {
        try {
            IParseResult parseResult = (IParseResult) parse(ruleName, new ANTLRInputStream(in), factory);
            return parseResult;
        } catch (IOException e) {
            throw new WrappedException(e);
        }
    }

    public IParseResult parse(InputStream in, IAstFactory factory) {
        return parse(getDefaultRuleName(), in, factory);
    }

    public IParseResult parse(InputStream in) {
        return parse(getDefaultRuleName(), in, getDefaultASTFactory());
    }

    public IParseResult reparse(CompositeNode originalRootNode, int offset, int length, String change) {
    	return PartialParsingUtil.reparse(this, originalRootNode, offset, length, change);
    }

    public IParseResult parse(String ruleName, InputStream in) {
        return parse(ruleName, in, getDefaultASTFactory());
    }
    
    protected IAstFactory getDefaultASTFactory() {
        return astElementFactory;
    }

    protected abstract String getDefaultRuleName();

    protected abstract IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory);
}

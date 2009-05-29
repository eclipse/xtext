/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.SyntaxError;

/**
 * The result of a parsing operation.
 * 
 * @author Jan Köhnlein
 */
public class ParseResult implements IParseResult {

    private EObject rootAstElement;
    private CompositeNode rootNode;
    
    public ParseResult(EObject rootAstElement, CompositeNode rootNode) {
        this.rootAstElement = rootAstElement;
        this.rootNode = rootNode;
    }
    
    public ParseResult() {
    }

    public void setRootASTElement(EObject rootAstElement) {
        this.rootAstElement = rootAstElement;
    }

    public void setRootNode(CompositeNode rootNode) {
        this.rootNode = rootNode;
    }

    public EObject getRootASTElement() {
        return rootAstElement;
    }

    public CompositeNode getRootNode() {
        return rootNode;
    }

	public List<SyntaxError> getParseErrors() {
		//TODO performance?
		return rootNode != null ? rootNode.allSyntaxErrors() : Collections.<SyntaxError>emptyList();
	}
    
}

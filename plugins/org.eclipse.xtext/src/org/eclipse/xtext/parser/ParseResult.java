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
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.SyntaxError;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * The result of a parsing operation.
 * 
 * @author Jan Köhnlein
 */
public class ParseResult implements IParseResult {

    private EObject rootAstElement;
    private CompositeNode rootNode;
    private ICompositeNode rootNode2;
    
    public ParseResult(EObject rootAstElement, CompositeNode rootNode, ICompositeNode rootNode2) {
        this.rootAstElement = rootAstElement;
        this.rootNode = rootNode;
        this.rootNode2 = rootNode2;
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

    @Deprecated
	public CompositeNode getRootNode() {
        return rootNode;
    }

	@Deprecated
	public List<AbstractNode> getParseErrors() {
		List<SyntaxError> result = rootNode != null ? rootNode.allSyntaxErrors() : Collections.<SyntaxError>emptyList();
		return Lists.transform(result, new Function<SyntaxError, AbstractNode>() {

			public AbstractNode apply(SyntaxError from) {
				return from.getNode();
			}
			
		});
	}
	
	public Iterable<INode> getParseErrors2() {
		if (rootNode2 == null)
			return Collections.emptyList();
		return Iterables.filter(rootNode2, new Predicate<INode>() {
			public boolean apply(INode input) {
				return input.getSyntaxErrorMessage() != null;
			}
		});
	}
	
	public ICompositeNode getRootNode2() {
		return rootNode2;
	}
    
}

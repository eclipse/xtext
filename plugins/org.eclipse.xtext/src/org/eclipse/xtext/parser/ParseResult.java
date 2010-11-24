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
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.CompositeNode;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 * The result of a parsing operation.
 * 
 * @author Jan Köhnlein
 */
public class ParseResult implements IParseResult {

    private EObject rootAstElement;
    private ICompositeNode rootNode;
	private final boolean hasErrors;
    
    public ParseResult(EObject rootAstElement, ICompositeNode rootNode, boolean hasErrors) {
        this.rootAstElement = rootAstElement;
        this.rootNode = rootNode;
		this.hasErrors = hasErrors;
    }
    
    public void setRootASTElement(EObject rootAstElement) {
        this.rootAstElement = rootAstElement;
    }

    public EObject getRootASTElement() {
        return rootAstElement;
    }

	public Iterable<INode> getSyntaxErrors() {
		if (rootNode == null || !hasSyntaxErrors())
			return Collections.emptyList();
		return new Iterable<INode>() {
			public Iterator<INode> iterator() {
				// TODO: organize imports
				return Iterators.filter(Iterators.filter(
						((org.eclipse.xtext.nodemodel.impl.CompositeNode) rootNode).basicTreeIterator(), INode.class),
						new Predicate<INode>() {
					public boolean apply(INode input) {
						return input.getSyntaxErrorMessage() != null;
					}
				});
			}
		};
	}
	
	public ICompositeNode getRootNode() {
		return rootNode;
	}
    
	public void setRootNode2(ICompositeNode rootNode2) {
		this.rootNode = rootNode2;
	}

	public boolean hasSyntaxErrors() {
		return hasErrors;
	}
}

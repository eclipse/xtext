/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;

import com.google.common.base.Preconditions;
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
    
    public ParseResult(/* @Nullable */ EObject rootAstElement, /* @NonNull */ ICompositeNode rootNode, boolean hasErrors) {
    	Preconditions.checkNotNull(rootNode);
        this.rootAstElement = rootAstElement;
        this.rootNode = rootNode;
		this.hasErrors = hasErrors;
    }
    
    public void setRootASTElement(/* @Nullable */ EObject rootAstElement) {
        this.rootAstElement = rootAstElement;
    }

    /* @Nullable */
    @Override
	public EObject getRootASTElement() {
        return rootAstElement;
    }

    /* @NonNull */
	@Override
	public Iterable<INode> getSyntaxErrors() {
		if (rootNode == null || !hasSyntaxErrors())
			return Collections.emptyList();
		return new Iterable<INode>() {
			@Override
			@SuppressWarnings("unchecked")
			public Iterator<INode> iterator() {
				Iterator<? extends INode> result = Iterators.filter(((CompositeNode) rootNode).basicIterator(),
						new Predicate<AbstractNode>() {
					@Override
					public boolean apply(AbstractNode input) {
						return input.getSyntaxErrorMessage() != null;
					}
				});
				return (Iterator<INode>) result;
			}
		};
	}
	
    /* @NonNull */
	@Override
	public ICompositeNode getRootNode() {
		return rootNode;
	}
    
	public void setRootNode(/* @NonNull */ ICompositeNode rootNode) {
		Preconditions.checkNotNull(rootNode);
		this.rootNode = rootNode;
	}

	@Override
	public boolean hasSyntaxErrors() {
		return hasErrors;
	}
}

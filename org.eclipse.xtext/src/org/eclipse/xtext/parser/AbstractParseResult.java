/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 * @since 2.35
 */
public abstract class AbstractParseResult implements IParseResult {
	private EObject rootAstElement;
	private boolean hasErrors;
    
    protected AbstractParseResult(/* @Nullable */ EObject rootAstElement, boolean hasErrors) {
        this.rootAstElement = rootAstElement;
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
		ICompositeNode rootNode = getRootNode();
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
	
	@Override
	public boolean hasSyntaxErrors() {
		return hasErrors;
	}
	
	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}
	
	public abstract void setRootNode(/* @NonNull */ ICompositeNode rootNode);
	
}

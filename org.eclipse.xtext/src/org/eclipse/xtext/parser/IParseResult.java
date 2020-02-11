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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * Represents the result of the parsing. 
 * Via the ParseResult the semantic root AST element,
 * the root node model element and the list of syntax errors can be retrieved.
 */
public interface IParseResult {

	/* @Nullable */
    EObject getRootASTElement();

	/* @NonNull */
    ICompositeNode getRootNode();
    
    /* @NonNull */
    Iterable<INode> getSyntaxErrors();
    
    boolean hasSyntaxErrors();
}

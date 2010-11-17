/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface INode extends TreeIterable<INode> {

	int ROOT = 1 << 0;
	int COMPOSITE = 1 << 1;
	int LEAF = 1 << 2;
	int SYNTAX_ERROR = 1 << 3;
	int SEMANTIC_MODEL_REFERENCE = 1 << 4;
	int HIDDEN = 1 << 5;
	int SYNTHETIC_COMPOSITE = 1 << 6;

	ICompositeNode getParent();

	int getTotalOffset();

	int getTotalLength();

	String getText();

	EObject getGrammarElement();

	SyntaxErrorMessage getSyntaxErrorMessage();

	int getNodeType();

}

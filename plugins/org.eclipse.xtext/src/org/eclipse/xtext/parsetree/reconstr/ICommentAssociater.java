/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultCommentAssociater;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(DefaultCommentAssociater.class)
public interface ICommentAssociater {

	public Map<LeafNode, EObject> associateCommentsWithSemanticEObjects(EObject model, Set<CompositeNode> roots);

	//	public void arrangeCommentsForEObject(EObject context, List<CommentOrSemanticToken> tokens);

	//	public interface CommentOrSemanticToken {
	//		public AbstractNode getNode();
	//	}
	//
	//	public interface SemanticToken extends CommentOrSemanticToken {
	//		AbstractElement getGrammarElement();
	//
	//		Object getValue();
	//	}
	//
	//	public interface CommentToken extends CommentOrSemanticToken {
	//
	//	}

}

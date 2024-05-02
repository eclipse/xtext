/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.InternalNodeModelUtils;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.impl.LeafNodeWithSyntaxError;
import org.eclipse.xtext.nodemodel.impl.RootNode;

public class NodeModelAccessForTests extends InternalNodeModelUtils {

	public static void basicSetCompleteContent(RootNode node, String content) {
		InternalNodeModelUtils.basicSetCompleteContent(node, content);
	}
	
	public static void basicSetGrammarElement(AbstractNode node, EObject grammarElement) {
		InternalNodeModelUtils.basicSetGrammarElement(node, grammarElement);
	}
	
	public static void basicSetGrammarElement(AbstractNode node, EObject[] grammarElementArray) {
		InternalNodeModelUtils.basicSetGrammarElement(node, grammarElementArray);
	}
	
	public static void basicSetSyntaxErrorMessage(LeafNodeWithSyntaxError leafNode, SyntaxErrorMessage errorMessage) {
		InternalNodeModelUtils.basicSetSyntaxErrorMessage(leafNode, errorMessage);
	}
	
	public static void basicSetTotalRegion(LeafNode leaf, int offset, int length) {
		InternalNodeModelUtils.basicSetTotalRegion(leaf, offset, length);
	}
	
	public static AbstractNode basicGetNextSibling(AbstractNode node) {
		return InternalNodeModelUtils.basicGetNextSibling(node);
	}
	
	public static AbstractNode basicGetPreviousSibling(AbstractNode node) {
		return InternalNodeModelUtils.basicGetPreviousSibling(node);
	}
	
	public static AbstractNode basicGetFirstChild(CompositeNode node) {
		return InternalNodeModelUtils.basicGetFirstChild(node);
	}
	
	public static AbstractNode basicGetLastChild(CompositeNode node) {
		return InternalNodeModelUtils.basicGetLastChild(node);
	}
}

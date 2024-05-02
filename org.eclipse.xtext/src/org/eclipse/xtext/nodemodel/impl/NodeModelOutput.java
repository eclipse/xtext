/*******************************************************************************
 * Copyright (c) Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

/**
 * Encapsulates serialization logic for the node model.
 * 
 * @since 2.35
 */
public interface NodeModelOutput {
	
	default void writeNode(AbstractNode node) throws IOException {
		writeNode(node, node.getNodeId().ordinal());
	}
	
	default void writeNode(AbstractNode node, int type) throws IOException {
		writeCompressedInt(type);
		node.writeContent(this);
	}

	void writeGrammarElement(Object grammarElementOrArray) throws IOException;

	void writeSemanticObject(EObject semanticElement) throws IOException;
	
	void writeSyntaxErrorMessage(SyntaxErrorMessage syntaxErrorMessage) throws IOException;
	
	void writeCompressedInt(int value) throws IOException;
	
	void writeContent(String content) throws IOException;
	
	default void writeLength(int value) throws IOException {
		writeCompressedInt(value);
	}
	
}

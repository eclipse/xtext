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
import org.eclipse.xtext.nodemodel.impl.AbstractNode.NodeType;

/**
 * Encapsulates deserialization logic for the node model.
 * 
 * @since 2.35
 */
public interface NodeModelInput {

	default AbstractNode readNode() throws IOException {
		return readNode(readCompressedInt());
	}
	
	default AbstractNode readNode(int type) throws IOException {
		AbstractNode node = NodeType.fromOrdinal(type);
		if (node != null) {
			node.readContent(this);
		}
		return node;
	}

	Object readGrammarElement() throws IOException;

	EObject readSemanticObject() throws IOException;

	SyntaxErrorMessage readSyntaxErrorMessage() throws IOException;

	int readCompressedInt() throws IOException;

	String readContent() throws IOException;
	
	int readLength() throws IOException;

	int currentOffset();


}

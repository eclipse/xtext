/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.detachable;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

/**
 * @since 2.35
 */
public class NodeModelData {

	private final byte[] bytes;
	private final List<EObject> semanticObjects;
	private final List<SyntaxErrorMessage> syntaxErrors;
	private final List<ArrayReference> grammarElementArrays;

	public NodeModelData(byte[] bytes, List<EObject> semanticObjects,
			List<SyntaxErrorMessage> syntaxErrors, List<ArrayReference> grammarElementArrays) {
		super();
		this.bytes = bytes;
		this.semanticObjects = semanticObjects;
		this.syntaxErrors = syntaxErrors;
		this.grammarElementArrays = grammarElementArrays;
	}

	public byte[] getBytes() {
		return bytes;
	}
	
	public List<EObject> getSemanticObjects() {
		return semanticObjects;
	}
	
	public List<ArrayReference> getGrammarElementArrays() {
		return grammarElementArrays;
	}
	
	public List<SyntaxErrorMessage> getSyntaxErrors() {
		return syntaxErrors;
	}

	@Override
	public String toString() {
		return "NodeModelData [bytes=" + bytes.length + ", semanticObjects=" + semanticObjects.size()
				+ ", syntaxErrors=" + syntaxErrors.size() + ", grammarElementArrays=" + grammarElementArrays.size() + "]";
	}
	
}

/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.detachable;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectInputStream;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.NodeModelInput;
import org.eclipse.xtext.util.Strings;

/**
 * @since 2.35
 */
public class CompactStoredNodeModelReader extends EObjectInputStream implements NodeModelInput {

	private final Tabulated<ArrayReference> grammarElementArrays;
	private final Tabulated<EObject> semanticObjects;
	private final Tabulated<SyntaxErrorMessage> syntaxErrorMessages;
	private final DetachableNodeModelBuilder nodeModelBuilder;
	private final String content;
	private final GrammarElementLookup grammarElements;
	private int offset;
	
	public CompactStoredNodeModelReader(InputStream inputStream, String content, Tabulated<EObject> semanticObjects, DetachableNodeModelBuilder nodeModelBuilder, GrammarElementLookup grammarElements) throws IOException {
		super(inputStream, Collections.singletonMap(BinaryResourceImpl.OPTION_INTERNAL_BUFFER_CAPACITY, 8192));

		this.content = content;
		this.semanticObjects = semanticObjects;
		this.nodeModelBuilder = nodeModelBuilder;
		this.grammarElements = grammarElements;
		this.syntaxErrorMessages = new Tabulated<>();
		this.grammarElementArrays = new Tabulated<>();
	}
	
	@Override
	public AbstractNode readNode(int type) throws IOException {
		AbstractNode result = NodeModelInput.super.readNode(type);
		if (result instanceof CompositeNodeWithSemanticElement && result.hasDirectSemanticElement()) {
			nodeModelBuilder.associateWithSemanticElement((ICompositeNode) result, result.getSemanticElement());
		}
		return result;
	}
	
	@Override
	protected void readSignature() throws IOException {
		// no signature
	}
	
	@Override
	public int readLength() throws IOException {
		int result = readCompressedInt();
		offset += result;
		return result;
	}
	
	@Override
	public int currentOffset() {
		return offset;
	}
	
	@Override
	public Object readGrammarElement() throws IOException {
		int id = readCompressedInt();
		if (id == -1) {
			return null;
		}
		if (id >= grammarElements.size()) {
			id -= grammarElements.size();
			EObject[] array;
			if (id == grammarElementArrays.size()) {
				int len = readCompressedInt();
				array = new EObject[len];
				for(int i = 0; i < len; i++) {
					array[i] = grammarElements.getGrammarElement(readCompressedInt());
				}
				grammarElementArrays.getId(new ArrayReference(array));
			} else {
				array = grammarElementArrays.getObject(id).getArray();
			}
			return array;
		}
		return grammarElements.getGrammarElement(id);
	}
	
	@Override
	public EObject readSemanticObject() throws IOException {
		int id = readCompressedInt();
		if (id == -1) {
			return null;
		}
		return semanticObjects.getObject(id);
	}

	@Override
	public SyntaxErrorMessage readSyntaxErrorMessage() throws IOException {
		int id = readCompressedInt();
		if (id == -1) {
			return null;
		}
		if (id == syntaxErrorMessages.size()) {
			String issueCode = readSegmentedString();
			String message = readSegmentedString();
			int issueDataLen = readCompressedInt();
			String[] issueData;
			if (issueDataLen == -1) {
				issueData = null;
			} else if (issueDataLen == 0) {
				issueData = Strings.EMPTY_ARRAY;
			} else {
				issueData = new String[issueDataLen];
				for (int i = 0; i < issueDataLen; i++) {
					issueData[i] = readSegmentedString();
				}
			}
			SyntaxErrorMessage result = new SyntaxErrorMessage(message, issueCode, issueData);
			syntaxErrorMessages.getId(result);
			return result;
		}
		return syntaxErrorMessages.getObject(id);
	}
	
	protected boolean hasErrors() {
		return syntaxErrorMessages.size() > 0;
	}
	
	@Override
	public String readContent() throws IOException {
		return content;
	}

}



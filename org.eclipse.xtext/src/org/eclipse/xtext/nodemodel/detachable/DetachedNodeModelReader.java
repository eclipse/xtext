/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.detachable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectInputStream;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.NodeModelInput;
import org.eclipse.xtext.nodemodel.impl.RootNode;

/**
 * @since 2.35
 */
public class DetachedNodeModelReader extends EObjectInputStream implements NodeModelInput {

	private final List<ArrayReference> grammarElementArrays;
	private final List<EObject> semanticObjects;
	private final List<SyntaxErrorMessage> syntaxErrorMessages;
	private GrammarElementLookup grammarElements;
	private int offset;
	private Tabulated<INode> externalReferences;
	private Map<EObject, CompositeNodeWithSemanticElement> associations;
	
	public DetachedNodeModelReader(NodeModelData nodeModelData) throws IOException {
		super(new GZIPInputStream(new ByteArrayInputStream(nodeModelData.getBytes())), Collections.singletonMap(BinaryResourceImpl.OPTION_INTERNAL_BUFFER_CAPACITY, 8192));

		this.syntaxErrorMessages = nodeModelData.getSyntaxErrors();
		this.grammarElementArrays = nodeModelData.getGrammarElementArrays();
		this.semanticObjects = nodeModelData.getSemanticObjects();
	}
	
	public StandardNodeModelReference deserialize(DetachableParseResult target) throws IOException {
		externalReferences = new Tabulated<>(readCompressedInt());
		associations = new HashMap<>();
		this.grammarElements = target.getGrammarElementLookup();
		RootNode rootNode = (RootNode) readNode();
		return new StandardNodeModelReference(target, rootNode, associations, externalReferences);
	}
	
	@Override
	public AbstractNode readNode(int type) throws IOException {
		if (type == -1) {
			return null;
		}
		boolean hasExternalId = (type & 1) == 1;
		AbstractNode result = NodeModelInput.super.readNode(type >>> 1);
		if (hasExternalId) {
			externalReferences.set(result, readCompressedInt());
		}
		if (result instanceof CompositeNodeWithSemanticElement && result.hasDirectSemanticElement()) {
			associations.put(result.getSemanticElement(), (CompositeNodeWithSemanticElement) result);
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
			return grammarElementArrays.get(id - grammarElements.size()).getArray();
		}
		return grammarElements.getGrammarElement(id);
	}
	
	@Override
	public EObject readSemanticObject() throws IOException {
		int id = readCompressedInt();
		if (id == -1) {
			return null;
		}
		return semanticObjects.get(id);
	}

	@Override
	public SyntaxErrorMessage readSyntaxErrorMessage() throws IOException {
		int id = readCompressedInt();
		if (id == -1) {
			return null;
		}
		return syntaxErrorMessages.get(id);
	}
	
	@Override
	public String readContent() throws IOException {
		return readSegmentedString();
	}

}



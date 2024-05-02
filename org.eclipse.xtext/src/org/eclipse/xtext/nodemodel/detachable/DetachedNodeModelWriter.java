/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.detachable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.zip.GZIPOutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectOutputStream;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.NodeModelOutput;

/**
 * @since 2.35
 */
public class DetachedNodeModelWriter extends EObjectOutputStream implements NodeModelOutput {

	private final Tabulated<ArrayReference> grammarElementArrays;
	private final Tabulated<EObject> semanticObjects;
	private final Tabulated<SyntaxErrorMessage> syntaxErrorMessages;
	private final GrammarElementLookup grammarElements;
	private final ByteArrayOutputStream bout;
	
	private Tabulated<INode> externalReferences;
	
	public DetachedNodeModelWriter(GrammarElementLookup grammarElements) throws IOException {
		this(new ByteArrayOutputStream(), grammarElements);
	}
	
	public DetachedNodeModelWriter(ByteArrayOutputStream bout, GrammarElementLookup grammarElements) throws IOException {
		super(new GZIPOutputStream(bout, true), Collections.singletonMap(BinaryResourceImpl.OPTION_INTERNAL_BUFFER_CAPACITY, 8192),
				Version.VERSION_1_1, STYLE_DATA_CONVERTER);

		this.grammarElements = grammarElements;
		this.syntaxErrorMessages = new Tabulated<>();
		this.grammarElementArrays = new Tabulated<>();
		this.semanticObjects = new Tabulated<>();
		this.bout = bout;
	}
	
	public NodeModelData serialize(StandardNodeModelReference standard) throws IOException {
		this.externalReferences = standard.externalReferences;
		writeCompressedInt(externalReferences.size());
		writeNode(standard.rootNode);
		flush();
		outputStream.close();
		return new NodeModelData(
				bout.toByteArray(),
				semanticObjects.getObjects(), 
				syntaxErrorMessages.getObjects(), 
				grammarElementArrays.getObjects());
	}
	
	@Override
	protected void writeSignature() throws IOException {
		// don'T write a signature
	}
	
	@Override
	public void writeNode(AbstractNode node, int type) throws IOException {
		type <<= 1;
		int externalId = externalReferences.tryGetId(node);
		if (externalId != -1) {
			type |= 1;
		}
		NodeModelOutput.super.writeNode(node, type);
		if (externalId != -1) {
			writeCompressedInt(externalId);
		}
	}

	@Override
	public void writeGrammarElement(Object grammarElementOrArray) throws IOException {
		if (grammarElementOrArray != null) {
			if (grammarElementOrArray instanceof EObject) {
				writeCompressedInt(grammarElements.getId((EObject) grammarElementOrArray));
			} else {
				writeCompressedInt(grammarElements.size() + grammarElementArrays.getId(new ArrayReference((EObject[]) grammarElementOrArray)));
			}
 		} else {
 			writeCompressedInt(-1);
 		}
	}

	@Override
	public void writeSemanticObject(EObject semanticElement) throws IOException {
		if (semanticElement != null) {
			writeCompressedInt(semanticObjects.getId(semanticElement));
		} else {
			writeCompressedInt(-1);
		}
	}

	@Override
	public void writeSyntaxErrorMessage(SyntaxErrorMessage syntaxErrorMessage) throws IOException {
		if (syntaxErrorMessage != null) {
			writeCompressedInt(syntaxErrorMessages.getId(syntaxErrorMessage));
		} else {
			writeCompressedInt(-1);
		}
	}

	@Override
	public void writeContent(String value) throws IOException {
		writeSegmentedString(value);
	}
	
}



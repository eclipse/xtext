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
import java.io.OutputStream;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectOutputStream;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.impl.NodeModelOutput;

/**
 * @since 2.35
 */
public class CompactStoredNodeModelWriter extends EObjectOutputStream implements NodeModelOutput {

	private final Tabulated<ArrayReference> grammarElementArrays;
	private final Tabulated<EObject> semanticObjects;
	private final Tabulated<SyntaxErrorMessage> syntaxErrorMessages;
	private final GrammarElementLookup grammarElements;
	
	public CompactStoredNodeModelWriter(OutputStream out, Tabulated<EObject> semanticObjects, GrammarElementLookup grammarElements) throws IOException {
		super(out, Collections.singletonMap(BinaryResourceImpl.OPTION_INTERNAL_BUFFER_CAPACITY, 8192),
				Version.VERSION_1_1, STYLE_DATA_CONVERTER);

		this.grammarElements = grammarElements;
		this.syntaxErrorMessages = new Tabulated<>();
		this.grammarElementArrays = new Tabulated<>();
		this.semanticObjects = semanticObjects;
	}
	
	@Override
	protected void writeSignature() throws IOException {
		// don'T write a signature
	}
	
	@Override
	public void writeGrammarElement(Object grammarElementOrArray) throws IOException {
		if (grammarElementOrArray != null) {
			if (grammarElementOrArray instanceof EObject) {
				writeCompressedInt(grammarElements.getId((EObject) grammarElementOrArray));
			} else {
				int prevSize = grammarElementArrays.size();
				EObject[] array = (EObject[]) grammarElementOrArray;
				int arrayId = grammarElementArrays.getId(new ArrayReference(array));
				writeCompressedInt(grammarElements.size() + arrayId);
				if (prevSize == arrayId) {
					writeCompressedInt(array.length);
					for(EObject element: array) {
						writeCompressedInt(grammarElements.getId(element));		
					}
				}
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
			int prevSize = syntaxErrorMessages.size();
			int messageId = syntaxErrorMessages.getId(syntaxErrorMessage);
			writeCompressedInt(messageId);
			if (prevSize == messageId) {
				writeSegmentedString(syntaxErrorMessage.getIssueCode());
				writeSegmentedString(syntaxErrorMessage.getMessage());
				String[] issueData = syntaxErrorMessage.getIssueData();
				if (issueData == null) {
					writeCompressedInt(-1);
				} else {
					writeCompressedInt(issueData.length);
					for(String s: issueData) {
						writeSegmentedString(s);
					}
				}
			}
		} else {
			writeCompressedInt(-1);
		}
	}

	@Override
	public void writeContent(String value) throws IOException {
		// skip since it is loaded from disk
	}
}



/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.xtext.nodemodel.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.serialization.DeserializationConversionContext;
import org.eclipse.xtext.nodemodel.serialization.SerializationConversionContext;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Mark Christiaens - Initial contribution
 * 
 * @since 2.3
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noextend This class is not intended to be subclassed by clients.
 */
public class SerializableNodeModel {
	public int formatVersion;
	public Date date;
	public RootNode root;

	public SerializableNodeModel(XtextResource resource) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			ICompositeNode rootNode = parseResult.getRootNode();
			root = (RootNode) rootNode;
		}
		formatVersion = 1;
		date = new Date();
	}

	public SerializableNodeModel() {
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void writeObjectData(DataOutputStream out, SerializationConversionContext scc) throws IOException {
		String[] grammarIdToURIMap = scc.getGrammarIdToURIMap();

		out.writeInt(grammarIdToURIMap.length);
		for (String string : grammarIdToURIMap) {
			out.writeUTF(string);
		}

		root.write(out, scc);
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void readObjectData(DataInputStream in, DeserializationConversionContext context) throws IOException {
		int grammarIdToURIMapLength = in.readInt();

		String[] grammarIdToURIMap = new String[grammarIdToURIMapLength];
		for (int i = 0; i < grammarIdToURIMapLength; ++i) {
			grammarIdToURIMap[i] = in.readUTF();
			if (grammarIdToURIMap[i] == null) {
				throw new IllegalStateException("During deserialzing the grammar id to URI map got a null reference. ");
			}
		}

		context.setGrammarIdToURIMap(grammarIdToURIMap);

		root = new RootNode();
		root.readData(in, context);
	}
}

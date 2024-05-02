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
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.nodemodel.impl.RootNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.io.CharStreams;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @since 2.35
 */
public class StorageAwareDetachableParseResultWrapper extends DetachableParseResultWrapper {

	private static final Logger LOG = Logger.getLogger(DetachableParseResultWrapper.class);

	@Inject
	protected Provider<NodeModelBuilder> nodeModelBuilder;
	
	@Inject
	protected GrammarElementLookup grammarElementLookup;
	
	@Override
	public boolean customWriteNodeModel(XtextResource resource, OutputStream outputStream) throws IOException {
		IParseResult parseResult = resource.getParseResult();
		EObject rootElement = parseResult.getRootASTElement();
		Tabulated<EObject> semanticObjects = semanticObjectIndex(rootElement);
		CompactStoredNodeModelWriter writer = new CompactStoredNodeModelWriter(outputStream, semanticObjects, grammarElementLookup);
		RootNode rootNode = (RootNode) parseResult.getRootNode();
		writer.writeNode(rootNode);
		writer.flush();
		return true;
	}

	protected Tabulated<EObject> semanticObjectIndex(EObject rootElement) {
		Tabulated<EObject> semanticObjects = new Tabulated<>();
		TreeIterator<EObject> iterator = EcoreUtil2.eAll(rootElement);
		while(iterator.hasNext()) {
			semanticObjects.getId(iterator.next());
		}
		return semanticObjects;
	}
	
	@Override
	public boolean customReadNodeModel(XtextResource resource, InputStream inputStream) throws IOException {
		// if this is a synthetic resource (i.e. tests or so, don't load the node model)
		URIConverter uriConverter = resource.getResourceSet().getURIConverter();
		URI uri = resource.getURI();
		if (!uriConverter.exists(uri, resource.getResourceSet().getLoadOptions())) {
			LOG.info("Skipping loading node model for synthetic resource " + uri);
			return false;
		}
		try (InputStreamReader reader = new InputStreamReader(uriConverter.createInputStream(uri), resource.getEncoding())) {
			String completeContent = CharStreams.toString(reader);
			
			DetachableNodeModelBuilder builder = (DetachableNodeModelBuilder) nodeModelBuilder.get();
			EObject semanticRoot = resource.getContents().get(0);
			Tabulated<EObject> semanticObjects = semanticObjectIndex(semanticRoot);
			CompactStoredNodeModelReader nodeModelReader = new CompactStoredNodeModelReader(inputStream, completeContent, semanticObjects, builder, grammarElementLookup);
			RootNode rootNode = (RootNode) nodeModelReader.readNode();
			IParseResult parseResult = builder.createParseResult(semanticRoot, rootNode, nodeModelReader.hasErrors());
			resource.setParseResult(parseResult);
		}
		return true;
	}
}

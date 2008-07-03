/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeContentAdapter;
import org.eclipse.xtext.service.Inject;

/**
 * An EMF resource that reads and writes models of an Xtext DSL.
 * 
 * @author Jan Köhnlein
 */
public class XtextResource extends ResourceImpl {
	@Inject
	private IParser parser;

	@Inject
	private IAstFactory elementFactory;

	@Inject
	private IParseTreeConstructor parsetreeConstructor;

	private IParseResult parseResult;

	public XtextResource(URI uri) {
		super(uri);
	}

	public IParseResult getParseResult() {
		return parseResult;
	}

	public void update(int offset, String change) {
		CompositeNode rootNode = parseResult.getRootNode();
		int length = change.length();
		int documentGrowth = length - rootNode.length();
		int originalLength = length - documentGrowth;
		
		// unloading is required to ensure that any EObjects hanging around (e.g. in the outline) get a proxied URI
		// and thus still can be compared by their URI
		unload();
		
		parseResult = parser.reparse(rootNode, offset, originalLength, change);
		getContents().clear();
		getContents().add(parseResult.getRootASTElement());
		if (parseResult != null && parseResult.getRootNode() != rootNode) {
			addNodeContentAdapter();
		}
	}
	
	private void addNodeContentAdapter() {
		parseResult.getRootNode().eAdapters().add(new NodeContentAdapter());
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		getContents().clear();
		parseResult = parser.parse(inputStream, elementFactory);
		if (parseResult != null) {
			EObject rootElement = parseResult.getRootASTElement();
			if (rootElement != null) {
				getContents().add(rootElement);
			}
			addNodeContentAdapter();
		}
	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (contents.size() > 1) {
			throw new IllegalStateException("Xtext resource cannot contain multiple root elements");
		}
		if (!contents.isEmpty()) {
			EObject rootElement = contents.get(0);
			parsetreeConstructor.update(rootElement);
			NodeAdapter rootNodeAdapter = getNodeAdapter(rootElement);
			if (rootNodeAdapter != null) {
				CompositeNode rootNode = rootNodeAdapter.getParserNode();
				String serialize = rootNode.serialize();
				outputStream.write(serialize.getBytes());
			}
		}
	}

	private NodeAdapter getNodeAdapter(EObject object) {
		EList<Adapter> adapters = object.eAdapters();
		for (Adapter adapter : adapters) {
			if (adapter.isAdapterForType(AbstractNode.class)) {
				return (NodeAdapter) adapter;
			}
		}
		return null;
	}

}

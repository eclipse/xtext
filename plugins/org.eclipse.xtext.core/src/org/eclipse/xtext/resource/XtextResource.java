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
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParser;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.CompositeNode;
import org.eclipse.xtext.core.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.core.parsetree.NodeAdapter;

/**
 * An EMF resource that reads and writes models of an Xtext DSL.
 *  
 * @author Jan Köhnlein
 */
public class XtextResource extends ResourceImpl {

	private ILanguageFacade languageFacade;

	public XtextResource(ILanguageFacade languageFacade, URI uri) {
		super(uri);
		this.languageFacade = languageFacade;
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		IParser parser = languageFacade.getParser();
		IElementFactory elementFactory = languageFacade.getElementFactory();
		EObject rootElement = (EObject) parser.parse(inputStream, elementFactory);
		if (rootElement != null) {
			getContents().add(rootElement);
		}
	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (contents.size() > 1) {
			throw new IllegalStateException("Xtext resource cannot contain multiple root elements");
		}
		if (!contents.isEmpty()) {
			EObject rootElement = contents.get(0);
			IParseTreeConstructor parsetreeConstructor = languageFacade.getParsetreeConstructor();
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

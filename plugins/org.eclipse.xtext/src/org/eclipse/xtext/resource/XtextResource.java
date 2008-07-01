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
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.NodeAdapter;
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
    private IElementFactory elementFactory;
    
    @Inject
    private IParseTreeConstructor parsetreeConstructor;

	private IParseResult parse;

    public XtextResource(URI uri) {
        super(uri);
    }
    
    public IParseResult getParseResult() {
    	return parse;
    }
    
    public void update(int offset, int length, String change) {
    	parser.reparse(parse.getRootNode(), offset, length, change);
    }

    @Override
    protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
    	getContents().clear();
        parse = parser.parse(inputStream, elementFactory);
        if (parse != null) {
            EObject rootElement = parse.getRootASTElement();
            if (rootElement != null) {
                getContents().add(rootElement);
            }
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

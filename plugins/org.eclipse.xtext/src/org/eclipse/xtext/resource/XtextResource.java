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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.crossref.BrokenLink;
import org.eclipse.xtext.crossref.IFragmentProvider;
import org.eclipse.xtext.crossref.ILinker;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeContentAdapter;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
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
	private ILinker linker;

	@Inject
	private IFragmentProvider fragmentProvider;
	
	@Inject
	private IParseTreeConstructor parseTreeConstructor;
	
	private IParseResult parseResult;

	public XtextResource(URI uri) {
		super(uri);
	}

	public IParseResult getParseResult() {
		return parseResult;
	}

	public void update(int offset, int originalLength, String change) {
		CompositeNode rootNode = parseResult.getRootNode();

		// unloading is required to ensure that any EObjects hanging around
		// (e.g. in the outline) get a proxied URI
		// and thus still can be compared by their URI
		unload();

		parseResult = parser.reparse(rootNode, offset, originalLength, change);
		getContents().clear();
		if (parseResult != null) {
			if (parseResult.getRootASTElement() != null)
				getContents().add(parseResult.getRootASTElement());
			if (parseResult.getRootNode() != rootNode) {
				addNodeContentAdapter();
			}
		}
		doLinking();
	}

	protected void doLinking() {
		if (parseResult.getRootASTElement() == null)
			return;
		indexIds();
		List<BrokenLink> brokenLinks = linker.ensureLinked(parseResult.getRootASTElement());
		TreeIterator<EObject> allContents = parseResult.getRootASTElement().eAllContents();
		while (allContents.hasNext())
			brokenLinks.addAll(linker.ensureLinked(allContents.next()));

		// for (BrokenLink brokenLink : brokenLinks) {
		// //TODO handle broken links
		// }
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
		doLinking();
	}

	private void indexIds() {
		Map<String, EObject> map = new HashMap<String, EObject>();
		Iterator<EObject> iter = EcoreUtil.getAllContents(parseResult.getRootASTElement(), false);
		while (iter.hasNext()) {
			EObject object = (EObject) iter.next();
			String fragment = fragmentProvider.getFragment(object);
			if (fragment != null) {
				if (map.put(fragment, object) != null) {
					map.remove(fragment);
//					log.info("The id " + fragment
//							+ " is not unique within the resource. Will use relative pathes instead.");
				}
			}
		}
		setIntrinsicIDToEObjectMap(map);
	}
	
	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (contents.size() != 1)
			throw new IllegalStateException("The Xtext resource must contain exactly one root element");
		parseTreeConstructor.serialize(outputStream, contents.get(0), options);
	}
}

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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.crossref.IFragmentProvider;
import org.eclipse.xtext.crossref.ILinker;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeContentAdapter;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.IAbstractToken;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.util.StringInputStream;

/**
 * An EMF resource that reads and writes models of an Xtext DSL.
 * 
 * @author Jan Köhnlein
 * @author Heiko Behrens
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

	@Inject
	private ITokenSerializer tokenSerializer;

	private IParseResult parseResult;

	public XtextResource(URI uri) {
		super(uri);
	}

	public IParseResult getParseResult() {
		return parseResult;
	}

	public void reparse(String newContent) throws IOException {
		clearOutput();
		doLoad(new StringInputStream(newContent), null);
		reattachModificationTracker();
		setModified(false);
	}

	private void reattachModificationTracker() {
		if (isTrackingModification() && !getContents().isEmpty())
			// copied from ResourceImpl.setTrackingModification
			for (TreeIterator<EObject> i = getAllProperContents(getContents()); i.hasNext();) {
				EObject eObject = i.next();
				eObject.eAdapters().add(modificationTrackingAdapter);
			}
	}

	@Override
	protected void doUnload() {
		super.doUnload();
		parseResult = null;
	}

	public void update(int offset, int replacedTextLength, String newText) {
		if (!isLoaded()) {
			throw new IllegalStateException("You can't update an unloaded resource.");
		}
		try {
			isLoading = true;
			CompositeNode rootNode = parseResult.getRootNode();

			parseResult = parser.reparse(rootNode, offset, replacedTextLength, newText);
			clearOutput();
			if (parseResult != null) {
				if (parseResult.getRootASTElement() != null)
					if (getContents().add(parseResult.getRootASTElement()))
						reattachModificationTracker();
				if (parseResult.getRootNode() != rootNode) {
					addAdaptersToRoot();
				}
			}
			doLinking();
			setModified(false);
		}
		finally {
			isLoading = false;
		}
	}

	private void clearOutput() {
		getContents().clear();
		getErrors().clear();
	}

	protected void doLinking() {
		if (parseResult.getRootASTElement() == null)
			return;

		List<Diagnostic> brokenLinks = linker.ensureLinked(parseResult.getRootASTElement());
		TreeIterator<EObject> allContents = parseResult.getRootASTElement().eAllContents();
		while (allContents.hasNext())
			brokenLinks.addAll(linker.ensureLinked(allContents.next()));

		getErrors().addAll(brokenLinks);
		// logger.debug("errors: " + errors.size());
	}

	private void addAdaptersToRoot() {
		NodeContentAdapter.createAdapterAndAddToNode(parseResult.getRootNode());
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		parseResult = parser.parse(inputStream, elementFactory);
		if (parseResult != null) {
			EObject rootElement = parseResult.getRootASTElement();
			if (rootElement != null) {
				getContents().add(rootElement);
			}
			addAdaptersToRoot();
		}
		doLinking();
	}

	@Override
	public EObject getEObject(String uriFragment) {
		EObject result = (fragmentProvider != null) ? fragmentProvider.getEObject(this, uriFragment) : null;

		if (result == null)
			result = super.getEObject(uriFragment);

		return result;
	}

	@Override
	public String getURIFragment(EObject object) {
		String result = (fragmentProvider != null) ? fragmentProvider.getFragment(object) : null;

		if (result == null)
			result = super.getURIFragment(object);

		return result;
	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (contents.size() != 1)
			throw new IllegalStateException("The Xtext resource must contain exactly one root element");
		IAbstractToken tokenList = parseTreeConstructor.serialize(contents.get(0));
		tokenSerializer.serialize(tokenList, outputStream);
	}

	public interface Diagnostic extends org.eclipse.emf.ecore.resource.Resource.Diagnostic {
		public int getOffset();

		public int getLength();
	}
}

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ISwitchingParser;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeContentAdapter;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.IAbstractToken;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Inject;

/**
 * An EMF resource that reads and writes models of an Xtext DSL.
 *
 * @author Jan Köhnlein
 * @author Heiko Behrens
 * @author Dennis Hübner
 */
public class XtextResource extends ResourceImpl {

	public static String OPTION_RESOLVE_ALL = XtextResource.class.getName() + ".RESOLVE_ALL";
	
	private boolean validationDisabled;

	private IParser parser;

	@Inject
	private ILinker linker;

	@Inject
	private IFragmentProvider fragmentProvider;

	@Inject
	private IParseTreeConstructor parseTreeConstructor;

	@Inject
	private ITokenSerializer tokenSerializer;

	private IParseResult parseResult;

	@Inject
	protected void setInjectedParser(ISwitchingParser parser) {
		this.parser = parser;
	}

	public XtextResource(URI uri) {
		super(uri);
	}

	public XtextResource() {
		super();
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
				getErrors().addAll(createDiagnostics(parseResult));
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
		if (parseResult.getRootASTElement() == null && !validationDisabled)
			return;

		final ListBasedDiagnosticConsumer consumer = new ListBasedDiagnosticConsumer();
		linker.linkModel(parseResult.getRootASTElement(), consumer);
		getErrors().addAll(consumer.getResult());
		// logger.debug("errors: " + errors.size());
	}

	private void addAdaptersToRoot() {
		NodeContentAdapter.createAdapterAndAddToNode(parseResult.getRootNode());
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		parseResult = parser.parse(inputStream);
		if (parseResult != null) {
			getErrors().addAll(createDiagnostics(parseResult));
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

	/**
	 * Creates {@link Diagnostic}s from {@link SyntaxError}s in
	 * {@link ParseResult}
	 *
	 * @param list
	 *            of {@link SyntaxError}s
	 * @return list of {@link Diagnostic}
	 */
	private List<Diagnostic> createDiagnostics(IParseResult parseResult) {
		if (validationDisabled)
			return Collections.emptyList();

		List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
		for (SyntaxError error : parseResult.getParseErrors()) {
			diagnostics.add(new XtextSyntaxDiagnostic(error));
		}
		return diagnostics;
	}

	public IParser getParser() {
		return parser;
	}

	public void setParser(IParser parser) {
		this.parser = parser;
	}

	public ILinker getLinker() {
		return linker;
	}

	public void setLinker(ILinker linker) {
		this.linker = linker;
	}

	public IFragmentProvider getFragmentProvider() {
		return fragmentProvider;
	}

	public void setFragmentProvider(IFragmentProvider fragmentProvider) {
		this.fragmentProvider = fragmentProvider;
	}

	public IParseTreeConstructor getParseTreeConstructor() {
		return parseTreeConstructor;
	}

	public void setParseTreeConstructor(IParseTreeConstructor parseTreeConstructor) {
		this.parseTreeConstructor = parseTreeConstructor;
	}

	public ITokenSerializer getTokenSerializer() {
		return tokenSerializer;
	}

	public void setTokenSerializer(ITokenSerializer tokenSerializer) {
		this.tokenSerializer = tokenSerializer;
	}

	public void setParseResult(IParseResult parseResult) {
		this.parseResult = parseResult;
	}

	public boolean isValidationDisabled() {
		return validationDisabled;
	}

	public void setValidationDisabled(boolean validationDisabled) {
		this.validationDisabled = validationDisabled;
		if (validationDisabled) {
			getWarnings().clear();
			getErrors().clear();
		}
	}
}

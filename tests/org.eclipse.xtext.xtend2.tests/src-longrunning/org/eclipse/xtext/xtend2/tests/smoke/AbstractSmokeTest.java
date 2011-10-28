/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.smoke;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractSmokeTest extends AbstractXtend2TestCase {

	private static final Logger logger = Logger.getLogger(AbstractSmokeTest.class);
	
	protected List<String> smokeTestModels;
	
	@Inject
	protected IJvmTypeProvider.Factory typeProviderFactory;
	
	@Inject
	protected IResourceFactory resourceFactory;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		int i = 9; // TODO sz: investigate how to speed things up here (parallelism)?
		smokeTestModels = Lists.newArrayList();
		while(true) {
			String location = "/" + SmokeTest.class.getPackage().getName().replace('.', '/') + "/Case_" + i + ".xtend";
			URL resource = getClass().getClassLoader().getResource(location);
			if (resource == null)
				break;
			final InputStream resourceAsStream = resource.openStream();
			String string = Files.readStreamIntoString(resourceAsStream);
			smokeTestModels.add(string);
			i++;
		}
	}
	
	@Override
	protected void tearDown() throws Exception {
		smokeTestModels = null;
		super.tearDown();
	}
	
	protected void doParseAndCheckForSmoke(final String model) throws Exception {
		try {
			LazyLinkingResource resource = createResource(model);
			checkForSmoke(model, resource);
		} catch (Throwable e) {
			e.printStackTrace();
			assertEquals(e.getMessage()+" : Model was : \n\n"+model, model, "");
			// just to make sure we fail for empty model, too
			fail(e.getMessage()+" : Model was : \n\n"+model);
		}
	}
	
	protected void doParseAndCheckForSmokeWithoutResourceSet(final String model) throws Exception {
		try {
			LazyLinkingResource resource = createResource(model);
			// simulate closed editor
			ResourceSet resourceSet = resource.getResourceSet();
			resourceSet.eSetDeliver(false);
			resourceSet.getResources().clear();
			resourceSet.eAdapters().clear();
			checkForSmoke(model, resource);
		} catch (Throwable e) {
			e.printStackTrace();
			assertEquals(e.getMessage()+" : Model was : \n\n"+model, model, "");
			// just to make sure we fail for empty model, too
			fail(e.getMessage()+" : Model was : \n\n"+model);
		}
	}
	
	protected abstract void checkForSmoke(final String model, LazyLinkingResource resource);
	
	protected LazyLinkingResource createResource(final String model) throws IOException {
		if (logger.isTraceEnabled()) {
			logger.trace("createResource: " + model);
		}
		XtextResourceSet set = getResourceSet();
		typeProviderFactory.findOrCreateTypeProvider(set);
		LazyLinkingResource resource = (LazyLinkingResource) resourceFactory.createResource(URI.createURI("Test.xtend"));
		set.getResources().add(resource);
		resource.load(new StringInputStream(model), null);
		resource.resolveLazyCrossReferences(CancelIndicator.NullImpl);
		return resource;
	}
	
	public void testSkipLastCharacters() throws Exception {
		for(String string: smokeTestModels) {
			for (int i = 0; i < string.length(); i++) {
				logProgress(i);
				doParseAndCheckForSmoke(string.substring(0, i));
			}
		}
	}

	public void testSkipFirstCharacters() throws Exception {
		for(String string: smokeTestModels) {
			for (int i = 0; i < string.length(); i++) {
				logProgress(i);
				doParseAndCheckForSmoke(string.substring(i));
			}
		}
	}

	public void testSkipCharacterInBetween() throws Exception {
		for(String string: smokeTestModels) {
			for (int i = 0; i < string.length() - 1; i++) {
				logProgress(i);
				doParseAndCheckForSmoke(string.substring(0, i) + string.substring(i+1));
			}
		}
	}
	
	public void testSkipTokensInBetween() throws Exception {
		for(String string: smokeTestModels) {
			List<CommonToken> tokenList = Lists.newArrayList();
			{
				Lexer lexer = get(Lexer.class);
				lexer.setCharStream(new ANTLRStringStream(string));
				Token token = lexer.nextToken();
				while(token != Token.EOF_TOKEN) {
					tokenList.add((CommonToken) token);
					token = lexer.nextToken();
				}
			}
			for(CommonToken token: tokenList) {
				int start = token.getStartIndex();
				int length = token.getText().length();
				logProgress(token);
				doParseAndCheckForSmoke(string.substring(0, start) + string.substring(start + length));
			}
		}
	}
	
	public void testSkipNodesInBetween() throws Exception {
		for(String string: smokeTestModels) {
			LazyLinkingResource resource = createResource(string);
			ICompositeNode rootNode = resource.getParseResult().getRootNode();
			ReplaceRegion replaceRegion = null;
			for(INode node: rootNode.getAsTreeIterable()) {
				int offset = node.getTotalOffset();
				int length = node.getTotalLength();
				if (replaceRegion == null || replaceRegion.getOffset() != offset || replaceRegion.getLength() != length) {
					replaceRegion = new ReplaceRegion(offset, length, "");
					StringBuilder builder = new StringBuilder(string);
					replaceRegion.applyTo(builder);
					doParseAndCheckForSmoke(builder.toString());
				}
			}
		}
	}
	
	public void testSkipLastCharactersWithoutResourceSet() throws Exception {
		for(String string: smokeTestModels) {
			for (int i = 0; i < string.length(); i++) {
				logProgress(i);
				doParseAndCheckForSmokeWithoutResourceSet(string.substring(0, i));
			}
		}
	}

	public void testSkipFirstCharactersWithoutResourceSet() throws Exception {
		for(String string: smokeTestModels) {
			for (int i = 0; i < string.length(); i++) {
				logProgress(i);
				doParseAndCheckForSmokeWithoutResourceSet(string.substring(i));
			}
		}
	}

	public void testSkipCharacterInBetweenWithoutResourceSet() throws Exception {
		for(String string: smokeTestModels) {
			for (int i = 0; i < string.length() - 1; i++) {
				logProgress(i);
				doParseAndCheckForSmokeWithoutResourceSet(string.substring(0, i) + string.substring(i+1));
			}
		}
	}
	
	public void testSkipTokensInBetweenWithoutResourceSet() throws Exception {
		for(String string: smokeTestModels) {
			List<CommonToken> tokenList = Lists.newArrayList();
			{
				Lexer lexer = get(Lexer.class);
				lexer.setCharStream(new ANTLRStringStream(string));
				Token token = lexer.nextToken();
				while(token != Token.EOF_TOKEN) {
					tokenList.add((CommonToken) token);
					token = lexer.nextToken();
				}
			}
			for(CommonToken token: tokenList) {
				int start = token.getStartIndex();
				int length = token.getText().length();
				logProgress(token);
				doParseAndCheckForSmokeWithoutResourceSet(string.substring(0, start) + string.substring(start + length));
			}
		}
	}
	
	public void testSkipNodesInBetweenWithoutResourceSet() throws Exception {
		for(String string: smokeTestModels) {
			LazyLinkingResource resource = createResource(string);
			ICompositeNode rootNode = resource.getParseResult().getRootNode();
			ReplaceRegion replaceRegion = null;
			for(INode node: rootNode.getAsTreeIterable()) {
				int offset = node.getTotalOffset();
				int length = node.getTotalLength();
				if (replaceRegion == null || replaceRegion.getOffset() != offset || replaceRegion.getLength() != length) {
					replaceRegion = new ReplaceRegion(offset, length, "");
					StringBuilder builder = new StringBuilder(string);
					replaceRegion.applyTo(builder);
					doParseAndCheckForSmokeWithoutResourceSet(builder.toString());
				}
			}
		}
	}
	
	protected void logProgress(Object info) {
		if (logger.isDebugEnabled()) {
			Runtime runtime = Runtime.getRuntime();
			logger.debug("Step: " + info + " memory: free / total / max MB " + runtime.freeMemory() / (1000 * 1000) + " / " + runtime.totalMemory() / (1000 * 1000) + " / " + runtime.maxMemory() / (1000 * 1000));
		}
	}
}

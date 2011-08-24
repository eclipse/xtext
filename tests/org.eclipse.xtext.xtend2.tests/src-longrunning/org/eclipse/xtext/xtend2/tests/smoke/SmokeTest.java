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
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * A brute-force test class to ensure that parsing, linking and validation 
 * don't throw exceptions on invalid models.
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 * 
 * TODO connect all model listeners (highlighting, outline) and compiler to
 * verify that they do not throw any exceptions.
 */
public class SmokeTest extends AbstractXtend2TestCase {

	private static final Logger logger = Logger.getLogger(SmokeTest.class);
	
	private List<String> smokeTestModels;
	
	@Inject
	private InvariantChecker invariantChecker;
	
	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;
	
	@Inject
	private IResourceScopeCache cache;
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		int i = 0;
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
	
	public void testSkipLastCharacters() throws Exception {
		for(String string: smokeTestModels) {
			for (int i = 0; i < string.length(); i++) {
				logProgress(i);
				doParseLinkAndValidate(string.substring(0, i));
			}
		}
	}

	public void testSkipFirstCharacters() throws Exception {
		for(String string: smokeTestModels) {
			for (int i = 0; i < string.length(); i++) {
				logProgress(i);
				doParseLinkAndValidate(string.substring(i));
			}
		}
	}

	public void testSkipCharacterInBetween() throws Exception {
		for(String string: smokeTestModels) {
			for (int i = 0; i < string.length() - 1; i++) {
				logProgress(i);
				doParseLinkAndValidate(string.substring(0, i) + string.substring(i+1));
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
				doParseLinkAndValidate(string.substring(0, start) + string.substring(start + length));
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
					doParseLinkAndValidate(builder.toString());
				}
			}
		}
	}
	
	public void testSkipLastCharactersWithoutResourceSet() throws Exception {
		for(String string: smokeTestModels) {
			for (int i = 0; i < string.length(); i++) {
				logProgress(i);
				doParseLinkAndValidateWithoutResourceSet(string.substring(0, i));
			}
		}
	}

	public void testSkipFirstCharactersWithoutResourceSet() throws Exception {
		for(String string: smokeTestModels) {
			for (int i = 0; i < string.length(); i++) {
				logProgress(i);
				doParseLinkAndValidateWithoutResourceSet(string.substring(i));
			}
		}
	}

	public void testSkipCharacterInBetweenWithoutResourceSet() throws Exception {
		for(String string: smokeTestModels) {
			for (int i = 0; i < string.length() - 1; i++) {
				logProgress(i);
				doParseLinkAndValidateWithoutResourceSet(string.substring(0, i) + string.substring(i+1));
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
				doParseLinkAndValidateWithoutResourceSet(string.substring(0, start) + string.substring(start + length));
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
					doParseLinkAndValidateWithoutResourceSet(builder.toString());
				}
			}
		}
	}
	
	public void testResourceUpdateSkipLastCharacters() throws Exception {
		for(String string: smokeTestModels) {
			LazyLinkingResource resource = createResource("");
			for (int i = 0; i < string.length(); i++) {
				logProgress(i);
				compareWithNewResource(resource, i, 0, String.valueOf(string.charAt(i)));
			}
		}
	}

	public void testResourceUpdateSkipFirstCharacters() throws Exception {
		for(String string: smokeTestModels) {
			LazyLinkingResource resource = createResource("");
			for (int i = string.length() - 1; i >= 0; i--) {
				logProgress(i);
				compareWithNewResource(resource, 0, 0, String.valueOf(string.charAt(i)));
			}
		}
	}

	public void testResourceUpdateSkipCharacterInBetween() throws Exception {
		for(String string: smokeTestModels) {
			LazyLinkingResource resource = createResource(string.substring(1));
			for (int i = 0; i < string.length() - 1; i++) {
				logProgress(i);
				compareWithNewResource(resource, i, 1, String.valueOf(string.charAt(i)));
			}
		}
	}
	
	public void testResourceUpdateSkipTokensInBetween() throws Exception {
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
			LazyLinkingResource resource = createResource(string);
			CommonToken prev = null;
			for(CommonToken token: tokenList) {
				logProgress(token);
				if (prev == null) {
					compareWithNewResource(resource, 0, token.getText().length(), "");	
				} else {
					int offset = prev.getStartIndex();
					int length = token.getText().length();
					if (offset + length < string.length())
						compareWithNewResource(resource, offset, length, prev.getText());
				}
				prev = token;
			}
		}
	}
	
	protected void logProgress(Object info) {
		if (logger.isDebugEnabled()) {
			Runtime runtime = Runtime.getRuntime();
			logger.debug("Step: " + info + " memory: free / total / max MB " + runtime.freeMemory() / (1000 * 1000) + " / " + runtime.totalMemory() / (1000 * 1000) + " / " + runtime.maxMemory() / (1000 * 1000));
		}
	}
	
	protected void compareWithNewResource(LazyLinkingResource resource, int offset, int length, String newText) throws IOException {
		String model = resource.getParseResult().getRootNode().getText();
		try {
			long start = System.currentTimeMillis();
			long time = System.currentTimeMillis();
			if (logger.isDebugEnabled()) {
				logger.debug("Partial parsing ...");
				logger.trace("Input is >>>" + resource.getParseResult().getRootNode().getText() + "<<<");
				logger.trace("Offset: " + offset);
				logger.trace("Length: " + length);
				logger.trace("New Text: >>>" + newText + "<<<");
			}
			resource.update(offset, length, newText);
			String text = resource.getParseResult().getRootNode().getText();
			if (logger.isDebugEnabled()) {
				logger.debug("... took " + (System.currentTimeMillis() - time));
				logger.debug("Loading second resource ...");
				time = System.currentTimeMillis();
			}
			LazyLinkingResource newResource = createResource(text);
			if (logger.isDebugEnabled()) {
				logger.debug("... took " + (System.currentTimeMillis() - time));
				logger.debug("Semantic equality check ...");
				time = System.currentTimeMillis();
			}
			assertEquals(text, resource.getContents().size(), newResource.getContents().size());
			EcoreUtil.resolveAll(resource);
			EcoreUtil.resolveAll(newResource);
			for(int i = 0; i < resource.getContents().size(); i++) {
				assertEquals(text, EmfFormatter.objToStr(newResource.getContents().get(i)), EmfFormatter.objToStr(resource.getContents().get(i)));
			}
			if (logger.isDebugEnabled()) {
				logger.debug("... took " + (System.currentTimeMillis() - time));
				logger.debug("Node equality check ...");
				time = System.currentTimeMillis();
			}
			ICompositeNode rootNode = resource.getParseResult().getRootNode();
			ICompositeNode newRootNode = newResource.getParseResult().getRootNode();
			Iterator<INode> iterator = rootNode.getAsTreeIterable().iterator();
			Iterator<INode> newIterator = newRootNode.getAsTreeIterable().iterator();
			while(iterator.hasNext()) {
				assertTrue(newIterator.hasNext());
				assertEqualNodes(text, iterator.next(), newIterator.next());
			}
			if (logger.isDebugEnabled()) {
				logger.debug("... took " + (System.currentTimeMillis() - time));
				logger.debug("... done - total time: " + (System.currentTimeMillis() - start));
			}
		} catch(Throwable e) {
			e.printStackTrace();
			String failureMessage = e.getMessage()+" : Model was >>>\n"	+ 
			model + 
			"\n<<<\n" +
			"offset: " + offset + "\n" +
			"length:" + length + "\n" +
			"newText: >>>" + newText + "<<<";
			assertEquals(failureMessage, model, "");
			// just to make sure we fail for empty model, too
			fail(failureMessage);
		}
	}

	protected void assertEqualNodes(String text, INode node, INode other) {
		assertEquals(text, node.getClass(), other.getClass());
		assertEquals(text, node.getTotalOffset(), other.getTotalOffset());
		assertEquals(text, node.getTotalLength(), other.getTotalLength());
		assertEquals(text, node.getGrammarElement(), other.getGrammarElement());
		assertEquals(text, node.hasDirectSemanticElement(), other.hasDirectSemanticElement());
		assertEquals(text, node.getSyntaxErrorMessage(), other.getSyntaxErrorMessage());
	}

	protected void doParseLinkAndValidate(final String model) throws Exception {
		try {
			LazyLinkingResource resource = createResource(model);
			checkResource(model, resource);
		} catch (Throwable e) {
			e.printStackTrace();
			assertEquals(e.getMessage()+" : Model was : \n\n"+model, model, "");
			// just to make sure we fail for empty model, too
			fail(e.getMessage()+" : Model was : \n\n"+model);
		}
	}
	
	protected void doParseLinkAndValidateWithoutResourceSet(final String model) throws Exception {
		try {
			LazyLinkingResource resource = createResource(model);
			// simulate closed editor
			ResourceSet resourceSet = resource.getResourceSet();
			resourceSet.eSetDeliver(false);
			resourceSet.getResources().clear();
			resourceSet.eAdapters().clear();
			checkResource(model, resource);
		} catch (Throwable e) {
			e.printStackTrace();
			assertEquals(e.getMessage()+" : Model was : \n\n"+model, model, "");
			// just to make sure we fail for empty model, too
			fail(e.getMessage()+" : Model was : \n\n"+model);
		}
	}

	protected void checkResource(final String model, LazyLinkingResource resource) {
		checkNodeModelInvariant(resource);
		cache.clear(resource);
		checkNoErrorsInTypeProvider(resource);
		cache.clear(resource);
		checkNoErrorsInValidator(model, resource);
	}

	protected void checkNoErrorsInTypeProvider(LazyLinkingResource resource) {
		Iterator<Object> contents = EcoreUtil.getAllContents(resource, true);
		while(contents.hasNext()) {
			Object object = contents.next();
			if (object instanceof XExpression) {
				XExpression expression = (XExpression) object;
				typeProvider.getExpectedType(expression);
				typeProvider.getType(expression);
				typeProvider.getCommonReturnType(expression, true);
			}
			if (object instanceof JvmIdentifiableElement) {
				typeProvider.getTypeForIdentifiable((JvmIdentifiableElement) object);
			}
			if (object instanceof JvmWildcardTypeReference) {
				assertTrue(((JvmWildcardTypeReference) object).eContainer() instanceof JvmTypeReference);
			}
		}
	}

	protected void checkNoErrorsInValidator(final String model, LazyLinkingResource resource) {
		ResourceValidatorImpl validator = new ResourceValidatorImpl();
		assertNotSame(validator, resource.getResourceServiceProvider().getResourceValidator());
		getInjector().injectMembers(validator);
		validator.setDiagnosticConverter(new IDiagnosticConverter() {
			public void convertValidatorDiagnostic(org.eclipse.emf.common.util.Diagnostic diagnostic, IAcceptor<Issue> acceptor) {
				if (diagnostic instanceof BasicDiagnostic) {
					List<?> data = diagnostic.getData();
					if (!data.isEmpty() && data.get(0) instanceof Throwable) {
						Throwable t = (Throwable) data.get(0);
						// the framework catches runtime exception
						// and AssertionError does not take a throwable as argument
						throw new Error(new RuntimeException("Input was: " + model, t));
					}
				}
			}
			
			public void convertResourceDiagnostic(Diagnostic diagnostic, Severity severity, IAcceptor<Issue> acceptor) {
				if (diagnostic instanceof ExceptionDiagnostic) {
					Exception e = ((ExceptionDiagnostic) diagnostic).getException();
					// the framework catches runtime exception
					// and AssertionError does not take a throwable as argument
					throw new Error(new RuntimeException("Input was: " + model, e));
				}
			}
		});
		validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
	}

	protected void checkNodeModelInvariant(LazyLinkingResource resource) {
		invariantChecker.checkInvariant(resource.getParseResult().getRootNode());
	}

	protected LazyLinkingResource createResource(final String model) throws IOException {
		if (logger.isTraceEnabled()) {
			logger.trace("createResource: " + model);
		}
		XtextResourceSet set = get(XtextResourceSet.class);
		typeProviderFactory.findOrCreateTypeProvider(set);
		LazyLinkingResource resource = (LazyLinkingResource) set.createResource(URI.createURI("Test.xtend"));
		resource.load(new StringInputStream(model), null);
		resource.resolveLazyCrossReferences(CancelIndicator.NullImpl);
		return resource;
	}
	
}

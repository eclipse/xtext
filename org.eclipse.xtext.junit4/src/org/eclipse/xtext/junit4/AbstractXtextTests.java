/*******************************************************************************
 * Copyright (c) 2008, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.junit4.GlobalRegistries.GlobalStateMemento;
import org.eclipse.xtext.junit4.serializer.SerializerTester;
import org.eclipse.xtext.junit4.util.ResourceLoadHelper;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.google.common.base.Joiner;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.3
 */
@Deprecated(forRemoval = true, since = "2.30")
public abstract class AbstractXtextTests extends Assert implements ResourceLoadHelper {

	private Injector injector;
	private boolean canCreateInjector;
	private boolean isSerializerTestDisabled = false;
	private GlobalStateMemento globalStateMemento;
	
	static {
		GlobalRegistries.initializeDefaults();
	}

	@Before
	public void setUp() throws Exception {
		canCreateInjector = true;
		isSerializerTestDisabled = false;
		globalStateMemento = GlobalRegistries.makeCopyOfGlobalState();
	}

	@After
	public void tearDown() throws Exception {
		injector = null;
		isSerializerTestDisabled = false;
		globalStateMemento.restoreGlobalState();
	}

	public String serialize(EObject obj) {
		return getSerializer().serialize(obj);
	}

	/**
	 * call this to set the language class to be used in the current test.
	 */
	protected void with(Module ... modules) throws Exception {
		assertTrue("super.setUp() has to be called before any injector is instantiated", canCreateInjector);
		setInjector(Guice.createInjector(modules));
	}

	protected void with(Class<? extends ISetup> setupClazz) throws Exception {
		assertTrue("super.setUp() has to be called before any injector is instantiated", canCreateInjector);
		ISetup instance = setupClazz.getDeclaredConstructor().newInstance();
		setInjector(instance.createInjectorAndDoEMFRegistration());
	}

	public void with(ISetup setup) throws Exception {
		assertTrue("super.setUp() has to be called before any injector is instantiated", canCreateInjector);
		setInjector(setup.createInjectorAndDoEMFRegistration());
	}
	
	protected void setInjector(Injector injector) {
		this.injector = injector;
	}
	
	final public Injector getInjector() {
		if (injector==null)
			throw new IllegalStateException("No injector set. Did you forget to call something like 'with(new YourStadaloneSetup())'?");
		return injector;
	}

	public<T> T get(Class<T> clazz) {
		if (injector == null)
			injector = Guice.createInjector();
		return injector.getInstance(clazz);
	}

	public<T> T get(Key<T> key) {
		if (injector == null)
			injector = Guice.createInjector();
		return injector.getInstance(key);
	}
	
	public void injectMembers(Object object) {
		if (injector == null)
			injector = Guice.createInjector();
		injector.injectMembers(object);
	}

	protected IParser getParser() {
		return getInjector().getInstance(IParser.class);
	}

	protected ILinkingService getLinkingService() {
		return getInjector().getInstance(ILinkingService.class);
	}

	protected IAstFactory getASTFactory() {
		return getInjector().getInstance(IAstFactory.class);
	}

	protected IGrammarAccess getGrammarAccess() {
		return getInjector().getInstance(IGrammarAccess.class);
	}

	protected IParseTreeConstructor getParseTreeConstructor() {
		return getInjector().getInstance(IParseTreeConstructor.class);
	}

	protected IResourceFactory getResourceFactory()  {
		return getInjector().getInstance(IResourceFactory.class);
	}

	protected IValueConverterService getValueConverterService() {
		return getInjector().getInstance(IValueConverterService.class);
	}

	protected ISerializer getSerializer() {
		return getInjector().getInstance(ISerializer.class);
	}
	
	protected INodeModelFormatter getNodeModelFormatter() {
		return getInjector().getInstance(INodeModelFormatter.class);
	}

	protected IScopeProvider getScopeProvider() {
		return getInjector().getInstance(IScopeProvider.class);
	}
	
	protected InvariantChecker getInvariantChecker(){
		return getInjector().getInstance(InvariantChecker.class);
	}

	protected InputStream getAsStream(String model) {
		return new StringInputStream(model);
	}
	
	// parse methods

	public EObject getModel(String model) throws Exception {
		return getModel(getAsStream(model));
	}
	
	public final EObject getModel(InputStream model) throws Exception {
		XtextResource resource = getResource(model);
		return getModel(resource);
	}
	
	public static final int EXPECT_ERRORS = -2;
	public static final int UNKNOWN_EXPECTATION = Integer.MIN_VALUE;

	public final EObject getModelAndExpect(String model, int errors) throws Exception {
		return getModelAndExpect(getAsStream(model), errors);
	}
	
	public final EObject getModelAndExpect(InputStream model, int errors) throws Exception {
		XtextResource resource = getResourceAndExpect(model, errors);
		return getModel(resource);
	}

	protected EObject getModel(XtextResource resource) {
		return resource.getParseResult().getRootASTElement();
	}

	protected final XtextResource getResourceFromString(String model) throws Exception {
		return getResource(getAsStream(model));
	}
	
	protected final XtextResource getResourceFromStringAndExpect(String model, int errors) throws Exception {
		return getResourceAndExpect(getAsStream(model), errors);
	}

	public final XtextResource getResource(InputStream in) throws Exception {
		return getResource(in, URI.createURI("mytestmodel."+getCurrentFileExtension()));
	}
	
	protected String getCurrentFileExtension() {
		String instance = getInjector().getInstance(Key.get(String.class,Names.named(Constants.FILE_EXTENSIONS)));
		if (instance.indexOf(',')==-1)
			return instance;
		return instance.split(",")[0];
	}
	
	@Override
	public final XtextResource getResourceFor(InputStream stream) {
		try {
			return getResourceAndExpect(stream, AbstractXtextTests.UNKNOWN_EXPECTATION);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public final XtextResource getResourceAndExpect(InputStream in, int errors) throws Exception {
		return getResourceAndExpect(in, getTestModelURI(), errors);
	}

	/**
	 * @since 2.8
	 */
	protected URI getTestModelURI() {
		return URI.createURI("mytestmodel."+getCurrentFileExtension());
	}

	public final XtextResource getResource(InputStream in, URI uri) throws Exception {
		return getResourceAndExpect(in, uri, 0);
	}
	
	public final XtextResource getResource(String contents, String uri) throws Exception {
		return getResource(getAsStream(contents), URI.createURI(uri));
	}
	
	public final XtextResource getResourceAndExpect(InputStream in, URI uri, int expectedErrors) throws Exception {
		XtextResource resource = doGetResource(in, uri);
		checkNodeModel(resource);
		if (expectedErrors != UNKNOWN_EXPECTATION) {
			if (expectedErrors == EXPECT_ERRORS)
				assertFalse(Joiner.on('\n').join(resource.getErrors()), resource.getErrors().isEmpty());
			else
				assertEquals(Joiner.on('\n').join(resource.getErrors()), expectedErrors, resource.getErrors().size());
		}
		for(Diagnostic d: resource.getErrors()) {
			if (d instanceof ExceptionDiagnostic)
				fail(d.getMessage());
		}
		if (expectedErrors == 0 && resource.getContents().size() > 0 && shouldTestSerializer(resource)) {
			SerializerTester tester = get(SerializerTester.class);
			EObject obj = resource.getContents().get(0);
			tester.assertSerializeWithNodeModel(obj);
			tester.assertSerializeWithoutNodeModel(obj);
		}
		return resource;
	}

	protected void checkNodeModel(XtextResource resource) {
		IParseResult parseResult = resource.getParseResult();
		if(parseResult != null)
			getInvariantChecker().checkInvariant(parseResult.getRootNode());
	}

	protected boolean shouldTestSerializer(XtextResource resource) {
		return !isSerializerTestDisabled && !("org.eclipse.xtext.Xtext".equals(resource.getLanguageName()) 
				// TODO: fix serializer issues in refactoring tests
				|| "org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage".equals(resource.getLanguageName()));
	}
	
	protected void disableSerializerTest() {
		isSerializerTestDisabled = true;
	}

	protected XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		XtextResource resource = (XtextResource) getResourceFactory().createResource(uri);
		rs.getResources().add(resource);
		resource.load(in, null);
		if (resource instanceof LazyLinkingResource) {
			((LazyLinkingResource) resource).resolveLazyCrossReferences(CancelIndicator.NullImpl);
		} else {
			EcoreUtil.resolveAll(resource);
		}
		return resource;
	}

	protected final ICompositeNode getRootNode(InputStream model) throws Exception {
		XtextResource resource = getResource(model);
		return getRootNode(resource);
	}
	
	protected final ICompositeNode getRootNodeAndExpect(InputStream model, int errors) throws Exception {
		XtextResource resource = getResourceAndExpect(model, errors);
		return getRootNode(resource);
	}

	protected final ICompositeNode getRootNode(XtextResource resource) {
		return resource.getParseResult().getRootNode();
	}

	protected final IParseResult getParseResult(String model) throws Exception {
		return getResourceFromString(model).getParseResult();
	}
	
	protected final IParseResult getParseResultAndExpect(String model, int errors) throws Exception {
		return getResourceFromStringAndExpect(model, errors).getParseResult();
	}
	
	protected final ICompositeNode getRootNode(String model) throws Exception {
		return getRootNode(getAsStream(model));
	}
	
	protected final ICompositeNode getRootNodeAndExpect(String model, int errors) throws Exception {
		return getRootNodeAndExpect(getAsStream(model), errors);
	}
	
	protected String readFileIntoString(String filePath) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		URL url = classLoader.getResource(filePath);
		if (url == null) {
			fail("Could not read resource: '" + filePath + "'. Is your file system case sensitive?");
		} else {
			String canonicalPath = new File(new File(url.getPath()).getCanonicalPath()).toURI().getPath();
			if(!canonicalPath.endsWith(filePath))
				throw new RuntimeException(filePath + " -> " + canonicalPath + ":\n" +
						"The file does not exist exactly as it was named.\n" +
						"The test is likely to cause trouble on the build server.\n" +
						"Is your filesystem case insensitive? Please verify the spelling.");

			InputStream resourceAsStream = classLoader.getResourceAsStream(filePath);
			try {
				if (resourceAsStream == null) {
					fail("Could not read resource: '" + filePath + "'. Is your file system case sensitive?");
				} else {
						byte[] buffer = new byte[2048];
						int bytesRead = 0;
						StringBuffer b = new StringBuffer();
						do {
							bytesRead = resourceAsStream.read(buffer);
							if (bytesRead != -1)
								b.append(new String(buffer, 0, bytesRead));
						} while (bytesRead != -1);
						String model = b.toString();
						return model;
				}
			} finally {
				if (resourceAsStream != null)
					resourceAsStream.close();
			}
		}
		throw new IllegalStateException("May not happen, but helps to suppress false positives in eclipse' control flow analysis.");
	}

	public static final class Keys {
		private static final TypeLiteral<Provider<XtextResourceSet>> resourceSetLiteral = new TypeLiteral<Provider<XtextResourceSet>>(){
		};

		public static final Key<Provider<XtextResourceSet>> RESOURCE_SET_KEY = Key.get(resourceSetLiteral);
	}
}

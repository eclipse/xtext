/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.junit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ISwitchingParser;
import org.eclipse.xtext.parser.antlr.IAntlrParser;
import org.eclipse.xtext.parser.packrat.IPackratParser;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.SerializerUtil;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public abstract class AbstractXtextTests extends TestCase {

	private Injector injector;
	private HashMap<EPackage, Object> validatorReg;
	private HashMap<String, Object> epackageReg;
	private boolean canCreateInjector;

	static {
		//EMF Standalone setup
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		if (!EPackage.Registry.INSTANCE.containsKey(org.eclipse.xtext.XtextPackage.eNS_URI))
			EPackage.Registry.INSTANCE.put(org.eclipse.xtext.XtextPackage.eNS_URI, org.eclipse.xtext.XtextPackage.eINSTANCE);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		canCreateInjector = true;
		this.validatorReg = new HashMap<EPackage, Object>(EValidator.Registry.INSTANCE);
		this.epackageReg = new HashMap<String, Object>(EPackage.Registry.INSTANCE);
	}

	@Override
	protected void tearDown() throws Exception {
		injector = null;
		EValidator.Registry.INSTANCE.clear();
		EValidator.Registry.INSTANCE.putAll(validatorReg);

		EPackage.Registry.INSTANCE.clear();
		EPackage.Registry.INSTANCE.putAll(epackageReg);
		super.tearDown();
	}

	public String serialize(EObject obj) {
		return getSerializer().serialize(obj);
	}

	/**
	 * call this to set the language class to be used in the current test.
	 */
	protected void with(Module ... modules) throws Exception {
		assertTrue("super.setUp() has to be called before any injector is instantiated", canCreateInjector);
		injector = Guice.createInjector(modules);
	}

	protected void with(Class<? extends ISetup> setupClazz) throws Exception {
		assertTrue("super.setUp() has to be called before any injector is instantiated", canCreateInjector);
		ISetup instance = setupClazz.newInstance();
		injector = instance.createInjectorAndDoEMFRegistration();
	}

	public void with(ISetup setup) throws Exception {
		assertTrue("super.setUp() has to be called before any injector is instantiated", canCreateInjector);
		injector = setup.createInjectorAndDoEMFRegistration();
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

	protected IParser getParser() {
		return injector.getInstance(ISwitchingParser.class);
	}

	protected IAntlrParser getAntlrParser() {
		return injector.getInstance(IAntlrParser.class);
	}

	protected IPackratParser getPackratParser() {
		return injector.getInstance(IPackratParser.class);
	}
	
	protected ILinkingService getLinkingService() {
		return injector.getInstance(ILinkingService.class);
	}

	protected IAstFactory getASTFactory() {
		return injector.getInstance(IAstFactory.class);
	}

	protected IGrammarAccess getGrammarAccess() {
		return injector.getInstance(IGrammarAccess.class);
	}

	protected IParseTreeConstructor getParseTreeConstructor() {
		return injector.getInstance(IParseTreeConstructor.class);
	}

	protected IResourceFactory getResourceFactory()  {
		return injector.getInstance(IResourceFactory.class);
	}

	protected IValueConverterService getValueConverterService() {
		return injector.getInstance(IValueConverterService.class);
	}

	protected SerializerUtil getSerializer() {
		return injector.getInstance(SerializerUtil.class);
	}

	protected IScopeProvider getScopeProvider() {
		return injector.getInstance(IScopeProvider.class);
	}
	// parse methods

	public EObject getModel(String model) throws Exception {
		return getModel(new org.eclipse.xtext.util.StringInputStream(model));
	}

	public EObject getModel(InputStream model) throws Exception {
		XtextResource resource = getResource(model);
		return getModel(resource);
	}

	protected EObject getModel(XtextResource resource) {
		return resource.getParseResult().getRootASTElement();
	}

	protected XtextResource getResourceFromString(String model) throws Exception {
		return getResource(new org.eclipse.xtext.util.StringInputStream(model));
	}

	public XtextResource getResource(InputStream in) throws Exception {
		return getResource(in, URI.createURI("mytestmodel.test"));
	}

	public XtextResource getResource(InputStream in, URI uri) throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		XtextResource resource = (XtextResource) getResourceFactory().createResource(uri);
		rs.getResources().add(resource);
		resource.load(in, null);
		EcoreUtil.resolveAll(resource);

		for(Diagnostic d: resource.getErrors()) {
			System.out.println("Resource Error: "+d);
			if (d instanceof ExceptionDiagnostic)
				fail(d.getMessage());
		}

		for(Diagnostic d: resource.getWarnings())
			System.out.println("Resource Warning: "+d);

		return resource;
	}

	protected CompositeNode getRootNode(InputStream model) throws Exception {
		XtextResource resource = getResource(model);
		return getRootNode(resource);
	}

	protected CompositeNode getRootNode(XtextResource resource) {
		return resource.getParseResult().getRootNode();
	}

	protected CompositeNode getRootNode(String model2) throws Exception {
		return getRootNode(new StringInputStream(model2));
	}

	// Xtend helper methods

	protected void assertWithXtend(String left, String right, Object _this) {
		assertWithXtend(left + " != " + right, left, right, _this);
	}

	protected Object invokeWithXtend(String expression, Object _this) {
		XtendFacade f = getXtendFacade();
		f = f.cloneWithExtensions(getImportDeclarations() + "invoke(Object this) : " + expression + ";");
		return f.call("invoke", _this);
	}

	protected String[] importedExtensions() {
		return new String[0];
	}

	protected void assertWithXtend(String message, String left, String right, Object _this) {
		XtendFacade f = getXtendFacade();
		StringBuffer code = getImportDeclarations();
		code.append("__compare(Object this) : __left(this) == __right(this);__left(Object this) : " + left
				+ "; __right(Object this) :" + right + ";");
		f = f.cloneWithExtensions(code.toString());
		Boolean result = (Boolean) f.call("__compare", _this);
		if (!result) {
			Object leftResult = f.call("__left", _this);
			Object rightResult = f.call("__right", _this);
			fail(message + " was : " + leftResult + "("
					+ (leftResult != null ? leftResult.getClass().getSimpleName() : "") + ") != " + rightResult + "("
					+ (leftResult != null ? leftResult.getClass().getSimpleName() : "") + ")");
		}
	}

	private StringBuffer getImportDeclarations() {
		StringBuffer code = new StringBuffer();
		for (String _import : importedExtensions()) {
			code.append("extension ").append(_import).append(";");
		}
		return code;
	}

	protected XtendFacade getXtendFacade() {
		ExecutionContextImpl ctx = new ExecutionContextImpl();
		ctx.registerMetaModel(new EmfRegistryMetaModel());
		return XtendFacade.create(ctx);
	}

	protected String readFileIntoString(String filePath) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		URL url = classLoader.getResource(filePath);
		if (url == null) {
			fail("Could not read resource: '" + filePath + "'. Is your file system case sensitive?");
		} else {
			if(!new File(url.getPath()).getCanonicalPath().endsWith(filePath))
				throw new RuntimeException(filePath + ":\n" +
						"The file does not exist exactly as it was named.\n" +
						"The test is likely to cause trouble on the build server.\n" +
						"Is your filesystem case insensitive? Please verify the spelling.");

			InputStream resourceAsStream = classLoader.getResourceAsStream(filePath);
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
		}
		throw new IllegalStateException("May not happen, but helps to suppress false positives in eclipse' control flow analysis.");
	}

	public static final class Keys {
		private static final TypeLiteral<Provider<XtextResourceSet>> resourceSetLiteral = new TypeLiteral<Provider<XtextResourceSet>>(){
		};

		public static final Key<Provider<XtextResourceSet>> RESOURCE_SET_KEY = Key.get(resourceSetLiteral);
	}
}

/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.tests;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tools.ant.filters.StringInputStream;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseErrorHandler;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ServiceRegistry;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.xtend.XtendFacade;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public abstract class AbstractGeneratorTest extends TestCase {

	private ILanguageDescriptor currentLanguageDescriptor;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		currentLanguageDescriptor = null;
	}

	/**
	 * call this to set the language class to be used in the current test.
	 */
	protected void with(Class<?> standaloneSetup) throws Exception {
	    Method doSetupMethod = standaloneSetup.getMethod("doSetup");
	    doSetupMethod.invoke(null);
		Method getLangDescMethod = standaloneSetup.getMethod("getLanguageDescriptor");
		currentLanguageDescriptor = (ILanguageDescriptor) getLangDescMethod.invoke(null);
	}

	protected IParser getParser() {
	    return ServiceRegistry.getService(currentLanguageDescriptor, IParser.class);
	}

	protected IElementFactory getASTFactory() throws Exception {
	    return ServiceRegistry.getService(currentLanguageDescriptor, IElementFactory.class);
	}

	protected IParseTreeConstructor getParseTreeConstructor() throws Exception {
	    return ServiceRegistry.getService(currentLanguageDescriptor, IParseTreeConstructor.class);
	}

	// parse methods

	public EObject getModel(String model) throws Exception {
		return getModel(model, getASTFactory(), null);
	}

	public EObject getModel(String model, IElementFactory factory) throws Exception {
		return getModel(model, factory, null);
	}
	public EObject getModel(String model, IParseErrorHandler handler) throws Exception {
		return getModel(model, getASTFactory(), handler);
	}

	public EObject getModel(String model, IElementFactory factory, IParseErrorHandler errorHandler) throws Exception {
		return getModel(new StringInputStream(model), factory, errorHandler);
	}

	public EObject getModel(InputStream model) throws Exception {
		return getModel(model, getASTFactory(), null);
	}
	
	public EObject getModel(InputStream model, IElementFactory factory, IParseErrorHandler errorHandler)
			throws Exception {
		return parse(model, factory, errorHandler).getRootASTElement();
	}

    public IParseResult parse(InputStream model, IElementFactory factory, IParseErrorHandler errorHandler) {
        IParser parser = getParser();
        if (errorHandler != null) {
            return parser.parse(model, factory, errorHandler);
        } else {
            return parser.parse(model, factory);
        }
    }
    
    public IParseResult parse(String model, IElementFactory factory, IParseErrorHandler errorHandler) {
        return parse(new StringInputStream(model), factory, errorHandler);
    }   
    
    public IParseResult parse(String model, IParseErrorHandler errorHandler) throws Exception {
        return parse(new StringInputStream(model), getASTFactory(), errorHandler);
    }

    public IParseResult parse(String model) throws Exception {
        return parse(new StringInputStream(model), getASTFactory(), null);
    }
	
	public List<Invocation> getInvocations(String model) throws Exception {
		return getInvocations(model, (IParseErrorHandler) null);
	}

	public List<Invocation> getInvocations(String model, IParseErrorHandler errorHandler) throws Exception {
		final List<Invocation> calls = new ArrayList<Invocation>();
		getModel(model, new IElementFactory() {

			public void add(EObject _this, String feature, Object value) {
				calls.add(new Invocation("add", feature, value));
			}

			public EObject create(String typeName) {
				calls.add(new Invocation("create", typeName, null));
				EClass class1 = EcorePackage.eINSTANCE.getEcoreFactory().createEClass();
				class1.setName(typeName);
				return class1;
			}

			public void set(EObject _this, String feature, Object value) {
				calls.add(new Invocation("set", feature, value));
			}

		}, errorHandler);
		return calls;
	}
	
	// Xtend helper methods

	protected void assertWithXtend(String left, String right, Object _this) {
		assertWithXtend(left + " != " + right, left, right, _this);
	}

	protected Object invokeWithXtend(String expression, Object _this) {
		XtendFacade f = getXtendFacade();
		f = f.cloneWithExtensions(getImportDeclarations()+"invoke(Object this) : " + expression + ";");
		return f.call("invoke", _this);
	}

	protected String[] importedExtensions() {
		return new String[0];
	}

	protected void assertWithXtend(String message, String left, String right, Object _this) {
		XtendFacade f = getXtendFacade();
		StringBuffer code = getImportDeclarations();
		code.append("__compare(Object this) : __left(this) == __right(this);__left(Object this) : "
				+ left + "; __right(Object this) :" + right + ";");
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

    protected CompositeNode getRootNode(InputStream stream) throws Exception {
        return parse(stream, getASTFactory(), null).getRootNode();
    }
    protected CompositeNode getRootNode(String model2) throws Exception {
        return parse(new StringInputStream(model2), getASTFactory(), null).getRootNode();
    }
    
	protected CompositeNode getRootNode(String model2, IParseErrorHandler handler) throws Exception {
        return parse(new StringInputStream(model2), getASTFactory(), handler).getRootNode();
	}

}

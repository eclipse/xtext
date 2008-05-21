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
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.tools.ant.filters.StringInputStream;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParseErrorHandler;
import org.eclipse.xtext.core.parser.IParser;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.CompositeNode;
import org.eclipse.xtext.core.parsetree.NodeAdapter;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.xtend.XtendFacade;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public abstract class AbstractGeneratorTest extends TestCase {

	private String currentLanguage;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		currentLanguage = null;
	}

	/**
	 * call this to set the language class to be used in the current test.
	 */
	protected void with(String language) throws Exception {
		currentLanguage = language;
	}

	// parse methods

	public EObject getModel(String model) throws Exception {
		return getModel(model, getASTFactory(), null);
	}

	protected IElementFactory getASTFactory() throws Exception {
		return getFacade().getElementFactory();
	}

	private ILanguageFacade getFacade() {
		return LanguageFacadeFactory.getFacade(currentLanguage);
	}

	public EObject getModel(String model, IElementFactory factory) throws Exception {
		return getModel(model, factory, null);
	}

	public EObject getModel(String model, IElementFactory factory, IParseErrorHandler errorHandler) throws Exception {
		return getModel(new StringInputStream(model), factory, errorHandler);
	}

	public EObject getModel(InputStream model, IElementFactory factory, IParseErrorHandler errorHandler)
			throws Exception {
		IParser parserInstance = getFacade().getParser();
		if (errorHandler != null) {
			return parserInstance.parse(model, factory, errorHandler);
		} else {
			return parserInstance.parse(model, factory);
		}
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
		f = f.cloneWithExtensions("invoke(Object this) : " + expression + ";");
		return f.call("invoke", _this);
	}

	protected void assertWithXtend(String message, String left, String right, Object _this) {
		XtendFacade f = getXtendFacade();
		f = f.cloneWithExtensions("__compare(Object this) : __left(this) == __right(this);__left(Object this) : "
				+ left + "; __right(Object this) :" + right + ";");
		Boolean result = (Boolean) f.call("__compare", _this);
		if (!result) {
			Object leftResult = f.call("__left", _this);
			Object rightResult = f.call("__right", _this);
			fail(message + " was : " + leftResult + "("
					+ (leftResult != null ? leftResult.getClass().getSimpleName() : "") + ") != " + rightResult + "("
					+ (leftResult != null ? leftResult.getClass().getSimpleName() : "") + ")");
		}
	}

	protected XtendFacade getXtendFacade() {
		ExecutionContextImpl ctx = new ExecutionContextImpl();
		ctx.registerMetaModel(new EmfRegistryMetaModel());
		return XtendFacade.create(ctx);
	}

	protected CompositeNode getRootNode(String model2) throws Exception {
		EObject model = getModel(model2);
		NodeAdapter adapter = (NodeAdapter) EcoreUtil.getAdapter(model.eAdapters(), AbstractNode.class);
		if (adapter==null)
			return null;
		return adapter.getParserNode();
	}

}

/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.tests;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.antlr.runtime.TokenStream;
import org.apache.tools.ant.filters.StringInputStream;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParseErrorHandler;
import org.openarchitectureware.xtend.XtendFacade;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public abstract class AbstractGeneratorTest extends TestCase {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Class<?> class1 = getTheClass();
		Class<?> setupClass = class1.getClassLoader().loadClass(class1.getName()+"StandaloneSetup");
		setupClass.getMethod("doSetup").invoke(null);
	}
	
	protected Class<?> getTheClass() {
		return getClass();
	}

	public Object parse(String model, IElementFactory factory) throws Exception {
		return parse(model, factory, null);
	}

	public Object parse(String model, IElementFactory factory, IParseErrorHandler errorHandler) throws Exception {
		return parse(new StringInputStream(model),factory,errorHandler);
	}

	public Object parse(InputStream model, IElementFactory factory, IParseErrorHandler errorHandler) throws Exception {
		String name = getTheClass().getPackage().getName() + ".parser." + getTheClass().getSimpleName();
		String parser = name + "Parser";

		Class<?> parserClass = getTheClass().getClassLoader().loadClass(parser);
		Object parserInstance = parserClass.newInstance();
		if (errorHandler != null) {
			return parserClass.getMethod("parse", InputStream.class, IElementFactory.class, IParseErrorHandler.class)
					.invoke(parserInstance, model, factory, errorHandler);
		} else {
			return parserClass.getMethod("parse", InputStream.class, IElementFactory.class).invoke(parserInstance,
					model, factory);
		}
	}

	public List<Invocation> parse(String model) throws Exception {
		return parse(model, (IParseErrorHandler) null);
	}

	public List<Invocation> parse(String model, IParseErrorHandler errorHandler) throws Exception {
		final List<Invocation> calls = new ArrayList<Invocation>();
		parse(model, new IElementFactory() {

			public void add(Object _this, String feature, Object value) {
				calls.add(new Invocation("add", feature, value));
			}

			public Object create(String typeName) {
				calls.add(new Invocation("create", typeName, null));
				return typeName;
			}

			public void set(Object _this, String feature, Object value) {
				calls.add(new Invocation("set", feature, value));
			}

			public void associate(Object parserNode, Object astNode) {
				// TODO Auto-generated method stub
				
			}

			public Object createParserNode(TokenStream input,
					Object currentGrammarElement, Object parentParserNode) {
				// TODO Auto-generated method stub
				return null;
			}
		}, errorHandler);
		return calls;
	}

	protected void assertWithXtend(String left, String right, Object _this) {
		assertWithXtend(left + " != " + right, left, right, _this);
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
		throw new UnsupportedOperationException();
	}

}

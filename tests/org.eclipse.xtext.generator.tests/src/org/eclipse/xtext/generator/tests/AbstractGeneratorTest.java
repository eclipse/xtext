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

import org.apache.tools.ant.filters.StringInputStream;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.openarchitectureware.xtend.XtendFacade;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public abstract class AbstractGeneratorTest extends TestCase {
	
	public Object parse(String model, IElementFactory factory) throws Exception {
		String name = getClass().getPackage().getName() + ".parser." + getClass().getSimpleName();
		String parser = name + "Parser";

		Class<?> parserClass = getClass().getClassLoader().loadClass(parser);
		Object parserInstance = parserClass.newInstance();
		return parserClass.getMethod("parse", InputStream.class, IElementFactory.class).invoke(parserInstance,
				new StringInputStream(model), factory);
	}
	
	public Object parse(InputStream model, IElementFactory factory) throws Exception {
		String name = getClass().getPackage().getName() + ".parser." + getClass().getSimpleName();
		String parser = name + "Parser";
		
		Class<?> parserClass = getClass().getClassLoader().loadClass(parser);
		Object parserInstance = parserClass.newInstance();
		return parserClass.getMethod("parse", InputStream.class, IElementFactory.class).invoke(parserInstance,
				model, factory);
	}

	public List<Invocation> parse(String model) throws Exception {
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
		});
		return calls;
	}

	protected void assertWithXtend(String left, String right, Object _this) {
		assertWithXtend(left+" != "+right, left, right, _this);
	}
	protected void assertWithXtend(String message, String left, String right, Object _this) {
		XtendFacade f = getXtendFacade();
		f = f.cloneWithExtensions("__compare(Object this) : __left(this) == __right(this);__left(Object this) : "+left+"; __right(Object this) :"+right+";");
		assertTrue(message,(Boolean) f.call("__compare",_this));
	}

	protected XtendFacade getXtendFacade() {
		throw new UnsupportedOperationException();
	}

}

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DeclarativeValueConverterServiceTest extends AbstractXtextTests {

	public static class ValueConverterMock<T> implements IValueConverter<T> {

		private String ident;
		private DeclarativeValueConverterServiceTest test;
		
		public ValueConverterMock(String ident, DeclarativeValueConverterServiceTest test) {
			this.ident = ident;
			this.test = test;
		}
		
		@Override
		public T toValue(String string, INode node) throws ValueConverterException {
			test.announceToValue(ident);
			return null;
		}

		@Override
		public String toString(T value) throws ValueConverterException {
			test.announceToString(ident);
			return null;
		}
		
	}
	
	public static class SimpleIdConverter extends AbstractDeclarativeValueConverterService {
		
		@Inject
		protected DeclarativeValueConverterServiceTest test;
		
		private IValueConverter<String> idConverter;
		
		@ValueConverter(rule = "ID")
		public IValueConverter<String> ID() {
			if (idConverter == null)
				idConverter = new ValueConverterMock<String>("idConverter", test);
			return idConverter;
		}
	}
	
	public static class OverriddenIdConverter extends SimpleIdConverter {
		private IValueConverter<String> overriddenIdConverter;
		
		@ValueConverter(rule = "ID")
		public IValueConverter<String> overriddenID() {
			if (overriddenIdConverter == null)
				overriddenIdConverter = new ValueConverterMock<String>("overriddenIdConverter", test);
			return overriddenIdConverter;
		}
	}
	
	public static class DuplicateConverters extends SimpleIdConverter {
		@ValueConverter(rule = "STRING")
		public IValueConverter<String> firstString() {
			return new ValueConverterMock<String>("firstString", test);
		}
		
		@ValueConverter(rule = "STRING")
		public IValueConverter<String> secondString() {
			return new ValueConverterMock<String>("secondString", test);
		}
	}
	
	private String expectedIdent = null;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new org.eclipse.xtext.XtextRuntimeModule() {
					@SuppressWarnings("unused")
					public DeclarativeValueConverterServiceTest bindTest() {
						return DeclarativeValueConverterServiceTest.this;
					}
				});
			}
		});
		
	}
	
	protected void announceToValue(String ident) {
		assertEquals(expectedIdent, ident);
	}
	
	protected void announceToString(String ident) {
		assertEquals(expectedIdent, ident);
	}
	
	@Test public void testSimpleIdConverter() {
		IValueConverterService converter = get(SimpleIdConverter.class);
		expectedIdent = "idConverter";
		converter.toValue("Foo", "ID", null);
	}
	
	@Test public void testOverriddenIdConverter() {
		IValueConverterService converter = get(OverriddenIdConverter.class);
		expectedIdent = "overriddenIdConverter";
		converter.toString("Foo", "ID");
	}

	@Test public void testDuplicateConverters() {
		IValueConverterService converter = get(DuplicateConverters.class);
		try {
			converter.toString("Foo", "unknown");
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			assertTrue(e.getMessage().endsWith("'STRING'"));
		}
		
	}
}

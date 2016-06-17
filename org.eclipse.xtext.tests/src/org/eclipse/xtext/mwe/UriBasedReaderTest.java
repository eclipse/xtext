/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.linking.ImportUriTestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.importedURI.Type;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class UriBasedReaderTest extends AbstractXtextTests {
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	protected static class XtextErrorStandaloneSetup extends XtextStandaloneSetup {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new org.eclipse.xtext.XtextRuntimeModule() {
				@Override
				public void configureFileExtensions(Binder binder) {
					binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("xtexterror");
				}
			});
		}

		@Override
		public void register(Injector injector) {
			EPackage.Registry.INSTANCE.put(XtextPackage.eINSTANCE.getNsURI(), XtextPackage.eINSTANCE);
			IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
			IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtexterror", resourceFactory);
			IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("xtexterror", serviceProvider);
		}
	}

	@SuppressWarnings("unchecked")
	@Test public void testTransitiveReferences() throws Exception {
		UriBasedReader reader = new UriBasedReader();
		reader.addRegister(new ImportUriTestLanguageStandaloneSetup());
		reader.addUri("file:/" + pathTo("importUriSubfolder/Start.importuritestlanguage"));

		SlotEntry slotEntry = new SlotEntry();
		slotEntry.setType("Type");
		reader.addLoad(slotEntry);

		WorkflowContext ctx = new WorkflowContextDefaultImpl();
		IssuesImpl issues = new IssuesImpl();
		reader.checkConfiguration(issues);
		try {
			reader.invoke(ctx, new NullProgressMonitor(), issues);
		} catch (Exception e) {
			System.out.println(issues);
			throw e;
		}

		List<Type> types = (List<Type>) ctx.get(slotEntry.getSlot());
		assertEquals(3, types.size());
		for (Type type : types) {
			if (type.getName().equals("Foo")) {
				assertEquals("Bar", type.getExtends().getName());
			} else if (type.getName().equals("Bar")) {
				assertEquals("Baz", type.getExtends().getName());
			} else {
				assertNull(type.getExtends());
			}
		}
	}

	@Test public void testSimple() throws Exception {
		UriBasedReader reader = new UriBasedReader() {
			{
				getValidator().setStopOnError(false);
			}
		};
		reader.setClasspathURIContext(getClass());
		reader.addRegister(new XtextErrorStandaloneSetup());
		reader.addUri("classpath:/" + getClass().getName().replace('.', '/') + ".xtexterror");
		SlotEntry slotEntry = new SlotEntry();
		slotEntry.setType("Grammar");
		slotEntry.setFirstOnly(true);
		reader.addLoad(slotEntry);

		WorkflowContextDefaultImpl ctx = new WorkflowContextDefaultImpl();
		IssuesImpl issues = new IssuesImpl();
		reader.checkConfiguration(issues);
		assertFalse(issues.toString(), issues.hasErrors());
		reader.invoke(ctx, new NullProgressMonitor(), issues);
		assertTrue(ctx.get(slotEntry.getSlot()) instanceof Grammar);
		assertEquals(issues.toString(), 1, issues.getErrors().length);
	}

	@Test public void testMissingRegistration() throws Exception {
		with(new XtextErrorStandaloneSetup());
		UriBasedReader reader = new UriBasedReader();
		reader.setClasspathURIContext(getClass());
		//		reader.setRegister(new XtextStandaloneSetup());
		reader.addUri("classpath:/" + getClass().getName().replace('.', '/') + ".xtexterror");
		IssuesImpl issues = new IssuesImpl();
		reader.checkConfiguration(issues);
		assertTrue(issues.hasErrors());
	}

	@Test public void testMissingUri() throws Exception {
		UriBasedReader reader = new UriBasedReader();
		reader.setClasspathURIContext(getClass());
		reader.addRegister(new XtextStandaloneSetup());
		//		reader.setUri("classpath:/"+getClass().getName().replace('.', '/')+".xtext");
		IssuesImpl issues = new IssuesImpl();
		reader.checkConfiguration(issues);
		assertTrue(issues.hasErrors());
	}

	@Test public void testIssuesInOtherResource() throws Exception {
		UriBasedReader reader = new UriBasedReader() {
			{
				getValidator().setStopOnError(false);
			}
		};
		reader.setClasspathURIContext(getClass());
		reader.addRegister(new XtextStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new org.eclipse.xtext.XtextRuntimeModule() {
					@Override
					public void configureFileExtensions(Binder binder) {
						binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("xtexterror");
					}
				});
			}
			
			@Override
			public void register(Injector injector) {
				EPackage.Registry.INSTANCE.put(XtextPackage.eINSTANCE.getNsURI(), XtextPackage.eINSTANCE);
				IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
				IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtexterror", resourceFactory);
				IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("xtexterror", serviceProvider);
			}
		});
		final String errorURI = (getClass().getName() + "ResourceWithError").replace('.', '/')
				+ ".xtexterror";
		final String loadingURI = "classpath:/" + (getClass().getName() + "LoadingResourceWithError").replace('.', '/')
				+ ".xtexterror";
		reader.addUri(loadingURI);
		SlotEntry slotEntry = new SlotEntry();
		slotEntry.setType("Grammar");
		slotEntry.setFirstOnly(true);
		reader.addLoad(slotEntry);

		WorkflowContextDefaultImpl ctx = new WorkflowContextDefaultImpl();
		IssuesImpl issues = new IssuesImpl();
		reader.checkConfiguration(issues);
		assertFalse(issues.toString(), issues.hasErrors());
		reader.invoke(ctx, new NullProgressMonitor(), issues);
		assertTrue(ctx.get(slotEntry.getSlot()) instanceof Grammar);

		assertEquals(1, issues.getErrors().length);
		final String errorString = issues.getErrors()[0].toString();
		assertFalse(errorString, errorString.contains(loadingURI));
		assertTrue(errorString, errorString.contains(errorURI));
	}

	public String pathTo(String string) throws Exception {
		return new ReaderTest().pathTo(string).replace(File.separator, "/");
	}
	
}

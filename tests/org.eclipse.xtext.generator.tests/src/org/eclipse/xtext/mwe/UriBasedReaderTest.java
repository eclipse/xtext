/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.util.List;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.linking.ImportUriTestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.importedURI.Type;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class UriBasedReaderTest extends AbstractXtextTests {

	@SuppressWarnings("unchecked")
	public void testTransitiveReferences() throws Exception {
		UriBasedReader reader = new UriBasedReader();
		reader.addRegister(new ImportUriTestLanguageStandaloneSetup());
		reader.addUri("file:" + pathTo("importUriSubfolder/Start.importuritestlanguage"));

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

	public void testSimple() throws Exception {
		UriBasedReader reader = new UriBasedReader() {
			{
				getValidator().setStopOnError(false);
			}
		};
		reader.setClasspathURIContext(getClass());
		reader.addRegister(new XtextStandaloneSetup());
		reader.addUri("classpath:/" + getClass().getName().replace('.', '/') + ".xtext");
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

	public void testMissingRegistration() throws Exception {
		UriBasedReader reader = new UriBasedReader();
		reader.setClasspathURIContext(getClass());
		//		reader.setRegister(new XtextStandaloneSetup());
		reader.addUri("classpath:/" + getClass().getName().replace('.', '/') + ".xtext");
		IssuesImpl issues = new IssuesImpl();
		reader.checkConfiguration(issues);
		assertTrue(issues.hasErrors());
	}

	public void testMissingUri() throws Exception {
		UriBasedReader reader = new UriBasedReader();
		reader.setClasspathURIContext(getClass());
		reader.addRegister(new XtextStandaloneSetup());
		//		reader.setUri("classpath:/"+getClass().getName().replace('.', '/')+".xtext");
		IssuesImpl issues = new IssuesImpl();
		reader.checkConfiguration(issues);
		assertTrue(issues.hasErrors());
	}

	public void testIssuesInOtherResource() throws Exception {
		UriBasedReader reader = new UriBasedReader() {
			{
				getValidator().setStopOnError(false);
			}
		};
		reader.setClasspathURIContext(getClass());
		reader.addRegister(new XtextStandaloneSetup());
		final String errorURI = "classpath:/" + (getClass().getName() + "ResourceWithError").replace('.', '/')
				+ ".xtext";
		final String loadingURI = "classpath:/" + (getClass().getName() + "LoadingResourceWithError").replace('.', '/')
				+ ".xtext";
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
		return new ReaderTest().pathTo(string);
	}
	
}

/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import junit.framework.TestCase;

import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Heiko Behrens
 *
 */
@SuppressWarnings("deprecation")
public class MweReaderTest extends TestCase {

	public void testSimple() throws Exception {
		MweReader reader = new MweReader();
		reader.setClasspathURIContext(getClass());
		reader.setRegister(new XtextStandaloneSetup());
		reader.setUri("classpath:/"+getClass().getName().replace('.', '/')+".xtext");
		WorkflowContextDefaultImpl ctx = new WorkflowContextDefaultImpl();
		IssuesImpl issues = new IssuesImpl();
		reader.checkConfiguration(issues);
		assertFalse(issues.hasErrors());
		reader.invoke(ctx, new NullProgressMonitor(), issues);
		assertTrue(ctx.get(MweReader.DEFAULT_OUTPUT_SLOT) instanceof Grammar);
		assertEquals(issues.toString(),1,issues.getErrors().length);
	}

	public void testMissingRegistration() throws Exception {
		MweReader reader = new MweReader();
		reader.setClasspathURIContext(getClass());
//		reader.setRegister(new XtextStandaloneSetup());
		reader.setUri("classpath:/"+getClass().getName().replace('.', '/')+".xtext");
		IssuesImpl issues = new IssuesImpl();
		reader.checkConfiguration(issues);
		assertTrue(issues.hasErrors());
	}

	public void testMissingUri() throws Exception {
		MweReader reader = new MweReader();
		reader.setClasspathURIContext(getClass());
		reader.setRegister(new XtextStandaloneSetup());
//		reader.setUri("classpath:/"+getClass().getName().replace('.', '/')+".xtext");
		IssuesImpl issues = new IssuesImpl();
		reader.checkConfiguration(issues);
		assertTrue(issues.hasErrors());
	}
	
	public void testIssuesInOtherResource() throws Exception {
		MweReader reader = new MweReader();
		reader.setClasspathURIContext(getClass());
		reader.setRegister(new XtextStandaloneSetup());
		final String errorURI = "classpath:/"+(getClass().getName()+"ResourceWithError").replace('.', '/')+".xtext";
		final String loadingURI = "classpath:/"+(getClass().getName()+"LoadingResourceWithError").replace('.', '/')+".xtext";
		reader.setUri(loadingURI);
		WorkflowContextDefaultImpl ctx = new WorkflowContextDefaultImpl();
		IssuesImpl issues = new IssuesImpl();
		reader.checkConfiguration(issues);
		assertFalse(issues.hasErrors());
		reader.invoke(ctx, new NullProgressMonitor(), issues);
		assertTrue(ctx.get(MweReader.DEFAULT_OUTPUT_SLOT) instanceof Grammar);

		assertEquals(1, issues.getErrors().length);
		final String errorString = issues.getErrors()[0].toString();
		assertFalse(errorString.startsWith("[ERROR]: " + loadingURI));
		assertTrue(errorString.startsWith("[ERROR]: " + errorURI));
	}
}

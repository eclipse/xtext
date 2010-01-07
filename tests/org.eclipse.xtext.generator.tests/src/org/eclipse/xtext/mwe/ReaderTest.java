/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtext.index.IndexTestLanguageStandaloneSetup;
import org.eclipse.xtext.index.indexTestLanguage.Datatype;
import org.eclipse.xtext.index.indexTestLanguage.Entity;
import org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage;
import org.eclipse.xtext.junit.AbstractXtextTests;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ReaderTest extends AbstractXtextTests {

	public void testLoadOne() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());

		SlotEntry entry = new SlotEntry();
		entry.setName("foo.bar.Person");
		entry.setFirstOnly(true);

		reader.addLoad(entry);
		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		assertEquals("Person", ((Entity) ctx.get("model")).getName());
	}

	private Reader getReader() {
		Reader reader = new Reader();
		reader.setValidate(new Validator.Disabled());
		return reader;
	}

	public void testLoadTwo() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = new SlotEntry();
		entry.setSlot("person");
		entry.setName("foo.bar.Person");
		entry.setFirstOnly(true);
		SlotEntry entry2 = new SlotEntry();
		entry2.setSlot("string");
		entry2.setName("foo.bar.sub.String");
		entry2.setFirstOnly(true);
		reader.addLoad(entry);
		reader.addLoad(entry2);
		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		assertEquals("Person", ((Entity) ctx.get("person")).getName());
		assertEquals("String", ((Datatype) ctx.get("string")).getName());
	}

	@SuppressWarnings("unchecked")
	public void testLoadByType() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = new SlotEntry();
		entry.setType("Entity");
		reader.addLoad(entry);

		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		List<Entity> entities = (List<Entity>) ctx.get("model");
		assertEquals(2, entities.size());
	}
	
	@SuppressWarnings("unchecked")
	public void testLoadBySuperType() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = new SlotEntry();
		entry.setType("Type");
		reader.addLoad(entry);
		
		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		List<Entity> entities = (List<Entity>) ctx.get("model");
		assertEquals(3, entities.size());
	}
	
	public void testLoadByType_FirstOnly() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = new SlotEntry();
		entry.setType("Entity");
		entry.setFirstOnly(true);
		reader.addLoad(entry);
		
		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		assertEquals("Person", ((Entity) ctx.get("model")).getName());
	}
	
	@SuppressWarnings("unchecked")
	public void testLoadAll() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = new SlotEntry();
		reader.addLoad(entry);
		
		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		List<EObject> elements = (List<EObject>) ctx.get("model");
		assertEquals(8,elements.size());
	}

	@SuppressWarnings("unchecked")
	public void testLoadByType_withNsURI() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = new SlotEntry();
		entry.setType("Entity");
		entry.setNsURI(IndexTestLanguagePackage.eNS_URI);
		reader.addLoad(entry);

		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		List<Entity> entities = (List<Entity>) ctx.get("model");
		assertEquals(2, entities.size());
	}

	public void testLoadByType_withUnkownNsURI() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = new SlotEntry();
		entry.setType("Entity");
		entry.setNsURI("unknown ns uri");
		reader.addLoad(entry);

		WorkflowContext ctx = ctx();
		try {
			reader.invoke(ctx, monitor(), issues());
			fail("workflow interuption expected.");
		} catch (WorkflowInterruptedException e) {
			//expected
		}
	}

	public void testParseClassPath() throws Exception {
		Reader reader = getReader();
		assertEquals(0, reader.getPathes().size());
		reader.setUseJavaClassPath(true);
		assertTrue(reader.getPathes().size() > 50);
	}

	private WorkflowContext ctx() {
		return new WorkflowContextDefaultImpl();
	}

	private ProgressMonitor monitor() {
		return new NullProgressMonitor();
	}

	private Issues issues() {
		return new IssuesImpl();
	}

	private String pathTo(String string) throws Exception {
		java.net.URI uri = getClass().getClassLoader().getResource(getClass().getName().replace('.', '/') + ".class")
				.toURI();
		URI fileURI = URI.createURI(uri.toString());
		URI fileURI2 = URI.createURI(string);
		return fileURI2.resolve(fileURI).toFileString();
	}
}

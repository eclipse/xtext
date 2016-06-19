/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Level;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtext.index.IndexTestLanguageStandaloneSetup;
import org.eclipse.xtext.index.indexTestLanguage.Entity;
import org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage;
import org.eclipse.xtext.testing.logging.LoggingTester;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractReaderTest extends AbstractXtextTests {

	@Test public void testLoadMatchNone() throws Exception {
		final Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());

		SlotEntry entry = createSlotEntry();
		entry.setType("Type");
		reader.addLoad(entry);
		
		reader.setUriFilter(new UriFilter() {
			@Override
			public boolean matches(URI uri) {
				return false;
			}
		});
		final WorkflowContext ctx = ctx();
		LoggingTester.captureLogging(Level.WARN, SlotEntry.class, new Runnable() {

			@Override
			public void run() {
				reader.invoke(ctx, monitor(), issues());
			}
			
		}).assertLogEntry("Could not find any exported element of type 'Type' -> Slot 'model' is empty.");
		Collection<?> slotContent = (Collection<?>) ctx.get("model");
		assertNotNull(slotContent);
		assertTrue(slotContent.isEmpty());
	}
	
	@Test public void testLoadMatchAll() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());

		SlotEntry entry = createSlotEntry();
		entry.setType("Type");
		reader.addLoad(entry);
		
		reader.setUriFilter(new UriFilter() {
			@Override
			public boolean matches(URI uri) {
				return true;
			}
		});
		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		Collection<?> slotContent = (Collection<?>) ctx.get("model");
		assertNotNull(slotContent);
		// Foo, Person, String
		assertEquals(3, slotContent.size());
	}
	
	protected Reader getReader() {
		Reader reader = new Reader();
		reader.setValidate(new Validator.Disabled());
		return reader;
	}

	@SuppressWarnings("unchecked")
	@Test public void testLoadByType() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = createSlotEntry();
		entry.setType("Entity");
		reader.addLoad(entry);

		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		List<Entity> entities = (List<Entity>) ctx.get("model");
		assertEquals(2, entities.size());
	}
	
	@SuppressWarnings("unchecked")
	@Test public void testLoadBySuperType() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = createSlotEntry();
		entry.setType("Type");
		reader.addLoad(entry);
		
		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		List<Entity> entities = (List<Entity>) ctx.get("model");
		assertEquals(3, entities.size());
	}
	
	@Test public void testLoadByType_FirstOnly() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = createSlotEntry();
		entry.setType("Entity");
		entry.setFirstOnly(true);
		reader.addLoad(entry);
		
		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		assertEquals("Person", ((Entity) ctx.get("model")).getName());
	}
	
	@SuppressWarnings("unchecked")
	@Test public void testLoadByType_withNsURI() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = createSlotEntry();
		entry.setType("Entity");
		entry.setNsURI(IndexTestLanguagePackage.eNS_URI);
		reader.addLoad(entry);

		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		List<Entity> entities = (List<Entity>) ctx.get("model");
		assertEquals(2, entities.size());
	}

	@Test public void testLoadByType_withUnkownNsURI() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = createSlotEntry();
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

	protected abstract SlotEntry createSlotEntry();
	
	@Test public void testParseClassPath() throws Exception {
		Reader reader = getReader();
		assertEquals(0, reader.getPathes().size());
		reader.setUseJavaClassPath(true);
		assertTrue(reader.getPathes().size() > 0);
	}
	
	protected WorkflowContext ctx() {
		return new WorkflowContextDefaultImpl();
	}

	protected ProgressMonitor monitor() {
		return new NullProgressMonitor();
	}

	protected Issues issues() {
		return new IssuesImpl();
	}

	public String pathTo(String string) throws Exception {
//		URL resource = getClass().getClassLoader().getResource();
		File base = new File("./src/"+getClass().getName().replace('.', '/') + ".java");
		URI fileURI = URI.createFileURI(base.getAbsolutePath());
		System.out.println(fileURI);
		// this is a hack used in order to get a file URI for a bundleresource:/ URL
//		File f = (File) get(resource,"handler.bundleEntry.file");
//		if (f!=null)
//			fileURI = URI.createFileURI(f.getAbsolutePath());
		
		URI fileURI2 = URI.createURI(string);
		return fileURI2.resolve(fileURI).toFileString();
	}
	
	public Object get(final Object obj, String path) {
		String[] split = path.split("\\.");
		Object retVal = obj;
		for (String string : split) {
			try {
				Field field = findField(retVal.getClass(),string);
				field.setAccessible(true);
				retVal = field.get(retVal);
			} catch (Exception e) {
				return null;
			}
		}
		return retVal;
	}

	protected Field findField(Class<? extends Object> class1, String string) {
		try {
			return class1.getDeclaredField(string);
		} catch (Exception e) {
			if (class1.getSuperclass()!=null)
				return findField(class1.getSuperclass(), string);
		}
		return null;
	}
}

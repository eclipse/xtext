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
import org.eclipse.xtext.index.indexTestLanguage.Entity;
import org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage;
import org.eclipse.xtext.junit.AbstractXtextTests;

import com.google.common.base.Predicate;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractReaderTest extends AbstractXtextTests {

	public void testLoadMatchNone() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());

		SlotEntry entry = createSlotEntry();
		entry.setType("Type");
		reader.addLoad(entry);
		
		reader.setUriFilter(new UriFilter() {
			public boolean matches(URI uri) {
				return false;
			}
		});
		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		Collection<?> slotContent = (Collection<?>) ctx.get("model");
		assertNotNull(slotContent);
		assertTrue(slotContent.isEmpty());
	}
	
	public void testLoadMatchAll() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());

		SlotEntry entry = createSlotEntry();
		entry.setType("Type");
		reader.addLoad(entry);
		
		reader.setUriFilter(new UriFilter() {
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
	public void testLoadByType() throws Exception {
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
	public void testLoadBySuperType() throws Exception {
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
	
	public void testLoadByType_FirstOnly() throws Exception {
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
	public void testLoadByType_withNsURI() throws Exception {
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

	public void testLoadByType_withUnkownNsURI() throws Exception {
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
	
	protected Predicate<EObject> getPredicate(final String uriContains) {
		return new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return input.eResource().getURI().toString().contains("%20"+uriContains);
			}
		};
	}

	public void testParseClassPath() throws Exception {
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
		URL resource = getClass().getClassLoader().getResource(getClass().getName().replace('.', '/') + ".class");
		URI fileURI = URI.createURI(resource.toString());
		
		// this is a hack used in order to get a file URI for a bundleresource:/ URL
		File f = (File) get(resource,"handler.bundleEntry.file");
		if (f!=null)
			fileURI = URI.createFileURI(f.getAbsolutePath());
		
		URI fileURI2 = URI.createURI(string);
		return fileURI2.resolve(fileURI).toFileString();
	}
	
	public Object get(Object obj, String path) {
		String[] split = path.split("\\.");
		for (String string : split) {
			try {
				Field field = findField(obj.getClass(),string);
				field.setAccessible(true);
				obj = field.get(obj);
			} catch (Exception e) {
				return null;
			}
		}
		return obj;
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

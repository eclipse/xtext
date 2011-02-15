/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtend2.ui.internal.Xtend2Activator;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractXtend2UITestCase extends TestCase {

	private static Injector injector = Xtend2Activator.getInstance().getInjector("org.eclipse.xtext.xtend2.Xtend2");
	
	@Inject
	private FileExtensionProvider fileExtensionProvider; 
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getInjector().injectMembers(this);
	}

	public Injector getInjector() {
		return injector;
	}
	
	public <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}

	protected XtendClass clazz(String string) throws Exception {
		return file(string).getXtendClass();
	}
	
	protected XtendFile file(String string) throws Exception {
		XtextResourceSet set = get(XtextResourceSet.class);
		Resource resource = set.createResource(URI.createURI("Test." + getFileExtension()));
		resource.load(new StringInputStream(string), null);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}

	protected XtendFunction function(String string) throws Exception {
		XtendClass clazz = clazz("class Foo { "+string+"}");
		return (XtendFunction) clazz.getMembers().get(0);
	}
	
	protected String getFileExtension() {
		return fileExtensionProvider.getFileExtensions().iterator().next();
	}
}

/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests;

import java.io.InputStream;

import junit.framework.TestCase;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.junit.util.ResourceLoadHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.ui.internal.XtypeActivator;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractXbaseUITestCase extends TestCase implements ResourceLoadHelper {

	@Inject
	protected IWorkspace workspace;

	protected String fileExtension;

	static Injector injector = XtypeActivator.getInstance().getInjector("org.eclipse.xtext.xbase.Xbase");
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getInjector().injectMembers(this);
	}

	@Override
	protected void tearDown() throws Exception {
		if (doCleanWorkspace())
			IResourcesSetupUtil.cleanWorkspace();
		super.tearDown();
	}
	
	protected boolean doCleanWorkspace() {
		return true;
	}
	
	public Injector getInjector() {
		return injector;
	}
	
	public <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}

	protected XExpression expression(String string) throws Exception {
		XtextResource resource = getResourceFor(new StringInputStream(string));
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
		XExpression result = (XExpression) resource.getContents().get(0);
		return result;
	}
	
	public XtextResource getResourceFor(InputStream stream) {
		try {
			XtextResourceSet set = get(XtextResourceSet.class);
			XtextResource result = (XtextResource) set.createResource(URI.createURI("Test." + fileExtension));
			result.load(stream, null);
			return result;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Inject
	protected void setExtensions(@Named(Constants.FILE_EXTENSIONS) String extensions) {
		this.fileExtension = extensions.split(",")[0];
	}
}

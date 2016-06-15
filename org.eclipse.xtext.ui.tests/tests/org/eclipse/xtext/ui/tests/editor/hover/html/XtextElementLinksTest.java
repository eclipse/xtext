/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.hover.html;

import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hover.html.XtextElementLinks;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.foo.File;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Test;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
public class XtextElementLinksTest extends AbstractEditorTest {
	
	protected XtextEditor editor;
	
	protected IXtextDocument document;

	protected String modelAsText;

	private XtextElementLinks elementLinks;

	private File f;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		modelAsText = "stuff mystuff\nstuff yourstuff";
		IFile file = IResourcesSetupUtil.createFile("test/test.testlanguage", modelAsText);
		editor = openEditor(file);
		document = editor.getDocument();
		elementLinks = Activator.getInstance().getInjector(getEditorId()).getInstance (XtextElementLinks.class);
		f = document.readOnly(new IUnitOfWork<File, XtextResource>() {
			@Override
			public File exec(XtextResource state) throws Exception {
				return (File) state.getContents().get(0);
			}	
		});	
	}
	
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		editor.close(false);
	}
	
	@Test public void testDefaultScheme () throws Exception {
		String link = elementLinks.createLink (f.getStuff().get(0));
		assertTrue (isLinkOfType (link, XtextElementLinks.XTEXTDOC_SCHEME));
		assertEquals (f.getStuff().get(0), getEObject(link));
	}
	
	@Test public void testXTEXTDOC_SCHEME () throws Exception {
		String link = elementLinks.createLink (XtextElementLinks.XTEXTDOC_SCHEME, f.getStuff().get(0));
		assertTrue (isLinkOfType (link, XtextElementLinks.XTEXTDOC_SCHEME));
		assertEquals (f.getStuff().get(0), getEObject(link));
	}
	
	@Test public void testOPEN_LINK_SCHEME () throws Exception {
		String link = elementLinks.createLink (XtextElementLinks.OPEN_LINK_SCHEME, f.getStuff().get(0));
		assertTrue (isLinkOfType (link, XtextElementLinks.OPEN_LINK_SCHEME));
		assertEquals (f.getStuff().get(0), getEObject(link));
	}
	
	@Test public void testXTEXTDOC_VIEW_SCHEME () throws Exception {
		String link = elementLinks.createLink (XtextElementLinks.XTEXTDOC_VIEW_SCHEME ,f.getStuff().get(0));
		assertTrue (isLinkOfType (link, XtextElementLinks.XTEXTDOC_VIEW_SCHEME));
		assertEquals (f.getStuff().get(0), getEObject(link));
	}
	
	protected boolean isLinkOfType (String link, String type) {
		return link.matches("<a.* href='" + type + ":.*'.*</a>");
	}
	
	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.TestLanguage";
	}
	
	protected String getLocation (String link) {
		// parse the href=link
		Pattern pattern = Pattern.compile("href='(.*)'");
		Matcher matcher = pattern.matcher(link);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}

	protected EObject getEObject (String link) throws URISyntaxException {
		URI uri = elementLinks.parseURI(new java.net.URI(getLocation(link)));
		ResourceSet rs = document.readOnly(new IUnitOfWork<ResourceSet, XtextResource>() {
			@Override
			public ResourceSet exec(XtextResource state) throws Exception {
				return state.getResourceSet();
			}
		});
		return rs.getEObject(uri, true);	
	}
	
}

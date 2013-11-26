/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceFactory;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ImportURINavigationTest.InjectorProvider.class)
public class ImportURINavigationTest {

	@Inject
	private XtextResourceSetProvider resourceSetProvider;
	
	@Inject
	private XtextResourceFactory resourceFactory;
	
	@Inject
	private IHyperlinkHelper helper;
	
	@Inject
	private IWorkbench workbench;
	
	@Test
	public void testNavigateToFileURI() throws Exception {
		doTestNavigation(new IUnitOfWork<URI, IFile>() {
			public URI exec(IFile file) throws Exception {
				return URI.createURI(file.getLocationURI().toURL().toString());
			}
		}, true);
	}
	

	@Test
	public void testNavigateToClasspathURI() throws Exception {
		doTestNavigation(new IUnitOfWork<URI, IFile>() {
			public URI exec(IFile file) throws Exception {
				return URI.createURI("classpath:/first.importuriuitestlanguage");
			}
		}, false);
	}

	protected void doTestNavigation(IUnitOfWork<URI, IFile> uriComputation, boolean expectFQN) throws Exception {
		IJavaProject project = JavaProjectSetupUtil.createJavaProject("importuriuitestlanguage.project");
		try {
			IFile first = project.getProject().getFile("src/first.importuriuitestlanguage");
			first.create(new StringInputStream("type ASimpleType"), true, null);
			
			ResourceSet resourceSet = resourceSetProvider.get(project.getProject());
			
			Resource resource = resourceFactory.createResource(URI.createURI("synthetic://second.importuriuitestlanguage"));
			resourceSet.getResources().add(resource);
			String model = "import '" + uriComputation.exec(first) + "' type MyType extends ASimpleType";
			resource.load(new StringInputStream(model), null);
			EcoreUtil.resolveAll(resource);
			Assert.assertTrue(resource.getErrors().isEmpty());
			
			IHyperlink[] hyperlinks = helper.createHyperlinksByOffset((XtextResource) resource, model.indexOf("SimpleType"), false);
			Assert.assertEquals(1, hyperlinks.length);
			IWorkbenchPage activePage = workbench.getActiveWorkbenchWindow().getActivePage();
			Assert.assertNull(activePage.getActiveEditor());
			if (expectFQN) {
				Assert.assertEquals(URI.createURI(first.getLocationURI().toString()), ((XtextHyperlink)hyperlinks[0]).getURI().trimFragment());
			} else {
				Assert.assertEquals(URI.createPlatformResourceURI(first.getFullPath().toString(), true), ((XtextHyperlink)hyperlinks[0]).getURI().trimFragment());
			}
			hyperlinks[0].open();
			IEditorPart editor = activePage.getActiveEditor();
			Assert.assertNotNull(editor);
			IXtextDocument document = XtextDocumentUtil.get(editor);
			document.readOnly(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource state) throws Exception {
					Assert.assertEquals("platform:/resource/importuriuitestlanguage.project/src/first.importuriuitestlanguage", state.getURI().toString());
				}
			});
			Assert.assertEquals("type ASimpleType", document.get());
			IEditorPart newPart = IDE.openEditor(activePage, first);
			Assert.assertEquals(1, activePage.getEditorReferences().length);
			Assert.assertEquals(editor, newPart);
		} finally {
			project.getProject().delete(true, null);
		}
	}
	
	public static class InjectorProvider implements IInjectorProvider {
		
		public Injector getInjector() {
			return Activator.getInstance().getInjector(Activator.ORG_ECLIPSE_XTEXT_UI_TESTS_LINKING_IMPORTURIUITESTLANGUAGE);
		}
		
	}
}

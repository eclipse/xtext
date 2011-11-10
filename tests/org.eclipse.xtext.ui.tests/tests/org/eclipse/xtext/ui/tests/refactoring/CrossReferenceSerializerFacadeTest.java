/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ltk.core.refactoring.FileStatusContext;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.refactoring.impl.CrossReferenceSerializerFacade;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Element;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Main;
import org.eclipse.xtext.ui.tests.refactoring.services.RefactoringTestLanguageGrammarAccess;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class CrossReferenceSerializerFacadeTest extends AbstractXtextTests {

	@Inject
	private TestableCrossReferenceSerializerFacade facade;

	@Inject
	private org.eclipse.xtext.parsetree.reconstr.Serializer oldSerializer;

	@Inject
	private org.eclipse.xtext.serializer.impl.Serializer newSerializer;

	@Inject
	private RefactoringTestLanguageGrammarAccess grammarAccess;
	
	@Inject
	private StatusWrapper status;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setInjector(Activator.getInstance().getInjector("org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage"));
		getInjector().injectMembers(this);
	}
	
	@Override
	protected void tearDown() throws Exception {
		cleanWorkspace();
		super.tearDown();
	}
	
	public void testOldSerializer() throws Exception {
		facade.setSerializer(oldSerializer);
		assertFalse(facade.useNewSerializer());
		performTest();
	}

	public void testNewSerializer() throws Exception {
		facade.setSerializer(newSerializer);
		assertTrue(facade.useNewSerializer());
		performTest();
	}

	public void performTest() throws Exception {
		String model = "bar { ref foo } foo";
		String wsRelativePath = "test/test."+getCurrentFileExtension();
		IFile file = createFile(wsRelativePath, model);
		Main main = (Main) getModel(file.getContents());
		XtextResource resource = (XtextResource) main.eResource();
		resource.setURI(URI.createPlatformResourceURI(wsRelativePath, true));
		
		Element bar = (Element) main.getElements().get(0);
		Element foo = bar.getReferenced().get(0);
		assertEquals("foo", foo.getName());
		
		CrossReference crossref = GrammarUtil.containedCrossReferences(grammarAccess.getElementRule()).get(0);
		TextRegion linkTextRegion = new TextRegion(model.lastIndexOf("foo"), 3);
		String linkText = facade.serializeCrossRef(bar, crossref, foo, linkTextRegion, status);
		assertEquals(linkText, "foo");
		assertTrue(status.getRefactoringStatus().isOK());
		
		foo.setName("fooBar");
		resource.getCache().clear(resource);
		String linkText1 = facade.serializeCrossRef(bar, crossref, foo, linkTextRegion, status);
		assertEquals(linkText1, "fooBar");
		assertTrue(status.getRefactoringStatus().isOK());

		assertEquals(foo, ((Main) resource.getContents().get(0)).getElements().get(1));
		foo.setName("bar");
		resource.getCache().clear(resource);
		facade.serializeCrossRef(bar, crossref, foo, linkTextRegion, status);
		assertTrue(status.getRefactoringStatus().hasError());
		RefactoringStatusEntry fatalError = status.getRefactoringStatus().getEntryAt(0);
		assertTrue(fatalError.getMessage().contains("cross-reference"));
		assertTrue(fatalError.getContext() instanceof FileStatusContext);
		assertEquals(file, ((FileStatusContext)fatalError.getContext()).getFile());
		IRegion contextRegion = ((FileStatusContext)fatalError.getContext()).getTextRegion();
		assertEquals(linkTextRegion.getOffset(), contextRegion.getOffset());
		assertEquals(linkTextRegion.getLength(), contextRegion.getLength());
	}

	static class TestableCrossReferenceSerializerFacade extends CrossReferenceSerializerFacade {
		@Override
		public void setSerializer(ISerializer serializer) {
			super.setSerializer(serializer);
		}
	}
}

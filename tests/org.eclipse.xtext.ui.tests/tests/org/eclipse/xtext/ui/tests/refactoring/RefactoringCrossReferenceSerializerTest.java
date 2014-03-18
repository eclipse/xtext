/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringCrossReferenceSerializer;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Element;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Main;
import org.eclipse.xtext.ui.tests.refactoring.services.RefactoringTestLanguageGrammarAccess;
import org.eclipse.xtext.util.TextRegion;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RefactoringCrossReferenceSerializerTest extends AbstractXtextTests {

	@Inject
	private RefactoringTestLanguageGrammarAccess grammarAccess;
	
	@Inject
	private RefactoringCrossReferenceSerializer facade;
	
	@Inject
	private StatusWrapper status;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		setInjector(Activator.getInstance().getInjector("org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage"));
		getInjector().injectMembers(this);
	}
	
	@Override
	public void tearDown() throws Exception {
		cleanWorkspace();
		super.tearDown();
	}
	
	@Test public void testSerializer() throws Exception {
		RefactoringCrossReferenceSerializer.RefTextEvaluator evaluator = new RefactoringCrossReferenceSerializer.RefTextEvaluator() {
			public boolean isValid(IEObjectDescription target) {
				return true;
			}
			
			public boolean isBetterThan(String newText, String currentText) {
				return newText.length() < currentText.length();
			}
		};
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
		String linkText = facade.getCrossRefText(bar, crossref, foo, evaluator, linkTextRegion, status);
		assertEquals(linkText, "foo");
		assertTrue(status.getRefactoringStatus().isOK());
		
		foo.setName("fooBar");
		resource.getCache().clear(resource);
		String linkText1 = facade.getCrossRefText(bar, crossref, foo, evaluator, linkTextRegion, status);
		assertEquals(linkText1, "fooBar");
		assertTrue(status.getRefactoringStatus().isOK());

		assertEquals(foo, ((Main) resource.getContents().get(0)).getElements().get(1));
		foo.setName("bar");
		resource.getCache().clear(resource);
		assertNull(facade.getCrossRefText(bar, crossref, foo, evaluator, linkTextRegion, status));
	}

}

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import junit.framework.TestCase;

import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.impl.OffsetCorrector;
import org.eclipse.xtext.util.ReplaceRegion;

/**
 * @author koehnlein - Initial contribution and API
 */
public class OffsetCorrectorTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testGrowDeclaringDocument() {
		IRefactoringDocument declarationDocument = new MockRefactoringDocument();
		ReplaceRegion declarationEdit = new ReplaceRegion(1, 2, "foo");
		OffsetCorrector offsetCorrector = new OffsetCorrector(declarationDocument, declarationEdit);
		assertEquals(0, offsetCorrector.oldToNew(declarationDocument, 0));
		assertEquals(1, offsetCorrector.oldToNew(declarationDocument, 1));
		assertEquals(4, offsetCorrector.oldToNew(declarationDocument, 3));
		assertEquals(0, offsetCorrector.newToOld(declarationDocument, 0));
		assertEquals(1, offsetCorrector.newToOld(declarationDocument, 1));
		assertEquals(3, offsetCorrector.newToOld(declarationDocument, 4));
	}

	public void testShrinkDeclaringDocument() {
		IRefactoringDocument declarationDocument = new MockRefactoringDocument();
		ReplaceRegion declarationEdit = new ReplaceRegion(1, 2, "f");
		OffsetCorrector offsetCorrector = new OffsetCorrector(declarationDocument, declarationEdit);
		assertEquals(0, offsetCorrector.oldToNew(declarationDocument, 0));
		assertEquals(1, offsetCorrector.oldToNew(declarationDocument, 1));
		assertEquals(2, offsetCorrector.oldToNew(declarationDocument, 3));
		assertEquals(0, offsetCorrector.newToOld(declarationDocument, 0));
		assertEquals(1, offsetCorrector.newToOld(declarationDocument, 1));
		assertEquals(3, offsetCorrector.newToOld(declarationDocument, 2));
	}

	public void testUnaffectedDocument() {
		IRefactoringDocument declarationDocument = new MockRefactoringDocument();
		ReplaceRegion declarationEdit = new ReplaceRegion(1, 2, "foo");
		OffsetCorrector offsetCorrector = new OffsetCorrector(declarationDocument, declarationEdit);
		IRefactoringDocument otherDocument = new MockRefactoringDocument();
		assertEquals(0, offsetCorrector.oldToNew(otherDocument, 0));
		assertEquals(1, offsetCorrector.oldToNew(otherDocument, 1));
		assertEquals(3, offsetCorrector.oldToNew(otherDocument, 3));
		assertEquals(0, offsetCorrector.newToOld(otherDocument, 0));
		assertEquals(1, offsetCorrector.newToOld(otherDocument, 1));
		assertEquals(5, offsetCorrector.newToOld(otherDocument, 5));		
	}
}

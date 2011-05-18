/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.jface.text.Document;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.DocumentChange;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.ui.refactoring.impl.DisplayChangeWrapper;
import org.eclipse.xtext.ui.refactoring.ui.ReplaceEditExtractor;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class ReplaceEditExtractorTest extends TestCase {

	private ReplaceEditExtractor replaceEditExtractor;
	private Document document;

	@Override
	protected void setUp() {
		replaceEditExtractor = new ReplaceEditExtractor();
		document = new Document();
	}
	
	public void testPlain() throws Exception {
		DocumentChange documentChange = new DocumentChange("foo", document);
		ReplaceEdit replaceEdit = new ReplaceEdit(0,0,"bar");
		documentChange.setEdit(replaceEdit);
		List<ReplaceEdit> replaceEdits = replaceEditExtractor.getReplaceEditsForDocument(documentChange, document);
		assertEquals(1, replaceEdits.size());
		assertEquals(replaceEdit, replaceEdits.get(0));
	}
	
	public void testWrongDocument() throws Exception {
		DocumentChange documentChange = new DocumentChange("foo", document);
		ReplaceEdit replaceEdit = new ReplaceEdit(0,0,"bar");
		documentChange.setEdit(replaceEdit);
		List<ReplaceEdit> replaceEdits = replaceEditExtractor.getReplaceEditsForDocument(documentChange, new Document());
		assertTrue(replaceEdits.isEmpty());
	}
	
	public void testWorngEdit() throws Exception {
		DocumentChange documentChange = new DocumentChange("foo", document);
		InsertEdit edit = new InsertEdit(0,"bar");
		documentChange.setEdit(edit);
		List<ReplaceEdit> replaceEdits = replaceEditExtractor.getReplaceEditsForDocument(documentChange, new Document());
		assertTrue(replaceEdits.isEmpty());
	}
	
	public void testCompositeChange() throws Exception {
		DocumentChange documentChange0 = new DocumentChange("foo", document);
		ReplaceEdit replaceEdit0 = new ReplaceEdit(0,0,"bar");
		documentChange0.setEdit(replaceEdit0);
		DocumentChange documentChange1 = new DocumentChange("foo1", document);
		ReplaceEdit replaceEdit1 = new ReplaceEdit(0,0,"barbaz");
		documentChange1.setEdit(replaceEdit1);
		CompositeChange compositeChange0 = new CompositeChange("baz");
		compositeChange0.add(documentChange0);
		CompositeChange compositeChange1 = new CompositeChange("foobar");
		compositeChange1.add(compositeChange0);
		compositeChange1.add(documentChange1);
		List<ReplaceEdit> replaceEdits = replaceEditExtractor.getReplaceEditsForDocument(compositeChange1, document);
		assertEquals(2, replaceEdits.size());
		assertTrue(replaceEdits.contains(replaceEdit0));
		assertTrue(replaceEdits.contains(replaceEdit1));
	}
	
	public void testDisplayWrapper() throws Exception {
		DocumentChange documentChange = new DocumentChange("foo", document);
		ReplaceEdit replaceEdit = new ReplaceEdit(0,0,"bar");
		documentChange.setEdit(replaceEdit);
		DisplayChangeWrapper wrapper = new DisplayChangeWrapper(documentChange);
		List<ReplaceEdit> replaceEdits = replaceEditExtractor.getReplaceEditsForDocument(wrapper, document);
		assertEquals(1, replaceEdits.size());
		assertEquals(replaceEdit, replaceEdits.get(0));
	}
	
}

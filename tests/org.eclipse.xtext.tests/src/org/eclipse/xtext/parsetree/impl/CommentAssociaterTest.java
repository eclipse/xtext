/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.impl.commentAssociation.Element;
import org.eclipse.xtext.parsetree.impl.commentAssociation.Model;
import org.eclipse.xtext.parsetree.reconstr.ICommentAssociater;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * @author koehnlein - Initial contribution and API
 */
public class CommentAssociaterTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(CommentAssociationTestLanguageStandaloneSetup.class);
	}

	public void testCommentAssociation() throws Exception {
		String textModel = "element x // comment post x\n" 
				+ "// comment pre y\n"
				+ "element /* comment inside y */ y // comment post y\n" 
				+ "// comment pre z\n" 
				+ "element z";
		Model model = (Model) getModel(textModel);
		Multimap<EObject, String> multimap = createModel2CommentMap(model);
		EList<Element> elements = model.getElements();
		Element x = elements.get(0);
		Element y = elements.get(1);
		Element z = elements.get(2);

		checkComments(multimap, x, "// comment post x\n");
		checkComments(multimap, y, "// comment pre y\n", "/* comment inside y */", "// comment post y\n");
		checkComments(multimap, z, "// comment pre z\n");

	}

	protected Multimap<EObject, String> createModel2CommentMap(Model model) {
		CompositeNode rootNode = NodeUtil.getRootNode(model);
		ICommentAssociater commentAssociater = getInjector().getInstance(ICommentAssociater.class);
		Map<LeafNode, EObject> map = commentAssociater.associateCommentsWithSemanticEObjects(model, Collections
				.singleton(rootNode));
		Multimap<EObject, String> multimap = Multimaps.newArrayListMultimap();
		for (Map.Entry<LeafNode, EObject> entry : map.entrySet()) {
			multimap.put(entry.getValue(), entry.getKey().getText());
		}
		return multimap;
	}

	public void testCommentAssociationWithAction() throws Exception {
		String textModel = "// comment pre x\n" 
				+ "element /* comment inside x */ x // comment post x\n"
				+ "// comment pre y\n" 
				+ "parent /* comment inside y */ y // comment post y\n" 
				+ "// comment pre z\n"
				+ "element z";

		Model model = (Model) getModel(textModel);
		Multimap<EObject, String> multimap = createModel2CommentMap(model);
		EList<Element> elements = model.getElements();
		Element y = elements.get(0);
		Element x = y.getChild();
		Element z = elements.get(1);

		checkComments(multimap, x, "// comment pre x\n", "/* comment inside x */", "// comment post x\n");
		checkComments(multimap, y, "// comment pre y\n", "/* comment inside y */", "// comment post y\n");
		checkComments(multimap, z, "// comment pre z\n");
	}

	private void checkComments(Multimap<EObject, String> multimap, EObject element, String... expectedComments) {
		Collection<String> comments = multimap.get(element);
		assertEquals(expectedComments.length, comments.size());
		for (String expectedComment : expectedComments) {
			assertTrue("missing comment " + expectedComment, comments.contains(expectedComment));
		}
	}
}

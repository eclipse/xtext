/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.language;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.ui.services.AbstractServiceTest;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Dennis Hübner
 */
public class ReferenceGrammarTest extends AbstractServiceTest {

	public void testParseNothing() throws Exception {
		EObject object = getModelForDefaultLanguage("").getRootASTElement();
		assertNull(object);
	}

	public void testParseGrammar() throws Exception {
		String model = "spielplatz 200 \"Peters Spielplatz\" {" + "    kind (soeren 7)" + "    kind (lennart 4)"
				+ "    kind (jonas 1)" + "    erwachsener (peter 33)" + "    erwachsener (anne 33)" + "}";
		EObject object = getModelForDefaultLanguage(model).getRootASTElement();
		assertNotNull(object);
		NodeAdapter adapter = (NodeAdapter) object.eAdapters().get(0);
		AbstractNode node = adapter.getParserNode();
		for (TreeIterator<EObject> allContents = node.eAllContents(); allContents.hasNext();) {
			AbstractNode subnode = (AbstractNode) allContents.next();
			System.out.println(subnode);
		}
		System.out.println("---");
		dumpEObject(object);

	}

	public void testParseBadGrammar() throws Exception {
		String badGrammar = "spielplatz ";
		IParseResult badParseResult = getModelForDefaultLanguage(badGrammar);
		assertNotNull(badParseResult);
		assertNotNull(badParseResult.getRootNode());
		assertNull(badParseResult.getRootASTElement());
	}

	private void dumpEObject(EObject object) {
		System.out.println(object);
		for (TreeIterator<EObject> allContents = object.eAllContents(); allContents.hasNext();) {
			EObject element = allContents.next();
			System.out.println(element);
			EList<EObject> contents = element.eContents();
			for (EObject object2 : contents) {
				dumpEObject(object2);
			}
		}
	}

}

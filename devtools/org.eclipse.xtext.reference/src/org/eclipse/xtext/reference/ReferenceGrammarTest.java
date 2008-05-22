/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference;

import junit.framework.TestCase;

import org.apache.tools.ant.filters.StringInputStream;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.NodeAdapter;
import org.eclipse.xtext.reference.parser.ReferenceGrammarASTFactory;
import org.eclipse.xtext.reference.parser.ReferenceGrammarParser;

/**
 * @author Peter Friese - Initial contribution and API
 *
 */
public class ReferenceGrammarTest extends TestCase {
	
	{
		ReferenceGrammarStandaloneSetup.doSetup();
	}
	
	ILanguageFacade f = LanguageFacadeFactory.getFacade(ReferenceGrammarLanguageFacade.LANGUAGE_ID);
	
	public void testParseNothing() throws Exception {
		EObject object = f.getParser().parse(new StringInputStream(""));
		assertNull(object);
	}
	
	public void testParseGrammar() {
		String grammar = 
			"spielplatz '200' {" +
			"    kind (soeren '7')" +
			"    kind (lennart '4')" +
			"    kind (jonas '1')" +
			"    erwachsener (peter '33')" + 
			"    erwachsener (anne '33')" + 
			"}";
		
		ReferenceGrammarParser parser = new ReferenceGrammarParser();
		EObject object = (EObject) parser.parse(new StringInputStream(grammar), new ReferenceGrammarASTFactory());
		NodeAdapter adapter = (NodeAdapter) object.eAdapters().get(0);
		AbstractNode node = adapter.getParserNode();
		for (TreeIterator allContents = node.eAllContents(); allContents.hasNext();) {
			AbstractNode subnode = (AbstractNode) allContents.next();
			System.out.println(subnode);
		}
		
		System.out.println("---");
		dumpEObject(object);
		
	}
	
	private void dumpEObject(EObject object) {
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

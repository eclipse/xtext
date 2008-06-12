/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.language;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseError;
import org.eclipse.xtext.parser.IParseErrorHandler;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.reference.ReferenceGrammarStandaloneSetup;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class ReferenceGrammarTest extends TestCase {

	{
	//	ReferenceGrammarStandaloneSetup.doSetup();
	}

	ILanguageDescriptor languageDescriptor = ReferenceGrammarStandaloneSetup.getLanguageDescriptor();

	public void testParseNothing() throws Exception {
		IParser parser = ServiceRegistry.getService(languageDescriptor, IParser.class);
		EObject object = parser.parse(new StringInputStream("")).getRootASTElement();
		assertNull(object);
	}

	public void testParseGrammar() {
		String grammar = "spielplatz 200 \"Peters Spielplatz\" {" + "    kind (soeren 7)" + "    kind (lennart 4)"
				+ "    kind (jonas 1)" + "    erwachsener (peter 33)" + "    erwachsener (anne 33)" + "}";
		IParser parser = ServiceRegistry.getService(languageDescriptor, IParser.class);
		IElementFactory elementFactory = ServiceRegistry.getService(languageDescriptor, IElementFactory.class);
		EObject object = (EObject) parser.parse(new StringInputStream(grammar), elementFactory).getRootASTElement();
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

	public void testParseBadGrammar() {
		IParser parser = ServiceRegistry.getService(languageDescriptor, IParser.class);
		IElementFactory elementFactory = ServiceRegistry.getService(languageDescriptor, IElementFactory.class);
		String badGrammar = "spielplatz ";
		IParseResult badParseResult = parser.parse(new StringInputStream(badGrammar), elementFactory,
				new IParseErrorHandler() {
					public void handleParserError(IParseError error) {
						System.out.println("ReferenceGrammarTest#.handleParserError(): " + error.getMessage());
					}
				});
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

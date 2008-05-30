/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.XtextGrammarTestASTFactory;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.tests.Invocation;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class XtextGrammarTest extends AbstractGeneratorTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextGrammarTestStandaloneSetup.doSetup();
		with(XtextGrammarTestStandaloneSetup.class);
	}
	
	public void testBootstrapping() throws Exception {
		List<Invocation> parse = getInvocations("generate foo 'bar' Foo : name=ID;");
		Iterator<Invocation> iter = parse.iterator();
		assertEquals("create(GeneratedMetamodel)", iter.next().toString());
		assertEquals("set(name,foo)", iter.next().toString());
		assertEquals("set(nsURI,'bar')", iter.next().toString());
		assertEquals("create(Grammar)", iter.next().toString());
		assertEquals("add(metamodelDeclarations,GeneratedMetamodel)", iter.next().toString());
		assertEquals("create(ParserRule)", iter.next().toString());
		assertEquals("set(name,Foo)", iter.next().toString());
		assertEquals("create(Assignment)", iter.next().toString());
		assertEquals("set(feature,name)", iter.next().toString());
		assertEquals("set(operator,=)", iter.next().toString());
		assertEquals("create(RuleCall)", iter.next().toString());
		assertEquals("set(name,ID)", iter.next().toString());
		assertEquals("set(terminal,RuleCall)", iter.next().toString());
		assertEquals("set(alternatives,Assignment)", iter.next().toString());
		assertEquals("add(parserRules,ParserRule)", iter.next().toString());
	}
	
	public void testInstantiate() throws Exception {
		EObject grammar = (EObject) getModel("generate foo 'bar' Foo : name=ID;", new XtextGrammarTestASTFactory());
		assertWithXtend("'Foo'","parserRules.first().name",grammar);
		assertWithXtend("'name'","parserRules.first().alternatives.feature",grammar);
	}
	
	public void testInstantiateXtextGrammar() throws Exception {
		InputStream bootGrammar = getClass().getClassLoader().getResourceAsStream(getClass().getName().replace('.','/')+".xtext");
		EObject grammar = (EObject) getModel(bootGrammar , new XtextGrammarTestASTFactory(),null);
		assertWithXtend("true","parserRules.select(e|e.name=='AbstractToken').first()!=null",grammar);
		assertWithXtend("'AbstractElement'","parserRules.select(e|e.name=='AbstractToken').first().type.name",grammar);
		XtextGrammarTestParseTreeConstructor foo = new XtextGrammarTestParseTreeConstructor();
		foo.update(grammar);
		System.out.println(foo.getText());
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
//				"xmi", new XMIResourceFactoryImpl());
//		Resource resource = new ResourceSetImpl().createResource(URI.createURI("foo.xmi"));
//		resource.getContents().add(grammar);
//		resource.save(null);
	}
	
	public void testSerialization() throws Exception {
		String model = "generate foo 'bar' Foo : ( 'stuff' '{' '}' STRING ) ? ;";
		EObject grammar = (EObject) getModel(model, new XtextGrammarTestASTFactory());
		XtextGrammarTestParseTreeConstructor ptc = new XtextGrammarTestParseTreeConstructor();
		ptc.update(grammar);
		assertEquals(model, ptc.getText());
	}

}

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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.eclipse.xtext.generator.tests.Invocation;
import org.eclipse.xtext.parser.XtextGrammarTestFactory;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.xtend.XtendFacade;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class XtextGrammarTest extends AbstractGeneratorTest {
	
	public void testBootstrapping() throws Exception {
		List<Invocation> parse = parse("generate foo 'bar' Foo : name=ID;");
		Iterator<Invocation> iter = parse.iterator();
		for (Invocation invocation : parse) {
			System.out.println(invocation);
		}
		assertEquals("create(GeneratedMetamodel)", iter.next().toString());
		assertEquals("set(name,[@2,9:11='foo',<4>,1:9])", iter.next().toString());
		assertEquals("set(nsURI,[@4,13:17=''bar'',<5>,1:13])", iter.next().toString());
		assertEquals("create(Grammar)", iter.next().toString());
		assertEquals("add(metamodelDeclarations,GeneratedMetamodel)", iter.next().toString());
		assertEquals("create(ParserRule)", iter.next().toString());
		assertEquals("set(name,[@6,19:21='Foo',<4>,1:19])", iter.next().toString());
		assertEquals("create(Assignment)", iter.next().toString());
		assertEquals("set(feature,[@10,25:28='name',<4>,1:25])", iter.next().toString());
		assertEquals("set(operator,[@11,29:29='=',<23>,1:29])", iter.next().toString());
		assertEquals("create(RuleCall)", iter.next().toString());
		assertEquals("set(name,[@12,30:31='ID',<4>,1:30])", iter.next().toString());
		assertEquals("set(terminal,RuleCall)", iter.next().toString());
		assertEquals("set(alternatives,Assignment)", iter.next().toString());
		assertEquals("add(parserRules,ParserRule)", iter.next().toString());
	}
	
	public void testInstantiate() throws Exception {
		EObject grammar = (EObject) parse("generate foo 'bar' Foo : name=ID;", new XtextGrammarTestFactory());
		assertWithXtend("'Foo'","parserRules.first().name",grammar);
		assertWithXtend("'name'","parserRules.first().alternatives.feature",grammar);
	}
	
	public void testInstantiateXtextGrammar() throws Exception {
		InputStream bootGrammar = getClass().getClassLoader().getResourceAsStream(getClass().getName().replace('.','/')+".xtext");
		EObject grammar = (EObject) parse(bootGrammar , new XtextGrammarTestFactory());
		assertWithXtend("true","parserRules.select(e|e.name=='AbstractToken').first()!=null",grammar);
		assertWithXtend("'AbstractElement'","parserRules.select(e|e.name=='AbstractToken').first().type.name",grammar);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
//				"xmi", new XMIResourceFactoryImpl());
//		Resource resource = new ResourceSetImpl().createResource(URI.createURI("foo.xmi"));
//		resource.getContents().add(grammar);
//		resource.save(null);
		
		
	}

	@Override
	protected XtendFacade getXtendFacade() {
		ExecutionContextImpl ctx = new ExecutionContextImpl();
		ctx.registerMetaModel(new EmfRegistryMetaModel() {
			@Override
			protected EPackage[] allPackages() {
				return new EPackage[]{XtextGrammarTestEPackageAccess.getXtextTestEPackage()};
			}
		});
		return XtendFacade.create(ctx);
	}
	
}

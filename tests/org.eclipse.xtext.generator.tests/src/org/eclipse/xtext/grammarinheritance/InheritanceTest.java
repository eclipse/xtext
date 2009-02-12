/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance;

import static org.eclipse.xtext.util.CollectionUtils.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.Function;

public class InheritanceTest extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		EPackage aMetamodel = EcoreUtil2.loadEPackage(
				"classpath:/org/eclipse/xtext/grammarinheritance/ametamodel.ecore",
				InheritanceTest.class.getClassLoader());
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/xtext/tests/grammarinheritance", aMetamodel);
		with(ConcreteTestLanguageStandaloneSetup.class);
	}

	public void testSimple() throws Exception {
		EObject model = getModel("model 23.34 : element A element B");
		assertEquals(23.34, invokeWithXtend("magicNumber", model));
		assertWithXtend("'A'", "elements.get(0).name", model);
		assertWithXtend("'B'", "elements.get(1).name", model);
	}

	public void testMetamodel() throws Exception {
		AbstractRule rule = GrammarUtil.findRuleForName(getGrammarAccess().getGrammar(), "OverridableParserRule2");
		assertNotNull("rule", rule);
		TypeRef ref = rule.getType();
		assertNotNull("ref", ref);
		final EClass clazz = (EClass) ref.getType();
		assertNotNull("class", clazz);
		assertEquals("AType2", clazz.getName());
		assertEquals(2, clazz.getESuperTypes().size());
		Set<String> expectedNames = new HashSet<String>(Arrays.asList(new String[]{"AType", "RootRule"}));
		Iterator<String> iter = map(clazz.getESuperTypes(), new Function<EClass, String>(){
			public String exec(EClass param) {
				return param.getName();
			}
		}).iterator();
		while(iter.hasNext()) {
			String name = iter.next();
			assertTrue("name = '" + name + "'", expectedNames.remove(name));
		}
		assertTrue(expectedNames.toString(), expectedNames.isEmpty());
	}
}

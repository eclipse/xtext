/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup
import org.eclipse.xtext.linking.langATestLanguage.Main
import org.eclipse.xtext.linking.services.LangATestLanguageGrammarAccess
import org.eclipse.xtext.resource.XtextResource
import org.junit.Test

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sebastian Zarnekow
 */
class GrammarUtilTest extends AbstractXtextTests {
	
	@Test def void testFindCurrentType_01() throws Exception {
		with(XtextStandaloneSetup)
		var String model = '''
			grammar myLang with org.eclipse.xtext.common.Terminals
			generate g 'http://1'
			Rule:
				Fragment;
			fragment Fragment*: name=ID;
		'''
		val r = getResourceFromString(model)
		val grammar = r.getContents().get(0) as Grammar
		val rule = grammar.rules.head
		val fragmentCall = rule.alternatives
		val currentType = GrammarUtil.findCurrentType(fragmentCall)
		assertEquals('Rule', currentType.name)
	}
	
	@Test def void testFindCurrentType_02() throws Exception {
		with(XtextStandaloneSetup)
		var String model = '''
			grammar myLang with org.eclipse.xtext.common.Terminals
			generate g 'http://1'
			Rule:
				Fragment;
			fragment Fragment: name=ID {SubRule.named=current};
		'''
		val r = getResourceFromString(model)
		val grammar = r.getContents().get(0) as Grammar
		val rule = grammar.rules.head
		val fragmentCall = rule.alternatives
		val currentType = GrammarUtil.findCurrentType(fragmentCall)
		assertEquals('SubRule', currentType.name)
	}
	
	@Test def void testFindCurrentType_03() throws Exception {
		with(XtextStandaloneSetup)
		var String model = '''
			grammar myLang with org.eclipse.xtext.common.Terminals
			generate g 'http://1'
			Rule:
				Fragment;
			fragment Fragment: name=ID SecondFragment;
			fragment SecondFragment: {SubRule.named=current} value=ID;
		'''
		val r = getResourceFromString(model)
		val grammar = r.getContents().get(0) as Grammar
		val rule = grammar.rules.head
		val fragmentCall = rule.alternatives
		val currentType = GrammarUtil.findCurrentType(fragmentCall)
		assertEquals('SubRule', currentType.name)
	}
	
	@Test def void testFindCurrentType_04() throws Exception {
		with(XtextStandaloneSetup)
		var String model = '''
			grammar myLang with org.eclipse.xtext.common.Terminals
			generate g 'http://1'
			Rule:
				Fragment;
			fragment Fragment: name=ID SecondFragment?;
			fragment SecondFragment: {SubRule.named=current} value=ID;
		'''
		val r = getResourceFromString(model)
		val grammar = r.getContents().get(0) as Grammar
		val rule = grammar.rules.head
		val fragmentCall = rule.alternatives
		val currentType = GrammarUtil.findCurrentType(fragmentCall)
		assertEquals('Rule', currentType.name)
	}
	
	@Test def void testAllRules() throws Exception {
		with(XtextStandaloneSetup)
		var String model = '''
			grammar myLang with org.eclipse.xtext.common.Terminals
			generate g 'http://1'
			Rule:
				name=super::STRING;
			terminal STRING: '"';
		'''
		val r = getResourceFromString(model)
		val grammar = r.getContents().get(0) as Grammar
		val allRules = GrammarUtil.allRules(grammar);
		// order is crucial for terminal rules
		assertEquals(
			#['Rule', 'STRING', 'ID', 'INT', 'STRING', 'ML_COMMENT', 'SL_COMMENT', 'WS', 'ANY_OTHER'].toString,
			allRules.map[ name ].toString 
		)
	}
	
	@Test def void testFindRuleByName() throws Exception {
		with(XtextStandaloneSetup)
		var String model = '''
			grammar myLang with org.eclipse.xtext.common.Terminals
			generate g 'http://1'
			Rule:
				name=ID;
			terminal STRING: '"';
		'''
		var r = getResourceFromString(model)
		var grammar = r.getContents().get(0) as Grammar
		assertEquals(grammar, GrammarUtil.findRuleForName(grammar, 'Rule').eContainer)
		assertNull(GrammarUtil.findRuleForName(grammar, 'org.eclipse.xtext.common.Terminals.Rule'))
		assertEquals(grammar.usedGrammars.head, GrammarUtil.findRuleForName(grammar, 'ID').eContainer)
		assertEquals(grammar, GrammarUtil.findRuleForName(grammar, 'STRING').eContainer)
		assertEquals(grammar.usedGrammars.head, GrammarUtil.findRuleForName(grammar, 'org.eclipse.xtext.common.Terminals.STRING').eContainer)
	}
	
	@Test def void testAllMetamodelDeclarations_01() throws Exception {
		with(XtextStandaloneSetup)
		var String model = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			import 'http://www.eclipse.org/emf/2002/Ecore' as ecore
			generate g 'http://3' as ecore
			startrule returns ecore::startrule: name=ID;
		'''
		var Resource r = getResourceFromString(model)
		var Grammar g = r.getContents().get(0) as Grammar
		var List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g)
		// ecore as ecore
		// g as ecore
		// inherited ecore as ecore == ecore as bar
		assertEquals(2, decls.size())
		var AbstractMetamodelDeclaration decl = decls.get(0)
		assertTrue(decl instanceof ReferencedMetamodel)
		assertNotNull(decl.getEPackage())
		assertEquals("http://www.eclipse.org/emf/2002/Ecore", decl.getEPackage().getNsURI())
		assertEquals("ecore", decl.getAlias())
		decl = decls.get(1)
		assertEquals("ecore", decl.getAlias())
		assertNotNull(decl.getEPackage())
		assertEquals("http://3", decl.getEPackage().getNsURI())
	}

	@Test def void testAllMetamodelDeclarations_02() throws Exception {
		with(XtextStandaloneSetup)
		var String model = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			import 'http://www.eclipse.org/emf/2002/Ecore' as bar
			generate g 'http://3' as bar
			startrule returns bar::startrule: name=ID;
		'''
		var Resource r = getResourceFromString(model)
		var Grammar g = r.getContents().get(0) as Grammar
		var List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g)
		// ecore as bar
		// g as bar
		// inherited ecore as ecore != ecore as bar
		assertEquals(3, decls.size())
		var AbstractMetamodelDeclaration decl = decls.get(0)
		assertTrue(decl instanceof ReferencedMetamodel)
		assertNotNull(decl.getEPackage())
		assertEquals("http://www.eclipse.org/emf/2002/Ecore", decl.getEPackage().getNsURI())
		assertEquals("bar", decl.getAlias())
		decl = decls.get(1)
		assertEquals("bar", decl.getAlias())
		assertNotNull(decl.getEPackage())
		assertEquals("http://3", decl.getEPackage().getNsURI())
		decl = decls.get(2)
		assertTrue(decl instanceof ReferencedMetamodel)
		assertNotNull(decl.getEPackage())
		assertEquals("http://www.eclipse.org/emf/2002/Ecore", decl.getEPackage().getNsURI())
		assertEquals("ecore", decl.getAlias())
		var AbstractRule abstractRule = g.getRules().get(0)
		assertSame(decls.get(1), abstractRule.getType().getMetamodel())
	}

	@Test def void testAllMetamodelDeclarations_03() throws Exception {
		with(XtextStandaloneSetup)
		var String model = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			generate g 'http://3' as bar
			import 'http://www.eclipse.org/emf/2002/Ecore' as bar
			startrule returns bar::startrule: name=ID;
		'''
		var Resource r = getResourceFromString(model)
		var Grammar g = r.getContents().get(0) as Grammar
		var List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g)
		// ecore as bar
		// g as bar
		// inherited ecore as ecore != ecore as bar
		assertEquals(3, decls.size())
		var AbstractMetamodelDeclaration decl = decls.get(0)
		assertTrue(decl instanceof GeneratedMetamodel)
		assertEquals("bar", decl.getAlias())
		assertNotNull(decl.getEPackage())
		assertEquals("http://3", decl.getEPackage().getNsURI())
		decl = decls.get(1)
		assertTrue(decl instanceof ReferencedMetamodel)
		assertNotNull(decl.getEPackage())
		assertEquals("http://www.eclipse.org/emf/2002/Ecore", decl.getEPackage().getNsURI())
		assertEquals("bar", decl.getAlias())
		decl = decls.get(2)
		assertTrue(decl instanceof ReferencedMetamodel)
		assertNotNull(decl.getEPackage())
		assertEquals("http://www.eclipse.org/emf/2002/Ecore", decl.getEPackage().getNsURI())
		assertEquals("ecore", decl.getAlias())
		var AbstractRule abstractRule = g.getRules().get(0)
		assertSame(decls.get(0), abstractRule.getType().getMetamodel())
	}

	@Test def void testGetReference() throws Exception {
		with(LangATestLanguageStandaloneSetup)
		var XtextResource resource = getResourceFromStringAndExpect("type A extends B", 1)
		var Assignment asExtends = get(LangATestLanguageGrammarAccess).getTypeAccess().getExtendsAssignment_2_1()
		var CrossReference xref = asExtends.getTerminal() as CrossReference
		var Main model = getModel(resource) as Main
		var EObject typeA = model.getTypes().get(0)
		var EReference ref = GrammarUtil.getReference(xref, typeA.eClass())
		assertNotNull(ref)
		assertEquals("extends", ref.getName())
		assertFalse(ref.isMany())
		assertEquals(typeA.eClass(), ref.getEReferenceType())
	}

}

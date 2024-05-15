/**
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.Main;
import org.eclipse.xtext.linking.services.LangATestLanguageGrammarAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class GrammarUtilTest extends AbstractXtextTests {
	@Test
	public void testFindCurrentType_01() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = 
				"grammar myLang with org.eclipse.xtext.common.Terminals\n" +
				"generate g 'http://1'\n" +
				"Rule:\n" +
				"	Fragment;\n" +
				"fragment Fragment*: name=ID;\n";
		XtextResource r = getResourceFromString(model);
		Grammar grammar = (Grammar) r.getContents().get(0);
		AbstractRule rule = Iterables.getFirst(grammar.getRules(), null);
		AbstractElement fragmentCall = rule.getAlternatives();
		EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
		Assert.assertEquals("Rule", currentType.getName());
	}

	@Test
	public void testFindCurrentType_02() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = 
				"grammar myLang with org.eclipse.xtext.common.Terminals\n" +
				"generate g 'http://1'\n" +
				"Rule:\n" +
				"	Fragment;\n" +
				"fragment Fragment: name=ID {SubRule.named=current};\n";
		XtextResource r = getResourceFromString(model);
		Grammar grammar = (Grammar) r.getContents().get(0);
		AbstractRule rule = Iterables.getFirst(grammar.getRules(), null);
		AbstractElement fragmentCall = rule.getAlternatives();
		EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
		Assert.assertEquals("SubRule", currentType.getName());
	}

	@Test
	public void testFindCurrentType_03() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = 
				"grammar myLang with org.eclipse.xtext.common.Terminals\n" +
				"generate g 'http://1'\n" +
				"Rule:\n" +
				"	Fragment;\n" +
				"fragment Fragment: name=ID SecondFragment;\n" +
				"fragment SecondFragment: {SubRule.named=current} value=ID;\n";
		XtextResource r = getResourceFromString(model);
		Grammar grammar = (Grammar) r.getContents().get(0);
		AbstractRule rule = Iterables.getFirst(grammar.getRules(), null);
		AbstractElement fragmentCall = rule.getAlternatives();
		EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
		Assert.assertEquals("SubRule", currentType.getName());
	}

	@Test
	public void testFindCurrentType_04() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = 
				"grammar myLang with org.eclipse.xtext.common.Terminals\n" +
				"generate g 'http://1'\n" +
				"Rule:\n" +
				"	Fragment;\n" +
				"fragment Fragment: name=ID SecondFragment?;\n" +
				"fragment SecondFragment: {SubRule.named=current} value=ID;\n";
		XtextResource r = getResourceFromString(model);
		Grammar grammar = (Grammar) r.getContents().get(0);
		AbstractRule rule = Iterables.getFirst(grammar.getRules(), null);
		AbstractElement fragmentCall = rule.getAlternatives();
		EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
		Assert.assertEquals("Rule", currentType.getName());
	}

	@Test
	public void testFindCurrentType_05() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = 
				"grammar myLang with org.eclipse.xtext.common.Terminals\n" +
				"generate g 'http://1'\n" +
				"Rule:\n" +
				"	Fragment;\n" +
				"fragment Fragment returns Rule:\n" +
				"    name=ID Fragment?\n" +
				";\n";
		XtextResource r = getResourceFromString(model);
		Grammar grammar = (Grammar) r.getContents().get(0);
		AbstractRule rule = Iterables.getFirst(grammar.getRules(), null);
		AbstractElement fragmentCall = rule.getAlternatives();
		EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
		Assert.assertEquals("Rule", currentType.getName());
	}

	@Test
	public void testFindCurrentType_06() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = 
				"grammar myLang with org.eclipse.xtext.common.Terminals\n" +
				"generate g 'http://1'\n" +
				"Rule:\n" +
				"	Fragment;\n" +
				"fragment Fragment returns Rule:\n" +
				"    name=ID Fragment?\n" +
				";\n";
		XtextResource r = getResourceFromString(model);
		Grammar grammar = (Grammar) r.getContents().get(0);
		AbstractRule rule = Iterables.getLast(grammar.getRules());
		AbstractElement fragmentCall = Iterables.getLast(((Group) rule.getAlternatives()).getElements());
		EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
		Assert.assertEquals("Rule", currentType.getName());
	}

	@Test
	public void testAllRules() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = 
				"grammar myLang with org.eclipse.xtext.common.Terminals\n" +
				"generate g 'http://1'\n" +
				"Rule:\n" +
				"	name=super::STRING;\n" +
				"terminal STRING: '\"';\n";
		XtextResource r = getResourceFromString(model);
		Grammar grammar = (Grammar) r.getContents().get(0);
		List<AbstractRule> allRules = GrammarUtil.allRules(grammar);
		// order is crucial for terminal rules
		Assert.assertEquals(
				Lists.<String>newArrayList("Rule", "STRING", "ID", "INT", "STRING", "ML_COMMENT", "SL_COMMENT", "WS",
						"ANY_OTHER").toString(),
				ListExtensions.<AbstractRule, String>map(allRules, AbstractRule::getName).toString());
	}

	@Test
	public void testFindRuleByName() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = 
				"grammar myLang with org.eclipse.xtext.common.Terminals\n" +
				"generate g 'http://1'\n" +
				"Rule:\n" +
				"	name=ID;\n" +
				"terminal STRING: '\"';\n";
		XtextResource r = getResourceFromString(model);
		Grammar grammar = (Grammar) r.getContents().get(0);
		Assert.assertEquals(grammar, GrammarUtil.findRuleForName(grammar, "Rule").eContainer());
		Assert.assertNull(GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.Rule"));
		Assert.assertEquals(Iterables.<Grammar>getFirst(grammar.getUsedGrammars(), null),
				GrammarUtil.findRuleForName(grammar, "ID").eContainer());
		Assert.assertEquals(grammar, GrammarUtil.findRuleForName(grammar, "STRING").eContainer());
		Assert.assertEquals(Iterables.<Grammar>getFirst(grammar.getUsedGrammars(), null),
				GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.STRING").eContainer());
	}

	@Test
	public void testAllMetamodelDeclarations_01() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = 
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
				"generate g 'http://3' as ecore\n" +
				"startrule returns ecore::startrule: name=ID;\n";
		Resource r = getResourceFromString(model);
		Grammar g = (Grammar) r.getContents().get(0);
		List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g);
		// ecore as ecore
		// g as ecore
		// inherited ecore as ecore == ecore as bar
		Assert.assertEquals(2, decls.size());
		AbstractMetamodelDeclaration decl = decls.get(0);
		Assert.assertTrue((decl instanceof ReferencedMetamodel));
		Assert.assertNotNull(decl.getEPackage());
		Assert.assertEquals("http://www.eclipse.org/emf/2002/Ecore", decl.getEPackage().getNsURI());
		Assert.assertEquals("ecore", decl.getAlias());
		decl = decls.get(1);
		Assert.assertEquals("ecore", decl.getAlias());
		Assert.assertNotNull(decl.getEPackage());
		Assert.assertEquals("http://3", decl.getEPackage().getNsURI());
	}

	@Test
	public void testAllMetamodelDeclarations_02() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = 
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as bar\n" +
				"generate g 'http://3' as bar\n" +
				"startrule returns bar::startrule: name=ID;\n";
		Resource r = getResourceFromString(model);
		Grammar g = (Grammar) r.getContents().get(0);
		List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g);
		// ecore as bar
		// g as bar
		// inherited ecore as ecore != ecore as bar
		Assert.assertEquals(3, decls.size());
		AbstractMetamodelDeclaration decl = decls.get(0);
		Assert.assertTrue((decl instanceof ReferencedMetamodel));
		Assert.assertNotNull(decl.getEPackage());
		Assert.assertEquals("http://www.eclipse.org/emf/2002/Ecore", decl.getEPackage().getNsURI());
		Assert.assertEquals("bar", decl.getAlias());
		decl = decls.get(1);
		Assert.assertEquals("bar", decl.getAlias());
		Assert.assertNotNull(decl.getEPackage());
		Assert.assertEquals("http://3", decl.getEPackage().getNsURI());
		decl = decls.get(2);
		Assert.assertTrue((decl instanceof ReferencedMetamodel));
		Assert.assertNotNull(decl.getEPackage());
		Assert.assertEquals("http://www.eclipse.org/emf/2002/Ecore", decl.getEPackage().getNsURI());
		Assert.assertEquals("ecore", decl.getAlias());
		AbstractRule abstractRule = g.getRules().get(0);
		Assert.assertSame(decls.get(1), abstractRule.getType().getMetamodel());
	}

	@Test
	public void testAllMetamodelDeclarations_03() throws Exception {
		with(XtextStandaloneSetup.class);
		String model = 
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"generate g 'http://3' as bar\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as bar\n" +
				"startrule returns bar::startrule: name=ID;\n";
		Resource r = getResourceFromString(model);
		Grammar g = (Grammar) r.getContents().get(0);
		List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g);
		// ecore as bar
		// g as bar
		// inherited ecore as ecore != ecore as bar

		Assert.assertEquals(3, decls.size());
		AbstractMetamodelDeclaration decl = decls.get(0);
		Assert.assertTrue((decl instanceof GeneratedMetamodel));
		Assert.assertEquals("bar", decl.getAlias());
		Assert.assertNotNull(decl.getEPackage());
		Assert.assertEquals("http://3", decl.getEPackage().getNsURI());
		decl = decls.get(1);
		Assert.assertTrue((decl instanceof ReferencedMetamodel));
		Assert.assertNotNull(decl.getEPackage());
		Assert.assertEquals("http://www.eclipse.org/emf/2002/Ecore", decl.getEPackage().getNsURI());
		Assert.assertEquals("bar", decl.getAlias());
		decl = decls.get(2);
		Assert.assertTrue((decl instanceof ReferencedMetamodel));
		Assert.assertNotNull(decl.getEPackage());
		Assert.assertEquals("http://www.eclipse.org/emf/2002/Ecore", decl.getEPackage().getNsURI());
		Assert.assertEquals("ecore", decl.getAlias());
		AbstractRule abstractRule = g.getRules().get(0);
		Assert.assertSame(decls.get(0), abstractRule.getType().getMetamodel());
	}

	@Test
	public void testGetReference() throws Exception {
		with(LangATestLanguageStandaloneSetup.class);
		XtextResource resource = getResourceFromStringAndExpect("type A extends B", 1);
		Assignment asExtends = get(LangATestLanguageGrammarAccess.class)
				.getTypeAccess().getExtendsAssignment_2_1();
		CrossReference xref = (CrossReference) asExtends.getTerminal();
		Main model = (Main) getModel(resource);
		EObject typeA = model.getTypes().get(0);
		EReference ref = GrammarUtil.getReference(xref, typeA.eClass());
		Assert.assertNotNull(ref);
		Assert.assertEquals("extends", ref.getName());
		Assert.assertFalse(ref.isMany());
		Assert.assertEquals(typeA.eClass(), ref.getEReferenceType());
	}
}

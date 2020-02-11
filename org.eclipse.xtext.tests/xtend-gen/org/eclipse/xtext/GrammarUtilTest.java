/**
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext;

import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.Main;
import org.eclipse.xtext.linking.services.LangATestLanguageGrammarAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class GrammarUtilTest extends AbstractXtextTests {
  @Test
  public void testFindCurrentType_01() throws Exception {
    this.with(XtextStandaloneSetup.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar myLang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate g \'http://1\'");
    _builder.newLine();
    _builder.append("Rule:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Fragment;");
    _builder.newLine();
    _builder.append("fragment Fragment*: name=ID;");
    _builder.newLine();
    String model = _builder.toString();
    final XtextResource r = this.getResourceFromString(model);
    EObject _get = r.getContents().get(0);
    final Grammar grammar = ((Grammar) _get);
    final AbstractRule rule = IterableExtensions.<AbstractRule>head(grammar.getRules());
    final AbstractElement fragmentCall = rule.getAlternatives();
    final EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
    Assert.assertEquals("Rule", currentType.getName());
  }
  
  @Test
  public void testFindCurrentType_02() throws Exception {
    this.with(XtextStandaloneSetup.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar myLang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate g \'http://1\'");
    _builder.newLine();
    _builder.append("Rule:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Fragment;");
    _builder.newLine();
    _builder.append("fragment Fragment: name=ID {SubRule.named=current};");
    _builder.newLine();
    String model = _builder.toString();
    final XtextResource r = this.getResourceFromString(model);
    EObject _get = r.getContents().get(0);
    final Grammar grammar = ((Grammar) _get);
    final AbstractRule rule = IterableExtensions.<AbstractRule>head(grammar.getRules());
    final AbstractElement fragmentCall = rule.getAlternatives();
    final EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
    Assert.assertEquals("SubRule", currentType.getName());
  }
  
  @Test
  public void testFindCurrentType_03() throws Exception {
    this.with(XtextStandaloneSetup.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar myLang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate g \'http://1\'");
    _builder.newLine();
    _builder.append("Rule:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Fragment;");
    _builder.newLine();
    _builder.append("fragment Fragment: name=ID SecondFragment;");
    _builder.newLine();
    _builder.append("fragment SecondFragment: {SubRule.named=current} value=ID;");
    _builder.newLine();
    String model = _builder.toString();
    final XtextResource r = this.getResourceFromString(model);
    EObject _get = r.getContents().get(0);
    final Grammar grammar = ((Grammar) _get);
    final AbstractRule rule = IterableExtensions.<AbstractRule>head(grammar.getRules());
    final AbstractElement fragmentCall = rule.getAlternatives();
    final EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
    Assert.assertEquals("SubRule", currentType.getName());
  }
  
  @Test
  public void testFindCurrentType_04() throws Exception {
    this.with(XtextStandaloneSetup.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar myLang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate g \'http://1\'");
    _builder.newLine();
    _builder.append("Rule:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Fragment;");
    _builder.newLine();
    _builder.append("fragment Fragment: name=ID SecondFragment?;");
    _builder.newLine();
    _builder.append("fragment SecondFragment: {SubRule.named=current} value=ID;");
    _builder.newLine();
    String model = _builder.toString();
    final XtextResource r = this.getResourceFromString(model);
    EObject _get = r.getContents().get(0);
    final Grammar grammar = ((Grammar) _get);
    final AbstractRule rule = IterableExtensions.<AbstractRule>head(grammar.getRules());
    final AbstractElement fragmentCall = rule.getAlternatives();
    final EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
    Assert.assertEquals("Rule", currentType.getName());
  }
  
  @Test
  public void testFindCurrentType_05() throws Exception {
    this.with(XtextStandaloneSetup.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar myLang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate g \'http://1\'");
    _builder.newLine();
    _builder.append("Rule:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Fragment;");
    _builder.newLine();
    _builder.append("fragment Fragment returns Rule:");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("name=ID Fragment?");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    String model = _builder.toString();
    final XtextResource r = this.getResourceFromString(model);
    EObject _get = r.getContents().get(0);
    final Grammar grammar = ((Grammar) _get);
    final AbstractRule rule = IterableExtensions.<AbstractRule>head(grammar.getRules());
    final AbstractElement fragmentCall = rule.getAlternatives();
    final EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
    Assert.assertEquals("Rule", currentType.getName());
  }
  
  @Test
  public void testFindCurrentType_06() throws Exception {
    this.with(XtextStandaloneSetup.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar myLang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate g \'http://1\'");
    _builder.newLine();
    _builder.append("Rule:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Fragment;");
    _builder.newLine();
    _builder.append("fragment Fragment returns Rule:");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("name=ID Fragment?");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    String model = _builder.toString();
    final XtextResource r = this.getResourceFromString(model);
    EObject _get = r.getContents().get(0);
    final Grammar grammar = ((Grammar) _get);
    final AbstractRule rule = IterableExtensions.<AbstractRule>last(grammar.getRules());
    AbstractElement _alternatives = rule.getAlternatives();
    final AbstractElement fragmentCall = IterableExtensions.<AbstractElement>last(((Group) _alternatives).getElements());
    final EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
    Assert.assertEquals("Rule", currentType.getName());
  }
  
  @Test
  public void testAllRules() throws Exception {
    this.with(XtextStandaloneSetup.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar myLang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate g \'http://1\'");
    _builder.newLine();
    _builder.append("Rule:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name=super::STRING;");
    _builder.newLine();
    _builder.append("terminal STRING: \'\"\';");
    _builder.newLine();
    String model = _builder.toString();
    final XtextResource r = this.getResourceFromString(model);
    EObject _get = r.getContents().get(0);
    final Grammar grammar = ((Grammar) _get);
    final List<AbstractRule> allRules = GrammarUtil.allRules(grammar);
    final Function1<AbstractRule, String> _function = (AbstractRule it) -> {
      return it.getName();
    };
    Assert.assertEquals(
      Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Rule", "STRING", "ID", "INT", "STRING", "ML_COMMENT", "SL_COMMENT", "WS", "ANY_OTHER")).toString(), 
      ListExtensions.<AbstractRule, String>map(allRules, _function).toString());
  }
  
  @Test
  public void testFindRuleByName() throws Exception {
    this.with(XtextStandaloneSetup.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar myLang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate g \'http://1\'");
    _builder.newLine();
    _builder.append("Rule:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name=ID;");
    _builder.newLine();
    _builder.append("terminal STRING: \'\"\';");
    _builder.newLine();
    String model = _builder.toString();
    XtextResource r = this.getResourceFromString(model);
    EObject _get = r.getContents().get(0);
    Grammar grammar = ((Grammar) _get);
    Assert.assertEquals(grammar, GrammarUtil.findRuleForName(grammar, "Rule").eContainer());
    Assert.assertNull(GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.Rule"));
    Assert.assertEquals(IterableExtensions.<Grammar>head(grammar.getUsedGrammars()), GrammarUtil.findRuleForName(grammar, "ID").eContainer());
    Assert.assertEquals(grammar, GrammarUtil.findRuleForName(grammar, "STRING").eContainer());
    Assert.assertEquals(IterableExtensions.<Grammar>head(grammar.getUsedGrammars()), GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.STRING").eContainer());
  }
  
  @Test
  public void testAllMetamodelDeclarations_01() throws Exception {
    this.with(XtextStandaloneSetup.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/emf/2002/Ecore\' as ecore");
    _builder.newLine();
    _builder.append("generate g \'http://3\' as ecore");
    _builder.newLine();
    _builder.append("startrule returns ecore::startrule: name=ID;");
    _builder.newLine();
    String model = _builder.toString();
    Resource r = this.getResourceFromString(model);
    EObject _get = r.getContents().get(0);
    Grammar g = ((Grammar) _get);
    List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g);
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
    this.with(XtextStandaloneSetup.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/emf/2002/Ecore\' as bar");
    _builder.newLine();
    _builder.append("generate g \'http://3\' as bar");
    _builder.newLine();
    _builder.append("startrule returns bar::startrule: name=ID;");
    _builder.newLine();
    String model = _builder.toString();
    Resource r = this.getResourceFromString(model);
    EObject _get = r.getContents().get(0);
    Grammar g = ((Grammar) _get);
    List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g);
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
    this.with(XtextStandaloneSetup.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate g \'http://3\' as bar");
    _builder.newLine();
    _builder.append("import \'http://www.eclipse.org/emf/2002/Ecore\' as bar");
    _builder.newLine();
    _builder.append("startrule returns bar::startrule: name=ID;");
    _builder.newLine();
    String model = _builder.toString();
    Resource r = this.getResourceFromString(model);
    EObject _get = r.getContents().get(0);
    Grammar g = ((Grammar) _get);
    List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g);
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
    this.with(LangATestLanguageStandaloneSetup.class);
    XtextResource resource = this.getResourceFromStringAndExpect("type A extends B", 1);
    Assignment asExtends = this.<LangATestLanguageGrammarAccess>get(LangATestLanguageGrammarAccess.class).getTypeAccess().getExtendsAssignment_2_1();
    AbstractElement _terminal = asExtends.getTerminal();
    CrossReference xref = ((CrossReference) _terminal);
    EObject _model = this.getModel(resource);
    Main model = ((Main) _model);
    EObject typeA = model.getTypes().get(0);
    EReference ref = GrammarUtil.getReference(xref, typeA.eClass());
    Assert.assertNotNull(ref);
    Assert.assertEquals("extends", ref.getName());
    Assert.assertFalse(ref.isMany());
    Assert.assertEquals(typeA.eClass(), ref.getEReferenceType());
  }
}

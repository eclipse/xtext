/**
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext;

import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
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
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.Main;
import org.eclipse.xtext.linking.langATestLanguage.Type;
import org.eclipse.xtext.linking.services.LangATestLanguageGrammarAccess;
import org.eclipse.xtext.resource.XtextResource;
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
    EList<EObject> _contents = r.getContents();
    EObject _get = _contents.get(0);
    final Grammar grammar = ((Grammar) _get);
    EList<AbstractRule> _rules = grammar.getRules();
    final AbstractRule rule = IterableExtensions.<AbstractRule>head(_rules);
    final AbstractElement fragmentCall = rule.getAlternatives();
    final EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
    String _name = currentType.getName();
    Assert.assertEquals("Rule", _name);
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
    EList<EObject> _contents = r.getContents();
    EObject _get = _contents.get(0);
    final Grammar grammar = ((Grammar) _get);
    EList<AbstractRule> _rules = grammar.getRules();
    final AbstractRule rule = IterableExtensions.<AbstractRule>head(_rules);
    final AbstractElement fragmentCall = rule.getAlternatives();
    final EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
    String _name = currentType.getName();
    Assert.assertEquals("SubRule", _name);
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
    EList<EObject> _contents = r.getContents();
    EObject _get = _contents.get(0);
    final Grammar grammar = ((Grammar) _get);
    EList<AbstractRule> _rules = grammar.getRules();
    final AbstractRule rule = IterableExtensions.<AbstractRule>head(_rules);
    final AbstractElement fragmentCall = rule.getAlternatives();
    final EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
    String _name = currentType.getName();
    Assert.assertEquals("SubRule", _name);
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
    EList<EObject> _contents = r.getContents();
    EObject _get = _contents.get(0);
    final Grammar grammar = ((Grammar) _get);
    EList<AbstractRule> _rules = grammar.getRules();
    final AbstractRule rule = IterableExtensions.<AbstractRule>head(_rules);
    final AbstractElement fragmentCall = rule.getAlternatives();
    final EClassifier currentType = GrammarUtil.findCurrentType(fragmentCall);
    String _name = currentType.getName();
    Assert.assertEquals("Rule", _name);
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
    EList<EObject> _contents = r.getContents();
    EObject _get = _contents.get(0);
    final Grammar grammar = ((Grammar) _get);
    final List<AbstractRule> allRules = GrammarUtil.allRules(grammar);
    String _string = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Rule", "STRING", "ID", "INT", "STRING", "ML_COMMENT", "SL_COMMENT", "WS", "ANY_OTHER")).toString();
    final Function1<AbstractRule, String> _function = new Function1<AbstractRule, String>() {
      @Override
      public String apply(final AbstractRule it) {
        return it.getName();
      }
    };
    List<String> _map = ListExtensions.<AbstractRule, String>map(allRules, _function);
    String _string_1 = _map.toString();
    Assert.assertEquals(_string, _string_1);
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
    EList<EObject> _contents = r.getContents();
    EObject _get = _contents.get(0);
    Grammar grammar = ((Grammar) _get);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Rule");
    EObject _eContainer = _findRuleForName.eContainer();
    Assert.assertEquals(grammar, _eContainer);
    AbstractRule _findRuleForName_1 = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.Rule");
    Assert.assertNull(_findRuleForName_1);
    EList<Grammar> _usedGrammars = grammar.getUsedGrammars();
    Grammar _head = IterableExtensions.<Grammar>head(_usedGrammars);
    AbstractRule _findRuleForName_2 = GrammarUtil.findRuleForName(grammar, "ID");
    EObject _eContainer_1 = _findRuleForName_2.eContainer();
    Assert.assertEquals(_head, _eContainer_1);
    AbstractRule _findRuleForName_3 = GrammarUtil.findRuleForName(grammar, "STRING");
    EObject _eContainer_2 = _findRuleForName_3.eContainer();
    Assert.assertEquals(grammar, _eContainer_2);
    EList<Grammar> _usedGrammars_1 = grammar.getUsedGrammars();
    Grammar _head_1 = IterableExtensions.<Grammar>head(_usedGrammars_1);
    AbstractRule _findRuleForName_4 = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.STRING");
    EObject _eContainer_3 = _findRuleForName_4.eContainer();
    Assert.assertEquals(_head_1, _eContainer_3);
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
    EList<EObject> _contents = r.getContents();
    EObject _get = _contents.get(0);
    Grammar g = ((Grammar) _get);
    List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g);
    int _size = decls.size();
    Assert.assertEquals(2, _size);
    AbstractMetamodelDeclaration decl = decls.get(0);
    Assert.assertTrue((decl instanceof ReferencedMetamodel));
    EPackage _ePackage = decl.getEPackage();
    Assert.assertNotNull(_ePackage);
    EPackage _ePackage_1 = decl.getEPackage();
    String _nsURI = _ePackage_1.getNsURI();
    Assert.assertEquals("http://www.eclipse.org/emf/2002/Ecore", _nsURI);
    String _alias = decl.getAlias();
    Assert.assertEquals("ecore", _alias);
    AbstractMetamodelDeclaration _get_1 = decls.get(1);
    decl = _get_1;
    String _alias_1 = decl.getAlias();
    Assert.assertEquals("ecore", _alias_1);
    EPackage _ePackage_2 = decl.getEPackage();
    Assert.assertNotNull(_ePackage_2);
    EPackage _ePackage_3 = decl.getEPackage();
    String _nsURI_1 = _ePackage_3.getNsURI();
    Assert.assertEquals("http://3", _nsURI_1);
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
    EList<EObject> _contents = r.getContents();
    EObject _get = _contents.get(0);
    Grammar g = ((Grammar) _get);
    List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g);
    int _size = decls.size();
    Assert.assertEquals(3, _size);
    AbstractMetamodelDeclaration decl = decls.get(0);
    Assert.assertTrue((decl instanceof ReferencedMetamodel));
    EPackage _ePackage = decl.getEPackage();
    Assert.assertNotNull(_ePackage);
    EPackage _ePackage_1 = decl.getEPackage();
    String _nsURI = _ePackage_1.getNsURI();
    Assert.assertEquals("http://www.eclipse.org/emf/2002/Ecore", _nsURI);
    String _alias = decl.getAlias();
    Assert.assertEquals("bar", _alias);
    AbstractMetamodelDeclaration _get_1 = decls.get(1);
    decl = _get_1;
    String _alias_1 = decl.getAlias();
    Assert.assertEquals("bar", _alias_1);
    EPackage _ePackage_2 = decl.getEPackage();
    Assert.assertNotNull(_ePackage_2);
    EPackage _ePackage_3 = decl.getEPackage();
    String _nsURI_1 = _ePackage_3.getNsURI();
    Assert.assertEquals("http://3", _nsURI_1);
    AbstractMetamodelDeclaration _get_2 = decls.get(2);
    decl = _get_2;
    Assert.assertTrue((decl instanceof ReferencedMetamodel));
    EPackage _ePackage_4 = decl.getEPackage();
    Assert.assertNotNull(_ePackage_4);
    EPackage _ePackage_5 = decl.getEPackage();
    String _nsURI_2 = _ePackage_5.getNsURI();
    Assert.assertEquals("http://www.eclipse.org/emf/2002/Ecore", _nsURI_2);
    String _alias_2 = decl.getAlias();
    Assert.assertEquals("ecore", _alias_2);
    EList<AbstractRule> _rules = g.getRules();
    AbstractRule abstractRule = _rules.get(0);
    AbstractMetamodelDeclaration _get_3 = decls.get(1);
    TypeRef _type = abstractRule.getType();
    AbstractMetamodelDeclaration _metamodel = _type.getMetamodel();
    Assert.assertSame(_get_3, _metamodel);
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
    EList<EObject> _contents = r.getContents();
    EObject _get = _contents.get(0);
    Grammar g = ((Grammar) _get);
    List<AbstractMetamodelDeclaration> decls = GrammarUtil.allMetamodelDeclarations(g);
    int _size = decls.size();
    Assert.assertEquals(3, _size);
    AbstractMetamodelDeclaration decl = decls.get(0);
    Assert.assertTrue((decl instanceof GeneratedMetamodel));
    String _alias = decl.getAlias();
    Assert.assertEquals("bar", _alias);
    EPackage _ePackage = decl.getEPackage();
    Assert.assertNotNull(_ePackage);
    EPackage _ePackage_1 = decl.getEPackage();
    String _nsURI = _ePackage_1.getNsURI();
    Assert.assertEquals("http://3", _nsURI);
    AbstractMetamodelDeclaration _get_1 = decls.get(1);
    decl = _get_1;
    Assert.assertTrue((decl instanceof ReferencedMetamodel));
    EPackage _ePackage_2 = decl.getEPackage();
    Assert.assertNotNull(_ePackage_2);
    EPackage _ePackage_3 = decl.getEPackage();
    String _nsURI_1 = _ePackage_3.getNsURI();
    Assert.assertEquals("http://www.eclipse.org/emf/2002/Ecore", _nsURI_1);
    String _alias_1 = decl.getAlias();
    Assert.assertEquals("bar", _alias_1);
    AbstractMetamodelDeclaration _get_2 = decls.get(2);
    decl = _get_2;
    Assert.assertTrue((decl instanceof ReferencedMetamodel));
    EPackage _ePackage_4 = decl.getEPackage();
    Assert.assertNotNull(_ePackage_4);
    EPackage _ePackage_5 = decl.getEPackage();
    String _nsURI_2 = _ePackage_5.getNsURI();
    Assert.assertEquals("http://www.eclipse.org/emf/2002/Ecore", _nsURI_2);
    String _alias_2 = decl.getAlias();
    Assert.assertEquals("ecore", _alias_2);
    EList<AbstractRule> _rules = g.getRules();
    AbstractRule abstractRule = _rules.get(0);
    AbstractMetamodelDeclaration _get_3 = decls.get(0);
    TypeRef _type = abstractRule.getType();
    AbstractMetamodelDeclaration _metamodel = _type.getMetamodel();
    Assert.assertSame(_get_3, _metamodel);
  }
  
  @Test
  public void testGetReference() throws Exception {
    this.with(LangATestLanguageStandaloneSetup.class);
    XtextResource resource = this.getResourceFromStringAndExpect("type A extends B", 1);
    LangATestLanguageGrammarAccess _get = this.<LangATestLanguageGrammarAccess>get(LangATestLanguageGrammarAccess.class);
    LangATestLanguageGrammarAccess.TypeElements _typeAccess = _get.getTypeAccess();
    Assignment asExtends = _typeAccess.getExtendsAssignment_2_1();
    AbstractElement _terminal = asExtends.getTerminal();
    CrossReference xref = ((CrossReference) _terminal);
    EObject _model = this.getModel(resource);
    Main model = ((Main) _model);
    EList<Type> _types = model.getTypes();
    EObject typeA = _types.get(0);
    EClass _eClass = typeA.eClass();
    EReference ref = GrammarUtil.getReference(xref, _eClass);
    Assert.assertNotNull(ref);
    String _name = ref.getName();
    Assert.assertEquals("extends", _name);
    boolean _isMany = ref.isMany();
    Assert.assertFalse(_isMany);
    EClass _eClass_1 = typeA.eClass();
    EClass _eReferenceType = ref.getEReferenceType();
    Assert.assertEquals(_eClass_1, _eReferenceType);
  }
}

/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io/) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.ActionTestLanguage3StandaloneSetup;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguage3GrammarAccess;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class SetEntryPointOnXtextResourceTest extends AbstractXtextTests {
  @Test
  public void test1() {
    try {
      this.with(ReferenceGrammarTestLanguageStandaloneSetup.class);
      final String model = "kind (Hugo 13)";
      final ParserRule kindRule = this.<ReferenceGrammarTestLanguageGrammarAccess>get(ReferenceGrammarTestLanguageGrammarAccess.class).getKindRule();
      final XtextResource resource = this.createResource();
      resource.setEntryPoint(kindRule);
      StringInputStream _stringInputStream = new StringInputStream(model);
      resource.load(_stringInputStream, CollectionLiterals.<Object, Object>emptyMap());
      Assert.assertTrue(resource.getErrors().isEmpty());
      Assert.assertEquals(kindRule, NodeModelUtils.getEntryParserRule(resource.getParseResult().getRootNode()));
      final String originalNodeModel = NodeModelUtils.compactDump(resource.getParseResult().getRootNode(), false);
      resource.update(0, model.length(), ((" " + model) + " "));
      final String reparsedNodeModel = NodeModelUtils.compactDump(resource.getParseResult().getRootNode(), false);
      Assert.assertEquals(originalNodeModel, reparsedNodeModel);
      final ParserRule erwachsenerRule = this.<ReferenceGrammarTestLanguageGrammarAccess>get(ReferenceGrammarTestLanguageGrammarAccess.class).getErwachsenerRule();
      resource.setEntryPoint(erwachsenerRule);
      resource.update(0, model.length(), "erwachsener (Peter 30)");
      Assert.assertEquals(erwachsenerRule, NodeModelUtils.getEntryParserRule(resource.getParseResult().getRootNode()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test2() {
    try {
      this.with(ActionTestLanguage3StandaloneSetup.class);
      final ParserRule rule = this.<ActionTestLanguage3GrammarAccess>get(ActionTestLanguage3GrammarAccess.class).getProductionRule1Rule();
      final String model = "X \"Y\" 42";
      final XtextResource resource = this.createResource();
      resource.setEntryPoint(rule);
      StringInputStream _stringInputStream = new StringInputStream(model);
      resource.load(_stringInputStream, CollectionLiterals.<Object, Object>emptyMap());
      Assert.assertTrue(resource.getErrors().isEmpty());
      final ParserRule entryRule = NodeModelUtils.getEntryParserRule(resource.getParseResult().getRootNode());
      Assert.assertEquals(rule, entryRule);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test3() {
    try {
      this.with(ActionTestLanguage3StandaloneSetup.class);
      final ParserRule rule = this.<ActionTestLanguage3GrammarAccess>get(ActionTestLanguage3GrammarAccess.class).getProductionRule2Rule();
      final String model = "\"Y\" X42";
      final XtextResource resource = this.createResource();
      resource.setEntryPoint(rule);
      StringInputStream _stringInputStream = new StringInputStream(model);
      resource.load(_stringInputStream, CollectionLiterals.<Object, Object>emptyMap());
      Assert.assertTrue(resource.getErrors().isEmpty());
      final ParserRule entryRule = NodeModelUtils.getEntryParserRule(resource.getParseResult().getRootNode());
      Assert.assertEquals(rule, entryRule);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private XtextResource createResource() {
    String _currentFileExtension = this.getCurrentFileExtension();
    String _plus = ("dummy." + _currentFileExtension);
    Resource _createResource = this.<IResourceFactory>get(IResourceFactory.class).createResource(URI.createURI(_plus));
    return ((XtextResource) _createResource);
  }
}

/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io/) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
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
      ReferenceGrammarTestLanguageGrammarAccess _get = this.<ReferenceGrammarTestLanguageGrammarAccess>get(ReferenceGrammarTestLanguageGrammarAccess.class);
      final ParserRule kindRule = _get.getKindRule();
      final XtextResource resource = this.createResource();
      resource.setEntryPoint(kindRule);
      StringInputStream _stringInputStream = new StringInputStream(model);
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      resource.load(_stringInputStream, _emptyMap);
      EList<Resource.Diagnostic> _errors = resource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      IParseResult _parseResult = resource.getParseResult();
      ICompositeNode _rootNode = _parseResult.getRootNode();
      ParserRule _entryParserRule = NodeModelUtils.getEntryParserRule(_rootNode);
      Assert.assertEquals(kindRule, _entryParserRule);
      IParseResult _parseResult_1 = resource.getParseResult();
      ICompositeNode _rootNode_1 = _parseResult_1.getRootNode();
      final String originalNodeModel = NodeModelUtils.compactDump(_rootNode_1, false);
      int _length = model.length();
      resource.update(0, _length, ((" " + model) + " "));
      IParseResult _parseResult_2 = resource.getParseResult();
      ICompositeNode _rootNode_2 = _parseResult_2.getRootNode();
      final String reparsedNodeModel = NodeModelUtils.compactDump(_rootNode_2, false);
      Assert.assertEquals(originalNodeModel, reparsedNodeModel);
      ReferenceGrammarTestLanguageGrammarAccess _get_1 = this.<ReferenceGrammarTestLanguageGrammarAccess>get(ReferenceGrammarTestLanguageGrammarAccess.class);
      final ParserRule erwachsenerRule = _get_1.getErwachsenerRule();
      resource.setEntryPoint(erwachsenerRule);
      int _length_1 = model.length();
      resource.update(0, _length_1, "erwachsener (Peter 30)");
      IParseResult _parseResult_3 = resource.getParseResult();
      ICompositeNode _rootNode_3 = _parseResult_3.getRootNode();
      ParserRule _entryParserRule_1 = NodeModelUtils.getEntryParserRule(_rootNode_3);
      Assert.assertEquals(erwachsenerRule, _entryParserRule_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private XtextResource createResource() {
    IResourceFactory _get = this.<IResourceFactory>get(IResourceFactory.class);
    String _currentFileExtension = this.getCurrentFileExtension();
    String _plus = ("dummy." + _currentFileExtension);
    URI _createURI = URI.createURI(_plus);
    Resource _createResource = _get.createResource(_createURI);
    return ((XtextResource) _createResource);
  }
}

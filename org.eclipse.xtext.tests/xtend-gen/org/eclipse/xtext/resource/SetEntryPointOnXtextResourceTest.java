/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io/) and others.
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
  
  private XtextResource createResource() {
    String _currentFileExtension = this.getCurrentFileExtension();
    String _plus = ("dummy." + _currentFileExtension);
    Resource _createResource = this.<IResourceFactory>get(IResourceFactory.class).createResource(URI.createURI(_plus));
    return ((XtextResource) _createResource);
  }
}

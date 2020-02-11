/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.parser.antlr.KeywordHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class KeywordHelperTest extends AbstractXtextTests {
  private GlobalRegistries.GlobalStateMemento globalStateMemento;
  
  @Before
  @Override
  public void setUp() {
    try {
      this.globalStateMemento = GlobalRegistries.makeCopyOfGlobalState();
      super.setUp();
      EPackage.Registry.INSTANCE.put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE);
      this.with(XtextStandaloneSetup.class);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  @Override
  public void tearDown() {
    try {
      super.tearDown();
      this.globalStateMemento.restoreGlobalState();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testToAntlrTokenIdentifier() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("grammar org.eclipse.xtext.xbase.Xbase with org.eclipse.xtext.common.Terminals");
      _builder.newLine();
      _builder.append("import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore");
      _builder.newLine();
      _builder.append("Model returns ecore::EClass : \"model\" \"/EOF\" \"EOF\" \"ƒ÷‹‰ˆ¸ﬂ\" name=ID;");
      _builder.newLine();
      final XtextResource resource = this.getResourceFromString(_builder.toString());
      EObject _head = IterableExtensions.<EObject>head(resource.getContents());
      final Grammar grammar = ((Grammar) _head);
      GrammarAccessExtensions _grammarAccessExtensions = new GrammarAccessExtensions();
      final KeywordHelper keywordHelper = new KeywordHelper(grammar, true, _grammarAccessExtensions);
      Assert.assertEquals("[/EOF, EOF, model, ƒ÷‹‰ˆ¸ﬂ]", IterableExtensions.<String>sort(keywordHelper.getAllKeywords()).toString());
      Assert.assertEquals("KW_EOF_1", keywordHelper.getRuleName("/EOF"));
      Assert.assertEquals("KW_EOF", keywordHelper.getRuleName("EOF"));
      Assert.assertEquals("Model", keywordHelper.getRuleName("model"));
      Assert.assertEquals("AeOeUeaeOeUe", keywordHelper.getRuleName("ƒ÷‹‰ˆ¸ﬂ"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected InputStream getAsStream(final String model) {
    return this.getAsStream(model, StandardCharsets.ISO_8859_1);
  }
}

/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parsetree.formatter;

import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parsetree.formatter.FormatterTestLanguage2StandaloneSetup;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage2.Root;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnotherFormatterTest extends AbstractXtextTests {
  @Override
  public void setUp() throws Exception {
    super.setUp();
    this.with(FormatterTestLanguage2StandaloneSetup.class);
  }
  
  @Test
  public void loadModel() {
    try {
      final ParseHelper<Root> parseHelper = this.getInjector().<ParseHelper<Root>>getInstance(Key.<ParseHelper<Root>>get(new TypeLiteral<ParseHelper<Root>>() {
      }));
      final INodeModelFormatter formatter = this.getInjector().<INodeModelFormatter>getInstance(INodeModelFormatter.class);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("test sample {");
      _builder.newLine();
      _builder.append("// just a comment");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Root root = parseHelper.parse(_builder);
      Assert.assertNotNull(root);
      final EList<Resource.Diagnostic> errors = root.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", ");
      _builder_1.append(_join);
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      Resource _eResource = root.eResource();
      ICompositeNode rootNode = ((XtextResource) _eResource).getParseResult().getRootNode();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("test sample {");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("// just a comment");
      _builder_2.newLine();
      _builder_2.append("}");
      final String expected = _builder_2.toString();
      INodeModelFormatter.IFormattedRegion formattedRegion = formatter.format(rootNode, rootNode.getTotalOffset(), rootNode.getTotalLength());
      Assert.assertEquals(expected, formattedRegion.getFormattedText());
      formattedRegion = formatter.format(rootNode, rootNode.getTotalOffset(), rootNode.getTotalLength());
      Assert.assertEquals(expected, formattedRegion.getFormattedText());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

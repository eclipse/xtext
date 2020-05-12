/**
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.tests.XtextInjectorProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test cases for the {@link XtextFormatter} class.
 * 
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
@SuppressWarnings("all")
public class XtextFormatterTest {
  @Inject
  @Extension
  private ParseHelper<Grammar> _parseHelper;
  
  @Inject
  @Extension
  private INodeModelFormatter _iNodeModelFormatter;
  
  @Test
  public void formatting_with_windows_line_endings01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.example.mydsl.MyDsl");
    _builder.newLine();
    _builder.newLine();
    _builder.append("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("OpOther:");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("\'->\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'..<\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'>\' \'..\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'..\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'=>\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'>\' (=>(\'>\' \'>\') | \'>\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'<\' (=>(\'<\' \'<\') | \'<\' | \'=>\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'<>\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'?:\';");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar org.xtext.example.mydsl.MyDsl");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("OpOther:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'->\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'..<\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'>\' \'..\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'..\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'=>\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'>\' (=> (\'>\' \'>\') | \'>\')");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'<\' (=> (\'<\' \'<\') | \'<\' | \'=>\')");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'<>\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'?:\';");
    this.assertFormattedAs(_builder, _builder_1);
  }
  
  @Test
  public void formatting_with_windows_line_endings02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.example.mydsl.MyDsl");
    _builder.newLine();
    _builder.newLine();
    _builder.append("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("OpOther:");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("\'->\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'..<\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'>\' \'..\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'..\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'=>\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'>\' (=>(\'>\' \'>\') | \'>\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'<\' (=>(\'<\' \'<\') | \'<\' | \'=>\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'<>\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'?:\';");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar org.xtext.example.mydsl.MyDsl");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("OpOther:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'->\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'..<\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'>\' \'..\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'..\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'=>\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'>\' (=> (\'>\' \'>\') | \'>\')");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'<\' (=> (\'<\' \'<\') | \'<\' | \'=>\')");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'<>\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'?:\';");
    this.assertFormattedAs(_builder, _builder_1);
  }
  
  @Test
  public void formatting_with_unix_line_endings01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.example.mydsl.MyDsl");
    _builder.newLine();
    _builder.newLine();
    _builder.append("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("OpOther:");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("\'->\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'..<\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'>\' \'..\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'..\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'=>\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'>\' (=>(\'>\' \'>\') | \'>\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'<\' (=>(\'<\' \'<\') | \'<\' | \'=>\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'<>\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'?:\';");
    String _unixLineSeparator = Strings.toUnixLineSeparator(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar org.xtext.example.mydsl.MyDsl");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("OpOther:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'->\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'..<\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'>\' \'..\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'..\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'=>\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'>\' (=> (\'>\' \'>\') | \'>\')");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'<\' (=> (\'<\' \'<\') | \'<\' | \'=>\')");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'<>\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'?:\';");
    this.assertFormattedAs(_unixLineSeparator, _builder_1);
  }
  
  @Test
  public void formatting_with_unix_line_endings02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.example.mydsl.MyDsl");
    _builder.newLine();
    _builder.newLine();
    _builder.append("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("OpOther:");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("\'->\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'..<\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'>\' \'..\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'..\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'=>\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'>\' (=>(\'>\' \'>\') | \'>\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'<\' (=>(\'<\' \'<\') | \'<\' | \'=>\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'<>\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("| \'?:\';");
    _builder.newLine();
    String _unixLineSeparator = Strings.toUnixLineSeparator(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar org.xtext.example.mydsl.MyDsl");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("OpOther:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'->\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'..<\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'>\' \'..\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'..\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'=>\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'>\' (=> (\'>\' \'>\') | \'>\')");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'<\' (=> (\'<\' \'<\') | \'<\' | \'=>\')");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'<>\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| \'?:\';");
    this.assertFormattedAs(_unixLineSeparator, _builder_1);
  }
  
  private void assertFormattedAs(final CharSequence input, final CharSequence expected) {
    Assert.assertEquals(expected.toString(), this.formattedText(input));
  }
  
  private String formattedText(final CharSequence unformattedText) {
    try {
      String _xblockexpression = null;
      {
        Resource _eResource = this._parseHelper.parse(unformattedText).eResource();
        final ICompositeNode rootNode = ((XtextResource) _eResource).getParseResult().getRootNode();
        _xblockexpression = this._iNodeModelFormatter.format(rootNode, 0, unformattedText.length()).getFormattedText();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

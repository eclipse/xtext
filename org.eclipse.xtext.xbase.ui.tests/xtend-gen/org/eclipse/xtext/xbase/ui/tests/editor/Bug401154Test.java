/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.ui.tests.editor.AbstractXbaseContentAssistBugTest;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug401154Test extends AbstractXbaseContentAssistBugTest {
  @Test
  public void testImplicitReceiver() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch it: new Object {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("CharSequence: ");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposal("length").withDisplayString("length : int - CharSequence.length()");
  }
  
  @Test
  public void testLocalSwitchVariable() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch it: new Object {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("CharSequence: ");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposal("it").withDisplayString("it");
  }
  
  @Test
  public void testLocalSwitchVariableInDefault() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch it: new Object {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("default: ");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposal("it").withDisplayString("it");
  }
  
  @Test
  public void testImplicitReceiverInEmptyBlock() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch it: new Object {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("CharSequence: {");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposal("length").withDisplayString("length : int - CharSequence.length()");
  }
  
  @Test
  public void testImplicitReceiverInBlock() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch it: new Object {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("CharSequence: { length ");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposal("length").withDisplayString("length : int - CharSequence.length()");
  }
  
  @Test
  public void testNestedSwitchWithImplicitReceiverInBlock_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch it: new Object {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("CharSequence: switch it {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Appendable: { appe");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposal("append()");
  }
  
  @Test
  public void testNestedSwitchWithImplicitReceiverInBlock_02() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch it: new Object {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("CharSequence: switch it {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Appendable: { ");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposal("length").withDisplayString("length : int - CharSequence.length()");
  }
  
  @Test
  public void testExplicitReceiver() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch it: new Object {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("CharSequence: it.");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposal("length").withDisplayString("length : int - CharSequence.length()");
  }
  
  @Test
  public void testKnownTypeIsSupertype() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch it: new StringBuilder {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("CharSequence: ");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposal("charAt()").withDisplayString("charAt(int index) : char - AbstractStringBuilder");
  }
  
  @Test
  public void testKnownTypeIsSupertype_02() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch it: new StringBuilder {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("CharSequence: it.");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposal("charAt()").withDisplayString("charAt(int index) : char - AbstractStringBuilder");
  }
}

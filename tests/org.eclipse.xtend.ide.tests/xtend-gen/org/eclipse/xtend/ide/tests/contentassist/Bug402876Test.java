/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtend.ide.tests.contentassist.AbstractXtendContentAssistBugTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug402876Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void testExtensionPrecendence_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Iterable<String> s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("s.map<|>");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposalAtCursor = _append.assertProposalAtCursor("map[]");
    _assertProposalAtCursor.withDisplayString("map((T)=>R transformation) : Iterable<R> - IterableExtensions");
  }
  
  @Test
  public void testExtensionPrecendence_02() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(java.util.Collection<String> s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("s.map<|>");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposalAtCursor = _append.assertProposalAtCursor("map[]");
    _assertProposalAtCursor.withDisplayString("map((T)=>R transformation) : Iterable<R> - IterableExtensions");
  }
  
  @Test
  public void testExtensionPrecendence_03() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(java.util.List<String> s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("s.map<|>");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposalAtCursor = _append.assertProposalAtCursor("map[]");
    _assertProposalAtCursor.withDisplayString("map((T)=>R transformation) : List<R> - ListExtensions");
  }
  
  @Test
  public void testExtensionPrecendence_04() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T, R> void map(java.util.Collection<T> c, (T)=>R f) {} ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(java.util.List<String> s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("s.map<|>");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposalAtCursor = _append.assertProposalAtCursor("map[]");
    _assertProposalAtCursor.withDisplayString("map((T)=>R f) : void - C");
  }
  
  @Ignore
  @Test
  public void testExtensionPrecendence_05() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static <T, R> void map(java.util.Collection<T> c, (T)=>R f) {} ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(java.util.List<String> s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("s.map<|>");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposalAtCursor = _append.assertProposalAtCursor("map[]");
    _assertProposalAtCursor.withDisplayString("map((T)=>R transformation) : List<R> - ListExtensions");
  }
  
  @Ignore
  @Test
  public void testExtensionPrecendence_06() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T, R> int map(java.util.Collection<T> c, (T)=>R f) {} ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T, R> long map(java.util.AbstractCollection<T> c, (T)=>R f) {} ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(java.util.List<String> s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("s.map<|>");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposalAtCursor = _append.assertProposalAtCursor("map[]");
    _assertProposalAtCursor.withDisplayString("map((T)=>R f) : long - C");
  }
  
  @Test
  public void testExtensionParameterNoArguments_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(extension String s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("subSequence()");
    _assertProposal.withDisplayString("subSequence(int beginIndex, int endIndex) : CharSequence - String");
  }
  
  @Test
  public void testExtensionParameter_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(int i, extension String s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("i.");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("subSequence()");
    _assertProposal.withDisplayString("subSequence(int endIndex) : CharSequence - String");
  }
  
  @Test
  public void testExtensionParameter_02() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(int i, extension String s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("i.");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("charAt");
    _assertProposal.withDisplayString("charAt : char - String.charAt()");
  }
  
  @Test
  public void testExtensionParameterWithImplicitArgument_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(int it, extension String s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("charAt");
    _assertProposal.withDisplayString("charAt : char - String.charAt()");
  }
  
  @Test
  public void testExtensionLocal_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(int i) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension String s = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("i.");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("subSequence()");
    _assertProposal.withDisplayString("subSequence(int endIndex) : CharSequence - String");
  }
  
  @Test
  public void testExtensionLocal_02() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(int i) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension String s = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("i.");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("charAt");
    _assertProposal.withDisplayString("charAt : char - String.charAt()");
  }
  
  @Test
  public void testExtensionLocalWithImplicitArgument_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(int it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension String s = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("charAt");
    _assertProposal.withDisplayString("charAt : char - String.charAt()");
  }
  
  @Test
  public void testExtensionLambdaParameter_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(int it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("[ extension String s |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("charAt");
    _assertProposal.withDisplayString("charAt : char - String.charAt()");
  }
  
  @Test
  public void testExtensionForLoopParameter_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(int it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for(extension String s : newArrayList) ");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("charAt");
    _assertProposal.withDisplayString("charAt : char - String.charAt()");
  }
  
  @Test
  public void testExtensionCatchParameter_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(int it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// illegal catch param does not matter");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {} catch(extension String s) ");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("charAt");
    _assertProposal.withDisplayString("charAt : char - String.charAt()");
  }
  
  @Test
  public void testInheritedExtensionField_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected extension String s");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class C extends A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(int it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("charAt");
    _assertProposal.withDisplayString("charAt : char - String.charAt()");
  }
}

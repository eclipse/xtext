/**
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.contentassist;

import java.util.Collections;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=462915">Bug 462915</a>
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug462915Test extends AbstractXtendContentAssistBugTest {
  private static final String NO_GUICE_PROJECT_NAME = "Bug462915";

  private IProject noGuiceProject;

  @After
  @Override
  public void tearDown() throws Exception {
    if ((this.noGuiceProject != null)) {
      JavaProjectSetupUtil.deleteProject(this.noGuiceProject);
    }
    super.tearDown();
  }

  /**
   * make sure additional proposal infos can be calculated
   */
  @Test
  public void testAdditionalProposalInfoWorks() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("test");
      _builder.newLine();
      _builder.append("}");
      final String model = _builder.toString();
      ContentAssistProcessorTestBuilder _append = this.newBuilder().append(model);
      int _indexOf = model.indexOf("test");
      int _plus = (_indexOf + 4);
      final ICompletionProposal[] proposals = _append.computeCompletionProposals(_plus);
      Assert.assertEquals("More than one proposal found", 1, ((List<ICompletionProposal>)Conversions.doWrapArray(proposals)).size());
      final ICompletionProposal proposal = IterableExtensions.<ICompletionProposal>head(((Iterable<ICompletionProposal>)Conversions.doWrapArray(proposals)));
      Assert.assertEquals("test - JUnit test method", proposal.getDisplayString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@Test");
      _builder_1.newLine();
      _builder_1.append("def void testName() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("}");
      Assert.assertEquals(Strings.toUnixLineSeparator(_builder_1).toString(), proposal.getAdditionalProposalInfo());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * make sure inject is not proposed
   */
  @Test
  public void testTestPreConditionsWork() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("inject");
      _builder.newLine();
      _builder.append("}");
      final String model = _builder.toString();
      ContentAssistProcessorTestBuilder _append = this.newBuilder().append(model);
      int _indexOf = model.indexOf("inject");
      int _plus = (_indexOf + 6);
      final ICompletionProposal[] proposals = _append.computeCompletionProposals(_plus);
      Assert.assertEquals("Did not expect to find any proposal", 0, ((List<ICompletionProposal>)Conversions.doWrapArray(proposals)).size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Override
  public IJavaProject getJavaProject(final ResourceSet resourceSet) {
    IJavaProject javaProject = JavaProjectSetupUtil.findJavaProject(Bug462915Test.NO_GUICE_PROJECT_NAME);
    if (((javaProject == null) || (!javaProject.exists()))) {
      try {
        this.noGuiceProject = WorkbenchTestHelper.createPluginProject(Bug462915Test.NO_GUICE_PROJECT_NAME, ((String[])Conversions.unwrapArray(this.getTestProjectRequiredBundles(), String.class)));
        javaProject = JavaProjectSetupUtil.findJavaProject(Bug462915Test.NO_GUICE_PROJECT_NAME);
      } catch (final Throwable _t) {
        if (_t instanceof CoreException) {
          final CoreException e = (CoreException)_t;
          String _message = e.getMessage();
          String _plus = ("cannot create java project due to: " + _message);
          String _plus_1 = (_plus + " / ");
          String _plus_2 = (_plus_1 + e);
          Assert.fail(_plus_2);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return javaProject;
  }

  protected List<String> getTestProjectRequiredBundles() {
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit"));
  }
}

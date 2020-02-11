/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.fragments;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamed;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamedWithAction;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractFragmentsTest extends AbstractXtextTests {
  @Inject
  @Extension
  private ParseHelper<ParserRuleFragments> parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper validationTestHelper;
  
  @Inject
  @Extension
  private InvariantChecker invariantChecker;
  
  @Override
  protected void setInjector(final Injector injector) {
    super.setInjector(injector);
    this.injectMembers(this);
  }
  
  @Test
  public void testSimpleModel() {
    final ParserRuleFragments fragments = this.parseAndValidate("#1 myName");
    Assert.assertNotNull(fragments);
    Assert.assertEquals("myName", fragments.getElement().getName());
  }
  
  @Test
  public void testReference() {
    final ParserRuleFragments fragments = this.parseAndValidate("#2 myName -> myName");
    Assert.assertNotNull(fragments);
    Assert.assertEquals("myName", fragments.getElement().getName());
    Assert.assertEquals(fragments.getElement(), fragments.getRef());
  }
  
  @Test
  public void testReference_02() {
    final ParserRuleFragments fragments = this.parseAndValidate("#1 myName : myName");
    Assert.assertNotNull(fragments);
    Assert.assertEquals("myName", fragments.getElement().getName());
    Assert.assertEquals(fragments.getElement(), fragments.getElement().getRef());
  }
  
  @Test
  public void testReferenceInFragment() {
    final ParserRuleFragments fragments = this.parseAndValidate("#1 myName - myName");
    Assert.assertNotNull(fragments);
    Assert.assertEquals("myName", fragments.getElement().getName());
    Assert.assertEquals(fragments.getElement(), fragments.getElement().getRef());
  }
  
  @Test
  public void testReferenceBeforeFragment() {
    final ParserRuleFragments fragments = this.parseAndValidate("#3 myName <- myName");
    Assert.assertNotNull(fragments);
    Assert.assertEquals("myName", fragments.getElement().getName());
    Assert.assertEquals(fragments.getElement(), fragments.getElement().getRef());
  }
  
  @Test
  public void testAction() {
    final ParserRuleFragments fragments = this.parseAndValidate("#4 prev current");
    Assert.assertNotNull(fragments);
    Assert.assertEquals("current", fragments.getElement().getName());
    PRFNamed _element = fragments.getElement();
    Assert.assertEquals("prev", ((PRFNamedWithAction) _element).getPrev().getName());
  }
  
  @Test
  public void testActionAndReference() {
    final ParserRuleFragments fragments = this.parseAndValidate("#4 prev current prev current");
    Assert.assertNotNull(fragments);
    final PRFNamed element = fragments.getElement();
    Assert.assertEquals("current", element.getName());
    final PRFNamed prev = ((PRFNamedWithAction) element).getPrev();
    Assert.assertEquals("prev", prev.getName());
    Assert.assertEquals(prev, element.getRef());
    Assert.assertEquals(element, ((PRFNamedWithAction) element).getRef2());
  }
  
  @Test
  @Ignore("Actions are currently not supported in fragments")
  public void testActionInFragment_01() {
    final ParserRuleFragments fragments = this.parseAndValidate("#5 prev current");
    Assert.assertNotNull(fragments);
    Assert.assertEquals("current", fragments.getElement().getName());
    PRFNamed _element = fragments.getElement();
    Assert.assertEquals("prev", ((PRFNamedWithAction) _element).getPrev().getName());
  }
  
  @Test
  @Ignore("Actions are currently not supported in fragments")
  public void testActionInFragment_02() {
    final ParserRuleFragments fragments = this.parseAndValidate("#6 prev current");
    Assert.assertNotNull(fragments);
    Assert.assertEquals("current", fragments.getElement().getName());
    PRFNamed _element = fragments.getElement();
    Assert.assertEquals("prev", ((PRFNamedWithAction) _element).getPrev().getName());
  }
  
  @Test
  @Ignore("Actions are currently not supported in fragments")
  public void testActionInFragmentAndReference_01() {
    final ParserRuleFragments fragments = this.parseAndValidate("#5 prev current current - prev");
    Assert.assertNotNull(fragments);
    final PRFNamed element = fragments.getElement();
    Assert.assertEquals("current", element.getName());
    final PRFNamed prev = ((PRFNamedWithAction) element).getPrev();
    Assert.assertEquals("prev", prev.getName());
    Assert.assertEquals(prev, element.getRef());
    Assert.assertEquals(element, ((PRFNamedWithAction) element).getRef2());
  }
  
  @Test
  @Ignore("Actions are currently not supported in fragments")
  public void testActionInFragmentAndReference_02() {
    final ParserRuleFragments fragments = this.parseAndValidate("#6 prev current current - prev");
    Assert.assertNotNull(fragments);
    final PRFNamed element = fragments.getElement();
    Assert.assertEquals("current", element.getName());
    final PRFNamed prev = ((PRFNamedWithAction) element).getPrev();
    Assert.assertEquals("prev", prev.getName());
    Assert.assertEquals(prev, element.getRef());
    Assert.assertEquals(element, ((PRFNamedWithAction) element).getRef2());
  }
  
  @Test
  @Ignore("Actions are currently not supported in fragments")
  public void testActionInFragmentAndReferenceLoop() {
    final ParserRuleFragments fragments = this.parseAndValidate("#7 root -> a a -> b b -> c c - root");
    Assert.assertNotNull(fragments);
    PRFNamed element = fragments.getElement();
    while ((element instanceof PRFNamedWithAction)) {
      {
        Assert.assertEquals(element, ((PRFNamedWithAction)element).getRef2());
        element = ((PRFNamedWithAction)element).getPrev();
      }
    }
    Assert.assertEquals(element, element.getRef());
  }
  
  @Test
  public void testDatatypeRule_01() {
    final ParserRuleFragments fragments = this.parseAndValidate("#8 a - a");
    Assert.assertNotNull(fragments);
    PRFNamed element = fragments.getElement();
    Assert.assertEquals(element, element.getRef());
  }
  
  @Test
  public void testDatatypeRule_02() {
    final ParserRuleFragments fragments = this.parseAndValidate("#8 a.b.c.d");
    Assert.assertNotNull(fragments);
    PRFNamed element = fragments.getElement();
    Assert.assertEquals("a.b.c.d", element.getName());
  }
  
  @Test
  public void testDatatypeRule_03() {
    final ParserRuleFragments fragments = this.parseAndValidate("#8 a.b.c.d - a.b.c.d");
    Assert.assertNotNull(fragments);
    PRFNamed element = fragments.getElement();
    Assert.assertEquals(element, element.getRef());
  }
  
  @Test
  public void testFragmentWithPredicate() {
    final ParserRuleFragments fragments = this.parseAndValidate("#9 myName - myName");
    Assert.assertNotNull(fragments);
    Assert.assertEquals("myName", fragments.getElement().getName());
    Assert.assertEquals(fragments.getElement(), fragments.getElement().getRef());
  }
  
  @Test
  public void testFragmentRecursive_01() {
    final ParserRuleFragments fragments = this.parseAndValidate("#10 myName myPrev");
    Assert.assertNotNull(fragments);
    Assert.assertEquals("myName", fragments.getElement().getName());
    PRFNamed _element = fragments.getElement();
    final PRFNamed prev = ((PRFNamedWithAction) _element).getPrev();
    Assert.assertEquals("myPrev", prev.getName());
    final ICompositeNode node = NodeModelUtils.findActualNodeFor(prev);
    Assert.assertEquals(" myPrev", node.getText());
    final EObject lookup = NodeModelUtils.findActualSemanticObjectFor(node);
    Assert.assertSame(prev, lookup);
  }
  
  @Test
  public void testFragmentRecursive_02() {
    final ParserRuleFragments fragments = this.parseAndValidate("#10 myName ((myPrev))");
    Assert.assertNotNull(fragments);
    Assert.assertEquals("myName", fragments.getElement().getName());
    PRFNamed _element = fragments.getElement();
    final PRFNamed prev = ((PRFNamedWithAction) _element).getPrev();
    Assert.assertEquals("myPrev", prev.getName());
    final ICompositeNode node = NodeModelUtils.findActualNodeFor(prev);
    Assert.assertEquals(" ((myPrev))", node.getText());
    final EObject lookup = NodeModelUtils.findActualSemanticObjectFor(node);
    Assert.assertSame(prev, lookup);
  }
  
  @Test
  public void testFragmentRecursive_03() {
    final ParserRuleFragments fragments = this.parseAndValidate("#11 myName myPrev");
    Assert.assertNotNull(fragments);
    Assert.assertEquals("myName", fragments.getElement().getName());
    PRFNamed _element = fragments.getElement();
    final PRFNamed prev = ((PRFNamedWithAction) _element).getPrev();
    Assert.assertEquals("myPrev", prev.getName());
    final ICompositeNode node = NodeModelUtils.findActualNodeFor(prev);
    Assert.assertEquals(" myPrev", node.getText());
    final EObject lookup = NodeModelUtils.findActualSemanticObjectFor(node);
    Assert.assertSame(prev, lookup);
  }
  
  @Test
  public void testFragmentRecursive_04() {
    final ParserRuleFragments fragments = this.parseAndValidate("#11 myName ((myPrev))");
    Assert.assertNotNull(fragments);
    Assert.assertEquals("myName", fragments.getElement().getName());
    PRFNamed _element = fragments.getElement();
    final PRFNamed prev = ((PRFNamedWithAction) _element).getPrev();
    Assert.assertEquals("myPrev", prev.getName());
    final ICompositeNode node = NodeModelUtils.findActualNodeFor(prev);
    Assert.assertEquals("myPrev", node.getText());
    final EObject lookup = NodeModelUtils.findActualSemanticObjectFor(node);
    Assert.assertSame(prev, lookup);
  }
  
  protected ParserRuleFragments parseAndValidate(final CharSequence s) {
    try {
      final ParserRuleFragments result = this.parseHelper.parse(s);
      this.validationTestHelper.assertNoIssues(result);
      Resource _eResource = result.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      final ICompositeNode node = resource.getParseResult().getRootNode();
      this.invariantChecker.checkInvariant(node);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

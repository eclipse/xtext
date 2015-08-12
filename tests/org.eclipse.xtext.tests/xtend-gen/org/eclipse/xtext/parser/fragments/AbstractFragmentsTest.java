/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.fragments;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamed;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamedWithAction;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
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
    PRFNamed _element = fragments.getElement();
    String _name = _element.getName();
    Assert.assertEquals("myName", _name);
  }
  
  @Test
  public void testReference() {
    final ParserRuleFragments fragments = this.parseAndValidate("#2 myName -> myName");
    Assert.assertNotNull(fragments);
    PRFNamed _element = fragments.getElement();
    String _name = _element.getName();
    Assert.assertEquals("myName", _name);
    PRFNamed _element_1 = fragments.getElement();
    PRFNamed _ref = fragments.getRef();
    Assert.assertEquals(_element_1, _ref);
  }
  
  @Test
  public void testReference_02() {
    final ParserRuleFragments fragments = this.parseAndValidate("#1 myName : myName");
    Assert.assertNotNull(fragments);
    PRFNamed _element = fragments.getElement();
    String _name = _element.getName();
    Assert.assertEquals("myName", _name);
    PRFNamed _element_1 = fragments.getElement();
    PRFNamed _element_2 = fragments.getElement();
    PRFNamed _ref = _element_2.getRef();
    Assert.assertEquals(_element_1, _ref);
  }
  
  @Test
  public void testReferenceInFragment() {
    final ParserRuleFragments fragments = this.parseAndValidate("#1 myName - myName");
    Assert.assertNotNull(fragments);
    PRFNamed _element = fragments.getElement();
    String _name = _element.getName();
    Assert.assertEquals("myName", _name);
    PRFNamed _element_1 = fragments.getElement();
    PRFNamed _element_2 = fragments.getElement();
    PRFNamed _ref = _element_2.getRef();
    Assert.assertEquals(_element_1, _ref);
  }
  
  @Test
  public void testReferenceBeforeFragment() {
    final ParserRuleFragments fragments = this.parseAndValidate("#3 myName <- myName");
    Assert.assertNotNull(fragments);
    PRFNamed _element = fragments.getElement();
    String _name = _element.getName();
    Assert.assertEquals("myName", _name);
    PRFNamed _element_1 = fragments.getElement();
    PRFNamed _element_2 = fragments.getElement();
    PRFNamed _ref = _element_2.getRef();
    Assert.assertEquals(_element_1, _ref);
  }
  
  @Test
  public void testAction() {
    final ParserRuleFragments fragments = this.parseAndValidate("#4 prev current");
    Assert.assertNotNull(fragments);
    PRFNamed _element = fragments.getElement();
    String _name = _element.getName();
    Assert.assertEquals("current", _name);
    PRFNamed _element_1 = fragments.getElement();
    PRFNamed _prev = ((PRFNamedWithAction) _element_1).getPrev();
    String _name_1 = _prev.getName();
    Assert.assertEquals("prev", _name_1);
  }
  
  @Test
  public void testActionAndReference() {
    final ParserRuleFragments fragments = this.parseAndValidate("#4 prev current prev current");
    Assert.assertNotNull(fragments);
    final PRFNamed element = fragments.getElement();
    String _name = element.getName();
    Assert.assertEquals("current", _name);
    final PRFNamed prev = ((PRFNamedWithAction) element).getPrev();
    String _name_1 = prev.getName();
    Assert.assertEquals("prev", _name_1);
    PRFNamed _ref = element.getRef();
    Assert.assertEquals(prev, _ref);
    PRFNamed _ref2 = ((PRFNamedWithAction) element).getRef2();
    Assert.assertEquals(element, _ref2);
  }
  
  @Test
  public void testActionInFragment_01() {
    final ParserRuleFragments fragments = this.parseAndValidate("#5 prev current");
    Assert.assertNotNull(fragments);
    PRFNamed _element = fragments.getElement();
    String _name = _element.getName();
    Assert.assertEquals("current", _name);
    PRFNamed _element_1 = fragments.getElement();
    PRFNamed _prev = ((PRFNamedWithAction) _element_1).getPrev();
    String _name_1 = _prev.getName();
    Assert.assertEquals("prev", _name_1);
  }
  
  @Test
  public void testActionInFragment_02() {
    final ParserRuleFragments fragments = this.parseAndValidate("#6 prev current");
    Assert.assertNotNull(fragments);
    PRFNamed _element = fragments.getElement();
    String _name = _element.getName();
    Assert.assertEquals("current", _name);
    PRFNamed _element_1 = fragments.getElement();
    PRFNamed _prev = ((PRFNamedWithAction) _element_1).getPrev();
    String _name_1 = _prev.getName();
    Assert.assertEquals("prev", _name_1);
  }
  
  @Test
  public void testActionInFragmentAndReference_01() {
    final ParserRuleFragments fragments = this.parseAndValidate("#5 prev current current - prev");
    Assert.assertNotNull(fragments);
    final PRFNamed element = fragments.getElement();
    String _name = element.getName();
    Assert.assertEquals("current", _name);
    final PRFNamed prev = ((PRFNamedWithAction) element).getPrev();
    String _name_1 = prev.getName();
    Assert.assertEquals("prev", _name_1);
    PRFNamed _ref = element.getRef();
    Assert.assertEquals(prev, _ref);
    PRFNamed _ref2 = ((PRFNamedWithAction) element).getRef2();
    Assert.assertEquals(element, _ref2);
  }
  
  @Test
  public void testActionInFragmentAndReference_02() {
    final ParserRuleFragments fragments = this.parseAndValidate("#6 prev current current - prev");
    Assert.assertNotNull(fragments);
    final PRFNamed element = fragments.getElement();
    String _name = element.getName();
    Assert.assertEquals("current", _name);
    final PRFNamed prev = ((PRFNamedWithAction) element).getPrev();
    String _name_1 = prev.getName();
    Assert.assertEquals("prev", _name_1);
    PRFNamed _ref = element.getRef();
    Assert.assertEquals(prev, _ref);
    PRFNamed _ref2 = ((PRFNamedWithAction) element).getRef2();
    Assert.assertEquals(element, _ref2);
  }
  
  @Test
  public void testActionInFragmentAndReferenceLoop() {
    final ParserRuleFragments fragments = this.parseAndValidate("#7 root -> a a -> b b -> c c - root");
    Assert.assertNotNull(fragments);
    PRFNamed element = fragments.getElement();
    while ((element instanceof PRFNamedWithAction)) {
      {
        PRFNamed _ref2 = ((PRFNamedWithAction)element).getRef2();
        Assert.assertEquals(element, _ref2);
        PRFNamed _prev = ((PRFNamedWithAction)element).getPrev();
        element = _prev;
      }
    }
    PRFNamed _ref = element.getRef();
    Assert.assertEquals(element, _ref);
  }
  
  @Test
  public void testDatatypeRule_01() {
    final ParserRuleFragments fragments = this.parseAndValidate("#8 a - a");
    Assert.assertNotNull(fragments);
    PRFNamed element = fragments.getElement();
    PRFNamed _ref = element.getRef();
    Assert.assertEquals(element, _ref);
  }
  
  @Test
  public void testDatatypeRule_02() {
    final ParserRuleFragments fragments = this.parseAndValidate("#8 a.b.c.d");
    Assert.assertNotNull(fragments);
    PRFNamed element = fragments.getElement();
    String _name = element.getName();
    Assert.assertEquals("a.b.c.d", _name);
  }
  
  @Test
  public void testDatatypeRule_03() {
    final ParserRuleFragments fragments = this.parseAndValidate("#8 a.b.c.d - a.b.c.d");
    Assert.assertNotNull(fragments);
    PRFNamed element = fragments.getElement();
    PRFNamed _ref = element.getRef();
    Assert.assertEquals(element, _ref);
  }
  
  protected ParserRuleFragments parseAndValidate(final CharSequence s) {
    try {
      final ParserRuleFragments result = this.parseHelper.parse(s);
      this.validationTestHelper.assertNoIssues(result);
      Resource _eResource = result.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      IParseResult _parseResult = resource.getParseResult();
      final ICompositeNode node = _parseResult.getRootNode();
      this.invariantChecker.checkInvariant(node);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

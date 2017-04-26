/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.parser;

import com.google.inject.Inject;
import java.util.HashSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot;
import org.eclipse.xtext.xbase.testlanguages.tests.ContentAssistFragmentTestLangInjectorProvider;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ContentAssistFragmentTestLangInjectorProvider.class)
@SuppressWarnings("all")
public class Bug480686Test {
  @Inject
  private ParseHelper<ContentAssistFragmentTestLanguageRoot> parseHelper;
  
  @Test
  public void testUpdateTwice() {
    try {
      final ContentAssistFragmentTestLanguageRoot result = this.parseHelper.parse("");
      Resource _eResource = result.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      new InvariantChecker().checkInvariant(res.getParseResult().getRootNode());
      res.update(0, 0, "newArrayList()");
      final EObject first = IterableExtensions.<EObject>head(res.getContents());
      Assert.assertTrue(first.eClass().getName(), (first instanceof ContentAssistFragmentTestLanguageRoot));
      res.update("newArrayList(".length(), 0, "1");
      final EObject second = IterableExtensions.<EObject>head(res.getContents());
      Assert.assertTrue(second.eClass().getName(), (second instanceof ContentAssistFragmentTestLanguageRoot));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBrokenInput_01() {
    try {
      final ContentAssistFragmentTestLanguageRoot result = this.parseHelper.parse("}");
      Resource _eResource = result.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      final InvariantChecker invariantChecker = new InvariantChecker();
      invariantChecker.checkInvariant(res.getParseResult().getRootNode());
      res.update(0, 0, "newArrayList()");
      invariantChecker.checkInvariant(res.getParseResult().getRootNode());
      final EObject first = IterableExtensions.<EObject>head(res.getContents());
      Assert.assertTrue(first.eClass().getName(), (first instanceof ContentAssistFragmentTestLanguageRoot));
      res.update("newArrayList(".length(), 0, "1");
      invariantChecker.checkInvariant(res.getParseResult().getRootNode());
      final EObject second = IterableExtensions.<EObject>head(res.getContents());
      Assert.assertTrue(second.eClass().getName(), (second instanceof ContentAssistFragmentTestLanguageRoot));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBrokenInput_02() {
    try {
      final ContentAssistFragmentTestLanguageRoot result = this.parseHelper.parse("}} abc");
      Resource _eResource = result.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      final InvariantChecker invariantChecker = new InvariantChecker();
      invariantChecker.checkInvariant(res.getParseResult().getRootNode());
      res.update(0, 0, "newArrayList()");
      invariantChecker.checkInvariant(res.getParseResult().getRootNode());
      final EObject first = IterableExtensions.<EObject>head(res.getContents());
      Assert.assertTrue(first.eClass().getName(), (first instanceof ContentAssistFragmentTestLanguageRoot));
      res.update("newArrayList(".length(), 0, "1");
      invariantChecker.checkInvariant(res.getParseResult().getRootNode());
      final EObject second = IterableExtensions.<EObject>head(res.getContents());
      Assert.assertTrue(second.eClass().getName(), (second instanceof ContentAssistFragmentTestLanguageRoot));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAllGrammarElementsUnique() {
    try {
      final ContentAssistFragmentTestLanguageRoot result = this.parseHelper.parse("newArrayList()");
      Resource _eResource = result.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      final ICompositeNode root = res.getParseResult().getRootNode();
      new InvariantChecker().checkInvariant(root);
      final HashSet<EObject> set = CollectionLiterals.<EObject>newHashSet();
      BidiTreeIterable<INode> _asTreeIterable = root.getAsTreeIterable();
      for (final INode node : _asTreeIterable) {
        if ((node instanceof ICompositeNode)) {
          EObject _grammarElement = ((ICompositeNode)node).getGrammarElement();
          boolean _tripleNotEquals = (_grammarElement != null);
          if (_tripleNotEquals) {
            Assert.assertTrue(((ICompositeNode)node).getGrammarElement().toString(), set.add(((ICompositeNode)node).getGrammarElement()));
          } else {
            Assert.fail("node without grammar element");
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAllGrammarElementsUniqueAfterReparse() {
    try {
      final ContentAssistFragmentTestLanguageRoot result = this.parseHelper.parse("");
      Resource _eResource = result.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      res.update(0, 0, "newArrayList()");
      final ICompositeNode root = res.getParseResult().getRootNode();
      final HashSet<EObject> set = CollectionLiterals.<EObject>newHashSet();
      BidiTreeIterable<INode> _asTreeIterable = root.getAsTreeIterable();
      for (final INode node : _asTreeIterable) {
        if ((node instanceof ICompositeNode)) {
          EObject _grammarElement = ((ICompositeNode)node).getGrammarElement();
          boolean _tripleNotEquals = (_grammarElement != null);
          if (_tripleNotEquals) {
            Assert.assertTrue(((ICompositeNode)node).getGrammarElement().toString(), set.add(((ICompositeNode)node).getGrammarElement()));
          } else {
            Assert.fail("node without grammar element");
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCompareNodeModel_01() {
    try {
      final ContentAssistFragmentTestLanguageRoot result = this.parseHelper.parse("");
      Resource _eResource = result.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      res.update(0, 0, "newArrayList()");
      final ContentAssistFragmentTestLanguageRoot fresh = this.parseHelper.parse("newArrayList()");
      Resource _eResource_1 = fresh.eResource();
      this.assertEqual(res.getParseResult(), ((XtextResource) _eResource_1).getParseResult());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCompareNodeModel_02() {
    try {
      final ContentAssistFragmentTestLanguageRoot result = this.parseHelper.parse("{vjava.beans.VetoableChangeListener x = []}");
      Resource _eResource = result.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      res.update(2, 1, "a");
      final ContentAssistFragmentTestLanguageRoot fresh = this.parseHelper.parse("{ajava.beans.VetoableChangeListener x = []}");
      Resource _eResource_1 = fresh.eResource();
      this.assertEqual(res.getParseResult(), ((XtextResource) _eResource_1).getParseResult());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCompareNodeModel_03() {
    try {
      final ContentAssistFragmentTestLanguageRoot result = this.parseHelper.parse(((((("{  val Object o = \'foo\'    switch(o) {\n" + 
        "        String: \"\".oString\n") + 
        "    }\n") + 
        "    switch(o) {\n") + 
        "        String: \"\"\n") + 
        "    }}"));
      Resource _eResource = result.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      res.update(58, 1, "t");
      final ContentAssistFragmentTestLanguageRoot fresh = this.parseHelper.parse(((((("{  val Object o = \'foo\'    switch(o) {\n" + 
        "        String: \"\".tString\n") + 
        "    }\n") + 
        "    switch(o) {\n") + 
        "        String: \"\"\n") + 
        "    }}"));
      Resource _eResource_1 = fresh.eResource();
      this.assertEqual(res.getParseResult(), ((XtextResource) _eResource_1).getParseResult());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCompareNodeModel_04() {
    try {
      final ContentAssistFragmentTestLanguageRoot result = this.parseHelper.parse(((((("{  val Object o = \'foo\'    switch(o) {\n" + 
        "        String: \"\".  oString\n") + 
        "    }\n") + 
        "    switch(o) {\n") + 
        "        String: \"\"\n") + 
        "    }}"));
      Resource _eResource = result.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      res.update(60, 1, "t");
      final ContentAssistFragmentTestLanguageRoot fresh = this.parseHelper.parse(((((("{  val Object o = \'foo\'    switch(o) {\n" + 
        "        String: \"\".  tString\n") + 
        "    }\n") + 
        "    switch(o) {\n") + 
        "        String: \"\"\n") + 
        "    }}"));
      Resource _eResource_1 = fresh.eResource();
      this.assertEqual(res.getParseResult(), ((XtextResource) _eResource_1).getParseResult());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertEqual(final IParseResult parsedFromScratch, final IParseResult reparsed) {
    EObject rootFromScratch = parsedFromScratch.getRootASTElement();
    EObject rootReparsed = reparsed.getRootASTElement();
    this.assertEqual(EmfFormatter.objToStr(rootFromScratch), EmfFormatter.objToStr(rootReparsed));
    this.assertEqual(parsedFromScratch.getRootNode(), reparsed.getRootNode());
  }
  
  private void assertEqual(final ICompositeNode fromScratch, final ICompositeNode reparsed) {
    BidiTreeIterator<INode> scratchIterator = fromScratch.getAsTreeIterable().iterator();
    BidiTreeIterator<INode> reparsedIterator = reparsed.getAsTreeIterable().iterator();
    while (scratchIterator.hasNext()) {
      {
        Assert.assertTrue(reparsedIterator.hasNext());
        this.assertEqualNodes(scratchIterator.next(), reparsedIterator.next());
      }
    }
    Assert.assertFalse(scratchIterator.hasNext());
    Assert.assertFalse(reparsedIterator.hasNext());
  }
  
  private void assertEqualNodes(final INode node, final INode other) {
    Assert.assertEquals(node.getClass(), other.getClass());
    if ((node instanceof ILeafNode)) {
      Assert.assertEquals(((ILeafNode)node).getTotalOffset(), other.getTotalOffset());
      Assert.assertEquals(((ILeafNode)node).getTotalLength(), other.getTotalLength());
    }
    Assert.assertEquals(node.getGrammarElement(), other.getGrammarElement());
    Assert.assertEquals(Boolean.valueOf(node.hasDirectSemanticElement()), Boolean.valueOf(other.hasDirectSemanticElement()));
    Assert.assertEquals(node.getSyntaxErrorMessage(), other.getSyntaxErrorMessage());
    if ((node instanceof ICompositeNode)) {
      Assert.assertEquals(((ICompositeNode)node).getText(), ((ICompositeNode)node).getLookAhead(), ((ICompositeNode) other).getLookAhead());
    }
  }
  
  private void assertEqual(final String parsedFromScratch, final String reparsed) {
    boolean _equals = parsedFromScratch.equals(reparsed);
    boolean _not = (!_equals);
    if (_not) {
      throw new ComparisonFailure("Parsed EObjects are not equal", parsedFromScratch, reparsed);
    }
  }
  
  @Test
  public void testReparse() {
    try {
      final ContentAssistFragmentTestLanguageRoot result = this.parseHelper.parse(" newArrayList(1) ");
      Resource _eResource = result.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      res.reparse(" newArrayList(2) ");
      final EObject first = IterableExtensions.<EObject>head(res.getContents());
      Assert.assertTrue((first instanceof ContentAssistFragmentTestLanguageRoot));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAddComment() {
    try {
      final ContentAssistFragmentTestLanguageRoot result = this.parseHelper.parse(" newArrayList(1) ");
      Resource _eResource = result.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      res.update(0, 0, " /* abc */ ");
      final EObject first = IterableExtensions.<EObject>head(res.getContents());
      Assert.assertTrue((first instanceof ContentAssistFragmentTestLanguageRoot));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRemoveSpace() {
    try {
      final ContentAssistFragmentTestLanguageRoot result = this.parseHelper.parse(" newArrayList(1) ");
      Resource _eResource = result.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      res.update(0, 1, "");
      final EObject first = IterableExtensions.<EObject>head(res.getContents());
      Assert.assertTrue((first instanceof ContentAssistFragmentTestLanguageRoot));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

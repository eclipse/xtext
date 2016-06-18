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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
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
import org.eclipse.xtext.xbase.testlanguages.ContentAssistFragmentTestLangInjectorProvider;
import org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot;
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
      InvariantChecker _invariantChecker = new InvariantChecker();
      IParseResult _parseResult = res.getParseResult();
      ICompositeNode _rootNode = _parseResult.getRootNode();
      _invariantChecker.checkInvariant(_rootNode);
      res.update(0, 0, "newArrayList()");
      EList<EObject> _contents = res.getContents();
      final EObject first = IterableExtensions.<EObject>head(_contents);
      EClass _eClass = first.eClass();
      String _name = _eClass.getName();
      Assert.assertTrue(_name, (first instanceof ContentAssistFragmentTestLanguageRoot));
      int _length = "newArrayList(".length();
      res.update(_length, 0, "1");
      EList<EObject> _contents_1 = res.getContents();
      final EObject second = IterableExtensions.<EObject>head(_contents_1);
      EClass _eClass_1 = second.eClass();
      String _name_1 = _eClass_1.getName();
      Assert.assertTrue(_name_1, (second instanceof ContentAssistFragmentTestLanguageRoot));
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
      IParseResult _parseResult = res.getParseResult();
      ICompositeNode _rootNode = _parseResult.getRootNode();
      invariantChecker.checkInvariant(_rootNode);
      res.update(0, 0, "newArrayList()");
      IParseResult _parseResult_1 = res.getParseResult();
      ICompositeNode _rootNode_1 = _parseResult_1.getRootNode();
      invariantChecker.checkInvariant(_rootNode_1);
      EList<EObject> _contents = res.getContents();
      final EObject first = IterableExtensions.<EObject>head(_contents);
      EClass _eClass = first.eClass();
      String _name = _eClass.getName();
      Assert.assertTrue(_name, (first instanceof ContentAssistFragmentTestLanguageRoot));
      int _length = "newArrayList(".length();
      res.update(_length, 0, "1");
      IParseResult _parseResult_2 = res.getParseResult();
      ICompositeNode _rootNode_2 = _parseResult_2.getRootNode();
      invariantChecker.checkInvariant(_rootNode_2);
      EList<EObject> _contents_1 = res.getContents();
      final EObject second = IterableExtensions.<EObject>head(_contents_1);
      EClass _eClass_1 = second.eClass();
      String _name_1 = _eClass_1.getName();
      Assert.assertTrue(_name_1, (second instanceof ContentAssistFragmentTestLanguageRoot));
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
      IParseResult _parseResult = res.getParseResult();
      ICompositeNode _rootNode = _parseResult.getRootNode();
      invariantChecker.checkInvariant(_rootNode);
      res.update(0, 0, "newArrayList()");
      IParseResult _parseResult_1 = res.getParseResult();
      ICompositeNode _rootNode_1 = _parseResult_1.getRootNode();
      invariantChecker.checkInvariant(_rootNode_1);
      EList<EObject> _contents = res.getContents();
      final EObject first = IterableExtensions.<EObject>head(_contents);
      EClass _eClass = first.eClass();
      String _name = _eClass.getName();
      Assert.assertTrue(_name, (first instanceof ContentAssistFragmentTestLanguageRoot));
      int _length = "newArrayList(".length();
      res.update(_length, 0, "1");
      IParseResult _parseResult_2 = res.getParseResult();
      ICompositeNode _rootNode_2 = _parseResult_2.getRootNode();
      invariantChecker.checkInvariant(_rootNode_2);
      EList<EObject> _contents_1 = res.getContents();
      final EObject second = IterableExtensions.<EObject>head(_contents_1);
      EClass _eClass_1 = second.eClass();
      String _name_1 = _eClass_1.getName();
      Assert.assertTrue(_name_1, (second instanceof ContentAssistFragmentTestLanguageRoot));
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
      IParseResult _parseResult = res.getParseResult();
      final ICompositeNode root = _parseResult.getRootNode();
      InvariantChecker _invariantChecker = new InvariantChecker();
      _invariantChecker.checkInvariant(root);
      final HashSet<EObject> set = CollectionLiterals.<EObject>newHashSet();
      BidiTreeIterable<INode> _asTreeIterable = root.getAsTreeIterable();
      for (final INode node : _asTreeIterable) {
        if ((node instanceof ICompositeNode)) {
          EObject _grammarElement = ((ICompositeNode)node).getGrammarElement();
          boolean _tripleNotEquals = (_grammarElement != null);
          if (_tripleNotEquals) {
            EObject _grammarElement_1 = ((ICompositeNode)node).getGrammarElement();
            String _string = _grammarElement_1.toString();
            EObject _grammarElement_2 = ((ICompositeNode)node).getGrammarElement();
            boolean _add = set.add(_grammarElement_2);
            Assert.assertTrue(_string, _add);
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
      IParseResult _parseResult = res.getParseResult();
      final ICompositeNode root = _parseResult.getRootNode();
      final HashSet<EObject> set = CollectionLiterals.<EObject>newHashSet();
      BidiTreeIterable<INode> _asTreeIterable = root.getAsTreeIterable();
      for (final INode node : _asTreeIterable) {
        if ((node instanceof ICompositeNode)) {
          EObject _grammarElement = ((ICompositeNode)node).getGrammarElement();
          boolean _tripleNotEquals = (_grammarElement != null);
          if (_tripleNotEquals) {
            EObject _grammarElement_1 = ((ICompositeNode)node).getGrammarElement();
            String _string = _grammarElement_1.toString();
            EObject _grammarElement_2 = ((ICompositeNode)node).getGrammarElement();
            boolean _add = set.add(_grammarElement_2);
            Assert.assertTrue(_string, _add);
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
      IParseResult _parseResult = res.getParseResult();
      Resource _eResource_1 = fresh.eResource();
      IParseResult _parseResult_1 = ((XtextResource) _eResource_1).getParseResult();
      this.assertEqual(_parseResult, _parseResult_1);
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
      IParseResult _parseResult = res.getParseResult();
      Resource _eResource_1 = fresh.eResource();
      IParseResult _parseResult_1 = ((XtextResource) _eResource_1).getParseResult();
      this.assertEqual(_parseResult, _parseResult_1);
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
      IParseResult _parseResult = res.getParseResult();
      Resource _eResource_1 = fresh.eResource();
      IParseResult _parseResult_1 = ((XtextResource) _eResource_1).getParseResult();
      this.assertEqual(_parseResult, _parseResult_1);
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
      IParseResult _parseResult = res.getParseResult();
      Resource _eResource_1 = fresh.eResource();
      IParseResult _parseResult_1 = ((XtextResource) _eResource_1).getParseResult();
      this.assertEqual(_parseResult, _parseResult_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertEqual(final IParseResult parsedFromScratch, final IParseResult reparsed) {
    EObject rootFromScratch = parsedFromScratch.getRootASTElement();
    EObject rootReparsed = reparsed.getRootASTElement();
    String _objToStr = EmfFormatter.objToStr(rootFromScratch);
    String _objToStr_1 = EmfFormatter.objToStr(rootReparsed);
    this.assertEqual(_objToStr, _objToStr_1);
    ICompositeNode _rootNode = parsedFromScratch.getRootNode();
    ICompositeNode _rootNode_1 = reparsed.getRootNode();
    this.assertEqual(_rootNode, _rootNode_1);
  }
  
  private void assertEqual(final ICompositeNode fromScratch, final ICompositeNode reparsed) {
    BidiTreeIterable<INode> _asTreeIterable = fromScratch.getAsTreeIterable();
    BidiTreeIterator<INode> scratchIterator = _asTreeIterable.iterator();
    BidiTreeIterable<INode> _asTreeIterable_1 = reparsed.getAsTreeIterable();
    BidiTreeIterator<INode> reparsedIterator = _asTreeIterable_1.iterator();
    while (scratchIterator.hasNext()) {
      {
        boolean _hasNext = reparsedIterator.hasNext();
        Assert.assertTrue(_hasNext);
        INode _next = scratchIterator.next();
        INode _next_1 = reparsedIterator.next();
        this.assertEqualNodes(_next, _next_1);
      }
    }
    boolean _hasNext = scratchIterator.hasNext();
    Assert.assertFalse(_hasNext);
    boolean _hasNext_1 = reparsedIterator.hasNext();
    Assert.assertFalse(_hasNext_1);
  }
  
  private void assertEqualNodes(final INode node, final INode other) {
    Class<? extends INode> _class = node.getClass();
    Class<? extends INode> _class_1 = other.getClass();
    Assert.assertEquals(_class, _class_1);
    if ((node instanceof ILeafNode)) {
      int _totalOffset = ((ILeafNode)node).getTotalOffset();
      int _totalOffset_1 = other.getTotalOffset();
      Assert.assertEquals(_totalOffset, _totalOffset_1);
      int _totalLength = ((ILeafNode)node).getTotalLength();
      int _totalLength_1 = other.getTotalLength();
      Assert.assertEquals(_totalLength, _totalLength_1);
    }
    EObject _grammarElement = node.getGrammarElement();
    EObject _grammarElement_1 = other.getGrammarElement();
    Assert.assertEquals(_grammarElement, _grammarElement_1);
    boolean _hasDirectSemanticElement = node.hasDirectSemanticElement();
    boolean _hasDirectSemanticElement_1 = other.hasDirectSemanticElement();
    Assert.assertEquals(Boolean.valueOf(_hasDirectSemanticElement), Boolean.valueOf(_hasDirectSemanticElement_1));
    SyntaxErrorMessage _syntaxErrorMessage = node.getSyntaxErrorMessage();
    SyntaxErrorMessage _syntaxErrorMessage_1 = other.getSyntaxErrorMessage();
    Assert.assertEquals(_syntaxErrorMessage, _syntaxErrorMessage_1);
    if ((node instanceof ICompositeNode)) {
      String _text = ((ICompositeNode)node).getText();
      int _lookAhead = ((ICompositeNode)node).getLookAhead();
      int _lookAhead_1 = ((ICompositeNode) other).getLookAhead();
      Assert.assertEquals(_text, _lookAhead, _lookAhead_1);
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
      EList<EObject> _contents = res.getContents();
      final EObject first = IterableExtensions.<EObject>head(_contents);
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
      EList<EObject> _contents = res.getContents();
      final EObject first = IterableExtensions.<EObject>head(_contents);
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
      EList<EObject> _contents = res.getContents();
      final EObject first = IterableExtensions.<EObject>head(_contents);
      Assert.assertTrue((first instanceof ContentAssistFragmentTestLanguageRoot));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

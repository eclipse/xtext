/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.tests.parsing;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.lang.FileASTNode;
import com.intellij.psi.PsiErrorElement;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter;
import org.eclipse.xtext.idea.tests.parsing.NodeModelPrinter;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.junit.Assert;

@SuppressWarnings("all")
public class XtextResourceAsserts extends Assert {
  @Inject
  @Accessors(AccessorType.PUBLIC_GETTER)
  @Extension
  private NodeModelPrinter nodeModelPrinter;
  
  @Inject
  @Extension
  private InvariantChecker invariantChecker;
  
  public void assertResource(final XtextResource expectedResource, final XtextResource actualResource) {
    this.assertResource(expectedResource, actualResource, true);
  }
  
  public void assertResource(final XtextResource expectedResource, final XtextResource actualResource, final boolean resolve) {
    IParseResult _parseResult = expectedResource.getParseResult();
    final ICompositeNode expectedRootNode = _parseResult.getRootNode();
    IParseResult _parseResult_1 = actualResource.getParseResult();
    final ICompositeNode actualRootNode = _parseResult_1.getRootNode();
    String _print = this.nodeModelPrinter.print(expectedRootNode);
    String _print_1 = this.nodeModelPrinter.print(actualRootNode);
    Assert.assertEquals(_print, _print_1);
    if (resolve) {
      EcoreUtil2.resolveLazyCrossReferences(expectedResource, null);
      EcoreUtil2.resolveLazyCrossReferences(actualResource, null);
    }
    IParseResult _parseResult_2 = expectedResource.getParseResult();
    final EObject expectedRootASTElement = _parseResult_2.getRootASTElement();
    IParseResult _parseResult_3 = actualResource.getParseResult();
    final EObject actualRootASTElement = _parseResult_3.getRootASTElement();
    String _objToStr = EmfFormatter.objToStr(expectedRootASTElement);
    String _objToStr_1 = EmfFormatter.objToStr(actualRootASTElement);
    Assert.assertEquals(_objToStr, _objToStr_1);
    this.invariantChecker.checkInvariant(actualRootNode);
    final PsiToEcoreAdapter psiToEcoreAdapter = PsiToEcoreAdapter.get(actualResource);
    BaseXtextFile _xtextFile = psiToEcoreAdapter.getXtextFile();
    FileASTNode _node = _xtextFile.getNode();
    ASTNode[] _children = _node.getChildren(null);
    for (final ASTNode child : _children) {
      this.assertASTNode(child, actualRootNode, psiToEcoreAdapter);
    }
  }
  
  protected void assertASTNode(final ASTNode astNode, final ICompositeNode rootNode, final PsiToEcoreAdapter psiToEcoreAdapter) {
    if ((!(astNode instanceof PsiErrorElement))) {
      Map<ASTNode, INode> _nodesMapping = psiToEcoreAdapter.getNodesMapping();
      final INode node = _nodesMapping.get(astNode);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("The node is null the ast node: ");
      _builder.append(astNode, "");
      Assert.assertNotNull(_builder.toString(), node);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("The node ");
      _builder_1.append(node, "");
      _builder_1.append(" is not a part of the tree for the ast node: ");
      _builder_1.append(astNode, "");
      boolean _belongsTo = this.belongsTo(node, rootNode);
      Assert.assertTrue(_builder_1.toString(), _belongsTo);
      Map<INode, List<ASTNode>> _reverseNodesMapping = psiToEcoreAdapter.getReverseNodesMapping();
      final List<ASTNode> reverseNodesMapping = _reverseNodesMapping.get(node);
      Assert.assertNotNull(reverseNodesMapping);
      boolean _contains = reverseNodesMapping.contains(astNode);
      Assert.assertTrue(_contains);
    }
    ASTNode[] _children = astNode.getChildren(null);
    for (final ASTNode child : _children) {
      this.assertASTNode(child, rootNode, psiToEcoreAdapter);
    }
  }
  
  protected boolean belongsTo(final INode node, final ICompositeNode rootNode) {
    BidiTreeIterable<INode> _asTreeIterable = rootNode.getAsTreeIterable();
    final Function1<INode, Boolean> _function = new Function1<INode, Boolean>() {
      @Override
      public Boolean apply(final INode it) {
        return Boolean.valueOf(Objects.equal(it, node));
      }
    };
    return IterableExtensions.<INode>exists(_asTreeIterable, _function);
  }
  
  @Pure
  public NodeModelPrinter getNodeModelPrinter() {
    return this.nodeModelPrinter;
  }
}

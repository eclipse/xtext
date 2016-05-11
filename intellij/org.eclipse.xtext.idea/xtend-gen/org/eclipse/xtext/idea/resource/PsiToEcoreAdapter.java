/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.intellij.lang.ASTNode;
import com.intellij.lang.FileASTNode;
import com.intellij.psi.tree.IElementType;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformationContext;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.SyntheticCompositeNode;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.lib.Pure;

@EmfAdaptable
@SuppressWarnings("all")
public class PsiToEcoreAdapter {
  public static class PsiToEcoreAdapterAdapter extends AdapterImpl {
    private PsiToEcoreAdapter element;
    
    public PsiToEcoreAdapterAdapter(final PsiToEcoreAdapter element) {
      this.element = element;
    }
    
    public PsiToEcoreAdapter get() {
      return this.element;
    }
    
    @Override
    public boolean isAdapterForType(final Object object) {
      return object == PsiToEcoreAdapter.class;
    }
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final BaseXtextFile xtextFile;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final Map<ASTNode, INode> nodesMapping;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final Map<INode, List<ASTNode>> reverseNodesMapping;
  
  public PsiToEcoreAdapter(final PsiToEcoreTransformationContext context) {
    BaseXtextFile _xtextFile = context.getXtextFile();
    this.xtextFile = _xtextFile;
    Map<ASTNode, INode> _nodesMapping = context.getNodesMapping();
    Map<ASTNode, INode> _unmodifiableView = Collections.<ASTNode, INode>unmodifiableMap(_nodesMapping);
    this.nodesMapping = _unmodifiableView;
    Map<INode, List<ASTNode>> _reverseNodesMapping = context.getReverseNodesMapping();
    Map<INode, List<ASTNode>> _unmodifiableView_1 = Collections.<INode, List<ASTNode>>unmodifiableMap(_reverseNodesMapping);
    this.reverseNodesMapping = _unmodifiableView_1;
  }
  
  public INode getINode(final ASTNode astNode) {
    if ((astNode == null)) {
      return null;
    }
    INode node = this.nodesMapping.get(astNode);
    final IElementType elementType = astNode.getElementType();
    if ((elementType instanceof IGrammarAwareElementType)) {
      final EObject grammarElement = ((IGrammarAwareElementType)elementType).getGrammarElement();
      while (((node instanceof ICompositeNode) && (node.getGrammarElement() != grammarElement))) {
        INode _firstChild = ((ICompositeNode) node).getFirstChild();
        node = _firstChild;
      }
    }
    return node;
  }
  
  public ASTNode getASTNode(final INode node) {
    if ((node == null)) {
      return null;
    }
    int index = 0;
    INode originalNode = node;
    while ((originalNode instanceof SyntheticCompositeNode)) {
      {
        ICompositeNode _parent = ((SyntheticCompositeNode)originalNode).getParent();
        originalNode = _parent;
        index++;
      }
    }
    final List<ASTNode> astNodes = this.reverseNodesMapping.get(originalNode);
    if (((astNodes == null) && (node.getRootNode() == node))) {
      FileASTNode _node = this.xtextFile.getNode();
      return _node.getFirstChildNode();
    }
    return astNodes.get(index);
  }
  
  public static PsiToEcoreAdapter findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof PsiToEcoreAdapter.PsiToEcoreAdapterAdapter) {
    		return ((PsiToEcoreAdapter.PsiToEcoreAdapterAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public static PsiToEcoreAdapter removeFromEmfObject(final Notifier emfObject) {
    List<Adapter> adapters = emfObject.eAdapters();
    for(int i = 0, max = adapters.size(); i < max; i++) {
    	Adapter adapter = adapters.get(i);
    	if (adapter instanceof PsiToEcoreAdapter.PsiToEcoreAdapterAdapter) {
    		emfObject.eAdapters().remove(i);
    		return ((PsiToEcoreAdapter.PsiToEcoreAdapterAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    PsiToEcoreAdapter result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for PsiToEcoreAdapter");
    PsiToEcoreAdapter.PsiToEcoreAdapterAdapter adapter = new PsiToEcoreAdapter.PsiToEcoreAdapterAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
  
  @Pure
  public BaseXtextFile getXtextFile() {
    return this.xtextFile;
  }
  
  @Pure
  public Map<ASTNode, INode> getNodesMapping() {
    return this.nodesMapping;
  }
  
  @Pure
  public Map<INode, List<ASTNode>> getReverseNodesMapping() {
    return this.reverseNodesMapping;
  }
}

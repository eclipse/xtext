/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.nodemodel;

import com.google.inject.ImplementedBy;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.Key;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.tree.IElementType;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.nodemodel.ASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

@ImplementedBy(ASTNodeAwareNodeModelBuilder.class)
@SuppressWarnings("all")
public interface IASTNodeAwareNodeModelBuilder {
  public final static Key<Boolean> HIDDEN_KEY = Key.<Boolean>create("HIDDEN_KEY");
  
  public final static Key<Integer> LOOK_AHEAD_KEY = Key.<Integer>create("LOOK_AHEAD_KEY");
  
  public final static Key<IElementType> TOKEN_TYPE_KEY = Key.<IElementType>create("TOKEN_TYPE_KEY");
  
  public final static Key<Boolean> HAS_SEMANTIC_ELEMENT_KEY = Key.<Boolean>create("HAS_SEMANTIC_ELEMENT_KEY");
  
  public abstract Map<ASTNode, INode> getNodesMapping();
  
  public abstract Map<INode, List<ASTNode>> getReverseNodesMapping();
  
  public abstract ICompositeNode newRootNode(final String text);
  
  public abstract ILeafNode newLeafNode(final ASTNode astNode, final ICompositeNode parent);
  
  public abstract ILeafNode newLeafNode(final LeafElement leafElement, final EObject grammarElement, final ICompositeNode parent);
  
  public abstract ICompositeNode newCompositeNode(final CompositeElement compositeElement, final ICompositeNode parent);
  
  public abstract ICompositeNode newCompositeNodeAsParentOf(final CompositeElement compositeElement, final EObject grammarElement, final int lookahead, final ICompositeNode existing);
  
  public abstract void associateWithSemanticElement(final ICompositeNode node, final EObject astElement);
  
  public abstract INode setSyntaxError(final INode node, final SyntaxErrorMessage errorMessage);
  
  public abstract ICompositeNode compressAndReturnParent(final ICompositeNode compositeNode);
}

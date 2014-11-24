package org.eclipse.xtext.idea.nodemodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.nodemodel.impl.RootNode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class ASTNodeAwareNodeModelBuilder extends NodeModelBuilder implements IASTNodeAwareNodeModelBuilder {
  public final static Object HIDDEN_KEY /* Skipped initializer because of errors */;
  
  public final static Object LOOK_AHEAD_KEY /* Skipped initializer because of errors */;
  
  public final static Object TOKEN_TYPE_KEY /* Skipped initializer because of errors */;
  
  @Inject
  private IGrammarAccess grammarAccess;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final /* Map<ASTNode, INode> */Object nodesMapping = CollectionLiterals.<ASTNode, INode>newHashMap();
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final /* Map<INode, List<ASTNode>> */Object reverseNodesMapping = CollectionLiterals.<INode, List<ASTNode>>newHashMap();
  
  protected void associate(final /* ASTNode */Object astNode, final INode node) {
    this.nodesMapping.put(astNode, node);
    List<ASTNode> _elvis = null;
    List<ASTNode> _get = this.reverseNodesMapping.get(node);
    if (_get != null) {
      _elvis = _get;
    } else {
      ArrayList<ASTNode> _xblockexpression = null;
      {
        final ArrayList<ASTNode> result = CollectionLiterals.<ASTNode>newArrayList();
        this.reverseNodesMapping.put(node, result);
        _xblockexpression = result;
      }
      _elvis = _xblockexpression;
    }
    final List<ASTNode> reverseMapping = _elvis;
    reverseMapping.add(astNode);
  }
  
  protected void replaceAssociations(final INode oldNode, final INode newNode) {
    final List<ASTNode> mapping = this.reverseNodesMapping.remove(oldNode);
    boolean _notEquals = (!Objects.equal(mapping, null));
    if (_notEquals) {
      for (final ASTNode astNode : mapping) {
        this.associate(astNode, newNode);
      }
    }
  }
  
  protected void removeAssociations(final INode node) {
    final List<ASTNode> mapping = this.reverseNodesMapping.remove(node);
    boolean _notEquals = (!Objects.equal(mapping, null));
    if (_notEquals) {
      for (final ASTNode astNode : mapping) {
        this.nodesMapping.remove(astNode);
      }
    }
  }
  
  protected void replaceByRootNode(final CompositeNode oldNode, final RootNode rootNode) {
    final INode firstChild = rootNode.getFirstChild();
    super.replaceByRootNode(oldNode, rootNode);
    boolean _notEquals = (!Objects.equal(firstChild, null));
    if (_notEquals) {
      this.removeAssociations(firstChild);
    }
    this.replaceAssociations(oldNode, rootNode);
  }
  
  protected void replaceChildren(final AbstractNode oldNode, final AbstractNode newNode) {
    super.replaceChildren(oldNode, newNode);
    this.replaceAssociations(oldNode, newNode);
  }
  
  public ILeafNode newLeafNode(final /* LeafElement */Object it, final EObject grammarElement, final ICompositeNode parent) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field startOffset is undefined for the type ASTNodeAwareNodeModelBuilder"
      + "\nThe method or field textLength is undefined for the type ASTNodeAwareNodeModelBuilder");
  }
  
  public ILeafNode newLeafNode(final /* ASTNode */Object it, final ICompositeNode parent) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field elementType is undefined for the type ASTNodeAwareNodeModelBuilder"
      + "\nThe method getUserData is undefined for the type ASTNodeAwareNodeModelBuilder"
      + "\nThe method getUserData is undefined for the type ASTNodeAwareNodeModelBuilder"
      + "\nThe method or field startOffset is undefined for the type ASTNodeAwareNodeModelBuilder"
      + "\nThe method or field textLength is undefined for the type ASTNodeAwareNodeModelBuilder"
      + "\ngrammarElement cannot be resolved"
      + "\n!= cannot be resolved"
      + "\ntoString cannot be resolved"
      + "\nlexerRule cannot be resolved"
      + "\ngetLexerRuleName cannot be resolved"
      + "\n?: cannot be resolved");
  }
  
  public ICompositeNode newCompositeNode(final /* CompositeElement */Object it, final ICompositeNode parent) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field elementType is undefined for the type ASTNodeAwareNodeModelBuilder"
      + "\nThe method getUserData is undefined for the type ASTNodeAwareNodeModelBuilder"
      + "\ngrammarElement cannot be resolved"
      + "\nnewCompositeNode cannot be resolved");
  }
  
  public ICompositeNode newCompositeNodeAsParentOf(final /* CompositeElement */Object it, final EObject grammarElement, final int lookahead, final ICompositeNode existing) {
    ICompositeNode _xblockexpression = null;
    {
      final ICompositeNode compositeNode = this.newCompositeNodeAsParentOf(grammarElement, lookahead, existing);
      this.associate(this, compositeNode);
      _xblockexpression = compositeNode;
    }
    return _xblockexpression;
  }
  
  public ICompositeNode newRootNode(final /* PsiFile */Object psiFile) {
    throw new Error("Unresolved compilation problems:"
      + "\ntext cannot be resolved");
  }
  
  @Pure
  public /* Map<ASTNode, INode> */Object getNodesMapping() {
    return this.nodesMapping;
  }
  
  @Pure
  public /* Map<INode, List<ASTNode>> */Object getReverseNodesMapping() {
    return this.reverseNodesMapping;
  }
}

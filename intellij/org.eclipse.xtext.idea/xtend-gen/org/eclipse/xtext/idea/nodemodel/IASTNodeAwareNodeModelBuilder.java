package org.eclipse.xtext.idea.nodemodel;

import com.google.inject.ImplementedBy;
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
  public abstract /* Map<ASTNode, INode> */Object getNodesMapping();
  
  public abstract /* Map<INode, List<ASTNode>> */Object getReverseNodesMapping();
  
  public abstract ILeafNode newLeafNode(final /* ASTNode */Object astNode, final ICompositeNode parent);
  
  public abstract ILeafNode newLeafNode(final /* LeafElement */Object leafElement, final EObject grammarElement, final ICompositeNode parent);
  
  public abstract ICompositeNode newCompositeNode(final /* CompositeElement */Object compositeElement, final ICompositeNode parent);
  
  public abstract ICompositeNode newCompositeNodeAsParentOf(final /* CompositeElement */Object compositeElement, final EObject grammarElement, final int lookahead, final ICompositeNode existing);
  
  public abstract ICompositeNode newRootNode(final /* PsiFile */Object psiFile);
  
  public abstract void associateWithSemanticElement(final ICompositeNode node, final EObject astElement);
  
  public abstract INode setSyntaxError(final INode node, final SyntaxErrorMessage errorMessage);
  
  public abstract ICompositeNode compressAndReturnParent(final ICompositeNode compositeNode);
}

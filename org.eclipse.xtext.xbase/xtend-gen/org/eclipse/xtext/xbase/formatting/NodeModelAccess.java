package org.eclipse.xtext.xbase.formatting;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @deprecated use {@link ITextRegionAccess}
 */
@Deprecated
@SuppressWarnings("all")
public class NodeModelAccess {
  public INode nodeForEObject(final EObject obj) {
    return NodeModelUtils.findActualNodeFor(obj);
  }
  
  public ILeafNode nodeForKeyword(final EObject obj, final String kw) {
    ILeafNode _xblockexpression = null;
    {
      final ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
      final Function1<INode, Boolean> _function = (INode it) -> {
        return Boolean.valueOf(((Objects.equal(it.getSemanticElement(), obj) && (it.getGrammarElement() instanceof Keyword)) && Objects.equal(it.getText(), kw)));
      };
      INode _findFirst = IterableExtensions.<INode>findFirst(node.getAsTreeIterable(), _function);
      _xblockexpression = ((ILeafNode) _findFirst);
    }
    return _xblockexpression;
  }
  
  public Iterable<ILeafNode> nodesForKeyword(final EObject obj, final String kw) {
    Iterable<ILeafNode> _xblockexpression = null;
    {
      final ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
      final Function1<ILeafNode, Boolean> _function = (ILeafNode it) -> {
        return Boolean.valueOf(((Objects.equal(it.getSemanticElement(), obj) && (it.getGrammarElement() instanceof Keyword)) && Objects.equal(it.getText(), kw)));
      };
      _xblockexpression = IterableExtensions.<ILeafNode>filter(Iterables.<ILeafNode>filter(node.getAsTreeIterable(), ILeafNode.class), _function);
    }
    return _xblockexpression;
  }
  
  public INode nodeForFeature(final EObject obj, final EStructuralFeature feature) {
    return IterableExtensions.<INode>head(NodeModelUtils.findNodesForFeature(obj, feature));
  }
  
  public Iterable<INode> nodesForFeature(final EObject obj, final EStructuralFeature feature) {
    return NodeModelUtils.findNodesForFeature(obj, feature);
  }
  
  public ILeafNode immediatelyFollowingKeyword(final EObject obj, final String kw) {
    return this.immediatelyFollowingKeyword(this.nodeForEObject(obj), kw);
  }
  
  public ILeafNode immediatelyFollowingKeyword(final INode node, final String kw) {
    ILeafNode _xblockexpression = null;
    {
      INode current = node;
      while ((current instanceof ICompositeNode)) {
        current = ((ICompositeNode)current).getLastChild();
      }
      final INode current1 = current;
      final Function1<ILeafNode, Boolean> _function = (ILeafNode it) -> {
        return Boolean.valueOf(((!Objects.equal(current1, it)) && (it.getGrammarElement() instanceof Keyword)));
      };
      final ILeafNode result = this.findNextLeaf(current1, _function);
      ILeafNode _xifexpression = null;
      if (((result != null) && Objects.equal(result.getText(), kw))) {
        _xifexpression = result;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public ILeafNode findNextLeaf(final INode node, final Function1<? super ILeafNode, ? extends Boolean> matches) {
    Object _xifexpression = null;
    if ((node != null)) {
      if (((node instanceof ILeafNode) && (matches.apply(((ILeafNode) node))).booleanValue())) {
        return ((ILeafNode) node);
      }
      final NodeIterator ni = new NodeIterator(node);
      while (ni.hasNext()) {
        {
          final INode next = ni.next();
          if (((next instanceof ILeafNode) && (matches.apply(((ILeafNode) next))).booleanValue())) {
            return ((ILeafNode) next);
          }
        }
      }
    }
    return ((ILeafNode)_xifexpression);
  }
}

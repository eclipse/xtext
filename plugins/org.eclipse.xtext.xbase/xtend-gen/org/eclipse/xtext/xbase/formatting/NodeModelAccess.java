package org.eclipse.xtext.xbase.formatting;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractGrammarElement;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
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
      BidiTreeIterable<INode> _asTreeIterable = node.getAsTreeIterable();
      final Function1<INode, Boolean> _function = new Function1<INode, Boolean>() {
        @Override
        public Boolean apply(final INode it) {
          boolean _and = false;
          boolean _and_1 = false;
          EObject _semanticElement = it.getSemanticElement();
          boolean _equals = Objects.equal(_semanticElement, obj);
          if (!_equals) {
            _and_1 = false;
          } else {
            AbstractGrammarElement _grammarElement = it.getGrammarElement();
            _and_1 = (_grammarElement instanceof Keyword);
          }
          if (!_and_1) {
            _and = false;
          } else {
            String _text = it.getText();
            boolean _equals_1 = Objects.equal(_text, kw);
            _and = _equals_1;
          }
          return Boolean.valueOf(_and);
        }
      };
      INode _findFirst = IterableExtensions.<INode>findFirst(_asTreeIterable, _function);
      _xblockexpression = ((ILeafNode) _findFirst);
    }
    return _xblockexpression;
  }
  
  public Iterable<ILeafNode> nodesForKeyword(final EObject obj, final String kw) {
    Iterable<ILeafNode> _xblockexpression = null;
    {
      final ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
      BidiTreeIterable<INode> _asTreeIterable = node.getAsTreeIterable();
      Iterable<ILeafNode> _filter = Iterables.<ILeafNode>filter(_asTreeIterable, ILeafNode.class);
      final Function1<ILeafNode, Boolean> _function = new Function1<ILeafNode, Boolean>() {
        @Override
        public Boolean apply(final ILeafNode it) {
          boolean _and = false;
          boolean _and_1 = false;
          EObject _semanticElement = it.getSemanticElement();
          boolean _equals = Objects.equal(_semanticElement, obj);
          if (!_equals) {
            _and_1 = false;
          } else {
            AbstractGrammarElement _grammarElement = it.getGrammarElement();
            _and_1 = (_grammarElement instanceof Keyword);
          }
          if (!_and_1) {
            _and = false;
          } else {
            String _text = it.getText();
            boolean _equals_1 = Objects.equal(_text, kw);
            _and = _equals_1;
          }
          return Boolean.valueOf(_and);
        }
      };
      _xblockexpression = IterableExtensions.<ILeafNode>filter(_filter, _function);
    }
    return _xblockexpression;
  }
  
  public INode nodeForFeature(final EObject obj, final EStructuralFeature feature) {
    List<INode> _findNodesForFeature = NodeModelUtils.findNodesForFeature(obj, feature);
    return IterableExtensions.<INode>head(_findNodesForFeature);
  }
  
  public Iterable<INode> nodesForFeature(final EObject obj, final EStructuralFeature feature) {
    return NodeModelUtils.findNodesForFeature(obj, feature);
  }
  
  public ILeafNode immediatelyFollowingKeyword(final EObject obj, final String kw) {
    INode _nodeForEObject = this.nodeForEObject(obj);
    return this.immediatelyFollowingKeyword(_nodeForEObject, kw);
  }
  
  public ILeafNode immediatelyFollowingKeyword(final INode node, final String kw) {
    ILeafNode _xblockexpression = null;
    {
      INode current = node;
      while ((current instanceof ICompositeNode)) {
        INode _lastChild = ((ICompositeNode)current).getLastChild();
        current = _lastChild;
      }
      final INode current1 = current;
      final Function1<ILeafNode, Boolean> _function = new Function1<ILeafNode, Boolean>() {
        @Override
        public Boolean apply(final ILeafNode it) {
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(current1, it));
          if (!_notEquals) {
            _and = false;
          } else {
            AbstractGrammarElement _grammarElement = it.getGrammarElement();
            _and = (_grammarElement instanceof Keyword);
          }
          return Boolean.valueOf(_and);
        }
      };
      final ILeafNode result = this.findNextLeaf(current1, _function);
      ILeafNode _xifexpression = null;
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(result, null));
      if (!_notEquals) {
        _and = false;
      } else {
        String _text = result.getText();
        boolean _equals = Objects.equal(_text, kw);
        _and = _equals;
      }
      if (_and) {
        _xifexpression = result;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public ILeafNode findNextLeaf(final INode node, final Function1<? super ILeafNode, ? extends Boolean> matches) {
    Object _xifexpression = null;
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      boolean _and = false;
      if (!(node instanceof ILeafNode)) {
        _and = false;
      } else {
        Boolean _apply = matches.apply(((ILeafNode) node));
        _and = (_apply).booleanValue();
      }
      if (_and) {
        return ((ILeafNode) node);
      }
      final NodeIterator ni = new NodeIterator(node);
      while (ni.hasNext()) {
        {
          final INode next = ni.next();
          boolean _and_1 = false;
          if (!(next instanceof ILeafNode)) {
            _and_1 = false;
          } else {
            Boolean _apply_1 = matches.apply(((ILeafNode) next));
            _and_1 = (_apply_1).booleanValue();
          }
          if (_and_1) {
            return ((ILeafNode) next);
          }
        }
      }
    }
    return ((ILeafNode)_xifexpression);
  }
}

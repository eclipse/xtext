package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class NodeModelAccess {
  public INode nodeForEObject(final EObject obj) {
    ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(obj);
    return _findActualNodeFor;
  }
  
  public ILeafNode nodeForKeyword(final EObject obj, final String kw) {
    ILeafNode _xblockexpression = null;
    {
      final ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
      BidiTreeIterable<INode> _asTreeIterable = node.getAsTreeIterable();
      final Function1<INode,Boolean> _function = new Function1<INode,Boolean>() {
          public Boolean apply(final INode it) {
            boolean _and = false;
            boolean _and_1 = false;
            EObject _semanticElement = it.getSemanticElement();
            boolean _equals = Objects.equal(_semanticElement, obj);
            if (!_equals) {
              _and_1 = false;
            } else {
              EObject _grammarElement = it.getGrammarElement();
              _and_1 = (_equals && (_grammarElement instanceof Keyword));
            }
            if (!_and_1) {
              _and = false;
            } else {
              String _text = it.getText();
              boolean _equals_1 = Objects.equal(_text, kw);
              _and = (_and_1 && _equals_1);
            }
            return Boolean.valueOf(_and);
          }
        };
      INode _findFirst = IterableExtensions.<INode>findFirst(_asTreeIterable, _function);
      _xblockexpression = (((ILeafNode) _findFirst));
    }
    return _xblockexpression;
  }
  
  public INode nodeForFeature(final EObject obj, final EStructuralFeature feature) {
    List<INode> _findNodesForFeature = NodeModelUtils.findNodesForFeature(obj, feature);
    INode _head = IterableExtensions.<INode>head(_findNodesForFeature);
    return _head;
  }
  
  public Iterable<INode> features(final EObject obj, final EStructuralFeature feature) {
    List<INode> _findNodesForFeature = NodeModelUtils.findNodesForFeature(obj, feature);
    return _findNodesForFeature;
  }
  
  public ILeafNode immediatelyFollowingKeyword(final INode node, final String kw) {
    ILeafNode _xblockexpression = null;
    {
      INode current = node;
      boolean _while = (current instanceof ICompositeNode);
      while (_while) {
        INode _lastChild = ((ICompositeNode) current).getLastChild();
        current = _lastChild;
        _while = (current instanceof ICompositeNode);
      }
      final INode current1 = current;
      final Function1<ILeafNode,Boolean> _function = new Function1<ILeafNode,Boolean>() {
          public Boolean apply(final ILeafNode it) {
            boolean _and = false;
            boolean _notEquals = (!Objects.equal(current1, it));
            if (!_notEquals) {
              _and = false;
            } else {
              EObject _grammarElement = it.getGrammarElement();
              _and = (_notEquals && (_grammarElement instanceof Keyword));
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
        _and = (_notEquals && _equals);
      }
      if (_and) {
        _xifexpression = result;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public Pair<Integer,Integer> getRangeBefore(final INode node) {
    Pair<Integer,Integer> _xblockexpression = null;
    {
      final Function1<ILeafNode,Boolean> _function = new Function1<ILeafNode,Boolean>() {
          public Boolean apply(final ILeafNode it) {
            boolean _isHidden = it.isHidden();
            boolean _not = (!_isHidden);
            return Boolean.valueOf(_not);
          }
        };
      final ILeafNode start = this.findNextLeaf(node, _function);
      final ILeafNode previous = this.findPreviousLeaf(start);
      Pair<Integer,Integer> _xifexpression = null;
      boolean _isHidden = previous.isHidden();
      if (_isHidden) {
        int _offset = previous.getOffset();
        int _length = previous.getLength();
        Pair<Integer,Integer> _mappedTo = Pair.<Integer, Integer>of(Integer.valueOf(_offset), Integer.valueOf(_length));
        _xifexpression = _mappedTo;
      } else {
        int _offset_1 = start.getOffset();
        Pair<Integer,Integer> _mappedTo_1 = Pair.<Integer, Integer>of(Integer.valueOf(_offset_1), Integer.valueOf(0));
        _xifexpression = _mappedTo_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public ILeafNode whitespaceBefore(final INode node) {
    ILeafNode _xblockexpression = null;
    {
      final Function1<ILeafNode,Boolean> _function = new Function1<ILeafNode,Boolean>() {
          public Boolean apply(final ILeafNode it) {
            boolean _isHidden = it.isHidden();
            boolean _not = (!_isHidden);
            return Boolean.valueOf(_not);
          }
        };
      final ILeafNode start = this.findNextLeaf(node, _function);
      final ILeafNode previous = this.findPreviousLeaf(start);
      ILeafNode _xifexpression = null;
      boolean _isHidden = previous.isHidden();
      if (_isHidden) {
        _xifexpression = previous;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public Pair<Integer,Integer> getRangeAfter(final INode node) {
    Pair<Integer,Integer> _xblockexpression = null;
    {
      final Function1<ILeafNode,Boolean> _function = new Function1<ILeafNode,Boolean>() {
          public Boolean apply(final ILeafNode it) {
            boolean _isHidden = it.isHidden();
            boolean _not = (!_isHidden);
            return Boolean.valueOf(_not);
          }
        };
      final ILeafNode start = this.findPreviousLeaf(node, _function);
      final ILeafNode next = this.findNextLeaf(start);
      Pair<Integer,Integer> _xifexpression = null;
      boolean _notEquals = (!Objects.equal(next, null));
      if (_notEquals) {
        Pair<Integer,Integer> _xifexpression_1 = null;
        boolean _isHidden = next.isHidden();
        if (_isHidden) {
          int _offset = next.getOffset();
          int _length = next.getLength();
          Pair<Integer,Integer> _mappedTo = Pair.<Integer, Integer>of(Integer.valueOf(_offset), Integer.valueOf(_length));
          _xifexpression_1 = _mappedTo;
        } else {
          int _offset_1 = start.getOffset();
          int _length_1 = start.getLength();
          int _plus = (_offset_1 + _length_1);
          Pair<Integer,Integer> _mappedTo_1 = Pair.<Integer, Integer>of(Integer.valueOf(_plus), Integer.valueOf(0));
          _xifexpression_1 = _mappedTo_1;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected ILeafNode findNextLeaf(final INode node, final Function1<? super ILeafNode,? extends Boolean> matches) {
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      boolean _and = false;
      if (!(node instanceof ILeafNode)) {
        _and = false;
      } else {
        Boolean _apply = matches.apply(((ILeafNode) node));
        _and = ((node instanceof ILeafNode) && (_apply).booleanValue());
      }
      if (_and) {
        return ((ILeafNode) node);
      }
      NodeIterator _nodeIterator = new NodeIterator(node);
      final NodeIterator ni = _nodeIterator;
      boolean _hasNext = ni.hasNext();
      boolean _while = _hasNext;
      while (_while) {
        {
          final INode next = ni.next();
          boolean _and_1 = false;
          if (!(next instanceof ILeafNode)) {
            _and_1 = false;
          } else {
            Boolean _apply_1 = matches.apply(((ILeafNode) next));
            _and_1 = ((next instanceof ILeafNode) && (_apply_1).booleanValue());
          }
          if (_and_1) {
            return ((ILeafNode) next);
          }
        }
        boolean _hasNext_1 = ni.hasNext();
        _while = _hasNext_1;
      }
    }
    return null;
  }
  
  protected ILeafNode findNextLeaf(final INode node) {
    NodeIterator _nodeIterator = new NodeIterator(node);
    final NodeIterator ni = _nodeIterator;
    boolean _hasNext = ni.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        final INode next = ni.next();
        if ((next instanceof ILeafNode)) {
          return ((ILeafNode) next);
        }
      }
      boolean _hasNext_1 = ni.hasNext();
      _while = _hasNext_1;
    }
    return null;
  }
  
  protected ILeafNode findPreviousLeaf(final INode node, final Function1<? super ILeafNode,? extends Boolean> matches) {
    INode current = node;
    boolean _while = (current instanceof ICompositeNode);
    while (_while) {
      INode _lastChild = ((ICompositeNode) current).getLastChild();
      current = _lastChild;
      _while = (current instanceof ICompositeNode);
    }
    boolean _and = false;
    if (!(current instanceof ILeafNode)) {
      _and = false;
    } else {
      Boolean _apply = matches.apply(((ILeafNode) current));
      _and = ((current instanceof ILeafNode) && (_apply).booleanValue());
    }
    if (_and) {
      return ((ILeafNode) current);
    }
    NodeIterator _nodeIterator = new NodeIterator(current);
    final NodeIterator ni = _nodeIterator;
    boolean _hasPrevious = ni.hasPrevious();
    boolean _while_1 = _hasPrevious;
    while (_while_1) {
      {
        final INode previous = ni.previous();
        boolean _and_1 = false;
        if (!(previous instanceof ILeafNode)) {
          _and_1 = false;
        } else {
          Boolean _apply_1 = matches.apply(((ILeafNode) previous));
          _and_1 = ((previous instanceof ILeafNode) && (_apply_1).booleanValue());
        }
        if (_and_1) {
          return ((ILeafNode) previous);
        }
      }
      boolean _hasPrevious_1 = ni.hasPrevious();
      _while_1 = _hasPrevious_1;
    }
    return null;
  }
  
  protected ILeafNode findPreviousLeaf(final INode node) {
    INode current = node;
    boolean _while = (current instanceof ICompositeNode);
    while (_while) {
      INode _lastChild = ((ICompositeNode) current).getLastChild();
      current = _lastChild;
      _while = (current instanceof ICompositeNode);
    }
    NodeIterator _nodeIterator = new NodeIterator(current);
    final NodeIterator ni = _nodeIterator;
    boolean _hasPrevious = ni.hasPrevious();
    boolean _while_1 = _hasPrevious;
    while (_while_1) {
      {
        final INode previous = ni.previous();
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(previous, current));
        if (!_notEquals) {
          _and = false;
        } else {
          _and = (_notEquals && (previous instanceof ILeafNode));
        }
        if (_and) {
          return ((ILeafNode) previous);
        }
      }
      boolean _hasPrevious_1 = ni.hasPrevious();
      _while_1 = _hasPrevious_1;
    }
    return null;
  }
}

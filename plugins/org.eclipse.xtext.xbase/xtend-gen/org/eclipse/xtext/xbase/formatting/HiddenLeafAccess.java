package org.eclipse.xtext.xbase.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.xbase.formatting.CommentInfo;
import org.eclipse.xtext.xbase.formatting.HiddenLeafs;
import org.eclipse.xtext.xbase.formatting.LeafInfo;
import org.eclipse.xtext.xbase.formatting.NodeModelAccess;
import org.eclipse.xtext.xbase.formatting.WhitespaceInfo;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class HiddenLeafAccess {
  @Inject
  @Extension
  private NodeModelAccess _nodeModelAccess;
  
  public HiddenLeafs getHiddenLeafsBefore(final INode node) {
    HiddenLeafs _xblockexpression = null;
    {
      final Function1<ILeafNode,Boolean> _function = new Function1<ILeafNode,Boolean>() {
        public Boolean apply(final ILeafNode it) {
          boolean _isHidden = it.isHidden();
          boolean _not = (!_isHidden);
          return Boolean.valueOf(_not);
        }
      };
      final ILeafNode start = this._nodeModelAccess.findNextLeaf(node, _function);
      final List<ILeafNode> nodes = this.findPreviousHiddenLeafs(start);
      HiddenLeafs _xifexpression = null;
      boolean _notEquals = (!Objects.equal(start, null));
      if (_notEquals) {
        int _xifexpression_1 = (int) 0;
        boolean _isEmpty = nodes.isEmpty();
        if (_isEmpty) {
          int _offset = start.getOffset();
          _xifexpression_1 = _offset;
        } else {
          ILeafNode _head = IterableExtensions.<ILeafNode>head(nodes);
          int _offset_1 = _head.getOffset();
          _xifexpression_1 = _offset_1;
        }
        HiddenLeafs _newHiddenLeafs = this.newHiddenLeafs(_xifexpression_1, nodes);
        _xifexpression = _newHiddenLeafs;
      } else {
        int _offset_2 = 0;
        if (node!=null) {
          _offset_2=node.getOffset();
        }
        HiddenLeafs _hiddenLeafs = new HiddenLeafs(_offset_2);
        _xifexpression = _hiddenLeafs;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected HiddenLeafs newHiddenLeafs(final int offset, final List<ILeafNode> nodes) {
    HiddenLeafs _xblockexpression = null;
    {
      HiddenLeafs _hiddenLeafs = new HiddenLeafs(offset);
      final HiddenLeafs result = _hiddenLeafs;
      boolean trailing = true;
      for (final ILeafNode node : nodes) {
        {
          boolean comment = false;
          int newLines = 0;
          String _text = node.getText();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_text);
          boolean _not = (!_isNullOrEmpty);
          if (_not) {
            String _text_1 = node.getText();
            int _length = _text_1.length();
            int _minus = (_length - 1);
            IntegerRange _upTo = new IntegerRange(0, _minus);
            for (final Integer i : _upTo) {
              {
                String _text_2 = node.getText();
                final char c = _text_2.charAt((i).intValue());
                String _string = Character.valueOf(c).toString();
                boolean _equals = Objects.equal(_string, "\n");
                if (_equals) {
                  int _plus = (newLines + 1);
                  newLines = _plus;
                } else {
                  boolean _isWhitespace = Character.isWhitespace(c);
                  boolean _not_1 = (!_isWhitespace);
                  if (_not_1) {
                    comment = true;
                  }
                }
              }
            }
          }
          if (comment) {
            List<LeafInfo> _leafs = result.getLeafs();
            LeafInfo _last = IterableExtensions.<LeafInfo>last(_leafs);
            boolean _not_1 = (!(_last instanceof WhitespaceInfo));
            if (_not_1) {
              List<LeafInfo> _leafs_1 = result.getLeafs();
              int _offset = node.getOffset();
              WhitespaceInfo _whitespaceInfo = new WhitespaceInfo(result, null, 0, _offset);
              _leafs_1.add(_whitespaceInfo);
            }
            List<LeafInfo> _leafs_2 = result.getLeafs();
            CommentInfo _commentInfo = new CommentInfo(result, node, newLines, trailing);
            _leafs_2.add(_commentInfo);
          } else {
            List<LeafInfo> _leafs_3 = result.getLeafs();
            int _offset_1 = node.getOffset();
            WhitespaceInfo _whitespaceInfo_1 = new WhitespaceInfo(result, node, newLines, _offset_1);
            _leafs_3.add(_whitespaceInfo_1);
          }
          boolean _greaterThan = (newLines > 0);
          if (_greaterThan) {
            trailing = false;
          }
        }
      }
      List<LeafInfo> _leafs = result.getLeafs();
      LeafInfo _last = IterableExtensions.<LeafInfo>last(_leafs);
      boolean _not = (!(_last instanceof WhitespaceInfo));
      if (_not) {
        List<LeafInfo> _leafs_1 = result.getLeafs();
        int _xifexpression = (int) 0;
        List<LeafInfo> _leafs_2 = result.getLeafs();
        boolean _isEmpty = _leafs_2.isEmpty();
        if (_isEmpty) {
          _xifexpression = offset;
        } else {
          List<LeafInfo> _leafs_3 = result.getLeafs();
          LeafInfo _last_1 = IterableExtensions.<LeafInfo>last(_leafs_3);
          ILeafNode _node = _last_1.getNode();
          int _offset = _node.getOffset();
          List<LeafInfo> _leafs_4 = result.getLeafs();
          LeafInfo _last_2 = IterableExtensions.<LeafInfo>last(_leafs_4);
          ILeafNode _node_1 = _last_2.getNode();
          int _length = _node_1.getLength();
          int _plus = (_offset + _length);
          _xifexpression = _plus;
        }
        WhitespaceInfo _whitespaceInfo = new WhitespaceInfo(result, null, 0, _xifexpression);
        _leafs_1.add(_whitespaceInfo);
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public HiddenLeafs getHiddenLeafsAfter(final INode node) {
    HiddenLeafs _xblockexpression = null;
    {
      final Function1<ILeafNode,Boolean> _function = new Function1<ILeafNode,Boolean>() {
        public Boolean apply(final ILeafNode it) {
          boolean _isHidden = it.isHidden();
          boolean _not = (!_isHidden);
          return Boolean.valueOf(_not);
        }
      };
      final ILeafNode start = this.findPreviousLeaf(node, _function);
      HiddenLeafs _xifexpression = null;
      boolean _notEquals = (!Objects.equal(start, null));
      if (_notEquals) {
        int _offset = start.getOffset();
        int _length = start.getLength();
        int _plus = (_offset + _length);
        List<ILeafNode> _findNextHiddenLeafs = this.findNextHiddenLeafs(start);
        HiddenLeafs _newHiddenLeafs = this.newHiddenLeafs(_plus, _findNextHiddenLeafs);
        _xifexpression = _newHiddenLeafs;
      } else {
        int _offset_1 = 0;
        if (node!=null) {
          _offset_1=node.getOffset();
        }
        HiddenLeafs _hiddenLeafs = new HiddenLeafs(_offset_1);
        _xifexpression = _hiddenLeafs;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected List<ILeafNode> findNextHiddenLeafs(final INode node) {
    ArrayList<ILeafNode> _xblockexpression = null;
    {
      final ArrayList<ILeafNode> result = CollectionLiterals.<ILeafNode>newArrayList();
      NodeIterator _nodeIterator = new NodeIterator(node);
      final NodeIterator ni = _nodeIterator;
      boolean _hasNext = ni.hasNext();
      boolean _while = _hasNext;
      while (_while) {
        {
          final INode next = ni.next();
          if ((next instanceof ILeafNode)) {
            boolean _isHidden = ((ILeafNode) ((ILeafNode)next)).isHidden();
            if (_isHidden) {
              result.add(((ILeafNode) ((ILeafNode)next)));
            } else {
              return result;
            }
          }
        }
        boolean _hasNext_1 = ni.hasNext();
        _while = _hasNext_1;
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
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
    boolean _notEquals = (!Objects.equal(current, null));
    if (_notEquals) {
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
    }
    return null;
  }
  
  protected List<ILeafNode> findPreviousHiddenLeafs(final INode node) {
    List<ILeafNode> _xblockexpression = null;
    {
      INode current = node;
      boolean _while = (current instanceof ICompositeNode);
      while (_while) {
        INode _lastChild = ((ICompositeNode) current).getLastChild();
        current = _lastChild;
        _while = (current instanceof ICompositeNode);
      }
      final ArrayList<ILeafNode> result = CollectionLiterals.<ILeafNode>newArrayList();
      boolean _notEquals = (!Objects.equal(current, null));
      if (_notEquals) {
        NodeIterator _nodeIterator = new NodeIterator(current);
        final NodeIterator ni = _nodeIterator;
        boolean _hasPrevious = ni.hasPrevious();
        boolean _while_1 = _hasPrevious;
        while (_while_1) {
          {
            final INode previous = ni.previous();
            boolean _and = false;
            boolean _notEquals_1 = (!Objects.equal(previous, current));
            if (!_notEquals_1) {
              _and = false;
            } else {
              _and = (_notEquals_1 && (previous instanceof ILeafNode));
            }
            if (_and) {
              boolean _isHidden = ((ILeafNode) previous).isHidden();
              if (_isHidden) {
                result.add(((ILeafNode) previous));
              } else {
                return ListExtensions.<ILeafNode>reverse(result);
              }
            }
          }
          boolean _hasPrevious_1 = ni.hasPrevious();
          _while_1 = _hasPrevious_1;
        }
      }
      List<ILeafNode> _reverse = ListExtensions.<ILeafNode>reverse(result);
      _xblockexpression = (_reverse);
    }
    return _xblockexpression;
  }
}

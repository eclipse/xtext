/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @deprecated use {@link IHiddenRegionFormatter}
 */
@Deprecated
@SuppressWarnings("all")
public class FormattingDataFactory {
  @Inject
  @Extension
  private HiddenLeafAccess _hiddenLeafAccess;

  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> newFormattingData(final HiddenLeafs leafs, final Procedure1<? super FormattingDataInit> init) {
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _xblockexpression = null;
    {
      final FormattingDataInit data = new FormattingDataInit();
      init.apply(data);
      _xblockexpression = this.newFormattingData(leafs, data.key, data);
    }
    return _xblockexpression;
  }

  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final Void key, final FormattingDataInit it) {
    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
      Integer _elvis = null;
      if (it.newLines != null) {
        _elvis = it.newLines;
      } else {
        _elvis = Integer.valueOf(0);
      }
      final int newLines2 = (int) _elvis;
      if ((((it.space == null) && (it.newLines == null)) || ((leafs.getNewLinesInComments() == 0) && ((newLines2 == 0) || Objects.equal(it.space, ""))))) {
        return this.newWhitespaceData(leafs, it.space, it.increaseIndentationChange, it.decreaseIndentationChange, doc.isDebugConflicts());
      } else {
        return this.newNewLineData(leafs, newLines2, newLines2, it.increaseIndentationChange, it.decreaseIndentationChange, doc.isDebugConflicts());
      }
    };
    return _function;
  }

  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final BlankLineKey key, final FormattingDataInit it) {
    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
      Iterable<FormattingData> _xblockexpression = null;
      {
        final int blankline = doc.getCfg().get(key);
        final int preserve = doc.getCfg().get(XbaseFormatterPreferenceKeys.preserveBlankLines);
        final int min = (blankline + 1);
        final int max = Math.max((preserve + 1), min);
        _xblockexpression = this.newNewLineData(leafs, min, max, it.increaseIndentationChange, it.decreaseIndentationChange, doc.isDebugConflicts());
      }
      return _xblockexpression;
    };
    return _function;
  }

  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final NewLineOrPreserveKey key, final FormattingDataInit it) {
    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
      Iterable<FormattingData> _xblockexpression = null;
      {
        final boolean newLine = doc.getCfg().get(key);
        final boolean preserve = doc.getCfg().get(XbaseFormatterPreferenceKeys.preserveNewLines);
        int _xifexpression = (int) 0;
        if (newLine) {
          _xifexpression = 1;
        } else {
          _xifexpression = 0;
        }
        int _xifexpression_1 = (int) 0;
        if ((preserve || newLine)) {
          _xifexpression_1 = 1;
        } else {
          _xifexpression_1 = 0;
        }
        _xblockexpression = this.newNewLineData(leafs, _xifexpression, _xifexpression_1, it.increaseIndentationChange, it.decreaseIndentationChange, 
          doc.isDebugConflicts());
      }
      return _xblockexpression;
    };
    return _function;
  }

  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final NewLineKey key, final FormattingDataInit it) {
    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
      Iterable<FormattingData> _xblockexpression = null;
      {
        final boolean newLine = doc.getCfg().get(key);
        int _xifexpression = (int) 0;
        if (newLine) {
          _xifexpression = 1;
        } else {
          _xifexpression = 0;
        }
        final int minmax = _xifexpression;
        _xblockexpression = this.newNewLineData(leafs, minmax, minmax, it.increaseIndentationChange, it.decreaseIndentationChange, doc.isDebugConflicts());
      }
      return _xblockexpression;
    };
    return _function;
  }

  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final PreferenceKey key, final FormattingDataInit it) {
    Class<? extends PreferenceKey> _class = key.getClass();
    String _plus = ("Unknown configuration key kind: " + _class);
    throw new RuntimeException(_plus);
  }

  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final WhitespaceKey key, final FormattingDataInit it) {
    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
      Iterable<FormattingData> _xblockexpression = null;
      {
        final boolean space = doc.getCfg().get(key);
        String _xifexpression = null;
        if (space) {
          _xifexpression = " ";
        } else {
          _xifexpression = "";
        }
        _xblockexpression = this.newWhitespaceData(leafs, _xifexpression, it.increaseIndentationChange, it.decreaseIndentationChange, doc.isDebugConflicts());
      }
      return _xblockexpression;
    };
    return _function;
  }

  protected Iterable<FormattingData> newWhitespaceData(final HiddenLeafs leafs, final String space, final int increaseIndentationChange, final int decreaseIndentationChange, final boolean trace) {
    ArrayList<FormattingData> _xblockexpression = null;
    {
      final ArrayList<FormattingData> result = CollectionLiterals.<FormattingData>newArrayList();
      boolean isFirst = true;
      List<LeafInfo> _leafs = leafs.getLeafs();
      for (final LeafInfo leaf : _leafs) {
        boolean _matched = false;
        if (leaf instanceof WhitespaceInfo) {
          _matched=true;
          int _offset = ((WhitespaceInfo)leaf).getOffset();
          int _length = ((WhitespaceInfo)leaf).getLength();
          int _xifexpression = (int) 0;
          if (isFirst) {
            _xifexpression = increaseIndentationChange;
          } else {
            _xifexpression = 0;
          }
          int _xifexpression_1 = (int) 0;
          if (isFirst) {
            _xifexpression_1 = decreaseIndentationChange;
          } else {
            _xifexpression_1 = 0;
          }
          RuntimeException _xifexpression_2 = null;
          if (trace) {
            _xifexpression_2 = new RuntimeException();
          }
          WhitespaceData _whitespaceData = new WhitespaceData(_offset, _length, _xifexpression, _xifexpression_1, _xifexpression_2, space);
          result.add(_whitespaceData);
          isFirst = false;
        }
        if (!_matched) {
          if (leaf instanceof CommentInfo) {
            _matched=true;
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  protected Iterable<FormattingData> newNewLineData(final HiddenLeafs leafs, final int minNewLines, final int maxNewLines, final int increaseIndentationChange, final int decreaseIndentationChange, final boolean trace) {
    ArrayList<FormattingData> _xblockexpression = null;
    {
      final ArrayList<FormattingData> result = CollectionLiterals.<FormattingData>newArrayList();
      boolean applied = false;
      List<LeafInfo> _leafs = leafs.getLeafs();
      for (final LeafInfo leaf : _leafs) {
        boolean _matched = false;
        if (leaf instanceof WhitespaceInfo) {
          _matched=true;
          final boolean equalIndentationChange = (increaseIndentationChange == (decreaseIndentationChange * (-1)));
          boolean _and = false;
          CommentInfo _trailingComment = ((WhitespaceInfo)leaf).trailingComment();
          boolean _isTrailing = false;
          if (_trailingComment!=null) {
            _isTrailing=_trailingComment.isTrailing();
          }
          if (!_isTrailing) {
            _and = false;
          } else {
            CommentInfo _trailingComment_1 = ((WhitespaceInfo)leaf).trailingComment();
            boolean _isMultiline = false;
            if (_trailingComment_1!=null) {
              _isMultiline=_trailingComment_1.isMultiline();
            }
            boolean _not = (!_isMultiline);
            _and = _not;
          }
          if (_and) {
            String _xifexpression = null;
            int _offset = ((WhitespaceInfo)leaf).getOffset();
            boolean _equals = (_offset == 0);
            if (_equals) {
              _xifexpression = "";
            } else {
              String _xifexpression_1 = null;
              if ((maxNewLines == 0)) {
                _xifexpression_1 = null;
              } else {
                _xifexpression_1 = " ";
              }
              _xifexpression = _xifexpression_1;
            }
            final String space = _xifexpression;
            int _offset_1 = ((WhitespaceInfo)leaf).getOffset();
            int _length = ((WhitespaceInfo)leaf).getLength();
            RuntimeException _xifexpression_2 = null;
            if (trace) {
              _xifexpression_2 = new RuntimeException();
            }
            WhitespaceData _whitespaceData = new WhitespaceData(_offset_1, _length, 0, 0, _xifexpression_2, space);
            result.add(_whitespaceData);
          } else {
            if ((!applied)) {
              int newLines = Math.min(Math.max(leafs.getNewLines(), minNewLines), maxNewLines);
              boolean _and_1 = false;
              if (!((newLines < 1) && (((WhitespaceInfo)leaf).getOffset() > 0))) {
                _and_1 = false;
              } else {
                boolean _or = false;
                CommentInfo _leadingComment = ((WhitespaceInfo)leaf).leadingComment();
                boolean _isMultiline_1 = false;
                if (_leadingComment!=null) {
                  _isMultiline_1=_leadingComment.isMultiline();
                }
                if (_isMultiline_1) {
                  _or = true;
                } else {
                  CommentInfo _trailingComment_2 = ((WhitespaceInfo)leaf).trailingComment();
                  boolean _isMultiline_2 = false;
                  if (_trailingComment_2!=null) {
                    _isMultiline_2=_trailingComment_2.isMultiline();
                  }
                  _or = _isMultiline_2;
                }
                _and_1 = _or;
              }
              if (_and_1) {
                newLines = 1;
              }
              CommentInfo _leadingComment_1 = ((WhitespaceInfo)leaf).leadingComment();
              boolean _endsWithNewLine = false;
              if (_leadingComment_1!=null) {
                _endsWithNewLine=_leadingComment_1.endsWithNewLine();
              }
              if (_endsWithNewLine) {
                newLines = (newLines - 1);
              }
              boolean _and_2 = false;
              CommentInfo _leadingComment_2 = ((WhitespaceInfo)leaf).leadingComment();
              boolean _endsWithNewLine_1 = false;
              if (_leadingComment_2!=null) {
                _endsWithNewLine_1=_leadingComment_2.endsWithNewLine();
              }
              boolean _not_1 = (!_endsWithNewLine_1);
              if (!_not_1) {
                _and_2 = false;
              } else {
                _and_2 = (newLines == 0);
              }
              if (_and_2) {
                int _offset_2 = ((WhitespaceInfo)leaf).getOffset();
                int _length_1 = ((WhitespaceInfo)leaf).getLength();
                RuntimeException _xifexpression_3 = null;
                if (trace) {
                  _xifexpression_3 = new RuntimeException();
                }
                String _xifexpression_4 = null;
                int _offset_3 = ((WhitespaceInfo)leaf).getOffset();
                boolean _equals_1 = (_offset_3 == 0);
                if (_equals_1) {
                  _xifexpression_4 = "";
                } else {
                  String _xifexpression_5 = null;
                  boolean _containsComment = leafs.containsComment();
                  if (_containsComment) {
                    _xifexpression_5 = null;
                  } else {
                    _xifexpression_5 = " ";
                  }
                  _xifexpression_4 = _xifexpression_5;
                }
                WhitespaceData _whitespaceData_1 = new WhitespaceData(_offset_2, _length_1, increaseIndentationChange, decreaseIndentationChange, _xifexpression_3, _xifexpression_4);
                result.add(_whitespaceData_1);
              } else {
                if ((equalIndentationChange && (!Objects.equal(IterableExtensions.<LeafInfo>last(leafs.getLeafs()), leaf)))) {
                  int _offset_4 = ((WhitespaceInfo)leaf).getOffset();
                  int _length_2 = ((WhitespaceInfo)leaf).getLength();
                  RuntimeException _xifexpression_6 = null;
                  if (trace) {
                    _xifexpression_6 = new RuntimeException();
                  }
                  NewLineData _newLineData = new NewLineData(_offset_4, _length_2, increaseIndentationChange, decreaseIndentationChange, _xifexpression_6, Integer.valueOf(newLines));
                  result.add(_newLineData);
                } else {
                  int _offset_5 = ((WhitespaceInfo)leaf).getOffset();
                  int _length_3 = ((WhitespaceInfo)leaf).getLength();
                  int _xifexpression_7 = (int) 0;
                  if (equalIndentationChange) {
                    _xifexpression_7 = 0;
                  } else {
                    _xifexpression_7 = increaseIndentationChange;
                  }
                  int _xifexpression_8 = (int) 0;
                  if (equalIndentationChange) {
                    _xifexpression_8 = 0;
                  } else {
                    _xifexpression_8 = decreaseIndentationChange;
                  }
                  RuntimeException _xifexpression_9 = null;
                  if (trace) {
                    _xifexpression_9 = new RuntimeException();
                  }
                  NewLineData _newLineData_1 = new NewLineData(_offset_5, _length_3, _xifexpression_7, _xifexpression_8, _xifexpression_9, Integer.valueOf(newLines));
                  result.add(_newLineData_1);
                }
              }
              applied = true;
            } else {
              int newLines_1 = 1;
              CommentInfo _leadingComment_3 = ((WhitespaceInfo)leaf).leadingComment();
              boolean _endsWithNewLine_2 = false;
              if (_leadingComment_3!=null) {
                _endsWithNewLine_2=_leadingComment_3.endsWithNewLine();
              }
              if (_endsWithNewLine_2) {
                newLines_1 = (newLines_1 - 1);
              }
              if ((equalIndentationChange && (!Objects.equal(IterableExtensions.<LeafInfo>last(leafs.getLeafs()), leaf)))) {
                int _offset_6 = ((WhitespaceInfo)leaf).getOffset();
                int _length_4 = ((WhitespaceInfo)leaf).getLength();
                RuntimeException _xifexpression_10 = null;
                if (trace) {
                  _xifexpression_10 = new RuntimeException();
                }
                NewLineData _newLineData_2 = new NewLineData(_offset_6, _length_4, increaseIndentationChange, decreaseIndentationChange, _xifexpression_10, Integer.valueOf(newLines_1));
                result.add(_newLineData_2);
              } else {
                int _offset_7 = ((WhitespaceInfo)leaf).getOffset();
                int _length_5 = ((WhitespaceInfo)leaf).getLength();
                RuntimeException _xifexpression_11 = null;
                if (trace) {
                  _xifexpression_11 = new RuntimeException();
                }
                NewLineData _newLineData_3 = new NewLineData(_offset_7, _length_5, 0, 0, _xifexpression_11, Integer.valueOf(newLines_1));
                result.add(_newLineData_3);
              }
            }
          }
        }
        if (!_matched) {
          if (leaf instanceof CommentInfo) {
            _matched=true;
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  public Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> append(final INode node, final Procedure1<? super FormattingDataInit> init) {
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _xifexpression = null;
    if ((node != null)) {
      _xifexpression = this.newFormattingData(this._hiddenLeafAccess.getHiddenLeafsAfter(node), init);
    }
    return _xifexpression;
  }

  public Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> prepend(final INode node, final Procedure1<? super FormattingDataInit> init) {
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _xifexpression = null;
    if ((node != null)) {
      _xifexpression = this.newFormattingData(this._hiddenLeafAccess.getHiddenLeafsBefore(node), init);
    }
    return _xifexpression;
  }

  public Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> surround(final INode node, final Procedure1<? super FormattingDataInit> init) {
    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
      ArrayList<FormattingData> _xblockexpression = null;
      {
        final ArrayList<FormattingData> result = CollectionLiterals.<FormattingData>newArrayList();
        if ((node != null)) {
          Iterable<FormattingData> _elvis = null;
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData = this.newFormattingData(this._hiddenLeafAccess.getHiddenLeafsBefore(node), init);
          Iterable<FormattingData> _apply = null;
          if (_newFormattingData!=null) {
            _apply=_newFormattingData.apply(doc);
          }
          if (_apply != null) {
            _elvis = _apply;
          } else {
            List<FormattingData> _emptyList = CollectionLiterals.<FormattingData>emptyList();
            _elvis = _emptyList;
          }
          Iterables.<FormattingData>addAll(result, _elvis);
          Iterable<FormattingData> _elvis_1 = null;
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData_1 = this.newFormattingData(this._hiddenLeafAccess.getHiddenLeafsAfter(node), init);
          Iterable<FormattingData> _apply_1 = null;
          if (_newFormattingData_1!=null) {
            _apply_1=_newFormattingData_1.apply(doc);
          }
          if (_apply_1 != null) {
            _elvis_1 = _apply_1;
          } else {
            List<FormattingData> _emptyList_1 = CollectionLiterals.<FormattingData>emptyList();
            _elvis_1 = _emptyList_1;
          }
          Iterables.<FormattingData>addAll(result, _elvis_1);
        }
        _xblockexpression = result;
      }
      return _xblockexpression;
    };
    return _function;
  }

  public Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> surround(final INode node, final Procedure1<? super FormattingDataInit> before, final Procedure1<? super FormattingDataInit> after) {
    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
      ArrayList<FormattingData> _xblockexpression = null;
      {
        final ArrayList<FormattingData> result = CollectionLiterals.<FormattingData>newArrayList();
        if ((node != null)) {
          Iterable<FormattingData> _elvis = null;
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData = this.newFormattingData(this._hiddenLeafAccess.getHiddenLeafsBefore(node), before);
          Iterable<FormattingData> _apply = null;
          if (_newFormattingData!=null) {
            _apply=_newFormattingData.apply(doc);
          }
          if (_apply != null) {
            _elvis = _apply;
          } else {
            List<FormattingData> _emptyList = CollectionLiterals.<FormattingData>emptyList();
            _elvis = _emptyList;
          }
          Iterables.<FormattingData>addAll(result, _elvis);
          Iterable<FormattingData> _elvis_1 = null;
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData_1 = this.newFormattingData(this._hiddenLeafAccess.getHiddenLeafsAfter(node), after);
          Iterable<FormattingData> _apply_1 = null;
          if (_newFormattingData_1!=null) {
            _apply_1=_newFormattingData_1.apply(doc);
          }
          if (_apply_1 != null) {
            _elvis_1 = _apply_1;
          } else {
            List<FormattingData> _emptyList_1 = CollectionLiterals.<FormattingData>emptyList();
            _elvis_1 = _emptyList_1;
          }
          Iterables.<FormattingData>addAll(result, _elvis_1);
        }
        _xblockexpression = result;
      }
      return _xblockexpression;
    };
    return _function;
  }

  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> newFormattingData(final HiddenLeafs leafs, final PreferenceKey key, final FormattingDataInit it) {
    if (key instanceof BlankLineKey) {
      return _newFormattingData(leafs, (BlankLineKey)key, it);
    } else if (key instanceof NewLineKey) {
      return _newFormattingData(leafs, (NewLineKey)key, it);
    } else if (key instanceof NewLineOrPreserveKey) {
      return _newFormattingData(leafs, (NewLineOrPreserveKey)key, it);
    } else if (key instanceof WhitespaceKey) {
      return _newFormattingData(leafs, (WhitespaceKey)key, it);
    } else if (key == null) {
      return _newFormattingData(leafs, (Void)null, it);
    } else if (key != null) {
      return _newFormattingData(leafs, key, it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(leafs, key, it).toString());
    }
  }
}

/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.internal;

import java.util.Collection;
import java.util.List;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.internal.ConflictingRegionsException;
import org.eclipse.xtext.formatting2.internal.RegionTrace;
import org.eclipse.xtext.formatting2.internal.TextSegmentSet;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class TestableTextSegmentSet {
  private final List<String> issues = CollectionLiterals.<String>newArrayList();
  
  private final TextSegmentSet<ITextSegment> set;
  
  private String fmt(final ITextSegment region) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[");
    int _offset = region.getOffset();
    _builder.append(_offset, "");
    _builder.append(",");
    int _length = region.getLength();
    _builder.append(_length, "");
    _builder.append("]");
    return _builder.toString();
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=");
    String _join = IterableExtensions.join(this.issues, ", ");
    _builder.append(_join, "");
    _builder.newLineIfNotEmpty();
    _builder.append("set=");
    final Function1<ITextSegment, String> _function = (ITextSegment it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("[");
      int _offset = it.getOffset();
      _builder_1.append(_offset, "");
      _builder_1.append(",");
      int _length = it.getLength();
      _builder_1.append(_length, "");
      _builder_1.append("]");
      return _builder_1.toString();
    };
    Iterable<String> _map = IterableExtensions.<ITextSegment, String>map(this.set, _function);
    String _string = _map.toString();
    String _replace = _string.replace("\n", ", ");
    _builder.append(_replace, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public void add(final ITextSegment segment) {
    try {
      this.set.add(segment);
    } catch (final Throwable _t) {
      if (_t instanceof ConflictingRegionsException) {
        final ConflictingRegionsException e = (ConflictingRegionsException)_t;
        Collection<RegionTrace> _traces = e.getTraces();
        final Function1<RegionTrace, ITextSegment> _function = (RegionTrace it) -> {
          return it.getRegion();
        };
        final Iterable<ITextSegment> conflicting = IterableExtensions.<RegionTrace, ITextSegment>map(_traces, _function);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("mergeConflict:");
        final Function1<ITextSegment, String> _function_1 = (ITextSegment it) -> {
          return this.fmt(it);
        };
        Iterable<String> _map = IterableExtensions.<ITextSegment, String>map(conflicting, _function_1);
        String _join = IterableExtensions.join(_map, "<>");
        _builder.append(_join, "");
        this.issues.add(_builder.toString());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public TestableTextSegmentSet(final TextSegmentSet<ITextSegment> set) {
    super();
    this.set = set;
  }
}

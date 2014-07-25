/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.internal;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.internal.ConflictingRegionsException;
import org.eclipse.xtext.formatting2.internal.MultiCauseException;
import org.eclipse.xtext.formatting2.internal.TextSegmentSet;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

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
  
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=");
    String _join = IterableExtensions.join(this.issues, ", ");
    _builder.append(_join, "");
    _builder.newLineIfNotEmpty();
    _builder.append("set=[");
    String _string = this.set.toString();
    String _replace = _string.replace("\n", ", ");
    _builder.append(_replace, "");
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public void add(final ITextSegment segment) {
    try {
      this.set.add(segment);
    } catch (final Throwable _t) {
      if (_t instanceof MultiCauseException) {
        final MultiCauseException e = (MultiCauseException)_t;
        Throwable[] _causes = e.getCauses();
        Iterable<ConflictingRegionsException> _filter = Iterables.<ConflictingRegionsException>filter(((Iterable<?>)Conversions.doWrapArray(_causes)), ConflictingRegionsException.class);
        ConflictingRegionsException _head = IterableExtensions.<ConflictingRegionsException>head(_filter);
        Pair<String, ITextSegment>[] _regions = _head.getRegions();
        final Function1<Pair<String, ITextSegment>, ITextSegment> _function = new Function1<Pair<String, ITextSegment>, ITextSegment>() {
          public ITextSegment apply(final Pair<String, ITextSegment> it) {
            return it.getSecond();
          }
        };
        final List<ITextSegment> conflicting = ListExtensions.<Pair<String, ITextSegment>, ITextSegment>map(((List<Pair<String, ITextSegment>>)Conversions.doWrapArray(_regions)), _function);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("mergeConflict:");
        final Function1<ITextSegment, String> _function_1 = new Function1<ITextSegment, String>() {
          public String apply(final ITextSegment it) {
            return TestableTextSegmentSet.this.fmt(it);
          }
        };
        List<String> _map = ListExtensions.<ITextSegment, String>map(conflicting, _function_1);
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

/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.internal;

import java.util.List;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.internal.TextSegmentSet;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
    final Function1<ITextSegment, String> _function = new Function1<ITextSegment, String>() {
      @Override
      public String apply(final ITextSegment it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("[");
        int _offset = it.getOffset();
        _builder.append(_offset, "");
        _builder.append(",");
        int _length = it.getLength();
        _builder.append(_length, "");
        _builder.append("]");
        return _builder.toString();
      }
    };
    Iterable<String> _map = IterableExtensions.<ITextSegment, String>map(this.set, _function);
    String _string = _map.toString();
    String _replace = _string.replace("\n", ", ");
    _builder.append(_replace, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public void add(final ITextSegment segment) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method region is undefined for the type TestableTextSegmentSet"
      + "\nType mismatch: cannot convert implicit first argument from TestableTextSegmentSet to ITextSegment");
  }
  
  public TestableTextSegmentSet(final TextSegmentSet<ITextSegment> set) {
    super();
    this.set = set;
  }
}

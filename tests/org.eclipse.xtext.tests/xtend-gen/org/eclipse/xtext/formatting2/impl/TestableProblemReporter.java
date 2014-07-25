/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.impl;

import java.util.Collection;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.FormatterProblemReporter;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.impl.TextSegmentSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class TestableProblemReporter extends FormatterProblemReporter {
  private final List<String> issues = CollectionLiterals.<String>newArrayList();
  
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
  
  public void reportMergeConflict(final TextSegmentSet<? extends ITextSegment> set, final Collection<? extends ITextSegment> existing) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mergeConflict:");
    final Function1<ITextSegment, String> _function = new Function1<ITextSegment, String>() {
      public String apply(final ITextSegment it) {
        return TestableProblemReporter.this.fmt(it);
      }
    };
    Iterable<String> _map = IterableExtensions.map(existing, _function);
    String _join = IterableExtensions.join(_map, "<>");
    _builder.append(_join, "");
    this.issues.add(_builder.toString());
  }
  
  public void reportOutsideOfRegion(final TextSegmentSet<? extends ITextSegment> set, final ITextSegment region) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("outOfRegion:");
    String _fmt = this.fmt(region);
    _builder.append(_fmt, "");
    this.issues.add(_builder.toString());
  }
  
  public String toString() {
    return IterableExtensions.join(this.issues, ", ");
  }
}

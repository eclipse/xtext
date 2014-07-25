/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.impl;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.FormatterProblemReporter;
import org.eclipse.xtext.formatting2.ITextRegion2;
import org.eclipse.xtext.formatting2.impl.RegionSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class TestableProblemReporter extends FormatterProblemReporter {
  private final List<String> issues = CollectionLiterals.<String>newArrayList();
  
  private String fmt(final ITextRegion2 region) {
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
  
  public void handleMergeConflict(final RegionSet<? extends ITextRegion2> set, final ITextRegion2 existing, final ITextRegion2 add) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mergeConflict:");
    String _fmt = this.fmt(existing);
    _builder.append(_fmt, "");
    _builder.append("<>");
    String _fmt_1 = this.fmt(add);
    _builder.append(_fmt_1, "");
    this.issues.add(_builder.toString());
  }
  
  public void handleOutsideOfRegion(final RegionSet<? extends ITextRegion2> set, final ITextRegion2 region) {
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

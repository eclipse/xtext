/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.formatting2.IAutowrapFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class IndentOnceAutowrapFormatter implements IAutowrapFormatter {
  private final IHiddenRegion last;
  
  private boolean hasWrapped = false;
  
  @Override
  public void format(final ITextSegment region, final IHiddenRegionFormatting wrapped, @Extension final IFormattableDocument document) {
    if ((!this.hasWrapped)) {
      IHiddenRegion _switchResult = null;
      boolean _matched = false;
      if (region instanceof IHiddenRegion) {
        _matched=true;
        _switchResult = ((IHiddenRegion)region);
      }
      if (!_matched) {
        if (region instanceof IHiddenRegionPart) {
          _matched=true;
          _switchResult = ((IHiddenRegionPart)region).getHiddenRegion();
        }
      }
      final IHiddenRegion hiddenRegion = _switchResult;
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.indent();
      };
      document.set(hiddenRegion, this.last, _function);
      this.hasWrapped = true;
    }
  }
  
  public IndentOnceAutowrapFormatter(final IHiddenRegion last) {
    super();
    this.last = last;
  }
}

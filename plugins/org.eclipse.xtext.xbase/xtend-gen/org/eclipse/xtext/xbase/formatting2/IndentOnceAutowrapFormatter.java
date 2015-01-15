/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.formatting2.IAutowrapFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author meysholdt - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class IndentOnceAutowrapFormatter implements IAutowrapFormatter {
  private final IHiddenRegion last;
  
  private boolean hasWrapped = false;
  
  @Override
  public void format(final IHiddenRegionFormatter wrapped, @Extension final IFormattableDocument document) {
    if ((!this.hasWrapped)) {
      wrapped.increaseIndentation();
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.decreaseIndentation();
        }
      };
      document.set(this.last, _function);
      this.hasWrapped = true;
    }
  }
  
  public IndentOnceAutowrapFormatter(final IHiddenRegion last) {
    super();
    this.last = last;
  }
}

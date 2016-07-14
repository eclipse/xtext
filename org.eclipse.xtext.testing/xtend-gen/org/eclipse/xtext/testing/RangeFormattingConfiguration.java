/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing;

import io.typefox.lsapi.Range;
import io.typefox.lsapi.impl.PositionImpl;
import io.typefox.lsapi.impl.RangeImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.testing.FormattingConfiguration;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RangeFormattingConfiguration extends FormattingConfiguration {
  private Range range = ObjectExtensions.<RangeImpl>operator_doubleArrow(new RangeImpl(), 
    ((Procedure1<RangeImpl>) (RangeImpl it) -> {
      PositionImpl _positionImpl = new PositionImpl(0, 0);
      it.setStart(_positionImpl);
      PositionImpl _positionImpl_1 = new PositionImpl(0, 1);
      it.setEnd(_positionImpl_1);
    }));
  
  @Pure
  public Range getRange() {
    return this.range;
  }
  
  public void setRange(final Range range) {
    this.range = range;
  }
}

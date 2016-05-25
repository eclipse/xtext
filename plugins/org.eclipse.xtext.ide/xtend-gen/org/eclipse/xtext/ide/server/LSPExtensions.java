/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import io.typefox.lsapi.PositionImpl;
import io.typefox.lsapi.RangeImpl;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class LSPExtensions {
  public static PositionImpl newPosition(final int line, final int character) {
    PositionImpl _positionImpl = new PositionImpl();
    final Procedure1<PositionImpl> _function = new Procedure1<PositionImpl>() {
      @Override
      public void apply(final PositionImpl it) {
        it.setLine(line);
        it.setCharacter(character);
      }
    };
    return ObjectExtensions.<PositionImpl>operator_doubleArrow(_positionImpl, _function);
  }
  
  public static RangeImpl newRange(final PositionImpl start, final PositionImpl end) {
    RangeImpl _rangeImpl = new RangeImpl();
    final Procedure1<RangeImpl> _function = new Procedure1<RangeImpl>() {
      @Override
      public void apply(final RangeImpl it) {
        it.setStart(start);
        it.setEnd(end);
      }
    };
    return ObjectExtensions.<RangeImpl>operator_doubleArrow(_rangeImpl, _function);
  }
}

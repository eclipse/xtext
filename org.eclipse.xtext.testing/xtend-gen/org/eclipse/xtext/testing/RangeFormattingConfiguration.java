/**
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.testing.FormattingConfiguration;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RangeFormattingConfiguration extends FormattingConfiguration {
  private Range range = ObjectExtensions.<Range>operator_doubleArrow(new Range(), ((Procedure1<Range>) (Range it) -> {
    Position _position = new Position(0, 0);
    it.setStart(_position);
    Position _position_1 = new Position(0, 1);
    it.setEnd(_position_1);
  }));
  
  @Pure
  public Range getRange() {
    return this.range;
  }
  
  public void setRange(final Range range) {
    this.range = range;
  }
}

/**
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.formatting2;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@Data
@SuppressWarnings("all")
public class TemplateWhitespace extends Chunk {
  @Override
  public String toString() {
    int _length = this.getText().length();
    return ("T" + Integer.valueOf(_length));
  }

  public TemplateWhitespace(final CharSequence text) {
    super(text);
  }

  @Override
  @Pure
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    if (!super.equals(obj))
      return false;
    return true;
  }
}

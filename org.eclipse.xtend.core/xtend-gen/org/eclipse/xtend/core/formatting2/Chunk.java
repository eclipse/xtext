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
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@Data
@SuppressWarnings("all")
public abstract class Chunk {
  private final CharSequence text;

  public int getLength() {
    return this.text.length();
  }

  public Chunk(final CharSequence text) {
    super();
    this.text = text;
  }

  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.text== null) ? 0 : this.text.hashCode());
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
    Chunk other = (Chunk) obj;
    if (this.text == null) {
      if (other.text != null)
        return false;
    } else if (!this.text.equals(other.text))
      return false;
    return true;
  }

  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("text", this.text);
    return b.toString();
  }

  @Pure
  public CharSequence getText() {
    return this.text;
  }
}

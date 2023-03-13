/**
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.formatting2;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@Accessors
@SuppressWarnings("all")
public class LineModel {
  private String leadingText;

  private int rootIndentLenght = (-1);

  private final List<Line> lines = CollectionLiterals.<Line>newArrayList();

  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rootIndentLenght=");
    _builder.append(this.rootIndentLenght);
    _builder.newLineIfNotEmpty();
    _builder.append(this.leadingText);
    String _join = IterableExtensions.join(this.lines);
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  @Pure
  public String getLeadingText() {
    return this.leadingText;
  }

  public void setLeadingText(final String leadingText) {
    this.leadingText = leadingText;
  }

  @Pure
  public int getRootIndentLenght() {
    return this.rootIndentLenght;
  }

  public void setRootIndentLenght(final int rootIndentLenght) {
    this.rootIndentLenght = rootIndentLenght;
  }

  @Pure
  public List<Line> getLines() {
    return this.lines;
  }
}

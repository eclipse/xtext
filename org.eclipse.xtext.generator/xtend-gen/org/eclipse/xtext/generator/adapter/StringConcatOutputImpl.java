/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.adapter;

import com.google.common.base.Objects;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @since 2.9
 */
@Deprecated
@SuppressWarnings("all")
public class StringConcatOutputImpl extends OutputImpl {
  public static final String STRING_OUTLET = "StringConcatOutputImpl.StringOutlet";
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private StringConcatenation stringOutlet;
  
  @Override
  public void openFile(final String path, final String outletName) {
    boolean _equals = Objects.equal(outletName, StringConcatOutputImpl.STRING_OUTLET);
    if (_equals) {
      StringConcatenation _stringConcatenation = new StringConcatenation();
      this.stringOutlet = _stringConcatenation;
    } else {
      super.openFile(path, outletName);
    }
  }
  
  @Override
  public void closeFile() {
    if ((this.stringOutlet != null)) {
      this.stringOutlet = null;
    } else {
      super.closeFile();
    }
  }
  
  @Override
  public void write(final String bytes) {
    if ((this.stringOutlet != null)) {
      this.stringOutlet.append(bytes);
    } else {
      super.write(bytes);
    }
  }
  
  @Pure
  public StringConcatenation getStringOutlet() {
    return this.stringOutlet;
  }
}

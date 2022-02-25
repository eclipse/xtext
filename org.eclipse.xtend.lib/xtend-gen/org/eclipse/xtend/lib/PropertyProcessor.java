/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.lib;

import org.eclipse.xtend.lib.annotations.AccessorsProcessor;
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @since 2.7
 * @noextend
 * @noreference
 */
@Deprecated
@SuppressWarnings("all")
public class PropertyProcessor extends AbstractFieldProcessor {
  @Override
  public void doTransform(final MutableFieldDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final AccessorsProcessor.Util util = new AccessorsProcessor.Util(context);
    boolean _hasGetter = util.hasGetter(it);
    boolean _not = (!_hasGetter);
    if (_not) {
      util.addGetter(it, Visibility.PUBLIC);
    }
    if (((!it.isFinal()) && (!util.hasSetter(it)))) {
      util.addSetter(it, Visibility.PUBLIC);
    }
    String _firstLower = StringExtensions.toFirstLower(it.getSimpleName());
    String _plus = ("_" + _firstLower);
    it.setSimpleName(_plus);
  }
}

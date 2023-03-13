/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XExpression;

@SuppressWarnings("all")
public class ExpressionImpl extends AbstractElementImpl<XExpression> implements Expression {
  @Override
  public String toString() {
    return NodeModelUtils.getNode(this.getDelegate()).getText().trim();
  }
}

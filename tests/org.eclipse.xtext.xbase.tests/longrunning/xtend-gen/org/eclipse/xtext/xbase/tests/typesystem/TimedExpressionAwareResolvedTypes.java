/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.typesystem.TimedReassigningResolvedTypes;
import org.eclipse.xtext.xbase.tests.typesystem.TimedStackedResolvedTypes;
import org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTimes;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionAwareStackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class TimedExpressionAwareResolvedTypes extends ExpressionAwareStackedResolvedTypes {
  private TypeResolutionTimes times;
  
  public TimedExpressionAwareResolvedTypes(final ResolvedTypes parent, final XExpression expression, final TypeResolutionTimes times) {
    super(parent, expression);
    this.times = times;
  }
  
  @Override
  public StackedResolvedTypes pushReassigningTypes() {
    return new TimedReassigningResolvedTypes(this, this.times);
  }
  
  @Override
  public StackedResolvedTypes pushTypes() {
    return new TimedStackedResolvedTypes(this, this.times);
  }
  
  @Override
  public ExpressionAwareStackedResolvedTypes pushTypes(final XExpression context) {
    return new TimedExpressionAwareResolvedTypes(this, context, this.times);
  }
}

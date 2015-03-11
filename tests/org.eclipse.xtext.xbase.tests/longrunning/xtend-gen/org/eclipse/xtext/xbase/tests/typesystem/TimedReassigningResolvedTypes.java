/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.typesystem.TimedExpressionAwareResolvedTypes;
import org.eclipse.xtext.xbase.tests.typesystem.TimedStackedResolvedTypes;
import org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTimes;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionAwareStackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.ReassigningStackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class TimedReassigningResolvedTypes extends ReassigningStackedResolvedTypes {
  private TypeResolutionTimes times;
  
  public TimedReassigningResolvedTypes(final ResolvedTypes parent, final TypeResolutionTimes times) {
    super(parent);
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

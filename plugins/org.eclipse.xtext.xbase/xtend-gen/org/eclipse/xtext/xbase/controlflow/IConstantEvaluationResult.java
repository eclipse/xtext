/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.controlflow;

import com.google.common.base.Optional;
import org.eclipse.xtext.xbase.validation.ConstantExpressionValidator;

/**
 * Represents a result of the {@link ConstantExpressionValidator}.
 * It carries the information if the result is a constant expression and
 * it may also have information about the computed value of an expression.
 * The value may be null, which indicates that it could not be computed. Or it may be
 * {@link Optional#absent()} if it was computed to be the literal value {@code null}.
 */
@SuppressWarnings("all")
public interface IConstantEvaluationResult<T extends Object> {
  /**
   * Returns the optional computation result. If the result is null, no value could be
   * computed.
   */
  public abstract Optional<T> getValue();
  
  public abstract boolean isCompileTimeConstant();
}

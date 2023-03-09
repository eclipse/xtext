/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.controlflow;

import com.google.common.base.Optional;
import org.eclipse.xtext.xbase.validation.ConstantExpressionValidator;

/**
 * Represents a result of the {@link ConstantExpressionValidator}. It carries
 * the information if the result is a constant expression and it may also have
 * information about the computed value of an expression. The value may be null,
 * which indicates that it could not be computed. Or it may be
 * {@link Optional#absent()} if it was computed to be the literal value
 * {@code null}.
 */
public interface IConstantEvaluationResult<T extends Object> {
	/**
	 * Returns the optional computation result. If the result is null, no value
	 * could be computed.
	 */
	Optional<T> getValue();

	boolean isCompileTimeConstant();
}

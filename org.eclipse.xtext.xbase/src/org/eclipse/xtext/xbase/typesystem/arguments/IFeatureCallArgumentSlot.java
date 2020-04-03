/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.typesystem.arguments;

import java.util.List;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IFeatureCallArgumentSlot {
	boolean isVarArg();

	boolean isSuperfluous();

	/**
	 * The list of expressions. The list is never <code>null</code> but may
	 * contain <code>null</code> entries.
	 */
	List<XExpression> getArgumentExpressions();

	/**
	 * @Nullable
	 */
	XExpression getArgumentExpression();

	/**
	 * @Nullable
	 */
	LightweightTypeReference getDeclaredType();

	void markProcessed();
}

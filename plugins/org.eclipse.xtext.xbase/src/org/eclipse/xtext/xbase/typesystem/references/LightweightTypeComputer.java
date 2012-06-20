/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface LightweightTypeComputer extends ITypeComputer {

	void computeTypes(XExpression expression, LightweightTypeComputationState state);

	JvmIdentifiableElement getRefinableCandidate(XExpression object, LightweightTypeComputationState state);
	
}

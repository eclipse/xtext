/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.junit.typesystem

import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class PublicResolvedTypes extends RootResolvedTypes {
	new(DefaultReentrantTypeResolver resolver) {
		super(resolver, CancelIndicator.NullImpl)
	}
	
	override UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter type) {
		super.createUnboundTypeReference(expression, type)
	}
	
	override getUnboundTypeReference(Object handle) {
		super.getUnboundTypeReference(handle)
	}
	
	override getHints(Object handle) {
		super.getHints(handle)
	}
	
	override basicGetExpressionTypes() {
		super.basicGetExpressionTypes()
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class PublicStackedResolvedTypes extends StackedResolvedTypes {
	new(ResolvedTypes parent) {
		super(parent)
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class PublicReentrantTypeResolver extends DefaultReentrantTypeResolver {
	
	override setTypeComputer(ITypeComputer typeComputer) {
		super.setTypeComputer(typeComputer)
	}
	
	override getBatchScopeProvider() {
		super.getBatchScopeProvider()
	}
	
}

/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	
	override public UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter type) {
		super.createUnboundTypeReference(expression, type)
	}
	
	override public getUnboundTypeReference(Object handle) {
		super.getUnboundTypeReference(handle)
	}
	
	override public getHints(Object handle) {
		super.getHints(handle)
	}
	
	override public basicGetExpressionTypes() {
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
	
	override public setTypeComputer(ITypeComputer typeComputer) {
		super.setTypeComputer(typeComputer)
	}
	
	override public getBatchScopeProvider() {
		super.getBatchScopeProvider()
	}
	
}

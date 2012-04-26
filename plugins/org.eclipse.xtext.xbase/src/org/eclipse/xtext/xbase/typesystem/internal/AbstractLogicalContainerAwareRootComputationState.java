/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public abstract class AbstractLogicalContainerAwareRootComputationState extends AbstractRootTypeComputationState {

	private final JvmMember member;

	protected AbstractLogicalContainerAwareRootComputationState(TypeResolution typeResolution, JvmMember member,
			LogicalContainerAwareReentrantTypeResolver reentrantTypeResolver) {
		super(typeResolution, reentrantTypeResolver);
		this.member = member;
	}
	
	protected JvmMember getMember() {
		return member;
	}
	
	@Override
	@NonNull
	protected LogicalContainerAwareReentrantTypeResolver getResolver() {
		return (LogicalContainerAwareReentrantTypeResolver) super.getResolver();
	}
	
	@Override
	@Nullable
	protected XExpression getRootExpression() {
		return getResolver().getLogicalContainerProvider().getAssociatedExpression(getMember());
	}
	
}

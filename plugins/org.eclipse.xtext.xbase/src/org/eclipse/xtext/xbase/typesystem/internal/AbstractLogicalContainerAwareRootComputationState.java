/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public abstract class AbstractLogicalContainerAwareRootComputationState extends AbstractRootTypeComputationState {

	private final JvmMember member;

	protected AbstractLogicalContainerAwareRootComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			JvmMember member,
			LogicalContainerAwareReentrantTypeResolver reentrantTypeResolver) {
		super(resolvedTypes, featureScopeSession, reentrantTypeResolver);
		this.member = member;
	}
	
	protected JvmMember getMember() {
		return member;
	}
	
	@Override
	protected XExpression getRootExpression() {
		return ((LogicalContainerAwareReentrantTypeResolver) getResolver()).getLogicalContainerProvider().getAssociatedExpression(getMember());
	}
	
}

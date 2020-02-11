/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.LocalVariableCapturer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public abstract class AbstractLogicalContainerAwareRootComputationState extends AbstractRootTypeComputationState {

	private final JvmMember member;

	protected AbstractLogicalContainerAwareRootComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession, JvmMember member) {
		super(resolvedTypes, featureScopeSession);
		this.member = member;
	}
	
	protected JvmMember getMember() {
		return member;
	}
	
	@Override
	protected XExpression getRootExpression() {
		XExpression result = ((LogicalContainerAwareReentrantTypeResolver) getResolver()).getLogicalContainerProvider().getAssociatedExpression(getMember());
		if (result == null && member instanceof JvmFeature) {
			// make sure we process dangling local classes if the expression has been removed by an
			// active annotation
			// 
			// To some extend this is a workaround for a bug with #setBody which should
			// take care of local classes, too
			List<JvmGenericType> localClasses = ((JvmFeature) member).getLocalClasses();
			for(JvmGenericType localClass: localClasses) {
				LocalVariableCapturer.captureLocalVariables(localClass, this);
			}
		}
		return result;
	}
	
}

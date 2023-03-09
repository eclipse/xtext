/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;

import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractPendingLinkingCandidate;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow
 */
@Singleton
public class EagerArgumentTypeComputer extends XbaseTypeComputer {
	@Override
	protected ILinkingCandidate getBestCandidate(List<? extends ILinkingCandidate> candidates) {
		for (ILinkingCandidate candidate : candidates) {
			if (candidate instanceof AbstractPendingLinkingCandidate) {
				((AbstractPendingLinkingCandidate<?>) candidate).computeArgumentTypes();
			}
		}
		return super.getBestCandidate(candidates);
	}
}

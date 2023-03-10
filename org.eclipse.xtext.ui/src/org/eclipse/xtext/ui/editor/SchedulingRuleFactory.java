/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.core.runtime.jobs.ISchedulingRule;

/**
 * Scheduling rule factory for asynchronous operations. Mostly copied from
 * org.eclipse.debug.internal.ui.viewers.AsynchronousSchedulingRuleFactory.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class SchedulingRuleFactory {
	public static SchedulingRuleFactory INSTANCE = new SchedulingRuleFactory();

	/**
	 * All jobs that are configured with the same instance of this rule will run sequentially.
	 * 
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	public static class Sequence implements ISchedulingRule {

		@Override
		public boolean contains(ISchedulingRule rule) {
			return rule == this;
		}

		@Override
		public boolean isConflicting(ISchedulingRule rule) {
			return rule instanceof Sequence;
		}
	}

	/**
	 * Rule allows only one job for each given lock object to run at a time
	 */
	static class SerialPerObjectRule implements ISchedulingRule {
		private Object lockObject = null;

		public SerialPerObjectRule(Object lock) {
			lockObject = lock;
		}

		@Override
		public boolean contains(ISchedulingRule rule) {
			return rule == this;
		}

		@Override
		public boolean isConflicting(ISchedulingRule rule) {
			if (rule instanceof SerialPerObjectRule) {
				SerialPerObjectRule serialPerObjectRule = (SerialPerObjectRule) rule;
				return lockObject == serialPerObjectRule.lockObject;
			}
			return false;
		}

	}

	private SchedulingRuleFactory() {
	}

	/**
	 * Returns a scheduling rule that allows all jobs with an instance of the rule to run one at a time.
	 * 
	 * @return scheduling rule
	 */
	public ISchedulingRule newSequence() {
		return new Sequence();
	}

	/**
	 * Returns a scheduling rule that allows all jobs with an instance of the rule on the same object to run one at a
	 * time.
	 * 
	 * @param lock
	 *            object to serialize one
	 * @return scheduling rule
	 */
	public ISchedulingRule newSerialPerObjectRule(Object lock) {
		return new SerialPerObjectRule(lock);
	}

}

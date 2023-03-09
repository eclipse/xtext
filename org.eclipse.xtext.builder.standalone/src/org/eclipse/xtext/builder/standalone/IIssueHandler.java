/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone;

import org.apache.log4j.Logger;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;

/**
 * @author Dennis Huebner
 * 
 */
public interface IIssueHandler {

	/**
	 * @param issues
	 *            Validation issues to handle
	 * @return <code>false</code> if issues has a severe problem,
	 *         <code>true</code> otherwise
	 */
	boolean handleIssue(Iterable<Issue> issues);

	class DefaultIssueHandler implements IIssueHandler {
		private static final Logger LOG = Logger.getLogger(DefaultIssueHandler.class);

		/**
		 * Handle the issues and return true if there are no errors.
		 * 
		 * @param issues
		 *            Validation issues to handle
		 * @return <code>false</code> if an {@link Issue} with
		 *         {@link Severity#ERROR} was found, <code>true</code>
		 *         otherwise
		 */
		@Override
		public boolean handleIssue(Iterable<Issue> issues) {
			boolean errorFree = true;
			for (Issue issue : issues) {
				switch (issue.getSeverity()) {
				case ERROR:
					LOG.error(issue.toString());
					errorFree = false;
					break;
				case WARNING:
					LOG.warn(issue.toString());
					break;
				case INFO:
					LOG.info(issue.toString());
					break;
				default:
					break;
				}
			}
			return errorFree;
		}
	}
}

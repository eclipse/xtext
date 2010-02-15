/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collections;
import java.util.List;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public interface IssueResolutionProvider {

	public interface IssueContextProvider {
		public IssueContext getIssueContext();
	}

	boolean hasResolutionFor(String issueCode);

	public List<IssueResolution> getResolutions(IssueContext context);

	public List<IssueResolution> getResolutions(String issueCode, IssueContextProvider provider);

	public static class IssueContextProviderImpl implements IssueContextProvider {

		private final IssueContext context;

		public IssueContextProviderImpl(IssueContext context) {
			this.context = context;
		}

		public IssueContext getIssueContext() {
			return context;
		}

	}

	public static class NullImpl implements IssueResolutionProvider {

		public List<IssueResolution> getResolutions(IssueContext context) {
			return Collections.emptyList();
		}

		public List<IssueResolution> getResolutions(String issueCode, IssueContextProvider provider) {
			return Collections.emptyList();
		}

		public boolean hasResolutionFor(String issueCode) {
			return false;
		}

	}
}

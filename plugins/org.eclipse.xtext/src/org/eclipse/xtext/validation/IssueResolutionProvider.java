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

	boolean hasResolutionFor(Integer IssueCode);
	
	public List<IssueResolution> getResolutions(IssueContext context);
	
	public static class NullImpl implements IssueResolutionProvider {

		public List<IssueResolution> getResolutions(IssueContext context) {
			return Collections.emptyList();
		}

		public boolean hasResolutionFor(Integer issueCode) {
			return false;
		}
		
	}
}

/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.util;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.xpect.text.IRegion;

import com.google.common.base.Predicate;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class IssueOverlapsRangePredicate implements Predicate<Issue> {
	private final Severity severity;
	private final IRegion region;

	public IssueOverlapsRangePredicate(IRegion region, Severity severity) {
		this.region = region;
		this.severity = severity;
	}

	public boolean apply(Issue issue) {
		if (severity != null && severity != issue.getSeverity())
			return false;
		Integer offset = issue.getOffset();
		Integer length = issue.getLength();
		int start = region.getOffset();
		int end = start + region.getLength();
		if (offset != null && length != null && offset < end && offset + length > start)
			return true;
		return false;
	}

	public IRegion getRegion() {
		return region;
	}

	public Severity getSeverity() {
		return severity;
	}

	@Override
	public String toString() {
		return "Severity:" + severity + " Region:" + region;
	}

}
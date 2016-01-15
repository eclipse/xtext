/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.util;

import java.util.Set;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.xpect.text.IRegion;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class IssueOverlapsRangePredicate implements Predicate<Issue> {
	private final Set<Severity> severities;
	private final IRegion region;

	public IssueOverlapsRangePredicate(IRegion region, Set<Severity> severity) {
		Preconditions.checkNotNull(region);
		Preconditions.checkNotNull(severity);
		this.region = region;
		this.severities = severity;
	}

	public boolean apply(Issue issue) {
		if (!severities.contains(issue.getSeverity()))
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

	public Set<Severity> getSeverity() {
		return severities;
	}

	@Override
	public String toString() {
		return "Severities:" + severities + " Region:" + region;
	}

}
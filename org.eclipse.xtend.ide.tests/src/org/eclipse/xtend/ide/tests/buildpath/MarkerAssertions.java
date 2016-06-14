/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.buildpath;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.ui.util.IssueUtil;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class MarkerAssertions {

	@Inject
	private IssueUtil issueUtil;

	public void assertErrorMarker(IFile file, String issueCode) throws CoreException {
		assertErrorMarker(file, issueCode, 1);
	}

	public void assertErrorMarker(IFile file, String issueCode, int expectedIssuesCount) throws CoreException {
		IMarker[] findMarkers = file.findMarkers(null, true, IResource.DEPTH_INFINITE);
		int matchingIssuesFound = 0;
		List<String> allCodes = new ArrayList<String>();
		for (IMarker iMarker : findMarkers) {
			String code = issueUtil.getCode(iMarker);
			if (code != null) {
				allCodes.add(code);
				if (issueCode.equals(code)) {
					matchingIssuesFound++;
				}
			}
		}
		String message = "Expected error marker not found: '" + issueCode
				+ (allCodes.isEmpty() ? "'" : "' but found '" + Strings.concat(",", allCodes) + "'");
		assertTrue(message, matchingIssuesFound > 0);
		assertEquals("Expected error marker count for '" + issueCode + "'", expectedIssuesCount, matchingIssuesFound);
	}

	public void assertNoErrorMarker(IFile file) throws CoreException {
		int severity = file.findMaxProblemSeverity(null, true, IResource.DEPTH_INFINITE);
		if (severity != -1) {
			StringBuilder errors = new StringBuilder();
			for (IMarker marker : file.findMarkers(null, true, IResource.DEPTH_INFINITE)) {
				errors.append("\n").append(marker.getAttribute(IMarker.MESSAGE));
			}
			fail("Expected no error but got" + errors.toString());
		}
	}

}

/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.builder.standalone.IIssueHandler
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.idea.build.net.Protocol.BuildIssue
import org.eclipse.xtext.validation.Issue
import org.jetbrains.jps.incremental.messages.BuildMessage.Kind

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class IdeaIssueHandler implements IIssueHandler {
	
	@Accessors XtextBuildResultCollector buildResultCollector
	
	override handleIssue(Iterable<Issue> issues) {
		var errorFree = true
		for(issue: issues.filter[severity != Severity.IGNORE]) {
			buildResultCollector.addIssue(new BuildIssue() => [
				kind = issue.kind
				message = issue.message
				path = issue.uriToProblem.path
				startOffset = issue.offset
				endOffset = issue.offset + issue.length
				locationOffset = issue.offset
				line = issue.lineNumber
				column = 0 // FIXME we have to find out the column :-(
			])
			errorFree = errorFree && issue.severity != Severity.ERROR
		}
		return errorFree
	}
	
	private def getKind(Issue issue) {
		switch issue.severity {
			case ERROR:
				Kind.ERROR
			case WARNING:
				Kind.WARNING
			case INFO:
				Kind.INFO
			case IGNORE:
				Kind.PROGRESS
		}
	}
}
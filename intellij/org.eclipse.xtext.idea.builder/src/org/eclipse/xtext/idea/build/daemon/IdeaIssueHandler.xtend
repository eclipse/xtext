/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.idea.build.net.Protocol.BuildIssueMessage
import org.eclipse.xtext.validation.Issue
import org.jetbrains.jps.incremental.messages.BuildMessage.Kind

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class IdeaIssueHandler implements BuildRequest.IPostValidationCallback {
	
	@Inject extension IBuildSessionSingletons 
	
	override afterValidate(URI validated, Iterable<Issue> issues) {
		for(issue: issues.filter[severity != Severity.IGNORE]) {
			objectChannel.writeObject(new BuildIssueMessage() => [
				kind = issue.kind
				message = issue.message
				uriToProblem = issue.uriToProblem.toString
				startOffset = issue.offset
				endOffset = issue.offset + issue.length
				locationOffset = issue.offset
				line = issue.lineNumber
				column = 0 // FIXME we have to find out the column :-(
			])
		}
		return true
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
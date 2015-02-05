package org.eclipse.xtext.idea.build.incremental

import org.eclipse.xtext.builder.standalone.IIssueHandler
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtend.lib.annotations.Accessors
import org.jetbrains.jps.incremental.messages.CompilerMessage
import org.jetbrains.jps.incremental.messages.BuildMessage.Kind
import org.eclipse.xtext.diagnostics.Severity

class IdeaIssueHandler implements IIssueHandler {
	
	@Accessors
	IdeaBuildData buildData
	
	override handleIssue(Iterable<Issue> issues) {
		var hasErrors = false
		for(it: issues.filter[severity != Severity.IGNORE]) {
			buildData.context.processMessage(new CompilerMessage(
				buildData.compilerName, kind, message, uriToProblem.path, 
				offset, offset + length, offset, lineNumber, 0 // we have to find out the column :-(
			))
			hasErrors = hasErrors || severity == Severity.ERROR
		}
		return hasErrors
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
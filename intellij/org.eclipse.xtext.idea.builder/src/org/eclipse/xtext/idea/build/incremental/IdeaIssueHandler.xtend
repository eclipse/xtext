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
		var errorFree = true
		for(it: issues.filter[severity != Severity.IGNORE]) {
			buildData.context.processMessage(new CompilerMessage(
				buildData.compilerName, kind, message, uriToProblem.path, 
				offset, offset + length, offset, lineNumber, 0 // FIXME we have to find out the column :-(
			))
			errorFree = errorFree && severity != Severity.ERROR
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
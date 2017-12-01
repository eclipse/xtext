/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.rename

import java.util.List
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError
import org.eclipse.lsp4j.jsonrpc.messages.ResponseErrorCode
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity
import org.eclipse.xtext.util.ITextRegion

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
class ServerRefactoringIssueAcceptor implements RefactoringIssueAcceptor {
	
	static class Issue {
		Severity severity
		String message
	}
	
	List<Issue> issues = newArrayList
	
	override add(Severity severity, String message, URI uri, ResourceSet resourceSet) {
		addIssue(severity, message)
	}
	
	override add(Severity severity, String message, URI resourceUri) {
		addIssue(severity, message)
	}
	
	override add(Severity severity, String message, EObject element) {
		addIssue(severity, message)
	}
	
	override add(Severity severity, String message, EObject element, ITextRegion region) {
		addIssue(severity, message)
	}
	
	override add(Severity severity, String message, Exception exc, Logger log) {
		addIssue(severity, message)
	}
	
	override add(Severity severity, String message, Object... params) {
		issues += new Issue => [
			it.severity = severity
			it.message = message
		]
		checkSeverity
	}
	
	protected def boolean addIssue(Severity severity, String message) {
		issues += new Issue => [
			it.severity = severity
			it.message = message
		]
	}
	
	def Severity getMaximumSeverity() {
		issues.minBy[severity]?.severity ?: Severity.OK
	}	
	
	def ResponseError toResponseError() {
		val maxSeverity = maximumSeverity
		new ResponseError => [
			message = switch (maxSeverity) {
				case OK: 'Refactoring is possible' 
				case INFO: 'Refactoring is possible' 
				case WARNING: 'Refactoring could cause issues' 
				case ERROR: 'Refactoring has errors' 
				case FATAL: 'Refactoring cannot be performed' 
			} 
			data = issues.sortBy[severity].reverse.map[message].join('\n')
			code = switch (maxSeverity) {
				case OK: 0 
				case INFO: 0 
				case WARNING: 0 
				case ERROR: ResponseErrorCode.UnknownErrorCode.value 
				case FATAL: ResponseErrorCode.UnknownErrorCode.value 
			} 
		]
	}
	
	def checkSeverity() {
		if(maximumSeverity < Severity.WARNING) 
			throw new ResponseErrorException(toResponseError)
	}
}
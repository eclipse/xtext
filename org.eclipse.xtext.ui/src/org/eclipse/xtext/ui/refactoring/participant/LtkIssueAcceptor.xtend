/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.participant

import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.ITextRegion
import org.apache.log4j.Logger
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper
import com.google.inject.Inject
import org.eclipse.ltk.core.refactoring.RefactoringStatus

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
class LtkIssueAcceptor implements RefactoringIssueAcceptor {
	
	@Inject StatusWrapper status
	
	override add(Severity severity, String message, URI uri, ResourceSet resourceSet) {
		status.add(severity.convert, message, uri, resourceSet)
	}
	
	override add(Severity severity, String message, URI resourceUri) {
		status.add(severity.convert, message, resourceUri)
	}
	
	override add(Severity severity, String message, EObject element) {
		status.add(severity.convert, message, element)
	}
	
	override add(Severity severity, String message, EObject element, ITextRegion region) {
		status.add(severity.convert, message, element, region)
	}
	
	override add(Severity severity, String message, Exception exc, Logger log) {
		status.add(severity.convert, message, exc, log)
	}
	
	override add(Severity severity, String message, Object... params) {
		status.add(severity.convert, message, params)
	}
	
	def getRefactoringStatus() {
		status.refactoringStatus
	}

	protected def convert(Severity severity) {
		switch severity {
			case FATAL: RefactoringStatus.FATAL
			case ERROR: RefactoringStatus.ERROR
			case WARNING: RefactoringStatus.WARNING
			case INFO: RefactoringStatus.INFO
			case OK: RefactoringStatus.OK
		}
	}
}
/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.refactoring;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public interface RefactoringIssueAcceptor {
	enum Severity {
		FATAL, ERROR, WARNING, INFO, OK;
	}

	void add(Severity severity, String message, URI uri, ResourceSet resourceSet);

	void add(Severity severity, String message, URI resourceUri);

	void add(Severity severity, String message, EObject element);

	void add(Severity severity, String message, EObject element, ITextRegion region);

	void add(Severity severity, String message, Exception exc, Logger log);

	void add(Severity severity, String message, Object... params);
}

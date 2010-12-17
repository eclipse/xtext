/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RefactoringStatusException extends RuntimeException {

	private static final long serialVersionUID = 6796021485044787459L;
	private final boolean isFatal;

	public RefactoringStatusException(String message, boolean isFatal) {
		super(message);
		this.isFatal = isFatal;
	}
	
	public boolean isFatal() {
		return isFatal;
	}

	@Deprecated
	public void reportToStatus(RefactoringStatus status) {
		if(isFatal)
			status.addFatalError(getMessage());
		else
			status.addError(getMessage());
	}
	
}
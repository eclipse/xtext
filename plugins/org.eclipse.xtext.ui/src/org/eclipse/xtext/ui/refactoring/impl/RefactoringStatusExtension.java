/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.apache.log4j.Logger;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RefactoringStatusExtension {

	private static final Logger LOG = Logger.getLogger(RefactoringStatusExtension.class);
	
	public static void handleException(RefactoringStatus status, Exception exc) {
		if(exc instanceof RefactoringStatusException) { 
			if(((RefactoringStatusException) exc).isFatal())
				status.addFatalError(exc.getMessage());
			else
				status.addError(exc.getMessage());
		} else {
			status.addFatalError("Error during refactoring: " + exc.getMessage() +". See log for details");
			LOG.error("Error during refactoring", exc);
		}
	}
}

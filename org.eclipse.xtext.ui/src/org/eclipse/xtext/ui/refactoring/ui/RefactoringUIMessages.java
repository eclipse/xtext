/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import org.eclipse.osgi.util.NLS;

/**
 * @author George Suaridze - Initial contribution and API
 */
class RefactoringUIMessages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.ui.refactoring.ui.messages"; //$NON-NLS-1$
	public static String RefactoringHintTemplate_0;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, RefactoringUIMessages.class);
	}

	private RefactoringUIMessages() {
	}
}

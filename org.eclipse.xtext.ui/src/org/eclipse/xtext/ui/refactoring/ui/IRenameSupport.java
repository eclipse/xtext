/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;


/**
 * Common UI facade of JDT and Xtext rename refactorings.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IRenameSupport {
	
	interface Factory {
		IRenameSupport create(Object context, String newName);
	}
	
	void startRefactoringWithDialog(final boolean previewOnly) throws InterruptedException;

	void startDirectRefactoring() throws InterruptedException;
	
}

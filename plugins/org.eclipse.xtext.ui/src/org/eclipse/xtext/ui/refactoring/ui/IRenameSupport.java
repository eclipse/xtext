/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

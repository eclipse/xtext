/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

/**
 * Provides the rename refactoring for a given element.
 * 
 * Top-level hook for clients who want to provide a completely different rename refactoring implementation.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IRenameRefactoringProvider {

	ProcessorBasedRefactoring getRenameRefactoring(IRenameElementContext renameElementContext);
	
	RenameProcessor getRenameProcessor(IRenameElementContext renameElementContext);
}

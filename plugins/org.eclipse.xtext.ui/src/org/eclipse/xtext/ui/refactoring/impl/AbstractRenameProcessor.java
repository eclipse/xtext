/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.ImplementedBy;

/**
 * Unfortunately LTK only defines abstract classes so this is an abstract class instead of an interface only.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
@ImplementedBy(RenameElementProcessor.class)
public abstract class AbstractRenameProcessor extends RenameProcessor {

	public abstract boolean initialize(IRenameElementContext renameElementContext);

	public abstract String getOriginalName();

	public abstract String getNewName();

	public abstract void setNewName(String newName);
	
	public abstract RefactoringStatus validateNewName(String newName);
	
}

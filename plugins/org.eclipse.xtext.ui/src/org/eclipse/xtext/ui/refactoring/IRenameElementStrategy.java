/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameElementStrategy;

import com.google.inject.ImplementedBy;

/**
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(DefaultRenameElementStrategy.class)
public interface IRenameElementStrategy {

	String getCurrentName();

	ReplaceEdit getRenameEdit(String newName);

	RefactoringStatus validateNewName(String newName);

	@ImplementedBy(DefaultRenameElementStrategy.Provider.class)
	interface Provider {
		IRenameElementStrategy get(IEObjectDescription target);
	}
}

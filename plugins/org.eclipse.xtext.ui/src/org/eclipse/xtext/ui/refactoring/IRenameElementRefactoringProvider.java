/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameElementRefactoringProvider;

import com.google.inject.ImplementedBy;

/**
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(DefaultRenameElementRefactoringProvider.class)
public interface IRenameElementRefactoringProvider {

	RenameRefactoring getRenameRefactoring(IEObjectDescription element);
}

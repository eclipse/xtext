/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Sets.*;

import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.ReferenceQueryData;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;

import com.google.common.base.Predicate;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RefactoringReferenceQueryDataFactory {

	public IReferenceFinder.IQueryData create(ElementRenameArguments args) {
		return new ReferenceQueryData(args.getTargetElementURI(),
				newLinkedHashSet(args.getRenamedElementURIs()), args.getTargetElementURI().trimFragment(), createFilter(args), "");
	}

	protected Predicate<IReferenceDescription> createFilter(ElementRenameArguments args) {
		return null;
	}
}

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator;

import com.google.inject.ImplementedBy;

/**
 * Calculates elements whose name changes with the rename of a <code>baseElement</code>. Cross-references to these
 * elements will have to be updated, too.
 * 
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(DefaultDependentElementsCalculator.class)
public interface IDependentElementsCalculator {

	Iterable<ElementRenameInfo> getDependentElementRenameInfos(EObject baseElement, ElementRenameInfo baseRenameInfo, IProgressMonitor monitor);

	static class Null implements IDependentElementsCalculator {
		public Iterable<ElementRenameInfo> getDependentElementRenameInfos(EObject baseElement,
				ElementRenameInfo baseRenameInfo, IProgressMonitor monitor) {
			return Collections.emptyList();
		}
	}
}

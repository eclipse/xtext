/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.refactoring;

import static com.google.common.collect.Iterables.*;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringStatusException;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelDependentElementsCalculator;
import org.eclipse.xtext.xtend2.jvmmodel.DispatchUtil;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2DependentElementsCalculator extends JvmModelDependentElementsCalculator {

	@Inject
	private DispatchUtil dispatchUtil;
	
	@Override
	public List<URI> getDependentElementURIs(EObject baseElement, IProgressMonitor monitor) {
		if (baseElement instanceof XtendFunction) {
			for (JvmOperation inferredOperation : filter(getJvmModelAssociations().getJvmElements(baseElement),
					JvmOperation.class)) {
				if (dispatchUtil.isDispatcherFunction(inferredOperation))
					throw new RefactoringStatusException("Cannot refactor polymorphic dispatch method", true);
			}
		}
		return super.getDependentElementURIs(baseElement, monitor);
	}

}

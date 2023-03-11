/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelDependentElementsCalculator;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendDependentElementsCalculator extends JvmModelDependentElementsCalculator {

	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private DispatchRenameSupport dispatchRenameSupport;
	
	@Override
	public List<URI> getDependentElementURIs(EObject baseElement, IProgressMonitor monitor) {
		if (baseElement instanceof XtendFunction && ((XtendFunction) baseElement).isDispatch()) {
			Set<URI> result = newHashSet();
			for(JvmOperation dispatchOperation: dispatchRenameSupport.getAllDispatchOperations((XtendFunction) baseElement)) {
				result.add(EcoreUtil2.getPlatformResourceOrNormalizedURI(dispatchOperation));
				XtendFunction xtendFunction = associations.getXtendFunction(dispatchOperation);
				if(xtendFunction != null) {
					result.add(EcoreUtil2.getPlatformResourceOrNormalizedURI(xtendFunction));
				}
			}
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			return newArrayList(result);
		}
		return super.getDependentElementURIs(baseElement, monitor);
	}

}

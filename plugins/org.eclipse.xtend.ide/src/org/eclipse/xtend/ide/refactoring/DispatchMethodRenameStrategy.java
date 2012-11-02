/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import static com.google.common.collect.Lists.*;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtend.core.dispatch.DispatchingSupport;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategyProvider.IInitializable;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.DefaultJvmModelRenameStrategy;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DispatchMethodRenameStrategy implements IInitializable {

	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private com.google.inject.Provider<DispatchMethodChildStrategy> childStrategyProvider; 
	
	@Inject
	private DispatchingSupport support;
	
	private List<IRenameStrategy> children = newArrayList(); 
	
	public boolean initialize(EObject xtendMethod, IRenameElementContext context) {
		Assert.isLegal(xtendMethod instanceof XtendFunction);
		Assert.isLegal(((XtendFunction) xtendMethod).isDispatch());

		JvmOperation dispatcher = associations.getDispatchOperation((XtendFunction)xtendMethod);
		XtendClass xtendClass = ((XtendClass)xtendMethod.eContainer());
		Collection<JvmOperation> dispatchCases = support.getDispatcher2dispatched(xtendClass, false).get(dispatcher);
		for(JvmOperation dispatchCase: dispatchCases) {
			XtendFunction xtendDispatchMethod = associations.getXtendFunction(dispatchCase);
			if(xtendDispatchMethod != null) {
				DispatchMethodChildStrategy childStrategy = childStrategyProvider.get();
				childStrategy.initialize(xtendDispatchMethod, context);
				children.add(childStrategy);
			} else {
				// TODO non local cases
			}
		}
		return !children.isEmpty();
	}
	
	public static class DispatchMethodChildStrategy extends DefaultJvmModelRenameStrategy {
		@Override
		protected void setInferredJvmElementName(String name, EObject renamedElement) {
			super.setInferredJvmElementName("_" + name, renamedElement);
		}
	}

	public String getOriginalName() {
		return children.get(0).getOriginalName();
	}

	public RefactoringStatus validateNewName(String newName) {
		RefactoringStatus status = new RefactoringStatus();
		for(IRenameStrategy child: children)
			status.merge(child.validateNewName(newName));
		return status;
	}

	public void applyDeclarationChange(String newName, ResourceSet resourceSet) {
		for(IRenameStrategy child: children)
			child.applyDeclarationChange(newName, resourceSet);
	}

	public void revertDeclarationChange(ResourceSet resourceSet) {
		for(IRenameStrategy child: children)
			child.revertDeclarationChange(resourceSet);
	}

	public void createDeclarationUpdates(String newName, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor) {
		for(IRenameStrategy child: children)
			child.createDeclarationUpdates(newName, resourceSet, updateAcceptor);
	}
	
}

/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2RenameStrategy extends DefaultRenameStrategy {

	public static class Provider extends DefaultRenameStrategy.Provider {
		@Override
		public IRenameStrategy get(EObject targetElement, IRenameElementContext renameElementContext) {
			return new Xtend2RenameStrategy(targetElement, getLocationInFileProvider());
		}
	}
	
	protected Xtend2RenameStrategy(EObject targetElement, ILocationInFileProvider locationInFileProvider) {
		super(targetElement, locationInFileProvider);
	}

	@Override
	protected void resolveProxies(ResourceSet resourceSet) {
		for(int i=0; i< resourceSet.getResources().size(); ++i) {
			Resource resource = resourceSet.getResources().get(i);
			if(!(resource instanceof TypeResource))
				EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
		}
	}
}

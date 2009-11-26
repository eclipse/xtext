/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.namespaces;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.index.IXtextIndexFacade;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IndexGlobalScopeProvider2 extends AbstractScopeProvider implements IGlobalScopeProvider {
	
	@Inject
	private IXtextIndexFacade indexFacade;
	
	@Inject
	private IResourceDescription.Manager descriptionManager;
	
	@Inject
	private IContainer.Manager containerManager;
	
	public IScope getScope(final EObject context, EReference reference) {
		IScope result = IScope.NULLSCOPE;
		IResourceDescription description = descriptionManager.getResourceDescription(context.eResource());
		List<IContainer> containers = containerManager.getVisibleContainers(description);
		ListIterator<IContainer> iter = containers.listIterator();
		while(iter.hasPrevious()) {
			IContainer container = iter.previous();
			result = createIndexScope(result, container, reference);
		}
		return result;
	}

	protected SimpleScope createIndexScope(IScope parent, final IContainer container, final EReference reference) {
		return new SimpleScope(parent, null) {

			@Override
			public Iterable<IEObjectDescription> internalGetContents() {
				return indexFacade.findAllEObjects(container, reference.getEReferenceType());
			}

			@Override
			public IEObjectDescription getContentByName(String name) {
				Iterable<IEObjectDescription> allDescriptions = indexFacade.findAllEObjects(
						container, reference.getEReferenceType(), name);
				Iterator<IEObjectDescription> iter = allDescriptions.iterator();
				IEObjectDescription result = null;
				while(iter.hasNext()) {
					if (result != null)
						return null;
					result = iter.next();
				}
				if (result != null)
					return result;
				return getOuterScope().getContentByName(name);
			}

			@Override
			public IEObjectDescription getContentByEObject(EObject object) {
				Iterable<IEObjectDescription> allDescriptions = indexFacade.findAllDescriptionsFor(object);
				Iterator<IEObjectDescription> iter = allDescriptions.iterator();
				boolean hadNext = false;
				while(iter.hasNext()) {
					hadNext = true;
					IEObjectDescription result = iter.next();
					if (isValidForEObject(result))
						return result;
				}
				if (hadNext)
					return null;
				return getOuterScope().getContentByEObject(object);
			}

			private boolean isValidForEObject(IEObjectDescription result) {
				Iterable<IEObjectDescription> allDescriptionsByName = indexFacade.findAllEObjects(
						container, reference.getEReferenceType(), result.getName());
				Iterator<IEObjectDescription> iter = allDescriptionsByName.iterator();
				IEObjectDescription inverted = null;
				while(iter.hasNext()) {
					if (inverted != null)
						return false;
					inverted = iter.next();
				}
				return inverted != null && inverted.getEObjectURI().equals(result.getEObjectURI());
			}
		};
	}

}

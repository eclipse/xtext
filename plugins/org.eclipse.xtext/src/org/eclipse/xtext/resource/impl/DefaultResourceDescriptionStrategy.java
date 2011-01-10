/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultResourceDescriptionStrategy implements IDefaultResourceDescriptionStrategy {

	private final static Logger LOG = Logger.getLogger(DefaultResourceDescriptionStrategy.class);

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	public void setQualifiedNameProvider(IQualifiedNameProvider qualifiedNameProvider) {
		this.qualifiedNameProvider = qualifiedNameProvider;
	}
	
	public IQualifiedNameProvider getQualifiedNameProvider() {
		return qualifiedNameProvider;
	}
	
	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (qualifiedNameProvider == null)
			return false;
		try {
			QualifiedName qualifiedName = qualifiedNameProvider.getFullyQualifiedName(eObject);
			if (qualifiedName != null) {
				acceptor.accept(EObjectDescription.create(qualifiedName, eObject));
			}
		} catch (Exception exc) {
			LOG.error(exc.getMessage());
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean createReferenceDescriptions(EObject from, URI exportedContainerURI, IAcceptor<IReferenceDescription> acceptor) {
		EList<EReference> references = from.eClass().getEAllReferences();
		for (EReference eReference : references) {
			if (isIndexable(eReference) && from.eIsSet(eReference)) {
				Object val = from.eGet(eReference);
				if (val != null) {
					if (eReference.isMany()) {
						List<EObject> list = (List<EObject>) val;
						for (int i = 0; i < list.size(); i++) {
							EObject to = list.get(i);
							if (isResolvedAndExternal(from, to)) {
								acceptor.accept(new DefaultReferenceDescription(from, to,
										eReference, i, exportedContainerURI));
							}
						}
					} else {
						EObject to = (EObject) val;
						if (isResolvedAndExternal(from, to)) {
							acceptor.accept(new DefaultReferenceDescription(from, to, eReference,
									-1, exportedContainerURI));
						}
					}
				}
			}
		}
		return true;
	}


	protected boolean isIndexable(EReference eReference) {
		return !eReference.isContainment() && !eReference.isDerived() && !eReference.isVolatile() && !eReference.isTransient();
	}
	
	protected boolean isResolvedAndExternal(EObject from, EObject to) {
		return to != null && !((InternalEObject) to).eIsProxy() && from.eResource() != to.eResource();
	}

}

/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * By default, all elements with a not null <code>name</code> feature and all cross-resource crossrefs are indexed.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class DefaultResourceDescriptionStrategy implements IDefaultResourceDescriptionStrategy {

	private final static Logger LOG = Logger.getLogger(DefaultResourceDescriptionStrategy.class);

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private LazyURIEncoder uriEncoder;

	public void setQualifiedNameProvider(IQualifiedNameProvider qualifiedNameProvider) {
		this.qualifiedNameProvider = qualifiedNameProvider;
	}

	public IQualifiedNameProvider getQualifiedNameProvider() {
		return qualifiedNameProvider;
	}

	/** @since 2.0 */
	public void setLazyURIEncoder(LazyURIEncoder uriEncoder) {
		this.uriEncoder = uriEncoder;
	}

	/** @since 2.0 */
	public LazyURIEncoder getLazyURIEncoder() {
		return uriEncoder;
	}

	@Override
	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (getQualifiedNameProvider() == null)
			return false;
		try {
			QualifiedName qualifiedName = getQualifiedNameProvider().getFullyQualifiedName(eObject);
			if (qualifiedName != null) {
				acceptor.accept(EObjectDescription.create(qualifiedName, eObject));
			}
		} catch (Exception exc) {
			LOG.error(exc.getMessage(), exc);
		}
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean createReferenceDescriptions(EObject from, URI exportedContainerURI,
			IAcceptor<IReferenceDescription> acceptor) {
		EList<EReference> references = from.eClass().getEAllReferences();
		for (EReference eReference : references) {
			if (isIndexable(eReference) && from.eIsSet(eReference)) {
				Object val = from.eGet(eReference, false);
				if (val != null) {
					if (eReference.isMany()) {
						InternalEList<EObject> list = (InternalEList<EObject>) val;
						for (int i = 0; i < list.size(); i++) {
							EObject to = list.basicGet(i);
							if (isResolvedAndExternal(from, to)) {
								acceptor.accept(createReferenceDescription(from, exportedContainerURI, eReference, i,
										to));
							}
						}
					} else {
						EObject to = (EObject) val;
						if (isResolvedAndExternal(from, to)) {
							acceptor.accept(createReferenceDescription(from, exportedContainerURI, eReference, -1, to));
						}
					}
				}
			}
		}
		return true;
	}

	/** @since 2.0 */
	protected IReferenceDescription createReferenceDescription(EObject owner, URI exportedContainerURI,
			EReference eReference, int indexInList, EObject target) {
		return new DefaultReferenceDescription(owner, target, eReference, indexInList, exportedContainerURI);
	}

	protected boolean isIndexable(EReference eReference) {
		return (!eReference.isContainment() || eReference.isResolveProxies()) 
				&& !eReference.isDerived() 
				&& !eReference.isVolatile()
				&& !eReference.isTransient() 
				&& (!eReference.isContainer() || eReference.isResolveProxies());
	}

	protected boolean isResolvedAndExternal(EObject from, EObject to) {
		if (to == null)
			return false;
		if (!to.eIsProxy()) {
			if (to.eResource() == null) {
				LOG.error("Reference from " + EcoreUtil.getURI(from) + " to " + to
						+ " cannot be exported as the target is not contained in a resource.");
				return false;
			}
			return from.eResource() != to.eResource();
		}
		return !getLazyURIEncoder()
				.isCrossLinkFragment(from.eResource(), ((InternalEObject) to).eProxyURI().fragment());
	}
}

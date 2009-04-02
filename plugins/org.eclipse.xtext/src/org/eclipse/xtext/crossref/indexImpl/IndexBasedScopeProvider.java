/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref.indexImpl;

import java.util.Iterator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.EObjectDescriptor.Query;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.crossref.impl.AbstractScopeProvider;
import org.eclipse.xtext.crossref.impl.SimpleAttributeResolver;
import org.eclipse.xtext.crossref.impl.SimpleNestedScope;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IndexBasedScopeProvider extends AbstractScopeProvider {
	
	private final IIndexStore index;
	
	@Inject
	public IndexBasedScopeProvider(IIndexStore index) {
		this.index = index;
	}

	public IScope getScope(EObject context, EReference ref) {
		EClass type = (EClass) ref.getEType();
		return getScope(context, type);
	}
	
	public IScope getScope(EObject context, EClass type) {
		Resource eResource = context.eResource();
		Iterable<IScopedElement> iterable = getElements(eResource.getURI().toPlatformString(true), type);
		TreeIterator<EObject> eAllContents = EcoreUtil.getRootContainer(context).eAllContents();
			
		return new SimpleNestedScope(createOuter(eAllContents, type), iterable);
	}

	private Iterable<IScopedElement> getElements(String uri, EClass eClazz) {
		Query eClassQuery = index.eObjectDAO().createQuery();
		eClassQuery.resource().uri(uri);
		eClassQuery.eClass().name(eClazz.getName()).ePackage().nsURI(eClazz.getEPackage().getNsURI());
		final Iterable<EObjectDescriptor> iter = eClassQuery.executeListResult();
		return Iterables.transform(iter, new Function<EObjectDescriptor, IScopedElement>(){
			public IScopedElement apply(EObjectDescriptor param) {
				return new IndexBasedScopedElement(param);
			}});
	}

	private final SimpleAttributeResolver<EObject, String> importResolver = SimpleAttributeResolver.newResolver(String.class, "importURI");
	
	/**
	 * @param context
	 * @param reference
	 * @return
	 */
	private IScope createOuter(Iterator<EObject> iter, EClass type) {
		while (iter.hasNext()) {
			EObject object = iter.next();
			String uri = importResolver.getValue(object);
			if (uri != null) {
				Iterable<IScopedElement> elements = getElements(uri, type);
				return new SimpleNestedScope(createOuter(iter, type), elements);
			}
		}
		return IScope.NULLSCOPE;
	}

}

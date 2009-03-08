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
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor.Query;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.crossref.impl.AbstractScopeProvider;
import org.eclipse.xtext.crossref.impl.SimpleAttributeResolver;
import org.eclipse.xtext.crossref.impl.SimpleNestedScope;
import org.eclipse.xtext.util.AdaptingIterable;
import org.eclipse.xtext.util.Function;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IndexBasedScopeProvider extends AbstractScopeProvider {
	
	private IIndexStore index;
	
	@Inject
	public IndexBasedScopeProvider(IIndexStore index) {
		this.index = index;
	}

	public IScope getScope(EObject context, EReference reference) {
		Resource eResource = context.eResource();
		EClass eClazz = (EClass) reference.getEType();
		Iterable<IScopedElement> iterable = getElements(eResource.getURI().toPlatformString(true), eClazz);
		TreeIterator<EObject> eAllContents = EcoreUtil.getRootContainer(context).eAllContents();
			
		return new SimpleNestedScope(createOuter(eAllContents,reference), iterable);
	}

	private Iterable<IScopedElement> getElements(String uri, EClass eClazz) {
		ResourceDescriptor descriptor = index.resourceDAO().createQuery().uri(uri).executeSingleResult();
		EClassDescriptor clazzDesc = index.eClassDAO().createQueryEClass(eClazz).executeSingleResult();
		Query eClassQuery = index.eObjectDAO().createQuery().resource(descriptor).eClass(clazzDesc);
		final Iterable<EObjectDescriptor> iter = eClassQuery.executeListResult();
		return AdaptingIterable.create(iter, new Function<EObjectDescriptor, IScopedElement>(){

			public IScopedElement exec(EObjectDescriptor param) {
				return new IndexBasedScopedElement(param);
			}});
	}

	private final SimpleAttributeResolver<String> importResolver = SimpleAttributeResolver.newResolver(String.class, "importURI");
	/**
	 * @param context
	 * @param reference
	 * @return
	 */

	private IScope createOuter(Iterator<EObject> iter, EReference ref) {
		while (iter.hasNext()) {
			EObject object = iter.next();
			String uri = importResolver.getValue(object);
			if (uri != null) {
				EClass eType = (EClass) ref.getEType();
				Iterable<IScopedElement> elements = getElements(uri, eType);
				return new SimpleNestedScope(createOuter(iter, ref), elements);
			}
		}
		return IScope.NULLSCOPE;
	}

}

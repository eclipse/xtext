/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfindex.ResourceDescriptor;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.ResourceDescriptorQuery;
import org.eclipse.emf.emfindex.store.IndexUpdater;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EReferenceDescriptorIndexer {

	private static Logger log = Logger.getLogger(EReferenceDescriptorIndexer.class);

	public void update(Resource resource, IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
		ResourceDescriptorQuery query = new ResourceDescriptorQuery();
		query.setURI(resource.getURI());
		Iterator<ResourceDescriptor> result = queryExecutor.execute(query).iterator();
		if (!result.hasNext()) {
			return;
		}
		ResourceDescriptor descriptor = result.next();
		descriptor.getEReferenceDescriptors().clear();
		Map<EObject, Collection<Setting>> find = EcoreUtil.CrossReferencer.find(resource.getContents());
		for (Map.Entry<EObject, Collection<Setting>> entry : find.entrySet()) {
			for (Setting setting : entry.getValue()) {
				Object target = setting.get(true);
				if (setting.getEStructuralFeature().isMany())
					for (Object t : (Collection<?>) target)
						index(indexUpdater, setting.getEObject(), (EObject) t, (EReference) setting
								.getEStructuralFeature());
				else
					index(indexUpdater, setting.getEObject(), (EObject) target, (EReference) setting
							.getEStructuralFeature());
			}
		}
	}

	protected void index(IndexUpdater indexUpdater, EObject from, EObject to, EReference ref) {
		Resource res = from.eResource();
		if (!((to instanceof InternalEObject) && ((InternalEObject) to).eIsProxy())) {
			indexUpdater.createOrUpdateEReference(res.getURI(), res.getURIFragment(from), EcoreUtil.getURI(to), ref,
					getUserData(from, to, ref));
		} else {
			if (log.isInfoEnabled())
				log.info("Unresolved cross link to " + to);
		}
	}

	protected Map<String, String> getUserData(EObject from, EObject to, EReference ref) {
		return null;
	}

}

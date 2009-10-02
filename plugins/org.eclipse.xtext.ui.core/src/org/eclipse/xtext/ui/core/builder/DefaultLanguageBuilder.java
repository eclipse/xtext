/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.scoping.IQualifiedNameProvider;
import org.eclipse.xtext.ui.core.editor.validation.IXtextResourceChecker;
import org.eclipse.xtext.validation.CheckMode;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultLanguageBuilder implements ILanguageBuilder {

	@Inject(optional = true)
	private IQualifiedNameProvider qualifiedNameProvider;

	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(getClass());
	
	public void indexEObjectDescriptors(Resource resource, IEObjectDescriptorIndexer feeder, IProgressMonitor monitor) {
		if (qualifiedNameProvider == null)
			return;
		TreeIterator<EObject> iterator = resource.getAllContents();
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			String qualifiedName = qualifiedNameProvider.getQualifiedName(next);
			if (qualifiedName != null)
				feeder.index(qualifiedName, next, null);
		}
	}

	public void indexEReferenceDescriptors(Resource resource, IEReferenceDescriptorIndexer feeder,
			IProgressMonitor monitor) {
		Map<EObject, Collection<Setting>> find = EcoreUtil.CrossReferencer.find(resource.getContents());
		for (Map.Entry<EObject, Collection<Setting>> entry : find.entrySet()) {
			for (Setting setting : entry.getValue()) {
				feeder.index(setting.getEObject(), (EObject) setting.get(true), (EReference) setting
						.getEStructuralFeature());
			}
		}
	}

	public void doBuild(Resource res, IProgressMonitor monitor) {
	}

	public Resource load(URI uri, ResourceSet resourceSet, IProgressMonitor monitor) {
		Resource resource = resourceSet.getResource(uri, true);
		return resource;
	}

	@Inject
	private IXtextResourceChecker resourceChecker;

	public List<Map<String, Object>> validate(Resource res, IProgressMonitor monitor) {
		return resourceChecker.check(res, getValidationContext(), monitor);
	}

	protected Map<?, ?> getValidationContext() {
		return Collections.singletonMap(CheckMode.KEY, CheckMode.NORMAL_AND_FAST);
	}

}

/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XExpression;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
@Singleton
public class JvmModelAssociator implements IJvmModelAssociations, IJvmModelAssociator, ILogicalContainerProvider, IDerivedStateComputer {
	
	@SuppressWarnings("unused")
	private final static Logger LOG = Logger.getLogger(JvmModelAssociator.class);
	
	@Inject
	@Named(Constants.LANGUAGE_NAME) 
	private String languageName;
	
	@Inject 
	private IReferableElementsUnloader.GenericUnloader unloader;
	
	@Inject
	private IJvmModelInferrer inferrer;
	
	protected static class Adapter extends AdapterImpl {
		public ListMultimap<EObject, EObject> sourceToTargetMap = LinkedListMultimap.create();
		public Map<EObject, JvmIdentifiableElement> logicalContainerMap = newHashMap();
		
		@Override
		public boolean isAdapterForType(Object type) {
			return Adapter.class == type;
		}
	}
	
	protected Adapter getOrInstall(Resource resource) {
		if (!(resource instanceof XtextResource))
			return new Adapter();
		if (!languageName.equals(((XtextResource) resource).getLanguageName()))
			return new Adapter();
		Adapter adapter = (Adapter) EcoreUtil.getAdapter(resource.eAdapters(), Adapter.class);
		if (adapter == null) {
			adapter = new Adapter();
			resource.eAdapters().add(adapter);
		}
		return adapter;
	}
	
	protected Map<EObject, JvmIdentifiableElement> getLogicalContainerMapping(Resource resource) {
		return getOrInstall(resource).logicalContainerMap;
	}
	
	public XExpression getAssociatedExpression(JvmIdentifiableElement element) {
		if (element == null)
			return null;
		Map<EObject, JvmIdentifiableElement> mapping = getLogicalContainerMapping(element.eResource());
		for (Map.Entry<EObject, JvmIdentifiableElement> entry : mapping.entrySet()) {
			if (entry.getValue() == element && entry.getKey() instanceof XExpression) {
				return (XExpression) entry.getKey();
			}
		}
		return null;
	}

	public JvmIdentifiableElement getLogicalContainer(EObject object) {
		if (object == null)
			return null;
		final Map<EObject, JvmIdentifiableElement> mapping = getLogicalContainerMapping(object.eResource());
		if (mapping.containsKey(object)) {
			return mapping.get(object);
		}
		if (object.eContainer() != null && !mapping.containsKey(object.eContainer())) {
			Set<EObject> elements = getJvmElements(object.eContainer());
			for (EObject eObject : elements) {
				if (eObject instanceof JvmIdentifiableElement) {
					return (JvmIdentifiableElement) eObject;
				}
			}
		}
		return null;
	}
	
	public void associateLogicalContainer(EObject logicalChild, JvmIdentifiableElement element) {
		if (logicalChild == null)
			return;
		final Map<EObject, JvmIdentifiableElement> mapping = getLogicalContainerMapping(logicalChild.eResource());
		if (mapping.containsKey(logicalChild)) {
			throw new IllegalStateException("There is already a logical container for "+logicalChild);
		}
		mapping.put(logicalChild, element);
	}

	protected ListMultimap<EObject, EObject> sourceToTargetMap(Resource res) {
		return getOrInstall(res).sourceToTargetMap;
	}

	protected Resource getResource(Notifier ctx) {
		Resource res = null;
		if (ctx instanceof EObject) {
			res = ((EObject) ctx).eResource();
		} else if (ctx instanceof Resource) {
			res = (Resource) ctx;
		}
		if (res == null) {
			throw new IllegalArgumentException(
					"Argument must either be an EObject (cotained in a resource) or a resource. But was " + ctx);
		}
		return res;
	}

	public void associate(EObject sourceElement, EObject jvmElement) {
		if (sourceElement != null) {
			ListMultimap<EObject, EObject> map = sourceToTargetMap(sourceElement.eResource());
			map.put(sourceElement, jvmElement);
		}
	}

	public void associatePrimary(EObject sourceElement, EObject jvmElement) {
		if (sourceElement != null) {
			ListMultimap<EObject, EObject> map = sourceToTargetMap(sourceElement.eResource());
			if (map.containsKey(sourceElement)) {
				map.get(sourceElement).add(0, jvmElement);
			} else {
				map.put(sourceElement, jvmElement);
			}
		}
	}

	public Set<EObject> getJvmElements(EObject sourceElement) {
		final ListMultimap<EObject, EObject> sourceToTargetMap = sourceToTargetMap(sourceElement.eResource());
		final List<EObject> elements = sourceToTargetMap.get(sourceElement);
		return newLinkedHashSet(elements);
	}

	public Set<EObject> getSourceElements(EObject jvmElement) {
		//If this turns out to be too slow we should improve the internal data structure :-)
		ListMultimap<EObject,EObject> map = sourceToTargetMap(jvmElement.eResource());
		Set<EObject> sourceElements = newLinkedHashSet();
		for (Map.Entry<EObject, EObject> entry : map.entries()) {
			if (entry.getValue() == jvmElement)
				sourceElements.add(entry.getKey());
		}
		return sourceElements;
	}

	public EObject getPrimarySourceElement(EObject jvmElement) {
		ListMultimap<EObject,EObject> map = sourceToTargetMap(jvmElement.eResource());
		for (Map.Entry<EObject, EObject> entry : map.entries()) {
			if (entry.getValue() == jvmElement)
				return entry.getKey();
		}
		return null;
	}

	public void installDerivedState(final DerivedStateAwareResource resource, boolean isPreLinkingPhase) {
		if (resource.getContents().isEmpty())
			return;
		EObject eObject = resource.getContents().get(0);
		inferrer.infer(eObject, new IAcceptor<JvmDeclaredType>() {
			public void accept(JvmDeclaredType t) {
				resource.getContents().add(t);
			}
		}, isPreLinkingPhase);
	}

	public void discardDerivedState(DerivedStateAwareResource resource) {
		cleanAssociationState(resource);
	}

	public void cleanAssociationState(Resource resource) {
		List<EObject> derived = newArrayList();
		EList<EObject> resourcesContentsList = resource.getContents();
		for (int i = 1; i< resourcesContentsList.size(); i++) {
			EObject eObject = resourcesContentsList.get(i);
			unloader.unloadRoot(eObject);
			derived.add(eObject);
		}
		resourcesContentsList.removeAll(derived);
		sourceToTargetMap(resource).clear();
		getLogicalContainerMapping(resource).clear();
	}
}


/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Sets.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.IResourceScopeCache;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class JvmModelAssociator implements IJvmModelAssociations, IJvmModelAssociator {

	@Inject
	private IResourceScopeCache cache;
	
	protected ListMultimap<EObject, EObject> sourceToTargetMap(EObject ctx) {
		return cache.get("jvm-associations", ctx.eResource(), new Provider<ListMultimap<EObject,EObject>>() {
			public ListMultimap<EObject, EObject> get() {
				return LinkedListMultimap.create();
			}
		});
	}
	
	public void associate(EObject sourceElement, EObject jvmElement) {
		ListMultimap<EObject, EObject> map = sourceToTargetMap(sourceElement);
		map.put(sourceElement, jvmElement);
	}

	public void associatePrimary(EObject sourceElement, EObject jvmElement) {
		ListMultimap<EObject, EObject> map = sourceToTargetMap(sourceElement);
		if (map.containsKey(sourceElement)) {
			map.get(sourceElement).add(0, jvmElement);
		} else {
			map.put(sourceElement, jvmElement);
		}
	}

	public Set<EObject> getJvmElements(EObject sourceElement) {
		final ListMultimap<EObject, EObject> sourceToTargetMap = sourceToTargetMap(sourceElement);
		final List<EObject> elements = sourceToTargetMap.get(sourceElement);
		return newLinkedHashSet(elements);
	}

	public Set<EObject> getSourceElements(EObject jvmElement) {
		//If this turns out to be too slow we should improve the internal data structure :-)
		ListMultimap<EObject,EObject> map = sourceToTargetMap(jvmElement);
		Set<EObject> sourceElements = newLinkedHashSet();
		for (Map.Entry<EObject, EObject> entry : map.entries()) {
			if (entry.getValue() == jvmElement)
				sourceElements.add(entry.getKey());
		}
		return sourceElements;
	}

	public EObject getPrimarySourceElement(EObject jvmElement) {
		ListMultimap<EObject,EObject> map = sourceToTargetMap(jvmElement);
		for (Map.Entry<EObject, EObject> entry : map.entries()) {
			if (entry.getValue() == jvmElement)
				return entry.getKey();
		}
		return null;
	}

	//TODO get rid of this method
	public Set<EObject> getAssociatedElements(EObject jvmOrSourceElement) {
		ListMultimap<EObject,EObject> map = sourceToTargetMap(jvmOrSourceElement);
		Set<EObject> sourceElements = newLinkedHashSet();
		for (Map.Entry<EObject, EObject> entry : map.entries()) {
			if (entry.getValue() == jvmOrSourceElement) {
				sourceElements.add(entry.getKey());
			} else if (entry.getKey() == jvmOrSourceElement) {
				sourceElements.add(entry.getValue());
			}
		}
		return sourceElements;
	}

}


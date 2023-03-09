/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.XtextPackage;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO double check the usage of {@link #isAdapterForType(Object)}
 */
public class SourceAdapter extends AdapterImpl {

	public static SourceAdapter adapt(EObject object, EObject source) {
		SourceAdapter adapter = (SourceAdapter) EcoreUtil.getAdapter(object.eAdapters(), source);
		if (adapter == null) {
			adapter = new SourceAdapter();
			object.eAdapters().add(adapter);
		}
		adapter.sources.add(source);
		return adapter;
	}
	
	public static SourceAdapter find(EObject object) {
		for(Adapter adapter: object.eAdapters()) {
			if (adapter instanceof SourceAdapter)
				return (SourceAdapter) adapter;
		}
		return null;
	}

	private Set<EObject> sources;
	
	protected SourceAdapter() {
		this.sources = Sets.newHashSet();
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type instanceof EObject && XtextPackage.eINSTANCE == ((EObject) type).eClass().getEPackage(); 
	}
	
	public Collection<EObject> getSources() {
		return Collections.unmodifiableCollection(sources);
	}
	
}

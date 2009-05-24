/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.index.resource.impl.ResourceIndexerImpl;
import org.eclipse.xtext.linking.impl.SimpleAttributeResolver;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class DefaultDeclarativeResourceIndexer extends ResourceIndexerImpl {

	private final PolymorphicDispatcher<String> getName = new PolymorphicDispatcher<String>("getName", 1, 1, Collections
			.singletonList(this));
	
	private final PolymorphicDispatcher<Boolean> isIndex = new PolymorphicDispatcher<Boolean>("isIndex", 1, 1, Collections
			.singletonList(this));

	private final PolymorphicDispatcher<String> getDisplayName = new PolymorphicDispatcher<String>("getDisplayName", 1, 1, Collections
			.singletonList(this), new PolymorphicDispatcher.ErrorHandler<String>() {

		public String handle(Object[] params, Throwable throwable) {
			return getName.invoke(params);
		}
	});
	
	protected boolean isIndexElement(EObject element) {
		return isIndex.invoke(element);
	};
	
	protected boolean isIndex(EObject element) {
		return getEObjectDisplayName(element) != null;
	};

	@Override
	protected String getEObjectName(EObject eObject) {
		return getName.invoke(eObject);
	}

	@Override
	protected String getEObjectDisplayName(EObject eObject) {
		return getDisplayName.invoke(eObject);
	}

	private final SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class, "name");

	public String getName(EObject obj) {
		String value = resolver.getValue(obj);
		if (value == null)
			return null;
		while (obj.eContainer() != null) {
			obj = obj.eContainer();
			String name = getName(obj);
			if (name != null)
				return name + delimiter() + value;
		}
		return value;
	}

	protected String delimiter() {
		return ".";
	}
}

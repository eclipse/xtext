/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.xtext.generator.OutputConfiguration;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.SetMultimap;

/**
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.12
 */
public class DerivedResourcesLookupMap extends ForwardingMap<OutputConfiguration, Iterable<IMarker>> {

	private Map<OutputConfiguration, Iterable<IMarker>> delegate;
	
	private SetMultimap<String, IFile> reverseLookupMap;

	public DerivedResourcesLookupMap(Map<OutputConfiguration, Iterable<IMarker>> delegate, SetMultimap<String, IFile> reverseLookupMap) {
		this.delegate = delegate;
		this.reverseLookupMap = reverseLookupMap;
	}

	@Override
	protected Map<OutputConfiguration, Iterable<IMarker>> delegate() {
		return delegate;
		
	}

	public Set<IFile> getDerivedResources(String uri) {
		if (reverseLookupMap.containsKey(uri)) {
			return reverseLookupMap.get(uri);
		}
		return Collections.emptySet();
	}

}

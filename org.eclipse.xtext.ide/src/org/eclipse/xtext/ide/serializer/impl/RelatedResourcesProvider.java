/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.serializer.hooks.IEObjectSnapshot;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceSnapshot;
import org.eclipse.xtext.ide.serializer.hooks.IResourceSnapshot;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
 */
public class RelatedResourcesProvider {

	public static class RelatedResource {
		protected final List<IReferenceSnapshot> outgoingReferences = Lists.newArrayList();

		protected final URI uri;

		public RelatedResource(URI uri) {
			super();
			this.uri = uri;
		}

		public URI getUri() {
			return uri;
		}
		
		@Override
		public String toString() {
			List<String> out = Lists.newArrayList();
			for(IReferenceSnapshot s: outgoingReferences) {
				out.add(s.toString());
			}
			Collections.sort(out);
			return getClass().getSimpleName() +" " + uri + "\n" + Joiner.on("\n").join(out);
		}
	}

	public List<RelatedResource> getRelatedResources(Collection<IResourceSnapshot> snapshots) {
		Map<URI, RelatedResource> result = Maps.newLinkedHashMap();
		for (IResourceSnapshot res : snapshots) {
			for (IEObjectSnapshot obj : res.getObjects().values()) {
				for (IReferenceSnapshot ref : obj.getIncomingReferences()) {
					URI source = ref.getSourceEObjectUri().trimFragment();
					RelatedResource related = result.get(source);
					if (related == null) {
						related = new RelatedResource(source);
						result.put(source, related);
					}
					related.outgoingReferences.add(ref);
				}
			}
		}
		Set<URI> added = Sets.newHashSet();
		Set<URI> removed = Sets.newHashSet();
		for (IResourceSnapshot res : snapshots) {
			URI oldUri = res.getURI();
			URI newUri = res.getResource().getURI();
			if (!oldUri.equals(newUri)) {
				added.add(newUri);
				removed.add(oldUri);
			} else {
				result.remove(newUri);
			}
		}
		removed.removeAll(added);
		for (URI uri : removed) {
			result.remove(uri);
		}
		return ImmutableList.copyOf(result.values());
	}

}

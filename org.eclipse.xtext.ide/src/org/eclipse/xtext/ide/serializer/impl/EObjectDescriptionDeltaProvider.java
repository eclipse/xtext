/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ide.serializer.hooks.IEObjectDescriptionProvider;
import org.eclipse.xtext.ide.serializer.hooks.IEObjectSnapshot;
import org.eclipse.xtext.ide.serializer.hooks.IResourceSnapshot;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.Arrays;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EObjectDescriptionDeltaProvider {

	public static class Delta {
		private List<IEObjectDescription> descriptions = Lists.newArrayList();
		private final EObject object;
		private IEObjectSnapshot snapshot;

		public Delta(EObject object) {
			super();
			this.object = object;
		}

		public List<IEObjectDescription> getDescriptions() {
			return descriptions;
		}

		public IEObjectSnapshot getSnapshot() {
			return snapshot;
		}

		public EObject getObject() {
			return object;
		}
	}

	public static class Deltas {
		private Collection<IResourceSnapshot> snapshots;
		private final Map<EObject, Delta> deltas = Maps.newLinkedHashMap();

		public Collection<IResourceSnapshot> getSnapshots() {
			return snapshots;
		}

		public Delta findContainingDelta(EObject obj) {
			EObject current = obj;
			while (current != null) {
				Delta delta = deltas.get(current);
				if (delta != null) {
					return delta;
				}
				current = current.eContainer();
			}
			return null;
		}
	}

	public static class Group {
		private List<IEObjectDescription> descriptions = Lists.newArrayList();
		private final EObject object;
		private IEObjectSnapshot snapshot;

		public Group(EObject object) {
			super();
			this.object = object;
		}
	}

	protected Delta createDelta(EObject object, IEObjectSnapshot snapshot, List<IEObjectDescription> descriptions) {
		Delta delta = new Delta(object);
		delta.descriptions = descriptions;
		delta.snapshot = snapshot;
		if (snapshot == null || snapshot.getDescriptions() == null || delta.descriptions == null) {
			return delta;
		}
		if (delta.descriptions.size() != snapshot.getDescriptions().size()) {
			return delta;
		}
		if (delta.snapshot.getDescriptions().size() == 1 && delta.descriptions.size() == 1) {
			if (!simpleNameAndUserDataEquals(delta.snapshot.getDescriptions().get(0), delta.descriptions.get(0))) {
				return delta;
			}
			return null;
		}
		Set<IEObjectDescription> remaining = Sets.newHashSet(snapshot.getDescriptions());
		FOR: for (IEObjectDescription desc : descriptions) {
			Iterator<IEObjectDescription> it = remaining.iterator();
			while (it.hasNext()) {
				IEObjectDescription next = it.next();
				if (simpleNameAndUserDataEquals(desc, next)) {
					it.remove();
					continue FOR;
				}
			}
			return null;
		}
		if (remaining.isEmpty()) {
			return delta;
		}
		return null;
	}

	public Deltas getDelta(ChangeSerializer serializer, Collection<IResourceSnapshot> snapshots) {
		Map<EObject, IEObjectSnapshot> old = Maps.newHashMap();
		Map<EObject, Group> groups = Maps.newHashMap();
		for (IResourceSnapshot rs : snapshots) {
			old.putAll(rs.getObjects());
		}
		for (IResourceSnapshot rs : snapshots) {
			IEObjectDescriptionProvider p = serializer.getService(rs.getResource(), IEObjectDescriptionProvider.class);
			Iterable<IEObjectDescription> descriptions = p.getEObjectDescriptions(rs.getResource());
			for (IEObjectDescription desc : descriptions) {
				EObject obj = EcoreUtil.resolve(desc.getEObjectOrProxy(), rs.getResource());
				Group delta = groups.get(obj);
				if (delta == null) {
					delta = new Group(obj);
					delta.snapshot = old.get(obj);
					groups.put(obj, delta);
				}
				delta.descriptions.add(desc);
			}
		}
		Deltas result = new Deltas();
		result.snapshots = snapshots;
		for (Group g : groups.values()) {
			Delta delta = createDelta(g.object, g.snapshot, g.descriptions);
			if (delta != null) {
				result.deltas.put(delta.object, delta);
			}
		}
		return result;
	}

	protected boolean simpleNameAndUserDataEquals(IEObjectDescription oldDesc, IEObjectDescription newDesc) {
		if (!oldDesc.getName().equals(newDesc.getName())) {
			return false;
		}
		if (!userDataEuqals(oldDesc, newDesc)) {
			return false;
		}
		return true;
	}

	protected boolean userDataEuqals(IEObjectDescription oldObj, IEObjectDescription newObj) {
		String[] oldKeys = oldObj.getUserDataKeys();
		String[] newKeys = newObj.getUserDataKeys();
		if (oldKeys.length != newKeys.length)
			return false;
		for (String key : oldKeys) {
			if (!Arrays.contains(newKeys, key))
				return false;
			String oldValue = oldObj.getUserData(key);
			String newValue = newObj.getUserData(key);
			if (!Objects.equal(oldValue, newValue))
				return false;
		}
		return true;
	}

}

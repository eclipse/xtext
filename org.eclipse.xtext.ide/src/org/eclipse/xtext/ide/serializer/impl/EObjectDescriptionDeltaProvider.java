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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

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
 *
 * @since 2.13 
 */
public class EObjectDescriptionDeltaProvider {

	public static class Delta {
		private List<IEObjectDescription> descriptions = Lists.newArrayList();
		private final EObject object;
		private boolean qualifiedNameChanged;
		private boolean simpleNameAndUserDataChanged;
		private IEObjectSnapshot snapshot;

		public Delta(EObject object, IEObjectSnapshot snapshot, List<IEObjectDescription> descriptions) {
			super();
			this.object = object;
			this.snapshot = snapshot;
			this.descriptions = descriptions;
			this.simpleNameAndUserDataChanged = !forAll(this::isSimpleNameAndUserdataEqual);
			this.qualifiedNameChanged = !forAll(this::isQualifiedNameEqual);
		}

		protected boolean forAll(BiFunction<IEObjectDescription, IEObjectDescription, Boolean> comparator) {
			if (snapshot == null) {
				return false;
			}
			List<IEObjectDescription> snap = snapshot.getDescriptions();
			if (snap == null && descriptions == null) {
				return true;
			}
			if (snap == null || descriptions == null) {
				return false;
			}
			int size = descriptions.size();
			if (size == 0 && snap.isEmpty()) {
				return true;
			}
			if (size != snap.size()) {
				return false;
			}
			if (size == 1) {
				return comparator.apply(snap.get(0), descriptions.get(0));
			}
			Set<IEObjectDescription> candidates = Sets.newHashSet(snap);
			FOR: for (IEObjectDescription d : descriptions) {
				Iterator<IEObjectDescription> it = candidates.iterator();
				while (it.hasNext()) {
					IEObjectDescription s = it.next();
					if (comparator.apply(d, s)) {
						it.remove();
						continue FOR;
					}
				}
				return false;
			}
			return true;
		}

		public List<IEObjectDescription> getDescriptions() {
			return descriptions;
		}

		public EObject getObject() {
			return object;
		}

		public IEObjectSnapshot getSnapshot() {
			return snapshot;
		}

		public boolean hasQualifiedNameChanged() {
			return qualifiedNameChanged;
		}

		public boolean hasSimpleNameOrUserdataChanged() {
			return simpleNameAndUserDataChanged;
		}

		protected boolean isQualifiedNameEqual(IEObjectDescription desc1, IEObjectDescription desc2) {
			return desc1.getQualifiedName().equals(desc2.getQualifiedName());
		}

		protected boolean isSimpleNameAndUserdataEqual(IEObjectDescription oldDesc, IEObjectDescription newDesc) {
			if (!oldDesc.getName().equals(newDesc.getName())) {
				return false;
			}
			if (!isUserDataEqual(oldDesc, newDesc)) {
				return false;
			}
			return true;
		}

		protected boolean isUserDataEqual(IEObjectDescription oldObj, IEObjectDescription newObj) {
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

	public static class Deltas {
		private final Map<EObject, Delta> deltas = Maps.newLinkedHashMap();
		private Collection<IResourceSnapshot> snapshots;

		public Delta getDelta(EObject obj) {
			return deltas.get(obj);
		}

		public Collection<Delta> getDeltas() {
			return deltas.values();
		}

		public Collection<IResourceSnapshot> getSnapshots() {
			return snapshots;
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
		return new Delta(object, snapshot, descriptions);
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
			if (delta.hasQualifiedNameChanged() || delta.hasSimpleNameOrUserdataChanged()) {
				result.deltas.put(delta.object, delta);
			}
		}
		return result;
	}

}

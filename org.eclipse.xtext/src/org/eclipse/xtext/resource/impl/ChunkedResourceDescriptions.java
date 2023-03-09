/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.impl;

import static com.google.common.collect.Iterables.*;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.containers.ProjectDescriptionBasedContainerManager;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.annotations.Beta;

/**
 * A IResourceDescriptions implementation that holds its resource description in chunks, each identified by a string.
 * The strings represent units such as projects, source sets, and libraries.
 * 
 * @see ProjectDescription
 * @see ProjectDescriptionBasedContainerManager
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@Beta
public class ChunkedResourceDescriptions extends AbstractCompoundSelectable
		implements IResourceDescriptions, Externalizable {

	protected ConcurrentHashMap<String, ResourceDescriptionsData> chunk2resourceDescriptions = new ConcurrentHashMap<>();
	protected ResourceSet resourceSet;

	public ChunkedResourceDescriptions() {
	}

	public ChunkedResourceDescriptions(Map<String, ResourceDescriptionsData> initialData) {
		chunk2resourceDescriptions = new ConcurrentHashMap<>(initialData);
	}

	public ChunkedResourceDescriptions(Map<String, ResourceDescriptionsData> initialData, ResourceSet resourceSet) {
		this(initialData);
		setResourceSet(resourceSet);
	}

	/**
	 * Creates a shallow copy of the resource descriptions map and installs it with the given ResourceSet.
	 */
	public ChunkedResourceDescriptions createShallowCopyWith(ResourceSet resourceSet) {
		return new ChunkedResourceDescriptions(chunk2resourceDescriptions, resourceSet);
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	protected void setResourceSet(ResourceSet resourceSet) {
		if (this.resourceSet != null)
			throw new IllegalStateException(
					"This " + getClass().getName() + " is already associated with a different resource set.");
		if (ChunkedResourceDescriptions.findInEmfObject(resourceSet) != null)
			throw new IllegalStateException(
					"There is already a different " + getClass().getName() + " installed in the given resource set.");
		this.resourceSet = resourceSet;
		attachToEmfObject(resourceSet);
	}

	public ResourceDescriptionsData setContainer(String name, ResourceDescriptionsData descriptions) {
		return chunk2resourceDescriptions.put(name, descriptions);
	}

	public ResourceDescriptionsData removeContainer(String name) {
		return chunk2resourceDescriptions.remove(name);
	}

	@Override
	protected Iterable<? extends ISelectable> getSelectables() {
		return chunk2resourceDescriptions.values();
	}

	@Override
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return concat(transform(chunk2resourceDescriptions.values(), it -> it.getAllResourceDescriptions()));
	}

	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		for (ResourceDescriptionsData selectable : chunk2resourceDescriptions.values()) {
			IResourceDescription result = selectable.getResourceDescription(uri);
			if (result != null)
				return result;
		}
		return null;
	}

	public ResourceDescriptionsData getContainer(URI uri) {
		for (ResourceDescriptionsData container : chunk2resourceDescriptions.values()) {
			IResourceDescription description = container.getResourceDescription(uri);
			if (description != null)
				return container;
		}
		return null;
	}

	public ResourceDescriptionsData getContainer(String containerHandle) {
		return chunk2resourceDescriptions.get(containerHandle);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		int numChunks = in.readInt();
		for (int i = 0; i < numChunks; i++) {
			String chunkName = in.readUTF();
			int numDescriptions = in.readInt();
			List<IResourceDescription> descriptions = new ArrayList<IResourceDescription>(numDescriptions);
			for (int j = 0; j < numDescriptions; j++)
				descriptions.add((IResourceDescription) in.readObject());
			chunk2resourceDescriptions.put(chunkName, new ResourceDescriptionsData(descriptions));
		}
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		Map<String, ResourceDescriptionsData> copy = new HashMap<>(chunk2resourceDescriptions);
		out.writeInt(copy.entrySet().size());
		for (Entry<String, ResourceDescriptionsData> entry : copy.entrySet()) {
			out.writeUTF(entry.getKey());
			Iterable<Object> descriptions = transform(entry.getValue().getAllResourceDescriptions(),
					d -> d instanceof Serializable ? d : SerializableResourceDescription.createCopy(d));
			out.writeInt(IterableExtensions.size(descriptions));
			for (Object d : descriptions)
				out.writeObject(d);
		}
	}

	public static ChunkedResourceDescriptions findInEmfObject(Notifier emfObject) {
		for (Adapter adapter : emfObject.eAdapters()) {
			if (adapter instanceof ChunkedResourceDescriptionsAdapter)
				return ((ChunkedResourceDescriptionsAdapter) adapter).get();
		}
		return null;
	}

	public static ChunkedResourceDescriptions removeFromEmfObject(Notifier emfObject) {
		List<Adapter> adapters = emfObject.eAdapters();
		for (int i = 0; i < adapters.size(); i++) {
			Adapter adapter = adapters.get(i);
			if (adapter instanceof ChunkedResourceDescriptionsAdapter)
				return ((ChunkedResourceDescriptionsAdapter) emfObject.eAdapters().remove(i)).get();
		}
		return null;
	}

	public void attachToEmfObject(Notifier emfObject) {
		ChunkedResourceDescriptions result = findInEmfObject(emfObject);
		if (result != null)
			throw new IllegalStateException(
					"The given EMF object already contains an adapter for ChunkedResourceDescriptions");
		ChunkedResourceDescriptionsAdapter adapter = new ChunkedResourceDescriptionsAdapter(this);
		emfObject.eAdapters().add(adapter);
	}

	public static class ChunkedResourceDescriptionsAdapter extends AdapterImpl {
		private ChunkedResourceDescriptions element;

		public ChunkedResourceDescriptionsAdapter(ChunkedResourceDescriptions element) {
			this.element = element;
		}

		public ChunkedResourceDescriptions get() {
			return element;
		}

		@Override
		public boolean isAdapterForType(Object object) {
			return object == ChunkedResourceDescriptions.class;
		}
	}
}

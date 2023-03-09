/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OriginalElement {
	public static class OriginalElementAdapter extends AdapterImpl {
		private OriginalElement element;

		public OriginalElementAdapter(OriginalElement element) {
			this.element = element;
		}

		public OriginalElement get() {
			return element;
		}

		@Override
		public boolean isAdapterForType(Object object) {
			return object == OriginalElement.class;
		}
	}

	private final AbstractElement original;

	public static OriginalElement findInEmfObject(Notifier emfObject) {
		for (Adapter adapter : emfObject.eAdapters()) {
			if (adapter instanceof OriginalElement.OriginalElementAdapter) {
				return ((OriginalElement.OriginalElementAdapter) adapter).get();
			}
		}
		return null;
	}

	public static OriginalElement removeFromEmfObject(Notifier emfObject) {
		List<Adapter> adapters = emfObject.eAdapters();
		for (int i = 0, max = adapters.size(); i < max; i++) {
			Adapter adapter = adapters.get(i);
			if (adapter instanceof OriginalElement.OriginalElementAdapter) {
				emfObject.eAdapters().remove(i);
				return ((OriginalElement.OriginalElementAdapter) adapter).get();
			}
		}
		return null;
	}

	public void attachToEmfObject(Notifier emfObject) {
		OriginalElement result = findInEmfObject(emfObject);
		if (result != null)
			throw new IllegalStateException("The given EMF object already contains an adapter for OriginalElement");
		OriginalElement.OriginalElementAdapter adapter = new OriginalElement.OriginalElementAdapter(this);
		emfObject.eAdapters().add(adapter);
	}

	public OriginalElement(AbstractElement original) {
		this.original = original;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((original == null) ? 0 : original.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OriginalElement other = (OriginalElement) obj;
		if (original == null) {
			if (other.original != null)
				return false;
		} else if (!original.equals(other.original))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("original", original);
		return b.toString();
	}

	public AbstractElement getOriginal() {
		return original;
	}
}

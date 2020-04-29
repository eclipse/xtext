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
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OriginalGrammar {
	public static class OriginalGrammarAdapter extends AdapterImpl {
		private OriginalGrammar element;

		public OriginalGrammarAdapter(OriginalGrammar element) {
			this.element = element;
		}

		public OriginalGrammar get() {
			return element;
		}

		@Override
		public boolean isAdapterForType(Object object) {
			return object == OriginalGrammar.class;
		}
	}

	private final Grammar original;

	public static OriginalGrammar findInEmfObject(Notifier emfObject) {
		for (Adapter adapter : emfObject.eAdapters()) {
			if (adapter instanceof OriginalGrammar.OriginalGrammarAdapter) {
				return ((OriginalGrammar.OriginalGrammarAdapter) adapter).get();
			}
		}
		return null;
	}

	public static OriginalGrammar removeFromEmfObject(Notifier emfObject) {
		List<Adapter> adapters = emfObject.eAdapters();
		for (int i = 0, max = adapters.size(); i < max; i++) {
			Adapter adapter = adapters.get(i);
			if (adapter instanceof OriginalGrammar.OriginalGrammarAdapter) {
				emfObject.eAdapters().remove(i);
				return ((OriginalGrammar.OriginalGrammarAdapter) adapter).get();
			}
		}
		return null;
	}

	public void attachToEmfObject(Notifier emfObject) {
		OriginalGrammar result = findInEmfObject(emfObject);
		if (result != null)
			throw new IllegalStateException("The given EMF object already contains an adapter for OriginalGrammar");
		OriginalGrammar.OriginalGrammarAdapter adapter = new OriginalGrammar.OriginalGrammarAdapter(this);
		emfObject.eAdapters().add(adapter);
	}

	public OriginalGrammar(Grammar original) {
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
		OriginalGrammar other = (OriginalGrammar) obj;
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

	public Grammar getOriginal() {
		return original;
	}
}

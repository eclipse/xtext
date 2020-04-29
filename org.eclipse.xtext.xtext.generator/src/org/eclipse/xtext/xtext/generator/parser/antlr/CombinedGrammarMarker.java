/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

public class CombinedGrammarMarker {
	public static class CombinedGrammarMarkerAdapter extends AdapterImpl {
		private CombinedGrammarMarker element;

		public CombinedGrammarMarkerAdapter(CombinedGrammarMarker element) {
			this.element = element;
		}

		public CombinedGrammarMarker get() {
			return element;
		}

		@Override
		public boolean isAdapterForType(Object object) {
			return object == CombinedGrammarMarker.class;
		}
	}

	private boolean isCombinedGrammar;

	public static CombinedGrammarMarker findInEmfObject(Notifier emfObject) {
		for (Adapter adapter : emfObject.eAdapters()) {
			if (adapter instanceof CombinedGrammarMarker.CombinedGrammarMarkerAdapter) {
				return ((CombinedGrammarMarker.CombinedGrammarMarkerAdapter) adapter).get();
			}
		}
		return null;
	}

	public static CombinedGrammarMarker removeFromEmfObject(Notifier emfObject) {
		List<Adapter> adapters = emfObject.eAdapters();
		for (int i = 0, max = adapters.size(); i < max; i++) {
			Adapter adapter = adapters.get(i);
			if (adapter instanceof CombinedGrammarMarker.CombinedGrammarMarkerAdapter) {
				emfObject.eAdapters().remove(i);
				return ((CombinedGrammarMarker.CombinedGrammarMarkerAdapter) adapter).get();
			}
		}
		return null;
	}

	public void attachToEmfObject(Notifier emfObject) {
		CombinedGrammarMarker result = findInEmfObject(emfObject);
		if (result != null)
			throw new IllegalStateException(
					"The given EMF object already contains an adapter for CombinedGrammarMarker");
		CombinedGrammarMarker.CombinedGrammarMarkerAdapter adapter = new CombinedGrammarMarker.CombinedGrammarMarkerAdapter(
				this);
		emfObject.eAdapters().add(adapter);
	}

	public CombinedGrammarMarker(boolean isCombinedGrammar) {
		this.isCombinedGrammar = isCombinedGrammar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isCombinedGrammar ? 1231 : 1237);
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
		CombinedGrammarMarker other = (CombinedGrammarMarker) obj;
		if (isCombinedGrammar != other.isCombinedGrammar)
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("isCombinedGrammar", isCombinedGrammar);
		return b.toString();
	}

	public boolean isCombinedGrammar() {
		return isCombinedGrammar;
	}
}

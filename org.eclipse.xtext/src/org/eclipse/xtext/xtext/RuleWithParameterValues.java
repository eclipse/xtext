/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RuleWithParameterValues {
	public static class RuleWithParameterValuesAdapter extends AdapterImpl {
		private RuleWithParameterValues element;

		public RuleWithParameterValuesAdapter(RuleWithParameterValues element) {
			this.element = element;
		}

		public RuleWithParameterValues get() {
			return element;
		}

		@Override
		public boolean isAdapterForType(Object object) {
			return object == RuleWithParameterValues.class;
		}
	}

	private final AbstractRule original;

	private final Set<Parameter> paramValues;

	public RuleWithParameterValues(AbstractRule original, Set<Parameter> paramValues) {
		this.original = original;
		this.paramValues = paramValues;
	}

	RuleWithParameterValues(AbstractRule original) {
		this(original, Collections.emptySet());
	}

	public static AbstractRule getOriginalRule(AbstractRule copy) {
		return RuleWithParameterValues.findInEmfObject(copy).getOriginal();
	}

	public static AbstractRule tryGetOriginalRule(AbstractRule copy) {
		RuleWithParameterValues adapter = RuleWithParameterValues.findInEmfObject(copy);
		AbstractRule rule = null;
		if (adapter != null) {
			rule = adapter.getOriginal();
		}
		return rule;
	}

	public static Set<Parameter> getParamValues(AbstractRule copy) {
		return RuleWithParameterValues.findInEmfObject(copy).getParamValues();
	}

	public static int getParamConfig(AbstractRule copy) {
		RuleWithParameterValues values = RuleWithParameterValues.findInEmfObject(copy);
		return ParameterConfigHelper.getParameterConfig(values.paramValues, (ParserRule) values.original);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((original == null) ? 0 : original.hashCode());
		result = prime * result + ((paramValues == null) ? 0 : paramValues.hashCode());
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
		RuleWithParameterValues other = (RuleWithParameterValues) obj;
		if (original == null) {
			if (other.original != null)
				return false;
		} else if (!original.equals(other.original))
			return false;
		if (paramValues == null) {
			if (other.paramValues != null)
				return false;
		} else if (!paramValues.equals(other.paramValues))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("original", original);
		b.add("paramValues", paramValues);
		return b.toString();
	}

	public AbstractRule getOriginal() {
		return original;
	}

	public Set<Parameter> getParamValues() {
		return paramValues;
	}

	public static RuleWithParameterValues findInEmfObject(Notifier emfObject) {
		for (Adapter adapter : emfObject.eAdapters()) {
			if (adapter instanceof RuleWithParameterValues.RuleWithParameterValuesAdapter) {
				return ((RuleWithParameterValues.RuleWithParameterValuesAdapter) adapter).get();
			}
		}
		return null;
	}

	public static RuleWithParameterValues removeFromEmfObject(Notifier emfObject) {
		List<Adapter> adapters = emfObject.eAdapters();
		for (int i = 0, max = adapters.size(); i < max; i++) {
			Adapter adapter = adapters.get(i);
			if (adapter instanceof RuleWithParameterValues.RuleWithParameterValuesAdapter) {
				emfObject.eAdapters().remove(i);
				return ((RuleWithParameterValues.RuleWithParameterValuesAdapter) adapter).get();
			}
		}
		return null;
	}

	public void attachToEmfObject(Notifier emfObject) {
		RuleWithParameterValues result = findInEmfObject(emfObject);
		if (result != null)
			throw new IllegalStateException(
					"The given EMF object already contains an adapter for RuleWithParameterValues");
		RuleWithParameterValues.RuleWithParameterValuesAdapter adapter = new RuleWithParameterValues.RuleWithParameterValuesAdapter(
				this);
		emfObject.eAdapters().add(adapter);
	}
}

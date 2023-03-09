/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.interpreter;

import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.impl.ClassFinder;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

public class Context {
	private final JvmTypeReference expectedType;

	private final ClassFinder classFinder;

	private final Map<String, JvmIdentifiableElement> visibleFeatures;

	private final Set<XExpression> alreadyEvaluating;

	public Context cloneWithExpectation(JvmTypeReference newExpectation) {
		return new Context(newExpectation, classFinder, visibleFeatures, alreadyEvaluating);
	}

	public Context(JvmTypeReference expectedType, ClassFinder classFinder,
			Map<String, JvmIdentifiableElement> visibleFeatures, Set<XExpression> alreadyEvaluating) {
		this.expectedType = expectedType;
		this.classFinder = classFinder;
		this.visibleFeatures = visibleFeatures;
		this.alreadyEvaluating = alreadyEvaluating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alreadyEvaluating == null) ? 0 : alreadyEvaluating.hashCode());
		result = prime * result + ((classFinder == null) ? 0 : classFinder.hashCode());
		result = prime * result + ((expectedType == null) ? 0 : expectedType.hashCode());
		result = prime * result + ((visibleFeatures == null) ? 0 : visibleFeatures.hashCode());
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
		Context other = (Context) obj;
		if (alreadyEvaluating == null) {
			if (other.alreadyEvaluating != null)
				return false;
		} else if (!alreadyEvaluating.equals(other.alreadyEvaluating))
			return false;
		if (classFinder == null) {
			if (other.classFinder != null)
				return false;
		} else if (!classFinder.equals(other.classFinder))
			return false;
		if (expectedType == null) {
			if (other.expectedType != null)
				return false;
		} else if (!expectedType.equals(other.expectedType))
			return false;
		if (visibleFeatures == null) {
			if (other.visibleFeatures != null)
				return false;
		} else if (!visibleFeatures.equals(other.visibleFeatures))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("expectedType", expectedType);
		b.add("classFinder", classFinder);
		b.add("visibleFeatures", visibleFeatures);
		b.add("alreadyEvaluating", alreadyEvaluating);
		return b.toString();
	}

	public JvmTypeReference getExpectedType() {
		return expectedType;
	}

	public ClassFinder getClassFinder() {
		return classFinder;
	}

	public Map<String, JvmIdentifiableElement> getVisibleFeatures() {
		return visibleFeatures;
	}

	public Set<XExpression> getAlreadyEvaluating() {
		return alreadyEvaluating;
	}
}

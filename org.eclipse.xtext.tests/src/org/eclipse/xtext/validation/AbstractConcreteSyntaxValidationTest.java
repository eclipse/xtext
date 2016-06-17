/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.HashMap;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.validation.AssertableDiagnostics.DiagnosticPredicate;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator.DiagnosticChainAcceptor;
import org.eclipse.xtext.validation.impl.ConcreteSyntaxDiagnosticProvider.ConcreteSyntaxFeatureDiagnostic;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractConcreteSyntaxValidationTest extends AbstractXtextTests {

	protected static class DiagPred implements DiagnosticPredicate {

		private EStructuralFeature feat;
		private Integer min;
		private Integer max;
		private int code;
		private String constraint;

		public DiagPred(EStructuralFeature feat, int code, Integer min, Integer max, String constraint) {
			super();
			this.feat = feat;
			this.min = min;
			this.max = max;
			this.code = code;
			this.constraint = constraint;
		}

		@Override
		public String toString() {
			String f = feat == null ? "null" : feat.getEContainingClass().getName() + "." + feat.getName();
			return "DiagPred [feat= " + f + " code=" + code + ", min=" + min + ", max=" + max + ", constraint="
					+ constraint + "]";
		}

		@Override
		public boolean apply(Diagnostic input) {
			if (input instanceof ConcreteSyntaxFeatureDiagnostic) {
				ConcreteSyntaxFeatureDiagnostic s = (ConcreteSyntaxFeatureDiagnostic) input;
				if (min != null && min != s.getMin())
					return false;
				if (max != null && max != s.getMax())
					return false;
				if (constraint != null && !constraint.equals(s.getConstraint()))
					return false;
				return s.getFeature() == feat && s.getCode() == code;
			}
			return false;
		}
	}

	protected DiagnosticPredicate err(EStructuralFeature feat, int code, Integer min, Integer max, String constraint) {
		return new DiagPred(feat, code, min, max, constraint);
	}

	protected AssertableDiagnostics validate(EObject obj) {
		final BasicDiagnostic dc = new BasicDiagnostic();
		getValidator().validateRecursive(obj, new DiagnosticChainAcceptor(dc), new HashMap<Object, Object>());
		return new AssertableDiagnostics(dc);
	}

	protected abstract IConcreteSyntaxValidator getValidator();

}

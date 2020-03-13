/**
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator;

import static org.eclipse.xtext.xbase.lib.IterableExtensions.*;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@Beta
@ImplementedBy(IShouldGenerate.OnlyWithoutErrors.class)
public interface IShouldGenerate {
	@Beta
	@Singleton
	class OnlyWithoutErrors implements IShouldGenerate {
		@Inject
		private IResourceValidator resourceValidator;

		@Override
		public boolean shouldGenerate(Resource resource, CancelIndicator cancelIndicator) {
			if (!resource.getErrors().isEmpty()) {
				return false;
			}
			List<Issue> issues = resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, cancelIndicator);
			return !exists(issues, (Issue issue) -> Objects.equal(issue.getSeverity(), Severity.ERROR));
		}
	}

	@Beta
	@Singleton
	class Always implements IShouldGenerate {
		@Override
		public boolean shouldGenerate(Resource resource, CancelIndicator cancelIndicator) {
			return true;
		}
	}

	/**
	 * Whether code should be generated for this resource.
	 */
	boolean shouldGenerate(Resource resource, CancelIndicator cancelIndicator);
}

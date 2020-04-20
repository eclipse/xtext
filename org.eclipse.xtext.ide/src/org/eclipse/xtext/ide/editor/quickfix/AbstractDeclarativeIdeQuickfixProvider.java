package org.eclipse.xtext.ide.editor.quickfix;

/*******************************************************************************
 * Copyright (c) 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2.Options;

import com.google.common.annotations.Beta;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Heinrich Weichert
 * 
 * @since 2.24
 */
@Beta
public class AbstractDeclarativeIdeQuickfixProvider implements IQuickFixProvider {

	private static final Logger LOG = Logger.getLogger(AbstractDeclarativeIdeQuickfixProvider.class);

	@Inject
	private Provider<DiagnosticResolutionAcceptor> issueResolutionAcceptorProvider;

	private boolean getFixMethodPredicate(Method input, String issueCode) {
		for (QuickFix annotation : input.getAnnotationsByType(QuickFix.class)) {
			boolean result = annotation != null && Objects.equals(issueCode,annotation.value())
					&& input.getParameterTypes().length == 1 && Void.TYPE == input.getReturnType()
					&& input.getParameterTypes()[0].isAssignableFrom(DiagnosticResolutionAcceptor.class);
			if (result) {
				return true;
			}
		}
		return false;
	}

	private List<DiagnosticResolution> getResolutions(Options options, Iterable<Method> fixMethods) {
		DiagnosticResolutionAcceptor issueResolutionAcceptor = issueResolutionAcceptorProvider.get();
		for (Method fixMethod : fixMethods) {
			try {
				// will throw if this is not a public method, but it should be
				fixMethod.invoke(this, issueResolutionAcceptor);
			} catch (Exception e) {
				LOG.error("Error executing fix method", e);
			}
		}
		return issueResolutionAcceptor.getDiagnosticResolutions(options);
	}

	private Iterable<Method> collectMethods(Class<? extends AbstractDeclarativeIdeQuickfixProvider> clazz,
			String issueCode) {
		return Arrays.stream(clazz.getMethods()).filter(method -> getFixMethodPredicate(method, issueCode))
				.collect(Collectors.toList());
	}

	private Iterable<Method> getFixMethods(Diagnostic issue) {
		if (Strings.isNullOrEmpty(issue.getCode().getLeft())) {
			return Collections.emptyList();
		}
		return collectMethods(getClass(), issue.getCode().getLeft());
	}

	@Override
	public List<DiagnosticResolution> getResolutions(Options options, Diagnostic issue) {
		if (issue == null || issue.getCode() == null || issue.getMessage() == null || issue.getSeverity() == null) {
			return Collections.emptyList();
		}
		return getResolutions(options, getFixMethods(issue));
	}

}

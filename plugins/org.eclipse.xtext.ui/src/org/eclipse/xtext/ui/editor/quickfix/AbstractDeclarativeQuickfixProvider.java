/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Knut Wannheden - Initial contribution and API
 * @author Heiko Behrens
 * @author Jan Koehnlein
 */
public class AbstractDeclarativeQuickfixProvider implements IssueResolutionProvider {

	private static final Logger LOG = Logger.getLogger(AbstractDeclarativeQuickfixProvider.class);

	@Inject
	private Provider<IssueResolutionAcceptor> issueResolutionAcceptorProvider;

	protected Predicate<Method> getFixMethodPredicate(final String issueCode) {
		return new Predicate<Method>() {
			public boolean apply(Method input) {
				Fix annotation = input.getAnnotation(Fix.class);
				boolean result = annotation != null && issueCode.equals(annotation.value())
						&& input.getParameterTypes().length == 2 && Void.TYPE == input.getReturnType()
						&& input.getParameterTypes()[0].isAssignableFrom(Issue.class)
						&& input.getParameterTypes()[1].isAssignableFrom(IssueResolutionAcceptor.class);
				return result;
			}
		};
	}

	protected List<IssueResolution> getResolutions(Issue issue, List<Method> fixMethods) {
		IssueResolutionAcceptor issueResolutionAcceptor = issueResolutionAcceptorProvider.get();
		for (Method fixMethod : fixMethods) {
			try {
				fixMethod.setAccessible(true);
				fixMethod.invoke(this, issue, issueResolutionAcceptor);
			} catch (Exception e) {
				LOG.error("Error executing fix method", e);
			}
		}
		return issueResolutionAcceptor.getIssueResolutions();
	}

	protected Iterable<Method> collectMethods(Class<? extends AbstractDeclarativeQuickfixProvider> clazz,
			String issueCode) {
		List<Method> methods = Lists.newArrayList(clazz.getMethods());
		return Iterables.filter(methods, getFixMethodPredicate(issueCode));
	}

	protected List<Method> getFixMethods(final Issue issue) {
		return Lists.newArrayList(collectMethods(getClass(), issue.getCode()));
	}

	public boolean hasResolutionFor(final String issueCode) {
		if (issueCode == null)
			return false;
		// TODO : cache this if it's a performance hit
		Iterable<Method> methods = collectMethods(getClass(), issueCode);
		return methods.iterator().hasNext();
	}

	public List<IssueResolution> getResolutions(final Issue issue) {
		List<Method> fixMethods = getFixMethods(issue);
		return getResolutions(issue, fixMethods);
	}

	protected Provider<IssueResolutionAcceptor> getIssueResolutionAcceptorProvider() {
		return issueResolutionAcceptorProvider;
	}

	/**
	 * for testing without guice
	 */
	public void setIssueResolutionAcceptorProvider(Provider<IssueResolutionAcceptor> issueResolutionAcceptorProvider) {
		this.issueResolutionAcceptorProvider = issueResolutionAcceptorProvider;
	}
}

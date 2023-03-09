/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider.Registry;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Validator {

	private boolean validateAll = true;

	public void setValidateAll(boolean validateAll) {
		this.validateAll = validateAll;
	}

	private boolean stopOnError = true;

	public void setStopOnError(boolean stopOnError) {
		this.stopOnError = stopOnError;
	}

	public boolean isStopOnError() {
		return stopOnError;
	}

	public boolean isValidateAll() {
		return validateAll;
	}

	public void validate(ResourceSet resourceSet, IResourceServiceProvider.Registry registry, Issues issues) {
		List<Resource> resources = Lists.newArrayList(resourceSet.getResources());
		for (Resource resource : resources) {
			try {
				resource.load(null);
				IResourceServiceProvider provider = registry.getResourceServiceProvider(resource.getURI());
				if (provider != null) {
					List<Issue> result = provider.getResourceValidator().validate(resource, CheckMode.ALL, null);
					for (Issue issue : result) {
						switch (issue.getSeverity()) {
							case ERROR:
								issues.addError(issue.getMessage(), issue);
								break;
							case WARNING:
								issues.addWarning(issue.getMessage(), issue);
								break;
							case INFO:
								issues.addInfo(issue.getMessage(), issue);
								break;
							case IGNORE:
								break;
						}
					}
				}
			} catch (IOException e) {
				throw new WorkflowInterruptedException("Couldn't load resource (" + resource.getURI() + ")", e);
			}
		}
		if (isStopOnError() && issues.hasErrors()) {
			String errorMessage = toString(issues);
			throw new WorkflowInterruptedException("Validation problems: \n" + errorMessage);
		}
	}

	public String toString(Issues issues) {
		if (!issues.hasErrors() && !issues.hasWarnings())
			return "No issues.";
		StringBuilder result = new StringBuilder();
		if (issues.hasErrors()) {
			MWEDiagnostic[] errors = issues.getErrors();
			if (errors.length == 1) {
				result.append("1 error:\n");
			} else {
				result.append(errors.length).append(" errors:\n");
			}
			appendMessages(result, errors);
		}
		if (issues.hasWarnings()) {
			MWEDiagnostic[] warnings = issues.getWarnings();
			if (issues.hasErrors())
				result.append('\n');
			if (warnings.length == 1) {
				result.append("1 warning:\n");
			} else {
				result.append(warnings.length).append(" warnings:\n");
			}
			appendMessages(result, warnings);
		}
		return result.toString();
	}

	protected void appendMessages(StringBuilder result, MWEDiagnostic[] diagnostics) {
		Multimap<URI, MWEDiagnostic> issuesPerURI = groupByURI(diagnostics);
		boolean first = true;
		for (URI uri : issuesPerURI.keySet()) {
			if (!first)
				result.append('\n');
			first = false;
			if (uri != null) {
				result.append('\t').append(uri.lastSegment()).append(" - ");
				if (uri.isFile())
					result.append(uri.toFileString());
				else
					result.append(uri);
			}
			for (MWEDiagnostic diagnostic : issuesPerURI.get(uri)) {
				Issue issue = (Issue) diagnostic.getElement();
				result.append("\n\t\t").append(issue.getLineNumber()).append(": ").append(diagnostic.getMessage());
			}
		}
	}

	protected Multimap<URI, MWEDiagnostic> groupByURI(MWEDiagnostic[] diagnostic) {
		Multimap<URI, MWEDiagnostic> result = Multimaps.newMultimap(
				Maps.<URI, Collection<MWEDiagnostic>> newLinkedHashMap(), new Supplier<Collection<MWEDiagnostic>>() {
					@Override
					public Collection<MWEDiagnostic> get() {
						return Sets.newTreeSet(getDiagnosticComparator());
					}
				});
		result.putAll(Multimaps.index(Arrays.asList(diagnostic), new Function<MWEDiagnostic, URI>() {
			@Override
			public URI apply(MWEDiagnostic from) {
				Issue issue = (Issue) from.getElement();
				URI uriToProblem = issue.getUriToProblem();
				return uriToProblem != null ? uriToProblem.trimFragment() : NullURI;
			}
		}));
		return result;
	}
	
	private final static URI NullURI = URI.createURI("no/uri");

	public static class Disabled extends Validator {
		@Override
		public void validate(ResourceSet resourceSet, Registry registry, Issues issues) {
			// do nothing
		}
	}

	protected Comparator<MWEDiagnostic> getDiagnosticComparator() {
		return new MWEDiagnosticComparator();
	}

	public static class MWEDiagnosticComparator implements Comparator<MWEDiagnostic> {
		@Override
		public int compare(MWEDiagnostic o1, MWEDiagnostic o2) {
			Issue issue1 = (Issue) o1.getElement();
			Issue issue2 = (Issue) o2.getElement();
			int lineNumberCompare = nullSafeCompare(issue1.getLineNumber(), issue2.getLineNumber());
			if (lineNumberCompare != 0) {
				return lineNumberCompare;
			}
			int columnCompare = nullSafeCompare(issue1.getColumn(), issue2.getColumn());
			if (columnCompare != 0) {
				return columnCompare;
			}
			int offsetCompare = nullSafeCompare(issue1.getOffset(), issue2.getOffset());
			if (offsetCompare != 0) {
				return offsetCompare;
			}
			return Strings.notNull(o1.getMessage()).compareTo(Strings.notNull(o2.getMessage()));
		}

		protected int nullSafeCompare(Integer x, Integer y) {
			return notNull(x).compareTo(notNull(y));
		}

		protected Integer notNull(Integer x) {
			return x != null ? x : Integer.valueOf(-1);
		}
	}

}

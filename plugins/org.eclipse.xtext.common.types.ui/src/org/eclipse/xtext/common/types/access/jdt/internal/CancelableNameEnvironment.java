/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.internal.codeassist.ISearchRequestor;
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jdt.internal.core.SearchableEnvironment;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public class CancelableNameEnvironment extends SearchableEnvironment {
	private final CancelIndicator monitor;

	public CancelableNameEnvironment(JavaProject project, WorkingCopyOwner owner, ICompilationUnit[] workingCopies, CancelIndicator monitor) throws JavaModelException {
		super(project, workingCopies);
		this.monitor = monitor == null ? CancelIndicator.NullImpl : monitor;
		this.owner = owner;
	}

	private void checkCanceled() {
		if (monitor.isCanceled()) {
			throw new AbortCompilation(true/*silent*/, new OperationCanceledException());
		}
	}

	@Override
	public void findPackages(char[] prefix, ISearchRequestor requestor) {
		checkCanceled();
		super.findPackages(prefix, requestor);
	}

	@Override
	public NameEnvironmentAnswer findType(char[] name, char[][] packageName) {
		checkCanceled();
		return super.findType(name, packageName);
	}

	@Override
	public NameEnvironmentAnswer findType(char[][] compoundTypeName) {
		checkCanceled();
		return super.findType(compoundTypeName);
	}

	@Override
	public void findTypes(char[] prefix, boolean findMembers, boolean camelCaseMatch, int searchFor, ISearchRequestor storage, IProgressMonitor progressMonitor) {
		checkCanceled();
		super.findTypes(prefix, findMembers, camelCaseMatch, searchFor, storage, progressMonitor);
	}
	
}

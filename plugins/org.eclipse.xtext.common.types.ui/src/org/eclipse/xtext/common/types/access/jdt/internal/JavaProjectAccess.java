/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt.internal;

import java.util.Map;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jdt.internal.core.NameLookup;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public class JavaProjectAccess {
	
	private final JavaProject javaProject;
	private final WorkingCopies workingCopies;
	private final Map<IJavaProject, JavaProjectAccess> pool;
	
	protected CancelableNameEnvironment nameEnvironment;

	public JavaProjectAccess(JavaProject javaProject, WorkingCopies workingCopies) {
		this(javaProject, workingCopies, Maps.<IJavaProject, JavaProjectAccess>newHashMap());
	}
	
	JavaProjectAccess(JavaProject javaProject, WorkingCopies workingCopies, Map<IJavaProject, JavaProjectAccess> pool) {
		this.javaProject = javaProject;
		this.workingCopies = workingCopies;
		this.pool = pool;
		pool.put(javaProject, this);
	}
	
	public IType findType(String packageName, String typeName) throws JavaModelException {
		NameLookup lookup = getNameLookup();
		NameLookup.Answer answer = lookup.findType(
				typeName,
				packageName,
				false,
				NameLookup.ACCEPT_ALL,
				true, // secondary types
				true, // wait for indexes (in case we need to consider secondary types)
				false /*don't check restrictions*/,
				null);
		return answer == null ? null : answer.type;
	}
	
	protected CancelableNameEnvironment getNameEnvironment() throws JavaModelException {
		if (nameEnvironment == null) {
			createNameEnvironment();
		}
		return nameEnvironment;
	}
	
	protected NameLookup getNameLookup() throws JavaModelException {
		return getNameEnvironment().nameLookup;
	}

	protected void createNameEnvironment() throws JavaModelException {
		nameEnvironment = new CancelableNameEnvironment(javaProject, workingCopies.getOwner(), workingCopies.getWorkingCopies(), CancelIndicator.NullImpl);
		nameEnvironment.nameLookup = CustomNameLookup.create(nameEnvironment.nameLookup);
	}
	
	public WorkingCopyOwner getWorkingCopyOwner() {
		return workingCopies.getOwner();
	}
	
	public JavaProject getJavaProject() {
		return javaProject;
	}
	
	public JavaProjectAccess access(IJavaProject project) {
		JavaProjectAccess result = pool.get(project);
		if (result != null) {
			return result;
		}
		return createAccess((JavaProject) project, workingCopies, pool);
	}

	protected JavaProjectAccess createAccess(JavaProject project, WorkingCopies workingCopies, Map<IJavaProject, JavaProjectAccess> pool) {
		return new JavaProjectAccess(project, workingCopies, pool);
	}

	public IPackageFragmentRoot[] getPackageFragmentRoots() throws JavaModelException {
		return javaProject.getPackageFragmentRoots();
	}
	
}

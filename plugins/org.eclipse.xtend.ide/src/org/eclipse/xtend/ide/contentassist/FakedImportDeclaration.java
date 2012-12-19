/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IOpenable;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.JavaModelException;

/**
 * @author schill - Initial contribution and API
 */
final class FakedImportDeclaration implements IImportDeclaration {
	private final String importString;

	FakedImportDeclaration(String importString) {
		this.importString = importString;
	}

	public void rename(String name, boolean replace, IProgressMonitor monitor)
			throws JavaModelException {}

	public void move(IJavaElement container, IJavaElement sibling, String rename,
			boolean replace, IProgressMonitor monitor) throws JavaModelException {}

	public void delete(boolean force, IProgressMonitor monitor) throws JavaModelException {}

	public void copy(IJavaElement container, IJavaElement sibling, String rename,
			boolean replace, IProgressMonitor monitor) throws JavaModelException {}

	public ISourceRange getSourceRange() throws JavaModelException {

		return null;
	}

	public String getSource() throws JavaModelException {
		return null;
	}

	public ISourceRange getNameRange() throws JavaModelException {
		return null;
	}

	public Object getAdapter(Class adapter) {
		return null;
	}

	public boolean isStructureKnown() throws JavaModelException {
		return false;
	}

	public boolean isReadOnly() {
		return false;
	}

	public IResource getUnderlyingResource() throws JavaModelException {
		return null;
	}

	public ISchedulingRule getSchedulingRule() {
		return null;
	}

	public IResource getResource() {
		return null;
	}

	public IJavaElement getPrimaryElement() {
		return null;
	}

	public IPath getPath() {
		return null;
	}

	public IJavaElement getParent() {
		return null;
	}

	public IOpenable getOpenable() {
		return null;
	}

	public IJavaProject getJavaProject() {
		return null;
	}

	public IJavaModel getJavaModel() {
		return null;
	}

	public String getHandleIdentifier() {
		return null;
	}

	public int getElementType() {
		return 0;
	}

	public IResource getCorrespondingResource() throws JavaModelException {
		return null;
	}

	public String getAttachedJavadoc(IProgressMonitor monitor) throws JavaModelException {
		return null;
	}

	public IJavaElement getAncestor(int ancestorType) {
		return null;
	}

	public boolean exists() {
		return false;
	}

	public boolean isOnDemand() {
		return false;
	}

	public int getFlags() throws JavaModelException {
		return 0;
	}

	public String getElementName() {
		return importString;
	}
}
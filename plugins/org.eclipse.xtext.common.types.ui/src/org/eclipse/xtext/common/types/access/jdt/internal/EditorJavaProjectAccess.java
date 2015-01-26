/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt.internal;

import java.util.Map;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.JavaProject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EditorJavaProjectAccess extends JavaProjectAccess implements IElementChangedListener {

	public EditorJavaProjectAccess(JavaProject javaProject, EditorWorkingCopies workingCopies) {
		super(javaProject, workingCopies);
	}
	
	public EditorJavaProjectAccess(JavaProject javaProject, EditorWorkingCopies workingCopies, Map<IJavaProject, JavaProjectAccess> pool) {
		super(javaProject, workingCopies, pool);
	}

	@Override
	protected void createNameEnvironment() throws JavaModelException {
		JavaCore.addElementChangedListener(this);
		super.createNameEnvironment();
	}

	@Override
	public void elementChanged(ElementChangedEvent event) {
		if ((event.getDelta().getFlags() & IJavaElementDelta.F_PRIMARY_WORKING_COPY) != 0) {
			JavaCore.removeElementChangedListener(this);
			nameEnvironment = null;
		}
	}
	
	@Override
	protected JavaProjectAccess createAccess(JavaProject project, WorkingCopies workingCopies,
			Map<IJavaProject, JavaProjectAccess> pool) {
		return new EditorJavaProjectAccess(project, (EditorWorkingCopies) workingCopies, pool);
	}
	
}

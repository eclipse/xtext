/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt.internal;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.WorkingCopyOwner;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class WorkingCopies {

	private WorkingCopyOwner owner;

	protected WorkingCopies(WorkingCopyOwner owner) {
		this.owner = owner;
	}
	
	public WorkingCopyOwner getOwner() {
		return this.owner;
	}
	
	public abstract ICompilationUnit[] getWorkingCopies();
	
}

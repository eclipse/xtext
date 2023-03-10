/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.workspace;

import org.eclipse.core.internal.resources.WorkManager;
import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
@Singleton
public class WorkspaceLockAccess {

	public enum Result {
		YES, NO, SHUTDOWN
	}

	public Result isWorkspaceLockedByCurrentThread(IWorkspace workspace) {
		try {
			WorkManager workManager = ((Workspace) workspace).getWorkManager();
			if (workManager.isLockAlreadyAcquired()) {
				return Result.YES;
			}
			return Result.NO;
		} catch (CoreException e) { // may be thrown during shutdown when the workmanager is no longer available
			return Result.SHUTDOWN;
		}
	}

}

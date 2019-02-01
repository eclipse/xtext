/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;

import com.google.common.annotations.Beta;

/**
 * Utility to discard builder state for a given set of projects.
 * 
 * It'll access the {@link XtextBuilder} assigned to the given projects and invoke
 * {@link IncrementalProjectBuilder#forgetLastBuiltState()}.
 * 
 * Clients are usually not expected to call this manually.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.17
 */
@Beta
public class BuilderStateDiscarder {

	/**
	 * Returns true, if the given builderArguments indicate that we should discard the built state
	 * for the given projects.
	 */
	public boolean forgetLastBuildState(Iterable<IProject> toUpdate, Map<String, String> builderArguments) {
		if (canHandleBuildFlag(builderArguments)) {
			for (IProject project : toUpdate) {
				XtextBuilder builder = BuildManagerAccess.findBuilder(project);
				if (builder != null) {
					builder.forgetLastBuiltState();
				}
			}
			return true;
		}
		return false;
	}

	protected boolean canHandleBuildFlag(Map<String, String> builderArguments) {
		return IBuildFlag.FORGET_BUILD_STATE_ONLY.isSet(builderArguments)
				|| IBuildFlag.RECOVERY_BUILD.isSet(builderArguments);
	}

}

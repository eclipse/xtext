/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Map;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("rawtypes")
public interface IBuildFlag {

	/**
	 * Indicating a full build triggered when the builder state could not be loaded. 
	 * Resources that have been built between the scheduling of this build and its 
	 * execution will not be built again. 
	 */
	static final IBuildFlag RECOVERY_BUILD = new Impl("RecoveryBuild");
	/**
	 * Indicates that the builder should not actually build anything, but just discard its state.
	 * This means that the next build will be a full build, even if only an incremental build is
	 * requested.
	 */
	static final IBuildFlag FORGET_BUILD_STATE_ONLY = new Impl("ForgetBuildState");

	void addToMap(Map buildArgs);

	boolean isSet(Map buildArgs);

	static class Impl implements IBuildFlag {
		private final String key;

		Impl(String key) {
			this.key = key;
		}

		@Override
		@SuppressWarnings("unchecked")
		public void addToMap(Map buildArgs) {
			buildArgs.put(key, Boolean.TRUE);
		}

		@Override
		public boolean isSet(Map buildArgs) {
			return buildArgs != null && buildArgs.containsKey(key);
		}

	}

}

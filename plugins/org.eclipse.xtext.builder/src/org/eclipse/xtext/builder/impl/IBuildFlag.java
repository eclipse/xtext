/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Map;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("rawtypes")
public interface IBuildFlag {

	/**
	 * Indicating a full build triggered when the builder state could not be loaded. 
	 * Resources that have been built between the scheduling of this build and its 
	 * execution will not be built again. 
	 */
	static final IBuildFlag RECOVERY_BUILD = new Impl("RecoveryBuild");

	void addToMap(Map buildArgs);

	boolean isSet(Map buildArgs);

	static class Impl implements IBuildFlag {
		private final String key;

		Impl(String key) {
			this.key = key;
		}

		@SuppressWarnings("unchecked")
		public void addToMap(Map buildArgs) {
			buildArgs.put(key, Boolean.TRUE);
		}

		public boolean isSet(Map buildArgs) {
			return buildArgs != null && buildArgs.containsKey(key);
		}

	}

}

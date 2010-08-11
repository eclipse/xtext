/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import org.apache.log4j.Logger;
import org.eclipse.xtext.builder.clustering.ClusteringModule;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DispatchingSharedModule implements Module {

	private static final Logger logger = Logger.getLogger(DispatchingSharedModule.class);
	
	public static boolean useClusteredBuilder() {
		String property = System.getProperty("xtext.clustered.builder");
		return "true".equals(property);
	}
	
	public void configure(Binder binder) {
		if (useClusteredBuilder()) {
			logger.info("Use clustered builder == true");
			new ClusteringModule().configure(binder);
		}
	}

}

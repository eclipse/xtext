/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 */
public abstract class ScenarioProcessor {

	@Inject
	private Injector injector;
	
	protected <T> T get(Class<T> service) {
		return injector.getInstance(service);
	}
	
	protected String preProcess(String data) {
		return data;
	}
	
	protected abstract void processFile(String data) throws Exception;
	
}

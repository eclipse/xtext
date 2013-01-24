/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.performance;

import static com.google.common.collect.Lists.*;

import java.util.List;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class GeneratorConfig {
	public String className;
	public String packageName;
	public boolean noTypeInference = false;
	public List<String> injectedExtensionTypes = newArrayList();
	public List<String> staticImportTypes = newArrayList();
}

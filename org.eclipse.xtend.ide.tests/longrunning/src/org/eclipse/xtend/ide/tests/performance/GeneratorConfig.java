/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.performance;

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

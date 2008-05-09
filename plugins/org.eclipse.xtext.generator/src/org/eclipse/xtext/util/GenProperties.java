/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Properties;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class GenProperties {
	
	private static Properties PROPS;
	public static void setProperties(Properties p) {
		PROPS = p;
	}
	
	public static String get(String prop) {
		return PROPS.getProperty(prop);
	}
}

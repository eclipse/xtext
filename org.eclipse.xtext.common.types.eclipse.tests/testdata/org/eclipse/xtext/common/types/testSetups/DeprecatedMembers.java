/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DeprecatedMembers {

	@Deprecated
	public DeprecatedMembers() {}
	
	/**
	 * @deprecated
	 */
	@Deprecated
	@SuppressWarnings("all")
	public void method() {}

	@Deprecated
	public String field;
	
	@Deprecated
	@interface Annotatation {}
	@Deprecated
	enum Enum {}
	@Deprecated
	interface Interface {}
	@Deprecated
	class Clazz {}
}

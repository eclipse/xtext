/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

/**
 * @author koehnlein - Initial contribution and API
 */
public abstract class Methods {
	
	public abstract void publicAbstractMethod();
	protected final void protectedFinalMethod() {}
	static void defaultStaticMethod() {}
	private synchronized void privateSynchronizedMethod() {}
	public strictfp void publicStrictFpMethod() {}
	public native void publicNativeMethod();
	
	public strictfp class StrictFpClass {}
}

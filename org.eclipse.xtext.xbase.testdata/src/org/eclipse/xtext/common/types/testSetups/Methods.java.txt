/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

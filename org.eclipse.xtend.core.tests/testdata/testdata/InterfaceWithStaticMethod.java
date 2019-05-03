/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package testdata;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public interface InterfaceWithStaticMethod {
	
	public int doit();
	public static int iamtheanswer() {
		return 42;
	}

}

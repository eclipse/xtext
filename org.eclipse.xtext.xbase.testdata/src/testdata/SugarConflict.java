/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package testdata;

/**
 * @author Jan Koehnlein
 * @since 2.3
 */
public interface SugarConflict {
	void getFoo();
	void foo();
	
	void bar();
	void getBar();
	
	Object getFooBar();
	boolean isFooBar();
	
	boolean isZonk();
	Object getZonk();
	
	boolean isBaz();
	Object getBaz();
	Object baz();
	String baz = "baz";
	
}

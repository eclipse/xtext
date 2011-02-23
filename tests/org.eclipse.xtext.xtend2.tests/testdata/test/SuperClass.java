/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package test;

import java.util.List;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class SuperClass {

	public abstract String string();
	public abstract String string(String s);
	
	public abstract Object object();
	public abstract Object object(Object o);

	@SuppressWarnings("unused")
	private String privateMethod() { return null; }
	
	public abstract List<String> returnsListString();
	public abstract List<? extends Object> returnsListExtendsObject();
	
	public abstract void voidFunction();
}

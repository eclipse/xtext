/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package testdata;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassWithVarArgs {

	private boolean varArgConstructor;
	private boolean defaultConstructor;

	public ClassWithVarArgs() {
		defaultConstructor = true;
	}
	
	public ClassWithVarArgs(int i, String... strings) {
		this.varArgConstructor = true;
	}
	
	public ClassWithVarArgs(int i, String s1, String s2) {
		this.varArgConstructor = false;
	}
	
	public List<String> stringsToList(String... strings) {
		if (strings == null)
			return null;
		return Lists.newArrayList(strings);
	}
	
	public List<String> stringsToList(String s1, String s2) {
		return Lists.newArrayList("foo", s1, s2);
	}
	
	public boolean isVarArgConstructor() {
		return varArgConstructor;
	}
	
	public boolean isDefaultConstructor() {
		return defaultConstructor;
	}
}

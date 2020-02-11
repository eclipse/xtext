/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("unused")
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
	
	public List<String> stringsToList2(String firstArg, String... strings) {
		if (strings == null)
			return null;
		final ArrayList<String> result = Lists.newArrayList(firstArg);
		result.addAll(Lists.newArrayList(strings));
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> toList(T... args) {
		return Lists.newArrayList(args);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Number> List<T> toNumberList(T... args) {
		return Lists.newArrayList(args);
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
	
	public String logInfo(String msg) {
		return String.format("logInfo(%s)", msg);
	}

	public String logInfo(String msg, Object... args) {
		return String.format("logInfo(%s, args...)", msg);
	}
	
	public String logInfo2(String msg) {
		return String.format("logInfo2(%s)", msg);
	}

	public String logInfo2(String msg, String param1) {
		return String.format("logInfo2(%s, %s)", msg, param1);
	}
	
	public String logInfo2(String msg, String param1, String param2) {
		return String.format("logInfo2(%s, %s, %s)", msg, param1, param2);
	}
	
	public String logInfo2(String msg, Object... args) {
		return String.format("logInfo2(%s, args...)", msg);
	}
	
	private List<String> values;
	
	public void setValues(String ... values) {
		this.values = stringsToList(values);
	}
	
	public List<String> getValues() {
		return values;
	}
	
}

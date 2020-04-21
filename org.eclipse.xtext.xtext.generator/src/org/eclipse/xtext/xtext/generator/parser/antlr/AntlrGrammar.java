/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

public class AntlrGrammar {
	private final String packageName;

	private final String simpleName;

	public String getName() {
		return packageName + "." + simpleName;
	}

	public String getGrammarFileName() {
		return getName().replace('.', '/') + ".g";
	}

	public String getTokensFileName() {
		return getName().replace('.', '/') + ".tokens";
	}

	@Override
	public String toString() {
		return getName();
	}

	public AntlrGrammar(String packageName, String simpleName) {
		this.packageName = packageName;
		this.simpleName = simpleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
		result = prime * result + ((simpleName == null) ? 0 : simpleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AntlrGrammar other = (AntlrGrammar) obj;
		if (packageName == null) {
			if (other.packageName != null)
				return false;
		} else if (!packageName.equals(other.packageName))
			return false;
		if (simpleName == null) {
			if (other.simpleName != null)
				return false;
		} else if (!simpleName.equals(other.simpleName))
			return false;
		return true;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getSimpleName() {
		return simpleName;
	}
}

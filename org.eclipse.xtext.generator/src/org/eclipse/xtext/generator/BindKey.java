/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;

/**
 *
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class BindKey {
	private String type;
	private boolean isSingleton = false;
	private boolean isEagerSingleton = false;

	@Override
	public String toString() {
		if (isSingleton) {
			return "singleton "+type;
		}
		if (isEagerSingleton) {
			return "eagerSingleton "+type;
		}
		return type;
	}

	public String getType() {
		return type;
	}


	public boolean isSingleton() {
		return isSingleton;
	}


	public boolean isEagerSingleton() {
		return isEagerSingleton;
	}

	private BindKey(String type, boolean isSingleton, boolean isEagerSingleton) {
		super();
		this.type = type.replace('$', '.');
		this.isSingleton = isSingleton;
		this.isEagerSingleton = isEagerSingleton;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		BindKey other = (BindKey) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	public static BindKey type(String name) {
		return new BindKey(name, false, false);
	}
	public static BindKey eagerSingleton(String name) {
		return new BindKey(name, true, true);
	}
	public static BindKey singleton(String name) {
		return new BindKey(name, true, false);
	}
}
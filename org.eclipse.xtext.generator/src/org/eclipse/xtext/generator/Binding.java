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
 * @author Sven Efftinge - Initial contribution and API
 *
 */
@Deprecated
public class Binding {

	private BindKey key;
	private BindValue val;
	private String contributedBy;
	private boolean isFinal;

	public Binding(BindKey key, BindValue val, boolean isFinal, String contributedBy) {
		super();
		this.key = key;
		this.val = val;
		this.contributedBy = contributedBy;
		this.isFinal = isFinal;
	}

	public String getContributedBy() {
		return contributedBy;
	}

	public BindKey getKey() {
		return key;
	}

	public BindValue getValue() {
		return val;
	}

	public boolean isFinal() {
		return isFinal;
	}

	@Override
	public String toString() {
		return (isFinal?"final ":"")+key+" -> "+val+" (contributed by "+contributedBy+")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		Binding other = (Binding) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}


}

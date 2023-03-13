/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package test;

import org.eclipse.xtend.lib.annotations.Data;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Data
public class BasicDataClass {
	private final String _myText;

	public BasicDataClass(String _myText) {
		super();
		this._myText = _myText;
	}
	public String getMyText() {
		return _myText;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_myText == null) ? 0 : _myText.hashCode());
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
		BasicDataClass other = (BasicDataClass) obj;
		if (_myText == null) {
			if (other._myText != null)
				return false;
		} else if (!_myText.equals(other._myText))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BasicDataClass [_myText=" + _myText + "]";
	}
	
}

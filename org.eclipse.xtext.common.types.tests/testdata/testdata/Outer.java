/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class Outer {
	
	public Outer getOuter() {
		return null;
	}
	
	public Inner getInner() {
		return null;
	}
	
	public Inner.InnerMost getInnerMost() {
		return null;
	}
	
	public static class Inner {
	
		public static class InnerMost {
			
		}
		
	}

}

/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

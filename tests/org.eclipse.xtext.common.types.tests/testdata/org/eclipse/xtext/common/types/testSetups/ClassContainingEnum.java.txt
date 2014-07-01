/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

public class ClassContainingEnum {
	
	public enum InnerEnumWithInt {
		FOO(1), BAR(2);
		private int x;
		InnerEnumWithInt(int i) {
			x = i;
		}
		
		@Override
		public String toString() {
			return super.toString()+x;
		}
	}
}

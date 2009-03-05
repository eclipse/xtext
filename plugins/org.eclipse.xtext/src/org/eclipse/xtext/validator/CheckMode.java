/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validator;

public interface CheckMode {
	public final static String KEY = "check.mode";
	
	public final static CheckMode FAST_ONLY = new CheckMode(){
		public boolean shouldCheck(CheckType type) {
			return type == CheckType.FAST;
		}
	};
	
	public final static CheckMode NORMAL_ONLY = new CheckMode(){
		public boolean shouldCheck(CheckType type) {
			return type == CheckType.NORMAL;
		}
	};
	
	public final static CheckMode EXPENSIVE_ONLY = new CheckMode(){
		public boolean shouldCheck(CheckType type) {
			return type == CheckType.EXPENSIVE;
		}
	};
	
	public final static CheckMode NORMAL_AND_FAST = new CheckMode(){
		public boolean shouldCheck(CheckType type) {
			return type == CheckType.NORMAL || type == CheckType.FAST;
		}
	};
	
	public final static CheckMode ALL = new CheckMode(){
		public boolean shouldCheck(CheckType type) {
			return true;
		}
	};
	
	boolean shouldCheck(CheckType type);
	
}

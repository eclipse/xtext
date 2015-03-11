/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InnerClasses {

	static class Super<T> {
		class Inner<X> {
		}
		class SubInner<X> extends Inner<X> {
		}
	}
	static class Sub<Y> extends Super<Y> {
		class SubInner2<X> extends Inner<Y> {}
	}
	
	static class SubString<Y> extends Super<String> {
	}
	
	static class Super2<T> {
		class Inner<X> {
		}
	}
	static class Sub2 extends Super2<String> {
		class SubInner extends Inner<String> {
		}
	}
	
	static class Super3<T> {
		class Inner<X> {}
		class Inner2<X> extends Inner<X> {}
	}
	static class Sub3 extends Super3<String> {
	}
	static class Sub4<Y> extends Super3<String> {
		class Inner3<X> extends Inner2<Y> {}
	}
	static class Sub5<X> extends Super3<String>.Inner<X> {
		Sub5() {
			new Super3<String>().super();
		}
	}
	
}


/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package selftypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConcreteSubBuilder<B extends ConcreteSubBuilder<B>> extends ConcreteBuilder<B>{

	public B appendTwice(String s) {
		return super.append(s).append(s);
	}
	
	public static ConcreteSubBuilder<?> create() {
		class ConcreteSubStringBuilder extends ConcreteSubBuilder<ConcreteSubStringBuilder> {
			public ConcreteSubStringBuilder() {
				b = this;
			}
		}
		return new ConcreteSubStringBuilder();
	}
	
}

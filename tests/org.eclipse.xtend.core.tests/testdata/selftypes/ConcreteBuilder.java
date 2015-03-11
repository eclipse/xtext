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
public class ConcreteBuilder<B extends ConcreteBuilder<B>> implements Builder<String> {

	private String s = "";
	protected B b;
	
	@Override
	public String build() {
		return s;
	}
	
	public B append(String s) {
		this.s += s;
		return b;
	}
	
	public static ConcreteBuilder<?> create() {
		class ConcreteStringBuilder extends ConcreteBuilder<ConcreteStringBuilder> {
			public ConcreteStringBuilder() {
				b = this;
			}
		}
		return new ConcreteStringBuilder();
	}
	
}

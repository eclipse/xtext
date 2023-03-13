/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

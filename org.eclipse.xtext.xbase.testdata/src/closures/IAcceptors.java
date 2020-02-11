/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package closures;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public interface IAcceptors {

	public interface IAcceptor {
		void doSth(String m);
	}

	public interface IAcceptor2 {
		void doSth(String[] m);
	}

	public interface IAcceptor3 {
		void doSth(String... m);
	}

	public interface IAcceptor4 {
		void doSth(String x, String[] m);
	}

	public interface IAcceptor5 {
		void doSth(String x, String... m);
	}

	public interface IAcceptor6 {
		void doSth(String[] x, String[] m);
	}

	public interface IAcceptor7 {
		void doSth(String[] x, String... m);
	}

}

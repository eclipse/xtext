/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.io.IOException;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ITraceToBytecodeInstaller {

	byte[] installTrace(byte[] javaClassBytecode) throws IOException;

	void setTrace(String javaFileName, AbstractTraceRegion trace);

}

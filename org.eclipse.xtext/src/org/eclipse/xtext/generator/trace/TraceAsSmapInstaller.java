/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TraceAsSmapInstaller implements ITraceToBytecodeInstaller {
	
	private static final Logger LOG = Logger.getLogger(TraceAsSmapInstaller.class);
	private static boolean hasLogged = false;

	@Override
	public byte[] installTrace(byte[] javaClassBytecode) throws IOException {
		if (!hasLogged) {
			hasLogged = true;
			LOG.error("The class "+getClass().getName()+" has been moved to 'org.eclipse.xtext.smap'. Please update your dependency.");
		}
		return javaClassBytecode;
	}

	@Override
	public void setTrace(String javaFileName, AbstractTraceRegion trace) {
	}

}

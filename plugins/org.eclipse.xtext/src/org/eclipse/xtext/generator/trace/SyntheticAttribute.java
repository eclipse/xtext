/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.objectweb.asm.Attribute;
import org.objectweb.asm.ByteVector;
import org.objectweb.asm.ClassWriter;

/**
 * @author kosyakov - Initial contribution and API
 */
class SyntheticAttribute extends Attribute {

	public SyntheticAttribute() {
		super("Synthetic");
	}

	@Override
	public boolean isUnknown() {
		return false;
	}

	@Override
	protected ByteVector write(final ClassWriter cw, final byte[] code, final int len, final int maxStack,
			final int maxLocals) {
		return new ByteVector();
	}

}
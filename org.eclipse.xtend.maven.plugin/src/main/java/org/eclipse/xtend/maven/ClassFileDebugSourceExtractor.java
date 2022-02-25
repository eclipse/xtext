/*******************************************************************************
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.maven;

import java.io.File;
import java.io.IOException;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

import com.google.common.io.Files;

public class ClassFileDebugSourceExtractor {

	protected static class Visitor extends ClassVisitor {
		public Visitor() {
			super(Opcodes.ASM9);
		}

		protected String source;

		@Override
		public void visitSource(String arg0, String arg1) {
			this.source = arg0;
		}
	}

	public String getDebugSourceFileName(File classFile) throws IOException {
		ClassReader cr = new ClassReader(Files.toByteArray(classFile));
		Visitor visitor = new Visitor();
		cr.accept(visitor, ClassReader.SKIP_CODE | ClassReader.SKIP_FRAMES);
		return visitor.source;
	}
}

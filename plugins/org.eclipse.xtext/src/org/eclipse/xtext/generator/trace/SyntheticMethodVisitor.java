/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * @author kosyakov - Initial contribution and API
 */
public class SyntheticMethodVisitor extends MethodVisitor {
	
	public SyntheticMethodVisitor(int api, MethodVisitor mv) {
		super(api, mv);
	}

	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
		if (desc.equals("Lorg/eclipse/xtext/xbase/lib/Synthetic;")) {
			super.visitAttribute(new SyntheticAttribute());
		}
		return super.visitAnnotation(desc, visible);
	}

}

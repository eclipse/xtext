/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.util.internal;

import org.apache.log4j.Logger;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend2.lib.StringConcatenationClient;

public class LogProcessor extends AbstractClassProcessor {
	@Override
	public void doTransform(MutableClassDeclaration cls, TransformationContext context) {
		cls.addField("LOG", field -> {
			field.setStatic(true);
			field.setFinal(true);
			field.setType(context.newTypeReference(Logger.class));
			field.setInitializer(new StringConcatenationClient() {
				@Override
				protected void appendTo(TargetStringConcatenation target) {
					target.append(Logger.class);
					target.append(".getLogger(");
					target.append(cls.getSimpleName());
					target.append(".class)");
					target.newLineIfNotEmpty();
				}
			});
			context.setPrimarySourceElement(field, cls);
		});
	}
}

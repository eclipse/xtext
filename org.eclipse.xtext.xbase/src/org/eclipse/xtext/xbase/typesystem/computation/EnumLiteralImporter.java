/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.scoping.batch.ITypeImporter;

/**
 * Imports the enum literals that are defined in a given enum type statically.
 * 
 * @since 2.7
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EnumLiteralImporter implements ITypeImporter.Client {
	private JvmDeclaredType enumType;

	public EnumLiteralImporter(JvmDeclaredType enumType) {
		this.enumType = enumType;
	}

	@Override
	public void doAddImports(ITypeImporter importer) {
		for (JvmMember member : enumType.getMembers()) {
			if (member instanceof JvmEnumerationLiteral) {
				importer.importStatic(enumType, member.getSimpleName());
			}
		}
	}
}
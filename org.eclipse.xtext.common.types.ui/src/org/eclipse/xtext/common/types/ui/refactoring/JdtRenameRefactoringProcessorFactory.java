/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.ILocalVariable;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeParameter;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.corext.refactoring.rename.JavaRenameProcessor;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenameEnumConstProcessor;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenameFieldProcessor;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenameLocalVariableProcessor;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenameNonVirtualMethodProcessor;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenameTypeParameterProcessor;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenameTypeProcessor;
import org.eclipse.jdt.internal.corext.refactoring.rename.RenameVirtualMethodProcessor;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JdtRenameRefactoringProcessorFactory {
	private static final Logger LOG = Logger.getLogger(JdtRenameRefactoringProcessorFactory.class);

	public JavaRenameProcessor createRenameProcessor(IJavaElement element) {
		try {
			switch (element.getElementType()) {
				case IJavaElement.TYPE:
					return new RenameTypeProcessor((IType) element);
				case IJavaElement.FIELD:
					if (((IField) element).getDeclaringType().isEnum())
						return new RenameEnumConstProcessor((IField) element);
					else
						return new RenameFieldProcessor((IField) element);
				case IJavaElement.METHOD:
					if(((IMethod)element).isConstructor()) 
						break;
					if (Flags.isStatic(((IMethod) element).getFlags()) || Flags.isPrivate(((IMethod) element).getFlags()))
						return new RenameNonVirtualMethodProcessor((IMethod) element);
					else
						return new RenameVirtualMethodProcessor((IMethod) element);
		        case IJavaElement.TYPE_PARAMETER:
		        	return new RenameTypeParameterProcessor((ITypeParameter)element);
		        case IJavaElement.LOCAL_VARIABLE:
		        	return new RenameLocalVariableProcessor((ILocalVariable)element);

			}
		} catch (JavaModelException exc) {
			LOG.error("Error creating refactoring processor for " + element.getElementName(), exc);
		}
		return null;
	}

}

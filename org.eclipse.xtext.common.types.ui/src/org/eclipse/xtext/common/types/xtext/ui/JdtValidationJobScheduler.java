/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.ui.editor.ValidationJobScheduler;

/**
 * Java aware extended {@link org.eclipse.xtext.ui.editor.IValidationJobScheduler validation
 * job scheduler}. It takes the currently dirty java editors into account, too.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.1
 */
public class JdtValidationJobScheduler extends ValidationJobScheduler {

	@Override
	protected boolean isDirty(URI uri) {
		if (uri == null)
			return false;
		if (URIHelperConstants.PROTOCOL.equals(uri.scheme())) {
			String path = uri.path();
			if (URIHelperConstants.PRIMITIVES.equals(path))
				return false;
			String topLevelTypeName = path.substring(URIHelperConstants.OBJECTS.length());
			ICompilationUnit[] workingCopies = JavaCore.getWorkingCopies(null);
			for(ICompilationUnit cu: workingCopies) {
				try {
					if (cu.hasUnsavedChanges()) {
						IType primaryType = cu.findPrimaryType();
						if (primaryType != null) {
							if (topLevelTypeName.equals(primaryType.getFullyQualifiedName())) {
								return true;
							}
						}
					}
				} catch (JavaModelException e) {
					// ignore
				}
			}
		}
		return super.isDirty(uri);
	}
	
}

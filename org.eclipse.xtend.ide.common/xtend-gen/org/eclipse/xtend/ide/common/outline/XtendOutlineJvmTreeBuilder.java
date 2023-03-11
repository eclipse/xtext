/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.common.outline;

import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmDeclaredType;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendOutlineJvmTreeBuilder extends AbstractXtendOutlineTreeBuilder {
  protected void _build(final XtendFile xtendFile, final IXtendOutlineContext context) {
    this.buildPackageAndImportSection(xtendFile, context);
    final Consumer<JvmDeclaredType> _function = (JvmDeclaredType it) -> {
      this.buildType(it, context);
    };
    Iterables.<JvmDeclaredType>filter(xtendFile.eResource().getContents(), JvmDeclaredType.class).forEach(_function);
  }

  protected void _build(final JvmDeclaredType jvmDeclaredType, final IXtendOutlineContext context) {
    this.buildMembers(jvmDeclaredType, jvmDeclaredType, context);
  }

  @Override
  protected void buildType(final EObject someType, final IXtendOutlineContext context) {
    if ((someType instanceof JvmDeclaredType)) {
      this.buildJvmType(((JvmDeclaredType)someType), context);
    } else {
      if ((someType instanceof XtendTypeDeclaration)) {
        final EObject jvmElement = this._iXtendJvmAssociations.getPrimaryJvmElement(someType);
        if ((jvmElement instanceof JvmDeclaredType)) {
          this.buildJvmType(((JvmDeclaredType)jvmElement), context);
        }
      }
    }
  }

  public void build(final EObject jvmDeclaredType, final IXtendOutlineContext context) {
    if (jvmDeclaredType instanceof JvmDeclaredType) {
      _build((JvmDeclaredType)jvmDeclaredType, context);
      return;
    } else if (jvmDeclaredType instanceof XtendFile) {
      _build((XtendFile)jvmDeclaredType, context);
      return;
    } else if (jvmDeclaredType != null) {
      _build(jvmDeclaredType, context);
      return;
    } else if (jvmDeclaredType == null) {
      _build((Void)null, context);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(jvmDeclaredType, context).toString());
    }
  }
}

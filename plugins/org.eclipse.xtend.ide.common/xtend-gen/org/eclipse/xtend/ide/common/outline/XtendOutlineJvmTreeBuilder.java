/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.common.outline;

import com.google.common.collect.Iterables;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.common.outline.AbstractXtendOutlineTreeBuilder;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineContext;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendOutlineJvmTreeBuilder extends AbstractXtendOutlineTreeBuilder {
  protected void _build(final XtendFile xtendFile, final IXtendOutlineContext context) {
    this.buildPackageAndImportSection(xtendFile, context);
    Resource _eResource = xtendFile.eResource();
    EList<EObject> _contents = _eResource.getContents();
    Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents, JvmDeclaredType.class);
    final Procedure1<JvmDeclaredType> _function = new Procedure1<JvmDeclaredType>() {
      @Override
      public void apply(final JvmDeclaredType it) {
        XtendOutlineJvmTreeBuilder.this.buildType(it, context);
      }
    };
    IterableExtensions.<JvmDeclaredType>forEach(_filter, _function);
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

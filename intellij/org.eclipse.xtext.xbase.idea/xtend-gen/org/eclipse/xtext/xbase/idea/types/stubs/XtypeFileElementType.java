/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.types.stubs;

import com.google.inject.Inject;
import com.intellij.lang.Language;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubIndexKey;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.stubs.ExportedObject;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.xbase.idea.types.stubs.JvmDeclaredTypeShortNameIndex;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtypeFileElementType<T extends XtextFileStub<?>> extends XtextFileElementType<T> {
  @Inject
  private JvmDeclaredTypeShortNameIndex jvmDeclaredTypeShortNameIndex;
  
  public XtypeFileElementType(final Language language) {
    super(language);
  }
  
  @Override
  protected void indexExportedObject(final ExportedObject exportedObject, @Extension final IndexSink sink) {
    super.indexExportedObject(exportedObject, sink);
    EClass _eClass = exportedObject.getEClass();
    boolean _isAssignableFrom = EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_DECLARED_TYPE, _eClass);
    if (_isAssignableFrom) {
      StubIndexKey<String, BaseXtextFile> _key = this.jvmDeclaredTypeShortNameIndex.getKey();
      QualifiedName _qualifiedName = exportedObject.getQualifiedName();
      String _lastSegment = _qualifiedName.getLastSegment();
      sink.<BaseXtextFile, String>occurrence(_key, _lastSegment);
    }
  }
}

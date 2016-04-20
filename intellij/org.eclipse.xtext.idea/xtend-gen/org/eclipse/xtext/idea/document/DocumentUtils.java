/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.document;

import com.intellij.openapi.editor.Document;
import java.util.List;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class DocumentUtils {
  @FinalFieldsConstructor
  private static class ImportingSourceAppender implements ISourceAppender {
    private final RewritableImportSection importSection;
    
    private final StringBuilder result = new StringBuilder();
    
    @Override
    public ISourceAppender append(final CharSequence string) {
      this.result.append(string);
      return this;
    }
    
    @Override
    public ISourceAppender append(final JvmType object) {
      if ((object instanceof JvmGenericType)) {
        if (((this.importSection.addImport(((JvmDeclaredType)object)) || this.importSection.hasImportedType(((JvmDeclaredType)object))) || (!this.importSection.needsImport(((JvmDeclaredType)object))))) {
          String _simpleName = ((JvmGenericType)object).getSimpleName();
          this.result.append(_simpleName);
          return this;
        }
      }
      String _qualifiedName = object.getQualifiedName();
      this.result.append(_qualifiedName);
      return this;
    }
    
    @Override
    public ISourceAppender append(final LightweightTypeReference typeRef) {
      final DocumentUtils.ImportingSourceAppender nested = new DocumentUtils.ImportingSourceAppender(this.importSection);
      final LightweightTypeReferenceSerializer serializer = new LightweightTypeReferenceSerializer(nested);
      typeRef.accept(serializer);
      String _string = nested.toString();
      this.result.append(_string);
      return this;
    }
    
    @Override
    public String toString() {
      return this.result.toString();
    }
    
    @Override
    public boolean isJava() {
      return false;
    }
    
    @Override
    public ISourceAppender decreaseIndentation() {
      throw new UnsupportedOperationException("TODO: auto-generated method stub");
    }
    
    @Override
    public ISourceAppender increaseIndentation() {
      throw new UnsupportedOperationException("TODO: auto-generated method stub");
    }
    
    @Override
    public ISourceAppender newLine() {
      throw new UnsupportedOperationException("TODO: auto-generated method stub");
    }
    
    public ImportingSourceAppender(final RewritableImportSection importSection) {
      super();
      this.importSection = importSection;
    }
  }
  
  public void updateImportSection(final Document document, final RewritableImportSection importSection) {
    List<ReplaceRegion> _rewrite = importSection.rewrite();
    for (final ReplaceRegion reg : _rewrite) {
      int _offset = reg.getOffset();
      int _endOffset = reg.getEndOffset();
      String _text = reg.getText();
      document.replaceString(_offset, _endOffset, _text);
    }
  }
  
  public String toImportableString(final LightweightTypeReference ref, final RewritableImportSection importSection) {
    final DocumentUtils.ImportingSourceAppender appender = new DocumentUtils.ImportingSourceAppender(importSection);
    appender.append(ref);
    return appender.toString();
  }
  
  public String toImportableString(final JvmTypeReference ref, final RewritableImportSection importSection) {
    final DocumentUtils.ImportingSourceAppender appender = new DocumentUtils.ImportingSourceAppender(importSection);
    JvmType _type = ref.getType();
    appender.append(_type);
    return appender.toString();
  }
}

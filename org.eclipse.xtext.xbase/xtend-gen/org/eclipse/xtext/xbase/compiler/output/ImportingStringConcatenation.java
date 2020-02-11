/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler.output;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.output.SharedAppendableState;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceFactory;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer;

/**
 * A specialized {@link StringConcatenation} that will properly convert instances of
 * {@link Class}, {@link JvmType}, {@link JvmTypeReference} or {@link LightweightTypeReference}
 * to their valid serialized representation including import handling.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ImportingStringConcatenation extends StringConcatenation {
  private final ImportManager importManager;
  
  private final ITypeReferenceOwner typeReferenceOwner;
  
  public ImportingStringConcatenation(final SharedAppendableState state, final ITypeReferenceOwner typeReferenceOwner) {
    super(state.getLineSeparator());
    this.importManager = state.getImportManager();
    this.typeReferenceOwner = typeReferenceOwner;
  }
  
  protected String _getStringRepresentation(final Object object) {
    return super.getStringRepresentation(object);
  }
  
  protected String _getStringRepresentation(final JvmType object) {
    return this.importManager.serialize(object).toString();
  }
  
  protected String _getStringRepresentation(final JvmTypeReference object) {
    final LightweightTypeReference reference = new LightweightTypeReferenceFactory(this.typeReferenceOwner, true).toLightweightReference(object);
    return this._getStringRepresentation(reference);
  }
  
  protected String _getStringRepresentation(final LightweightTypeReference object) {
    final StringBuilderBasedAppendable appender = new StringBuilderBasedAppendable(this.importManager);
    final LightweightTypeReferenceSerializer serializer = new LightweightTypeReferenceSerializer(appender);
    object.accept(serializer);
    return appender.toString();
  }
  
  protected String _getStringRepresentation(final Class<?> object) {
    return this.importManager.serialize(object).toString();
  }
  
  /**
   * A potentially contained trailing line delimiter is ignored.
   */
  @Override
  protected List<String> getSignificantContent() {
    final List<String> result = super.getSignificantContent();
    if (((result.size() >= 1) && Objects.equal(this.getLineDelimiter(), IterableExtensions.<String>last(result)))) {
      int _size = result.size();
      int _minus = (_size - 1);
      return result.subList(0, _minus);
    }
    return result;
  }
  
  protected String getStringRepresentation(final Object object) {
    if (object instanceof JvmType) {
      return _getStringRepresentation((JvmType)object);
    } else if (object instanceof Class) {
      return _getStringRepresentation((Class<?>)object);
    } else if (object instanceof JvmTypeReference) {
      return _getStringRepresentation((JvmTypeReference)object);
    } else if (object instanceof LightweightTypeReference) {
      return _getStringRepresentation((LightweightTypeReference)object);
    } else if (object != null) {
      return _getStringRepresentation(object);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(object).toString());
    }
  }
}

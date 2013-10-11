/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

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
    super(new Function0<String>() {
      public String apply() {
        String _lineSeparator = state.getLineSeparator();
        return _lineSeparator;
      }
    }.apply());
    ImportManager _importManager = state.getImportManager();
    this.importManager = _importManager;
    this.typeReferenceOwner = typeReferenceOwner;
  }
  
  protected String _getStringRepresentation(final Object object) {
    String _stringRepresentation = super.getStringRepresentation(object);
    return _stringRepresentation;
  }
  
  protected String _getStringRepresentation(final JvmType object) {
    CharSequence _serialize = this.importManager.serialize(object);
    return _serialize.toString();
  }
  
  protected String _getStringRepresentation(final JvmTypeReference object) {
    OwnedConverter _ownedConverter = new OwnedConverter(this.typeReferenceOwner, true);
    final LightweightTypeReference reference = _ownedConverter.toLightweightReference(object);
    return this._getStringRepresentation(reference);
  }
  
  protected String _getStringRepresentation(final LightweightTypeReference object) {
    StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(this.importManager);
    final StringBuilderBasedAppendable appender = _stringBuilderBasedAppendable;
    LightweightTypeReferenceSerializer _lightweightTypeReferenceSerializer = new LightweightTypeReferenceSerializer(appender);
    final LightweightTypeReferenceSerializer serializer = _lightweightTypeReferenceSerializer;
    object.accept(serializer);
    return appender.toString();
  }
  
  protected String _getStringRepresentation(final Class<? extends Object> object) {
    CharSequence _serialize = this.importManager.serialize(object);
    return _serialize.toString();
  }
  
  /**
   * A potentially contained trailing line delimiter is ignored.
   */
  protected List<String> getSignificantContent() {
    final List<String> result = super.getSignificantContent();
    boolean _and = false;
    int _size = result.size();
    boolean _greaterEqualsThan = (_size >= 1);
    if (!_greaterEqualsThan) {
      _and = false;
    } else {
      String _lineDelimiter = this.getLineDelimiter();
      String _last = IterableExtensions.<String>last(result);
      boolean _equals = Objects.equal(_lineDelimiter, _last);
      _and = (_greaterEqualsThan && _equals);
    }
    if (_and) {
      int _size_1 = result.size();
      int _minus = (_size_1 - 1);
      return result.subList(0, _minus);
    }
    return result;
  }
  
  protected String getStringRepresentation(final Object object) {
    if (object instanceof JvmType) {
      return _getStringRepresentation((JvmType)object);
    } else if (object instanceof JvmTypeReference) {
      return _getStringRepresentation((JvmTypeReference)object);
    } else if (object instanceof Class) {
      return _getStringRepresentation((Class<?>)object);
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

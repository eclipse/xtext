/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.lib.util;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringContext;

/**
 * Helps with the construction of good {@link Object#toString()} representations.
 * <p>You can customize the output using the builder-style methods {@link ToStringBuilder#singleLine()} {@link ToStringBuilder#skipNulls()} and {@link ToStringBuilder#hideFieldNames()}.</p>
 * <p>You can either directly list fields to include via {@link ToStringBuilder#add(String, Object)} and {@link ToStringBuilder#add(Object)}
 * or you can let the builder do it automatically using reflection, either including the fields declared in this class or including all superclasses.</p>
 * <p>The builder will automatically handle cycles in the object tree. It also pretty prints arrays and Iterables.</p>
 * 
 * This class is not thread safe.
 * @since 2.7
 */
@Beta
@GwtCompatible
@SuppressWarnings("all")
public final class ToStringBuilder {
  private static final class Part {
    private String fieldName;
    
    private Object value;
  }
  
  private static class IndentationAwareStringBuilder {
    private final StringBuilder builder = new StringBuilder();
    
    private final String indentationString = "  ";
    
    private final String newLineString = "\n";
    
    private int indentation = 0;
    
    public IndentationAwareStringBuilder increaseIndent() {
      this.indentation++;
      return this;
    }
    
    public IndentationAwareStringBuilder decreaseIndent() {
      this.indentation--;
      return this;
    }
    
    public IndentationAwareStringBuilder append(final CharSequence string) {
      if ((this.indentation > 0)) {
        String _repeat = Strings.repeat(this.indentationString, this.indentation);
        final String replacement = (this.newLineString + _repeat);
        String _string = string.toString();
        final String indented = _string.replace(this.newLineString, replacement);
        this.builder.append(indented);
      } else {
        this.builder.append(string);
      }
      return this;
    }
    
    public IndentationAwareStringBuilder newLine() {
      StringBuilder _append = this.builder.append(this.newLineString);
      String _repeat = Strings.repeat(this.indentationString, this.indentation);
      _append.append(_repeat);
      return this;
    }
    
    @Override
    public String toString() {
      return this.builder.toString();
    }
  }
  
  @Extension
  private static ToStringContext _toStringContext = ToStringContext.INSTANCE;
  
  private final Object instance;
  
  private final String typeName;
  
  private boolean multiLine = true;
  
  private boolean skipNulls = false;
  
  private boolean showFieldNames = true;
  
  private boolean prettyPrint = true;
  
  private final ArrayList<Part> parts = CollectionLiterals.<Part>newArrayList();
  
  /**
   * Creates a new ToStringBuilder for the given object. If you don't use reflection, then this instance
   * is only used for obtaining its classes' simplename.
   * 
   * @param instance the object to convert to a String
   */
  public ToStringBuilder(final Object instance) {
    this.instance = instance;
    Class<?> _class = instance.getClass();
    String _simpleName = _class.getSimpleName();
    this.typeName = _simpleName;
  }
  
  /**
   * Fields are printed on a single line, separated by commas instead of newlines
   * @return this
   */
  public ToStringBuilder singleLine() {
    this.multiLine = false;
    return this;
  }
  
  /**
   * Fields with null values will be excluded from the output
   * @return this
   */
  public ToStringBuilder skipNulls() {
    this.skipNulls = true;
    return this;
  }
  
  /**
   * Field names will not be included in the output. Useful for small classes.
   * @return this
   */
  public ToStringBuilder hideFieldNames() {
    this.showFieldNames = false;
    return this;
  }
  
  /**
   * By default, Iterables, Arrays and multiline Strings are pretty-printed.
   * Switching to their normal representation makes the toString method significantly faster.
   * @since 2.9
   * @return this
   */
  public ToStringBuilder verbatimValues() {
    this.prettyPrint = false;
    return this;
  }
  
  /**
   * Adds all fields declared directly in the object's class to the output
   * @return this
   */
  @GwtIncompatible("Class.getDeclaredFields")
  public ToStringBuilder addDeclaredFields() {
    Class<?> _class = this.instance.getClass();
    Field[] _declaredFields = _class.getDeclaredFields();
    for (final Field it : _declaredFields) {
      this.addField(it);
    }
    return this;
  }
  
  /**
   * Adds all fields declared in the object's class and its superclasses to the output.
   * @return this
   */
  @GwtIncompatible("Class.getDeclaredFields")
  public ToStringBuilder addAllFields() {
    Class<?> _class = this.instance.getClass();
    ArrayList<Field> _allDeclaredFields = this.getAllDeclaredFields(_class);
    for (final Field it : _allDeclaredFields) {
      this.addField(it);
    }
    return this;
  }
  
  /**
   * @param fieldName the name of the field to add to the output using reflection
   * @return this
   */
  @GwtIncompatible("Class.getDeclaredField(String)")
  public ToStringBuilder addField(final String fieldName) {
    Class<?> _class = this.instance.getClass();
    ArrayList<Field> _allDeclaredFields = this.getAllDeclaredFields(_class);
    final Function1<Field, Boolean> _function = new Function1<Field, Boolean>() {
      @Override
      public Boolean apply(final Field it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, fieldName));
      }
    };
    Field _findFirst = IterableExtensions.<Field>findFirst(_allDeclaredFields, _function);
    return this.addField(_findFirst);
  }
  
  @GwtIncompatible("java.lang.reflect.Field")
  private ToStringBuilder addField(final Field field) {
    try {
      ToStringBuilder _xifexpression = null;
      int _modifiers = field.getModifiers();
      boolean _isStatic = Modifier.isStatic(_modifiers);
      boolean _not = (!_isStatic);
      if (_not) {
        ToStringBuilder _xblockexpression = null;
        {
          field.setAccessible(true);
          String _name = field.getName();
          Object _get = field.get(this.instance);
          _xblockexpression = this.add(_name, _get);
        }
        _xifexpression = _xblockexpression;
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * @param value the value to add to the output
   * @param fieldName the fiel name to list the value under
   * @return this
   */
  public ToStringBuilder add(final String fieldName, final Object value) {
    return this.addPart(fieldName, value);
  }
  
  /**
   * @param value the value to add to the output without a field name
   * @return this
   */
  public ToStringBuilder add(final Object value) {
    return this.addPart(value);
  }
  
  private Part addPart() {
    final Part p = new Part();
    this.parts.add(p);
    return p;
  }
  
  private ToStringBuilder addPart(final Object value) {
    final Part p = this.addPart();
    p.value = value;
    return this;
  }
  
  private ToStringBuilder addPart(final String fieldName, final Object value) {
    final Part p = this.addPart();
    p.fieldName = fieldName;
    p.value = value;
    return this;
  }
  
  /**
   * @return the String representation of the processed object
   */
  @Override
  public String toString() {
    boolean _startProcessing = ToStringBuilder._toStringContext.startProcessing(this.instance);
    boolean _not = (!_startProcessing);
    if (_not) {
      return this.toSimpleReferenceString(this.instance);
    }
    try {
      final IndentationAwareStringBuilder builder = new IndentationAwareStringBuilder();
      IndentationAwareStringBuilder _append = builder.append(this.typeName);
      _append.append(" ");
      builder.append("[");
      String nextSeparator = "";
      if (this.multiLine) {
        builder.increaseIndent();
      }
      for (final Part part : this.parts) {
        if (((!this.skipNulls) || (part.value != null))) {
          if (this.multiLine) {
            builder.newLine();
          } else {
            builder.append(nextSeparator);
            nextSeparator = ", ";
          }
          boolean _and = false;
          if (!(part.fieldName != null)) {
            _and = false;
          } else {
            _and = this.showFieldNames;
          }
          if (_and) {
            IndentationAwareStringBuilder _append_1 = builder.append(part.fieldName);
            _append_1.append(" = ");
          }
          this.internalToString(part.value, builder);
        }
      }
      if (this.multiLine) {
        IndentationAwareStringBuilder _decreaseIndent = builder.decreaseIndent();
        _decreaseIndent.newLine();
      }
      builder.append("]");
      return builder.toString();
    } finally {
      ToStringBuilder._toStringContext.endProcessing(this.instance);
    }
  }
  
  private void internalToString(final Object object, final IndentationAwareStringBuilder sb) {
    if (this.prettyPrint) {
      if ((object instanceof Iterable<?>)) {
        this.serializeIterable(((Iterable<?>)object), sb);
      } else {
        if ((object instanceof Object[])) {
          String _string = Arrays.toString(((Object[])object));
          sb.append(_string);
        } else {
          if ((object instanceof byte[])) {
            String _string_1 = Arrays.toString(((byte[])object));
            sb.append(_string_1);
          } else {
            if ((object instanceof char[])) {
              String _string_2 = Arrays.toString(((char[])object));
              sb.append(_string_2);
            } else {
              if ((object instanceof int[])) {
                String _string_3 = Arrays.toString(((int[])object));
                sb.append(_string_3);
              } else {
                if ((object instanceof boolean[])) {
                  String _string_4 = Arrays.toString(((boolean[])object));
                  sb.append(_string_4);
                } else {
                  if ((object instanceof long[])) {
                    String _string_5 = Arrays.toString(((long[])object));
                    sb.append(_string_5);
                  } else {
                    if ((object instanceof float[])) {
                      String _string_6 = Arrays.toString(((float[])object));
                      sb.append(_string_6);
                    } else {
                      if ((object instanceof double[])) {
                        String _string_7 = Arrays.toString(((double[])object));
                        sb.append(_string_7);
                      } else {
                        if ((object instanceof CharSequence)) {
                          IndentationAwareStringBuilder _append = sb.append("\"");
                          String _string_8 = ((CharSequence)object).toString();
                          String _replace = _string_8.replace("\n", "\\n");
                          String _replace_1 = _replace.replace("\r", "\\r");
                          IndentationAwareStringBuilder _append_1 = _append.append(_replace_1);
                          _append_1.append("\"");
                        } else {
                          if ((object instanceof Enum<?>)) {
                            String _name = ((Enum<?>)object).name();
                            sb.append(_name);
                          } else {
                            String _valueOf = String.valueOf(object);
                            sb.append(_valueOf);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    } else {
      String _valueOf_1 = String.valueOf(object);
      sb.append(_valueOf_1);
    }
  }
  
  private void serializeIterable(final Iterable<?> object, final IndentationAwareStringBuilder sb) {
    final Iterator<?> iterator = object.iterator();
    Class<? extends Iterable> _class = object.getClass();
    String _simpleName = _class.getSimpleName();
    IndentationAwareStringBuilder _append = sb.append(_simpleName);
    _append.append(" (");
    if (this.multiLine) {
      sb.increaseIndent();
    }
    boolean wasEmpty = true;
    while (iterator.hasNext()) {
      {
        wasEmpty = false;
        if (this.multiLine) {
          sb.newLine();
        }
        Object _next = iterator.next();
        this.internalToString(_next, sb);
        boolean _hasNext = iterator.hasNext();
        if (_hasNext) {
          sb.append(",");
        }
      }
    }
    if (this.multiLine) {
      sb.decreaseIndent();
    }
    boolean _and = false;
    if (!(!wasEmpty)) {
      _and = false;
    } else {
      _and = this.multiLine;
    }
    if (_and) {
      sb.newLine();
    }
    sb.append(")");
  }
  
  private String toSimpleReferenceString(final Object obj) {
    Class<?> _class = obj.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = (_simpleName + "@");
    int _identityHashCode = System.identityHashCode(obj);
    return (_plus + Integer.valueOf(_identityHashCode));
  }
  
  @GwtIncompatible("java.lang.reflect.Field")
  private ArrayList<Field> getAllDeclaredFields(final Class<?> clazz) {
    Class<?> current = clazz;
    final ArrayList<Field> result = CollectionLiterals.<Field>newArrayList();
    do {
      {
        Field[] _declaredFields = current.getDeclaredFields();
        Iterables.<Field>addAll(result, ((Iterable<? extends Field>)Conversions.doWrapArray(_declaredFields)));
        Class<?> _superclass = current.getSuperclass();
        current = _superclass;
      }
    } while((!Objects.equal(current, null)));
    return result;
  }
}

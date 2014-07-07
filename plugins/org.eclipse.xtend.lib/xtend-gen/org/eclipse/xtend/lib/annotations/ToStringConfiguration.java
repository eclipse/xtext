package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
@SuppressWarnings("all")
public class ToStringConfiguration {
  private final boolean skipNulls;
  
  private final boolean singleLine;
  
  private final boolean hideFieldNames;
  
  public ToStringConfiguration() {
    this(false, false, false);
  }
  
  public ToStringConfiguration(final boolean skipNulls, final boolean singleLine, final boolean hideFieldNames) {
    this.skipNulls = skipNulls;
    this.singleLine = singleLine;
    this.hideFieldNames = hideFieldNames;
  }
  
  public ToStringConfiguration(final AnnotationReference annotation) {
    boolean _booleanValue = annotation.getBooleanValue("skipNulls");
    this.skipNulls = _booleanValue;
    boolean _booleanValue_1 = annotation.getBooleanValue("singleLine");
    this.singleLine = _booleanValue_1;
    boolean _booleanValue_2 = annotation.getBooleanValue("hideFieldNames");
    this.hideFieldNames = _booleanValue_2;
  }
  
  public boolean isSkipNulls() {
    return this.skipNulls;
  }
  
  public boolean isSingleLine() {
    return this.singleLine;
  }
  
  public boolean isHideFieldNames() {
    return this.hideFieldNames;
  }
}

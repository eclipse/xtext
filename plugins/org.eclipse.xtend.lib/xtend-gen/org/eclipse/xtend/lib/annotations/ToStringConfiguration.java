package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;

/**
 * @since 2.7
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This class is not intended to be referenced by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@Beta
@SuppressWarnings("all")
public class ToStringConfiguration {
  private final boolean skipNulls;
  
  private final boolean singleLine;
  
  private final boolean hideFieldNames;
  
  private final boolean verbatimValues;
  
  public ToStringConfiguration() {
    this(false, false, false, false);
  }
  
  public ToStringConfiguration(final boolean skipNulls, final boolean singleLine, final boolean hideFieldNames, final boolean verbatimValues) {
    this.skipNulls = skipNulls;
    this.singleLine = singleLine;
    this.hideFieldNames = hideFieldNames;
    this.verbatimValues = verbatimValues;
  }
  
  public ToStringConfiguration(final AnnotationReference annotation) {
    boolean _booleanValue = annotation.getBooleanValue("skipNulls");
    this.skipNulls = _booleanValue;
    boolean _booleanValue_1 = annotation.getBooleanValue("singleLine");
    this.singleLine = _booleanValue_1;
    boolean _booleanValue_2 = annotation.getBooleanValue("hideFieldNames");
    this.hideFieldNames = _booleanValue_2;
    boolean _booleanValue_3 = annotation.getBooleanValue("verbatimValues");
    this.verbatimValues = _booleanValue_3;
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
  
  public boolean isVerbatimValues() {
    return this.verbatimValues;
  }
}

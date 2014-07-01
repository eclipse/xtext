package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
@SuppressWarnings("all")
public enum AccessorType {
  PUBLIC_GETTER,
  
  PROTECTED_GETTER,
  
  PACKAGE_GETTER,
  
  PRIVATE_GETTER,
  
  PUBLIC_SETTER,
  
  PROTECTED_SETTER,
  
  PACKAGE_SETTER,
  
  PRIVATE_SETTER,
  
  NONE;
}

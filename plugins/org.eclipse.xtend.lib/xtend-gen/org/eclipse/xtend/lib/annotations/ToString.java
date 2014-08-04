package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.annotations.ToStringProcessor;
import org.eclipse.xtend.lib.macro.Active;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Creates a default {@link Object#toString toString} implementation. All non-static fields of this class and all of its superclasses are used. The default format is:
 * <pre>
 *  ClassName [
 *    field1 = "Foo"
 *    field2 = 2
 *    field3 = null
 *  ]
 * </pre>
 * <p>
 * For brevity there are options to hide field names, skip fields with null values and print everything on one line.
 * </p>
 * <strong>Note for GWT users</strong>: If this class has a superclass, reflection is used to get the values of the super classes fields, which will not work on GWT.
 * @see ToStringBuilder
 * @since 2.7
 */
@Beta
@Target(ElementType.TYPE)
@Active(ToStringProcessor.class)
@GwtCompatible
public @interface ToString {
  /**
   * Fields with null values are not shown in the output.
   */
  public boolean skipNulls() default false;
  /**
   * Seperate fields with a comma and a single space
   */
  public boolean singleLine() default false;
  /**
   * Only list the values of the fields, not their names
   */
  public boolean hideFieldNames() default false;
}

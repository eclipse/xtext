package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.annotations.DelegateProcessor;
import org.eclipse.xtend.lib.macro.Active;

/**
 * Implements interfaces by forwarding method calls to an annotated field or method.
 * 
 * <p>
 * <pre>
 * interface I {
 *  def String m()
 * }
 * class Foo implements I {
 *  override String m() {
 *   "Foo"
 *  }
 * }
 * class Bar implements I {
 *  //This will generate a method m(), which calls foo.m()
 *  &#64;Delegate val foo = new Foo
 * }
 * </pre>
 * 
 * For each interface that the declaring class and the delegate have in common,
 * an implementation for each method is added if it does not yet exist. This
 * implementation forwards all calls directly to the delegate. You can restrict
 * which interfaces to implement using the {@link Class}[] value of this
 * annotation. This is especially useful when there are several delegates that
 * have some interfaces in common.
 * 
 * </p>
 * Delegate methods can either take
 * <ul>
 * <li>no arguments</li>
 * <li>the name of the method to be called (String)</li>
 * <li>the name of the method to be called (String), its parameter types
 * (Class[]) and the actual arguments (Object[]) of the call</li>
 * </ul>
 * This allows you to generate meaningful error messages or to dynamically
 * dispatch based on the arguments.
 * 
 * @since 2.7
 */
@Beta
@GwtCompatible
@Target({ ElementType.FIELD, ElementType.METHOD })
@Active(DelegateProcessor.class)
@Documented
public @interface Delegate {
  /**
   * Optional list of interfaces that this delegate is restricted to.
   * Defaults to the common interfaces of the context type and the annotated
   * element.
   */
  public Class<?>[] value() default {};
}

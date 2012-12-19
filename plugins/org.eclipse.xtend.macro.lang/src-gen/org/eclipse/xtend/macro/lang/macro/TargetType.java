/**
 */
package org.eclipse.xtend.macro.lang.macro;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Target Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtend.macro.lang.macro.MacroPackage#getTargetType()
 * @model
 * @generated
 */
public enum TargetType implements Enumerator
{
  /**
   * The '<em><b>Class</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CLASS_VALUE
   * @generated
   * @ordered
   */
  CLASS(0, "class", "class"),

  /**
   * The '<em><b>Field</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FIELD_VALUE
   * @generated
   * @ordered
   */
  FIELD(1, "field", "field"),

  /**
   * The '<em><b>Method</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #METHOD_VALUE
   * @generated
   * @ordered
   */
  METHOD(2, "method", "method"),

  /**
   * The '<em><b>Parameter</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PARAMETER_VALUE
   * @generated
   * @ordered
   */
  PARAMETER(3, "parameter", "parameter"),

  /**
   * The '<em><b>Constructor</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONSTRUCTOR_VALUE
   * @generated
   * @ordered
   */
  CONSTRUCTOR(4, "constructor", "constructor");

  /**
   * The '<em><b>Class</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Class</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CLASS
   * @model name="class"
   * @generated
   * @ordered
   */
  public static final int CLASS_VALUE = 0;

  /**
   * The '<em><b>Field</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Field</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FIELD
   * @model name="field"
   * @generated
   * @ordered
   */
  public static final int FIELD_VALUE = 1;

  /**
   * The '<em><b>Method</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Method</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #METHOD
   * @model name="method"
   * @generated
   * @ordered
   */
  public static final int METHOD_VALUE = 2;

  /**
   * The '<em><b>Parameter</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Parameter</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PARAMETER
   * @model name="parameter"
   * @generated
   * @ordered
   */
  public static final int PARAMETER_VALUE = 3;

  /**
   * The '<em><b>Constructor</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Constructor</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CONSTRUCTOR
   * @model name="constructor"
   * @generated
   * @ordered
   */
  public static final int CONSTRUCTOR_VALUE = 4;

  /**
   * An array of all the '<em><b>Target Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final TargetType[] VALUES_ARRAY =
    new TargetType[]
    {
      CLASS,
      FIELD,
      METHOD,
      PARAMETER,
      CONSTRUCTOR,
    };

  /**
   * A public read-only list of all the '<em><b>Target Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<TargetType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Target Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TargetType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      TargetType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Target Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TargetType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      TargetType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Target Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TargetType get(int value)
  {
    switch (value)
    {
      case CLASS_VALUE: return CLASS;
      case FIELD_VALUE: return FIELD;
      case METHOD_VALUE: return METHOD;
      case PARAMETER_VALUE: return PARAMETER;
      case CONSTRUCTOR_VALUE: return CONSTRUCTOR;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private TargetType(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //TargetType

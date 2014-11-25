/**
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Enum Bug Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage#getEnumBugEnum()
 * @model
 * @generated
 */
public enum EnumBugEnum implements Enumerator
{
  /**
   * The '<em><b>Array</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ARRAY_VALUE
   * @generated
   * @ordered
   */
  ARRAY(0, "array", "array"),

  /**
   * The '<em><b>Object</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OBJECT_VALUE
   * @generated
   * @ordered
   */
  OBJECT(1, "object", "object"),

  /**
   * The '<em><b>Result Set</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RESULT_SET_VALUE
   * @generated
   * @ordered
   */
  RESULT_SET(2, "resultSet", "resultSet"),

  /**
   * The '<em><b>Iterator</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ITERATOR_VALUE
   * @generated
   * @ordered
   */
  ITERATOR(3, "iterator", "iterator");

  /**
   * The '<em><b>Array</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Array</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ARRAY
   * @model name="array"
   * @generated
   * @ordered
   */
  public static final int ARRAY_VALUE = 0;

  /**
   * The '<em><b>Object</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Object</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OBJECT
   * @model name="object"
   * @generated
   * @ordered
   */
  public static final int OBJECT_VALUE = 1;

  /**
   * The '<em><b>Result Set</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Result Set</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RESULT_SET
   * @model name="resultSet"
   * @generated
   * @ordered
   */
  public static final int RESULT_SET_VALUE = 2;

  /**
   * The '<em><b>Iterator</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Iterator</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ITERATOR
   * @model name="iterator"
   * @generated
   * @ordered
   */
  public static final int ITERATOR_VALUE = 3;

  /**
   * An array of all the '<em><b>Enum Bug Enum</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final EnumBugEnum[] VALUES_ARRAY =
    new EnumBugEnum[]
    {
      ARRAY,
      OBJECT,
      RESULT_SET,
      ITERATOR,
    };

  /**
   * A public read-only list of all the '<em><b>Enum Bug Enum</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<EnumBugEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Enum Bug Enum</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static EnumBugEnum get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      EnumBugEnum result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Enum Bug Enum</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static EnumBugEnum getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      EnumBugEnum result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Enum Bug Enum</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static EnumBugEnum get(int value)
  {
    switch (value)
    {
      case ARRAY_VALUE: return ARRAY;
      case OBJECT_VALUE: return OBJECT;
      case RESULT_SET_VALUE: return RESULT_SET;
      case ITERATOR_VALUE: return ITERATOR;
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
  private EnumBugEnum(int value, String name, String literal)
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
  
} //EnumBugEnum

/**
 */
package org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Kind Of Keyword</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EnumAndReferenceTestLanguagePackage#getKindOfKeyword()
 * @model
 * @generated
 */
public enum KindOfKeyword implements Enumerator
{
  /**
   * The '<em><b>Kind Of Keyword</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #KIND_OF_KEYWORD_VALUE
   * @generated
   * @ordered
   */
  KIND_OF_KEYWORD(0, "kindOfKeyword", "kindOfKeyword"),

  /**
   * The '<em><b>Another Enum Literal</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ANOTHER_ENUM_LITERAL_VALUE
   * @generated
   * @ordered
   */
  ANOTHER_ENUM_LITERAL(1, "anotherEnumLiteral", "anotherEnumLiteral");

  /**
   * The '<em><b>Kind Of Keyword</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Kind Of Keyword</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #KIND_OF_KEYWORD
   * @model name="kindOfKeyword"
   * @generated
   * @ordered
   */
  public static final int KIND_OF_KEYWORD_VALUE = 0;

  /**
   * The '<em><b>Another Enum Literal</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Another Enum Literal</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ANOTHER_ENUM_LITERAL
   * @model name="anotherEnumLiteral"
   * @generated
   * @ordered
   */
  public static final int ANOTHER_ENUM_LITERAL_VALUE = 1;

  /**
   * An array of all the '<em><b>Kind Of Keyword</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final KindOfKeyword[] VALUES_ARRAY =
    new KindOfKeyword[]
    {
      KIND_OF_KEYWORD,
      ANOTHER_ENUM_LITERAL,
    };

  /**
   * A public read-only list of all the '<em><b>Kind Of Keyword</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<KindOfKeyword> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Kind Of Keyword</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static KindOfKeyword get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      KindOfKeyword result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Kind Of Keyword</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static KindOfKeyword getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      KindOfKeyword result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Kind Of Keyword</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static KindOfKeyword get(int value)
  {
    switch (value)
    {
      case KIND_OF_KEYWORD_VALUE: return KIND_OF_KEYWORD;
      case ANOTHER_ENUM_LITERAL_VALUE: return ANOTHER_ENUM_LITERAL;
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
  private KindOfKeyword(int value, String name, String literal)
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
  
} //KindOfKeyword

/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExistingEnum.java,v 1.1 2010/02/04 09:24:54 sefftinge Exp $
 */
package org.eclipse.xtext.enumrules.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Existing Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.enumrules.enums.EnumsPackage#getExistingEnum()
 * @model
 * @generated
 */
public enum ExistingEnum implements Enumerator {
	/**
	 * The '<em><b>Same Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAME_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	SAME_NAME(3, "SameName", "SameName"),

	/**
	 * The '<em><b>Overridden Literal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDDEN_LITERAL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDDEN_LITERAL(2, "OverriddenLiteral", "OtherLiteral"),

	/**
	 * The '<em><b>Different Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIFFERENT_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	DIFFERENT_NAME(1, "DifferentName", "DifferentLiteral");

	/**
	 * The '<em><b>Same Name</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Same Name</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SAME_NAME
	 * @model name="SameName"
	 * @generated
	 * @ordered
	 */
	public static final int SAME_NAME_VALUE = 3;

	/**
	 * The '<em><b>Overridden Literal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Overridden Literal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDDEN_LITERAL
	 * @model name="OverriddenLiteral" literal="OtherLiteral"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDDEN_LITERAL_VALUE = 2;

	/**
	 * The '<em><b>Different Name</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Different Name</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIFFERENT_NAME
	 * @model name="DifferentName" literal="DifferentLiteral"
	 * @generated
	 * @ordered
	 */
	public static final int DIFFERENT_NAME_VALUE = 1;

	/**
	 * An array of all the '<em><b>Existing Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ExistingEnum[] VALUES_ARRAY =
		new ExistingEnum[] {
			SAME_NAME,
			OVERRIDDEN_LITERAL,
			DIFFERENT_NAME,
		};

	/**
	 * A public read-only list of all the '<em><b>Existing Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ExistingEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Existing Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExistingEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExistingEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Existing Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExistingEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExistingEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Existing Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExistingEnum get(int value) {
		switch (value) {
			case SAME_NAME_VALUE: return SAME_NAME;
			case OVERRIDDEN_LITERAL_VALUE: return OVERRIDDEN_LITERAL;
			case DIFFERENT_NAME_VALUE: return DIFFERENT_NAME;
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
	private ExistingEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ExistingEnum

/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.jvm

import com.intellij.psi.impl.java.stubs.JavaClassElementType
import com.intellij.psi.impl.java.stubs.JavaFieldStubElementType
import com.intellij.psi.impl.java.stubs.JavaMethodElementType
import com.intellij.psi.impl.source.tree.JavaElementType
import com.intellij.psi.impl.source.tree.java.AnnotationMethodElement
import com.intellij.psi.impl.source.tree.java.AnonymousClassElement
import com.intellij.psi.impl.source.tree.java.ClassElement
import com.intellij.psi.impl.source.tree.java.EnumConstantElement
import com.intellij.psi.impl.source.tree.java.EnumConstantInitializerElement
import com.intellij.psi.impl.source.tree.java.FieldElement
import com.intellij.psi.impl.source.tree.java.MethodElement
import com.intellij.psi.impl.source.tree.java.ParameterElement

/**
 * @author kosyakov - Initial contribution and API
 */
interface JvmElementTypes {
	val PARAMETER = new JavaClassElementType('PARAMETER') {

		override createCompositeNode() {
			new ParameterElement(JavaElementType.PARAMETER) {

				override protected createPsiNoLock() {
					new JvmPsiParameterImpl(this)
				}

			}
		}

	}
	val RECEIVER_PARAMETER = new JavaClassElementType('RECEIVER_PARAMETER') {

		override createCompositeNode() {
			new ParameterElement(JavaElementType.RECEIVER_PARAMETER) {

				override protected createPsiNoLock() {
					new JvmPsiReceiverParameterImpl(this)
				}

			}
		}

	}
	val CLASS = new JavaClassElementType('CLASS') {

		override createCompositeNode() {
			new ClassElement(JavaElementType.CLASS) {

				override protected createPsiNoLock() {
					new JvmPsiClassImpl(this)
				}

			}
		}

	}
	val ANONYMOUS_CLASS = new JavaClassElementType('ANONYMOUS_CLASS') {

		override createCompositeNode() {
			new AnonymousClassElement() {

				override protected createPsiNoLock() {
					new JvmPsiAnonymousClassImpl(this)
				}

			}
		}

	}
	val ENUM_CONSTANT_INITIALIZER = new JavaClassElementType('ENUM_CONSTANT_INITIALIZER') {

		override createCompositeNode() {
			new EnumConstantInitializerElement() {

				override protected createPsiNoLock() {
					new JvmPsiEnumConstantInitializerImpl(this)
				}

			}
		}
	}
	val METHOD = new JavaMethodElementType('METHOD') {

		override createCompositeNode() {
			new MethodElement() {

				override protected createPsiNoLock() {
					new JvmPsiMethodImpl(this)
				}

			}
		}

	}
	val ANNOTATION_METHOD = new JavaMethodElementType('ANNOTATION_METHOD') {

		override createCompositeNode() {
			new AnnotationMethodElement() {

				override protected createPsiNoLock() {
					new JvmPsiAnnotationMethodImpl(this)
				}

			}
		}

	}
	val FIELD = new JavaFieldStubElementType('FIELD') {

		override createCompositeNode() {
			new FieldElement() {

				override protected createPsiNoLock() {
					new JvmPsiFieldImpl(this)
				}

			}
		}

	}
	val ENUM_CONSTANT = new JavaFieldStubElementType('ENUM_CONSTANT') {

		override createCompositeNode() {
			new EnumConstantElement() {

				override protected createPsiNoLock() {
					new JvmPsiEnumConstantImpl(this)
				}

			}
		}

	}
}
/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.java.stubs.JavaClassElementType;
import com.intellij.psi.impl.java.stubs.JavaFieldStubElementType;
import com.intellij.psi.impl.java.stubs.JavaMethodElementType;
import com.intellij.psi.impl.source.tree.JavaElementType;
import com.intellij.psi.impl.source.tree.java.AnnotationMethodElement;
import com.intellij.psi.impl.source.tree.java.AnonymousClassElement;
import com.intellij.psi.impl.source.tree.java.ClassElement;
import com.intellij.psi.impl.source.tree.java.EnumConstantElement;
import com.intellij.psi.impl.source.tree.java.EnumConstantInitializerElement;
import com.intellij.psi.impl.source.tree.java.FieldElement;
import com.intellij.psi.impl.source.tree.java.MethodElement;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiAnnotationMethodImpl;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiAnonymousClassImpl;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiClassImpl;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiEnumConstantImpl;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiEnumConstantInitializerImpl;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiFieldImpl;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiMethodImpl;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public interface JvmStubElementTypes {
  public final static JavaClassElementType CLASS = new JavaClassElementType("CLASS") {
    @Override
    public ASTNode createCompositeNode() {
      return new ClassElement(JavaElementType.CLASS) {
        @Override
        protected PsiElement createPsiNoLock() {
          return new JvmPsiClassImpl(this);
        }
      };
    }
  };
  
  public final static JavaClassElementType ANONYMOUS_CLASS = new JavaClassElementType("ANONYMOUS_CLASS") {
    @Override
    public ASTNode createCompositeNode() {
      return new AnonymousClassElement() {
        @Override
        protected PsiElement createPsiNoLock() {
          return new JvmPsiAnonymousClassImpl(this);
        }
      };
    }
  };
  
  public final static JavaClassElementType ENUM_CONSTANT_INITIALIZER = new JavaClassElementType("ENUM_CONSTANT_INITIALIZER") {
    @Override
    public ASTNode createCompositeNode() {
      return new EnumConstantInitializerElement() {
        @Override
        protected PsiElement createPsiNoLock() {
          return new JvmPsiEnumConstantInitializerImpl(this);
        }
      };
    }
  };
  
  public final static JavaMethodElementType METHOD = new JavaMethodElementType("METHOD") {
    @Override
    public ASTNode createCompositeNode() {
      return new MethodElement() {
        @Override
        protected PsiElement createPsiNoLock() {
          return new JvmPsiMethodImpl(this);
        }
      };
    }
  };
  
  public final static JavaMethodElementType ANNOTATION_METHOD = new JavaMethodElementType("ANNOTATION_METHOD") {
    @Override
    public ASTNode createCompositeNode() {
      return new AnnotationMethodElement() {
        @Override
        protected PsiElement createPsiNoLock() {
          return new JvmPsiAnnotationMethodImpl(this);
        }
      };
    }
  };
  
  public final static JavaFieldStubElementType FIELD = new JavaFieldStubElementType("FIELD") {
    @Override
    public ASTNode createCompositeNode() {
      return new FieldElement() {
        @Override
        protected PsiElement createPsiNoLock() {
          return new JvmPsiFieldImpl(this);
        }
      };
    }
  };
  
  public final static JavaFieldStubElementType ENUM_CONSTANT = new JavaFieldStubElementType("ENUM_CONSTANT") {
    @Override
    public ASTNode createCompositeNode() {
      return new EnumConstantElement() {
        @Override
        protected PsiElement createPsiNoLock() {
          return new JvmPsiEnumConstantImpl(this);
        }
      };
    }
  };
}

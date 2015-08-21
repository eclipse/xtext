/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.clazz;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.binary.asm.JvmDeclaredTypeBuilder;
import org.eclipse.xtext.common.types.access.reflect.ReflectURIHelper;
import org.eclipse.xtext.common.types.access.reflect.ReflectionTypeFactory;
import org.objectweb.asm.ClassReader;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;
import com.google.common.io.ByteStreams;

/*

WITH URIs

 0% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Asm3CommonTypes, type=OBJECT} 38859.58 ns; ?=170.46 ns @ 3 trials
 6% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=JdtCommonTypes, type=OBJECT} 33383.66 ns; ?=354.06 ns @ 10 trials
11% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Reflection, type=OBJECT} 42494.99 ns; ?=414.42 ns @ 10 trials
17% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Asm3CommonTypes, type=STRING} 206441.07 ns; ?=1766.40 ns @ 3 trials
22% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=JdtCommonTypes, type=STRING} 193156.49 ns; ?=2192.49 ns @ 10 trials
28% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Reflection, type=STRING} 203675.14 ns; ?=2032.57 ns @ 4 trials
33% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Asm3CommonTypes, type=JBUTTON} 47535.38 ns; ?=218.99 ns @ 3 trials
39% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=JdtCommonTypes, type=JBUTTON} 47597.68 ns; ?=246.56 ns @ 3 trials
44% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Reflection, type=JBUTTON} 55266.95 ns; ?=674.90 ns @ 10 trials
50% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Asm3CommonTypes, type=JCOMPONENT} 450306.87 ns; ?=7426.91 ns @ 10 trials
56% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=JdtCommonTypes, type=JCOMPONENT} 494231.99 ns; ?=18851.32 ns @ 10 trials
61% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Reflection, type=JCOMPONENT} 559264.44 ns; ?=16221.34 ns @ 10 trials
67% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Asm3CommonTypes, type=ABSTRACT_MULTIMAP} 174557.41 ns; ?=3202.01 ns @ 10 trials
72% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=JdtCommonTypes, type=ABSTRACT_MULTIMAP} 184771.19 ns; ?=1683.71 ns @ 3 trials
78% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Reflection, type=ABSTRACT_MULTIMAP} 4665091.40 ns; ?=221818.26 ns @ 10 trials
83% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Asm3CommonTypes, type=XTEND_PARSER} 3354051.34 ns; ?=9171.65 ns @ 3 trials
89% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=JdtCommonTypes, type=XTEND_PARSER} 4410670.89 ns; ?=29129.07 ns @ 3 trials
94% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Reflection, type=XTEND_PARSER} 3002309.09 ns; ?=13633.44 ns @ 3 trials

             type  implementation     us linear runtime
           OBJECT Asm3CommonTypes   38.9 =
           OBJECT  JdtCommonTypes   33.4 =
           OBJECT      Reflection   42.5 =
           STRING Asm3CommonTypes  206.4 =
           STRING  JdtCommonTypes  193.2 =
           STRING      Reflection  203.7 =
          JBUTTON Asm3CommonTypes   47.5 =
          JBUTTON  JdtCommonTypes   47.6 =
          JBUTTON      Reflection   55.3 =
       JCOMPONENT Asm3CommonTypes  450.3 ==
       JCOMPONENT  JdtCommonTypes  494.2 ===
       JCOMPONENT      Reflection  559.3 ===
ABSTRACT_MULTIMAP Asm3CommonTypes  174.6 =
ABSTRACT_MULTIMAP  JdtCommonTypes  184.8 =
ABSTRACT_MULTIMAP      Reflection 4665.1 ==============================
     XTEND_PARSER Asm3CommonTypes 3354.1 =====================
     XTEND_PARSER  JdtCommonTypes 4410.7 ============================
     XTEND_PARSER      Reflection 3002.3 ===================


WITHOUT URI:

 0% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Asm3CommonTypes, type=OBJECT} 11538.43 ns; ?=105.42 ns @ 4 trials
17% Scenario{vm=java7, trial=0, benchmark=Parse, implementation=Asm3CommonTypes, type=STRING} 124029.85 ns; ?=3290.40 ns @ 10 trials

WITH BINARY URI:

 */

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeFactoryBenchmark extends SimpleBenchmark {

	public enum Impl {
		Asm3CommonTypes {
			
			@Override
			int parse(final byte[] bytes, Class<?> c) {
				JvmDeclaredTypeBuilder builder = new JvmDeclaredTypeBuilder(null, null, null) {
					@Override
					public JvmDeclaredType buildType() {
						ClassReader reader = new ClassReader(bytes);
						reader.accept(this, 
							  ClassReader.SKIP_DEBUG 
							| ClassReader.SKIP_FRAMES 
							| ClassReader.SKIP_CODE
						);
						return result;
					}
					@Override
					public void visitInnerClass(String name, String outerName, String innerName, int access) {
						// nothing to do
					}
				};
				JvmDeclaredType result = builder.buildType();
				return result.getMembers().size();
			}
			
		},
		Reflection {
			
			@Override
			int parse(byte[] bytes, Class<?> c) {
				ReflectionTypeFactory factory = new ReflectionTypeFactory(new ReflectURIHelper()) {
					@Override
					protected void createNestedTypes(Class<?> clazz, JvmDeclaredType result) {
						// nothing to do
					}
				};
				JvmDeclaredType result = factory.createType(c);
				return result.getMembers().size();
			}
			
		},
//		Jdt {
//
//			@Override
//			int parse(byte[] bytes) {
//				try {
//					ClassFileReader result = new ClassFileReader(bytes, CharOperation.NO_CHAR, true);
//					IBinaryField[] fields = result.getFields();
//					if (fields != null)
//						return fields.length;
//					return 0;
//				} catch (ClassFormatException e) {
//					throw new RuntimeException(e);
//				}
//			}
//			
//		},
//		Asm_skip_all {
//
//			@Override
//			int parse(byte[] bytes) {
//				ClassNode node = new ClassNode();
//				ClassReader reader = new ClassReader(bytes);
//				reader.accept(node, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES | ClassReader.SKIP_CODE);
//				return node.fields.size();
//			}
//			
//		},
//		Asm_include_all {
//
//			@Override
//			int parse(byte[] bytes) {
//				ClassNode node = new ClassNode();
//				ClassReader reader = new ClassReader(bytes);
//				reader.accept(node, 0);
//				return node.fields.size();
//			}
//			
//		},
//		Asm3 {
//			
//			@Override
//			int parse(byte[] bytes) {
//				org.objectweb.asm3.tree.ClassNode node = new org.objectweb.asm3.tree.ClassNode();
//				org.objectweb.asm3.ClassReader reader = new org.objectweb.asm3.ClassReader(bytes);
//				reader.accept(node, org.objectweb.asm3.ClassReader.SKIP_CODE | org.objectweb.asm3.ClassReader.SKIP_FRAMES | org.objectweb.asm3.ClassReader.SKIP_DEBUG);
//				return node.fields.size();
//			}
//			
//		},
//		Asm4_2 {
//
//			@Override
//			int parse(byte[] bytes) {
//				org.objectweb.asm4.tree.ClassNode node = new org.objectweb.asm4.tree.ClassNode();
//				org.objectweb.asm4.ClassReader reader = new org.objectweb.asm4.ClassReader(bytes);
//				reader.accept(node, org.objectweb.asm4.ClassReader.SKIP_CODE | org.objectweb.asm4.ClassReader.SKIP_FRAMES | org.objectweb.asm4.ClassReader.SKIP_DEBUG);
//				return node.fields.size();
//			}
//			
//		},
//		Asm5 {
//
//			@Override
//			int parse(byte[] bytes) {
//				org.objectweb.asm5.tree.ClassNode node = new org.objectweb.asm5.tree.ClassNode();
//				org.objectweb.asm5.ClassReader reader = new org.objectweb.asm5.ClassReader(bytes);
//				reader.accept(node, org.objectweb.asm5.ClassReader.SKIP_CODE | org.objectweb.asm5.ClassReader.SKIP_FRAMES | org.objectweb.asm5.ClassReader.SKIP_DEBUG);
//				return node.fields.size();
//			}
//			
//		},
		;
		abstract int parse(byte[] bytes, Class<?> c);
	}
	
	public enum Type {
		OBJECT {
			@Override
			Class<?> getType() {
				return Object.class;
			}
		},
		STRING {
			
			@Override
			Class<?> getType() {
				return String.class;
			}
			
		},
		JBUTTON {
			
			@Override
			Class<?> getType() {
				return JButton.class;
			}
			
		},
		JCOMPONENT {
			
			@Override
			Class<?> getType() {
				return JComponent.class;
			}
			
		},
		ABSTRACT_MULTIMAP {
			
			@Override
			Class<?> getType() {
				try {
					return Class.forName("com.google.common.collect.AbstractMultimap");
				} catch (ClassNotFoundException e) {
					throw new RuntimeException();
				}
			}
			
		},
		XTEND_PARSER {

			@Override
			Class<?> getType() {
				return org.eclipse.xtend.ide.common.contentassist.antlr.internal.InternalXtendParser.class;
			}
			
		}
		;
		abstract Class<?> getType();
		byte[] getBytes() {
			try {
				return ByteStreams.toByteArray(getClass().getClassLoader().getResourceAsStream(getType().getName().replace('.', '/') + ".class"));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	@Param
	Impl implementation;
	@Param
	Type type;
	
	byte[] bytes;
	
	@Override
	protected void setUp() throws Exception {
		bytes = type.getBytes(); 
	}

	public int timeParse(int reps) {
		Class<?> c = type.getType();
		int result = 0;
		for (int i = 0; i < reps; i++) {
			result += implementation.parse(bytes, c);
		}
		return result;
	}

	public static void main(String[] args) {
		Runner.main(TypeFactoryBenchmark.class, args);
	}

}

/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import org.junit.Test

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class AnnotationWithNestedAnnotationsProcessorTest extends AbstractActiveAnnotationTest {
	
	@Test def void testIssue624() {
		// no errors expected
		'''
		@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations$Annotation1(
			ann2=@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations$Annotation2(
				ann3=#[]
			)
		)
		class Entity {
		}
		
		@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations$Annotation1(
				ann2=@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations$Annotation2(
					ann3=#[
						@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations$Annotation3,
						@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations$Annotation3
					]
			)
		)
		class Entity2 {
		}
		
		'''.assertCompilesTo('''
		MULTIPLE FILES WERE GENERATED
		
		File 1 : /myProject/xtend-gen/Entity.java
		
		import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations;
		
		@AnnotationWithNestedAnnotations.Annotation1(ann2 = @AnnotationWithNestedAnnotations.Annotation2(ann3 = {}))
		@SuppressWarnings("all")
		public class Entity {
		}
		
		File 2 : /myProject/xtend-gen/Entity2.java
		
		import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations;
		
		@AnnotationWithNestedAnnotations.Annotation1(ann2 = @AnnotationWithNestedAnnotations.Annotation2(ann3 = { @AnnotationWithNestedAnnotations.Annotation3, @AnnotationWithNestedAnnotations.Annotation3 }))
		@SuppressWarnings("all")
		public class Entity2 {
		}
		
		''')
		
	}
	
}
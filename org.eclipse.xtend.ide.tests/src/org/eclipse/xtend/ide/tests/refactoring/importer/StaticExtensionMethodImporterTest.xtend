/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring.importer

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.Before
import org.junit.Test
import org.junit.Ignore

/**
 * @author vivien.jovet - Initial contribution and API
 */
class StaticExtensionMethodImporterTest extends AbstractXtendUITestCase {

    @Inject
    extension StaticExtensionMethodImporterTestBuilder builder

    @Inject
    extension WorkbenchTestHelper testHelper

    @Before
    def void setupTestClass() {
        'test/other/Other.xtend'.createFile('''
            package test.other
            
            class Other {
                def static String doSomething(String arg0) {}
                def static String doSomething(String arg0, String arg1) {}
                def static void doSomething(int arg0) {}
            }
        ''')
    }

    @Test
    def void testSingleStaticMethod() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    Other.doSo|mething('test')
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    'test'.doSomething()
                }
            }
        ''')
    }

    @Test
    def void testMultiStaticMethod() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
            
                val test = Other.doSomething('test0')
            
                def test1() {
                    Other.doSomething('test1')
                }
            
                def test2() {
                    Other.d|oSomething('test2')
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
            
                val test = 'test0'.doSomething()
            
                def test1() {
                    'test1'.doSomething()
                }
            
                def test2() {
                    'test2'.doSomething()
                }
            }
        ''')
    }

    @Ignore('Failing because of a bug in the import organizer')
    @Test
    def void testSingleExplicitStaticMethod() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    Other::doSo|mething('test')
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    'test'::doSomething()
                }
            }
        ''')
    }

    @Ignore('Failing because of a bug in the import organizer')
    @Test
    def void testMultiExplicitStaticMethod() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
            
                val test = Other::doSomething('test0')
            
                def test1() {
                    Other::doSomething('test1')
                }
            
                def test2() {
                    Other::d|oSomething('test2')
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
            
                val test = 'test0'::doSomething()
            
                def test1() {
                    'test1'::doSomething()
                }
            
                def test2() {
                    'test2'::doSomething()
                }
            }
        ''')
    }

    @Test
    def void testMultiMixExplicitStaticMethod() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
            
                val test = Other.doSomething('test0')
            
                def test1() {
                    Other::doSomething('test1')
                }
            
                def test2() {
                    Other.d|oSomething('test2')
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
            
                val test = 'test0'.doSomething()
            
                def test1() {
                    'test1'::doSomething()
                }
            
                def test2() {
                    'test2'.doSomething()
                }
            }
        ''')
    }

    @Test
    def void testStaticMethodsDifferentArgs() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    Other.doSo|mething('test')
                    Other.doSomething('test', 'test')
                }
            }
        ''').assertResult('''
            package test
            
            import test.other.Other
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    'test'.doSomething()
                    Other.doSomething('test', 'test')
                }
            }
        ''')
    }

    @Test
    def void testStaticMethodInLambda() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    #['1', '2', '3'].forEach[Other.doSo|mething(it)]
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    #['1', '2', '3'].forEach[it.doSomething()]
                }
            }
        ''')
    }

    @Test
    def void testStaticMethodInBrackets() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    (Other.doSo|mething('test'))
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    ('test'.doSomething())
                }
            }
        ''')
    }

    @Test
    def void testStaticMethodMultiClass() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    Other.doSo|mething('test')
                    Other.doSomething('test')
                }
            }
            
            class Test2 {
                def test2() {
                    Other.doSomething('test')
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    'test'.doSomething()
                    'test'.doSomething()
                }
            }
            
            class Test2 {
                def test2() {
                    'test'.doSomething()
                }
            }
        ''')
    }

    @Test
    def void testStaticMethodNested() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    Other.doSomething(
                        Other.doSomething(Other.doSome|thing('test'))
                    )
                }
            }
        ''').assertResult('''
            package test
            
            import test.other.Other
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    Other.doSomething(
                        Other.doSomething('test'.doSomething())
                    )
                }
            }
        ''')
    }

    @Test
    def void testStaticMethodInSwith() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    switch(Other.doSo|mething('test')) {
                    }
                    switch Other.doSomething('test') {
                    }
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    switch('test'.doSomething()) {
                    }
                    switch 'test'.doSomething() {
                    }
                }
            }
        ''')
    }

    @Test
    def void testStaticMethodInIf() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    if(Other.doSo|mething('test') !== null) {
                    }
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    if('test'.doSomething() !== null) {
                    }
                }
            }
        ''')
    }

    @Test
    def void testBadFormat() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    Other .      doSo|mething('test')
                    Other.
                    doSomething('test')
                    Other
                         .doSomething('test')
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    'test' .      doSomething()
                    'test'.
                    doSomething()
                    'test'
                         .doSomething()
                }
            }
        ''')
    }

    @Test
    def void testInComments() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    // Other.doSomething('test')
                    /* Other.doSomething('test') */
                    Other /* test */ .doSo|mething('test')
                    Other. /* test */ doSomething('test')
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    // Other.doSomething('test')
                    /* Other.doSomething('test') */
                    'test' /* test */ .doSomething()
                    'test'. /* test */ doSomething()
                }
            }
        ''')
    }
    
    @Test
    def void testWithVarParam() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    var i = 0
                    Other.doSo|mething(i)
                    Other.doSomething(i++)
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    var i = 0
                    i.doSomething()
                    (i++).doSomething()
                }
            }
        ''')
    }
    
    @Test
    def void testWithMethodCallParam() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    Other.doSome|thing(String.valueOf(true))
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    String.valueOf(true).doSomething()
                }
            }
        ''')
    }
    
    @Test
    def void testWithVarAssigment() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    var i = 0
                    Other.doSom|ething(i++)
                    Other.doSomething(i = 1)
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    var i = 0
                    (i++).doSomething()
                    (i = 1).doSomething()
                }
            }
        ''')
    }
    
    @Test
    def void testWithExpression() {
        'test/Test.xtend'.create('''
            package test
            
            import test.other.Other
            
            class Test {
                def test() {
                    Other.doSo|mething('test' + 'test')
                }
            }
        ''').assertResult('''
            package test
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    ('test' + 'test').doSomething()
                }
            }
        ''')
    }
    
    @Test
    def void testWithComplexExpressions() {
        'test/Test.xtend'.create('''
            package test
            
            import java.io.ByteArrayInputStream
            import test.other.Other
            
            class Test {
                def test() {
                    val test = 'test'
                    Other.doSo|mething(test + 'test')
                    Other.doSomething(switch test { case 'test': 'blah' default: 'default' })
                    Other.doSomething(if(test == 'something') 'test')
                    Other.doSomething(try(val in = new ByteArrayInputStream('test'.bytes)) { 'test' })
                    Other.doSomething(true?'test':'other')
                }
            }
        ''').assertResult('''
            package test

            import java.io.ByteArrayInputStream
            
            import static extension test.other.Other.doSomething
            
            class Test {
                def test() {
                    val test = 'test'
                    (test + 'test').doSomething()
                    (switch test { case 'test': 'blah' default: 'default' }).doSomething()
                    (if(test == 'something') 'test').doSomething()
                    (try(val in = new ByteArrayInputStream('test'.bytes)) { 'test' }).doSomething()
                    (true?'test':'other').doSomething()
                }
            }
        ''')
    }

}

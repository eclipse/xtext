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

/**
 * @author vivien.jovet - Initial contribution and API
 */
class StaticMethodImporterTest extends AbstractXtendUITestCase {

    @Inject
    extension StaticMethodImporterTestBuilder builder

    @Inject
    extension WorkbenchTestHelper testHelper

    @Before
    def void setupTestClass() {
        'test/other/Other.xtend'.createFile('''
            package test.other
            
            class Other {
                def static String doSomething(String arg0) {}
                def static String doSomething(String arg0, String arg1) {}
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
            
            import static test.other.Other.doSomething
            
            class Test {
                def test() {
                    doSomething('test')
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
            
            import static test.other.Other.doSomething
            
            class Test {

                val test = doSomething('test0')

                def test1() {
                    doSomething('test1')
                }

                def test2() {
                    doSomething('test2')
                }
            }
        ''')
    }

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
            
            import static test.other.Other.doSomething
            
            class Test {
                def test() {
                    doSomething('test')
                }
            }
        ''')
    }
    
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
            
            import static test.other.Other.doSomething
            
            class Test {

                val test = doSomething('test0')

                def test1() {
                    doSomething('test1')
                }

                def test2() {
                    doSomething('test2')
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
            
            import static test.other.Other.doSomething
            
            class Test {

                val test = doSomething('test0')

                def test1() {
                    doSomething('test1')
                }

                def test2() {
                    doSomething('test2')
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
            
            import static test.other.Other.doSomething
            
            class Test {
                def test() {
                    doSomething('test')
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

            import static test.other.Other.doSomething
            
            class Test {
                def test() {
                    #['1', '2', '3'].forEach[doSomething(it)]
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

            import static test.other.Other.doSomething
            
            class Test {
                def test() {
                    (doSomething('test'))
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
            
            import static test.other.Other.doSomething
            
            class Test {
                def test() {
                    doSomething('test')
                    doSomething('test')
                }
            }
            
            class Test2 {
                def test2() {
                    doSomething('test')
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
                    Other.doSo|mething(
                        Other.doSomething(Other.doSomething('test'))
                    )
                }
            }
        ''').assertResult('''
            package test
            
            import static test.other.Other.doSomething
            
            class Test {
                def test() {
                    doSomething(
                        doSomething(doSomething('test'))
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
            
            import static test.other.Other.doSomething
            
            class Test {
                def test() {
                    switch(doSomething('test')) {
                    }
                    switch doSomething('test') {
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
            
            import static test.other.Other.doSomething
            
            class Test {
                def test() {
                    if(doSomething('test') !== null) {
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
            
            import static test.other.Other.doSomething
            
            class Test {
                def test() {
                           doSomething('test')
                    
                    doSomething('test')
                    
                         doSomething('test')
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
            
            import static test.other.Other.doSomething
            
            class Test {
                def test() {
                    // Other.doSomething('test')
                    /* Other.doSomething('test') */
                     /* test */ doSomething('test')
                     /* test */ doSomething('test')
                }
            }
        ''')
    }

}

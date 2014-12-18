/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug435473Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			import java.util.List
			class Outer {
				val List<Functions.Function0<?>> x = #[[|1],  [|1.0]]
			}
		''', '''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final List<Function0<?>> x = Collections.<Function0<?>>unmodifiableList(CollectionLiterals.<Function0<?>>newArrayList(new Function0<Object>() {
			    public Object apply() {
			      return Integer.valueOf(1);
			    }
			  }, new Function0<Object>() {
			    public Object apply() {
			      return Double.valueOf(1.0);
			    }
			  }));
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			import java.util.List
			class Outer {
				val List<Functions.Function0<? extends Number>> x = #[[|1],  [|1.0]]
			}
		''', '''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final List<Function0<? extends Number>> x = Collections.<Function0<? extends Number>>unmodifiableList(CollectionLiterals.<Function0<? extends Number>>newArrayList(new Function0<Number>() {
			    public Number apply() {
			      return Integer.valueOf(1);
			    }
			  }, new Function0<Number>() {
			    public Number apply() {
			      return Double.valueOf(1.0);
			    }
			  }));
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			import java.util.List
			class Outer {
				val List<? extends Functions.Function0<? extends Number>> x = #[[|1],  [|1.0]]
			}
		''', '''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final List<? extends Function0<? extends Number>> x = Collections.<Function0<? extends Number>>unmodifiableList(CollectionLiterals.<Function0<? extends Number>>newArrayList(new Function0<Number>() {
			    public Number apply() {
			      return Integer.valueOf(1);
			    }
			  }, new Function0<Number>() {
			    public Number apply() {
			      return Double.valueOf(1.0);
			    }
			  }));
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			import java.util.List
			class Outer {
				val List<? extends Functions.Function0<Number>> x = #[[|1],  [|1.0]]
			}
		''', '''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final List<? extends Function0<Number>> x = Collections.<Function0<Number>>unmodifiableList(CollectionLiterals.<Function0<Number>>newArrayList(new Function0<Number>() {
			    public Number apply() {
			      return Integer.valueOf(1);
			    }
			  }, new Function0<Number>() {
			    public Number apply() {
			      return Double.valueOf(1.0);
			    }
			  }));
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			import java.util.Set
			class Outer {
				val Set<Functions.Function0<? extends Number>> x = #{ [|1],  [|1.0] }
			}
		''', '''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final Set<Function0<? extends Number>> x = Collections.<Function0<? extends Number>>unmodifiableSet(CollectionLiterals.<Function0<? extends Number>>newHashSet(new Function0<Number>() {
			    public Number apply() {
			      return Integer.valueOf(1);
			    }
			  }, new Function0<Number>() {
			    public Number apply() {
			      return Double.valueOf(1.0);
			    }
			  }));
			}
		''')
	}
	
	@Test
	def test_06() {
		assertCompilesTo('''
			import java.util.Set
			class Outer {
				val Set<Functions.Function0<Number>> x = #{ [|1],  [|1.0] }
			}
		''', '''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final Set<Function0<Number>> x = Collections.<Function0<Number>>unmodifiableSet(CollectionLiterals.<Function0<Number>>newHashSet(new Function0<Number>() {
			    public Number apply() {
			      return Integer.valueOf(1);
			    }
			  }, new Function0<Number>() {
			    public Number apply() {
			      return Double.valueOf(1.0);
			    }
			  }));
			}
		''')
	}
	
	@Test
	def test_07() {
		assertCompilesTo('''
			import java.util.Set
			class Outer {
				val Set<? extends Functions.Function0<? extends Number>> x = #{ [|1],  [|1.0] }
			}
		''', '''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final Set<? extends Function0<? extends Number>> x = Collections.<Function0<? extends Number>>unmodifiableSet(CollectionLiterals.<Function0<? extends Number>>newHashSet(new Function0<Number>() {
			    public Number apply() {
			      return Integer.valueOf(1);
			    }
			  }, new Function0<Number>() {
			    public Number apply() {
			      return Double.valueOf(1.0);
			    }
			  }));
			}
		''')
	}
	
	@Test
	def test_08() {
		assertCompilesTo('''
			import java.util.Set
			class Outer {
				val Set<? extends Functions.Function0<Number>> x = #{ [|1],  [|1.0] }
			}
		''', '''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final Set<? extends Function0<Number>> x = Collections.<Function0<Number>>unmodifiableSet(CollectionLiterals.<Function0<Number>>newHashSet(new Function0<Number>() {
			    public Number apply() {
			      return Integer.valueOf(1);
			    }
			  }, new Function0<Number>() {
			    public Number apply() {
			      return Double.valueOf(1.0);
			    }
			  }));
			}
		''')
	}
		
}
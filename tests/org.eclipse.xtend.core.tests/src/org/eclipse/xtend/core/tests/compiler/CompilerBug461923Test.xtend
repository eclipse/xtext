/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug461923Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T> m(List<? extends T> list, T value) {
			        ImmutableList.builder.addAll(list.filter[it != value]).build
			    }
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Objects;
			import com.google.common.collect.ImmutableList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public static <T extends Object> ImmutableList<T> m(final List<? extends T> list, final T value) {
			    ImmutableList.Builder<T> _builder = ImmutableList.<T>builder();
			    final Function1<T, Boolean> _function = new Function1<T, Boolean>() {
			      public Boolean apply(final T it) {
			        return Boolean.valueOf((!Objects.equal(it, value)));
			      }
			    };
			    Iterable<? extends T> _filter = IterableExtensions.filter(list, _function);
			    ImmutableList.Builder<T> _addAll = _builder.addAll(_filter);
			    return _addAll.build();
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T> m(List<T> list, T value) {
			        ImmutableList.builder.addAll(list.filter[it != value]).build
			    }
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Objects;
			import com.google.common.collect.ImmutableList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public static <T extends Object> ImmutableList<T> m(final List<T> list, final T value) {
			    ImmutableList.Builder<T> _builder = ImmutableList.<T>builder();
			    final Function1<T, Boolean> _function = new Function1<T, Boolean>() {
			      public Boolean apply(final T it) {
			        return Boolean.valueOf((!Objects.equal(it, value)));
			      }
			    };
			    Iterable<T> _filter = IterableExtensions.<T>filter(list, _function);
			    ImmutableList.Builder<T> _addAll = _builder.addAll(_filter);
			    return _addAll.build();
			  }
			}
		''')
	}
	
	@Test def test_03() {
		'''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T> m(List<? super T> list, T value) {
			        ImmutableList.builder.addAll(list.filter[it != value]).build
			    }
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Objects;
			import com.google.common.collect.ImmutableList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public static <T extends Object> ImmutableList<Object> m(final List<? super T> list, final T value) {
			    ImmutableList.Builder<Object> _builder = ImmutableList.<Object>builder();
			    final Function1<Object, Boolean> _function = new Function1<Object, Boolean>() {
			      public Boolean apply(final Object it) {
			        return Boolean.valueOf((!Objects.equal(it, value)));
			      }
			    };
			    Iterable<? super T> _filter = IterableExtensions.filter(list, _function);
			    ImmutableList.Builder<Object> _addAll = _builder.addAll(_filter);
			    return _addAll.build();
			  }
			}
		''')
	}
	
	@Test def test_04() {
		'''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T> m(List<? extends T> list) {
			        ImmutableList.builder.addAll(list).addAll(list).build
			    }
			}
		'''.assertCompilesTo('''
			import com.google.common.collect.ImmutableList;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public static <T extends Object> ImmutableList<T> m(final List<? extends T> list) {
			    ImmutableList.Builder<T> _builder = ImmutableList.<T>builder();
			    ImmutableList.Builder<T> _addAll = _builder.addAll(list);
			    ImmutableList.Builder<T> _addAll_1 = _addAll.addAll(list);
			    return _addAll_1.build();
			  }
			}
		''')
	}
	
	@Test def test_05() {
		'''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T> m(List<? extends T> list) {
			        ImmutableList.builder.addAll(list.filter[true]).addAll(list).build
			    }
			}
		'''.assertCompilesTo('''
			import com.google.common.collect.ImmutableList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public static <T extends Object> ImmutableList<T> m(final List<? extends T> list) {
			    ImmutableList.Builder<T> _builder = ImmutableList.<T>builder();
			    final Function1<T, Boolean> _function = new Function1<T, Boolean>() {
			      public Boolean apply(final T it) {
			        return Boolean.valueOf(true);
			      }
			    };
			    Iterable<? extends T> _filter = IterableExtensions.filter(list, _function);
			    ImmutableList.Builder<T> _addAll = _builder.addAll(_filter);
			    ImmutableList.Builder<T> _addAll_1 = _addAll.addAll(list);
			    return _addAll_1.build();
			  }
			}
		''')
	}
	
	@Test def test_06() {
		'''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T> m(List<? extends T> list) {
			        ImmutableList.builder.addAll(list).addAll(list.filter[false]).build
			    }
			}
		'''.assertCompilesTo('''
			import com.google.common.collect.ImmutableList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public static <T extends Object> ImmutableList<T> m(final List<? extends T> list) {
			    ImmutableList.Builder<T> _builder = ImmutableList.<T>builder();
			    ImmutableList.Builder<T> _addAll = _builder.addAll(list);
			    final Function1<T, Boolean> _function = new Function1<T, Boolean>() {
			      public Boolean apply(final T it) {
			        return Boolean.valueOf(false);
			      }
			    };
			    Iterable<? extends T> _filter = IterableExtensions.filter(list, _function);
			    ImmutableList.Builder<T> _addAll_1 = _addAll.addAll(_filter);
			    return _addAll_1.build();
			  }
			}
		''')
	}
	
	@Test def test_07() {
		'''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T> m(List<? extends T> list) {
			        ImmutableList.builder.addAll(list.filter[true]).addAll(list.filter[false]).build
			    }
			}
		'''.assertCompilesTo('''
			import com.google.common.collect.ImmutableList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public static <T extends Object> ImmutableList<T> m(final List<? extends T> list) {
			    ImmutableList.Builder<T> _builder = ImmutableList.<T>builder();
			    final Function1<T, Boolean> _function = new Function1<T, Boolean>() {
			      public Boolean apply(final T it) {
			        return Boolean.valueOf(true);
			      }
			    };
			    Iterable<? extends T> _filter = IterableExtensions.filter(list, _function);
			    ImmutableList.Builder<T> _addAll = _builder.addAll(_filter);
			    final Function1<T, Boolean> _function_1 = new Function1<T, Boolean>() {
			      public Boolean apply(final T it) {
			        return Boolean.valueOf(false);
			      }
			    };
			    Iterable<? extends T> _filter_1 = IterableExtensions.filter(list, _function_1);
			    ImmutableList.Builder<T> _addAll_1 = _addAll.addAll(_filter_1);
			    return _addAll_1.build();
			  }
			}
		''')
	}
	
	@Test def test_08() {
		'''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T> m(T[] arr, T value) {
			        ImmutableList.builder.addAll(arr.filter[it != value]).build
			    }
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Objects;
			import com.google.common.collect.ImmutableList;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public static <T extends Object> ImmutableList<T> m(final T[] arr, final T value) {
			    ImmutableList.Builder<T> _builder = ImmutableList.<T>builder();
			    final Function1<T, Boolean> _function = new Function1<T, Boolean>() {
			      public Boolean apply(final T it) {
			        return Boolean.valueOf((!Objects.equal(it, value)));
			      }
			    };
			    Iterable<T> _filter = IterableExtensions.<T>filter(((Iterable<T>)Conversions.doWrapArray(arr)), _function);
			    ImmutableList.Builder<T> _addAll = _builder.addAll(_filter);
			    return _addAll.build();
			  }
			}
		''')
	}
	
}
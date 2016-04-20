/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug458010Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import java.util.function.Consumer
			import java.util.function.Function
			import java.util.function.IntConsumer
			import java.util.function.Predicate
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					roster.processElements(
					    [gender == MALE && age >= 18 && age <= 25],
					    [emailAddress],
					    [println(it)]
					)
				}
				static def <X, Y> void processElements(
					    Iterable<X> source,
					    Predicate<X> tester,
					    Function <X, Y> mapper,
					    Consumer<Y> block) {
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.function.Consumer;
			import java.util.function.Function;
			import java.util.function.Predicate;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    final Predicate<Demo.Person> _function = (Demo.Person it) -> {
			      return ((Objects.equal(it.gender, Demo.Person.Sex.MALE) && (it.getAge() >= 18)) && (it.getAge() <= 25));
			    };
			    final Function<Demo.Person, String> _function_1 = (Demo.Person it) -> {
			      return it.emailAddress;
			    };
			    final Consumer<String> _function_2 = (String it) -> {
			      InputOutput.<String>println(it);
			    };
			    Demo.<Demo.Person, String>processElements(roster, _function, _function_1, _function_2);
			  }
			  
			  public static <X extends Object, Y extends Object> void processElements(final Iterable<X> source, final Predicate<X> tester, final Function<X, Y> mapper, final Consumer<Y> block) {
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					roster
						.stream
					    .filter[gender == MALE && age >= 18 && age <= 25]
					    .map[emailAddress]
					    .forEach[println(it)]
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.function.Consumer;
			import java.util.function.Function;
			import java.util.function.Predicate;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    Stream<Demo.Person> _stream = roster.stream();
			    final Predicate<Demo.Person> _function = (Demo.Person it) -> {
			      return ((Objects.equal(it.gender, Demo.Person.Sex.MALE) && (it.getAge() >= 18)) && (it.getAge() <= 25));
			    };
			    Stream<Demo.Person> _filter = _stream.filter(_function);
			    final Function<Demo.Person, String> _function_1 = (Demo.Person it) -> {
			      return it.emailAddress;
			    };
			    Stream<String> _map = _filter.<String>map(_function_1);
			    final Consumer<String> _function_2 = (String it) -> {
			      InputOutput.<String>println(it);
			    };
			    _map.forEach(_function_2);
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					roster
						.filter[gender == MALE && age >= 18 && age <= 25]
						.map[emailAddress]
						.forEach[println(it)]
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.function.Consumer;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    final Function1<Demo.Person, Boolean> _function = (Demo.Person it) -> {
			      return Boolean.valueOf(((Objects.equal(it.gender, Demo.Person.Sex.MALE) && (it.getAge() >= 18)) && (it.getAge() <= 25)));
			    };
			    Iterable<Demo.Person> _filter = IterableExtensions.<Demo.Person>filter(roster, _function);
			    final Function1<Demo.Person, String> _function_1 = (Demo.Person it) -> {
			      return it.emailAddress;
			    };
			    Iterable<String> _map = IterableExtensions.<Demo.Person, String>map(_filter, _function_1);
			    final Consumer<String> _function_2 = (String it) -> {
			      InputOutput.<String>println(it);
			    };
			    _map.forEach(_function_2);
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					roster
					    .stream
					    .filter[gender == MALE]
					    .mapToInt[age]
					    .average
					    .getAsDouble
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.OptionalDouble;
			import java.util.function.Predicate;
			import java.util.function.ToIntFunction;
			import java.util.stream.IntStream;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    Stream<Demo.Person> _stream = roster.stream();
			    final Predicate<Demo.Person> _function = (Demo.Person it) -> {
			      return Objects.equal(it.gender, Demo.Person.Sex.MALE);
			    };
			    Stream<Demo.Person> _filter = _stream.filter(_function);
			    final ToIntFunction<Demo.Person> _function_1 = (Demo.Person it) -> {
			      return it.getAge();
			    };
			    IntStream _mapToInt = _filter.mapToInt(_function_1);
			    OptionalDouble _average = _mapToInt.average();
			    _average.getAsDouble();
			  }
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import java.util.stream.Collectors
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					roster
					   .stream
					   .map[age]
					   .reduce(0) [$0 + $1]
				}
			}
		''', '''
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.function.BinaryOperator;
			import java.util.function.Function;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    Stream<Demo.Person> _stream = roster.stream();
			    final Function<Demo.Person, Integer> _function = (Demo.Person it) -> {
			      return Integer.valueOf(it.getAge());
			    };
			    Stream<Integer> _map = _stream.<Integer>map(_function);
			    final BinaryOperator<Integer> _function_1 = (Integer $0, Integer $1) -> {
			      return Integer.valueOf((($0).intValue() + ($1).intValue()));
			    };
			    _map.reduce(Integer.valueOf(0), _function_1);
			  }
			}
		''')
	}
	
	@Test
	def test_06_a() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import java.util.function.IntConsumer
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				static class Averager implements IntConsumer {
				    int total = 0
				    int count = 0
				    def average() {
				        if (count > 0) (total as double) / count else 0
				    }
				    override accept(int i) {
				    	total += i
				    	count++
				    }
				    def combine(Averager other) {
				        total += other.total
				        count += other.count
				    }
				}
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					roster
						.stream
					    .filter[gender == MALE]
					    .map[age]
					    .collect(
					    	[new Averager],
					    	[avg, i | avg.accept(i)],          // alternative: [$0.accept($1)]
					    	[avg1, avg2 | avg1.combine(avg2)]) // alternative: [$0.combine($1)]
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.function.BiConsumer;
			import java.util.function.Function;
			import java.util.function.IntConsumer;
			import java.util.function.Predicate;
			import java.util.function.Supplier;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  public static class Averager implements IntConsumer {
			    private int total = 0;
			    
			    private int count = 0;
			    
			    public double average() {
			      double _xifexpression = (double) 0;
			      if ((this.count > 0)) {
			        _xifexpression = (((double) this.total) / this.count);
			      } else {
			        _xifexpression = 0;
			      }
			      return _xifexpression;
			    }
			    
			    @Override
			    public void accept(final int i) {
			      int _tal = this.total;
			      this.total = (_tal + i);
			      this.count++;
			    }
			    
			    public int combine(final Demo.Averager other) {
			      int _xblockexpression = (int) 0;
			      {
			        int _tal = this.total;
			        this.total = (_tal + other.total);
			        int _count = this.count;
			        _xblockexpression = this.count = (_count + other.count);
			      }
			      return _xblockexpression;
			    }
			  }
			  
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    Stream<Demo.Person> _stream = roster.stream();
			    final Predicate<Demo.Person> _function = (Demo.Person it) -> {
			      return Objects.equal(it.gender, Demo.Person.Sex.MALE);
			    };
			    Stream<Demo.Person> _filter = _stream.filter(_function);
			    final Function<Demo.Person, Integer> _function_1 = (Demo.Person it) -> {
			      return Integer.valueOf(it.getAge());
			    };
			    Stream<Integer> _map = _filter.<Integer>map(_function_1);
			    final Supplier<Demo.Averager> _function_2 = () -> {
			      return new Demo.Averager();
			    };
			    final BiConsumer<Demo.Averager, Integer> _function_3 = (Demo.Averager avg, Integer i) -> {
			      avg.accept((i).intValue());
			    };
			    final BiConsumer<Demo.Averager, Demo.Averager> _function_4 = (Demo.Averager avg1, Demo.Averager avg2) -> {
			      avg1.combine(avg2);
			    };
			    _map.<Demo.Averager>collect(_function_2, _function_3, _function_4);
			  }
			}
		''')
	}
	
	@Test
	def test_06_b() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import java.util.function.IntConsumer
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				static class Averager implements IntConsumer {
				    int total = 0
				    int count = 0
				    def average() {
				        if (count > 0) (total as double) / count else 0
				    }
				    override accept(int i) {
				    	total += i
				    	count++
				    }
				    def combine(Averager other) {
				        total += other.total
				        count += other.count
				    }
				}
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(Person[] roster) {
					roster
						.stream
					    .filter[gender == MALE]
					    .map[age]
					    .collect(
					    	[new Averager],
					    	[$0.accept($1)],
					    	[$0.combine($1)])
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.List;
			import java.util.function.BiConsumer;
			import java.util.function.Function;
			import java.util.function.IntConsumer;
			import java.util.function.Predicate;
			import java.util.function.Supplier;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  public static class Averager implements IntConsumer {
			    private int total = 0;
			    
			    private int count = 0;
			    
			    public double average() {
			      double _xifexpression = (double) 0;
			      if ((this.count > 0)) {
			        _xifexpression = (((double) this.total) / this.count);
			      } else {
			        _xifexpression = 0;
			      }
			      return _xifexpression;
			    }
			    
			    @Override
			    public void accept(final int i) {
			      int _tal = this.total;
			      this.total = (_tal + i);
			      this.count++;
			    }
			    
			    public int combine(final Demo.Averager other) {
			      int _xblockexpression = (int) 0;
			      {
			        int _tal = this.total;
			        this.total = (_tal + other.total);
			        int _count = this.count;
			        _xblockexpression = this.count = (_count + other.count);
			      }
			      return _xblockexpression;
			    }
			  }
			  
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final Demo.Person[] roster) {
			    Stream<Demo.Person> _stream = ((List<Demo.Person>)Conversions.doWrapArray(roster)).stream();
			    final Predicate<Demo.Person> _function = (Demo.Person it) -> {
			      return Objects.equal(it.gender, Demo.Person.Sex.MALE);
			    };
			    Stream<Demo.Person> _filter = _stream.filter(_function);
			    final Function<Demo.Person, Integer> _function_1 = (Demo.Person it) -> {
			      return Integer.valueOf(it.getAge());
			    };
			    Stream<Integer> _map = _filter.<Integer>map(_function_1);
			    final Supplier<Demo.Averager> _function_2 = () -> {
			      return new Demo.Averager();
			    };
			    final BiConsumer<Demo.Averager, Integer> _function_3 = (Demo.Averager $0, Integer $1) -> {
			      $0.accept(($1).intValue());
			    };
			    final BiConsumer<Demo.Averager, Demo.Averager> _function_4 = (Demo.Averager $0, Demo.Averager $1) -> {
			      $0.combine($1);
			    };
			    _map.<Demo.Averager>collect(_function_2, _function_3, _function_4);
			  }
			}
		''')
	}
	
	@Test
	def test_07() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import java.util.stream.Collectors
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					roster
					    .stream
					    .filter[gender == MALE]
					    .map[name]
					    .collect(Collectors.toList)
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.List;
			import java.util.function.Function;
			import java.util.function.Predicate;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    Stream<Demo.Person> _stream = roster.stream();
			    final Predicate<Demo.Person> _function = (Demo.Person it) -> {
			      return Objects.equal(it.gender, Demo.Person.Sex.MALE);
			    };
			    Stream<Demo.Person> _filter = _stream.filter(_function);
			    final Function<Demo.Person, String> _function_1 = (Demo.Person it) -> {
			      return it.name;
			    };
			    Stream<String> _map = _filter.<String>map(_function_1);
			    Collector<String, ?, List<String>> _list = Collectors.<String>toList();
			    _map.collect(_list);
			  }
			}
		''')
	}
	
	@Test
	def test_08_a() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import java.util.stream.Collectors
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					val namesByGender = roster
				        .stream
				        .collect(
				            Collectors.groupingBy(
				                [gender],
				                Collectors.mapping(
				                    [Person p | p.name],
				                    Collectors.toList)))
				}
			}
		''', '''
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.List;
			import java.util.Map;
			import java.util.function.Function;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    Stream<Demo.Person> _stream = roster.stream();
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final Function<Demo.Person, String> _function_1 = (Demo.Person p) -> {
			      return p.name;
			    };
			    Collector<String, ?, List<String>> _list = Collectors.<String>toList();
			    Collector<Demo.Person, ?, List<String>> _mapping = Collectors.mapping(_function_1, _list);
			    Collector<Demo.Person, ?, Map<Demo.Person.Sex, List<String>>> _groupingBy = Collectors.groupingBy(_function, _mapping);
			    final Map<Demo.Person.Sex, List<String>> namesByGender = _stream.collect(_groupingBy);
			  }
			}
		''')
	}
	
	@Test
	def test_08_b() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import java.util.stream.Collectors
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					val namesByGender = roster
				        .stream
				        .collect(
				            Collectors.groupingBy(
				                [gender],
				                Collectors.mapping(
				                    [p | p.name],
				                    Collectors.toList)))
				}
			}
		''', '''
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.List;
			import java.util.Map;
			import java.util.function.Function;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    Stream<Demo.Person> _stream = roster.stream();
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final Function<Demo.Person, String> _function_1 = (Demo.Person p) -> {
			      return p.name;
			    };
			    Collector<String, ?, List<String>> _list = Collectors.<String>toList();
			    Collector<Demo.Person, ?, List<String>> _mapping = Collectors.mapping(_function_1, _list);
			    Collector<Demo.Person, ?, Map<Demo.Person.Sex, List<String>>> _groupingBy = Collectors.groupingBy(_function, _mapping);
			    final Map<Demo.Person.Sex, List<String>> namesByGender = _stream.collect(_groupingBy);
			  }
			}
		''')
	}
	
	@Test
	def test_09_a() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import java.util.stream.Collectors
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					roster
				        .stream
				        .collect(
				            Collectors.groupingBy(
				                [gender],                      
				                Collectors.<Person, Integer>reducing(
				                    0,
				                    [age],
				                    [$0 + $1])))
				}
			}
		''', '''
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.Map;
			import java.util.function.BinaryOperator;
			import java.util.function.Function;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    Stream<Demo.Person> _stream = roster.stream();
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final Function<Demo.Person, Integer> _function_1 = (Demo.Person it) -> {
			      return Integer.valueOf(it.getAge());
			    };
			    final BinaryOperator<Integer> _function_2 = (Integer $0, Integer $1) -> {
			      return Integer.valueOf((($0).intValue() + ($1).intValue()));
			    };
			    Collector<Demo.Person, ?, Integer> _reducing = Collectors.<Demo.Person, Integer>reducing(
			      Integer.valueOf(0), _function_1, _function_2);
			    Collector<Demo.Person, ?, Map<Demo.Person.Sex, Integer>> _groupingBy = Collectors.groupingBy(_function, _reducing);
			    _stream.collect(_groupingBy);
			  }
			}
		''')
	}
	
	@Test
	def test_09_b() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import java.util.stream.Collectors
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					roster
				        .stream
				        .collect(
				            Collectors.groupingBy(
				                [gender],                      
				                Collectors.reducing(
				                    0,
				                    [age],
				                    [$0 + $1])))
				}
			}
		''', '''
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.Map;
			import java.util.function.BinaryOperator;
			import java.util.function.Function;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    Stream<Demo.Person> _stream = roster.stream();
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final Function<Demo.Person, Integer> _function_1 = (Demo.Person it) -> {
			      return Integer.valueOf(it.getAge());
			    };
			    final BinaryOperator<Integer> _function_2 = (Integer $0, Integer $1) -> {
			      return Integer.valueOf((($0).intValue() + ($1).intValue()));
			    };
			    Collector<Demo.Person, ?, Integer> _reducing = Collectors.<Demo.Person, Integer>reducing(
			      Integer.valueOf(0), _function_1, _function_2);
			    Collector<Demo.Person, ?, Map<Demo.Person.Sex, Integer>> _groupingBy = Collectors.groupingBy(_function, _reducing);
			    _stream.collect(_groupingBy);
			  }
			}
		''')
	}
	
	@Test
	def test_10_a() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import java.util.stream.Collectors
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					val averageAgeByGender = roster
					    .stream
					    .collect(
					        Collectors.groupingBy(
					            [gender],                      
					            Collectors.<Person>averagingInt[age]))
				}
			}
		''', '''
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.Map;
			import java.util.function.Function;
			import java.util.function.ToIntFunction;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    Stream<Demo.Person> _stream = roster.stream();
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final ToIntFunction<Demo.Person> _function_1 = (Demo.Person it) -> {
			      return it.getAge();
			    };
			    Collector<Demo.Person, ?, Double> _averagingInt = Collectors.<Demo.Person>averagingInt(_function_1);
			    Collector<Demo.Person, ?, Map<Demo.Person.Sex, Double>> _groupingBy = Collectors.groupingBy(_function, _averagingInt);
			    final Map<Demo.Person.Sex, Double> averageAgeByGender = _stream.collect(_groupingBy);
			  }
			}
		''')
	}
	
	@Test
	def test_10_b() {
		assertCompilesTo('''
			import org.eclipse.xtend.lib.annotations.Accessors
			import static java.util.stream.Collectors.*			
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    Sex gender;
				    def getAge() {
				        10
				    }
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					roster
					    .stream
					    .collect(
					        groupingBy(
					            [gender],                      
					            averagingInt[age]))
				}
			}
		''', '''
			import java.util.ArrayList;
			import java.util.Map;
			import java.util.function.Function;
			import java.util.function.ToIntFunction;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private Demo.Person.Sex gender;
			    
			    public int getAge() {
			      return 10;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    Stream<Demo.Person> _stream = roster.stream();
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final ToIntFunction<Demo.Person> _function_1 = (Demo.Person it) -> {
			      return it.getAge();
			    };
			    Collector<Demo.Person, ?, Double> _averagingInt = Collectors.<Demo.Person>averagingInt(_function_1);
			    Collector<Demo.Person, ?, Map<Demo.Person.Sex, Double>> _groupingBy = Collectors.groupingBy(_function, _averagingInt);
			    _stream.collect(_groupingBy);
			  }
			}
		''')
	}
	
	@Test
	def test_10_c() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import org.eclipse.xtend.lib.annotations.Accessors

			import static java.util.stream.Collectors.*
			import static Demo.Person.Sex.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(Person[] roster) {
					roster
					    .stream
					    .collect(
					        groupingBy(
					            [gender],                      
					            averagingInt[age]))
				}
			}
		''', '''
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.List;
			import java.util.Map;
			import java.util.function.Function;
			import java.util.function.ToIntFunction;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final Demo.Person[] roster) {
			    Stream<Demo.Person> _stream = ((List<Demo.Person>)Conversions.doWrapArray(roster)).stream();
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final ToIntFunction<Demo.Person> _function_1 = (Demo.Person it) -> {
			      return it.getAge();
			    };
			    Collector<Demo.Person, ?, Double> _averagingInt = Collectors.<Demo.Person>averagingInt(_function_1);
			    Collector<Demo.Person, ?, Map<Demo.Person.Sex, Double>> _groupingBy = Collectors.groupingBy(_function, _averagingInt);
			    _stream.collect(_groupingBy);
			  }
			}
		''')
	}
	
	@Test
	def test_10_d() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import org.eclipse.xtend.lib.annotations.Accessors

			import static java.util.stream.Collectors.*			
			import static Demo.Person.Sex.*
			
			import static extension java.util.Arrays.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(Person[] roster) {
					roster
					    .stream
					    .collect(
					        groupingBy(
					            [gender],                      
					            averagingInt[age]))
				}
			}
		''', '''
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.Arrays;
			import java.util.Map;
			import java.util.function.Function;
			import java.util.function.ToIntFunction;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final Demo.Person[] roster) {
			    Stream<Demo.Person> _stream = Arrays.<Demo.Person>stream(roster);
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final ToIntFunction<Demo.Person> _function_1 = (Demo.Person it) -> {
			      return it.getAge();
			    };
			    Collector<Demo.Person, ?, Double> _averagingInt = Collectors.<Demo.Person>averagingInt(_function_1);
			    Collector<Demo.Person, ?, Map<Demo.Person.Sex, Double>> _groupingBy = Collectors.groupingBy(_function, _averagingInt);
			    _stream.collect(_groupingBy);
			  }
			}
		''')
	}
	
	@Test
	def test_10_e() {
		assertCompilesTo('''
			import java.time.LocalDate
			import java.time.Period
			import java.util.stream.Collectors
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			import static extension java.util.Arrays.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    LocalDate birthday;
				    Sex gender;
				    String emailAddress;
				    def getAge() {
				        Period.between(birthday, LocalDate.now).years
				    }
				}
				def static void main(Person[] roster) {
					roster
					    .stream
					    .collect(
					        Collectors.groupingBy(
					            [gender],                      
					            Collectors.<Person>averagingInt[age]))
				}
			}
		''', '''
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.Arrays;
			import java.util.Map;
			import java.util.function.Function;
			import java.util.function.ToIntFunction;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private LocalDate birthday;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    public int getAge() {
			      LocalDate _now = LocalDate.now();
			      Period _between = Period.between(this.birthday, _now);
			      return _between.getYears();
			    }
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public LocalDate getBirthday() {
			      return this.birthday;
			    }
			    
			    public void setBirthday(final LocalDate birthday) {
			      this.birthday = birthday;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final Demo.Person[] roster) {
			    Stream<Demo.Person> _stream = Arrays.<Demo.Person>stream(roster);
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final ToIntFunction<Demo.Person> _function_1 = (Demo.Person it) -> {
			      return it.getAge();
			    };
			    Collector<Demo.Person, ?, Double> _averagingInt = Collectors.<Demo.Person>averagingInt(_function_1);
			    Collector<Demo.Person, ?, Map<Demo.Person.Sex, Double>> _groupingBy = Collectors.groupingBy(_function, _averagingInt);
			    _stream.collect(_groupingBy);
			  }
			}
		''')
	}
	
	@Test
	def test_11_a() {
		assertCompilesTo('''
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    Sex gender;
				    String emailAddress;
				}
				def static void main(String[] args) {
					val roster = <Person>newArrayList
					val namesOfMaleMembersXtend = roster
					    .filter[gender == MALE]
					    .map[name]
					    .toList
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Person> roster = CollectionLiterals.<Demo.Person>newArrayList();
			    final Function1<Demo.Person, Boolean> _function = (Demo.Person it) -> {
			      return Boolean.valueOf(Objects.equal(it.gender, Demo.Person.Sex.MALE));
			    };
			    Iterable<Demo.Person> _filter = IterableExtensions.<Demo.Person>filter(roster, _function);
			    final Function1<Demo.Person, String> _function_1 = (Demo.Person it) -> {
			      return it.name;
			    };
			    Iterable<String> _map = IterableExtensions.<Demo.Person, String>map(_filter, _function_1);
			    final List<String> namesOfMaleMembersXtend = IterableExtensions.<String>toList(_map);
			  }
			}
		''')
	}
	
	@Test
	def test_11_b() {
		assertCompilesTo('''
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static Demo.Person.Sex.*
			
			class Demo {
				@Accessors
				static class Person {
				    public enum Sex {
				        MALE, FEMALE
				    }
				    String name;
				    Sex gender;
				    String emailAddress;
				}
				def static void main(Person[] roster) {
					roster
					    .filter[gender == MALE]
					    .map[name]
					    .toList
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Person {
			    public enum Sex {
			      MALE,
			      
			      FEMALE;
			    }
			    
			    private String name;
			    
			    private Demo.Person.Sex gender;
			    
			    private String emailAddress;
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public Demo.Person.Sex getGender() {
			      return this.gender;
			    }
			    
			    public void setGender(final Demo.Person.Sex gender) {
			      this.gender = gender;
			    }
			    
			    @Pure
			    public String getEmailAddress() {
			      return this.emailAddress;
			    }
			    
			    public void setEmailAddress(final String emailAddress) {
			      this.emailAddress = emailAddress;
			    }
			  }
			  
			  public static void main(final Demo.Person[] roster) {
			    final Function1<Demo.Person, Boolean> _function = (Demo.Person it) -> {
			      return Boolean.valueOf(Objects.equal(it.gender, Demo.Person.Sex.MALE));
			    };
			    Iterable<Demo.Person> _filter = IterableExtensions.<Demo.Person>filter(((Iterable<Demo.Person>)Conversions.doWrapArray(roster)), _function);
			    final Function1<Demo.Person, String> _function_1 = (Demo.Person it) -> {
			      return it.name;
			    };
			    Iterable<String> _map = IterableExtensions.<Demo.Person, String>map(_filter, _function_1);
			    IterableExtensions.<String>toList(_map);
			  }
			}
		''')
	}
	
	@Test
	def test_12_a() {
		assertCompilesTo('''
			import java.util.Collection
			import java.util.Comparator
			import java.util.stream.Collectors
			import org.eclipse.xtend.lib.annotations.Accessors
			
			class Demo {
				@Accessors
				static class Album {
					String name
					Collection<Track> tracks
				}
				@Accessors
				static class Track {
					int rating
				}
				def static void main(String[] args) {
					val albums = <Album>newArrayList
					val sortedFavs = albums.stream
					        .filter[tracks.stream.anyMatch[rating >= 4]]
					        .sorted(Comparator.<Album, String>comparing[name])
					        .collect(Collectors.toList)
				}
			}
		''', '''
			import java.util.ArrayList;
			import java.util.Collection;
			import java.util.Comparator;
			import java.util.List;
			import java.util.function.Function;
			import java.util.function.Predicate;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Album {
			    private String name;
			    
			    private Collection<Demo.Track> tracks;
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public Collection<Demo.Track> getTracks() {
			      return this.tracks;
			    }
			    
			    public void setTracks(final Collection<Demo.Track> tracks) {
			      this.tracks = tracks;
			    }
			  }
			  
			  @Accessors
			  public static class Track {
			    private int rating;
			    
			    @Pure
			    public int getRating() {
			      return this.rating;
			    }
			    
			    public void setRating(final int rating) {
			      this.rating = rating;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Album> albums = CollectionLiterals.<Demo.Album>newArrayList();
			    Stream<Demo.Album> _stream = albums.stream();
			    final Predicate<Demo.Album> _function = (Demo.Album it) -> {
			      Stream<Demo.Track> _stream_1 = it.tracks.stream();
			      final Predicate<Demo.Track> _function_1 = (Demo.Track it_1) -> {
			        return (it_1.rating >= 4);
			      };
			      return _stream_1.anyMatch(_function_1);
			    };
			    Stream<Demo.Album> _filter = _stream.filter(_function);
			    final Function<Demo.Album, String> _function_1 = (Demo.Album it) -> {
			      return it.name;
			    };
			    Comparator<Demo.Album> _comparing = Comparator.<Demo.Album, String>comparing(_function_1);
			    Stream<Demo.Album> _sorted = _filter.sorted(_comparing);
			    Collector<Demo.Album, ?, List<Demo.Album>> _list = Collectors.<Demo.Album>toList();
			    final List<Demo.Album> sortedFavs = _sorted.collect(_list);
			  }
			}
		''')
	}
	
	@Test
	def test_12_b() {
		assertCompilesTo('''
			import java.util.Collection
			import java.util.Comparator
			import java.util.stream.Collectors
			import org.eclipse.xtend.lib.annotations.Accessors
			
			class Demo {
				@Accessors
				static class Album {
					String name
					Collection<Track> tracks
				}
				@Accessors
				static class Track {
					int rating
				}
				def static void main(Album[] albums) {
					albums.stream
					        .filter[tracks.stream.anyMatch[rating >= 4]]
					        .sorted(Comparator.<Album, String>comparing[name])
					        .collect(Collectors.toList)
				}
			}
		''', '''
			import java.util.Collection;
			import java.util.Comparator;
			import java.util.List;
			import java.util.function.Function;
			import java.util.function.Predicate;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Album {
			    private String name;
			    
			    private Collection<Demo.Track> tracks;
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public Collection<Demo.Track> getTracks() {
			      return this.tracks;
			    }
			    
			    public void setTracks(final Collection<Demo.Track> tracks) {
			      this.tracks = tracks;
			    }
			  }
			  
			  @Accessors
			  public static class Track {
			    private int rating;
			    
			    @Pure
			    public int getRating() {
			      return this.rating;
			    }
			    
			    public void setRating(final int rating) {
			      this.rating = rating;
			    }
			  }
			  
			  public static void main(final Demo.Album[] albums) {
			    Stream<Demo.Album> _stream = ((List<Demo.Album>)Conversions.doWrapArray(albums)).stream();
			    final Predicate<Demo.Album> _function = (Demo.Album it) -> {
			      Stream<Demo.Track> _stream_1 = it.tracks.stream();
			      final Predicate<Demo.Track> _function_1 = (Demo.Track it_1) -> {
			        return (it_1.rating >= 4);
			      };
			      return _stream_1.anyMatch(_function_1);
			    };
			    Stream<Demo.Album> _filter = _stream.filter(_function);
			    final Function<Demo.Album, String> _function_1 = (Demo.Album it) -> {
			      return it.name;
			    };
			    Comparator<Demo.Album> _comparing = Comparator.<Demo.Album, String>comparing(_function_1);
			    Stream<Demo.Album> _sorted = _filter.sorted(_comparing);
			    Collector<Demo.Album, ?, List<Demo.Album>> _list = Collectors.<Demo.Album>toList();
			    _sorted.collect(_list);
			  }
			}
		''')
	}
	
	@Test
	def test_12_c() {
		assertCompilesTo('''
			import java.util.Collection
			import java.util.Comparator
			import java.util.stream.Collectors
			import org.eclipse.xtend.lib.annotations.Accessors
			
			class Demo {
				@Accessors
				static class Album {
					String name
					Collection<Track> tracks
				}
				@Accessors
				static class Track {
					int rating
				}
				def static void main(String[] args) {
					val albums = <Album>newArrayList
					val sortedFavs = albums.stream
					        .filter[tracks.stream.anyMatch[rating >= 4]]
					        .sorted(Comparator.comparing[name])
					        .collect(Collectors.toList)
				}
			}
		''', '''
			import java.util.ArrayList;
			import java.util.Collection;
			import java.util.Comparator;
			import java.util.List;
			import java.util.function.Function;
			import java.util.function.Predicate;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Album {
			    private String name;
			    
			    private Collection<Demo.Track> tracks;
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public Collection<Demo.Track> getTracks() {
			      return this.tracks;
			    }
			    
			    public void setTracks(final Collection<Demo.Track> tracks) {
			      this.tracks = tracks;
			    }
			  }
			  
			  @Accessors
			  public static class Track {
			    private int rating;
			    
			    @Pure
			    public int getRating() {
			      return this.rating;
			    }
			    
			    public void setRating(final int rating) {
			      this.rating = rating;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Album> albums = CollectionLiterals.<Demo.Album>newArrayList();
			    Stream<Demo.Album> _stream = albums.stream();
			    final Predicate<Demo.Album> _function = (Demo.Album it) -> {
			      Stream<Demo.Track> _stream_1 = it.tracks.stream();
			      final Predicate<Demo.Track> _function_1 = (Demo.Track it_1) -> {
			        return (it_1.rating >= 4);
			      };
			      return _stream_1.anyMatch(_function_1);
			    };
			    Stream<Demo.Album> _filter = _stream.filter(_function);
			    final Function<Demo.Album, String> _function_1 = (Demo.Album it) -> {
			      return it.name;
			    };
			    Comparator<Demo.Album> _comparing = Comparator.<Demo.Album, String>comparing(_function_1);
			    Stream<Demo.Album> _sorted = _filter.sorted(_comparing);
			    Collector<Demo.Album, ?, List<Demo.Album>> _list = Collectors.<Demo.Album>toList();
			    final List<Demo.Album> sortedFavs = _sorted.collect(_list);
			  }
			}
		''')
	}
	
	@Test
	def test_12_d() {
		assertCompilesTo('''
			import java.util.Collection
			import java.util.Comparator
			import org.eclipse.xtend.lib.annotations.Accessors
			
			import static java.util.stream.Collectors.*
			import static java.util.Comparator.*
			
			class Demo {
				@Accessors
				static class Album {
					String name
					Collection<Track> tracks
				}
				@Accessors
				static class Track {
					int rating
				}
				def static void main(Album[] albums) {
					albums.stream
					        .filter[tracks.stream.anyMatch[rating >= 4]]
					        .sorted(comparing[name])
					        .collect(toList)
				}
			}
		''', '''
			import java.util.Collection;
			import java.util.Comparator;
			import java.util.List;
			import java.util.function.Function;
			import java.util.function.Predicate;
			import java.util.stream.Collector;
			import java.util.stream.Collectors;
			import java.util.stream.Stream;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Album {
			    private String name;
			    
			    private Collection<Demo.Track> tracks;
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public Collection<Demo.Track> getTracks() {
			      return this.tracks;
			    }
			    
			    public void setTracks(final Collection<Demo.Track> tracks) {
			      this.tracks = tracks;
			    }
			  }
			  
			  @Accessors
			  public static class Track {
			    private int rating;
			    
			    @Pure
			    public int getRating() {
			      return this.rating;
			    }
			    
			    public void setRating(final int rating) {
			      this.rating = rating;
			    }
			  }
			  
			  public static void main(final Demo.Album[] albums) {
			    Stream<Demo.Album> _stream = ((List<Demo.Album>)Conversions.doWrapArray(albums)).stream();
			    final Predicate<Demo.Album> _function = (Demo.Album it) -> {
			      Stream<Demo.Track> _stream_1 = it.tracks.stream();
			      final Predicate<Demo.Track> _function_1 = (Demo.Track it_1) -> {
			        return (it_1.rating >= 4);
			      };
			      return _stream_1.anyMatch(_function_1);
			    };
			    Stream<Demo.Album> _filter = _stream.filter(_function);
			    final Function<Demo.Album, String> _function_1 = (Demo.Album it) -> {
			      return it.name;
			    };
			    Comparator<Demo.Album> _comparing = Comparator.<Demo.Album, String>comparing(_function_1);
			    Stream<Demo.Album> _sorted = _filter.sorted(_comparing);
			    Collector<Demo.Album, ?, List<Demo.Album>> _list = Collectors.<Demo.Album>toList();
			    _sorted.collect(_list);
			  }
			}
		''')
	}
	
	@Test
	def test_13_a() {
		assertCompilesTo('''
			import java.util.Collection
			import org.eclipse.xtend.lib.annotations.Accessors
			
			class Demo {
				@Accessors
				static class Album {
					String name
					Collection<Track> tracks
				}
				@Accessors
				static class Track {
					int rating
				}
				def static void main(String[] args) {
					val albums = <Album>newArrayList
					albums.filter[tracks.exists[rating >= 4]].sortBy[name]
				}
			}
		''', '''
			import java.util.ArrayList;
			import java.util.Collection;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Album {
			    private String name;
			    
			    private Collection<Demo.Track> tracks;
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public Collection<Demo.Track> getTracks() {
			      return this.tracks;
			    }
			    
			    public void setTracks(final Collection<Demo.Track> tracks) {
			      this.tracks = tracks;
			    }
			  }
			  
			  @Accessors
			  public static class Track {
			    private int rating;
			    
			    @Pure
			    public int getRating() {
			      return this.rating;
			    }
			    
			    public void setRating(final int rating) {
			      this.rating = rating;
			    }
			  }
			  
			  public static void main(final String[] args) {
			    final ArrayList<Demo.Album> albums = CollectionLiterals.<Demo.Album>newArrayList();
			    final Function1<Demo.Album, Boolean> _function = (Demo.Album it) -> {
			      final Function1<Demo.Track, Boolean> _function_1 = (Demo.Track it_1) -> {
			        return Boolean.valueOf((it_1.rating >= 4));
			      };
			      return Boolean.valueOf(IterableExtensions.<Demo.Track>exists(it.tracks, _function_1));
			    };
			    Iterable<Demo.Album> _filter = IterableExtensions.<Demo.Album>filter(albums, _function);
			    final Function1<Demo.Album, String> _function_1 = (Demo.Album it) -> {
			      return it.name;
			    };
			    IterableExtensions.<Demo.Album, String>sortBy(_filter, _function_1);
			  }
			}
		''')
	}
	
	@Test
	def test_13_b() {
		assertCompilesTo('''
			import java.util.Collection
			import org.eclipse.xtend.lib.annotations.Accessors
			
			class Demo {
				@Accessors
				static class Album {
					String name
					Collection<Track> tracks
				}
				@Accessors
				static class Track {
					int rating
				}
				def static void main(Album[] albums) {
					albums.filter[tracks.exists[rating >= 4]].sortBy[name]
				}
			}
		''', '''
			import java.util.Collection;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class Demo {
			  @Accessors
			  public static class Album {
			    private String name;
			    
			    private Collection<Demo.Track> tracks;
			    
			    @Pure
			    public String getName() {
			      return this.name;
			    }
			    
			    public void setName(final String name) {
			      this.name = name;
			    }
			    
			    @Pure
			    public Collection<Demo.Track> getTracks() {
			      return this.tracks;
			    }
			    
			    public void setTracks(final Collection<Demo.Track> tracks) {
			      this.tracks = tracks;
			    }
			  }
			  
			  @Accessors
			  public static class Track {
			    private int rating;
			    
			    @Pure
			    public int getRating() {
			      return this.rating;
			    }
			    
			    public void setRating(final int rating) {
			      this.rating = rating;
			    }
			  }
			  
			  public static void main(final Demo.Album[] albums) {
			    final Function1<Demo.Album, Boolean> _function = (Demo.Album it) -> {
			      final Function1<Demo.Track, Boolean> _function_1 = (Demo.Track it_1) -> {
			        return Boolean.valueOf((it_1.rating >= 4));
			      };
			      return Boolean.valueOf(IterableExtensions.<Demo.Track>exists(it.tracks, _function_1));
			    };
			    Iterable<Demo.Album> _filter = IterableExtensions.<Demo.Album>filter(((Iterable<Demo.Album>)Conversions.doWrapArray(albums)), _function);
			    final Function1<Demo.Album, String> _function_1 = (Demo.Album it) -> {
			      return it.name;
			    };
			    IterableExtensions.<Demo.Album, String>sortBy(_filter, _function_1);
			  }
			}
		''')
	}
	
}
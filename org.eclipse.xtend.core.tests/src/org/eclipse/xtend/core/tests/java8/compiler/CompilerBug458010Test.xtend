/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.testing.InjectWith
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
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.Objects;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			      return ((Objects.equals(it.gender, Demo.Person.Sex.MALE) && (it.getAge() >= 18)) && (it.getAge() <= 25));
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
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.Objects;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			      return ((Objects.equals(it.gender, Demo.Person.Sex.MALE) && (it.getAge() >= 18)) && (it.getAge() <= 25));
			    };
			    final Function<Demo.Person, String> _function_1 = (Demo.Person it) -> {
			      return it.emailAddress;
			    };
			    final Consumer<String> _function_2 = (String it) -> {
			      InputOutput.<String>println(it);
			    };
			    roster.stream().filter(_function).<String>map(_function_1).forEach(_function_2);
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
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.Objects;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			      return Boolean.valueOf(((Objects.equals(it.gender, Demo.Person.Sex.MALE) && (it.getAge() >= 18)) && (it.getAge() <= 25)));
			    };
			    final Function1<Demo.Person, String> _function_1 = (Demo.Person it) -> {
			      return it.emailAddress;
			    };
			    final Consumer<String> _function_2 = (String it) -> {
			      InputOutput.<String>println(it);
			    };
			    IterableExtensions.<Demo.Person, String>map(IterableExtensions.<Demo.Person>filter(roster, _function), _function_1).forEach(_function_2);
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
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.Objects;
			import java.util.function.Predicate;
			import java.util.function.ToIntFunction;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			      return Objects.equals(it.gender, Demo.Person.Sex.MALE);
			    };
			    final ToIntFunction<Demo.Person> _function_1 = (Demo.Person it) -> {
			      return it.getAge();
			    };
			    roster.stream().filter(_function).mapToInt(_function_1).average().getAsDouble();
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			    final Function<Demo.Person, Integer> _function = (Demo.Person it) -> {
			      return Integer.valueOf(it.getAge());
			    };
			    final BinaryOperator<Integer> _function_1 = (Integer $0, Integer $1) -> {
			      return Integer.valueOf((($0).intValue() + ($1).intValue()));
			    };
			    roster.stream().<Integer>map(_function).reduce(Integer.valueOf(0), _function_1);
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
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.Objects;
			import java.util.function.BiConsumer;
			import java.util.function.Function;
			import java.util.function.IntConsumer;
			import java.util.function.Predicate;
			import java.util.function.Supplier;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			      return Objects.equals(it.gender, Demo.Person.Sex.MALE);
			    };
			    final Function<Demo.Person, Integer> _function_1 = (Demo.Person it) -> {
			      return Integer.valueOf(it.getAge());
			    };
			    final Supplier<Demo.Averager> _function_2 = () -> {
			      return new Demo.Averager();
			    };
			    final BiConsumer<Demo.Averager, Integer> _function_3 = (Demo.Averager avg, Integer i) -> {
			      avg.accept((i).intValue());
			    };
			    final BiConsumer<Demo.Averager, Demo.Averager> _function_4 = (Demo.Averager avg1, Demo.Averager avg2) -> {
			      avg1.combine(avg2);
			    };
			    roster.stream().filter(_function).<Integer>map(_function_1).<Demo.Averager>collect(_function_2, _function_3, _function_4);
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
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.List;
			import java.util.Objects;
			import java.util.function.BiConsumer;
			import java.util.function.Function;
			import java.util.function.IntConsumer;
			import java.util.function.Predicate;
			import java.util.function.Supplier;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			    final Predicate<Demo.Person> _function = (Demo.Person it) -> {
			      return Objects.equals(it.gender, Demo.Person.Sex.MALE);
			    };
			    final Function<Demo.Person, Integer> _function_1 = (Demo.Person it) -> {
			      return Integer.valueOf(it.getAge());
			    };
			    final Supplier<Demo.Averager> _function_2 = () -> {
			      return new Demo.Averager();
			    };
			    final BiConsumer<Demo.Averager, Integer> _function_3 = (Demo.Averager $0, Integer $1) -> {
			      $0.accept(($1).intValue());
			    };
			    final BiConsumer<Demo.Averager, Demo.Averager> _function_4 = (Demo.Averager $0, Demo.Averager $1) -> {
			      $0.combine($1);
			    };
			    ((List<Demo.Person>)Conversions.doWrapArray(roster)).stream().filter(_function).<Integer>map(_function_1).<Demo.Averager>collect(_function_2, _function_3, _function_4);
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
			import java.time.LocalDate;
			import java.time.Period;
			import java.util.ArrayList;
			import java.util.Objects;
			import java.util.function.Function;
			import java.util.function.Predicate;
			import java.util.stream.Collectors;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			      return Objects.equals(it.gender, Demo.Person.Sex.MALE);
			    };
			    final Function<Demo.Person, String> _function_1 = (Demo.Person it) -> {
			      return it.name;
			    };
			    roster.stream().filter(_function).<String>map(_function_1).collect(Collectors.<String>toList());
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
			import java.util.stream.Collectors;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final Function<Demo.Person, String> _function_1 = (Demo.Person p) -> {
			      return p.name;
			    };
			    final Map<Demo.Person.Sex, List<String>> namesByGender = roster.stream().collect(
			      Collectors.groupingBy(_function, 
			        Collectors.mapping(_function_1, 
			          Collectors.<String>toList())));
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
			import java.util.stream.Collectors;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final Function<Demo.Person, String> _function_1 = (Demo.Person p) -> {
			      return p.name;
			    };
			    final Map<Demo.Person.Sex, List<String>> namesByGender = roster.stream().collect(
			      Collectors.groupingBy(_function, 
			        Collectors.mapping(_function_1, 
			          Collectors.<String>toList())));
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
			import java.util.function.BinaryOperator;
			import java.util.function.Function;
			import java.util.stream.Collectors;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final Function<Demo.Person, Integer> _function_1 = (Demo.Person it) -> {
			      return Integer.valueOf(it.getAge());
			    };
			    final BinaryOperator<Integer> _function_2 = (Integer $0, Integer $1) -> {
			      return Integer.valueOf((($0).intValue() + ($1).intValue()));
			    };
			    roster.stream().collect(
			      Collectors.groupingBy(_function, 
			        Collectors.<Demo.Person, Integer>reducing(
			          Integer.valueOf(0), _function_1, _function_2)));
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
			import java.util.function.BinaryOperator;
			import java.util.function.Function;
			import java.util.stream.Collectors;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final Function<Demo.Person, Integer> _function_1 = (Demo.Person it) -> {
			      return Integer.valueOf(it.getAge());
			    };
			    final BinaryOperator<Integer> _function_2 = (Integer $0, Integer $1) -> {
			      return Integer.valueOf((($0).intValue() + ($1).intValue()));
			    };
			    roster.stream().collect(
			      Collectors.groupingBy(_function, 
			        Collectors.<Demo.Person, Integer>reducing(
			          Integer.valueOf(0), _function_1, _function_2)));
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
			import java.util.stream.Collectors;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final ToIntFunction<Demo.Person> _function_1 = (Demo.Person it) -> {
			      return it.getAge();
			    };
			    final Map<Demo.Person.Sex, Double> averageAgeByGender = roster.stream().collect(
			      Collectors.groupingBy(_function, 
			        Collectors.<Demo.Person>averagingInt(_function_1)));
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
			import java.util.function.Function;
			import java.util.function.ToIntFunction;
			import java.util.stream.Collectors;
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
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final ToIntFunction<Demo.Person> _function_1 = (Demo.Person it) -> {
			      return it.getAge();
			    };
			    roster.stream().collect(
			      Collectors.groupingBy(_function, 
			        Collectors.<Demo.Person>averagingInt(_function_1)));
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
			import java.util.function.Function;
			import java.util.function.ToIntFunction;
			import java.util.stream.Collectors;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final ToIntFunction<Demo.Person> _function_1 = (Demo.Person it) -> {
			      return it.getAge();
			    };
			    ((List<Demo.Person>)Conversions.doWrapArray(roster)).stream().collect(
			      Collectors.groupingBy(_function, 
			        Collectors.<Demo.Person>averagingInt(_function_1)));
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
			import java.util.function.Function;
			import java.util.function.ToIntFunction;
			import java.util.stream.Collectors;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final ToIntFunction<Demo.Person> _function_1 = (Demo.Person it) -> {
			      return it.getAge();
			    };
			    Arrays.<Demo.Person>stream(roster).collect(
			      Collectors.groupingBy(_function, 
			        Collectors.<Demo.Person>averagingInt(_function_1)));
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
			import java.util.function.Function;
			import java.util.function.ToIntFunction;
			import java.util.stream.Collectors;
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
			      return Period.between(this.birthday, LocalDate.now()).getYears();
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
			    final Function<Demo.Person, Demo.Person.Sex> _function = (Demo.Person it) -> {
			      return it.gender;
			    };
			    final ToIntFunction<Demo.Person> _function_1 = (Demo.Person it) -> {
			      return it.getAge();
			    };
			    Arrays.<Demo.Person>stream(roster).collect(
			      Collectors.groupingBy(_function, 
			        Collectors.<Demo.Person>averagingInt(_function_1)));
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
			import java.util.ArrayList;
			import java.util.List;
			import java.util.Objects;
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
			      return Boolean.valueOf(Objects.equals(it.gender, Demo.Person.Sex.MALE));
			    };
			    final Function1<Demo.Person, String> _function_1 = (Demo.Person it) -> {
			      return it.name;
			    };
			    final List<String> namesOfMaleMembersXtend = IterableExtensions.<String>toList(IterableExtensions.<Demo.Person, String>map(IterableExtensions.<Demo.Person>filter(roster, _function), _function_1));
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
			import java.util.Objects;
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
			      return Boolean.valueOf(Objects.equals(it.gender, Demo.Person.Sex.MALE));
			    };
			    final Function1<Demo.Person, String> _function_1 = (Demo.Person it) -> {
			      return it.name;
			    };
			    IterableExtensions.<String>toList(IterableExtensions.<Demo.Person, String>map(IterableExtensions.<Demo.Person>filter(((Iterable<Demo.Person>)Conversions.doWrapArray(roster)), _function), _function_1));
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
			import java.util.stream.Collectors;
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
			    final Predicate<Demo.Album> _function = (Demo.Album it) -> {
			      final Predicate<Demo.Track> _function_1 = (Demo.Track it_1) -> {
			        return (it_1.rating >= 4);
			      };
			      return it.tracks.stream().anyMatch(_function_1);
			    };
			    final Function<Demo.Album, String> _function_1 = (Demo.Album it) -> {
			      return it.name;
			    };
			    final List<Demo.Album> sortedFavs = albums.stream().filter(_function).sorted(Comparator.<Demo.Album, String>comparing(_function_1)).collect(Collectors.<Demo.Album>toList());
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
			import java.util.stream.Collectors;
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
			    final Predicate<Demo.Album> _function = (Demo.Album it) -> {
			      final Predicate<Demo.Track> _function_1 = (Demo.Track it_1) -> {
			        return (it_1.rating >= 4);
			      };
			      return it.tracks.stream().anyMatch(_function_1);
			    };
			    final Function<Demo.Album, String> _function_1 = (Demo.Album it) -> {
			      return it.name;
			    };
			    ((List<Demo.Album>)Conversions.doWrapArray(albums)).stream().filter(_function).sorted(Comparator.<Demo.Album, String>comparing(_function_1)).collect(Collectors.<Demo.Album>toList());
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
			import java.util.stream.Collectors;
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
			    final Predicate<Demo.Album> _function = (Demo.Album it) -> {
			      final Predicate<Demo.Track> _function_1 = (Demo.Track it_1) -> {
			        return (it_1.rating >= 4);
			      };
			      return it.tracks.stream().anyMatch(_function_1);
			    };
			    final Function<Demo.Album, String> _function_1 = (Demo.Album it) -> {
			      return it.name;
			    };
			    final List<Demo.Album> sortedFavs = albums.stream().filter(_function).sorted(Comparator.<Demo.Album, String>comparing(_function_1)).collect(Collectors.<Demo.Album>toList());
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
			import java.util.stream.Collectors;
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
			    final Predicate<Demo.Album> _function = (Demo.Album it) -> {
			      final Predicate<Demo.Track> _function_1 = (Demo.Track it_1) -> {
			        return (it_1.rating >= 4);
			      };
			      return it.tracks.stream().anyMatch(_function_1);
			    };
			    final Function<Demo.Album, String> _function_1 = (Demo.Album it) -> {
			      return it.name;
			    };
			    ((List<Demo.Album>)Conversions.doWrapArray(albums)).stream().filter(_function).sorted(Comparator.<Demo.Album, String>comparing(_function_1)).collect(Collectors.<Demo.Album>toList());
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
			    final Function1<Demo.Album, String> _function_1 = (Demo.Album it) -> {
			      return it.name;
			    };
			    IterableExtensions.<Demo.Album, String>sortBy(IterableExtensions.<Demo.Album>filter(albums, _function), _function_1);
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
			    final Function1<Demo.Album, String> _function_1 = (Demo.Album it) -> {
			      return it.name;
			    };
			    IterableExtensions.<Demo.Album, String>sortBy(IterableExtensions.<Demo.Album>filter(((Iterable<Demo.Album>)Conversions.doWrapArray(albums)), _function), _function_1);
			  }
			}
		''')
	}
	
}
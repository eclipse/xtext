package lesson5;

import lesson5.Distance;
import lesson5.Speed;
import lesson5.Time;
import org.junit.Assert;
import org.junit.Test;

/**
 * This example shows the usage of operator overloading combined with
 * extension methods.
 */
@SuppressWarnings("all")
public class Operators {
  @Test
  public void testOperators() {
    Distance _cm = Distance.cm(23);
    Distance _mm = Distance.mm(10);
    Distance _cm_1 = Distance.cm(22);
    Distance _plus = _mm.operator_plus(_cm_1);
    Assert.assertEquals(_cm, _plus);
    Distance _km = Distance.km(3);
    Distance _km_1 = Distance.km(1);
    Distance _multiply = _km_1.operator_multiply(3);
    Assert.assertEquals(_km, _multiply);
    Distance _mm_1 = Distance.mm(1019997);
    Distance _km_2 = Distance.km(1);
    Distance _m = Distance.m(20);
    Distance _plus_1 = _km_2.operator_plus(_m);
    Distance _mm_2 = Distance.mm(3);
    Distance _minus = _plus_1.operator_minus(_mm_2);
    Assert.assertEquals(_mm_1, _minus);
    Distance _km_3 = Distance.km(42);
    Time _h = Time.h(1);
    final Speed speed = Speed.operator_divide(_km_3, _h);
    Distance _km_4 = Distance.km(21);
    Time _min = Time.min(30);
    Distance _multiply_1 = speed.operator_multiply(_min);
    Assert.assertEquals(_km_4, _multiply_1);
  }
  
  @Test
  public void testOperators2() {
    Distance _cm = Distance.cm(23);
    Distance _mm = Distance.mm(10);
    Distance _cm_1 = Distance.cm(22);
    Distance _plus = _mm.operator_plus(_cm_1);
    Assert.assertEquals(_cm, _plus);
    Distance _km = Distance.km(3);
    Distance _km_1 = Distance.km(1);
    Distance _multiply = _km_1.operator_multiply(3);
    Assert.assertEquals(_km, _multiply);
    Distance _mm_1 = Distance.mm(1019997);
    Distance _km_2 = Distance.km(1);
    Distance _m = Distance.m(20);
    Distance _plus_1 = _km_2.operator_plus(_m);
    Distance _mm_2 = Distance.mm(3);
    Distance _minus = _plus_1.operator_minus(_mm_2);
    Assert.assertEquals(_mm_1, _minus);
  }
}

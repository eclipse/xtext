package lesson5;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class Distance {
  private final double _mm;
  
  public double getMm() {
    return this._mm;
  }
  
  public Distance operator_plus(final Distance other) {
    double _mm = this.getMm();
    double _mm_1 = other.getMm();
    double _plus = (_mm + _mm_1);
    Distance _distance = new Distance(_plus);
    return _distance;
  }
  
  public Distance operator_minus(final Distance other) {
    double _mm = this.getMm();
    double _mm_1 = other.getMm();
    double _minus = (_mm - _mm_1);
    Distance _distance = new Distance(_minus);
    return _distance;
  }
  
  public Distance operator_multiply(final int times) {
    double _mm = this.getMm();
    double _multiply = (_mm * times);
    Distance _distance = new Distance(_multiply);
    return _distance;
  }
  
  public Distance operator_divide(final int times) {
    double _mm = this.getMm();
    double _divide = (_mm / times);
    Distance _distance = new Distance(_divide);
    return _distance;
  }
  
  public static Distance mm(final int millimeters) {
    Distance _distance = new Distance(millimeters);
    return _distance;
  }
  
  public static Distance cm(final int centimeters) {
    int _multiply = (centimeters * 10);
    Distance _mm = Distance.mm(_multiply);
    return _mm;
  }
  
  public static Distance m(final int meters) {
    int _multiply = (meters * 100);
    Distance _cm = Distance.cm(_multiply);
    return _cm;
  }
  
  public static Distance km(final int kilometers) {
    int _multiply = (kilometers * 1000);
    Distance _m = Distance.m(_multiply);
    return _m;
  }
  
  public Distance(final double mm) {
    super();
    this._mm = mm;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (Double.doubleToLongBits(_mm) ^ (Double.doubleToLongBits(_mm) >>> 32));
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Distance other = (Distance) obj;
    if (Double.doubleToLongBits(other._mm) != Double.doubleToLongBits(_mm))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}

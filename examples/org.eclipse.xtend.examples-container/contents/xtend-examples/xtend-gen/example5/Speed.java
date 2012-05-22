package example5;

import example5.Distance;
import example5.Time;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class Speed {
  private final double _mm_msec;
  
  public double getMm_msec() {
    return this._mm_msec;
  }
  
  public Time operator_plus(final Speed other) {
    double _mm_msec = this.getMm_msec();
    double _mm_msec_1 = other.getMm_msec();
    double _plus = (_mm_msec + _mm_msec_1);
    Time _time = new Time(_plus);
    return _time;
  }
  
  public Time operator_minus(final Speed other) {
    double _mm_msec = this.getMm_msec();
    double _mm_msec_1 = other.getMm_msec();
    double _minus = (_mm_msec - _mm_msec_1);
    Time _time = new Time(_minus);
    return _time;
  }
  
  public Speed operator_multiply(final int times) {
    double _mm_msec = this.getMm_msec();
    double _multiply = (_mm_msec * times);
    Speed _speed = new Speed(_multiply);
    return _speed;
  }
  
  public Distance operator_multiply(final Time time) {
    double _mm_msec = this.getMm_msec();
    double _ms = time.getMs();
    double _multiply = (_mm_msec * _ms);
    Distance _distance = new Distance(_multiply);
    return _distance;
  }
  
  public Time operator_divide(final int times) {
    double _mm_msec = this.getMm_msec();
    double _divide = (_mm_msec / times);
    Time _time = new Time(_divide);
    return _time;
  }
  
  public static Speed operator_divide(final Distance distance, final Time time) {
    double _mm = distance.getMm();
    double _ms = time.getMs();
    double _divide = (_mm / _ms);
    Speed _speed = new Speed(_divide);
    return _speed;
  }
  
  public Speed(final double mm_msec) {
    super();
    this._mm_msec = mm_msec;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (Double.doubleToLongBits(_mm_msec) ^ (Double.doubleToLongBits(_mm_msec) >>> 32));
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
    Speed other = (Speed) obj;
    if (Double.doubleToLongBits(other._mm_msec) != Double.doubleToLongBits(_mm_msec))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}

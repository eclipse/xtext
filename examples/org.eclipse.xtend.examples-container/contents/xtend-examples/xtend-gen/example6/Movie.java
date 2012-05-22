package example6;

import java.util.Set;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class Movie {
  private final String _title;
  
  public String getTitle() {
    return this._title;
  }
  
  private final String _year;
  
  public String getYear() {
    return this._year;
  }
  
  private final double _rating;
  
  public double getRating() {
    return this._rating;
  }
  
  private final int _numberOfVotes;
  
  public int getNumberOfVotes() {
    return this._numberOfVotes;
  }
  
  private final Set<String> _categories;
  
  public Set<String> getCategories() {
    return this._categories;
  }
  
  public Movie(final String title, final String year, final double rating, final int numberOfVotes, final Set<String> categories) {
    super();
    this._title = title;
    this._year = year;
    this._rating = rating;
    this._numberOfVotes = numberOfVotes;
    this._categories = categories;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_title== null) ? 0 : _title.hashCode());
    result = prime * result + ((_year== null) ? 0 : _year.hashCode());
    result = prime * result + (int) (Double.doubleToLongBits(_rating) ^ (Double.doubleToLongBits(_rating) >>> 32));
    result = prime * result + _numberOfVotes;
    result = prime * result + ((_categories== null) ? 0 : _categories.hashCode());
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
    Movie other = (Movie) obj;
    if (_title == null) {
      if (other._title != null)
        return false;
    } else if (!_title.equals(other._title))
      return false;
    if (_year == null) {
      if (other._year != null)
        return false;
    } else if (!_year.equals(other._year))
      return false;
    if (Double.doubleToLongBits(other._rating) != Double.doubleToLongBits(_rating))
      return false;
    if (other._numberOfVotes != _numberOfVotes)
      return false;
    if (_categories == null) {
      if (other._categories != null)
        return false;
    } else if (!_categories.equals(other._categories))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}

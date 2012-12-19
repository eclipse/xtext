package generator.xtend;

@SuppressWarnings("all")
public class Article {
  private String _title;
  
  public String getTitle() {
    return this._title;
  }
  
  public void setTitle(final String title) {
    this._title = title;
  }
  
  private boolean _article;
  
  public boolean isArticle() {
    return this._article;
  }
  
  public void setArticle(final boolean article) {
    this._article = article;
  }
  
  private String _href;
  
  public String getHref() {
    return this._href;
  }
  
  public void setHref(final String href) {
    this._href = href;
  }
  
  private String _img;
  
  public String getImg() {
    return this._img;
  }
  
  public void setImg(final String img) {
    this._img = img;
  }
  
  public void setArticle(final String aTitle) {
    this.setArticle(true);
    this.setTitle(aTitle);
  }
  
  public void setBlog(final String aTitle) {
    this.setArticle(false);
    this.setTitle(aTitle);
  }
}

package generator

class Examples extends AbstractWebsite {

  override path() {
    'examples.html'
  }
  
  override contents() '''
  <!--Container-->


  <div id="header_wrapper" class="container" >
           
  
  <div class="inner">
    
    <div class="container">
          
                    <div class="page-heading"><h1>Examples</h1></div>
    
    </div> <!-- /.container -->
    
  </div> <!-- /inner -->
  

        </div>
        
        <div id="page">  
            <div class="inner">
      <div  id="contact">
                <div id="sub_footer" class="container">
                    
                        <h2>Get in Touch and our Representative will get back to you within 24 hours</h2>
                  <hr/>
                        <div class="clearfix"></div>

                        <div class="span5">


                            <p>We want to hear from you! Just enter your name,<br> email address, and message into the form below and<br> send away.</p>


                            <form method="post" action="#" _lpchecked="1">
                                <fieldset>
                                    <div class="clearfix">
                                        <label for="name"><span>Name:</span></label>
                                        <div class="input">
                                            <input tabindex="1" size="18" class="span4" id="name" name="name" label="Name" type="text" value="">
                                        </div>
                                    </div>

                                    <div class="clearfix">
                                        <label for="email"><span>Email:</span></label>
                                        <div class="input">
                                            <input tabindex="2" size="25" id="email" class="span4" name="email" label="Email" type="text" value="">
                                        </div>
                                    </div>

                                    <div class="clearfix">
                                        <label for="message"><span>Message:</span></label>
                                        <div class="input">
                                            <textarea class="span4" tabindex="3" id="message" name="body" label="Message" rows="7"></textarea>
                                        </div>
                                    </div>

                                    <div class="actions">
                                        <input tabindex="3" type="submit" class="btn  btn-primary btn-large" value="Send message">
                                    </div>
                                </fieldset>
                            </form>


                        </div> 

                        <div class="span6">

                            <br>

                            <div class="span6">

                                <iframe width="500" height="200" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://www.google.com/maps?ie=UTF8&amp;ll=37.770715,-109.226074&amp;spn=13.793017,33.815918&amp;t=p&amp;z=6&amp;iwloc=A&amp;output=embed"></iframe>

                            </div>
                            <div class="span5">

                                <p>
                                    <strong>Address</strong> <br>
                                    123 Street Name, Suite # <br>
                                    City, State 12345, Country

                                    <br><br>
                                    <strong>Phone</strong><br>
                                    Phone: (123) 123-4567<br>
                                    Fax: (123) 123-4567<br>
                                    Toll Free: (800) 123-4567

                                </p>

                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore.</p>


                                
                            </div> 
                        </div>
                    </div>
                </div>
            </div>
        
        </div>
        </div>
  '''
  
}
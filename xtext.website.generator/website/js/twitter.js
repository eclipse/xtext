/**
 * remy sharp / http://remysharp.com
 * Twitter / @rem
 * http://remysharp.com/2007/05/18/add-twitter-to-your-blog-step-by-step/
 *
 * @params
 *   cssIdOfContainer: e.g. twitters
 *   options: 
 *       {
 *           id: {String} username,
 *           count: {Int} 1-20, defaults to 1 - max limit 200
 *           prefix: {String} '%name% said', defaults to blank
 *           clearContents: {Boolean} true, removes contents of element specified in cssIdOfContainer, defaults to true
 *           ignoreReplies: {Boolean}, skips over tweets starting with '@', defaults to false
 *           template: {String} HTML template to use for LI element (see URL above for examples), defaults to predefined template
 *           bigTemplate: {Boolean} bigger default template - similar to twitter's rendered view
 *           enableLinks: {Boolean} linkifies text, defaults to true,
 *           newwindow {Boolean} opens links in new window, defaults to false
 *           timeout: {Int} How long before triggering onTimeout, defaults to 10 seconds if onTimeout is set
 *           onTimeoutCancel: {Boolean} Completely cancel twitter call if timedout, defaults to false
 *           onTimeout: {Function} Function to run when the timeout occurs. Function is bound to element specified with 
 *           cssIdOfContainer (i.e. 'this' keyword)
 *           includeRT: {Boolean} Whether to include retweets, defaults to false
 *           callback: {Function} Callback function once the render is complete, doesn't fire on timeout
 *
 *      CURRENTLY DISABLED DUE TO CHANGE IN TWITTER API:
 *           withFriends: {Boolean} includes friend's status
 *
 *       }
 *
 * @license MIT (MIT-LICENSE.txt)
 * @version 1.13.3 - ify now supports lists
 * @date $Date: 2012/07/11 19:31:10 $
 */

// to protect variables from resetting if included more than once
if (typeof getTwitters !== 'function') (function () {

var twitterjs = {},
    guid = 0;

// https://github.com/ded/domready - cheers @ded
!function (context, doc) {
  var fns = [], ol, fn, f = false,
      testEl = doc.documentElement,
      hack = testEl.doScroll,
      domContentLoaded = 'DOMContentLoaded',
      addEventListener = 'addEventListener',
      onreadystatechange = 'onreadystatechange',
      loaded = /^loade|c/.test(doc.readyState);

  function flush(i) {
    loaded = 1;
    while (i = fns.shift()) { i() }
  }
  doc[addEventListener] && doc[addEventListener](domContentLoaded, fn = function () {
    doc.removeEventListener(domContentLoaded, fn, f);
    flush();
  }, f);


  hack && doc.attachEvent(onreadystatechange, (ol = function () {
    if (/^c/.test(doc.readyState)) {
      doc.detachEvent(onreadystatechange, ol);
      flush();
    }
  }));

  context['domReady'] = hack ?
    function (fn) {
      self != top ?
        loaded ? fn() : fns.push(fn) :
        function () {
          try {
            testEl.doScroll('left');
          } catch (e) {
            return setTimeout(function() { context['domReady'](fn) }, 50);
          }
          fn();
        }()
    } :
    function (fn) {
      loaded ? fn() : fns.push(fn);
    };

}(twitterjs, document);

window.getTwitters = function (target, id, count, options) {
  guid++;

  if (typeof id == 'object') {
    options = id;
    id = options.id;
    count = options.count;
  } 

  // defaulting options
  if (!count) count = 1;
  
  if (options) {
    options.count = count;
  } else {
    options = {};
  }
  
  if (!options.timeout && typeof options.onTimeout == 'function') {
    options.timeout = 10;
  }
  
  if (typeof options.clearContents == 'undefined') {
    options.clearContents = true;
  }
  
  // need to make these global since we can't pass in to the twitter callback
  options.twitterTarget = target;
  
  // default enable links
  if (typeof options.enableLinks == 'undefined') options.enableLinks = true;

  // check out the mad currying!
  twitterjs.domReady((function(options, guid) {
    return function () {
      function render(tweet) {
        var text = options.enableLinks ? twitterlib.ify.clean(twitterlib.expandLinks(tweet)) : twitterlib.expandLinks(tweet);
        
        var html = '<li>';
        
        if (options.prefix) {
          html += '<li><span className="twitterPrefix">';
          html += options.prefix.replace(/%(.*?)%/g, function (m, l) {
              return tweet.user[l];
          });
          html += ' </span></li>'; // space on purpose
        }
        
        html += '<span className="twitterStatus">' + twitterlib.time.relative(tweet.created_at) + '</span> ';
        html += '<span className="twitterTime">' + tweet.text + '</span>';
        
        if (options.newwindow) {
            html = html.replace(/<a href/gi, '<a target="_blank" href');
        }
        
        return html;
      }      
      
      function getTweets() {
        options.target = document.getElementById(options.twitterTarget);
        // if the element isn't on the DOM, don't bother
        if (!options.target) {
          return;
        }

        var tlOptions = {
          limit: count
        }

        if (options.includeRT) {
          tlOptions.rts = true;
        }

        if (options.timeout) {
          window['twitterTimeout' + guid] = setTimeout(function () {
            // cancel callback
            twitterlib.cancel(); // FIXME would be nice if we could be specific about which to cancel
            options.onTimeout.call(options.target);
          }, options.timeout * 1000);
        }
        
        // by default we list the user timeline
        var searchMethod = 'timeline';
        
        // if they pass a hashtag - run a search
        if (id.indexOf('#') === 0) searchMethod = 'search';
        
        // check for list, like: rem/family
        if (id.indexOf('/') !== -1) searchMethod = 'list';
        
        if (options.ignoreReplies) {
          tlOptions.filter = { not: new RegExp(/^@/) };
        }

        twitterlib.cache(true); // just to speed things up
        twitterlib[searchMethod](id, tlOptions, function (tweets, tlOptions) {
          clearTimeout(window['twitterTimeout' + guid]);
          var html = [],
              max = tweets.length > options.count ? options.count : tweets.length;

          html = ['<ul>'];

          for (var i = 0; i < max; i++) {
            // backward compatible hacks for old twitter.js
            tweets[i].time = twitterlib.time.relative(tweets[i].created_at);
            for (var key in tweets[i].user) {
                tweets[i]['user_' + key] = tweets[i].user[key];
            }
            
            if (options.template) {
              html.push('<li>' + options.template.replace(/%([a-z_\-\.]*)%/ig, function (m, l) {
                var r = tweets[i][l] + "" || "";
                if (l == 'text') r = twitterlib.expandLinks(tweets[i]);
                if (l == 'text' && options.enableLinks) r = twitterlib.ify.clean(r);
                return r;
              }) + '</li>');
            } else if (options.bigTemplate) {
              html.push(twitterlib.render(tweets[i]));
            } else {
              html.push(render(tweets[i]));
            }
          }

          html.push('</ul>');
          
          if (options.clearContents) {
            options.target.innerHTML = html.join('');            
          } else {
            options.target.innerHTML += html.join('');
          }
          
          options.callback && options.callback(tweets);
        });
      }
      
      
      // wait for twitterlib to be loaded
      if (typeof twitterlib === 'undefined') {
        // load twitterlib and then run init
        setTimeout(function () {
          var script = document.createElement('script');
          script.onload = script.onreadystatechange = function () {
            if (typeof window.twitterlib !== 'undefined') getTweets();
          };
          script.src = 'http://remy.github.com/twitterlib/twitterlib.js';

          var head = document.head || document.getElementsByTagName('head')[0];
          head.insertBefore(script, head.firstChild);
        }, 0);
      } else {
        getTweets();
      }
    };
  })(options, guid));
};

})();
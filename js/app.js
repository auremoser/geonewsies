$(document).ready(function() {
//add the guardian stuff:
    $.ajax({
        type: "GET",
        dataType: "jsonp",
        cache: false,
        url: "http://content.guardianapis.com/uk-news?show-fields=productionOffice&show-editors-picks=true&show-most-viewed=true&date-id=date%2Flast24hours&api-key=mediahackdays2014",
        success: function(json) {
            console.log(json);
            //unwrap the json object, they have a response object. DUMB!
            var data  = json.response,
                posts = [];
            //if our data has editorsPicks, add that to our posts:
            if(data.editorsPicks && data.editorsPicks.length){
                posts = posts.concat(data.editorsPicks);
            }
            //if our data has editorsPicks, add that to our posts:
            if(data.mostViewed && data.mostViewed.length){
                posts = posts.concat(data.mostViewed);
            }
            //create place holders for our HTML output
            var $content, $header, $date;
            //iterate over all editors picks,
            $.each(posts, function(i, post){
                console.log(post);
                //create the HTML containers, following the template provided.
                $content = $('<div class="small-offset-1 small-10 columns items">');
                $header = $('<h1 class="itemheadlinetext">');
                $date = $('<span class="metatext">');
                $header.html(post.webTitle);
                $date.html(post.webPublicationDate);
                $content.append($header).append($date);
                $('.media-container').append($content);
            });
        }
    });
});
$(document).ready(function() {
//add the guardian stuff:
    $.ajax({
        type: "GET",
        dataType: "jsonp",
        cache: false,
        url: "http://content.guardianapis.com/uk-news?show-fields=productionOffice&show-editors-picks=true&show-most-viewed=true&date-id=date%2Flast24hours&api-key=mediahackdays2014",
        success: function(json) {
            console.log(json);
            //unwrap the json object, have a response object. DUMB!
            var data  = json.response,
                posts = [];
            //if our data has editorsPicks, add that to our posts:
            if(data.editorsPicks && data.editorsPicks.length){
                posts = posts.concat(data.editorsPicks);
            }
            //if our data has mostViewed, add that to our posts:
            if(data.mostViewed && data.mostViewed.length){
                posts = posts.concat(data.mostViewed);
            }
            //create place holders for our HTML output
            var $content, $header, $date, $link;
            //iterate over all editors picks,
            $.each(posts, function(i, post){
                console.log(post);
                //create the HTML containers, following the template provided.
                $content = $('<div class="small-offset-1 small-10 columns items">');
                $link = $('<a>').html(post.webTitle).attr('href', post.webUrl).attr('target','_blank');
                $header = $('<h1 class="itemheadlinetext">');
                $date = $('<span class="metatext">');
                $header.html($link);
                $date.html(_formatDate(post.webPublicationDate));
                $content.append($header).append($date);
                $('.media-container').append($content);
            });
        }
    });
 
function _formatDate(str){
    var date = new Date(str),
        yyyy = date.getFullYear().toString();
        mm = (date.getMonth()+1).toString(); // getMonth() is zero-based
        dd  = date.getDate().toString();
    return (dd[1]?dd:"0"+dd[0]) + '/' + (mm[1]?mm:"0"+mm[0]) + '/' + yyyy;
}
});
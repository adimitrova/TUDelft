<?php
session_start();
require_once("C:\Users\Ani\Desktop\twitteroauth-master\twitteroauth\twitteroauth.php"); //Path to twitteroauth library
 
$twitteruser = "Ani_Dimitrova";
$notweets = 30;
$consumerkey = "FAKEVALUE";
$consumersecret = "FAKEVALUE";
$accesstoken = "FAKEVALUE";
$accesstokensecret = "FAKEVALUE";
 
function getConnectionWithAccessToken($cons_key, $cons_secret, $oauth_token, $oauth_token_secret) {
  $connection = new TwitterOAuth($cons_key, $cons_secret, $oauth_token, $oauth_token_secret);
  return $connection;
}
 
$connection = getConnectionWithAccessToken($consumerkey, $consumersecret, $accesstoken, $accesstokensecret);
 
$tweets = $connection->get("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=".$twitteruser."&count=".$notweets);
 
echo json_encode($tweets);
?>
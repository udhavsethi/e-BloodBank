<?php
	$db=mysql_connect("mysql12.000webhost.com", "a4941454_foo", "pass988312407");
	if(!$db)
	{
		die("Database connection failed: " . mysql_error());
	}
	$db_select = mysql_select_db("a4941454_foo");
	if(!$db_select)
	{
		die("Database selection failed: " . mysql_error());
	}
?>

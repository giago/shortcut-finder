<%if (request.getServerName().contains(".com") && !request.getServerName().contains(".latest")) {%>
	<div class="sc-right">
	<script type="text/javascript"><!--
	google_ad_client = "pub-2374318088795044";
	/* 160x600, created 4/5/10 */
	google_ad_slot = "3066583883";
	google_ad_width = 160;
	google_ad_height = 600;
	//-->
	</script>
	<script type="text/javascript"
	src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
	</script>
	</div>
<%} else {%>
	<div class="sc-right" style="width: 160px; height: 600px; border: 1px green solid;">space for google ads</div>	
<%}%>
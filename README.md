
# ucsb-cs56-goodsleepalarm
gives users sleep suggestions based on schedule...

=======

https://cs56-goodsleepalarm.herokuapp.com/

Setting up Google Credentials

1) Open the Google API Console Credentials page : https://console.developers.google.com/apis/dashboard

2) From the project drop-down, choose Create a new project, enter a name for the project, and optionally, edit the provided      project ID. Click Create.

3) On the Credentials page, select Create credentials, then select OAuth client ID.

4) You may be prompted to set a product name on the Consent screen; if so, click Configure consent screen, supply the requested information including adding cs56-goodsleepalarm.herokuapp.com to the authorized domains, and click Save to return to the Credentials screen.

5) Select Web application for the Application type, enter the application name. Then in the redirect urls, add all of the following: http://localhost:8080/login	
  https://cs56-goodsleepalarm.herokuapp.com	
  https://cs56-goodsleepalarm.herokuapp.com/login	
  http://cs56-goodsleepalarm.herokuapp.com/login	
  http://cs56-goodsleepalarm.herokuapp.com.
 Then click create.

6) On the page that appears, copy the client ID and client secret to your clipboard, as you will need them when you configure your client library.

Using Google Credentials
1. To use your Google credentials for localhost / heroku, copy localhost / heroku.json.SAMPLE to localhost / heroku.json at the project root
2. Modify localhost / heroku.json by putting in your client id and client secret where indicated
3. For heroku, run `./setHerokuEnv.py --app cs56-goodsleepalarm` ; For localhost run . env.sh from the root
4. Finally deploy / run the webapp with `mvn spring-boot:run` or `mvn package heroku:deploy`
